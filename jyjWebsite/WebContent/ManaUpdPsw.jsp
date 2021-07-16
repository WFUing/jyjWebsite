<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jyj.entity.*"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>ManaUpdPsw</title>
<link rel="stylesheet" type="text/css" href="css/Inter.css" />
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<%!Boolean isError = true;
	String error = null;%>
<script type="text/javascript">
	$(function() {
<%Manager manager = (Manager) session.getAttribute("manager");
if (manager == null) {
	request.setAttribute("error", "TimeError");%>
	<jsp:forward page="Login.jsp"></jsp:forward>
<%}%>
	
<%isError = true;
error = (String) request.getAttribute("error");
if (error != null) {
	if (error.equals("IdError")) {%>
	alert("编号错误");
<%} else if (error.equals("PswError")) {%>
	alert("密码错误");
<%} else if (error.equals("EmailError")) {%>
	alert("邮箱错误");
<%} else if (error.equals("NoError")) {%>
	alert("请输入新密码");
<%isError = false;
} else if (error.equals("UpdateError")) {%>
	alert("更新失败");
<%}
}%>
	});
</script>
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
		}
	}
	function check1() {
		check();
		$("#formRegist").attr('action', "ManaUpdPswServlet");
		$("#formRegist").submit();
		console.log(
<%=isError%>
	);
	}
	function check2() {
<%if (error != "NoError") {%>
	alert("请先验证");
<%} else {
	error = null;%>
	check();
		$("#formRegist").attr('action', "ManaUpdPswServlet2");
		$("#formRegist").submit();
<%}%>
	}
</script>
</head>
<body>
	<div class="topbar-wrap white">
		<div class="topbar-inner clearfix">
			<div class="topbar-logo-wrap clearfix">
				<ul class="navbar-list clearfix">
					<li><a class="on" href="Index.jsp">首页</a></li>
					<li><a><%=manager.getManagerName()%>，欢迎您</a></li>
				</ul>
			</div>
			<div class="top-info-wrap">
				<ul class="top-info-list clearfix">
					<li><a href="./ManaUpdPsw.jsp">修改密码</a></li>
					<li><a href="Login.jsp">退出</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container clearfix">
		<div class="sidebar-wrap">
			<div class="sidebar-title">
				<h1>菜单</h1>
			</div>
			<div class="sidebar-content">
				<ul class="sidebar-list">
					<li><a href="#"><i class="icon-font">&#xe018;</i>系统管理</a>
						<ul class="sub-menu">
							<li><a href="./ManaUpdPsw.jsp"><i class="icon-font">&#xe045;</i>修改此密码</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<div class="main-wrap">
			<div class="crumb-wrap">
				<div class="crumb-list">
					<i class="icon-font"></i><a href="Index.jsp">首页</a><span
						class="crumb-step">&gt;</span><span class="crumb-name">系统管理</span><span
						class="crumb-step">&gt;</span><span class="crumb-name">修改当前用户密码</span>
				</div>
			</div>
			<div class="search-wrap">
				<div class="admin_login_wrap"
					style="float: left; width: 40%; margin: 2% 30% 10% 10%;">
					<h2 align="center" style="font-size: 25px;">修改密码</h2>
					<p align="center" style="font-style: italic;">请先输入原信息验证，然后再更新密码</p>
					<br />
					<div class="adming_login_border">
						<div class="admin_input">
							<div class="admin_form">
								<form id="formRegist" method="post">
									<ul class="admin_items">
										<li><label for="user" style="float: left; width: 15%">用户名：</label>
											<input type="text" name="managername" id="user" size="40"
											class="admin_input_style" style="float: left; width: 80%"
											value="<%=manager.getManagerName()%>" readonly /><br /> <br /></li>
										<li><label for="password" style="float: left; width: 15%">密码：</label>
											<input type="text" name="password" id="pwd" size="40"
											class="admin_input_style" style="float: left; width: 80%"
											<%if (!isError) {%> value="<%=manager.getPassword()%>" <%}%> /><br />
											<br /></li>
										<li><label for="email" style="float: left; width: 15%">邮箱：</label>
											<input type="text" name="email" id="email" size="40"
											class="admin_input_style" style="float: left; width: 80%"
											<%if (!isError) {%> value="<%=manager.getEmail()%>" readonly
											<%}%> /><br /> <br /></li>
										<li><label for="id" style="float: left; width: 15%">编号：</label>
											<input type="text" name="id" id="id" size="40"
											class="admin_input_style" style="float: left; width: 80%"
											<%if (!isError) {%> value="<%=manager.getId()%>" readonly
											<%}%> /><br /></li>
									</ul>
									<input type="button" tabindex="3" value="验证"
										class="btn btn-primary btn-primary2" onclick="check1()"
										style="width: 40%; margin: 5%; float: left;" /> <input
										type="button" tabindex="3" value="修改密码"
										class="btn btn-primary btn-primary2"
										style="width: 40%; margin: 5%; float: left;"
										onclick="check2()" />
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>