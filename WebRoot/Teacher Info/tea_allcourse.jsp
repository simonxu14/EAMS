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
								<img class="thumb account-img" src="<%=basePath%>${teachInfo_session.teachPhoto}"/>
							</li>
							
							<li class="account-info">
								<h3>${teachInfo_session.teachName}</h3>
								<p>I'm ${teachInfo_session.teachName}, I come from Monster University!</p>
								<p>
									<a href="<%=basePath%>index.jsp">Edit</a> | <a href="<%=basePath%>Teacher Info/tea_personal page.jsp">Home</a>
								</p>
							</li>
							
							<li class="account-footer">
								<div class="row-fluid">
								
									<div class="span8">
										<a class="btn btn-small btn-primary btn-flat" href="<%=basePath%>Teacher Info/tea_updateteainfo.jsp">Update Information</a>
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
					<li><a href="<%=basePath%>Teacher Info/tea_personal page.jsp">Home</a> <span class="divider"><i class="icon-caret-right"></i></span></li>
					<li class="text-info">All course</li>
				</ul>
			
				<div class="row-fluid">
					<div class="span12">
						
						<div class="well widget">
							<!-- widget header -->
							<div class="widget-header">
								<h3 class="title">All Course</h3>
							</div>
							<!-- ./ widget header -->
							
							<!-- widget content -->
							<div class="widget-content">
								<table class="table">
									<thead>
										
										<tr>
										    <th>Course ID</th>
											<th>Course Name</th>
											<th>Course Major</th>
											<th>Number of Student</th>
											<th>Course Start Time</th>
											<th>Course End Time</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${allCourseInfo}" var="course">
										<tr class="success">				
										    <td>${course.courseId}</td>
											<td>${course.courseName}</td>
											<td>${course.courseMajor}</td>
											<td>
											<script type="text/javascript">
												var a = ${course.courseRemain};
												document.write(80-a);
											</script>
											</td>
											<td>${course.courseStart}</td>
											<td>${course.courseEnd}</td>							
										</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- ./ widget content -->
						</div>
						
					</div>
				</div>
			</div>
			<!-- end main content -->
			
			
			<!-- sidebar -->
			<ul id="sidebar" class="nav nav-pills nav-stacked">
				<li class="avatar hidden-phone">
					<a href="<%=basePath%>Teacher Info/tea_personal page.jsp">
						<!-- 点击链接 -->
						<img src="<%=basePath %>${teachInfo_session.teachPhoto}" />
						<!-- 用户照片 -->
						<span>${teachInfo_session.teachName}</span>
						<!-- 用户名字 -->
					</a>
				</li>
				
				
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<!-- 教师信息链接 -->
						<i class="micon-user-3"></i>
						<span class="hidden-phone">Teacher</span>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="teacherInfo!checkTeacher.action">
								<!-- 教师个人信息链接 -->
								<i class="icon-large icon-list-alt"></i> Personal information
							</a>
						</li>
						<li>
							<a href="teacherInfo!tea_hiddenList.action">
								<!-- 所有教师信息链接 -->
								<i class="icon-large icon-th"></i> All teachers
							</a>
						</li>
					</ul>
				</li>
				
				
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<!-- 课程模块链接 -->
						<i class="micon-folder"></i>
						<span class="hidden-phone">Course</span>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="teacherInfo!myCourse.action?teachInfo.teachId=${teachInfo_session.teachId}"">
								<!-- 教师个人课程链接 -->
								<i class="icon-large icon-print"></i>Personal courses
							</a>
						</li>
						<li>
							<a href="teacherInfo!allCourse.action">
								<!-- 所有课程链接 -->
								<i class="icon-large icon-th-list"></i> All courses
							</a>
						</li>
					</ul>
				</li>
				
			</ul>
			<!-- end sidebar -->
		</div>
		
		
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
</html>