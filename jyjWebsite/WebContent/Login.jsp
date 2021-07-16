<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World</title>
<link href="css/Inter.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function check() {
		var mana = $("#mana").val();
		if (!(mana.length > 0 & mana.length < 10)) {
			alert("姓名长度有误！必须是1-9位")
		} else {
			$("#formLogin").submit();
		}
	}
</script>
<script type="text/javascript">
	$(function() {
<%String error = (String) request.getAttribute("error");
if (error != null) {
	if (error.equals("LoginError")) {%>
	alert("用户名或密码错误");
<%} else if (error.equals("TimeError")) {%>
	alert("登录超时");
<%} else if (error.equals("DeleteError")) {%>
	alert("注销用户失败，请重新登录");
<%}
}
session.invalidate();%>
	});
</script>
</head>
<%
String username = "";
String password = "";
Cookie[] cookies = request.getCookies();
if (cookies != null) {
	for (int i = 0; i < cookies.length; i++) {
		if ("username".equals(cookies[i].getName())) {
	username = cookies[i].getValue();
		} else if ("password".equals(cookies[i].getName())) {
	password = cookies[i].getValue();
		}
	}
}
%>

<body>
	<div class="admin_login_wrap">
		<h1>Staff 登录</h1>
		<div class="adming_login_border">
			<div class="admin_input">
				<div class="admin_form">
					<form action="./LoginServlet" method="post" id="formLogin">
						<ul class="admin_items">
							<li><label for="mana">用户名：</label> <input type="text"
								name="managerName" id="mana" size="40" class="admin_input_style"
								value="<%=username%>" /></li>
							<li><label for="pwd">密码：</label> <input type="password"
								name="password" size="40" class="admin_input_style"
								value="<%=password%>" /></li>
						</ul>
						<input type="button" tabindex="3" value="登录"
							class="btn btn-primary" style="Margin: 3.333%; width: 40%"
							onclick="check()" /> <a href="./Regist.jsp" tabindex="3"
							class="btn btn-primary" style="Margin: 3.333%; width: 30%">注册</a><input
							class="admin_check" type="checkbox" name="tenDayAutoLoginFlag"
							value="ok"> 十天内免登录<br>
					</form>
				</div>
			</div>
		</div>
		<p class="admin_copyright">
			&copy; 2021 Powered by <a href="https://www.cnblogs.com/stu-jyj3621/"
				target="_blank">STU-JYJ3621</a>
		</p>
	</div>
</body>
</html>