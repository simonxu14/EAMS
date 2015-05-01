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
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>trunk/html5.js"></script>
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
					<li><a href="#">Teacher</a><span class="divider"><i class="icon-caret-right"></i></span></li>
					<li>Teacher Information<span class="divider"><i class="icon-caret-right"></i></span></li>
					<li class="text-info">Update Teacher Inforomation </li>
				</ul>
			
				<div class="row-fluid">
					<div class="span8">
						
						<div class="well widget">
							<div class="widget-header">
								<h3 class="title">Update teacher information</h3>
							</div>
							<form class="form-horizontal" />
								
								
								
								<div class="control-group">
									<label class="control-label" for="inputEmail">Account</label>
									<div class="controls">
										<input type="text" id="inputEmail" placeholder="Account" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="inputPassword">Name</label>
									<div class="controls">
										<input type="text" id="inputPassword" placeholder="Name" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="inputPassword">Password</label>
									<div class="controls">
										<input type="password" id="inputPassword" placeholder="Password" />
									</div>
								</div>
                                
                                <div class="control-group">
                        <label>Teacher level</label>
									<select class="cselect span8" data-placeholder="Select teacher level..." >
										<option />
										<option value="Monster University in China" />professor
										<option value="Monster University in America" />adjunct professor
										<option value="Monster University in UK" />lecture
                                        <option value="Monster University in UK" />assistment
									</select>
                                    </div>
                                    <p></p>
                                    
								<div class="control-group">
									<label class="control-label" for="inputPassword">Photo</label>
									<div class="controls">
										<input type="file"/>
									</div>
								</div>
								
								<div class="control-group">
									<label class="control-label" for="inputPassword">Sex</label>
									<div class="controls">
										Male   <input type="checkbox"/></br>
										Female   <input type="checkbox"/>
									</div>
								</div>
																															
								<div class="control-group">
									<label class="control-label" for="inputEmail">ID card</label>
									<div class="controls">
										<input type="text" id="inputEmail" placeholder="ID card" />
									</div>
								</div>
								
								<div class="control-group">
									<label class="control-label" for="inputEmail">Phone</label>
									<div class="controls">
										<input type="text" id="inputEmail" placeholder="Phone" />
									</div>
								</div>
								
								<div class="control-group">
									<label class="control-label" for="inputEmail">QQ</label>
									<div class="controls">
										<input type="text" id="inputEmail" placeholder="QQ" />
									</div>
								</div>
								
								<div class="control-group">
									<label class="control-label" for="inputEmail">Address</label>
									<div class="controls">
										<input type="text" id="inputEmail" placeholder="Address" />
									</div>
								</div>
                                
                                	<div class="control-group">
									<label class="control-label" for="inputEmail">Graduated university
</label>
									<div class="controls">
										<input type="text" id="inputEmail" placeholder="Address" />
									</div>
								</div>
                                
                                <div class="control-group">
									<label class="control-label" for="inputEmail"> Class major
</label>
									<div class="controls">
										<input type="text" id="inputEmail" placeholder="Address" />
									</div>
								</div>
                                
                                <div class="control-group">
									<label class="control-label" for="inputEmail"> Class quantity
</label>
									<div class="controls">
										<input type="text" id="inputEmail" placeholder="Address" />
									</div>
								</div>
                                
                                 <div class="control-group">
									<label class="control-label" for="inputEmail"> Entrance date
</label>
									<div class="controls">
										<input type="text" id="inputEmail" placeholder="Address" />
									</div>
								</div>
                                
                                 <div class="control-group">
									<label class="control-label" for="inputEmail"> Leave date
</label>
									<div class="controls">
										<input type="text" id="inputEmail" placeholder="Address" />
									</div>
								</div>
                                
                                <div class="control-group">
									<label class="control-label" for="inputEmail"> Commission settlement


</label>
									<div class="controls">
										<input type="text" id="inputEmail" placeholder="Address" />
									</div>
								</div>
                                
                                <div class="control-group">
									<label class="control-label" for="inputEmail"> Comment


</label>
									<div class="controls">
										<input type="text" id="inputEmail" placeholder="Address" />
									</div>
								</div>

								
								
								
								<div class="control-group">
									<div class="controls">
									<button type="submit" class="btn btn-warning">Submit</button>
									</div>
								</div>
							</form>
						</div>
						
					</div>
				</div>
			</div>
			<!-- end main content -->
			
			
			
			
			
			
			
			
			
			
			<!-- sidebar -->
			<ul id="sidebar" class="nav nav-pills nav-stacked">
				<li class="avatar hidden-phone">
					<a href="#">
						<!-- ç¹å»é¾æ¥ -->
						<img src="<%=basePath %>library/images/100/06.png" />
						<!-- ç¨æ·ç§ç -->
						<span>Geunevere Calista</span>
						<!-- ç¨æ·åå­ -->
					</a>
				</li>
				
				
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<!-- æºææ¨¡åé¾æ¥ -->
						<i class="micon-tree-view"></i>
						<span class="hidden-phone">Organization</span>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="ï¼">
								<!-- æºæä¿¡æ¯é¾æ¥ -->
								<i class="icon-large icon-hdd"></i> Organization
							</a>
						</li>
						<li>
							<a href="ï¼">
								<!-- é¨é¨ä¿¡æ¯é¾æ¥ -->
								<i class="icon-large icon-sitemap"></i> Department
							</a>
						</li>
					</ul>
				</li>
				
				
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<!-- åå·¥æ¨¡åé¾æ¥ -->
						<i class="micon-user"></i>
						<span class="hidden-phone">Employee</span>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="ï¼">
								<!-- èå·¥å·¥ç§ä¿¡æ¯é¾æ¥ -->
								<i class="icon-large icon-cloud"></i> Position
							</a>
						</li>
						<li>
							<a href="ï¼">
								<!-- åå·¥ä¿¡æ¯é¾æ¥ -->
								<i class="icon-large icon-user"></i> Employee
							</a>
						</li>
					</ul>
				</li>
				
				
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<!-- å¹´çº§æ¨¡åé¾æ¥ -->
						<i class="micon-cube"></i>
						<span class="hidden-phone">Grade</span>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="ï¼">
								<!-- å¹´çº§ä¿¡æ¯é¾æ¥ -->
								<i class="icon-large icon-th-large"></i> Grade
							</a>
						</li>
						<li>
							<a href="ï¼">
								<!-- ç­çº§ä¿¡æ¯é¾æ¥ -->
								<i class="icon-large icon-stop"></i> Class
							</a>
						</li>
					</ul>
				</li>


				<li>
					<a href="#">
						<!-- å¹´åº¦æ¥ç¨é¾æ¥ -->
						<i class="micon-calendar"></i>
						<span class="hidden-phone">Schedule</span>
					</a>
				</li>
				
				
				<li>
					<a href="#">
						<!-- èå¤æ°æ®é¾æ¥ -->
						<i class="micon-pencil-2"></i>
						<span class="hidden-phone">Schedule</span>
					</a>
				</li>
				
				<li>
					<a href="#">
						<!-- æéæ°æ®é¾æ¥ -->
						<i class="micon-key-2"></i>
						<span class="hidden-phone">Power</span>
					</a>
				</li>
				
				<li>
					<a href="#">
						<!-- è¯¾ç¨æ°æ®é¾æ¥ -->
						<i class="micon-book"></i>
						<span class="hidden-phone">Class</span>
					</a>
				</li>
				
				<li>
					<a href="#">
						<!-- å­¦çæ°æ®é¾æ¥ -->
						<i class="micon-accessibility"></i>
						<span class="hidden-phone">Student</span>
					</a>
				</li>
				
                
					<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<!-- æå¸æ¨¡åé¾æ¥ -->
						<i class="micon-user-3"></i>
						<span class="hidden-phone">Teacher</span>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="ï¼">
								<!-- æå¸ä¿¡æ¯é¾æ¥ -->
								<i class="icon-large icon-user"></i> Teacher information
							</a>
						</li>
						<li>
							<a href="ï¼">
								<!-- æå¸ç­çº§ä¿¡æ¯é¾æ¥ -->
								<i class="icon-large icon-flag"></i> Teacher level  
							</a>
						</li>
					</ul>
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