<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link type="text/css" rel="stylesheet" href="resources/css/bootstrap-datetimepicker.min.css" />
<link type="text/css" rel="stylesheet" href="resources/css/ADV03_2.css" />
<script type="text/javascript" src="resources/js/moment.js"></script>
<script type="text/javascript" src="resources/js/vi.js"></script>
<script type="text/javascript" src="resources/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="resources/js/ADV03_3.js"></script>
<script type="text/javascript">
            $(function () {
                $('#datetimepicker1').datetimepicker();
                $('#datetimepicker2').datetimepicker();
            });
</script>
<div class="container">
	<s:form action="ADV03_insertBannerSample">
	<div class="row">
		<div class="pull-left">
			<s:property value="message"/>
		</div>
		<div class="pull-right">
			<button type="submit" class="btn btn-default btn-xs" style="width:100px">
				<span class="glyphicon glyphicon-save"></span> Save
			</button>
		</div>
	</div>
	<div class="row">
        <div class="span12">
        		<table class="table table-condensed table-hover table-bordered">
	    			<caption align="top">Add banner</caption>
	    			<tbody>
	    				<tr>
	    					<td class="info" style="vertical-align: middle;">ID</td>
	    					<td style="vertical-align: middle;">
	    						<s:textfield name="bannerInsert.bannerId" id="id" cssClass="form-control"/>
	    					</td>
	    				</tr>
	    				<tr>
	    					<td class="info" style="vertical-align: middle;">Name</td>
	    					<td style="vertical-align: middle;">
	    						<s:textfield name="bannerInsert.bannerName" id="name" cssClass="form-control"/>
	    					</td>
	    				</tr>
	    				<tr>
	    					<td class="info" style="vertical-align: middle;">Description</td>
	    					<td style="vertical-align: middle;">
	    						<s:textfield name="bannerInsert.bannerDescription"  id="description"  cssClass="form-control"/>
	    					</td>
	    				</tr>
	    				<tr>
	    					<td class="info" style="vertical-align: middle;">Banner Type</td>
	    					<td style="vertical-align: middle;">
	    						<s:select name="bannerInsert.bannerType" list="allBannerType" listKey="key" listValue="value" id="bannerType" cssClass="form-control"/>
	    					</td>
	    				</tr>
	    				<tr>
	    					<td class="info" style="vertical-align: middle;">Image 1</td>
	    					<td style="vertical-align: middle;">
	    						<s:textfield name="bannerInsert.image1"  id="image1" cssClass="form-control"/>
	    					</td>
	    				</tr>
	    				<tr>
	    					<td class="info" style="vertical-align: middle;">Image 2</td>
	    					<td style="vertical-align: middle;">
	    						<s:textfield name="bannerInsert.image2"  id="image2" cssClass="form-control"/>
	    					</td>
	    				</tr>
	    				<tr>
	    					<td class="info" style="vertical-align: middle;">Android Url</td>
	    					<td style="vertical-align: middle;">
	    						<s:textfield name="bannerInsert.androidUrl"  id="url" cssClass="form-control"/>
	    					</td>
	    				</tr>
	    				<tr>
	    					<td class="info" style="vertical-align: middle;">Ios Url</td>
	    					<td style="vertical-align: middle;">
	    						<s:textfield name="bannerInsert.iosUrl"  id="url" cssClass="form-control"/>
	    					</td>
	    				</tr>
	    				<tr>
	    					<td class="info" style="vertical-align: middle;">Windows Url</td>
	    					<td style="vertical-align: middle;">
	    						<s:textfield name="bannerInsert.windowsUrl"  id="url" cssClass="form-control"/>
	    					</td>
	    				</tr>
	    			</tbody>
	    		</table>
    	</div>
	</div>
	</s:form>
</div>