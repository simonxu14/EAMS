<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/struts-tags" prefix="s"%>
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
					<li class="text-info">Update Personal Information</li>
				</ul>
			
				<div class="row-fluid">
					<div class="span8">
						
						<div class="well widget">
							<div class="widget-header">
								<h3 class="title">Update Personal Information</h3>
							</div>
							<form class="form-horizontal" action="student!StudentUpdateUpload.action?student.stuId=${student.stuId}" method="post" enctype="multipart/form-data">
								<h4>Update Head Portrait</h4>
									<div class="control-group">
										<label class="control-label" for="inputPassword">Photo</label>
										<div class="controls">
											   <input type="file" name="upload" class="span6 fancy"/>&nbsp;
												<button type="submit" class="btn btn-flat btn-small btn-primary">Upload Pic</button>
										</div>
									</div>
							</form>
							<form class="form-horizontal" id="updateStuInfo" action="student!updateStuInfo.action" method="post"/>
								<h4>Update Personal Information</h4>
								
								<div class="control-group">
									<label class="control-label" >ID</label>
									<div class="controls">
										${student.stuId}<input type="text"  placeholder="Account" name="student.stuId" value="${student.stuId}" style="visibility: hidden;"/>
									</div>
								</div>
								
								<div class="control-group">
									<label class="control-label" for="inputEmail">Account</label>
									<div class="controls">
										<input type="text" id="account" placeholder="Account" name="student.stuAccount" value="${student.stuAccount}"/>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="inputPassword">Name</label>
									<div class="controls">
										<input type="text" id="name" placeholder="Name" name="student.stuName" value="${student.stuName}"/>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="inputPassword">Password</label>
									<div class="controls">
										<input type="password" id="password1" placeholder="Password" name="student.stuPassword" value="${student.stuPassword}"/>
									</div>
								</div>	
								
								<div class="control-group">
									<label class="control-label" for="inputPassword">Repeat Password</label>
									<div class="controls">
										<input type="password" id="password2" placeholder="Repeat Password"/>
									</div>
								</div>							
								
								<div class="control-group">
									<label class="control-label" for="inputPassword">Gender</label>
									<div class="controls">
										   <input type="checkbox" id="sex" value="1" name="student.stuSex"/> Male &nbsp;
										   <input type="checkbox" id="sex" value="0" name="student.stuSex"/> Female
									</div>
								</div>
								
								
								<div class="control-group">
									<label class="control-label" for="inputPassword">Birthday</label>
									<div class="controls">
										<input type="text" value='<s:date name="student.stuBirth" format="MM-dd-yyyy"/>' name="student.stuBirth" class="datePicker" id="datepicker1" placeholder="publish date" /><span class="help-inline"></span>
									</div>
								</div>
								
								<div class="control-group">
									<label class="control-label">School</label>
									<div class="controls">
										<input type="text" name="student.stuSchool" value="${student.stuSchool}"/>
									</div>
								</div>
								
								<div class="control-group">
									<label class="control-label">Address</label>
									<div class="controls">
										<input type="text" placeholder="Address" name="student.stuAddress" value="${student.stuAddress}"/>
									</div>
								</div>
								
								<div class="control-group">
									<label class="control-label">Major</label>
									<div class="controls">
										<input type="text" placeholder="Major" name="student.stuMajor" value="${student.stuMajor}"/>
									</div>
								</div>
								
								<div class="control-group">
									<label class="control-label">Phone</label>
									<div class="controls">
										<input type="text" id="phone" placeholder="Phone" name="student.stuTel" value="${student.stuTel}"/>
									</div>
								</div>
							
								<div class="control-group">
									<label class="control-label" >Comment</label>
									<div class="controls">
										<input type="text" placeholder="Comment" name="student.stuComment" value="${student.stuComment}"/>
									</div>
								</div>
								
								
								
								<div class="control-group">
									<div class="controls">
									<button type="button" onclick="check()" class="btn btn-flat btn-v">Submit</button>&nbsp;
									<button type="reset" class="btn btn-flat btn-z"> Reset</button>
									</div>
								</div>
							</form>
						</div>
						
					</div>
				</div>
			</div>
			
			<script>
			 	var myValidator = new Eui.Validator(document.getElementById('updateStuInfo'),
				[{
					name: 'name',
					rules: 'required'
				},
				{
					name: 'account',
					rules: 'required'
				},
				{
					name: 'sex',
					rules: 'required'
				},
				{
					 name: 'password1, password2',
                	 rules: 'required, password'
				},
				{
					name: 'phone',
					rules: 'required'
				}],{
					requiredMsg: 'cannot be empty'
				});
				function check(){
					if(!myValidator){
						alert("please check the inputs");
					}else{
						updateStuInfo.submit();
					}
				}
			</script>
			
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