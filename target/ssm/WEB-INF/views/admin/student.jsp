<%--
  Created by IntelliJ IDEA.
  User: zhanghanwen
  Date: 2018/4/7
  Time: 下午4:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="${pageContext.request.getContextPath()}/static/images/favicon.ico">

    <title>后台管理</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.getContextPath()}/static/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="${pageContext.request.getContextPath()}/static/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.getContextPath()}/static/css/dashboard.css" rel="stylesheet">
    <script src="${pageContext.request.getContextPath()}/static/js/ie8-responsive-file-warning.js"></script>
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><![endif]-->
    <script src="${pageContext.request.getContextPath()}/static/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<%
    String active = (String)request.getSession().getAttribute("active");
%>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.getContextPath()}/admin/students">大数据和物联网实验室</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.getContextPath()}/admin/logout">登出</a></li>
            </ul>

        </div>


    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li <c:if test="${active == 'student'}">class='active'</c:if>> <a href="${pageContext.request.getContextPath()}/admin/students">学生<span class="sr-only">(current)</span></a></li>
                <li <c:if test="${active == 'teacher'}">class='active'</c:if> ><a href="${pageContext.request.getContextPath()}/admin/teacher">教师</a></li>
            </ul>
            <ul class="nav nav-sidebar">
            </ul>

        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div>
                <button class="btn  btn-danger" style="size: 10px">添加学生</button>
            </div>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>年级</th>
                        <th>学号</th>
                        <th>姓名</th>
                        <th>邮箱</th>
                        <th>职位</th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userList}" var="student">
                        <tr>
                            <td>${student.grade}</td>
                            <td>${student.studentNo}</td>
                            <td>${student.username}</td>
                            <td>${student.email}</td>
                            <td>${student.position}</td>
                            <td><a href="#">修改</a></td>
                            <td><a href="#">删除</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${pageContext.request.getContextPath()}/static/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.getContextPath()}/static/js/bootstrap.min.js"></script>
<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="${pageContext.request.getContextPath()}/static/js/holder.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="${pageContext.request.getContextPath()}/static/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
