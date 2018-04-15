/**
 * Created by Ng on 2017/4/21.
 */
var admin =(function () {

    var DOM={admin_message_modal:$('#admin_message_modal'),admin_confirm_modal:$('#admin_confirm_modal')};

    //验证用户信息提交是否规范
    var validator = function (form,prefix,message) {
        var flag=true;
        var namePatt = new RegExp(message.name.regex);
        if(form.name==null ||form.name ==undefined || form.name.length==0){
            $('#'+prefix+'-name-alert span').html(message.name.required);
            $('#'+prefix+'-name-alert').toggle();
            setTimeout(function () {
                $('#'+prefix+'-name-alert').toggle();
            },5000);
            flag=false;
        }else if(!namePatt.test(form.name)){
            $('#'+prefix+'-name-alert span').html(message.name.alert);
            $('#'+prefix+'-name-alert').toggle();
            setTimeout(function () {
                $('#'+prefix+'-name-alert').toggle();
            },5000);
            flag=false;
        }
        var pwdPatt = new RegExp(message.password.regex);
        if(form.password==null ||form.password ==undefined ||
            form.password.length==0){
            $('#'+prefix+'-password-alert span').html
            (message.password.required);
            $('#'+prefix+'-password-alert').toggle();
            setTimeout(function () {
                $('#'+prefix+'-password-alert').toggle();
            },5000);
            flag=false;
        }else if(!pwdPatt.test(form.password)){
            $('#'+prefix+'-password-alert span').html
            (message.password.alert);
            $('#'+prefix+'-password-alert').toggle();
            setTimeout(function () {
                $('#'+prefix+'-password-alert').toggle();
            },5000);
            flag=false;
        }
        if(form.confirmPassword!=null || form.confirmPassword !=undefined){
            if(form.password!=form.confirmPassword){
                $('#'+prefix+'-confirmPassword-alert span').html
                (message.password.confirm);
                $('#'+prefix+'-confirmPassword-alert').toggle();
                setTimeout(function () {
                    $('#'+prefix+'-confirmPassword-alert').toggle();
                },5000);
                flag=false;
        }
        }
        var nickNamePatt= new RegExp(message.nickname.regex);
        if(form.nickname==null ||form.nickname ==undefined ||
            form.nickname.length==0){
            $('#'+prefix+'-nickname-alert span').html
            (message.nickname.required);
            $('#'+prefix+'-nickname-alert').toggle();
            setTimeout(function () {
                $('#'+prefix+'-nickname-alert').toggle();
            },5000);
            flag=false;
        }
        else if(nickNamePatt.test(form.nickname)){
            $('#'+prefix+'-nickname-alert span').html
            (message.nickname.alert);
            $('#'+prefix+'-nickname-alert').toggle();
            setTimeout(function () {
                $('#'+prefix+'-nickname-alert').toggle();
            },5000);
            flag=false;
        }
        var emailPatt= new RegExp(message.email.regex);
        if(form.email==null ||form.email ==undefined || form.email.length==0){
            $('#'+prefix+'-email-alert span').html(message.email.required);
            $('#'+prefix+'-email-alert').toggle();
            setTimeout(function () {
                $('#'+prefix+'-email-alert').toggle();
            },5000);
            flag=false;
        }
        else if(!emailPatt.test(form.email)){
            $('#'+prefix+'-email-alert span').html(message.email.alert);
            $('#'+prefix+'-email-alert').toggle();
            setTimeout(function () {
                $('#'+prefix+'-email-alert').toggle();
            },5000);
            flag=false;
        }
        var telPatt =new RegExp(message.tel.regex);
        if(form.tel==null ||form.tel ==undefined || form.tel.length==0){
            $('#'+prefix+'-tel-alert span').html(message.tel.required);
            $('#'+prefix+'-tel-alert').toggle();
            setTimeout(function () {
                $('#'+prefix+'-tel-alert').toggle();
            },5000);
            flag=false;
        }
        else if(!telPatt.test(form.tel)){
            $('#'+prefix+'-tel-alert span').html(message.tel.alert);
            $('#'+prefix+'-tel-alert').toggle();
            setTimeout(function () {
                $('#'+prefix+'-tel-alert').toggle();
            },5000);
            flag=false;
        }
        return flag;
    }
    var eventHandler =function () {
        var admin_add_modal=$('#admin_add_modal');
        var admin_add_modal_form =$('#admin_add_modal_form');
        var admin_edit_modal=$('#admin_edit_modal');
        var admin_edit_form=$('#admin_edit_modal_form');
        return function () {
            //绑定打开添加用户模态框的按钮事件
            $('#admin_list_add_btn').on('click',function () {
                $.get('/role/getAllRole',function (r) {
                    var html='';
                    var p='';
                    if(r.success){
                        $.each(r.data,function (index,v) {
                            p='<option value="'+v.roleId+'">'+v.roleName+'</option>';
                            html+=p;
                        });
                        $('#admin_add_modal_form :input[name="roleId"]').html(html);
                    admin_add_modal.modal({ keyboard: false,backdrop:'static'});
                    $('#admin_add_modal_title').html("添加用户");
                    admin_add_modal.modal('show');
                    }else {
                        alert('拉取数据失败');
                    }
                });
            });

            //添加用户
            $('#admin_add_modal_saveButton').on('click',function () {
                var message ={
                    name:{required:"用户名不能为空",alert:"用户名长度为4-15位,字母或数字或_",regex:/^[a-zA-Z0-9_]{4,15}$/},
                    password:{required:"密码不能为空",alert:"密码长度为5-17且只能为字母和数字",confirm:"两次密码不一致",regex:/^[A-Za-z0-9]{5,17}$/},
                    nickname:{required:"昵称不能为空",alert:"含有非法字符",regex:/[@#\$%\^&\*]+/g},
                    email:{required:"邮箱不能为空",alert:"邮箱不符合格式",regex:/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/},
                    tel:{required:"手机号不能为空",alert:"不是完整的11位手机号",regex:/^1[3|4|5|8][0-9]\d{8}$/}
                }
                var flag = admin.validator(admin_add_modal_form.serializeObject(),'admin-add',message);
                if(flag){
                    $.post('/admin/add',admin_add_modal_form.serialize(),function (r) {
                        if(r.success){
                            admin_add_modal.modal('hide');
                            DOM.admin_message_modal.find('.modal-body span').html('添加成功');
                            DOM.admin_message_modal.modal('show');
                            setTimeout(function () {
                                DOM.admin_message_modal.modal('hide');
                                location.reload();
                            },3000);
                        }else{
                            // alert(r.error);
                            admin_add_modal.modal('show');
                            DOM.admin_message_modal.find('.modal-body span').html(r.error);
                            DOM.admin_message_modal.modal('show');
                            setTimeout(function () {
                                DOM.admin_message_modal.modal('hide');
                            },3000);
                        }
                    },'json');
                }
            });
            //绑定打开修改模态框的按钮事件
            $('.admin_edit_btn').on('click',function () {
                var arr=$(this).parent().parent('tr').children();
                var i;
                var attrs=new Array(
                    {name:'id'},
                    {name:'name',title:'用户名',alertId:'admin-edit-name-alert'},
                    {name:'nickname',title:'昵称',alertId:'admin-edit-nickname-alert'},
                    {name:'password',title:'密码',alertId:'admin-edit-password-alert'},
                    {},{},
                    {name:'email',title:'电子邮箱',alertId:'admin-edit-email-alert'},
                    {name:'tel',title:'手机',alertId:"admin-edit-tel-alert"}
                );
                var html="";
                var p="";
                for(i=0;i<arr.length-4;i++){
                    if(i==4 || i==5){
                        continue;
                    }
                    var val=arr[i].innerHTML;
                    if(i==0){
                        p='<div class="form-group">' +
                            '<input type="hidden" ' +
                            'class="form-control"  ' +
                            'name="id" value="'+val+'"> ' +
                            '</div>';
                    }else{
                        p='<div class="form-group"> ' +
                            '<label  class="control-label">'+attrs[i].title+'</label> ' +
                            '<input type="text" class="form-control"  name="'+attrs[i].name+'" value="'+val+'"> ' +
                            '</div> ' +
                            '<div id="'+attrs[i].alertId+'" class="alert alert-warning" style="display: none"> ' +
                            '<span></span> ' +
                            '</div>';
                    }
                    html+=p;
                }
                // html+='<div  name="state" class="form-group"> ' +
                //     '<select  name="state" class="form-control">';
                //     if(arr[8].innerHTML==1){
                //         html+='<option value="1">启用</option>'
                //     }else{
                //         html+='<option value="0">不启用</option>'
                //     }
                //   if(arr[8].innerHTML!=1){
                //     html+='<option value="1">启用</option>'
                //   }else{
                //     html+='<option value="0">不启用</option>'
                //   }
                // html+='</select></div>';
                var roleName=arr[9].innerHTML;
                html+="<div class='form-group'><select name='roleId' class='form-control'>"
                $.get("/role/getAllRole",function (r) {
                    if(r.success){
                        $.each(r.data,function (index,v,arr) {
                            if(roleName==v.roleName){
                                p='<option value="'+v.roleId+'" selected>'+v.roleName+'</option>'
                            }else{
                                p='<option value="'+v.roleId+'">'+v.roleName+'</option>'
                            }
                            html+=p;
                        });
                        html+="</select></div>";
                        admin_edit_modal.modal({ keyboard: false,backdrop:'static'});
                        $('#admin_edit_modal_title').html("修改用户");
                        admin_edit_form.html(html);
                        admin_edit_modal.modal('show');
                    }
                });
            });
            $('#admin_edit_modal_saveButton').on('click',function () {
                var message ={
                    name:{required:"用户名不能为空",alert:"用户名长度为4-15位,字母或数字或_",regex:/^[a-zA-Z0-9_]{4,15}$/},
                    password:{required:"密码不能为空",alert:"密码长度为5-17且只能为字母和数字",confirm:"两次密码不一致",regex:/^[A-Za-z0-9]{5,17}$/},
                    nickname:{required:"昵称不能为空",alert:"含有非法字符",regex:/[@#\$%\^&\*]+/g},
                    email:{required:"邮箱不能为空",alert:"邮箱不符合格式",regex:/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/},
                    tel:{required:"手机号不能为空",alert:"不是完整的11位手机号",regex:/^1[3|4|5|8][0-9]\d{8}$/}
                }
                var flag = admin.validator(admin_edit_form.serializeObject(),'admin-edit',message);
                if(flag) {
                    $.post('/admin/edit', admin_edit_form.serialize(), function (r) {
                        if (r.success) {
                            admin_edit_modal.modal('hide');
                            DOM.admin_message_modal.find('.modal-body span').html('修改成功');
                            DOM.admin_message_modal.modal('show');
                            setTimeout(function () {
                                DOM.admin_message_modal.modal('hide');
                                location.reload();
                            }, 3000);
                        } else {
                            admin_edit_modal.modal('hide');
                            DOM.admin_message_modal.find('.modal-body span').html(r.error);
                            DOM.admin_message_modal.modal('show');
                            setTimeout(function () {
                                DOM.admin_message_modal.modal('hide');
                            }, 3000);
                        }
                    })
                }
            });

            //绑定删除按钮事件
            var adminId;
            $('.admin_delete_btn').on('click',function () {
                   adminId = $(this).data('admin-id');
                   console.log('admin:'+adminId);
                   $('#admin_confirm_modal_title').html('提示');
                   DOM.admin_confirm_modal.find('.modal-body span').html('是否删除该用户？');
                   DOM.admin_confirm_modal.modal('show');
            });
            //删除按钮操作
            $('#admin_confirm_modal_confirmButton').on('click',function () {
                $.post('/admin/delete',{adminId:adminId},function (r) {
                    if(r.success){
                        DOM.admin_confirm_modal.modal('hide');
                        DOM.admin_message_modal.find('.modal-body span').html("删除成功");
                        DOM.admin_message_modal.modal('show');
                        setTimeout(function () {
                            DOM.admin_message_modal.modal('hide');
                            location.reload();
                        },3000);
                    }else{
                        DOM.admin_confirm_modal.modal('hide');
                        DOM.admin_message_modal.find('.modal-body span').html(r.error);
                        DOM.admin_message_modal.modal('show');
                        setTimeout(function () {
                            DOM.admin_message_modal.modal('hide');
                        },3000)
                    }
                },'json');
            });
            $('.admin_update_state_btn').on('click',function () {
                var admin_id=$(this).data('admin-id');
                var admin_state=$(this).data('admin-state');
                $.post('/admin/updateState',{adminId:admin_id,adminState:admin_state},function (r) {
                    if(r.success){
                        location.reload();
                    }else {
                        alert('修改失败');
                    }
                })
            });
        }
    }
    return {eventHandler:eventHandler(),validator:validator};
})();
function main() {
    admin.eventHandler();
}
main();