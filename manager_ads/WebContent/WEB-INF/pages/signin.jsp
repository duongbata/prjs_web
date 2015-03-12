<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng kí</title>
<script type="text/javascript" src="resources/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="resources/js/jquery-1.11.1.min.js"></script>
<%-- <script type="text/javascript" src="resources/js/jquery-latest.min.js"></script> --%>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/signin.js"></script>
<link type="text/css" rel="stylesheet"
	href="resources/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<s:set name="message" value="message" />
			<s:if test="%{#message != null}">
				<p class="text-left text-danger">
					<s:label name="message" />
				</p>
			</s:if>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Đăng kí</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<div style="display: none" id="login-alert"
						class="alert alert-danger col-sm-12"></div>

					<s:form action="signon" id="loginform" class="form-horizontal"
						onsubmit="return validateSignin();">

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
							<!-- <input id="login-username" type="text" class="form-control" name="username" value="" placeholder="user id"> -->
							<s:textfield id="login-username" cssClass="form-control"
								name="user.id" value="" placeholder="user id" />
						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-lock"></i>
							</span> 
							<!-- <input id="login-password" type="password" class="form-control" name="password" placeholder="password"> -->
							<s:password id="login-password" cssClass="form-control" name="user.password"  placeholder="password"></s:password>
						</div>
						<div style="margin-top: 10px" class="form-group">
							<!-- Button -->
							<div class="col-md-12 controls">
								<!-- <a id="btn-login" href="#" class="btn btn-success">Login </a>  -->
								<s:submit id="btn-login" cssClass="btn btn-success"
									value="Đăng kí" />
								&nbsp;&nbsp;
								<s:a action="login">Đăng nhập</s:a>
							</div>
						</div>
					</s:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>