/**
 * Created by Ng on 2017/4/26.
 */
var role=(function () {
    var DOM={
        role_add_modal:$('#role_add_modal'),
        role_chooseAuth_modal:$('#role_chooseAuth_modal'),
        role_message_modal:$('#role_message_modal'),
        role_confirm_modal:$('#role_confirm_modal')
    };
    //拼接权限HTML语句
    var splitAuth=function (node,html) {
        html+="<div style='margin-left: 30px'><input value='"+node.authId+"' name='add_auth_ids[]' class='auth_node' data-auth-pid='"+node.authPid+"' data-auth-id='"+node.authId+"' type='checkbox'/><span>"+node.authName+"</span>";
        if(node.children!=null){
            $.each(node.children,function (i,item) {
                html=splitAuth(item,html);
            });
        }
        html+="</div>";
        return html;
    }
    //权限父子联动
    var checkedInteraction= function (check) {
        if(check.prop('checked')==true){
            var auth_pid=check.data('auth-pid');
            if(auth_pid!=undefined){
                var parent =check.parent().parent().find('>input');
                if(auth_pid==parent.data('auth-id')){
                    parent.prop('checked',true);
                    if(parent.data('auth-pid')!=undefined){
                        checkedInteraction(parent);
                    }
                }
            }
        }else if(check.prop('checked')==false){
            var brothers=check.nextAll('div');
            if(brothers!=null){
                $.each(brothers,function (i,brother) {
                    $(brother).find('input').prop('checked',false);
                });
            }
        }
    }

    var validateRole = function (form) {
        var result =true;
        if(form.name==null && form.name == undefined || form.name.length==0){
            // DOM.role_message_modal.modal({backdrop:'static'});
            // $('#role_message_modal_title').html('提示');
            // DOM.role_message_modal.find('.modal-body span').html('角色名不能为空');
            // setTimeout(function () {
            //     DOM.role_message_modal.modal('hide');
            // },3000);
            alert('角色名不能为空');
            return false;
        }
        if(form.authIds==null && form.authIds == undefined || form.authIds.length==0){
            // DOM.role_message_modal.modal({backdrop:'static'});
            // $('#role_message_modal_title').html('提示');
            // DOM.role_message_modal.find('.modal-body span').html('权限不能为空');
            alert('权限不能为空');
            return false;
        }
        return result;
    }

    var eventHandler =function () {
        return function () {
            var modal_state;
            //绑定弹出添加用户模态框按钮事件
            $('#role_list_add_btn').on('click',function () {
                modal_state="add";
                DOM.role_add_modal.modal({ keyboard: false,backdrop:'static'});
                $('#role_add_modal_title').html("添加角色");
                //DOM.role_add_modal.modal('show');
            });
            //绑定添加用户的保存按钮事件
            $('#role_add_modal_saveButton').on('click',function () {
               var role_add_modal_form=$('#role_add_modal_form').serializeObject();
               var result = validateRole(role_add_modal_form);
                if(result){
                    $.post('/role/add',role_add_modal_form,function (r) {
                        if(r.success){
                            DOM.role_message_modal.modal({backdrop:'static'});
                            $('#role_message_modal_title').html('提示');
                            DOM.role_message_modal.find('.modal-body span').html('添加成功');
                            DOM.role_add_modal.modal('hide');
                            setTimeout(function () {
                                DOM.role_message_modal.modal('hide');
                                location.reload();
                            },3000);
                        }
                    });
                }
            });
            //绑定选择权限模态框按钮事件
            $('.role_modal_chooseAuth').on('click',function () {
                $.get('/auth/getAuthTree',function (r) {
                    var html="";
                    if(r.success){
                        if(r.data!=null){
                            var root = r.data;
                            html=splitAuth(root,html);
                            //console.log(html);
                        }
                        DOM.role_chooseAuth_modal.modal({ keyboard: false,backdrop:'static'});
                        $('#role_chooseAuth_modal_title').html("选择权限");
                        $('#role_chooseAuth_modal_body').html(html);
                        DOM.role_chooseAuth_modal.modal('show');
                    }else{
                        alert("获取数据失败");
                    }
                });
            });
            //绑定选择权限触发的父子联动事件
            $('#role_chooseAuth_modal_body').on('click','input',function () {
                checkedInteraction($(this));
            });
            //绑定选择权限模态框 确定按钮事件
            $('#role_chooseAuth_modal_button').on('click',function () {
                var auth_ids='';
               $('#role_chooseAuth_modal_body input[name="add_auth_ids[]"]:checked').each(function (i,val) {
                   auth_ids+=$(val).val()+',';
               });
                auth_ids=auth_ids.substring(0,auth_ids.length-1);
                if(modal_state=="add"){
                    $('#role_add_modal :input[name="authIds"]').val(auth_ids);
                }else if(modal_state=="edit"){
                    $('#role_edit_modal :input[name="authIds"]').val(auth_ids);
                }
                $('#role_chooseAuth_modal').modal('hide');
            });
            //绑定弹出编辑角色的模态框时间
            $('.role_edit_btn').on('click',function () {
                modal_state="edit";
                var id=$(this).data('role-id');
                var name=$(this).data('role-name');
                var auth_ids=$(this).data('role-auth-ids');
                $('#role_edit_modal_form input[name="id"]').val(id);
                $('#role_edit_modal_form input[name="name"]').val(name);
                $('#role_edit_modal_form input[name="authIds"]').val(auth_ids);
                $('#role_edit_modal').modal('show');
            });
            //绑定修改角色 保存按钮事件
            $('#role_edit_modal_saveButton').on('click',function () {
                var role_edit_modal_form=$('#role_edit_modal_form').serializeObject();
                var result = validateRole(role_edit_modal_form);
                if(result){
                    $.post('/role/edit',role_edit_modal_form,function (r) {
                        if(r.success){
                            DOM.role_message_modal.modal({backdrop:'static'});
                            $('#role_message_modal_title').html('提示');
                            DOM.role_message_modal.find('.modal-body span').html('修改成功');
                            $('#role_edit_modal').modal('hide');
                            setTimeout(function () {
                                DOM.role_message_modal.modal('hide');
                                location.reload();
                            },3000);
                        }
                    });
                }
            });
            //弹出删除确认框
            var role_id;
            $('.role_delete_btn').on('click',function () {
                role_id=$(this).data('role-id');
                $('#role_confirm_modal_title').html('提示');
                DOM.role_confirm_modal.find('.modal-body span').html('是否删除该用户？');
                DOM.role_confirm_modal.modal('show');
            });
            //绑定点击确定删除按钮的事件操作
            $('#role_confirm_modal_confirmButton').on('click',function () {
                $.post('/role/delete',{roleId:role_id},function (r) {
                    if(r.success){
                        DOM.role_confirm_modal.modal('hide');
                        DOM.role_message_modal.find('.modal-body span').html('删除成功');
                        $('#role_message_modal_title').html('提示');
                        DOM.role_message_modal.modal('show');
                        setTimeout(function () {
                            DOM.role_message_modal.modal('hide');
                            location.reload();
                        },3000);
                    }else{
                        //DOM.role_confirm_modal.modal('hide');
                        $('#role_message_modal_title').html('提示');
                        DOM.role_message_modal.find('.modal-body span').html(r.error);
                        DOM.role_message_modal.modal('show');
                        setTimeout(function () {
                            DOM.role_message_modal.modal('hide');
                        },3000)
                    }
                })
            });
            $('.role_update_state_btn').on('click',function () {
                var role_id=$(this).data('role-id');
                var role_state=$(this).data('role-state');
                $.post('/role/updateState',{roleId:role_id,roleState:role_state},function (r) {
                    if(r.success){
                        location.reload();
                    }else {
                        alert('修改失败');
                    }
                })
            });
        }
    }
    return {eventHandler:eventHandler()}
})();
function main() {
    role.eventHandler();
}
main();