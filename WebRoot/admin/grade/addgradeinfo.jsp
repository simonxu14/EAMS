<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>EAMS</title>
	<link rel="icon" href="<%=basePath%>image/sulley.ico" type="image/x-icon">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta name="description" content="" />
		<meta name="author" content="Olas Navigator" />
<link type="text/css" rel="stylesheet" href="<%=basePath %>css/validator.css" />
		<script src="<%=basePath %>js/validator.js"></script>
		<!-- required styles -->
		<link href="<%=basePath %>library/assets/css/bootstrap.css" rel="stylesheet" />
		<link href="<%=basePath %>library/assets/css/bootstrap-responsive.css" rel="stylesheet" />
		<link href="<%=basePath %>library/css/styles.css" rel="stylesheet" />
		
		<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
  
<body>
		
<!-- header -->
		<div id="header" class="navbar">
			<div class="navbar-inner">
				<!-- company or app name -->
				<a class="brand hidden-phone" href="index.html">Monster EAMS</a>
				
				<!-- nav icons -->
				<ul class="nav">
				
					<li class="visible-phone">
						<a href="#"><i class="icon-large icon-search"></i></a>
					</li>
					
					<li>
						<a href="#">
							<i class="icon-large icon-globe"></i>
						</a>
					</li>
					
					<li>
						<a href="#">
							<i class="icon-large icon-envelope"></i>
						</a>
					</li>
					
					<li>
						<a href="#">
							<i class="icon-large icon-cog"></i>
						</a>
					</li>
				</ul>
				
				<ul class="nav pull-right">
					
					<!-- dropdown user account -->
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<i class="icon-large icon-user"></i>
						</a>
						
						<ul class="dropdown-menu dropdown-user-account">
						
							<li class="account-img-container">
								<img class="thumb account-img" src="<%=basePath%>${empInfo_session.empPhoto}"/>
							</li>
							
							<li class="account-info">
								<h3>${empInfo_session.empName}</h3>
								<p>I'm ${empInfo_session.empName}, I come from Monster University!</p>
								<p>
									<a href="<%=basePath%>index.jsp">Edit</a> | <a href="<%=basePath%>page.jsp">Home</a>
								</p>
							</li>
							
							<li class="account-footer">
								<div class="row-fluid">
								
									<div class="span8">
										<a class="btn btn-small btn-primary btn-flat" href="empInfo!myForUpdateEmpInfo.action?empInfo.empId=${empInfo_session.empId}">Update Information</a>
									</div>
									
									<div class="span4 align-right">
										<a class="btn btn-small btn-danger btn-flat" href="<%=basePath%>index.jsp">Logout</a>
									</div>
									
								</div>									
							</li>
							
						</ul>
					</li>
					<!-- ./ dropdown user account -->
				</ul>
				
				<!-- search form -->
				<form class="navbar-search pull-right hidden-phone" action="#" >
					<input type="text" class="search-query span4" placeholder="search..." >
				</form>
				<!-- ./ search form -->
			</div>
		</div>
		<!-- end header -->		
		
		
		
		
		
		
		
		
		
		<div id="left_layout">
			<!-- main content -->
			<div id="main_content" class="container-fluid">
			
				<!-- page heading -->
				<div class="page-heading">
				
					<h2 class="page-title muted">
						<i class="icon-home"></i> Home Page
					</h2>
					
					<div class="page-info hidden-phone">
						<ul class="stats">
							<li>
								<span class="large text-warning">Friday</span>
								<span class="mini muted">week</span>
							</li>
							<li>
								<span class="large text-info">March</span>
								<span class="mini muted">month</span>
							</li>
							<li>
								<span class="large text-success">21</span>
								<span class="mini muted">day</span>
							</li>
							<li>
								<span class="large text-error">2014</span>
								<span class="mini muted">year</span>
							</li>
						</ul>
					</div>
				</div>
				<!-- ./ page heading -->
				
				<ul class="breadcrumb breadcrumb-main">
					<li><a href="<%=basePath%>page.jsp">Home</a> <span class="divider"><i class="icon-caret-right"></i></span></li>
					<li><a href="gradeInfo!gradePage.action">Grade</a> <span class="divider"><i class="icon-caret-right"></i></span></li>
					<li class="text-info">Add a grade</li>
				</ul>
			
				<div class="row-fluid">
					<div class="span8">
						
						<div class="well widget">
							<div class="widget-header">
								<h3 class="title">Add a new Grade</h3>
							</div>
							
							
							<form id="addGradeInfo" class="form-horizontal" action="gradeInfo!addGradeInfo.action" method="post">

								
								<div class="control-group">
									<label class="control-label">Name</label>
									<div class="controls">
										<input id="name" type="text" name="gradeInfo.gradeName" placeholder="Name" />
									</div>
								</div>
								
								<div class="control-group">
									<div class="controls">
									<button type="button" onclick="check()" class="btn btn-warning">Submit</button>
									</div>
								</div>
							</form>
						</div>
						
					</div>
				</div>
			</div>
			<script>
			 	var myValidator = new Eui.Validator(document.getElementById('addGradeInfo'),
				[{
					name: 'name',
					rules: 'required'
				}],{
					requiredMsg: 'cannot be empty'
				});
				function check(){
					if(!myValidator){
						alert("please check the inputs");
						return;
					}
					if(addGradeInfo.name.value == ""){
						alert("please check the inputs");
						return
					}
					
					else{
						addGradeInfo.submit();
					}
				}
			</script>
			
			
<!-- sidebar -->
			<ul id="sidebar" class="nav nav-pills nav-stacked">
				<li class="avatar hidden-phone">
					<a href="<%=basePath%>page.jsp">
						<img src="<%=basePath%>${empInfo_session.empPhoto}" />
						<span>${empInfo_session.empName}</span>
					</a>
				</li>
				
				<!-- 1自己日程 -->
				<li id="myschedule">
					<a href="scheduleInfo!mySchedulePage.action?scheduleInfo.empInfo.empId=${empInfo_session.empId}">
						<i class="micon-comments-6"></i>
						<span class="hidden-phone">My Schedule</span>
					</a>
				</li>
				
				
				
				<!-- 2机构 -->
				<li class="dropdown" id="org">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<i class="micon-tree-view"></i>
						<span class="hidden-phone">Organization</span>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="orgInfo!orgPage.action">
								<i class="icon-large icon-hdd"></i> Organization
							</a>
						</li>
						<li>
							<a href="depInfo!depPage.action">
								<i class="icon-large icon-sitemap"></i> Department
							</a>
						</li>
					</ul>
				</li>
				
				<!-- 3职工 -->
				<li class="dropdown" id="emp">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<i class="micon-user"></i>
						<span class="hidden-phone">Employee</span>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="postInfo!postPage.action">
								<i class="icon-large icon-cloud"></i> Position
							</a>
						</li>
						<li>
							<a href="empInfo!empPage.action">
								<i class="icon-large icon-user"></i> Employee
							</a>
						</li>
					</ul>
				</li>
				
				<!-- 4年级 -->
				<li class="dropdown" id="grade">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<i class="micon-cube"></i>
						<span class="hidden-phone">Grade</span>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="gradeInfo!gradePage.action">
								<i class="icon-large icon-th-large"></i> Grade
							</a>
						</li>
						<li>
							<a href="classInfo!classPage.action">
								<i class="icon-large icon-stop"></i> Class
							</a>
						</li>
					</ul>
				</li>



				
				
				<!-- 5管理日程 -->
				<li id="schedule">
					<a href="scheduleInfo!schedulePage.action">
						<i class="micon-calendar"></i>
						<span class="hidden-phone">Schedule</span>
					</a>
				</li>
				
				
				
				<!-- 6考勤 -->
				<li id="check">
					<a href="checkInfo!checkPage.action">
						<i class="micon-pencil-2"></i>
						<span class="hidden-phone">Check</span>
					</a>
				</li>
				
				
				
				<!-- 7权限 -->
				<li id="power">
					<a href="powerInfo!powerPage.action">
						<i class="micon-key-2"></i>
						<span class="hidden-phone">Power</span>
					</a>
				</li>
				
				
				<!-- 8课程 -->
				<li class="dropdown" id="course">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<i class="micon-book"></i>
						<span class="hidden-phone">Course</span>
					</a>
					<ul class="dropdown-menu">
						
						<li>
							<a href="course!queryAllCourses.action">
								<i class="icon-large micon-book"></i> All Course
							</a>
						</li>
						<li>
							<a href="course!queryAllTeachInfo.action">
								<i class="icon-large icon-plus"></i> Add Course
							</a>
						</li>
					</ul>
				</li>
				
				
				<!-- 9咨询学生 -->
				<li class="dropdown" id="consult">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<i class="micon-accessibility"></i>
						<span class="hidden-phone">Consult</span>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="Manager/addConsultStudent_admin.jsp">
								<i class="icon-large icon-plus-sign"></i> Add Consult Student
							</a>
						</li>
						<li>
							<a href="student!queryAllConsultStudent.action">
								<i class="icon-large icon-phone-sign"></i> All Consult Student
							</a>
						</li>
					</ul>
				</li>
				
				
				<!-- 10正式学生 -->
				<li id="student">
					<a href="student!queryAllStudent.action">
						<i class="micon-key-2"></i>
						<span class="hidden-phone">Student</span>
					</a>
				</li>
				
				
				
				<!-- 11老师 -->
				<li class="dropdown" id="teacher">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<i class="micon-user-3"></i>
						<span class="hidden-phone">Teacher</span>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="teacherInfo!hiddenList.action">
							<i class="icon-large icon-user"></i> Teacher information
							</a>
						</li>
						<li>
							<a href="teacherLevel!hiddenList.action">
							<i class="icon-large icon-flag"></i> Teacher level  
							</a>
						</li>
					</ul>
				</li>
				
				<!-- 12财务 -->
				<li class="dropdown" id="finance">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<i class="micon-bars"></i>
						<span class="hidden-phone">Finance</span>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="teacherInfo!checkout.action">
							<i class="icon-large icon-list-alt"></i> Teacher Checkout
							</a>
						</li>
						<li>
							<a href="student!checkout.action">
							<i class="icon-large icon-bar-chart"></i> Student Checkout  
							</a>
						</li>
						<li>
							<a href="empInfo!checkout.action">
							<i class="icon-large icon-list"></i> Employee Checkout
							</a>
						</li>
					</ul>
				</li>
				
				
			</ul>
			<!-- end sidebar -->
		</div>
		
		<!-- external api -->
		
		<!-- base -->
		<script src="<%=basePath %>library/assets/js/jquery.js"></script>
		<script src="<%=basePath %>library/assets/js/bootstrap.min.js"></script>
		
		<!-- addons -->
		<script src="<%=basePath %>library/plugins/chart-plugins.js"></script>
		<script src="<%=basePath %>library/plugins/jquery-ui-slider.js"></script>
		<script src="<%=basePath %>library/plugins/redactor/redactor.min.js"></script>
		<script src="<%=basePath %>library/plugins/jmapping/markermanager.js"></script>
		<script src="<%=basePath %>library/plugins/jmapping/StyledMarker.js"></script>
		<script src="<%=basePath %>library/plugins/jmapping/jquery.metadata.js"></script>
		<script src="<%=basePath %>library/plugins/jmapping/jquery.jmapping.min.js"></script>
		<script src="<%=basePath %>library/plugins/jquery.uniform.js"></script>
		<script src="<%=basePath %>library/plugins/chosen.jquery.min.js"></script>
		<script src="<%=basePath %>library/plugins/bootstrap-datepicker.js"></script>
		<script src="<%=basePath %>library/plugins/jquery.timePicker.min.js"></script>
				
		<!-- plugins loader -->
		<script src="<%=basePath %>library/js/loader.js"></script>
	</body>
	
	<script type="text/javascript">
	function show(){
	var a = ${empInfo_session.powerInfo.powerAccount};
	
	var myschedule=0;
	var org=0;
	var emp=0;
	var grade=0;
	var schedule=0;
	var check=0;
	var power=0;
	var course=0
	var consult=0;
	var student=0;
	var teacher=0;
	var finance=0;	
	
	/* Education */
	if(a%2 == 1){
		myschedule=1;
		course=1;
		student=1;
	}
	a = a/10;
	a = a.toFixed(0);
	
	/* Finance */
	if(a%2 == 1){
		myschedule=1;
		finance=1;
	}
	a = a/10;
	a = a.toFixed(0);
	
	/* Teacher */
	if(a%2 == 1){
		myschedule=1;
		teacher=1;
	}
	a = a/10;
	a = a.toFixed(0);
	
	/* Charge */
	if(a%2 == 1){
		myschedule=1;
		consult=1;
	}
	a = a/10;
	a = a.toFixed(0);
	
	/* Keyboard */
	if(a%2 == 1){
		myschedule=1;
		consult=1;
	}
	a = a/10;
	a = a.toFixed(0);
	
	/* System */
	if(a%2 == 1){
		myschedule=1;
		org=1;
		emp=1;
		grade=1;
		schedule=1;
		check=1;
		power=1;
	}
	a = a/10;
	a = a.toFixed(0);
	
	if(org == 0)
		$("#org").html("");
	if(emp == 0)
		$("#emp").html("");
	if(grade == 0)
		$("#grade").html("");
	if(myschedule == 0)
		$("#myschedule").html("");
	if(schedule == 0)
		$("#schedule").html("");
	if(check == 0)
		$("#check").html("");
	if(power == 0)
		$("#power").html("");
	if(course == 0)
		$("#course").html("");
	if(consult == 0)
		$("#consult").html("");
	if(student == 0)
		$("#student").html("");
	if(teacher == 0)
		$("#teacher").html("");
	if(finance == 0)
		$("#finance").html("");
	}
	show();
	</script>
	
	
</html>