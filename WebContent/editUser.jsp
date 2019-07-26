<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="update.action"  method="post"  >
		<div>
			用户名：<input type="text" value="${user.username}">
		</div>
		<div>
			电话号码：<input type="text" value="${user.phone}">
		</div>
		<div>
			邮箱：<input type="text" value="${user.email}">
		</div>
		<div>
			<button  type="submit">提交</button>
		</div>
	</form>
</body>
</html>