<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style>
body{
	background:#f1f1f1;
}
h1{
	background:#090;
	color:#fff;
	font-size:16px;
	padding:5px;
	width:97%;
}
</style>
</head>

<body bgcolor="#fef4d9" onload=initiate()>
<h1>欢迎界面</h1>
<p id="one"></p>
<p id="two"></p>
<script type="text/javascript">
var browser=navigator.appName  
if(browser!="Microsoft Internet Explorer"){
	document.write('<p style="color:green; font-size:20px; font-family:微软雅黑; text-align:center; margin:0 auto;">'+"欢迎登录郑州西亚斯国际学院教务在线后台管理系统。"+'<br/>'+"感谢您的使用，祝你使用愉快！！"+'</P>')
}

var message= new Array()

message[0]="欢迎登录郑州西亚斯国际学院—教务在线后台管理系统。"+'<br/>'+"感谢您的使用，祝你使用愉快！！";

message[1]="欢迎登录郑州西亚斯国际学院教务在线后台管理系统。"+'<br/>'+"感谢您的使用，祝你使用愉快！！";

var scrollerwidth=300;

var scrollertop=100;

var scrollerleft=350;

var targetlink="_blank";
var font_face="微软雅黑";
var font_color="green";
var font_size=16;

var standstill=3000;

var lineheightmax=15
var lineheight=lineheightmax
var linestep=0.2
var i_message=0
var mes_joined
var mes_split
var contenttext
var pause=20

function initiate() {
	if (document.all) {
		document.all.scrollertext.style.posTop=scrollertop
		document.all.scrollertext.style.posLeft=scrollerleft
		document.all.scrollertext.style.width=scrollerwidth
		lineup()
	}
	if (document.layers) {
		alert("This script works with Internet Explorer 4x or higher. Sorry Netscape-Folks!")
	}
}

function lineup(){
	mes_joined=message[i_message]
	mes_split=mes_joined.split("|")
	
	contenttext="<span style='position:relative;font-family:"+font_face+"; color:"+font_color+";font-size:"+font_size+"pt;line-height:"+lineheight+";width:"+scrollerwidth+"px'>"
	contenttext+=mes_split[0]
	contenttext+="</span>"
	
	if (lineheight>1.2) {
		scrollertext.innerHTML=contenttext
		var timer=setTimeout("lineup()",pause)
		lineheight-=linestep
	}
	else {
		mes_joined=message[i_message]
		mes_split=mes_joined.split("|")
		contenttext="<span style='position:relative;font-family:"+font_face+"; color:"+font_color+";font-size:"+font_size+"pt;line-height:"+lineheight+";width:"+scrollerwidth+"px'>"
		contenttext+=mes_split[0]
		contenttext+="</span>"
		scrollertext.innerHTML=contenttext
		clearTimeout(timer)
		var timer=setTimeout("squeeze()",standstill)
	}
}

function squeeze(){
	mes_joined=message[i_message]
	mes_split=mes_joined.split("|")
	contenttext="<span style='position:relative;font-family:"+font_face+"; color:"+font_color+";font-size:"+font_size+"pt;line-height:"+lineheight+";width:"+scrollerwidth+"px'>"
	contenttext+=mes_split[0]
	contenttext+="</span>"

	if (lineheight>0) {
		scrollertext.innerHTML=contenttext
		var timer=setTimeout("squeeze()",pause)
		lineheight-=linestep/2
	}
	else {
		clearTimeout(timer)
		scrollertext.innerHTML=""
		changemessage()
	}
}

function changemessage() {
	i_message++
	if (i_message>message.length-1) {i_message=0}
	lineheight=lineheightmax
	var timer=setTimeout("lineup()",1000)
}
</script>
<div id=scrollertext style="POSITION: absolute"></div>
</body>

</html>
