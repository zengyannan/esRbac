<!--添加用户模态框-->
<div class="modal fade" id="admin_add_modal" tabindex="-1" role="dialog" >
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 id="admin_add_modal_title" class="modal-title">添加用户</h4>
            </div>
            <div class="modal-body">
                <form id="admin_add_modal_form">
                    <div class="form-group">
                        <input type="hidden" class="form-control"  name="id">
                    </div>
                    <div class="form-group">
                        <label  class="control-label">用户名</label>
                        <input type="text" class="form-control"  name="name" required>
                    </div>
                    <div id="admin-add-name-alert" class="alert alert-warning" style="display: none">
                        <span></span>
                    </div>
                    <div class="form-group">
                        <label class="control-label">密码:</label>
                        <input class="form-control" type="password"   name="password" required />
                    </div>
                    <div id="admin-add-password-alert" class="alert alert-warning" style="display: none">
                        <span></span>
                    </div>
                    <div class="form-group">
                        <label  class="control-label">确认密码:</label>
                        <input class="form-control" name="confirmPassword"  type="password" />
                    </div>
                    <div id="admin-add-confirmPassword-alert" class="alert alert-warning" style="display: none">
                        <span></span>
                    </div>
                    <div class="form-group">
                        <label  class="control-label">昵称:</label>
                        <input class="form-control"  name="nickname" />
                    </div>
                    <div id="admin-add-nickname-alert" class="alert alert-warning" style="display: none">
                        <span></span>
                    </div>
                    <div class="form-group">
                        <label  class="control-label">电子邮箱:</label>
                        <input class="form-control" name="email" />
                    </div>
                    <div id="admin-add-email-alert" class="alert alert-warning" style="display: none">
                        <span></span>
                    </div>
                    <div class="form-group">
                        <label  class="control-label">手机:</label>
                        <input class="form-control" name="tel" />
                    </div>
                    <div id="admin-add-tel-alert" class="alert alert-warning" style="display: none">
                        <span></span>
                    </div>
                    <div  class="form-group">
                        <select  name="roleId" class="form-control">

                        </select>
                    </div>
                    <div  class="form-group">
                        <select  name="state" class="form-control">
                            <option value="1">启用</option>
                            <option value="0">不启用</option>
                        </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="admin_add_modal_saveButton" type="button" class="btn btn-primary">保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>


<!--修改用户模态框-->
<div class="modal fade" id="admin_edit_modal" tabindex="-1" role="dialog" >
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 id="admin_edit_modal_title" class="modal-title">修改用户</h4>
            </div>
            <div class="modal-body">
                <form id="admin_edit_modal_form">

                </form>
            </div>
            <div class="modal-footer">
                <button id="admin_edit_modal_saveButton" type="button" class="btn btn-primary">保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

<!--提示框-->
<div class="modal fade" id="admin_message_modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 id="admin_message_modal_title" class="modal-title">提示</h4>
            </div>
            <div class="modal-body">
                <span class="text-center"></span>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>
<!--确认框-->
<div class="modal fade" id="admin_confirm_modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 id="admin_confirm_modal_title" class="modal-title">提示</h4>
            </div>
            <div class="modal-body">
                <span class="text-center"></span>
            </div>
            <div class="modal-footer">
                <button id="admin_confirm_modal_confirmButton" type="button" class="btn btn-primary">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>

