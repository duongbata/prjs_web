<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link type="text/css" rel="stylesheet" href="resources/css/APP03.css" />
<script type="text/javascript" src="resources/js/APP03.js"></script>
<div class="container">
	<s:set var="contextPath" value="#request.get('javax.servlet.forward.context_path')"></s:set>
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
		<input type="button" class="btn btn-primary" value = "Click" id="demo">
	</div>
	<div class="row" style="margin-top: 10px">
		<ul class="nav nav-tabs" id="myTab">
			<li class="active">
				<a href="#sectionA">
					SectionA
				</a>
			</li>
			<li>
				<a href="#sectionB">
					SectionB
				</a>
			</li>
			<li class="dropdown">
				<a data-toggle="dropdown" class="dropdown-toggle" href="#">
					Dropdow<b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li>
						<a href="#sectionC">SectionC</a>
					</li>
					<li>
						<a href="#sectionD">SectionD</a>
					</li>
				</ul>
			</li>
		</ul>
		<div class="tab-content">
			<div id="sectionA" class="tab-pane fade in active">
				<p>SectionA</p>
			</div>
			<div id="sectionB" class="tab-pane fade">
				<p>SectionB</p>
			</div>
			<div id="sectionC" class="tab-pane fade">
				<p>SectionC</p>
			</div>
			<div id="sectionD" class="tab-pane fade">
				<p>SectionD</p>
			</div>
		</div>
		<div class="bs-example"></div>
	</div>
</div>


