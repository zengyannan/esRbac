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
</head>
<body>
    <%@include file="common/header.jsp" %>
    <div class="container-fluid">
        <div class="row">
            <%@include file="common/left.jsp" %>
            <div  id="load-content" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <ol class="breadcrumb" >
                    <li><a href="#" onclick="">Index</a></li>
                    <li class="active">index</li>
                </ol>
                <div class="row">
                    <div class="page-header">
                        <h1 class="index-page-header">欢迎,<small>${admin.adminName}</small></h1>
                    </div>
                </div>
                <div class="row">
                    <div id="index_notice" class="col-lg-6 col-md-6 col-xs-6 col-sm-6">
                        <h3 class="text-center">公告</h3>
                        <div id="index_notice_list" class="row">
                            <div class="panel panel-primary" >
                                <div class="panel-heading">Panel heading without title</div>
                                <div class="panel-body">
                                    Panel content
                                </div>
                            </div>
                            <div class="panel panel-primary" >
                                <div class="panel-heading">Panel heading without title</div>
                                <div class="panel-body">
                                    Panel content
                                </div>
                            </div>
                            <div class="panel panel-primary" >
                                <div class="panel-heading">Panel heading without title</div>
                                <div class="panel-body">
                                    Panel content
                                </div>
                            </div>
                            <div class="panel panel-primary" >
                                <div class="panel-heading">Panel heading without title</div>
                                <div class="panel-body">
                                    Panel content
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="index_schedule" class="col-lg-6 col-md-6 col-xs-6 col-sm-6">
                        <h3 class="text-center">日程</h3>
                        <div id="index_schedule_list">
                                <div class="panel panel-primary">
                                <!-- Default panel contents -->
                                <div class="panel-heading">Panel heading</div>
                                <div class="panel-body">
                                    <p>...</p>
                                </div>
                                <!-- List group -->
                                <ul class="list-group">
                                    <li class="list-group-item">Cras justo odio</li>
                                    <li class="list-group-item">Dapibus ac facilisis in</li>
                                    <li class="list-group-item">Morbi leo risus</li>
                                    <li class="list-group-item">Porta ac consectetur ac</li>
                                    <li class="list-group-item">Vestibulum at eros</li>
                                    <li class="list-group-item">Cras justo odio</li>
                                    <li class="list-group-item">Dapibus ac facilisis in</li>
                                    <li class="list-group-item">Morbi leo risus</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="/resources/js/bootstrap-treeview.min.js"></script>
    <!--左侧菜单JavaScript文件-->
    <script src="/resources/script/left.js"></script>
</body>
</html>
