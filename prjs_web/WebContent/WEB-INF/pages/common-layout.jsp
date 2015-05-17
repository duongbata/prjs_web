<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><tiles:getAsString name="title" /></title>
<tiles:insertAttribute name="styles" />
<tiles:insertAttribute name="scripts" />
</head>
<body>
	<div>
		<tiles:insertAttribute name="header" />
	</div>
	<div>
		<tiles:insertAttribute name="body" />
	</div>
	<div class="container">
		<div class="row">
			<div id="myModal" class="modal fade"  data-backdrop="static">
				<div class="modal-dialog modal-sm" >
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
<!-- 							<h4>Confirmation</h4> -->
						</div>
						<div class="modal-body">
<!-- 							<p>Are you alright ?</p> -->
						</div>
						<div class="modal-footer">
							<input type="button" class="btn btn-primary" data-dismiss="modal" value="Close">
<!-- 							<input type="button" class="btn btn-success" value="OK"> -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>