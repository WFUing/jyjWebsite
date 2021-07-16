<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jyj.entity.*"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>IndexPage</title>
<link rel="stylesheet" type="text/css" href="css/imgIndex.css" />
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/imgIndex.js"></script>
<%!Manager manager = null;%>
<script type="text/javascript">
	$(function() {
<%manager = (Manager) session.getAttribute("manager");
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
}%>
	});
</script>
<script type="text/javascript">
	function define() {
		if (confirm("是否要注销此管理员账号")) {
			$("#DeleteForm").submit();
		}
	}

	function Add(url) {
		var winObj = window.open(url, '增加员工',
				'height=600, width=500, top=200, left=200');
		var loop = setInterval(function() {
			if (winObj.closed) {
				clearInterval(loop);
				parent.location.reload();
			}
		}, 1);
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
	<div class="container clearfix" style="pointer-events: auto;">
		<div class="sidebar-wrap">
			<div class="sidebar-title">
				<h1>菜单</h1>
			</div>
			<div class="sidebar-content">
				<ul class="sidebar-list">
					<li><a href="#"><i class="icon-font">&#xe017;</i>常用操作</a>
						<ul class="sub-menu">
							<li><a href="EmpQueryByPageServlet?curPage=1"><i
									class="icon-font">&#xe003;</i>员工列表</a></li>
							<li><a onclick="Add('EmpAdd.jsp')"
								style="position: relative;"><i class="icon-font">&#xe005;</i>增加员工</a></li>
						</ul></li>
					<li><a href="#"><i class="icon-font">&#xe018;</i>系统管理</a>
						<ul class="sub-menu">
							<li><a href="./ManaUpdPsw.jsp"><i class="icon-font">&#xe045;</i>修改此密码</a></li>
							<li><form action="./ManaDeleteServlet" id="DeleteForm"
									method="post">
									<a onclick="define()"><i class="icon-font">&#xe037;</i>删除此帐号</a>
								</form></li>
							<li><i class="icon-font">&#xe012; &#xe052; &#xe033;
									&#xe004; &#xe006; &#xe008; &#xe046;</i></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<div id="outer">
			<ul id="imgList">
				<li><img src="images/1.jpg" style="pointer-events: none;" /></li>
				<li><img src="images/2.jpg" style="pointer-events: none;" /></li>
				<li><img src="images/3.jpg" style="pointer-events: none;" /></li>
				<li><img src="images/4.jpg" style="pointer-events: none;" /></li>
				<li><img src="images/5.jpg" style="pointer-events: none;" /></li>
				<li><img src="images/1.jpg" style="pointer-events: none;" /></li>
			</ul>
			<div id="navDiv">
				<a href="javascript: ;"></a> <a href="javascript: ;"></a> <a
					href="javascript: ;"></a> <a href="javascript: ;"></a> <a
					href="javascript: ;"></a>
			</div>
		</div>
		<br/>
		<div style="margin-left:200px">
			<div class="btn btn-primary">
				<a href="DownloadServlet?filename=1.jpg" style="color: yellow">下载第一张图片</a>
			</div>
			<div class="btn btn-primary">
				<a href="DownloadServlet?filename=2.jpg" style="color: yellow">下载第二张图片</a>
			</div>
			<div class="btn btn-primary">
				<a href="DownloadServlet?filename=3.jpg" style="color: yellow">下载第三张图片</a>
			</div>
			<div class="btn btn-primary">
				<a href="DownloadServlet?filename=4.jpg" style="color: yellow">下载第四张图片</a>
			</div>
			<div class="btn btn-primary">
				<a href="DownloadServlet?filename=5.jpg" style="color: yellow">下载第五张图片</a>
			</div>
		</div>
	</div>
</body>
</html>