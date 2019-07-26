<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.2.0.min.js" ></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#sel").click(function(){
			window.location.href="select.action?uid=1&flag=select";
		});
		
		$("#export").click(function(){
			window.location.href="export.action";
		});
		
		$("#delete").click(function(){
			$("#f1").submit();
		});
		
	});

</script>
</head>
<body>
	<button type="button" id="sel" >查询</button>
	<form action="delete.action" id="f1" method="post"  >
	<table    >
		<tr>
			<th></th>
			<th>用户名</th>
			<th>电话号码</th>
			<th>邮箱</th>
			<th>编辑</th>
		</tr>
		<c:forEach items="${resultList}"  var="user"  >
			<tr>
				<th>
					<input type="checkbox"  name="userid" value="${user.userid}"  >
				</th>
				<th>${user.username}</th>
				<th>${user.age}</th>
				<th>${user.birthday}</th>
				<th>
					<a href="edit.action"  >编辑</a>
				</th>
			</tr>
		</c:forEach>
	</table>
	</form>
	<button  type="button" id="delete" >删除</button>
	<button  type="button" id="export" >导出</button>
</body>
</html>