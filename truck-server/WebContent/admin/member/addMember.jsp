<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style>
div {
	width: 97%;
	margin: 0 auto;
}

h1 {
	background: #090;
	font-size: 16px;
	color: #fff;
	height: 23px;
	padding-left: 9px;
	margin-top: 0px;
	padding-top: 6px;
	border: #ccc 1px solid;
}

textarea {
	width: 620px;
	height: 150px;
	margin-left: 8%;
	margin-bottom: 20px;
}

input {
	margin-right: 5%;
	width: 250px;
}

form {
	margin-left: 8%;
}

.submit {
	width: 60px;
}

.hand {
	margin-left: 30%;
	margin-top: 40px;
}
</style>
<script type="text/javascript">
	function LTrim(str) {
		var i;
		for(i=0; i<str.length; i++) {
			if(str.charAt(i)!=" ") break;
		}
		str = str.substring(i,str.length);
		return str;
	}
	
	function RTrim(str) {
		var i;
		for(i=str.length-1; i>=0; i--) {
			if(str.charAt(i) != " ") break;
		}
		str = str.substring(0, i+1);
		return str;
	}
	
	function Trim(str) {
		return LTrim(RTrim(str));
	}
	
	function check() {
		if(Trim(document.myform.name.value) == "") {
			alert("请输入用户名!");
			document.myform.name.focus();
			return false;
		}
		if(Trim(document.myform.name.value).length>10) {
			alert("用户名最多只能输入10个字!");
			document.myform.name.focus();
			return false;
		}
		if(Trim(document.myform.password.value) == "") {
			alert("请输入密码!");
			document.myform.password.focus();
			return false;
		}
		if(Trim(document.myform.password.value).length>16) {
			alert("密码最多只能输入16位!");
			document.myform.password.focus();
			return false;
		}
		return true;
	}

</script>
</head>

<body>
	<div
		style="border: #ccc 1px solid; background: url(../images/tbg.jpg);">
		<h1>添加管理员</h1>
		<div>
			<form method="post" name="myform" onsubmit="return check()"
				action="<%=basePath%>member.do">
				<input type="hidden" name="method" value="addMember" />
				<p>
					<img src="<%=basePath%>admin/images/to.gif" />用户名: <input
						type="text" size="20" name="name" /><img
						src="<%=basePath%>admin/images/to.gif" /> 密 码 :&nbsp<input
						type="password" size="20" name="password" />
				</p>
				<p class="hand">
					<input type="submit" value="添加" name="add" class="submit" /><input
						type="reset" value="重置" name="rnew" class="submit" />
				</p>
			</form>
		</div>
	</div>
	<c:choose>
		<c:when test="${result eq null }">
		</c:when>
		<c:otherwise>
			<script>
 		alert("${result}");
 	</script>
		</c:otherwise>
	</c:choose>
</body>
</html>
