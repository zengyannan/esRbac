<%--
  Created by IntelliJ IDEA.
  User: Ng
  Date: 2017/4/30
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@include file="common/head.jsp" %>
    <title>${title}</title>
</head>
<body>
<%@include file="common/header.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@include file="common/left.jsp" %>
        <div  id="load-content" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header text-center">${title}</h1>
            <div class="row">
                <div class="btn-group"  style="float: right">
                    <button id="auth_list_add_btn" type="button" class="btn btn-default">添加权限</button>
                </div>
            </div>
            <div>
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>名字</th>
                            <th>父级权限</th>
                            <th>控制器名</th>
                            <th>操作名</th>
                            <th>权限URL</th>
                            <th>权限等级</th>
                            <th>创建时间</th>
                            <th>状态</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${page.list}" var="item">
                            <tr>
                                <td>${item.authId}</td>
                                <td>${item.authName}</td>
                                <td>${item.authPid}</td>
                                <td>${item.authC}</td>
                                <td>${item.authA}</td>
                                <td>${item.authUrl}</td>
                                <td>${item.authLevel}</td>
                                <td><fmt:formatDate value="${item.authCreatetime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                                <td>
                                    <c:choose>
                                    <c:when test="${item.authState eq 1}">
                                        <div class="btn-group">
                                            <button class="btn btn-primary auth_update_state_btn"  data-auth-id="${item.authId}"  data-auth-state="1" disabled>开启</button>
                                            <button class="btn btn-danger auth_update_state_btn" data-auth-id="${item.authId}"   data-auth-state="0">关闭</button>
                                        </div>
                                    </c:when>
                                    <c:when test="${item.authState eq 0}">
                                        <div class="btn-group">
                                            <button class="btn btn-primary auth_update_state_btn" data-auth-id="${item.authId}" data-auth-state="1" >开启</button>
                                            <button class="btn btn-danger auth_update_state_btn" data-auth-id="${item.authId}" data-auth-state="0"  disabled>关闭</button>
                                        </div>
                                    </c:when>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:if test="${item.authId!=1}">
                                        <button
                                                class="btn btn-default btn-sm auth_edit_btn"
                                                data-auth-id="${item.authId}"
                                                data-auth-pid="${item.authPid}"
                                                data-auth-name="${item.authName}"
                                                data-auth-c="${item.authC}"
                                                data-auth-a="${item.authA}"
                                        >
                                            <span class="glyphicon glyphicon-pencil" aria-hidden="true" />编辑
                                        </button>
                                    </c:if>
                                </td>
                                <td>
                                    <c:if test="${item.authId!=1}">
                                        <button class="btn btn-default btn-sm auth_delete_btn" data-auth-id="${item.authId}">
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
                                <a href="/auth/list?pageNow=${page.pageNow-1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:forEach var="item" varStatus="i" items="${page.list}" begin="0" step="1" end="4">
                            <c:if test="${page.pageNow+i.index le page.totalPage}">
                                <c:choose>
                                    <c:when test="${(page.pageNow+i.index) eq page.pageNow }">
                                        <li><a href="/auth/list?pageNow=${page.pageNow+i.index}"   class="active">${page.pageNow+i.index}</a></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li><a href="/auth/list?pageNow=${page.pageNow+i.index}" >${page.pageNow+i.index}</a></li>
                                    </c:otherwise>
                                </c:choose>
                            </c:if>
                        </c:forEach>
                        <c:if test="${page.pageNow lt page.totalPage}">
                            <li>
                                <a href="/auth/list?pageNow=${page.pageNow+1}" aria-label="Next">
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
<%@include file="common/authModal.jsp"%>
<%--<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>--%>
<%--<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>--%>
<script src="/resources/script/authList.js"></script>
</body>
</html>
