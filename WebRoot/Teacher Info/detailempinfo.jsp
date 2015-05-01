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
								<img class="thumb account-img" src="<%=basePath %>library/images/100/07.png" />
							</li>
							
							<li class="account-info">
								<h3>Geunevere Calista</h3>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
								<p>
									<a href="#">Edit</a> | <a href="#">Account Settings</a>
								</p>
							</li>
							
							<li class="account-footer">
								<div class="row-fluid">
								
									<div class="span8">
										<a class="btn btn-small btn-primary btn-flat" href="#">Change avatar</a>
									</div>
									
									<div class="span4 align-right">
										<a class="btn btn-small btn-danger btn-flat" href="#">Logout</a>
									</div>
									
								</div>									
							</li>
							
						</ul>
					</li>
					<!-- ./ dropdown user account -->
				</ul>
				
				<!-- search form -->
				<form class="navbar-search pull-right hidden-phone" action="" />
					<input type="text" class="search-query span4" placeholder="search..." />
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
								<span class="large text-warning">Thursday</span>
								<span class="mini muted">week</span>
							</li>
							<li>
								<span class="large text-info">March</span>
								<span class="mini muted">month</span>
							</li>
							<li>
								<span class="large text-success">13</span>
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
					<li>Teacher<span class="divider"><i class="icon-caret-right"></i></span></li>
					<li><a href="#">Teacher Information</a> <span class="divider"><i class="icon-caret-right"></i></span></li>
					<li class="text-info">Show teacher information</li>
				</ul>
			
				<div class="row-fluid">
					<div class="span6">
						
						<div class="well widget">
							<div class="widget-header">
								<h3 class="title">Teacher Information</h3>
							</div>
							
						    <dl class="dl-icon">
							    						
								<dt>Account</dt>
								    <dd>
									    <span class="icon-wrapper">
										    <i class="micon-rocket"></i>
									    </span>
									    <p>724895806</p>
							    <dt>Name</dt>
							    <dd>
								    <span class="icon-wrapper">
									    <i class="micon-happy"></i>
								    </span>
								    <p>章毅</p>
							    </dd>
							    <dt>Sex</dt>
							    <dd>
								    <span class="icon-wrapper">
									    <i class="micon-heart"></i>
								    </span>
								    <p>Male</p>
							    </dd>
							    <dt>Identity Card No.</dt>
							    <dd>
								    <span class="icon-wrapper">
									    <i class="micon-newspaper		"></i>
								    </span>
								    <p>546987195504190648</p>
							    </dd>
							    <dt>Mobile Phone No.</dt>
							    <dd>
								    <span class="icon-wrapper">
									    <i class="micon-phone"></i>
								    </span>
								    <p>18201668686</p>
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
								    <p>四川大学江安校区二级楼5楼</p>
							    </dd>
                                
                                 <dt>Graduated university</dt>
							    <dd>
								    <span class="icon-wrapper">
									    <i class="micon-trophy"></i>
								    </span>
								    <p>SCU</p>
							    </dd>
                                
                                <dt>Class major</dt>
							    <dd>
								    <span class="icon-wrapper">
									    <i class="micon-glasses"></i>
								    </span>
								    <p>software engineering</p>
							    </dd>
                                
                                <dt>Class quantity</dt>
							    <dd>
								    <span class="icon-wrapper">
									    <i class="micon-grid-view"></i>
								    </span>
								    <p>10</p>
							    </dd>
                                
                                
							    <dt>Entrance date</dt>
							    <dd>
								    <span class="icon-wrapper">
									    <i class="micon-user-3"></i>
								    </span>
								    <p>05/05/2005</p>
							    </dd>
                                
							    <dt>Leave date</dt>
							    <dd>
								    <span class="icon-wrapper">
									    <i class="micon-blocked"></i>
								    </span>
								    <p>-</p>
							    </dd>
                                
                                <dt>Commission settlement</dt>
							    <dd>
								    <span class="icon-wrapper">
									    <i class="micon-cart"></i>
								    </span>
								    <p>支票支付</p>
							    </dd>
                                
                                <dt>Comment</dt>
							    <dd>
								    <span class="icon-wrapper">
									    <i class="micon-pencil-2"></i>
								    </span>
								    <p>大BOSS</p>
							    </dd>
								
						    </dl>
                            <center>
						    <a class="btn btn-flat btn-warning btn-mini" href="#">Update</a>
							<a class="btn btn-flat btn-warning btn-mini" href="#">Delete</a>
							</center>
						</div>
						
					</div>
				</div>
			</div>
			<!-- end main content -->
			
			
			
			
			
			
			
			
			
			
			<!-- sidebar -->
			<ul id="sidebar" class="nav nav-pills nav-stacked">
				<li class="avatar hidden-phone">
					<a href="#">
						<!-- 点击链接 -->
						<img src="<%=basePath %>library/images/100/06.png" />
						<!-- 用户照片 -->
						<span>Geunevere Calista</span>
						<!-- 用户名字 -->
					</a>
				</li>
				
				
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<!-- 机构模块链接 -->
						<i class="micon-tree-view"></i>
						<span class="hidden-phone">Organization</span>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="＃">
								<!-- 机构信息链接 -->
								<i class="icon-large icon-hdd"></i> Organization
							</a>
						</li>
						<li>
							<a href="＃">
								<!-- 部门信息链接 -->
								<i class="icon-large icon-sitemap"></i> Department
							</a>
						</li>
					</ul>
				</li>
				
				
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<!-- 员工模块链接 -->
						<i class="micon-user"></i>
						<span class="hidden-phone">Employee</span>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="＃">
								<!-- 职工工种信息链接 -->
								<i class="icon-large icon-cloud"></i> Position
							</a>
						</li>
						<li>
							<a href="＃">
								<!-- 员工信息链接 -->
								<i class="icon-large icon-user"></i> Employee
							</a>
						</li>
					</ul>
				</li>
				
				
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<!-- 年级模块链接 -->
						<i class="micon-cube"></i>
						<span class="hidden-phone">Grade</span>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="＃">
								<!-- 年级信息链接 -->
								<i class="icon-large icon-th-large"></i> Grade
							</a>
						</li>
						<li>
							<a href="＃">
								<!-- 班级信息链接 -->
								<i class="icon-large icon-stop"></i> Class
							</a>
						</li>
					</ul>
				</li>


				<li>
					<a href="#">
						<!-- 年度日程链接 -->
						<i class="micon-calendar"></i>
						<span class="hidden-phone">Schedule</span>
					</a>
				</li>
				
				
				<li>
					<a href="#">
						<!-- 考勤数据链接 -->
						<i class="micon-pencil-2"></i>
						<span class="hidden-phone">Schedule</span>
					</a>
				</li>
				
				<li>
					<a href="#">
						<!-- 权限数据链接 -->
						<i class="micon-key-2"></i>
						<span class="hidden-phone">Power</span>
					</a>
				</li>
				
				<li>
					<a href="#">
						<!-- 课程数据链接 -->
						<i class="micon-book"></i>
						<span class="hidden-phone">Class</span>
					</a>
				</li>
				
				<li>
					<a href="#">
						<!-- 学生数据链接 -->
						<i class="micon-accessibility"></i>
						<span class="hidden-phone">Student</span>
					</a>
				</li>
				
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<!-- 教师模块链接 -->
						<i class="micon-user-3"></i>
						<span class="hidden-phone">Teacher</span>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="＃">
								<!-- 教师信息链接 -->
								<i class="icon-large icon-user"></i> Teacher information
							</a>
						</li>
						<li>
							<a href="＃">
								<!-- 教师等级信息链接 -->
								<i class="icon-large icon-flag"></i> Teacher level  
							</a>
						</li>
			</ul>
			<!-- end sidebar -->
		</div>
		
		<!-- external api -->
		<script src="http://maps.google.com/maps/api/js?v=3.5&sensor=false"></script>
		
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