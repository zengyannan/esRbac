/**
 * Created by Ng on 2017/4/30.
 */
var auth =(function () {
    var DOM={
        auth_add_modal:$('#auth_add_modal'),
        auth_edit_modal:$('#auth_edit_modal'),
        auth_message_modal:$('#auth_message_modal'),
        auth_confirm_modal:$('#auth_confirm_modal')
    }
    var eventHandler =function () {
        return function () {
            //弹出添加权限的模态框 按钮事件绑定
            $('#auth_list_add_btn').on('click',function () {
                $.get('/auth/getAllAuth',function (r) {
                    var html='';
                    var p='';
                    if(r.success){
                        $.each(r.data,function (index,v) {
                            p='<option value="'+v.authId+'">'+v.authName+'</option>';
                            html+=p;
                        });
                        $('#auth_add_modal_form :input[name="pid"]').html(html);
                        DOM.auth_add_modal.modal({ keyboard: false,backdrop:'static'});
                    }else {
                        alert('拉取数据失败');
                    }
                });
            });
            $('#auth_add_modal_saveButton').on('click',function () {
                var auth_add_modal_form =$('#auth_add_modal_form').serializeObject();
                if(auth_add_modal_form.name==null || auth_add_modal_form.name==undefined || auth_add_modal_form.name.length==0){
                    alert('名字不能为空');
                }else{
                    $.post('/auth/add',auth_add_modal_form,function (r) {
                        if(r.success){
                            DOM.auth_message_modal.find('.modal-body span').html("添加成功");
                            DOM.auth_add_modal.modal('hide');
                            DOM.auth_message_modal.modal('show');
                            setTimeout(function () {
                                DOM.auth_message_modal.modal('hide');
                                location.reload();
                            },3000);
                        }else{
                            alert('添加失败');
                        }
                    });
                }
            });
            //绑定打开修改权限的模态框的按钮事件
            $('.auth_edit_btn').on('click',function () {
                var auth_id = $(this).data('auth-id');
                var auth_pid = $(this).data('auth-pid');
                var auth_name = $(this).data('auth-name');
                var auth_c = $(this).data('auth-c');
                var auth_a = $(this).data('auth-a');
                $.get('/auth/getAllAuth',function (r) {
                    var html='';
                    var p='';
                    if(r.success){
                        $.each(r.data,function (index,v) {
                            if(auth_pid==v.authId){
                                p='<option selected value="'+v.authId+'">'+v.authName+'</option>';
                            }else {
                                p='<option value="'+v.authId+'">'+v.authName+'</option>';
                            }
                            html+=p;
                        });
                        $('#auth_edit_modal_form :input[name="pid"]').html(html);
                        $('#auth_edit_modal_form :input[name="id"]').val(auth_id);
                        $('#auth_edit_modal_form :input[name="name"]').val(auth_name);
                        $('#auth_edit_modal_form :input[name="authC"]').val(auth_c);
                        $('#auth_edit_modal_form :input[name="authA"]').val(auth_a);
                        DOM.auth_edit_modal.modal({ keyboard: false,backdrop:'static'});
                    }else {
                        alert('拉取数据失败');
                    }
                });
            });
            //绑定修改模态框保存按钮事件
            $('#auth_edit_modal_saveButton').on('click',function () {
                var auth_edit_modal_form =$('#auth_edit_modal_form').serializeObject();
                $.post('/auth/edit',auth_edit_modal_form,function (r) {
                    if(r.success){
                        DOM.auth_message_modal.find('.modal-body span').html("修改成功");
                        DOM.auth_edit_modal.modal('hide');
                        DOM.auth_message_modal.modal('show');
                        setTimeout(function () {
                            DOM.auth_message_modal.modal('hide');
                            location.reload();
                        },3000);
                    }else{
                        alert('修改失败');
                    }
                })
            });
            var auth_id;
            //绑定弹出删除确定模态框事件
            $('.auth_delete_btn').on('click',function () {
                auth_id=$(this).data('auth-id');
                DOM.auth_confirm_modal.find('.modal-body span').html('是否删除该用户？');
                DOM.auth_confirm_modal.modal({ keyboard: false,backdrop:'static'});
            });
            $('#auth_confirm_modal_confirmButton').on('click',function () {
                $.post('/auth/delete',{authId:auth_id},function (r) {
                   if(r.success){
                       DOM.auth_message_modal.find('.modal-body span').html("删除成功");
                       DOM.auth_confirm_modal.modal('hide');
                       DOM.auth_message_modal.modal('show');
                       setTimeout(function () {
                           DOM.auth_message_modal.modal('hide');
                           location.reload();
                       },3000);
                   }else{
                       alert('删除失败');
                   }
                });
            });
            $('.auth_update_state_btn').on('click',function () {
                var auth_id=$(this).data('auth-id');
                var auth_state=$(this).data('auth-state');
                $.post('/auth/updateState',{authId:auth_id,authState:auth_state},function (r) {
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
    auth.eventHandler();
}
main();
