 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
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
table{
	width:97%;
	margin:0 auto;
}
a{
	text-decoration:none;
	color:#000;
}
a:hover{
	color:red;
}
td{
	font-size:13px;
	text-align:center;
	color:#333;
	height:20px;
}
.bt{
    background:#090;  
    color:#fff;
    height:20px; 
    padding:4px 0px;
    font-size:16px;
   }
th{
	font-size:15px;
	height:20px;
}
li{
	list-style:none;
	float:left;
	margin-left:5px;
}
ul{
	float:right;
	margin-right:2%;}
a.num{
	color:#030;
	font-size:13px;
	text-decoration:underline;
}
a.num:hover{
	text-decoration:none;
	color:#0C0;}

</style>
<script type="text/javascript">
function confirmd() {  
            var msg = "您真的确定要删除吗？请确认！";  
            if (confirm(msg)==true){  
                return true;  
            }else{  
                return false;  
            }  
        }  
</script>
</head>
<body>
<table border="1"  cellpadding="0" cellspacing="0">
  <tr>
    <th class="bt" scope="col" colspan="3" >管理员列表</th>
  </tr>
  <tr>
    <th>用户名</th>
    <th>创建时间</th>
    <th>操作</th>
  </tr>
  <c:forEach items="${members}" var="member"> 
  <tr>
    <td>${member.mname }</td>
    <td>${member.pdate }</td>
    <td>    
	<a href="member.do?method=updateMemberBefore&id=${member.id }">【修改】</a>
	<a href="member.do?method=deleteMember&id=${member.id }" onclick="return confirmd()" >【删除】</a>	

    </td>   
  </tr>
  </c:forEach>
</table>
<pg:pager url="${basePath}member.do" items="${totalRecord}"
						export="currentPageNumber=pageNumber" maxPageItems="10">
		<pg:param name="method" value="memberList" />
<span class="num">共${totalRecord }条纪录,每页10条</span>
<ul>
<li>
<pg:first><a href="${pageUrl }" class="num">[首页]</a></pg:first>
</li>
<li>
<pg:prev><a href="${pageUrl }" class="num">[上一页]</a></pg:prev>
</li>
<li>
<pg:pages>
<c:choose>
	<c:when test="${currentPageNumber eq pageNumber}">
		<font color="red" style="font-size: 14px">${pageNumber}</font>
	</c:when>
	<c:otherwise>
		<a href="${pageUrl }" style="font-size: 14px">${pageNumber}</a>
	</c:otherwise>
</c:choose>
</pg:pages>
</li>
<li>
<pg:next><a href="${pageUrl }" class="num">[下一页]</a></pg:next>
</li>
<li>
<pg:last><a href="${pageUrl }" class="num">[末页]</a></pg:last>
</li>
</ul>
</pg:pager>
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
