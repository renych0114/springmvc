<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="addUser.action" method="post"  enctype="multipart/form-data"   >
		<div>
			用户名：<input type="text" name="username">
		</div>
		<div>
			电话号码：<input type="text" name="phone">
		</div>
		<div>
			邮箱：<input type="text" name="email">
		</div>
		<div>
			出生日期：<input type="date" name="birthday">
		</div>
		<div>
			籍贯：
			<select name="p.proid"  >
				<option  value="-1">请选择</option>
				<option  value="0">辽宁省</option>
				<option  value="1">吉林省</option>
			</select>
		</div>
		<div>
			性别：
			<input type="radio" name="sex" value="男" >男
			<input type="radio" name="sex" value="女" >女
		</div>
		<div>
			文件上传：<input type="file" name="pic">
		</div>
		<div>
			<button  type="submit">提交</button>
		</div>
	</form>
</body>
</html>