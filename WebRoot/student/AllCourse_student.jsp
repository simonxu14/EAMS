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
					<li class="text-info">Show All Courses</li>
				</ul>
			
				<div class="row-fluid">
					<div class="span12">
						
						<div class="well widget">
							<!-- widget header -->
							<div class="widget-header">
								<h3 class="title">All Courses</h3>
							</div>
							<!-- ./ widget header -->
							
							<!-- widget content -->
							<div class="widget-content">
								<table class="table">
									<thead>
										<tr>
											<th>ID</th>
											<th>Name</th>
											<th>Major</th>
											<th>Teacher</th>
											<th>Remain</th>
											<th>Start Time</th>
											<th>End Time</th>
											<th>Comment</th>
											<th>Detail</th>
											<th>Choose</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${allcourses}" var="u" varStatus="i">
									
    									<c:if test="${i.count%4==0}">
    										<tr class="success">
    											<td>${u.courseId}</td>
    											<td>${u.courseName}</td>
    											<td>${u.courseMajor}</td>
    											<td>${u.teachInfo.teachName}</td>
    											<td>${u.courseRemain}</td>
    											<td>${u.courseStart}</td>
    											<td>${u.courseEnd}</td>
    											<td>${u.courseComment}</td>
    											<td>
    											<a id="modal-981935" href="#${u.courseId}" role="button" data-toggle="modal">Deteil</a>
													<div id="${u.courseId}" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
														<div class="modal-header">
															 <h3 id="myModalLabel">
																		The Detail Of The Course
																</h3>
														</div>
														<div class="modal-body">
															<table class="table">
																<tr>
																	<th>category</th>
																	<th>data</th>
																</tr>
																<tr class="error"><td>Course ID</td><td>${u.courseId}</td></tr>
																<tr class="warning"><td>Course Name</td><td>${u.courseName}</td></tr>
																<tr class="info"><td>Course Major</td><td>${u.courseMajor}</td></tr>
																<tr class="success"><td>Course Teacher</td><td>${u.teachInfo.teachName}</td></tr>
																<tr class="error"><td>Course Remain</td><td>${u.courseRemain}</td></tr>
																<tr class="warning"><td>Course Start Time</td><td>${u.courseStart}</td></tr>
																<tr class="info"><td>Course End Time</td><td>${u.courseEnd}</td></tr>
																<tr class="success"><td>Course Comment</td><td>${u.courseComment}</td></tr>
															</table>
				
													</div>
													<div class="modal-footer">
														 <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
														<i class="micon-checkmark"></i><a href="student!selectCourse.action?courseInfo.courseId=${u.courseId}">Choose</a>
													</div>
												</div>
    											</td>
    											<td><i class="micon-checkmark"></i><a href="student!selectCourse.action?courseInfo.courseId=${u.courseId}">Choose</a></td>
    										</tr>
    									</c:if>
    									
    									<c:if test="${i.count%4==1}">
    										<tr class="warning">
    											<td>${u.courseId}</td>
    											<td>${u.courseName}</td>
    											<td>${u.courseMajor}</td>
    											<td>${u.teachInfo.teachName}</td>
    											<td>${u.courseRemain}</td>
    											<td>${u.courseStart}</td>
    											<td>${u.courseEnd}</td>
    											<td>${u.courseComment}</td>
    											<td><a></a>
    											   <a id="modal-981935" href="#${u.courseId}" role="button" data-toggle="modal">Deteil</a>
													<div id="${u.courseId}" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
														<div class="modal-header">
															 <h3 id="myModalLabel">
																		The Detail Of The Course
																</h3>
														</div>
														<div class="modal-body">
															<table class="table">
																<tr>
																	<th>category</th>
																	<th>data</th>
																</tr>
																<tr class="error"><td>Course ID</td><td>${u.courseId}</td></tr>
																<tr class="warning"><td>Course Name</td><td>${u.courseName}</td></tr>
																<tr class="info"><td>Course Major</td><td>${u.courseMajor}</td></tr>
																<tr class="success"><td>Course Teacher</td><td>${u.teachInfo.teachName}</td></tr>
																<tr class="error"><td>Course Remain</td><td>${u.courseRemain}</td></tr>
																<tr class="warning"><td>Course Start Time</td><td>${u.courseStart}</td></tr>
																<tr class="info"><td>Course End Time</td><td>${u.courseEnd}</td></tr>
																<tr class="success"><td>Course Comment</td><td>${u.courseComment}</td></tr>
															</table>
				
													</div>
													<div class="modal-footer">
														 <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button> 
														<i class="micon-checkmark"></i><a href="student!selectCourse.action?courseInfo.courseId=${u.courseId}">Choose</a>
													</div>
												</div>
											</td>
    											<td><i class="micon-checkmark"></i><a href="student!selectCourse.action?courseInfo.courseId=${u.courseId}">Choose</a></td>
    										</tr>
    									</c:if>
    									
    									<c:if test="${i.count%4==2}">
    										<tr class="info">
    											<td>${u.courseId}</td>
    											<td>${u.courseName}</td>
    											<td>${u.courseMajor}</td>
    											<td>${u.teachInfo.teachName}</td>
    											<td>${u.courseRemain}</td>
    											<td>${u.courseStart}</td>
    											<td>${u.courseEnd}</td>
    											<td>${u.courseComment}</td>
    											<td><a></a>
													<a id="modal-981935" href="#${u.courseId}" role="button" data-toggle="modal">Deteil</a>
													<div id="${u.courseId}" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
														<div class="modal-header">
															 <h3 id="myModalLabel">
																		The Detail Of The Course
																</h3>
														</div>
														<div class="modal-body">
															<table class="table">
																<tr>
																	<th>category</th>
																	<th>data</th>
																</tr>
																<tr class="error"><td>Course ID</td><td>${u.courseId}</td></tr>
																<tr class="warning"><td>Course Name</td><td>${u.courseName}</td></tr>
																<tr class="info"><td>Course Major</td><td>${u.courseMajor}</td></tr>
																<tr class="success"><td>Course Teacher</td><td>${u.teachInfo.teachName}</td></tr>
																<tr class="error"><td>Course Remain</td><td>${u.courseRemain}</td></tr>
																<tr class="warning"><td>Course Start Time</td><td>${u.courseStart}</td></tr>
																<tr class="info"><td>Course End Time</td><td>${u.courseEnd}</td></tr>
																<tr class="success"><td>Course Comment</td><td>${u.courseComment}</td></tr>
															</table>
				
													</div>
													<div class="modal-footer">
														 <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button> 
														<i class="micon-checkmark"></i><a href="student!selectCourse.action?courseInfo.courseId=${u.courseId}">Choose</a>
													</div>
												</div>
												</td>
    											<td><i class="micon-checkmark"></i><a href="student!selectCourse.action?courseInfo.courseId=${u.courseId}">Choose</a></td>
    										</tr>
    									</c:if>
    									
    									<c:if test="${i.count%4==3}">
    										<tr class="error">
    											<td>${u.courseId}</td>
    											<td>${u.courseName}</td>
    											<td>${u.courseMajor}</td>
    											<td>${u.teachInfo.teachName}</td>
    											<td>${u.courseRemain}</td>
    											<td>${u.courseStart}</td>
    											<td>${u.courseEnd}</td>
    											<td>${u.courseComment}</td>
    											<td><a></a>
    											<a id="modal-981935" href="#${u.courseId}" role="button" data-toggle="modal">Deteil</a>
												<div id="${u.courseId}" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
														<div class="modal-header">
															 <h3 id="myModalLabel">
																		The Detail Of The Course
																</h3>
														</div>
														<div class="modal-body">
															<table class="table">
																<tr>
																	<th>category</th>
																	<th>data</th>
																</tr>
																<tr class="error"><td>Course ID</td><td>${u.courseId}</td></tr>
																<tr class="warning"><td>Course Name</td><td>${u.courseName}</td></tr>
																<tr class="info"><td>Course Major</td><td>${u.courseMajor}</td></tr>
																<tr class="success"><td>Course Teacher</td><td>${u.teachInfo.teachName}</td></tr>
																<tr class="error"><td>Course Remain</td><td>${u.courseRemain}</td></tr>
																<tr class="warning"><td>Course Start Time</td><td>${u.courseStart}</td></tr>
																<tr class="info"><td>Course End Time</td><td>${u.courseEnd}</td></tr>
																<tr class="success"><td>Course Comment</td><td>${u.courseComment}</td></tr>
															</table>
				
													</div>
													<div class="modal-footer">
														 <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button> 
														<i class="micon-checkmark"></i><a href="student!selectCourse.action?courseInfo.courseId=${u.courseId}">Choose</a>
													</div>
												</div>	
    											</td>
    											<td><i class="micon-checkmark"></i><a href="student!selectCourse.action?courseInfo.courseId=${u.courseId}">Choose</a></td>
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
			<script type="text/javascript" >
					var flag = ${stuCourseflag};
					if(flag == 0){
						alert("选课成功");
					}
					else if(flag == 1){
						alert("课程已存在，请勿重复添加");
					}else{
						alert("日期冲突，无法选课");
					}
			</script>
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