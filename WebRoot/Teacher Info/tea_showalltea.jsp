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
					<li class="text-info">Show all teachers' information</li>
				</ul>
			
				<div class="row-fluid">
					<div class="span12">
						
						<div class="well widget">
							<!-- widget header -->
							<div class="widget-header">
								<h3 class="title">Teacher Information</h3>
							</div>
							<!-- ./ widget header -->
							
							<!-- widget content -->
							<div class="widget-content">
								<table class="table">
									<thead>
										
										<tr>
										  <th>
										    Teacher certificate
									      </th>
											<th>Level ID</th>
											<th>Account</th>
											<th>Name</th>
											<th>Sex</th>
											<th>Identity Card</th>
											<th>Mobile Phone</th>
											<th>QQ</th>
											<th>Detail</th>
											
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${info}" var="i">
										<tr class="success">				
										  <td>${i.teachId}</td>
											<td>${i.teachLevel.teachLevelName}</td>
											<td>${i.teachAccount}</td>
											<td>${i.teachName}</td>
											<td><script type="text/javascript">
					var b = ${i.teachSex};
					if(b == 1){
						document.write("Male");
					}
					else{
						document.write("Female");
					} 
				</script></td>
											<td>${i.teachIdentity}</td>
											<td>${i.teachTel}</td>
											<td>${i.teachQq}</td>
											<td>
											<a id="modal-981935" href="#${i.teachId}" role="button" data-toggle="modal">Deteil</a>
													<div id="${i.teachId}" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
													<div class="modal-header">
															 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
																<h3 id="myModalLabel">
																		The Detail Of teacher
																</h3>
														</div>
														<div class="modal-body">
															<table class="table">
																<tr>
																	<th>category</th>
																	<th>data</th>
																</tr>
																<tr class="error"><td>Teacher certificate No.</td><td>${i.teachId}</td></tr>
																<tr class="warning"><td>Level ID</td><td>${i.teachLevel.teachLevelName}</td></tr>
																<tr class="info"><td>Account</td><td>${i.teachAccount}</td></tr>
																<tr class="success"><td>Name</td><td>${i.teachName}</td></tr>
																<tr class="error"><td>Photo</td>
																
																
																
																<td><img src="<%=basePath %>${i.teachPhoto}"/></td>
																
																
																</tr>
																<tr class="warning"><td>Sex</td><td>
																<script type="text/javascript">
					var b = ${i.teachSex};
					if(b == 1){
						document.write("Male");
					}
					else{
						document.write("Female");
					} 
				</script>
																</td></tr>
																<tr class="info"><td>Identity Card No.</td><td>${i.teachIdentity}</td></tr>
																<tr class="success"><td>Mobile Phone No.</td><td>${i.teachTel}</td></tr>
																<tr class="error"><td>QQ</td><td>${i.teachQq}</td></tr>
																<tr class="warning"><td>Address</td><td>${i.teachAddress}</td></tr>
																<tr class="info"><td>Graduated university</td><td>${i.teachCollage}</td></tr>
																<tr class="success"><td>Class major</td><td>${i.teachMajor}</td></tr>
																<tr class="error"><td>Class quantity</td><td>${i.teachClassNumber}</td></tr>
																<tr class="warning"><td>Entrance date</td><td>${i.teachStart}</td></tr>
																<tr class="info"><td>Leave date</td><td>${i.teachEnd}</td></tr>
																<tr class="success"><td>Commission settlement</td><td>${i.teachClearForm}</td></tr>
																<tr class="error"><td>Comment</td><td>${i.teachComment}</td></tr>
																
															</table>
				
													</div>
														<div class="modal-footer">
														 <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button> 
													</div>
							</div>
													
											</td>								
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