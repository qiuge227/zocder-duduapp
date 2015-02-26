<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	height: 26px;
	padding-left: 9px;
	margin-top: 0px;
	padding-top: 7px;
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
<script>
	function LTrim(str) {
		var i;
		for (i = 0; i < str.length; i++) {
			if (str.charAt(i) != " ")
				break;
		}
		str = str.substring(i, str.length);
		return str;
	}

	function RTrim(str) {
		var i;
		for (i = str.length - 1; i >= 0; i--) {
			if (str.charAt(i) != " ")
				break;
		}
		str = str.substring(0, i + 1);
		return str;
	}

	function Trim(str) {
		return LTrim(RTrim(str));
	}

	function check() {
		if (Trim(document.myform.name.value) == "") {
			alert("请输入用户名!");
			document.myform.name.focus();
			return false;
		}
		if (Trim(document.myform.name.value).length > 10) {
			alert("用户名最多只能输入10个字!");
			document.myform.name.focus();
			return false;
		}
		if (Trim(document.myform.phone.value) == "") {
			alert("请输入手机号!");
			document.myform.phone.focus();
			return false;
		}
		if (Trim(document.myform.number.value) == "") {
			alert("请输入车牌号!");
			document.myform.number.focus();
			return false;
		}
		if (Trim(document.myform.truckType.value) == "") {
			alert("请输入车型号!");
			document.myform.truckType.focus();
			return false;
		}
		if (Trim(document.myform.totalWeight.value) == "") {
			alert("请输入载重!");
			document.myform.totalWeight.focus();
			return false;
		}
		return true;
	}
</script>
</head>

<body>
	<div
		style="border: #ccc 1px solid; background: url(../images/tbg.jpg);">
		<h1>修改嘟嘟司机信息列表</h1>
		<div>
			<form method="post" name="myform" onsubmit="return check()"
				action="<%=basePath%>driverInfo.do">
				<input type="hidden" name="method" value="updateDriverInfo" /> <input
					type="hidden" name="id" value="${driverInfo.phone}" />
				<p>
					<img src="${basePath}admin/images/to.gif" />用户名: <input
						type="text" size="20" name="name" value="${driverInfo.name}" />
				</P>
				<p>
					<img src="${basePath}admin/images/to.gif" />电话号码 : <input
						type="text" size="20" name="phone" value="${driverInfo.phone}" />
				</p>
				<p>
					<img src="${basePath}admin/images/to.gif" />车牌号 : <input
						type="text" size="20" name="number" value="${driverInfo.number}" />
				</p>
				<p>
					<img src="${basePath}admin/images/to.gif" />车型 : <input
						type="text" size="20" name="truckType"
						value="${driverInfo.truckType}" />
				</p>
				<p>
					<img src="${basePath}admin/images/to.gif" />载重 : <input
						type="text" size="20" name="totalWeight"
						value="${driverInfo.totalWeight}" />
				</p>
				<p class="hand">
					<input type="submit" value="修改" name="add" class="submit" /><input
						type="reset" value="重置" name="rnew" class="submit" />
				</p>
			</form>
		</div>
	</div>
</body>
</html>
