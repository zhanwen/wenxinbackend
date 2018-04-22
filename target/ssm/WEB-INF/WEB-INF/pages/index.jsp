<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
<title>首页</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href='http://fonts.googleapis.com/css?family=Quattrocento+Sans' rel='stylesheet' type='text/css'>
<link href="${pageContext.request.getContextPath()}/static/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--slider-->
<link href="${pageContext.request.getContextPath()}/static/css/slider.css" rel="stylesheet" type="text/css" media="all"/>
<script type="text/javascript" src="${pageContext.request.getContextPath()}/static/js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.getContextPath()}/static/js/jquery.nivo.slider.js"></script>
<script type="text/javascript">
    $(window).load(function() {
        $('#slider').nivoSlider();
    });
    </script>
	<style type="text/css">
		.main_a a{
			color: #a94442;
		}

	</style>
</head>
<body>
<div class="btm_border">
<div class="h_bg">
<div class="wrap">
	<div class="header">
		<div class="logo">
			<h1><a href="${pageContext.request.getContextPath()}/new/home"><img src="${pageContext.request.getContextPath()}/static/images/logo.png" alt=""></a></h1>
		</div>

		<div class="clear"></div>
	</div>
	<div class='h_btm'>
		<div class='cssmenu'>
			<ul>
			    <li class='active'><a href='${pageContext.request.getContextPath()}/new/home'><span>首页</span></a></li>
			    <li><a href='${pageContext.request.getContextPath()}/new/direction'><span>研究方向</span></a></li>
			    <li><a href='${pageContext.request.getContextPath()}/new/team'><span>科研团队</span></a></li>
			    <li><a href='${pageContext.request.getContextPath()}/new/researchProject'><span>科研项目</span></a></li>
			    <li class='has-sub'><a href='${pageContext.request.getContextPath()}/new/successResult'><span>成果和奖励</span></a></li>
				<li><a href='${pageContext.request.getContextPath()}/scholar/patent'><span>学术成就</span></a></li>
				<li class='last'><a href='${pageContext.request.getContextPath()}/new/download'><span>下载中心</span></a></li>
			 	<div class="clear"></div>
			 </ul>
	</div>

	<div class="clear"></div>
</div>
</div>
</div>
</div>
<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >Website Template</a></div>
<!------ Slider_bg ------------>
<div class="slider_bg">
<div class="wrap">
	<!------ Slider------------>
		  <div class="slider">
	      	<div class="slider-wrapper theme-default">
	            <div id="slider" class="nivoSlider">
	                <img src="${pageContext.request.getContextPath()}/static/images/new/banner1.jpg" data-thumb="images/1.jpg" alt="" />
	                <img src="${pageContext.request.getContextPath()}/static/images/new/banner2.jpg" data-thumb="images/2.jpg" alt="" />
	                <img src="${pageContext.request.getContextPath()}/static/images/new/banner3.jpg" data-thumb="images/3.jpg" alt="" />
	            </div>
	        </div>
	      </div>
		<!------End Slider ------------>
		<div class="grids_1_of_3">
				<div class="grid_1_of_3 images_1_of_3">
					  <img src="${pageContext.request.getContextPath()}/static/images/new/icon1.jpg">
					  <h3>实验室专属</h3>
					  	<p>培养科学态度，提高科学素质</p>
					  	<p>学科学知识，攀科技高峰</p>
					  	<p>动手动脑，好学善思</p>
						<p>独立思考，团结合作</p>
				</div>
				<div class="grid_1_of_3 images_1_of_3">
					  <img src="${pageContext.request.getContextPath()}/static/images/new/icon2.jpg">
					  <h3>科研团队</h3>
						<p>精英联袂搭台，尖端科技聚彩</p>
						<p>精英团体协作，尖端科技在握</p>
						<p>有坚实基础，只为能走得更远</p>
						<p>科技创造，技论功勋</p>
				</div>
				<div class="grid_1_of_3 images_1_of_3">
					  <img src="${pageContext.request.getContextPath()}/static/images/new/icon3.jpg">
					  <h3>高效产出</h3>
					  <p>高效率的人生，不要自我限制，也不要自我满足。自我限制是低估自己的能力，自我满足是人生的死海。人的生命非常珍贵有限，试着享受高效率的生活，让生命更有活力更有价值</p>
				</div>
				<div class="clear"></div>
			</div>
</div>
</div>
<!--main-->
<div class="main_bg">
<div class="wrap">
<div class="main">
	<div class="content">
		<h2>实验室简介 <a href="${pageContext.request.getContextPath()}/new/team" style="float: right; font-size: 20px; color: #a5a5a5;">更多>></a></h2>
		<h3>大数据和物联网实验室</h3>
		<p>
			<a href="details.html"><img src="${pageContext.request.getContextPath()}/static/images/new/pic1.jpg"></a><br><br>
			上海师范大学大数据和物联网实验室成立于200x年，经过多年的发展，已经成长为上海师范大学计算机学科建设的一支重要力量。 研究室现有教授1名，副教授x名，讲师x名，在校硕士生 x 名
			上海师范大学大数据和物联网实验室成立于200x年，经过多年的发展，已经成长为上海师范大学计算机学科建设的一支重要力量。 研究室现有教授1名，副教授x名，讲师x名，在校硕士生 x 名
		</p>
		<div class="clear"></div>
	</div>
</div>
</div>
<div class="main_btm">
	<div class="wrap">
		 <div class="main">
					<div class="content">
						<h2>研究方向 <a href="${pageContext.request.getContextPath()}/new/direction" style="float: right; font-size: 20px; color: #a5a5a5;">更多>></a></h2>
						<br>
					</div>
			 <div class="box1">
				 <h4 class="btm">智能</h4>
				 <div class="box1_address">
					 <p>研究情境感知计算和智能服务的基础理论和方法
					 包括：情境元模型、基于大数据的情境模型演化、情境推理、 服务发现、服务组合、服务推荐等，以及面向健康养老、生产性服务、互联网教育、公共安全等领域的情境感知计算、智能服务等关键技术和系统。 </p>
				 </div>
			 </div>
			 <div class="box1">
				 <h4 class="btm">物联网</h4>
				 <div class="box1_address">
					 <p>研究大数据、云计算、物联网等新型分</p>
					 <p>式系统安全的基础理论、方法和关键技,</p>
					 <p>包括：访问控制、加密共享、 隐私计算、</p>
					 <p>隔离计算、可信计算和可信溯源等，以</p>
					 <p>及面向大数据汇聚、交换、共享、分析 </p>
					 <p>等场景的安全多方计算、安全态势感知、</p>
					 <p>安全可信评测等关键技术和系统。 </p>
				 </div>
			 </div>
			 <div class="box1">
				 <h4 class="btm">大数据</h4>
				 <div class="box1_address">
					 <p>研究大数据分析与机器学习系统相关的基础理论和方法，研究融合计算智能与群智知识的大规模分布式机器学习系统的优化 方法，以及面向系统运维、人力资源、健康医疗、心理咨询、金融科技、精准推荐等领域的深度学习、增强学习、迁移学习等大数据分析技术和系统。</p>
				 </div>
			 </div>
			 <div class="clear"> </div>
		</div>
	</div>
</div>
<div class="main_bg">
	<div class="wrap">
	<div class="main">
		<div class="content">
			<h2>科研项目 <a href="${pageContext.request.getContextPath()}/new/researchProject" style="float: right; font-size: 20px; color: #a5a5a5;">更多>></a></h2>
			<br>
			<ul>
				<li><p>1、云存储的隐私保护与安全保障机制，国家自然科学基金重点，2013.1-2017.12</p></li>
				<li><p>2、适应用户兴趣漂移的知识结构组织和学习服务推荐方法，国家自然基金青年，2014.1-2016.12</p></li>
				<li><p>3、云安全的可信服务及示范应用，国家863计划重点，2015.1-2017.12</p></li>
				<li><p>4、大数据平台信息安全关键技术研发，深圳市科技攻关计划重点，2014.7-2016.12</p></li>
				<li><p>5、基于分数阶动力系统的IT 服务项目管理文化的混沌特性研究，教育部博士点基金，2014.1-2016.12</p></li>
			</ul>
			<div class="clear"></div>
		</div>
	</div>
</div>

<div class="main_btm">
	<div class="wrap">
		<div class="main">
			<div class="content">
				<h2>专利<a href="${pageContext.request.getContextPath()}/new/successResult" style="float: right; font-size: 20px; color: #a5a5a5;">更多>></a></h2>
				<br>
				<ul>
					<li><p>1、张旱文，基于问答网站知识的软件配置故障自动修复方法和系统，专利申请号：201610202074.2</p></li>
					<li><p>2、张旱文，电影上座率预测方法和系统，专利申请号：201610450944</p></li>
					<li><p>3、张旱文，云计算系统中高频次连续失效任务的在线识别方法和系统，专利申请号：CN 201510649451.2</p></li>
					<li><p>4、张旱文，基于互联网日志数据的软件缺陷故障识别方法和系统，专利申请号：CN 201510977321.1</p></li>
					<li><p>5、张旱文，基于多云存储的智能移动终端数据存储备份方法与系统，专利申请号：CN 201410219412.4</p></li>
				</ul>
				<div class="clear"></div>
			</div>
		</div>
	</div>
<!--footer-->
<div class="main_bg">
	<div class="wrap">
	<div class="main">
		<div class="content main_a">
			<h2>科普文章</h2>
			<br>
			<ul>
				<li>
					<a href="http://blog.csdn.net/hotqin888/article/details/78460385"  target="_blank">1、 beego利用casbin进行权限管理——第一节 起步、测试 （转载）</a>
				</li>
				<li>
					<a href="http://blog.csdn.net/hotqin888/article/details/78571240"  target="_blank">2、 beego利用casbin进行权限管理——第二节 策略存储 （转载）</a>
				</li>
				<li>
					<a href="http://blog.csdn.net/hotqin888/article/details/78992250"  target="_blank">3、 beego利用casbin进行权限管理——第三节 策略查询 （转载）</a>
				</li>
				<li>
					<a href="https://studygolang.com/articles/12323"  target="_blank">4、 在 Go 语言中使用 casbin 实现基于角色的 HTTP 权限控制 （转载）</a>
				</li>
				<li>
					<a href="https://www.v2ex.com/t/391872"  target="_blank">5、 Casbin: 强大的 Go 访问控制、权限管理框架，支持 ACL, RBAC, ABAC （转载）</a>
				</li>

				<li>
					<a href="http://www.sohu.com/a/144394875_609556"  target="_blank">6、 Casbin: 强大的 Go 支持MACRBACABAC多种模型的Golang访问控制框架Casbin （转载）</a>
				</li>
	    	</ul>
		</div>
	</div>
	<div class="clear"></div>			
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

</div>
</div>
</div>
</body>
</html>
