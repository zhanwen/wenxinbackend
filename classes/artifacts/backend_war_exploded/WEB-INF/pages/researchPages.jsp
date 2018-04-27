<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>学术成就</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href='http://fonts.googleapis.com/css?family=Quattrocento+Sans' rel='stylesheet' type='text/css'>
<link href="${pageContext.request.getContextPath()}/static/css/style.css" rel="stylesheet" type="text/css" media="all" />
	<style type="text/css">
		.list_xueshu_content ol{
			list-style:square;
			margin:0;padding:0;
		}
		.list_xueshu_content ol li{
			color: #595959;
		}
		.second{
			margin-left: 15px;
		}
	</style>
</head>
<body>
<div class="btm_border">
<div class="h_bg">
<div class="wrap">
	<div class="header">
		<div class="logo">
			<h1><a href="index.jsp"><img src="${pageContext.request.getContextPath()}/static/images/logo.png" alt=""></a></h1>
		</div>

		<div class="clear"></div>
	</div>
	<div class='h_btm'>
		<div class='cssmenu'>
			<ul>
				<li><a href='${pageContext.request.getContextPath()}/new/home'><span>首页</span></a></li>
				<li ><a href='${pageContext.request.getContextPath()}/new/direction'><span>研究方向</span></a></li>
				<li><a href='${pageContext.request.getContextPath()}/new/team'><span>科研团队</span></a></li>
				<li><a href='${pageContext.request.getContextPath()}/new/researchProject'><span>科研项目</span></a></li>
				<li class='has-sub'><a href='${pageContext.request.getContextPath()}/new/successResult'><span>成果和奖励</span></a></li>
				<li class='active'><a href='${pageContext.request.getContextPath()}/scholar/patent'><span>学术成就</span></a></li>
				<li class='last'><a href='${pageContext.request.getContextPath()}/new/download'><span>下载中心</span></a></li>
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
							<span style="font-family: 微软雅黑;"><span style="font-size: 26px;"><strong>学术论文:</strong></span></span><br>
							<div class="list_xueshu_content">
								<br />
								<span><strong>2017年</strong></span>
								<br>
								<ol>
									<li>Zhang Bo, Zhang Huan, Li Meizi*, Zhao Qin, Huang Jifeng. Trust Traversal: A Trust Link Detection Scheme in Social Network, Computer Networks, Volume 120, 19 June 2017, Pages 105–125 (SCI:000401877300008)</li>
									<li>Zhang Bo; Yong Ruihan; Li Meizi*, Pan Jianguo, Huang Jifeng. A Hybrid Trust Evaluation Framework for E-commerce in Online Social Network: A Factor Enrichment Perspective, IEEE Access, 2017,Volume 5: 7080 - 7096 (SCI:000403140800028) </li>
								</ol>
							</div>
                        </div>
                        <br>
                        <div class="other" style="margin-left: 200px">

                        </div>
                    </div>
                    <div class="company_address">
                        <div class="categories animated wow slideInUp" data-wow-delay=".5s">
                            <h3>学术成就</h3>
                            <ul class="cate">
                                <li><a href="${pageContext.request.getContextPath()}/scholar/patent">发明专利</a> </li>
                                <li><a href="${pageContext.request.getContextPath()}/scholar/softwareCopyright">软件著作权</a> </li>
                                <li><a href="${pageContext.request.getContextPath()}/scholar/researchPages">学术论文</a> </li>
                                <li>
									<li class="second"><a style="color: red" href="${pageContext.request.getContextPath()}/scholar/researchPages">2017年</a></li>
									<li class="second"><a  href="${pageContext.request.getContextPath()}/scholar/researchPages/page2016">2016年</a></li>
									<li class="second"><a  href="${pageContext.request.getContextPath()}/scholar/researchPages/page2015">2015年</a></li>
									<li class="second"><a  href="${pageContext.request.getContextPath()}/scholar/researchPages/page2014">2014年</a></li>
									<li class="second"><a  href="${pageContext.request.getContextPath()}/scholar/researchPages/page2013">2013年</a></li>
								</li>
								<li><a href="${pageContext.request.getContextPath()}/scholar/academicDissertations">学位论文</a> </li>
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
<!--footer-->
<div class="footer-bg">	
<div class="wrap">
<div class="footer">

	<div class="about-header">

		<div class="clear"> </div>
	</div>

	<div class="about-info">

	</div>


</div>
</div>
</div>
<!--footer1-->
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