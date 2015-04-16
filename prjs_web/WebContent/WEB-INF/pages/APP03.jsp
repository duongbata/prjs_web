<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link type="text/css" rel="stylesheet" href="resources/css/APP03.css" />
<div class="container">
	<form class="form-horizontal">
		<fieldset>
			<div class="form-group" style="width:300px">
				<label for="txtName" class="control-label col-xs-2">Name</label>
				<div class="col-xs-10">
					<div class="input-group">
						<span class="input-group-addon">
						<span class="glyphicon glyphicon-user"></span>
						</span>
						<input type="text" class="form-control input-sm" id="txtName">
					</div>
					<span class="help-block">Input Name</span>
				</div>
			</div>
			<div class="form-group" style="width:300px">
				<label for="txtPass" class="control-label col-xs-2">Pass</label>
				<div class="col-xs-10">
					<div class="input-group">
						
						<input type="password" class="form-control" id="txtPass">	
						<span class="input-group-btn">
							<%-- <span class="glyphicon glyphicon-file"></span> --%>
							<button type="button" class="btn btn-default">OK</button>
						</span>				
					</div>
				</div>			
			</div>
		</fieldset>
	</form>
</div>
<div class="container">
	<s:set var="contextPath" value="#request.get('javax.servlet.forward.context_path')"></s:set>
	<%-- <div class="col-md-6">
		<div class="thumbnail">
			<img src='${contextPath}/image/topic10.jpg' width="100px" height="100px"  class="img-circle" />
			<div class="caption">
				<h1>Bat ky</h1>
				<h3>abcabc </h3>
			</div>
		</div>
	</div>
	<div class="col-md-6">
		<div class="thumbnail">
			<img src='${contextPath}/image/topic11.jpg' width="100px" height="100px"  class="img-circle" />
			<div class="caption">
				<h1>Bat ky</h1>
				<h3>abcabc </h3>
			</div>
		</div>
	</div> --%>
	<div class="row">
		<ul class="media-list">
			<li class="media">
				<a href="#" class="pull-left">
					<img src='${contextPath}/image/topic11.jpg' width="100px" height="100px"  class="img-circle" />
				</a>
				<div class="media-body">
					<h4 class="media-heading">Jhon Carter <small><i>Posted on January 10, 2014</i></small></h4>
			        <p>X1</p>
				</div>
				<%-- <div class="media-body">
					<h4 class="media-heading">Jhon Carter <small><i>Posted on January 10, 2014</i></small></h4>
			        <p>X1</p>
			        <div class="media">
						<a href="#" class="pull-left">
							<img src='${contextPath}/image/topic10.jpg' width="100px" height="100px"  class="img-circle" />
						</a>
						<div class="media-body">
							<h4 class="media-heading">Jhon Carter <small><i>Posted on January 10, 2014</i></small></h4>
			        		<p>X11</p>
						</div>
					</div>
				</div> --%>
			</li>
			<li class="media">
				<a href="#" class="pull-left">
					<img src='${contextPath}/image/topic11.jpg' width="100px" height="100px"  class="img-circle" />
				</a>
				<div class="media-body">
					<h4 class="media-heading">Jhon Carter <small><i>Posted on January 10, 2014</i></small></h4>
			        <p>X2</p>
				</div>
			</li>
		</ul>
	</div>
</div>


