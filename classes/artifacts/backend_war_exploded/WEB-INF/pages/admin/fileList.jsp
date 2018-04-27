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
    <link rel="icon" href="${pageContext.request.getContextPath()}/static/images/favoricon.ico">

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

    <script language="JavaScript">

        function addFile() {
            var str = getRootPath_web();
            window.location.href=str+"/fileOperator/addFile";
            return false;
        }

        function getRootPath_web() {
            //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
            var curWwwPath = window.document.location.href;
            //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
            var pathName = window.document.location.pathname;
            var pos = curWwwPath.indexOf(pathName);
            //获取主机地址，如： http://localhost:8083
            var localhostPaht = curWwwPath.substring(0, pos);
            //获取带"/"的项目名，如：/uimcardprj
            var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
            return (localhostPaht + projectName);
        }



        function deleteConfirm() {
            var tr = confirm("确认删除");
            if(tr) {
                return true;
            }else {
                return false;
            }
        }
    </script>

    <style type="text/css">
        table td{white-space:nowrap;overflow:hidden; text-overflow:ellipsis;}
        table {
            table-layout: fixed;
        }

        /*table tr td:first-child{*/
            /*width: 100px;*/
        /*}*/

        /*table tr td:nth-child(2) {*/
            /*width: 50px;*/
        /*}*/
        /*table tr td:nth-child(3) {*/
            /*width: 170px;*/
        /*}*/
        /*table tr td:nth-child(4) {*/
            /*width: 50px;*/
        /*}*/
    </style>

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
            <a class="navbar-brand" href="${pageContext.request.getContextPath()}/admin/fileList">大数据和物联网实验室</a>
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
                <li class='active'> <a href="${pageContext.request.getContextPath()}/admin/fileList">文件列表<span class="sr-only">(current)</span></a></li>
            </ul>
            <ul class="nav nav-sidebar">
            </ul>

        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div>
                <button class="btn  btn-danger" style="size: 10px" onclick="return addFile()">上传文件</button>
            </div>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th width="11%">文件类别</th>
                        <th width="15%">作者</th>
                        <th width="9%">发表时间</th>
                        <th width="40%" >文件名</th>
                        <th width="20%">上传时间</th>
                        <th width="5%">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${fileBean.resultList}" var="file">
                        <tr>
                            <td>
                                <c:if test="${file.category == 1}">社交网络</c:if>
                                <c:if test="${file.category == 2}">自然语言处理</c:if>
                                <c:if test="${file.category == 3}">机器学习</c:if>
                                <c:if test="${file.category == 4}">智能信息推荐</c:if>
                                <c:if test="${file.category == 5}">深度学习</c:if>
                                <c:if test="${file.category == 6}">计算机视觉</c:if>
                                <c:if test="${file.category == 7}">大数据挖掘</c:if>
                            </td>
                            <td >${file.author}</td>
                            <td >${file.publicTime}</td>
                            <td id="showAll" class="filename">${file.fileName}</td>
                            <td >${file.date}</td>
                            <td ><a onclick="return deleteConfirm()" href="${pageContext.request.getContextPath()}/fileOperator/deleteFile?id=${file.id}">删除</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <c:if test="${fileBean.pageNos > 1}">
                              <li><a href="${pageContext.request.getContextPath()}/admin/fileList?pageNos=1">首页</a></li>
                              <li><a href="${pageContext.request.getContextPath()}/admin/fileList?pageNos=${fileBean.pageNos-1}">上一页</a></li>
                            </c:if>
                            <c:if test="${fileBean.pageNos < fileBean.totalPage}">
                                <li><a href="${pageContext.request.getContextPath()}/admin/fileList?pageNos=${fileBean.pageNos+1}">下一页</a></li>
                                <li><a href="${pageContext.request.getContextPath()}/admin/fileList?pageNos=${fileBean.totalPage}">尾页</a></li>
                            </c:if>
                            <li class="disabled"><a style="color: #6F6F6F">第${fileBean.pageNos}页</a></li>
                            <li class="disabled"><a style="color: #6F6F6F">共${fileBean.totalPage}页</a></li>
                        </ul>
                    </nav>
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
