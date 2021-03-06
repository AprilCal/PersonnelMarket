<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>招聘信息发布</title>
    <link href="css/demo.css" rel="stylesheet" type="text/css">
    <!--Framework-->
    <script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
    <script src="js/jquery-ui.js" type="text/javascript"></script>
    <!--End Framework-->
    <script src="js/jquery.ffform.js" type="text/javascript"></script>
<script language="JavaScript" type="text/javascript">  
   //定义了城市的二维数组，里面的顺序跟省份的顺序是相同的。通过selectedIndex获得省份的下标值来得到相应的城市数组  
              var city=[  
           ["北京","天津","上海","重庆"],  
           ["南京","苏州","南通","常州"],  
           ["福州","福安","龙岩","南平"],  
           ["广州","潮阳","潮州","澄海"],  
           ["兰州","白银","定西","敦煌"]  
             ];  
             var pos=[  
                    ["java","PHP","C++","Android"],  
                    ["产品总监","产品经理","研发助理","项目经理"],  
                    ["UI设计师","交互设计","网页设计师","后台工程师"],  
                    ["新媒体运营","编辑","数据运营","澄海"],  
                    ["市场推广","市场总监","市场运营","市场维护"],
                    ["HR","行政","财务","审计"],
                    ["投资","融资","并购","风控"]  
                    ];  
             function getPos(){  
        	     //获得省份下拉框的对象  
        	     var sltProvince=document.form1.department;  
        	     //获得城市下拉框的对象  
        	     var sltCity=document.form1.position;       
        	     //得到对应省份的城市数组  
        	     var provinceCity=pos[sltProvince.selectedIndex - 1];  
        	     //清空城市下拉框，仅留提示选项  
        	     sltCity.length=1;  
        	     //将城市数组中的值填充到城市下拉框中  
        	     for(var i=0;i<provinceCity.length;i++){  
        	       sltCity[i+1]=new Option(provinceCity[i],provinceCity[i]);  
        	     }  
        	   }  
             function getCity(){  
                 //获得省份下拉框的对象  
                 var sltProvince=document.form1.province;  
                 //获得城市下拉框的对象  
                 var sltCity=document.form1.city;       
                 //得到对应省份的城市数组  
                 var provinceCity=city[sltProvince.selectedIndex - 1];  
                 //清空城市下拉框，仅留提示选项  
                 sltCity.length=1;  
                 //将城市数组中的值填充到城市下拉框中  
                 for(var i=0;i<provinceCity.length;i++){  
                   sltCity[i+1]=new Option(provinceCity[i],provinceCity[i]);  
                 }  
               }  
</script>  

</head>
<body>
<section id="getintouch" >
<div class="container" style="border-bottom: 0;">
	<h1><span>请输入发布所需信息!</span></h1>
</div>
<div class="container">
<form method=post action="Release" name="form1">
	<div class="row clearfix">
		<div class="lbl">
			<label for="email"> 招聘职位</label>
		</div>
		<div class="ctrl">
				<select name="department" onChange="getPos()">
					<option value="0">请选择职位大类</option>
					<option value="技术">技术</option>
					<option value="产品">产品</option>
					<option value="设计">设计</option>
					<option value="运营">运营</option>
					<option value="市场与营销">市场与营销</option>
					<option value="职能">职能</option>
					<option value="金融">金融</option>
				</select>
				<select name="position">
					<option value="0">请选择岗位</option>
				</select>
		</div>
	</div>
    <div class="row clearfix">  
		<div class="lbl">
 			<label for="email">所在城市</label>
		</div>
		<div class="ctrl">
			<select name="province" onChange="getCity()">
				<option value="0">请选择省份</option>
				<option value="直辖市">直辖市</option>
				<option value="江苏">江苏</option>
				<option value="福建">福建</option>
				<option value="广东">广东</option>
				<option value="甘肃">甘肃</option>
			</select>
			<select name="city">
				<option value="0">请选择城市</option>
			</select>
		</div>
	</div>
	<div class="row clearfix">
		<div class="lbl">
			<label for="name">招聘标题</label>
		</div>
		<div class="ctrl">
			<input type="text" input style="width:590px" id="name" name="title" data-required="true" data-validation="text" data-msg="Invalid Name" placeholder="Ex: 算法工程师，GM，hr招聘">
		</div>
	</div>
            
		<div class="row clearfix">
			<div class="lbl">
				<label for="email">职位描述</label>
			</div>
			<div class="ctrl">
				<textarea id="message" name="positionDescription" rows="5" cols="82"></textarea>
			</div>
		</div>
		<div class="row clearfix">
			<div class="lbl">
				<label for="subject">薪水范围</label>
			</div>
			<div class="ctrl">
				<input type="text" name="salary_low" id="subject"  input style="width:100px"  placeholder="Ex:薪水下限"> <span>-------</span>
				<input type="text" name="salary_high" id="subject" input style="width:100px"  placeholder="Ex:薪水上限">		                     
			</div>
		</div>
		<div class="row clearfix">
			<div class="lbl">
				<label for="message">技术栈</label>
			</div>
			<div class="ctrl">
				<textarea id="message" name="techStack" rows="5" cols="82"></textarea>
			</div>
		</div>
		<div class="row clearfix">
			<div class="lbl">
				<label for="message">岗位要求</label>
			</div>
			<div class="ctrl">
				<textarea id="message" name="positionRequirement" rows="5" cols="82"></textarea>
			</div>
		</div>
		<div class="row  clearfix">
			<div class="span10 offset2">
				<input type="submit" name="submit" id="submit" class="submit" style="margin-left:250px; margin-top:20px" value="发布招聘">
			</div>
		</div>
</form>
</div>
</section>
</body>
</html>

