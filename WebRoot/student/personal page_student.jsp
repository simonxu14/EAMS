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
								<img class="thumb account-img" src="<%=basePath%>${student.stuPhoto}"/>
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
					<li><a href="#">Home</a> <span class="divider"></span></li>
					<!-- 主页链接 -->
				</ul>
				
				<!-- post wrapper -->				
				<div class="row-fluid">
				
					<div class="span4">
						<div class="well widget">
							<div class="widget-header">
								<h3 class="title">Personal Information</h3>
							</div>
							
						    <dl class="dl-icon">
							    <dt>University</dt>
							    <dd>
							    	<span class="icon-wrapper">
									    <i class="micon-briefcase-2"></i>
								    </span>
								    <p>Monster University in America</p>
								   
							    </dd>
							    <dt>Name</dt>
							    <dd>
								    <span class="icon-wrapper">
									    <i class="micon-drawer-2"></i>
								    </span>
								    <p>${student.stuName}</p>
							    </dd>
								<dt>Sex</dt>
							    <dd>
								    <span class="icon-wrapper">
									    <i class="micon-heart"></i>
								    </span>
								    <p>
								    <script type="text/javascript">
										var b = ${student.stuSex};
										if(b == 1){
											document.write("Male");
										}
										else{
											document.write("Female");
										} 
									</script>
								    
								    </p>
							    </dd>
							    <dt>Account</dt>
							    <dd>
								    <span class="icon-wrapper">
									    <i class="micon-tag"></i>
								    </span>
								    <p>${student.stuAccount}</p>
							    </dd>
							    <dt>Major</dt>
							    <dd>
								    <span class="icon-wrapper">
									    <i class="micon-happy"></i>
								    </span>
								    <p>${student.stuMajor}</p>
							    </dd>
							    <dt>Phone</dt>
							    <dd>
								    <span class="icon-wrapper">
									    <i class="micon-phone"></i>
								    </span>
								    <p>${student.stuTel}</p>
							    </dd>
							    <dt>Balance</dt>
							    <dd>
								    <span class="icon-wrapper">
									    <i class="micon-twitter-2"></i>
								    </span>
								    <p>${student.stuBalance}</p>
							    </dd>
							    <dt>Address</dt>
							    <dd>
								    <span class="icon-wrapper">
									    <i class="micon-home-2"></i>
								    </span>
								    <p>${student.stuAddress}</p>
							    </dd>
								
						    </dl>
							<center>
						    <a class="btn btn-flat btn-warning btn-mini" href="student!showStudentInfoForUpdate.action">Update</a>
							</center>
						</div>
						
						<div class="well widget" style="height:25px;">
							<!-- widget header -->
							<div class="widget-header">
								<h3 class="title">Semester</h3>
							</div>
							<!-- ./ widget header -->
							
							<!-- widget content -->
							<div class="progress mini progress-warning">
								<div class="bar top_tooltip" style="width: 50%" title="50%"></div>
							</div>
							<!-- ./ widget content -->
							
						</div>
						
						<div class="well widget" style="height:25px;">
							<!-- widget header -->
							<div class="widget-header">
								<h3 class="title">Work</h3>
							</div>
							<!-- ./ widget header -->
							
							<!-- widget content -->
							<div class="progress mini progress-danger">
								<div class="bar top_tooltip" style="width: 70%" title="70%"></div>
							</div>
							<!-- ./ widget content -->
							
						</div>
						
						
						<!-- widget -->
						<div class="well widget">
							<!-- widget header -->
							<div class="widget-header">
								<h3 class="title">Latest News</h3>
							</div>
							<!-- ./ widget header -->
							
							<!-- media object -->
							<div class="media media-feed">
								<div class="media-body">
									<a href="#"><h4 class="media-heading">Monster</h4></a>
									<p class="meta">
										<span class="tags"><a href="#" class="text-warning">There are a lot of monsters in the university</a></span>
									</p>
									<p class="excerpt">Welcome to Monster University!</p>
								</div>
							</div>
							<!-- ./ media object -->
							
							<!-- media object -->
							<div class="media media-feed">
								<div class="media-body">
									<a href="#"><h4 class="media-heading">Teacher</h4></a>
									<p class="meta">
										<span class="tags"><a href="#" class="text-warning">The Best Teacher in Monster University</a></span>
									</p>
									<p class="excerpt">The best monster teacher!</p>
								</div>
							</div>
							<!-- ./ media object -->
							
						</div>
						<!-- ./ widget -->
						
						
						<!-- custom alert -->
						<div class="c-alert" style="margin-bottom:20px;">
							<div class="alert-message error">
								<a class="close" href="#">
									<i class="icon-large icon-remove-circle"></i>
								</a>
								<strong>Alert</strong>! Do not make any monster angry!
							</div>
						</div>
						<!-- ./ custom alert -->
						
					</div>
					
					<div class="span8">
					
						<!-- widget -->
						<div class="well bg-d widget">
							<!-- widget header -->
							<div class="widget-header">
								<h3 class="title">Panels</h3>
								<div class="widget-nav">
									<div class="dropdown nav-item">
										<a href="#" class="dropdown-toggle" data-toggle="dropdown">
											<i class="icon-cog"></i>
										</a>
										<ul class="dropdown-menu pull-right">
											<li>
												<a href="#">Action</a>
											</li>
											<li>
												<a href="#">Another action</a>
											</li>
											<li>
												<a href="#">Something else here</a>
											</li>
										</ul>
									</div>
								</div>
							</div>
							<!-- ./ widget header -->
							
							<!-- widget content -->
							<div class="widget-content">
								<div class="btn-circle-panel large">
									<ul class="btn-circle">
										<li class="danger">
											<a href="#" class="bottom_tooltip" title="projects">
												<i class="icon-tasks text-error"></i>
											</a>
										</li>
										<li class="info">
											<a href="#" class="bottom_tooltip" title="Item sold">
												<i class="icon-shopping-cart text-info"></i>
											</a>
										</li>
										<li class="success">
											<a href="#" class="bottom_tooltip" title="Friend requests">
												<i class="icon-user text-success"></i>
											</a>
										</li>
										<li class="warning">
											<a href="#" class="bottom_tooltip" title="Messages">
												<i class="icon-comments text-warning"></i>
											</a>
										</li>
									</ul>
								</div>
							</div>
							<!-- ./ widget content -->
							
						</div>
						<!-- ./ widget -->
					
						<!-- widget -->
						
						
						
						
						<!-- widget -->
						<div class="well widget">
							<!-- widget header -->
							<div class="widget-header">
								<h3 class="title">Recent Posts</h3>
								<div class="widget-nav">
									
								</div>
							</div>
							<!-- ./ widget header -->
							
							<div class="row-fluid">
								<div class="span6">
									<p class="meta uppercase large">
										<span class="tags">
											<a href="#" class="text-info"><i class="icon-comments"></i> 12</a>
										</span>
										<span class="date">Nov 30, 2012</span>
									</p>
									<a href="#">
										<h3>The Adventure of Rujak Uleg</h3>
									</a>
									<img class="img-featured" src="http://lorempixel.com/600/300/people/1/" />
									<p>Dived cursed far some sprang fetchingly that willfully oriole far more reined oh overshot jeez arbitrarily much that dissolutely put more one amidst other then quizzically...</p>
								</div>
								<div class="span6">
									<p class="meta uppercase large">
										<span class="tags"><a href="#" class="muted"><i class="icon-comments"></i></a></span>
										<span class="date">Dec 01, 2012</span>
									</p>
									<a href="#">
										<h3>Begadang Jangan Begadang</h3>
									</a>
									<img class="img-featured" src="http://lorempixel.com/600/300/nature/3/" />
									<p>Dived cursed far some sprang fetchingly that willfully oriole far more reined oh overshot jeez arbitrarily much that dissolutely put more one amidst other then quizzically...</p>
								</div>
							</div>
							
						</div>
						<!-- ./ widget -->
						
					</div>
				</div>
				<!-- ./ post wrapper -->
			</div>
			<!-- end main content -->
			
			
			
			
			
			
			
			
			
			
			<!-- sidebar -->
		<div>
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
				
				
				
			
		</div>
		
		<!-- external api -->
		<script src="http://maps.google.com/maps/api/js?v=3.5&sensor=false"></script>
		
		<!-- base -->
		<script src="<%=basePath %>library/assets/js/jquery.js"></script>
		<script src="<%=basePath %>library/assets/js/bootstrap.min.js"></script>
		
		<!-- addons -->
		<script src="<%=basePath %>library/plugins/chart-plugins.js"></script>
		<script src="<%=basePath %>library/plugins/jquery-ui-slider.js"></script>
		<script src="ibrary/plugins/redactor/redactor.min.js"></script>
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