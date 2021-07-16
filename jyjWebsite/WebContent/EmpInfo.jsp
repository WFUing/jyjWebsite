<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jyj.entity.*"%>
<%@ page import="jyj.dao.*"%>
<%@ page import="java.util.*"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>IndexPage</title>
<link rel="stylesheet" type="text/css" href="css/Inter.css" />
<link rel="stylesheet" type="text/css" href="css/dateTime.css" />
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/dateTime.min.js"></script>
<%!Manager manager = null;%>
<script type="text/javascript">
	$(function() {
<%manager = (Manager) session.getAttribute("manager");
if (manager == null) {
	request.setAttribute("error", "TimeError");%>
	<jsp:forward page="Login.jsp"></jsp:forward>
<%}%>
	});

	function check() {
		var empNo = $("#empNo").val();
		var name = $("#name").val();
		if (!(name.length > 0 & name.length < 16)) {
			alert("姓名长度有误！必须是1-15位字符")
		} else if (!(parseInt(empNo) > 0 & parseInt(empNo) < 100)) {
			alert("编号大小有误！必须是1-99的数值")
		} else {
			$("#formRegist").submit();
		}
	}
</script>
</head>
<body>
	<%
	Employee employee = (Employee) request.getAttribute("employee");
	Date birthDate = employee.getBirthDay();
	Date hireDate = employee.getHireDate();
	Calendar cal = Calendar.getInstance();
	%>
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
	<div class="container clearfix" style="font-size:14px">
		<div class="sidebar-wrap">
			<div class="sidebar-title">
				<h1>菜单</h1>
			</div>
			<div class="sidebar-content">
				<ul class="sidebar-list">
					<li><a href="#"><i class="icon-font">&#xe017;</i>常用操作</a>
						<ul class="sub-menu">
							<li><a href="EmpIndex.jsp"><i class="icon-font">&#xe003;</i>员工信息</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<div class="main-wrap">
			<div class="crumb-wrap">
				<div class="crumb-list">
					<i class="icon-font"></i><a href="/jscss/admin">首页</a><span
						class="crumb-step">&gt;</span><span class="crumb-name">常用操作</span><span
						class="crumb-step">&gt;</span><span class="crumb-name">员工信息</span>
				</div>
			</div>
			<div class="search-wrap">
				<div class="admin_login_wrap"
					style="float: left; width: 40%; margin: 2% 30% 10% 10%;">
					<h2 align="center" style="font-size: 25px;"><%=employee.getName()%>的信息
					</h2>
					<div class="admin_login_wrap"
						style="width: 450px; margin: 20px auto 0">
						<div class="adming_login_border">
							<div class="admin_input">
								<div class="admin_form">
									<form id="formRegist" action="./EmpUpdInfoServlet" method="post">
										<ul class="admin_items">
											<li><label for="empNo"
												style="float: left; width: 15%; margin-left: 10%">编号：</label>
												<input type="text" name="empNo" id="empNo" size="40"
												class="admin_input_style" style="float: left; width: 70%"
												value="<%=employee.getEmpNo()%>" /><br /> <br /></li>
											<li><label for="name"
												style="float: left; width: 15%; margin-left: 10%">姓名：</label>
												<input type="text" name="name" id="name" size="40"
												class="admin_input_style" style="float: left; width: 70%"
												value="<%=employee.getName()%>" /><br /> <br /></li>
											<li><label for="gender"
												style="float: left; width: 35%; margin-left: 10%">性别：</label>
												<select name="gender" id="gender">
													<option value="M"
														<%if (employee.getGender().equals("M")) {%>
														selected="selected" <%}%>>男</option>
													<option value="F"
														<%if (employee.getGender().equals("F")) {%>
														selected="selected" <%}%>>女</option>
											</select> <br /> <br /></li>
											<li><label for="birthDate"
												style="float: left; width: 35%; margin-left: 10%">生日：</label>
												<input type="text" class="admin_input_style"
												style="float: left; width: 40%" placeholder="请选择日期"
												id="birthdate" name="birthday" value="<%=birthDate%>" /> <br />
												<br /></li>
											<li><label for="hireDate"
												style="float: left; width: 35%; margin-left: 10%">入职时间：</label>
												<input type="text" class="admin_input_style"
												style="float: left; width: 40%" placeholder="请选择日期"
												id="hiredate" name="hireday" value="<%=hireDate%>" /> <br />
												<br /></li>
										</ul>
										<div style="margin: 0 auto">
											<input type="button" tabindex="3" value="修改员工信息"
												class="btn btn-primary btn-primary2" onclick="check()" />
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
					<script type="text/javascript">
						
					<%cal.setTime(birthDate);%>
						$("#birthdate")
								.datetime(
										{
											type : "date",
											value : [
					<%=cal.get(Calendar.YEAR)%>
						,
					<%=cal.get(Calendar.MONTH) + 1%>
						,
					<%=cal.get(Calendar.DAY_OF_MONTH)%>
						],
											success : function(res) {
												console.log(res)
											}
										})
					<%cal.setTime(hireDate);%>
						$("#hiredate")
								.datetime(
										{
											type : "date",
											value : [
					<%=cal.get(Calendar.YEAR)%>
						,
					<%=cal.get(Calendar.MONTH) + 1%>
						,
					<%=cal.get(Calendar.DAY_OF_MONTH)%>
						],
											success : function(res) {
												console.log(res)
											}
										})
					</script>
				</div>
			</div>
		</div>

	</div>
</body>
</html>