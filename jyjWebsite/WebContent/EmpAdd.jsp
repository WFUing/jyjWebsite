<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="content-type" content="text/html; charset=UTF-8">
<title>Good Day</title>
<link href="css/Inter.css" rel="stylesheet" type="text/css" />
<link href="css/dateTime.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/dateTime.min.js"></script>
<script type="text/javascript">
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
	<div class="admin_login_wrap" style="width: 350px; margin: 50px auto 0">
		<div class="adming_login_border">
			<div class="admin_input">
				<div class="admin_form">
					<form id="formRegist" action="./EmpAddServlet" method="post">
						<ul class="admin_items">
							<li><label for="empNo"
								style="float: left; width: 15%; margin-left: 10%">编号：</label> <input
								type="text" name="empNo" id="empNo" size="40"
								class="admin_input_style" style="float: left; width: 70%" /><br />
								<br /></li>
							<li><label for="name"
								style="float: left; width: 15%; margin-left: 10%">姓名：</label> <input
								type="text" name="name" id="name" size="40"
								class="admin_input_style" style="float: left; width: 70%" /><br />
								<br /></li>
							<li><label for="gender"
								style="float: left; width: 35%; margin-left: 10%">性别：</label> <select
								name="gender" id="gender">
									<option value="M">男</option>
									<option value="F">女</option>
							</select> <br /> <br /></li>
							<li><label for="password"
								style="float: left; width: 35%; margin-left: 10%">生日：</label> <input
								type="text" class="admin_input_style"
								style="float: left; width: 40%" placeholder="请选择日期"
								id="birthdate" name="birthday" /> <br /> <br /></li>
							<li><label for="password"
								style="float: left; width: 35%; margin-left: 10%">入职时间：</label>
								<input type="text" class="admin_input_style"
								style="float: left; width: 40%" placeholder="请选择日期"
								id="hiredate" name="hireday" /> <br /> <br /></li>
						</ul>
						<input type="button" tabindex="3" value="添加新员工"
							class="btn btn-primary btn-primary2" onclick="check()" />
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$("#birthdate").datetime({
			type : "date",
			value : [ 2021, 1, 1 ],
			success : function(res) {
				console.log(res)
			}
		})
		$("#hiredate").datetime({
			type : "date",
			value : [ 2021, 1, 1 ],
			success : function(res) {
				console.log(res)
			}
		})
	</script>
</body>
</html>