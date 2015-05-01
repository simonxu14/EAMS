<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
		<link type="text/css" rel="stylesheet" href="<%=basePath %>css/validator.css" />
		<script src="<%=basePath %>js/validator.js"></script>
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
								<img class="thumb account-img" src="<%=basePath%>image/consult.jpg"/>
							</li>
							
							<li class="account-info">
								<h3>Consult Monster</h3>
								<p>I'm a child, I want to join in the Monster University!</p>
								<p>
									<a href="<%=basePath%>index.jsp">Edit</a>
								</p>
							</li>
							
							<li class="account-footer">
								<div class="row-fluid">
									
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
			
				<div class="row-fluid">
					<div class="span8">
						
						<div class="well widget">
							<div class="widget-header">
								<h3 class="title">Add Consult Student Information</h3>
							</div>
							<form id="addConsultStudent" class="form-horizontal" action="student!myAddConsultStudent.action" method="post">
								
								<div class="control-group">
									<label class="control-label" for="inputEmail">Name</label>
									<div class="controls">
										<input type="text" id="name" placeholder="Name" name="stuconsult.stuConsultName" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="inputPassword">Age</label>
									<div class="controls">
										<input type="text" id="age" placeholder="Age" name="stuconsult.consultAge"/>
									</div>
								</div>
								
								<div class="control-group">
									<label class="control-label" for="inputPassword">Gender</label>
									<div class="controls">
										   <input type="checkbox" id="sex" value="true" name="stuconsult.consultSex"/> Male &nbsp;
										   <input type="checkbox" id="sex" value="false" name="stuconsult.consultSex"/> Female
									</div>
								</div>
								
								<div class="control-group">
									<label class="control-label" for="inputPassword">School</label>
									<div class="controls">
										<input type="text" placeholder="School" name="stuconsult.consultSchool"/>
									</div>
								</div>								
								
								<div class="control-group">
									<label class="control-label" for="inputPassword">telephone</label>
									<div class="controls">
										<input type="text" id="phone" placeholder="Telephone" name="stuconsult.consulTel"/>
									</div>
								</div>
								
								<div class="control-group">
									<label class="control-label">major</label>
									<div class="controls">
									
										<input type="hidden" value="1000" name="stuconsult.consultCost"/>
										<input type="text" placeholder="Major" name="stuconsult.consultMajor"/>
									</div>
								</div>
								
								<div class="control-group">
									<label class="control-label">Address</label>
									<div class="controls">
										<input type="text" placeholder="Address" name="stuconsult.consultAddress"/>
									</div>
								</div>
								
								<div class="control-group">
									<label class="control-label">comment</label>
									<div class="controls">
										<input type="text" placeholder="Comment" name="stuconsult.consultComment"/>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">Consulting way</label>
									<div class="controls">
										<select class="chzn-select-deselect span8" data-placeholder="Select Consult Way..." name="stuconsult.consultWay">
											<option />
											<option value="On-site Consulting"/>On-site Consulting
											<option value="Telephone Counsulting" />Telephone Counsulting
											<option value="Website Consulting" />Website Consulting
										</select>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">Realizing Channel</label>
									<div class="controls">
										<select class="chzn-select-deselect span8" data-placeholder="Select Realizing Channel..." name="stuconsult.consultChannel">
											<option />
											<option value="Advertisement Board"/>Advertisement Board
											<option value="Activity Publicity" />Activity Publicity
											<option value="Advertisement Publicity" />Advertisement Publicity
											<option value="Internet Publicity" />Internet Publicity
											<option value="Introducing Of Others" />Introducing Of Others
											<option value="Presentation Of the Elder Students" />Presentation Of the Elder Students
											<option value="Introducing Of Teachers" />Introducing Of Teachers
										</select>
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
			 	var myValidator = new Eui.Validator(document.getElementById('addConsultStudent'),
				[{
					name: 'name',
					rules: 'required'
				},
				{
					name: 'age',
					rules: 'isnumber'
				},
				{
					name: 'sex',
					rules: 'required'
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
						addConsultStudent.submit();
					}
				}
			</script>
			<!-- end main content -->
			
		
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
	

	
	
</html>