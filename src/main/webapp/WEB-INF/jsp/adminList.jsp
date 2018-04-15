<%--
  Created by IntelliJ IDEA.
  User: Ng
  Date: 2017/4/9
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@include file="common/head.jsp" %>
    <title>${title}</title>
    <style>
        td{
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
        }
    </style>
</head>
<body>
<%@include file="common/header.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@include file="common/left.jsp" %>
        <div  id="load-content" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <h1 class="page-header text-center">${title}</h1>
            <div class="row">
                <div class="btn-group"  style="float: right"  role="group" aria-label="...">
                    <button id="admin_list_add_btn" type="button" class="btn btn-default">添加用户</button>
                </div>
            </div>
            <div>
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <%--<th>ID</th>--%>
                            <th>用户名</th>
                            <th>昵称</th>
                            <th>密码</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th>邮箱</th>
                            <th>电话</th>
                            <th>状态</th>
                            <th>角色</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${page.list}" var="item">
                            <tr>
                                <td style="display: none">${item.adminId}</td>
                                <td>${item.adminName}</td>
                                <td>${item.adminNickname}</td>
                                <td>${item.adminPassword}</td>
                                <td><fmt:formatDate value="${item.adminCreatetime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                                <td><fmt:formatDate value="${item.adminModifytime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                                <td>${item.adminEmail}</td>
                                <td>${item.adminTel}</td>
                                <td>
                                    <c:if test="${item.adminId!='0'}">
                                    <c:choose>
                                        <c:when test="${item.adminState eq 1}">
                                            <div class="btn-group">
                                                <button class="btn btn-primary admin_update_state_btn"  data-admin-id="${item.adminId}"  data-admin-state="1" disabled>开启</button>
                                                <button class="btn btn-danger admin_update_state_btn" data-admin-id="${item.adminId}"   data-admin-state="0">关闭</button>
                                            </div>                                        </c:when>
                                        <c:when test="${item.adminState eq 0}">
                                            <div class="btn-group">
                                                <button class="btn btn-primary admin_update_state_btn"  data-admin-id="${item.adminId}"  data-admin-state="1" >开启</button>
                                                <button class="btn btn-danger admin_update_state_btn" data-admin-id="${item.adminId}"   data-admin-state="0" disabled>关闭</button>
                                            </div>
                                        </c:when>
                                    </c:choose>
                                    </c:if>
                                </td>
                                <td>${item.role.roleName}</td>
                                <td>
                                    <c:if test="${item.adminId!='0'}">
                                    <button class="btn btn-default btn-sm admin_edit_btn">
                                        <span class="glyphicon glyphicon-pencil" aria-hidden="true" />编辑
                                    </button>
                                    </c:if>
                                </td>
                                <td>
                                    <c:if test="${item.adminId!='0'}">
                                    <button class="btn btn-default btn-sm admin_delete_btn" data-admin-id="${item.adminId}">
                                        <span class="glyphicon glyphicon-trash" aria-hidden="true"/>删除
                                    </button>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <nav aria-label="Page navigation">
                    <ul id="page" class="pagination pagination-lg">
                        <c:if test="${page.pageNow gt 1}">
                            <li>
                                <a href="/admin/list?pageNow=${page.pageNow-1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:forEach var="item" varStatus="i" items="${page.list}" begin="0" step="1" end="4">
                            <c:if test="${page.pageNow+i.index le page.totalPage}">
                                <c:choose>
                                    <c:when test="${(page.pageNow+i.index) eq page.pageNow }">
                                        <li><a href="/admin/list?pageNow=${page.pageNow+i.index}"   class="active">${page.pageNow+i.index}</a></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li><a href="/admin/list?pageNow=${page.pageNow+i.index}" >${page.pageNow+i.index}</a></li>
                                    </c:otherwise>
                                </c:choose>
                            </c:if>
                        </c:forEach>
                        <c:if test="${page.pageNow lt page.totalPage}">
                            <li>
                                <a href="/admin/list?pageNow=${page.pageNow+1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</div>
<%@include file="common/adminModal.jsp"%>
<%--<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>--%>
<%--<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>--%>
<script src="/resources/script/adminList.js"></script>
</body>
</html>
