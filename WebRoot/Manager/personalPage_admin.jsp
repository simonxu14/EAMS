<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<base href="<%=basePath%>"/>
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
							    <dt>Organization</dt>
							    <dd>
							    	<span class="icon-wrapper">
									    <i class="micon-briefcase-2"></i>
								    </span>
								    <p>Monster University in America</p>
								   
							    </dd>
							    <dt>Department</dt>
							    <dd>
								    <span class="icon-wrapper">
									    <i class="micon-drawer-2"></i>
								    </span>
								    <p>Financial Management Department</p>
							    </dd>
							    <dt>Position</dt>
							    <dd>
								    <span class="icon-wrapper">
									    <i class="micon-tag"></i>
								    </span>
								    <p>Manager</p>
							    </dd>
							    <dt>Name</dt>
							    <dd>
								    <span class="icon-wrapper">
									    <i class="micon-happy"></i>
								    </span>
								    <p>Simon Xu</p>
							    </dd>
							    <dt>Sex</dt>
							    <dd>
								    <span class="icon-wrapper">
									    <i class="micon-heart"></i>
								    </span>
								    <p>Male</p>
							    </dd>
							    <dt>Birthday</dt>
							    <dd>
								    <span class="icon-wrapper">
									    <i class="micon-gift"></i>
								    </span>
								    <p>Sep 14, 1992</p>
							    </dd>
							    <dt>Phone</dt>
							    <dd>
								    <span class="icon-wrapper">
									    <i class="micon-phone"></i>
								    </span>
								    <p>18200260509</p>
							    </dd>
							    <dt>QQ/twitter</dt>
							    <dd>
								    <span class="icon-wrapper">
									    <i class="micon-twitter-2"></i>
								    </span>
								    <p>784121690</p>
							    </dd>
							    <dt>Address</dt>
							    <dd>
								    <span class="icon-wrapper">
									    <i class="micon-home-2"></i>
								    </span>
								    <p>Beijing</p>
							    </dd>
								
						    </dl>
							<center>
						    <a class="btn btn-flat btn-warning btn-mini" href="#">Update</a>
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
						<div class="well widget widget-map hidden-phone">							
							<!-- widget content -->
							<div id="map1" class="map-wrapper bs-map" style="height:270px;"></div>
							<div id="map-side-bar" class="mapSidebar thumbs">
								<h3 class="title text-warning">Monster Online</h3>
								
								<div class="map-location" data-jmapping="{id: 1, point: {lng: 106.697135581519, lat: 10.772981071794}, category: 'hotel'}">
									<a href="#" class="map-link"><img src="http://lorempixel.com/40/40/people/1/" /></a>
									<div class="info-box hide">
										<p class="map-info-content">
											<a href="#">
												<img class="pull-left img-circle avatar" src="http://lorempixel.com/50/50/people/1/" />
											</a>
											<span class="user-name">
												<a href="#">Paenah</a>
											</span>
											<span class="recent-status">
												Dived cursed far some sprang fetchingly that willfully
											</span>
										</p>
									</div>
								</div>
								
								<div class="map-location" data-jmapping="{id: 2, point: {lng: 106.693530000000, lat: 10.771463000000}, category: 'hotel'}">
									<a href="#" class="map-link"><img src="http://lorempixel.com/40/40/people/3/" /></a>
									<div class="info-box hide">
										<p class="map-info-content">
											<a href="#">
												<img class="pull-left img-circle avatar" src="http://lorempixel.com/50/50/people/3/" />
											</a>
											<span class="user-name">
												<a href="#">Ponidjan</a>
											</span>
											<span class="recent-status">
												Dived cursed far some sprang fetchingly that willfully
											</span>
										</p>
									</div>
								</div>								
								
								<div class="map-location" data-jmapping="{id: 3, point: {lng: 106.705044000000, lat: 10.778864000000}, category: 'hotel'}">
									<a href="#" class="map-link"><img src="http://lorempixel.com/40/40/people/6/" /></a>
									<div class="info-box hide">
										<p class="map-info-content">
											<a href="#">
												<img class="pull-left img-circle avatar" src="http://lorempixel.com/50/50/people/6/" />
											</a>
											<span class="user-name">
												<a href="#">Sarmini</a>
											</span>
											<span class="recent-status">
												Dived cursed far some sprang fetchingly that willfully
											</span>
										</p>
									</div>
								</div>
								
								<div class="map-location" data-jmapping="{id: 4, point: {lng: 106.702903747558, lat: 10.778756141662}, category: 'hotel'}">
									<a href="#" class="map-link"><img src="http://lorempixel.com/40/40/people/7/" /></a>
									<div class="info-box hide">
										<p class="map-info-content">
											<a href="#">
												<img class="pull-left img-circle avatar" src="http://lorempixel.com/50/50/people/7/" />
											</a>
											<span class="user-name">
												<a href="#">Juminten</a>
											</span>
											<span class="recent-status">
												Dived cursed far some sprang fetchingly that willfully
											</span>
										</p>
									</div>
								</div>
								
								<div class="map-location" data-jmapping="{id: 5, point: {lng: 106.704818725585, lat: 10.776082992553}, category: 'hotel'}">
									<a href="#" class="map-link"><img src="http://lorempixel.com/40/40/people/8/" /></a>
									<div class="info-box hide">
										<p class="map-info-content">
											<a href="#">
												<img class="pull-left img-circle avatar" src="http://lorempixel.com/50/50/people/8/" />
											</a>
											<span class="user-name">
												<a href="#">Mlorotwati</a>
											</span>
											<span class="recent-status">
												Dived cursed far some sprang fetchingly that willfully
											</span>
										</p>
									</div>
								</div>

							</div>
							<!-- ./ widget content -->							
						</div>
						<!-- ./ widget -->
						
						<form method="post" action="" />
							<!-- widget -->
							<div class="well widget kuta-editor">
								<!-- widget header -->
								<div class="widget-header">
									<h3 class="title">Add New Post</h3>
								</div>
								<!-- ./ widget header -->
								
								<!-- widget content -->
								<textarea id="redactor_content" class="fullRedactor" name="content"></textarea>
								<!-- ./ widget content -->
								
							</div>
							<!-- ./ widget -->
							
							<div class="option-wrapper">
								<label class="checkbox inline">
									<input type="checkbox" class="fancy" /> Allow comment
								</label>
								<label class="checkbox inline">
									<input type="checkbox" class="fancy" /> Allow trackback
								</label>
							</div>
							
							<div class="action-wrapper">
								<div class="pull-left">
									<input type="text" value="11-30-2012" class="datePicker" id="datepicker1" placeholder="publish date" /><span class="help-inline">Published date</span>
								</div>
								<div class="pull-right">
									<button class="btn btn-flat btn-primary" type="submit">save</button> 
									<button class="btn btn-flat btn-danger" type="button">publish</button>
								</div>
							</div>
							
						</form>
						
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