<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>登陆</title>
	</head>
	<body>


		<form action="${pageContext.request.contextPath}/login.do">
			<!--<input /> 如果就是一个这样的，其实系统默认给我们加了一个type="text"
				type="text" 文本输入框
			-->
			用户名：<input  type="text" name="userName"/>
			<br>
			<!--type="password"密码输入框 -->
			密码：<input  type="password" name="pwd"/>
			<br>
			<!--type="submit" 提交按钮 当我们一点会找到form  action=""-->
			<input type="submit"  value="登陆jsp" />

		</form>

	</body>
</html>
