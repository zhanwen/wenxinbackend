<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="zh-CN">
<%
    String path = request.getRequestURI();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<base href="<%=basePath%>" rel="external nofollow" >
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>

    <link href="./static/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<h1>你好，世界！</h1>
<div class="jumbotron container">
    <div >
        <h1>Hello, world!</h1>
        <p><a class="btn btn-primary btn-lg" href="#" rel="external nofollow" role="button">Learn more</a></p>
    </div>
</div>
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="./static/js/jquery-3.1.1.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="./static/js/bootstrap.min.js"></script>
</body>
</html>