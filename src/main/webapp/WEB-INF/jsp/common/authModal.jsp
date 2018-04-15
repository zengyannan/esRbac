<!--添加权限模态框-->
<div class="modal fade" id="auth_add_modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 id="auth_add_modal_title" class="modal-title">添加权限</h4>
            </div>
            <div class="modal-body">
                <form id="auth_add_modal_form">
                    <div class="form-group">
                        <label  class="control-label">权限名</label>
                        <input type="text" class="form-control"  name="name" required>
                    </div>
                    <div class="form-group">
                        <label class="control-label">控制器名</label>
                        <input class="form-control"  name="authC" required />
                    </div>
                    <div class="form-group">
                        <label class="control-label">操作名</label>
                        <input class="form-control" name="authA" required />
                    </div>
                    <div  class="form-group">
                        <label class="control-label">父级权限</label>
                        <select  name="pid" class="form-control">

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
                <button id="auth_add_modal_saveButton" type="button" class="btn btn-primary">保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>


<!--修改权限模态框-->
<div class="modal fade" id="auth_edit_modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 id="auth_edit_modal_title" class="modal-title">修改权限</h4>
            </div>
            <div class="modal-body">
                <form id="auth_edit_modal_form">
                    <div class="form-group">
                    <input type="hidden" class="form-control"  name="id">
                    </div>
                    <div class="form-group">
                        <label  class="control-label">权限名</label>
                        <input type="text" class="form-control"  name="name" required>
                    </div>
                    <div class="form-group">
                        <label class="control-label">控制器名</label>
                        <input class="form-control"  name="authC" required />
                    </div>
                    <div class="form-group">
                        <label class="control-label">操作名</label>
                        <input class="form-control" name="authA" required />
                    </div>
                    <div  class="form-group">
                        <label class="control-label">父级权限</label>
                        <select  name="pid" class="form-control">

                        </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="auth_edit_modal_saveButton" type="button" class="btn btn-primary">保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

<!--提示框-->
<div class="modal fade" id="auth_message_modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 id="auth_message_modal_title" class="modal-title">提示</h4>
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
<div class="modal fade" id="auth_confirm_modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 id="auth_confirm_modal_title" class="modal-title">提示</h4>
            </div>
            <div class="modal-body">
                <span class="text-center"></span>
            </div>
            <div class="modal-footer">
                <button id="auth_confirm_modal_confirmButton" type="button" class="btn btn-primary">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>

