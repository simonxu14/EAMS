<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<!-- saved from url=(0024)http://iphper.duapp.com/ -->
<html lang="zh-ch"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<meta charset="UTF-8">
    <link rel="stylesheet" href="http://static2cdn.cdn.duapp.com//css/bootstrap.min.css">
	<link rel="stylesheet" href="http://static2cdn.cdn.duapp.com//css/bootstrap-theme.min.css">
<title>EAMS</title>
	<link rel="icon" href="<%=basePath%>image/sulley.ico" type="image/x-icon">







	<style>
		html { 
        background: url(<%=basePath%>library/images/5.jpg) no-repeat center center fixed; 
		  -webkit-background-size: cover;
		  -moz-background-size: cover;
		  -o-background-size: cover;
		  background-size: cover;
		}
		body{
			padding-top:20px;
			font-size:16px;
			font-family: "Open Sans",serif;
			background: transparent;
		}
		 h1 {
            font-family: "Abel", Arial, sans-serif;
            font-weight: 400;
            font-size: 40px;
        }

        .margin-base-vertical {
            margin: 40px 0;
        }
        .panel {
            background-color: rgba(255, 255, 255, 0.9);
        }
	</style>
</head>
<body style="">
  <div class="container">
		<div class="row">
			<div class="col-md-3 col-md-offset-2  panel panel-default">
				<h1 class="margin-base-vertical">Monster University</h1>
				<p>There are lots of monsters in the school.</p>
				<p>Join us!</p>
				<a href="<%=basePath %>student/addConsultStudent.jsp">Consule us</a>
				<p></p>
				<p></p>
				<p></p>
				<p>Monster, Please choose the role:</p>
					<p class="input-group">
                      System Operator<input type="radio" value="admin" name="q" onclick="choose1()">
					</p>
					<p class="input-group">
					  Teacher<input type="radio" value="teacher" name="q" onclick="choose2()">
					</p>
					<p class="input-group">
					  Student<input type="radio" value="student" name="q" onclick="choose3()">
					</p>
				<form action="" id="role" method="post" class="margin-base-vertical" >
					<p class="input-group" align="center">
                      <input id="account" type="text" class="form-control input-lg" placeholder="Account" name="">
					</p>
					<p class="input-group">
                      <input id="password" type="password" class="form-control input-lg" placeholder="Password" name="">
					</p>
					
					<p class="text-center">
						<button class="btn btn-success btn-lg" onClick="check()"  type="button">register</button>
					</p>
				</form>
					
				<div class="margin-base-vertical">
					<small class="text-muted"><a href="#">#</a>. Used under <a href="#">#</a>.</small>
				</div>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript">
function choose1(){
	document.getElementById("role").action = "empInfo!checkEmpInfo.action";
	document.getElementById("account").name = "empInfo.empAccount";
	document.getElementById("password").name = "empInfo.empPassword";
}
function choose2(){
	document.getElementById("role").action = "teacherInfo!checkTeacher.action";
	document.getElementById("account").name = "teachInfo.teachAccount";
	document.getElementById("password").name = "teachInfo.teachPsd";
}
function choose3(){
	document.getElementById("role").action = "student!CheckStudent.action";
	document.getElementById("account").name = "student.stuAccount";
	document.getElementById("password").name = "student.stuPassword";
}

function check()
{
  if(role.account.value == "")
    {
    	alert("Please input the Account");
    	role.account.focus();
    	return;
    }
    
  if(role.password.value == "")
    {
    	alert("Please input the Password");
    	role.password.focus();
    	return;
    }
  else
  {
  	role.submit();
  }
}

</script>
</html>