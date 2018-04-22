<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhanghanwen
  Date: 2018/4/7
  Time: 下午4:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8"%>
<%request.setCharacterEncoding("utf-8");%>
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
    <script src="${pageContext.request.getContextPath()}/static/js/jquery-1.9.0.min.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <![endif]-->
    <script type="text/javascript">
        $(function(){
            $("#file").change(function(){  // 当 id 为 file 的对象发生变化时
                var fileSize = this.files[0].size;
                var size = fileSize / 1024 / 1024;
                if (size > 20) {
                    alert("附件不能大于20M,请将文件压缩后重新上传！");
                    this.value="";
                    return false;
                }else{
                    $("#file_name").val($("#file").val());  //将 #file 的值赋给 #file_name
                }
            })
        });

    </script>

    <script type="text/javascript">
        var isCommitted = false;//表单是否已经提交标识，默认为false
        function dosubmit(){
            if(isCommitted==false){
                isCommitted = true;//提交表单后，将表单是否已经提交标识设置为true
                return true;//返回true让表单正常提交
            }else{
                return false;//返回false那么表单将不提交
            }
        }
    </script>

    <style type="text/css">

        #file_name{
            width: 400px;
            height: 30px;
        }
        a.input {
            width:70px;
            height:30px;
            line-height:30px;
            background:#3091d1;
            text-align:center;
            display:inline-block;/*具有行内元素的视觉，块级元素的属性 宽高*/
            overflow:hidden;/*去掉的话，输入框也可以点击*/
            position:relative;/*相对定位，为 #file 的绝对定位准备*/
            top:10px;
        }
        a.input:hover {
            background:#31b0d5;
            color: #ffffff;
        }
        a{
            text-decoration:none;
            color:#FFF;
        }
        #file {
            opacity:0;/*设置此控件透明度为零，即完全透明*/
            filter:alpha(opacity=0);/*设置此控件透明度为零，即完全透明针对IE*/
            font-size:100px;
            position:absolute;/*绝对定位，相对于 .input */
            top:0;
            right:0;
        }
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

            <form class="form-horizontal" id="form1" action="${pageContext.request.getContextPath()}/fileOperator/saveFile" enctype="multipart/form-data" method="post" onsubmit="return dosubmit()">
                <div class="form-group">
                    <label for="category" class="col-sm-2 control-label">选择类别</label>
                    <div class="col-sm-5">
                        <select id="category" name="selectId">
                            <option value="1">社交网络</option>
                            <option value="2">自然语言处理</option>
                            <option value="3">机器学习</option>
                            <option value="4">智能信息推荐</option>
                            <option value="5">深度学习</option>
                            <option value="6">计算机视觉</option>
                            <option value="7">大数据挖掘</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="author" class="col-sm-2 control-label">作者</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="author" name="author">
                    </div>
                </div>

                <div class="form-group">
                    <label for="publictime" class="col-sm-2 control-label">发表时间</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="publictime" name="publictime">
                    </div>
                    <div class="col-sm-5">
                        <input readonly="readonly" value="例如：2017.5" style="border: 0px;"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="file_name" class="col-sm-2 control-label">文件名</label>
                    <input type="text" id="file_name" readonly="readonly" value="" />
                    <a href="javascript:void(0);" class="input">
                        浏览
                        <input type="file" id="file" name="document[file]">
                    </a>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-success" >保存</button>
                    </div>
                </div>
            </form>
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
