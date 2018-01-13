<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>人才市场用户注册界面</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="Eminent Login Form Widget Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- font files -->
<!--<link href='//fonts.googleapis.com/css?family=Raleway:400,100,200,300,500,600,700,800,900' rel='stylesheet' type='text/css'>-->
<!--<link href='//fonts.googleapis.com/css?family=Poiret+One' rel='stylesheet' type='text/css'>-->
<!-- /font files -->
<!-- css files -->
<link href="css/style3.css" rel='stylesheet' type='text/css' media="all" />
<!-- /css files -->
</head>
<body>
<h1>注册</h1>
<div class="form-w3ls">
    <ul class="tab-group cl-effect-4">
        <li class="tab active"><a href="#signin-agile">个人用户注册</a></li>
		<li class="tab"><a href="#signup-agile">企业用户注册</a></li>        
    </ul>
    <div class="tab-content">
        <div id="signin-agile">   
			<form action="Register" method="post">
				
				<p class="header">用户名</p>
				<input type="text" name="customerName" value="Your Full Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Your Full Name';}">
				<p class="header">电话号码</p>
				<input type="text" name="tel" value="Your Phone Number" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Your Phone Number';}">
				<p class="header">邮箱</p>
				<input type="text" name="mail" value="Email@address.com" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email@address.com';}">
				<p class="header">密码</p>
				<input type="password" name="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
				<p class="header">确认密码</p>
				<input type="password" name="rePassword" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
				<input type="text" name="identity" hidden="true" value="customer">
				<input type="submit" class="sign-in" value="注册">
			</form>
		</div>
		<div id="signup-agile">   
			<form action="#" method="post">
				
				<p class="header">用户名</p>
				<input type="text" name="userName" value="Your Full Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Your Full Name';}">
				
				<p class="header">企业名</p>
				<input type="text" name="enterpriseName" value="Your Full Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Your Full Name';}">
				
				<p class="header">电话号码</p>
				<input type="tel" name="tel" value="Your Phone Number" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Your Phone Number';}">
				
				<p class="header">邮箱</p>
				<input type="email" name="mail" value="Email@address.com" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email@address.com';}">
				
				<p class="header">密码</p>
				<input type="password" name="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
				
				<p class="header">确认密码</p>
				<input type="password" name="rePassword" value="Confirm Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Confirm Password';}">
				<input type="text" name="identity" hidden="true" value="enterprise">
				<input type="submit" class="register" value="Register">
			</form>
		</div> 
    </div><!-- tab-content -->
</div> <!-- /form -->	  
<p class="copyright">© 2016 用户注册界面. All Rights Reserved | Design by 人才市场</p>
<!-- js files -->
<script src='js/jquery.min.js'></script>
<script src="js/index.js"></script>
<!-- /js files -->
</body>

</html>
