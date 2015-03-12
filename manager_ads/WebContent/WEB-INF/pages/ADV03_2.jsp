<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link type="text/css" rel="stylesheet" href="resources/css/bootstrap-datetimepicker.min.css" />
<link type="text/css" rel="stylesheet" href="resources/css/ADV03_2.css" />
<script type="text/javascript" src="resources/js/moment.js"></script>
<script type="text/javascript" src="resources/js/vi.js"></script>
<script type="text/javascript" src="resources/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="resources/js/ADV03_2.js"></script>
<script type="text/javascript">
            $(function () {
                $('#datetimepicker1').datetimepicker();
                $('#datetimepicker2').datetimepicker();
            });
</script>
<div class="container">
	<div class="row">
        <div class="span12">
    		<table class="table table-condensed table-hover table-bordered">
    			<caption align="top">Thông tin chi tiết</caption>
    			<tbody>
    				<tr>
    					<td class="info" style="vertical-align: middle;">ID</td>
    					<td style="vertical-align: middle;">
    						<s:property value="bannerEdit.bannerId"/>
    						<s:hidden name="bannerEdit.bannerId" id="id"/>
    						<s:hidden name="bannerEdit.campaignId" id="campaignId"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info" style="vertical-align: middle;">Name</td>
    					<td style="vertical-align: middle;">
    						<s:textfield name="bannerEdit.bannerName" id="name" cssClass="form-control"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info" style="vertical-align: middle;">Description</td>
    					<td style="vertical-align: middle;">
    						<s:textfield name="bannerEdit.bannerDescription"  id="description"  cssClass="form-control"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info" style="vertical-align: middle;">Banner Type</td>
    					<td style="vertical-align: middle;">
    						<s:select name="bannerEdit.bannerType" list="allBannerType" listKey="key" listValue="value" id="bannerType" cssClass="form-control"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info" style="vertical-align: middle;">Status</td>
    					<td style="vertical-align: middle;">
    						<s:select name="bannerEdit.statusId" list="allBannerStatus" listKey="key" listValue="value" id="statusId" cssClass="form-control"/>
    					</td>
    				</tr>
    				<%-- <tr>
    					<td class="info" style="vertical-align: middle;">Campaign</td>
    					<td style="vertical-align: middle;">
    						<s:select name="bannerEdit.campaignId" list="allCampaign" listKey="key" listValue="value"  id="campaignId" cssClass="form-control"/>
    					</td>
    				</tr> --%>
    				<tr >
    					<td class="info" style="vertical-align: middle;">Start Time</td>
    					<td style="vertical-align: middle;">
			                <div class='input-group date' id='datetimepicker1'>
			                    <s:textfield name="bannerEdit.startTime" cssClass="form-control" id="startTime">
			                    	<s:param name="value">
			                    		<s:date name="%{bannerEdit.startTime}" format="dd/MM/yyyy HH:mm"/>
			                    	</s:param>
			                    </s:textfield>
			                    <span class="input-group-addon">
			                    	<span class="glyphicon glyphicon-calendar"></span>
			                    </span>
			                </div>
    					</td>
    				</tr>
    				<tr>
    					<td class="info" style="vertical-align: middle;">Stop Time</td>
    					<td style="vertical-align: middle;">
    						<div class='input-group date' id='datetimepicker2'>
			                    <s:textfield name="bannerEdit.stopTime" cssClass="form-control" id="stopTime">
			                    	<s:param name="value">
			                    		<s:date name="%{bannerEdit.stopTime}" format="dd/MM/yyyy HH:mm"/>
			                    	</s:param>
			                    </s:textfield>
			                    <span class="input-group-addon">
			                    	<span class="glyphicon glyphicon-calendar"></span>
			                    </span>
			                </div>
    					</td>
    				</tr>
    				<tr>
    					<td class="info" style="vertical-align: middle;">Image 1</td>
    					<td style="vertical-align: middle;">
    						<s:textfield name="bannerEdit.image1"  id="image1" cssClass="form-control"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info" style="vertical-align: middle;">Image 2</td>
    					<td style="vertical-align: middle;">
    						<s:textfield name="bannerEdit.image2"  id="image2" cssClass="form-control"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info" style="vertical-align: middle;">Max Click</td>
    					<td style="vertical-align: middle;">
    						<s:textfield name="bannerEdit.maxClick"  id="maxClick" cssClass="form-control"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info" style="vertical-align: middle;">Max View</td>
    					<td style="vertical-align: middle;">
    						<s:textfield name="bannerEdit.maxView"  id="maxView" cssClass="form-control"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info" style="vertical-align: middle;">Android Url</td>
    					<td style="vertical-align: middle;">
    						<s:textfield name="bannerEdit.androidUrl"  id="androidUrl" cssClass="form-control"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info" style="vertical-align: middle;">Ios Url</td>
    					<td style="vertical-align: middle;">
    						<s:textfield name="bannerEdit.iosUrl"  id="iosUrl" cssClass="form-control"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info" style="vertical-align: middle;">Windows Url</td>
    					<td style="vertical-align: middle;">
    						<s:textfield name="bannerEdit.windowsUrl"  id="windowsUrl" cssClass="form-control"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info" style="vertical-align: middle;">Max Click Per Day</td>
    					<td style="vertical-align: middle;">
    						<s:textfield name="bannerEdit.maxClickPerDay"  id="maxClickPerDay" cssClass="form-control"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info" style="vertical-align: middle;">Max View Per Day</td>
    					<td style="vertical-align: middle;">
    						<s:textfield name="bannerEdit.maxViewPerDay"  id="maxViewPerDay" cssClass="form-control"/>
    					</td>
    				</tr>
    				<%-- <tr>
    					<td class="info" style="vertical-align: middle;">OS</td>
    					<td style="vertical-align: middle;">
    						<s:iterator value="bannerEdit.allOs" status="allOsStatus">
    							<s:checkbox name="%{key}" value="value" cssClass="cssOs"/> <s:property value="%{key}"/> <br/>
    						</s:iterator>
    					</td>
    				</tr> --%>
    				<tr>
    					<td colspan="2">
    						<button type="button" class="btn btn-success" id="btnOk">
    							<i class="icon-shopping-cart icon-white"></i> OK »
    						</button>
    					</td>
    				</tr>
    			</tbody>
    		</table>
    	</div>
	</div>
</div>