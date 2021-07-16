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
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<%!Manager manager = null;%>
<script type="text/javascript">
	$(function() {
<%Page p = (Page) request.getAttribute("p");
manager = (Manager) session.getAttribute("manager");
if (manager == null) {
	request.setAttribute("error", "TimeError");%>
	<jsp:forward page="Login.jsp"></jsp:forward>
<%}
String error = (String) session.getAttribute("error");
if (error != null) {
	if (error.equals("ReIdError")) {%>
	alert("该序号已经被注册");
<%} else if (error.equals("AddError")) {%>
	alert("注册失败");
<%}
}
session.setAttribute("error", "");
error = (String) request.getAttribute("error");
if (error != null) {
if (error.equals("DeleteError")) {%>
	alert("删除失败");
<%} else if (error.equals("UpdError")) {%>
	alert("更新员工信息失败");
<%}
}%>
	});

	function Add(url) {
		var winObj = window.open(url, '增加员工',
				'height=600, width=500, top=200, left=200');
		var loop = setInterval(function() {
			if (winObj.closed) {
				clearInterval(loop);
				parent.location.reload();
			}
		}, 1);
	};
	function test(num) {
		var rex = /^[0-9]+$/;
		var flag = rex.test(num);
		if (!flag) {
			alert("请输入数字");
		}

	};
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
					<li><a href="#"><i class="icon-font">&#xe017;</i>常用操作</a>
						<ul class="sub-menu">
							<li><a href="EmpQueryByPageServlet?curPage=1"><i class="icon-font">&#xe003;</i>员工列表</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<div class="main-wrap">
			<div class="crumb-wrap">
				<div class="crumb-list">
					<i class="icon-font"></i><a href="/jscss/admin">首页</a><span
						class="crumb-step">&gt;</span><span class="crumb-name">常用操作</span><span
						class="crumb-step">&gt;</span><span class="crumb-name">员工列表</span>
				</div>
			</div>
			<div class="search-wrap">
				<div class="search-content">
					<form action="EmpQueryByPageServlet?curPage=<%=p.getCurPage()%>"
						method="Get">
						<table class="search-tab">
							<tr>
								<th width="70">每页条数</th>
								<td><input class="common-text" placeholder="分页操作"
									name="pageSize" id="pageSize" type="text"></td>
								<td><input class="btn btn-primary btn2" name="sub"
									value="输入" type="submit" onclick="test($('#pageSize').val())"></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
			<div class="result-wrap">
				<form name="myform" id="myform" method="post">
					<div class="result-title">
						<div class="result-list">
							<a onclick="Add('EmpAdd.jsp')"><i class="icon-font"></i>新增员工</a>
							<a id="batchDel" href="javascript:void(0)"><i
								class="icon-font"></i>批量删除</a>
						</div>
					</div>
					<div class="result-content">
						<table class="result-tab">
							<tr>
								<th class="tc" width="5%"><input class="allChoose" name=""
									type="checkbox"></th>
								<th style="text-align: center">排序</th>
								<th style="text-align: center">编号</th>
								<th style="text-align: center">姓名</th>
								<th style="text-align: center">性别</th>
								<th style="text-align: center">生日</th>
								<th style="text-align: center">入职时间</th>
								<th style="text-align: center">操作</th>
							</tr>
							<%
							List<Employee> employees = p.getEmployees();
							for (int i = 0; i < employees.size(); i++) {
							%><tr align="center">
								<td class="tc"><input name="id[]" value="59"
									type="checkbox"></td>
								<td><input name="ids[]" value="59" type="hidden"> <input
									class="common-input sort-input" name="ord[]" value="<%=i + 1%>"
									type="text"></td>
								<td><a
									href="QueryEmpByEmpNoServlet?EmpNo=<%=employees.get(i).getEmpNo()%>"><%=employees.get(i).getEmpNo()%></a></td>
								<td><%=employees.get(i).getName()%></td>
								<td><%=employees.get(i).getGender().equals("M") ? "男" : "女"%></td>
								<td><%=employees.get(i).getBirthDay()%></td>
								<td><%=employees.get(i).getHireDate()%></td>
								<td><a class="link-del"
									href="EmpDeleteServlet?EmpNo=<%=employees.get(i).getEmpNo()%>"
									onclick="if(confirm('确定删除该员工信息')==false)return false;">删除</a></td>
							</tr>
							<%
							}
							%>
						</table>
						<div class="list-page" style="float: left; margin-left: 7%">
							<%=p.getCurPage()%>/<%=p.getTotalPage()%>
							<a
								href="EmpQueryByPageServlet?curPage=1&pageSize=<%=p.getPageSize()%>">首页
							</a> <a
								href="EmpQueryByPageServlet?curPage=<%=p.getCurPage() - 1 > 0 ? p.getCurPage() - 1 : 1%>&pageSize=<%=p.getPageSize()%>">上一页
							</a> <a
								href="EmpQueryByPageServlet?curPage=<%=p.getCurPage() + 1 <= p.getTotalPage() ? p.getCurPage() + 1 : p.getTotalPage()%>&pageSize=<%=p.getPageSize()%>">下一页
							</a> <a
								href="EmpQueryByPageServlet?curPage=<%=p.getTotalPage()%>&pageSize=<%=p.getPageSize()%>">尾页
							</a>

						</div>
					</div>
				</form>
			</div>
		</div>
		<!--/main-->
	</div>
</body>
</html>