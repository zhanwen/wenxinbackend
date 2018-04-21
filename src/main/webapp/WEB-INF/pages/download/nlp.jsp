<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Contact</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href='http://fonts.googleapis.com/css?family=Quattrocento+Sans' rel='stylesheet' type='text/css'>
<link href="${pageContext.request.getContextPath()}/static/css/style.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
<div class="btm_border">
<div class="h_bg">
<div class="wrap">
	<div class="header">
		<div class="logo">
			<h1><a href="index.html"><img src="${pageContext.request.getContextPath()}/static/images/logo.png" alt=""></a></h1>
		</div>
		<div class="clear"></div>
	</div>
	<div class='h_btm'>
		<div class='cssmenu'>
			<ul>
				<li><a href='${pageContext.request.getContextPath()}/new/home'><span>首页</span></a></li>
				<li><a href='${pageContext.request.getContextPath()}/new/direction'><span>研究方向</span></a></li>
				<li><a href='${pageContext.request.getContextPath()}/new/team'><span>科研团队</span></a></li>
				<li><a href='${pageContext.request.getContextPath()}/new/researchProject'><span>科研项目</span></a></li>
				<li class='has-sub'><a href='${pageContext.request.getContextPath()}/new/successResult'><span>成果和奖励</span></a></li>
				<li class='last active'><a href='${pageContext.request.getContextPath()}/new/download'><span>下载中心</span></a></li>
				<div class="clear"></div>
			</ul>
	</div>

	<div class="clear"></div>
</div>
</div>
</div>
</div>
<!--main-->
<div class="main_bg">
<div class="wrap">
<div class="main">
	<div class="contact">
		<div class="section group">				
				<div class="col span_1_of_2">
					<div class="contact_info">
						<div class="map">
							<br>
							<ul>
								<c:forEach items="${fileBean.resultList}" var="bean">
									<li style="padding-top: 10px"><a href="${pageContext.request.getContextPath()}/fileOperator/downloadFile?fileName=${bean.name}&filePath=${bean.filePath}&name=${bean.fileName}" style="color: #555555">${bean.fileName}</a></li>
								</c:forEach>
							</ul>
						</div>
						<br>
						<div class="other" style="margin-left: 200px">
							<p>
								<c:if test="${fileBean.pageNos > 1}">
									<a href="${pageContext.request.getContextPath()}/new/download?pageNos=1" style="color: #6F6F6F">首页</a>
									<a href="${pageContext.request.getContextPath()}/new/download?pageNos=${fileBean.pageNos-1}" style="color: #6F6F6F">上一页</a>
								</c:if>
								<c:if test="${fileBean.pageNos < fileBean.totalPage}">
									<a href="${pageContext.request.getContextPath()}/new/download?pageNos=${fileBean.pageNos+1}" style="color: #6F6F6F">下一页</a>
									<a href="${pageContext.request.getContextPath()}/new/download?pageNos=${fileBean.totalPage}" style="color: #6F6F6F">尾页</a>
								</c:if>
								<c:if test="${map['npl'] != 0}">
									<a style="color: #6F6F6F">第${fileBean.pageNos}页</a>
									<a style="color: #6F6F6F">共${fileBean.totalPage}页</a>
								</c:if>
							</p>
						</div>
					</div>
      			<div class="company_address">
					<div class="categories animated wow slideInUp" data-wow-delay=".5s">
						<h3>目录</h3>
						<ul class="cate">
							<li><a href="${pageContext.request.getContextPath()}/new/download">社交网络</a> <span>(${map['socialNetwork']})</span></li>
							<li><a href="${pageContext.request.getContextPath()}/new/download/nlp">自然语言处理</a> <span>(${map['npl']})</span></li>
							<li><a href="${pageContext.request.getContextPath()}/new/download/machineLearn">机器学习</a> <span>(${map['machineLearn']})</span></li>
							<li><a href="${pageContext.request.getContextPath()}/new/download/informationRecommend">智能信息推荐</a> <span>(${map['informationRecommend']})</span></li>
							<li><a href="${pageContext.request.getContextPath()}/new/download/deepLearning">深度学习</a> <span>(${map['deepLearn']})</span></li>
							<li><a href="${pageContext.request.getContextPath()}/new/download/computerVision">计算机视觉</a> <span>(${map['computerVision']})</span></li>
							<li><a href="${pageContext.request.getContextPath()}/new/download/bigDataDig">大数据挖掘</a> <span>(${map['bigDataDig']})</span></li>
						</ul>
					</div>
				   </div>
				   <div class="clear"></div>
				</div>				
				<div class="col span_2_of_4">

  				</div>		
  			<div class="clear"></div>
		  </div>
	</div>
</div>
</div>
</div>


<div class="ftr-bg">
	<div class="wrap">
		<div class="footer">
			<div class="copy">
				<p class="w3-link">Copyright &copy; 2018 All Rights Reserved 版权所有：上海师范大学大数据和物联网实验室</p>
				<p class="w3-link">联系地址:  上海市奉贤区海湾镇海思路100号</p>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</div>
</body>
</html>