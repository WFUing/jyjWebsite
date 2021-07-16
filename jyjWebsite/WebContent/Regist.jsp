<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="content-type" content="text/html; charset=UTF-8">
<title>Good Day</title>
<link href="css/Inter.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function check() {
		var user = $("#user").val();
		var pwd = $("#pwd").val();
		var email = $('#email').val();
		var id = $('#id').val();
		if (!(user.length > 0 & user.length < 10)) {
			alert("姓名长度有误！必须是1-9位")
		} else if (!(pwd.length > 0 & pwd.length < 25)) {
			alert("密码长度有误！必须是1-24位")
		} else if (!(email.length > 0 & email.length < 32)) {
			alert("邮箱长度有误！必须是1-31位")
		} else if (!(parseInt(id) > 0 & parseInt(id) < 100)) {
			alert("编号大小有误！必须是1-99的数值")
			console.log(parseInt(id));
			console.log(parseInt(id) > 0);
		} else {
			$("#formRegist").submit();
		}
	}
	//刷新验证码
	function changeImg(obj, createTypeFlag) {
		document.getElementById(obj.id).src = "${pageContext.request.contextPath}/DrawImageServlet?createTypeFlag="
				+ createTypeFlag + "&" + Math.random();
	}
</script>
<script type="text/javascript">
	$(function() {
<%String error = (String) request.getAttribute("error");
if (error != null) {
	if (error.equals("ReIdError")) {%>
	alert("该序号已经被注册");
<%} else if (error.equals("ReNameError")) {%>
	alert("该用户名已经被注册");
<%} else if (error.equals("AddError")) {%>
	alert("注册失败");
<%} else if (error.equals("ImageError")) {%>
	alert("验证码输入错误");
<%}
}
session.invalidate();%>
	});
</script>
</head>
<body>
	<div class="admin_login_wrap" style="width: 450px; margin: 50px auto 0">
		<h1>注册</h1>
		<div class="adming_login_border">
			<div class="admin_input">
				<div class="admin_form">
					<form id="formRegist" action="./RegistServlet" method="post">
						<ul class="admin_items">
							<li><label for="user" style="float: left; width: 15%">用户名：</label>
								<input type="text" name="managername" id="user" size="40"
								class="admin_input_style" style="float: left; width: 80%" /><br />
								<br /></li>

							<li><label for="password" style="float: left; width: 15%">密码：</label>
								<input type="text" name="password" id="pwd" size="40"
								class="admin_input_style" style="float: left; width: 80%" /><br />
								<br /></li>
							<li><label for="email" style="float: left; width: 15%">邮箱：</label>
								<input type="text" name="email" id="email" size="40"
								class="admin_input_style" style="float: left; width: 80%" /><br />
								<br /></li>
							<li><label for="id" style="float: left; width: 15%">编号：</label>
								<input type="text" name="id" id="id" size="40"
								class="admin_input_style" style="float: left; width: 80%" /><br />
								<br /></li>
							<li><label for="Image" style="float: left; width: 15%">验证码：</label>
								<input type="text" name="validateCode" id="id" size="40"
								class="admin_input_style"
								style="float: left; width: 40%; margin-right: 5%;" /> <img
								alt="验证码看不清，换一张"
								src="${pageContext.request.contextPath}/DrawImageServlet"
								id="validateCodeImg" onclick="changeImg(this,'nl')"> <br />
							</li>
						</ul>
						<input type="button" tabindex="3" value="注册"
							class="btn btn-primary btn-primary2" onclick="check()" />
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