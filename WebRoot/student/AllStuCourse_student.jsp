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
								<img class="thumb account-img" src="<%=basePath%>${student.stuPhoto }"/>
							</li>
							
							<li class="account-info">
								<h3>${student.stuName}</h3>
								<p>I'm ${student.stuName}, I come from Monster University!</p>
								<p>
									<a href="<%=basePath%>index.jsp">Edit</a> | <a href="<%=basePath%>student/personal page_student.jsp">Home</a>
								</p>
							</li>
							
							<li class="account-footer">
								<div class="row-fluid">
								
									<div class="span8">
										<a class="btn btn-small btn-primary btn-flat" href="student!showStudentInfoForUpdate.action">Update Information</a>
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
					<li><a href="#">Home</a> <span class="divider"><i class="icon-caret-right"></i></span></li>
					<li class="text-info">Show Personal Courses</li>
				</ul>
			
				<div class="row-fluid">
					<div class="span12">
						
						<div class="well widget">
							<!-- widget header -->
							<div class="widget-header">
								<h3 class="title">Personal Courses</h3>
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
											<th>Teacher</th>
											<th>Start Time</th>
											<th>End Time</th>
											<th>Comment</th>
											<td>Score</td>
											<th>Delete</th>
											<th>Check</th>
										</tr>
									</thead>
									<tbody>
									
									<c:forEach items="${courses}" var="u" varStatus="i">
									    <c:if test="${i.count%4==0}">
    										<tr class="success"> 
    											<td>${u.courseInfo.courseId}</td><td>${u.courseInfo.courseName}</td><td>${u.courseInfo.courseMajor}</td>
    											<td>${u.courseInfo.teachInfo.teachName}</td><td>${u.courseInfo.courseStart}</td><td>${u.courseInfo.courseEnd}</td><td>${u.courseInfo.courseComment}</td>
    											<td>${u.stuGrade}</td>
    											<td>
													 <i class="micon-remove"></i><a id="modal-981935" href="#${u.courseInfo.courseId}" role="button" data-toggle="modal">Delete</a>
			
													<div id="${u.courseInfo.courseId}" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
														<div class="modal-header">
															 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
															<h3 align="center">
																Delete
															</h3>
														</div>
														<div class="modal-body">
															<p>
															   Are You Sure Wanna Delete ${u.courseInfo.courseName}
															</p>
														</div>
														<div class="modal-footer">
															 <button class="btn btn-flat" data-dismiss="modal" aria-hidden="true">Cancel</button> 
															 <a class="btn btn-flat btn-success" href="student!deleteStuCourse.action?stucourse.stuCourseId=${u.stuCourseId}" role="button" class="btn">Yes, I'm Sure</a>
														</div>
													</div>
												</td>
    											<td><a href="student!queryStuCheckByCourse.action?courseInfo.courseId=${u.courseInfo.courseId}">Check</a></td>
    										</tr>
    									</c:if>
    									<c:if test="${i.count%4==1}">
    										<tr class="error"> 
    											<td>${u.courseInfo.courseId}</td><td>${u.courseInfo.courseName}</td><td>${u.courseInfo.courseMajor}</td>
    											<td>${u.courseInfo.teachInfo.teachName}</td><td>${u.courseInfo.courseStart}</td><td>${u.courseInfo.courseEnd}</td><td>${u.courseInfo.courseComment}</td>
    											<td>${u.stuGrade}</td>
    											<td>
    				    											
    											 <i class="micon-remove"></i><a id="modal-981935" href="#${u.courseInfo.courseId}" role="button" data-toggle="modal">Delete</a>
			
													<div id="${u.courseInfo.courseId}" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
														<div class="modal-header">
															 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
															<h3 align="center">
																Delete
															</h3>
														</div>
														<div class="modal-body">
															<p>
															   Are You Sure Wanna Delete ${u.courseInfo.courseName}
															</p>
														</div>
														<div class="modal-footer">
															 <button class="btn btn-flat" data-dismiss="modal" aria-hidden="true">Cancel</button> 
															 <a class="btn btn-flat btn-success" href="student!deleteStuCourse.action?stucourse.stuCourseId=${u.stuCourseId}" role="button" class="btn">Yes, I'm Sure</a>
														</div>
													</div>
    											
    											</td>
    											
    											
    											
    											<td><a href="student!queryStuCheckByCourse.action?courseInfo.courseId=${u.courseInfo.courseId}">Check</a></td>
    										</tr>
    									</c:if>
    									<c:if test="${i.count%4==2}">
    										<tr class="warning"> 
    											<td>${u.courseInfo.courseId}</td><td>${u.courseInfo.courseName}</td><td>${u.courseInfo.courseMajor}</td>
    											<td>${u.courseInfo.teachInfo.teachName}</td><td>${u.courseInfo.courseStart}</td><td>${u.courseInfo.courseEnd}</td><td>${u.courseInfo.courseComment}</td>
    											<td>${u.stuGrade}</td>
    											<td>
    											 <i class="micon-remove"></i><a id="modal-981935" href="#${u.courseInfo.courseId}" role="button" data-toggle="modal">Delete</a>
			
													<div id="${u.courseInfo.courseId}" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
														<div class="modal-header">
															 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
															<h3 align="center">
																Delete
															</h3>
														</div>
														<div class="modal-body">
															<p>
															   Are You Sure Wanna Delete ${u.courseInfo.courseName}
															</p>
														</div>
														<div class="modal-footer">
															 <button class="btn btn-flat" data-dismiss="modal" aria-hidden="true">Cancel</button> 
															 <a class="btn btn-flat btn-success" href="student!deleteStuCourse.action?stucourse.stuCourseId=${u.stuCourseId}" role="button" class="btn">Yes, I'm Sure</a>
														</div>
													</div>
    											</td>
    											<td><a href="student!queryStuCheckByCourse.action?courseInfo.courseId=${u.courseInfo.courseId}">Check</a></td>
    										</tr>
    									</c:if>
    									<c:if test="${i.count%4==3}">
    										<tr class="info"> 
    											<td>${u.courseInfo.courseId}</td><td>${u.courseInfo.courseName}</td><td>${u.courseInfo.courseMajor}</td>
    											<td>${u.courseInfo.teachInfo.teachName}</td><td>${u.courseInfo.courseStart}</td><td>${u.courseInfo.courseEnd}</td><td>${u.courseInfo.courseComment}</td>
    											<td>${u.stuGrade}</td>
    											<td>
    											 <i class="micon-remove"></i><a id="modal-981935" href="#${u.courseInfo.courseId}" role="button" data-toggle="modal">Delete</a>
			
													<div id="${u.courseInfo.courseId}" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
														<div class="modal-header">
															 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
															<h3 align="center">
																Delete
															</h3>
														</div>
														<div class="modal-body">
															<p>
															   Are You Sure Wanna Delete ${u.courseInfo.courseName}
															</p>
														</div>
														<div class="modal-footer">
															 <button class="btn btn-flat" data-dismiss="modal" aria-hidden="true">Cancel</button> 
															 <a class="btn btn-flat btn-success" href="student!deleteStuCourse.action?stucourse.stuCourseId=${u.stuCourseId}" role="button" class="btn">Yes, I'm Sure</a>
														</div>
													</div>
    											</td>
    											<td><a href="student!queryStuCheckByCourse.action?courseInfo.courseId=${u.courseInfo.courseId}">Check</a></td>
    										</tr>
    									</c:if>
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
					<a href="<%=basePath%>student/personal page_student.jsp">
						<!-- 点击链接 -->
						<img src="<%=basePath%>${student.stuPhoto }" />
						<!-- 用户照片 -->
						<span>${student.stuName}</span>
						<!-- 用户名字 -->
					</a>
				</li>
				
				

				
				<li>
					<a href="student!checkCourseByStudent.action">
						<!-- 课程数据链接 -->
						<i class="micon-book"></i>
						<span class="hidden-phone">Personal Courses</span>
					</a>
				</li>

				<li>
					<a href="student!checkAllCourse.action">
						<!-- 所有课程链接 -->
						<i class="micon-cube"></i>
						<span class="hidden-phone">All Courses</span>
					</a>
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