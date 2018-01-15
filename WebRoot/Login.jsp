<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登录威子哥人才市场</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Eminent Login Form Widget Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/style3.css" rel='stylesheet' type='text/css' media="all" />
</head>
<body>
<h1>登录</h1>
<div class="form-w3ls">
    <ul class="tab-group cl-effect-4">
        <li class="tab active"><a href="#signin-agile">个人用户登录</a></li>
		<li class="tab"><a href="#signup-agile">企业用户登录</a></li>
    </ul>
    <div class="tab-content">
        <div id="signin-agile">
			<form action="Login" method="post">
				<p class="header">用户名</p>
				<input type="text" name="name" value="请输入用户名" onfocus="if(this.value=='请输入用户名'){this.value = ''};" onblur="if (this.value == '') {this.value = '请输入用户名';}">
				<p class="header">密码</p>
				<input type="password" name="password" value="111111" onfocus="if(this.value=='111111'){this.value = ''};" onblur="if (this.value == '') {this.value = '111111';}">
				<input type="text" name="identity" hidden="true" value="customer">
				<%if(request.getAttribute("msg")!=null){ %>
					<font color="red"><%=request.getAttribute("msg") %></font>
				<%} %>
				<input type="submit" class="sign-in" value="个人登录">
				<a href="Register.html"> 注册?</a>
				<a href="underconstraction">忘记密码?</a>
			</form>
		</div>
		<div id="signup-agile">
			<form action="Login" method="post">
				<p class="header">用户名</p>
				<input type="text" name="name" value="请输入用户名" onfocus="if(this.value=='请输入用户名'){this.value = ''};" onblur="if (this.value == '') {this.value = '请输入用户名';}">
				<p class="header">密码</p>
				<input type="password" name="password" value="111111" onfocus="if(this.value=='111111'){this.value = ''};" onblur="if (this.value == '') {this.value = '111111';}">
				<input type="text" name="identity" hidden="true" value="enterprise">
				<%//if(request.getAttribute("msg")!=null){ %>
					<font color="red"><%=request.getAttribute("msg") %></font>
				<%//} %>
				<input type="submit" class="register" value="企业登录">
				<a href="Register.html">注册?</a>
				<a href="#">忘记密码?</a>
			</form>
		</div> 
    </div><!-- tab-content -->
</div> <!-- /form -->
<p class="copyright">© 2018 登录界面. All Rights Reserved | 威子哥人才市场</p>
<!-- js files -->
<script src='js/jquery.min.js'></script>
<script src="js/index.js"></script>
<!-- /js files -->
</body>
</html>
