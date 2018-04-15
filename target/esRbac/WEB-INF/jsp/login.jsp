<%--
  Created by IntelliJ IDEA.
  User: Ng
  Date: 2017/4/9
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@include file="common/head.jsp" %>
    <title>${title}</title>
    <%--<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->--%>
    <%--<!--[if lt IE 9]>--%>
    <%--<script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>--%>
    <%--<script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>--%>
    <%--<![endif]-->--%>

    <!-- Custom styles for this template -->
    <link href="/resources/css/signin.css" rel="stylesheet">
    <script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
</head>

<body>

<div class="container">

    <form  class="form-signin">
        <h2 class="form-signin-heading">请登录</h2>
        <label for="userName" class="sr-only">用户名</label>
        <input type="text" id="userName" class="form-control" placeholder="用户名" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="密码" required>
        <div class="checkbox">
            <label>
                <input id="remeber_me" type="checkbox" value="remember-me"> 记住我
            </label>
        </div>
        <button id="login-submit" data-toggle="popover" data-trigger="focus"  type="button" class="btn btn-lg btn-primary btn-block">登录</button>
    </form>

</div> <!-- /container -->

<script src="/resources/script/login.js"></script>

</body>
</html>

