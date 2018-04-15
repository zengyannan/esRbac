<!--添加角色模态框-->
<div class="modal fade" id="role_add_modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 id="role_add_modal_title" class="modal-title">添加角色</h4>
            </div>
            <div class="modal-body">
                <form id="role_add_modal_form">
                    <div class="form-group">
                        <label class="control-label">名字:</label>
                        <input class="form-control"  name="name" />
                    </div>
                    <div class="form-group">
                        <label class="control-label">选择权限:</label>
                            <div class="role_modal_chooseAuth">
                                <input class="form-control" readonly="true"  name="authIds"/>
                            </div>
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
                <button id="role_add_modal_saveButton" type="button" class="btn btn-primary">保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

<!--修改角色模态框-->
<div class="modal fade" id="role_edit_modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 id="role_edit_modal_title" class="modal-title">修改角色</h4>
            </div>
            <div class="modal-body">
                <form id="role_edit_modal_form">
                    <div>
                        <input class="form-control" type="hidden"  name="id" />
                    </div>
                    <div class="form-group">
                        <label class="control-label">名字:</label>
                        <input class="form-control"  name="name" />
                    </div>
                    <div class="form-group">
                        <label class="control-label">选择权限:</label>
                        <div class="role_modal_chooseAuth">
                            <input class="form-control"  readonly="true" name="authIds"/>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="role_edit_modal_saveButton" type="button" class="btn btn-primary">保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

<!--提示框-->
<div class="modal fade" id="role_message_modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 id="role_message_modal_title" class="modal-title">提示</h4>
            </div>
            <div class="modal-body">
                <span class="text-center"></span>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>
<!--删除确认框-->
<div class="modal fade" id="role_confirm_modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 id="role_confirm_modal_title" class="modal-title">提示</h4>
            </div>
            <div class="modal-body">
                <span class="text-center"></span>
            </div>
            <div class="modal-footer">
                <button id="role_confirm_modal_confirmButton" type="button" class="btn btn-primary">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<!--选择权限模态框-->
<div class="modal fade" id="role_chooseAuth_modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 id="role_chooseAuth_modal_title" class="modal-title">模态框</h4>
            </div>
            <div class="modal-body">
                <div id="role_chooseAuth_modal_body">
                </div>
            </div>
            <div class="modal-footer">
                <button id="role_chooseAuth_modal_button" type="button" class="btn btn-primary">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
