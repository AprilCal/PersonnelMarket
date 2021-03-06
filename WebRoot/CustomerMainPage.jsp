<%@page import="market.vo.Customer" import="market.vo.Recruitment"
	import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%  Customer customer = (Customer)session.getAttribute("customer"); %>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>威子哥人才市场</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/nprogress.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="apple-touch-icon-precomposed" href="images/icon.png">
<link rel="shortcut icon" href="images/favicon.ico">
<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/nprogress.js"></script>
<script src="js/jquery.lazyload.min.js"></script>
<style type="text/css">
	.panel
	{
		padding: 80px 20px 0px;
		min-height: 400px;
		cursor: default;
	}
	.text-center
	{
		margin: 0 auto;
		text-align: center;
		border-radius: 10px;
		max-width: 900px;
		-moz-box-shadow: 0px 0px 5px rgba(0,0,0,.3);
		-webkit-box-shadow: 0px 0px 5px rgba(0,0,0,.3);
		box-shadow: 0px 0px 5px rgba(0,0,0,.1);
	}
	.float-left
	{
		float: left !important;
	}
	.float-right
	{
		float: right !important;
	}
	img
	{
		border: 0;
		vertical-align: bottom;
	}
	h2
	{
		padding-top: 20px;
		font-size: 20px;
	}
	.padding-big
	{
		padding: 20px;
	}
	.alert
	{
		border-radius: 5px;
		padding: 15px;
		border: solid 1px #ddd;
		background-color: #f5f5f5;
	}
</style>
</head>
<body class="user-select">
<header class="header">
<nav class="navbar navbar-default" id="navbar">
<div class="container">
  <div class="header-topbar hidden-xs link-border">
	<ul class="site-nav topmenu">
		<li><a href="#" >进入企业版</a></li>
		<li><a href="#" rel="nofollow" >嘻嘻</a></li>
	</ul>找工作,就来威子哥网上人才市场
  </div>
  <div class="navbar-header">
	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#header-navbar" aria-expanded="false"> <span class="sr-only"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
	<h1 class="logo hvr-bounce-in"><a href="CustomerMainPage.html" title="木庄网络博客"><img src="images/logo.jpg" alt="木庄网络博客"></a></h1>
  </div>
  <div class="collapse navbar-collapse" id="header-navbar">
	<ul class="nav navbar-nav navbar-right">
	  <li><a data-cont="木庄网络博客" title="消息" href="underconstructing.html">消息(11)</a></li>
	  <li><a data-cont="列表页" title="我的简历" href="Resume.html">我的简历</a></li>
	  <li><a data-cont="详细页" title="详细页" href="DeliveredResumeServlet?customerId=<%= customer.getCustomerID() %>">投递箱</a></li>
	  <li><a data-cont="404" title="404" href="Favorite.html">收藏夹</a></li>
	  <li><a data-cont="MZ-NetBolg主题" title="MZ-NetBolg主题" href="underconstructing.html" ><%= customer.getCustomerName() %></a></li>
	  <li><a data-cont="资讯分享" title="资讯分享" href="underconstructing.html" >资讯分享</a></li>
	</ul>
  </div>
</div>
</nav>
</header>
<section class="container">
    <div class="widget widget_search" >
		<form class="navbar-form" action="Search" method="post" align="center">
			<select name="scope" >
				<option value="all">搜索范围</option>
				<option value="department">部门</option>
				<option value="position">职位</option>
				<option value="location">地区</option>
				<option value="title">标题</option>
			</select>
			<div class="input-group">
				<input type="text" name="keyword" class="form-control" size="140" placeholder="请输入关键字" maxlength="24" autocomplete="off">
				<input type="text" name="identity" hidden="true" value="customer">
				<span class="input-group-btn">
					<button class="btn btn-default btn-search" name="search" type="submit">搜索</button>
				</span> 
			</div>
		</form>
	</div>
<% 
	List<Recruitment> recruitmentList = (List<Recruitment>)session.getAttribute("recruitmentList");
	if(recruitmentList.isEmpty()){
		out.print("暂无职位");
	}
	else{
		for(Recruitment r : recruitmentList){
			out.print("<article class=\"excerpt excerpt-1\" style=\"\">"+
					"<a class=\"focus\" href=\"underconstructing.html\" title=\"enterprise title\" target=\"_blank\" >"+
					"<img class=\"thumb\" data-original=\"images/dulang.jpg\" src=\"images/dulang.jpg\" alt=\"用DTcms做一个独立博客网站\"  style=\"display: inline;\">"+
					"</a><header><a class=\"cat\" href=\"#\" title=\"企业名\" >武汉市毒狼网吧</a>"+
					"<h2><a href=\"RecruitmentDetailServlet?recruitmentId="+r.getRecruitmentId()+"\" title=\"招聘标题\" target=\"_blank\" >"+r.getTitle()+"</a></h2></header>"+
					"<p class=\"meta\">"+
					"<time class=\"time\"><i class=\"glyphicon glyphicon-time\"></i> 2016-10-14</time>"+
					"<span class=\"views\"><i class=\"glyphicon glyphicon-eye-open\"></i> 216</span> <a class=\"comment\" href=\"##comment\" title=\"评论\" target=\"_blank\" ><i class=\"glyphicon glyphicon-comment\"></i> 4</a>"+
					"</p><p class=\"note\">职位描述:"+r.getPositionDescription()+"</p></article>"
					);
		}
	}
%>
<!-- <article class="excerpt excerpt-1" style="">
	<a class="focus" href="underconstructing.html" title="enterprise title" target="_blank" >
		<img class="thumb" data-original="images/dulang.jpg" src="images/dulang.jpg" alt="用DTcms做一个独立博客网站（响应式模板）"  style="display: inline;">
	</a>
	<header>
		<a class="cat" href="#" title="MZ-NetBlog主题" >武汉市毒狼网吧</a>
		<h2>
			<a href="RecruitmentDetailPage.html" title="用DTcms做一个独立博客网站（响应式模板）" target="_blank" >毒狼网吧诚招网管一名</a>
		</h2>
	</header>
		<p class="meta">
			<time class="time"><i class="glyphicon glyphicon-time"></i> 2016-10-14</time>
			<span class="views"><i class="glyphicon glyphicon-eye-open"></i> 216</span> <a class="comment" href="##comment" title="评论" target="_blank" ><i class="glyphicon glyphicon-comment"></i> 4</a>
		</p>
		<p class="note">
			来我武汉毒狼网吧，拿到office以后包住宿餐饭，泡面管够，免费上网。需中专以上学历
		</p></article>
<article class="excerpt excerpt-1" style="">
	<a class="focus" href="underconstructing.html" title="用DTcms做一个独立博客网站（响应式模板）" target="_blank" >
		<img class="thumb" data-original="images/2.png" src="images/2.png" alt="用DTcms做一个独立博客网站（响应式模板）"  style="display: inline;">
	</a>
	<header>
		<a class="cat" href="#" title="MZ-NetBlog主题" >晨光镇光明村村民自治委员会</a>
		<h2>
			<a href="RecruitmentDetailPage.html" title="用DTcms做一个独立博客网站（响应式模板）" target="_blank" >晨光镇诚招镇长一名</a>
		</h2>
	</header>
		<p class="meta">
			<time class="time"><i class="glyphicon glyphicon-time"></i> 2016-10-14</time>
			<span class="views"><i class="glyphicon glyphicon-eye-open"></i> 216</span> <a class="comment" href="##comment" title="评论" target="_blank" ><i class="glyphicon glyphicon-comment"></i> 4</a>
		</p>
		<p class="note">
			来我武汉毒狼网吧，拿到office以后包住宿餐饭，泡面管够，免费上网。需中专以上学历。来我武汉毒狼网吧，拿到office以后包住宿餐饭，泡面
			管够，免费上网。需中专以上学历来我武汉毒狼网吧，拿到office以后包住宿餐饭，泡面管够，免费上网。需中专以上学历
		</p>
</article>
<article class="excerpt excerpt-1" style="">
  <a class="focus" href="#" title="用DTcms做一个独立博客网站（响应式模板）" target="_blank" ><img class="thumb" data-original="images/3.jpg" src="images/3.jpg" alt="用DTcms做一个独立博客网站（响应式模板）"  style="display: inline;"></a>
		<header><a class="cat" href="#" title="MZ-NetBlog主题" >武汉市毒狼网吧<i></i></a>
			<h2><a href="RecruitmentDetailPage.html" title="用DTcms做一个独立博客网站（响应式模板）" target="_blank" >毒狼网吧打手持续招募中</a>
			</h2>
		</header>
		<p class="meta">
			<time class="time"><i class="glyphicon glyphicon-time"></i> 2016-10-14</time>
			<span class="views"><i class="glyphicon glyphicon-eye-open"></i> 216</span> <a class="comment" href="##comment" title="评论" target="_blank" ><i class="glyphicon glyphicon-comment"></i> 4</a>
		</p>
		<p class="note">用DTcms做一个独立博客网站（响应式模板），采用DTcms V4.0正式版（MSSQL）。开发环境：SQL2008R2+VS2010。DTcms V4.0正式版功能修复和优化：1、favicon.ico图标后台上传。（解决要换图标时要连FTP或者开服务器的麻烦）</p>
</article>
<article class="excerpt excerpt-1" style="">
  <a class="focus" href="#" title="用DTcms做一个独立博客网站（响应式模板）" target="_blank" ><img class="thumb" data-original="images/12345.jpg" src="images/12345.jpg" alt="用DTcms做一个独立博客网站（响应式模板）"  style="display: inline;"></a>
		<header><a class="cat" href="#" title="MZ-NetBlog主题" >武汉市毒狼网吧<i></i></a>
			<h2><a href="RecruitmentDetailPage.html" title="用DTcms做一个独立博客网站（响应式模板）" target="_blank" >毒狼网吧打手持续招募中</a>
			</h2>
		</header>
		<p class="meta">
			<time class="time"><i class="glyphicon glyphicon-time"></i> 2016-10-14</time>
			<span class="views"><i class="glyphicon glyphicon-eye-open"></i> 216</span> <a class="comment" href="##comment" title="评论" target="_blank" ><i class="glyphicon glyphicon-comment"></i> 4</a>
		</p>
		<p class="note">用DTcms做一个独立博客网站（响应式模板），采用DTcms V4.0正式版（MSSQL）。开发环境：SQL2008R2+VS2010。DTcms V4.0正式版功能修复和优化：1、favicon.ico图标后台上传。（解决要换图标时要连FTP或者开服务器的麻烦）</p>
</article>
<article class="excerpt excerpt-1" style="">
  <a class="focus" href="#" title="用DTcms做一个独立博客网站（响应式模板）" target="_blank" ><img class="thumb" data-original="images/3.jpg" src="images/3.jpg" alt="用DTcms做一个独立博客网站（响应式模板）"  style="display: inline;"></a>
		<header><a class="cat" href="#" title="MZ-NetBlog主题" >武汉市毒狼网吧<i></i></a>
			<h2><a href="RecruitmentDetailPage.html" title="用DTcms做一个独立博客网站（响应式模板）" target="_blank" >毒狼网吧打手持续招募中</a>
			</h2>
		</header>
		<p class="meta">
			<time class="time"><i class="glyphicon glyphicon-time"></i> 2016-10-14</time>
			<span class="views"><i class="glyphicon glyphicon-eye-open"></i> 216</span> <a class="comment" href="##comment" title="评论" target="_blank" ><i class="glyphicon glyphicon-comment"></i> 4</a>
		</p>
		<p class="note">用DTcms做一个独立博客网站（响应式模板），采用DTcms V4.0正式版（MSSQL）。开发环境：SQL2008R2+VS2010。DTcms V4.0正式版功能修复和优化：1、favicon.ico图标后台上传。（解决要换图标时要连FTP或者开服务器的麻烦）</p>
</article>
<article class="excerpt excerpt-1" style="">
  <a class="focus" href="#" title="用DTcms做一个独立博客网站（响应式模板）" target="_blank" ><img class="thumb" data-original="images/3.jpg" src="images/3.jpg" alt="用DTcms做一个独立博客网站（响应式模板）"  style="display: inline;"></a>
		<header><a class="cat" href="#" title="MZ-NetBlog主题" >武汉市毒狼网吧<i></i></a>
			<h2><a href="RecruitmentDetailPage.html" title="用DTcms做一个独立博客网站（响应式模板）" target="_blank" >毒狼网吧打手持续招募中</a>
			</h2>
		</header>
		<p class="meta">
			<time class="time"><i class="glyphicon glyphicon-time"></i> 2016-10-14</time>
			<span class="views"><i class="glyphicon glyphicon-eye-open"></i> 216</span> <a class="comment" href="##comment" title="评论" target="_blank" ><i class="glyphicon glyphicon-comment"></i> 4</a>
		</p>
		<p class="note">用DTcms做一个独立博客网站（响应式模板），采用DTcms V4.0正式版（MSSQL）。开发环境：SQL2008R2+VS2010。DTcms V4.0正式版功能修复和优化：1、favicon.ico图标后台上传。（解决要换图标时要连FTP或者开服务器的麻烦）</p>
</article> -->
</section>
<footer class="footer">
<div class="container">
	<p>Copyright &copy; 2016.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
  </div>
<div id="gotop" style="display: block;"><a class="gotop" ></a>
</div>
</footer>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.ias.js"></script>
<script src="js/scripts.js"></script>
</body>
</html>