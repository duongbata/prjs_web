<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="resources/js/APP03_2.js"></script>
<div class="container">
	<s:if test="%{message != null}">
		<s:label name="message"/>
	</s:if>
	
	<s:form action="APP03_updateApp" id="formInsertApp" onsubmit="return validateUpdate();">
		<div class="row">
			<br/><s:submit cssClass="btn btn-default btn-xs btn-primary" value="Save" cssStyle="width:100px"/><br/><br/>
		</div>
		<div class="row">
			<table class="table table-condensed table-hover table-bordered">
				<tr>
					<td class="info" style="vertical-align: middle;">OS</td>
					<td style="vertical-align: middle;">
<%-- 						<s:select name="appUpdate.osId" id="osId" list="mapOS" listKey="key" listValue="value" cssClass="form-control" cssStyle="width:150px;" value="-1"/> --%>
							<s:property value="appUpdate.osId"/>
					</td>
				</tr>
				<tr>
					<td class="info" style="vertical-align: middle;">ID</td>
					<td style="vertical-align: middle;">
<%-- 						<s:select name="appUpdate.groupId" id="groupId" list="mapGroup" cssClass="form-control" cssStyle="width:150px;"/> --%>
							<s:property value="appUpdate.groupId"/>
					</td>
				</tr>
				<tr>
					<td class="info" style="vertical-align: middle;">Url</td>
					<td style="vertical-align: middle;">
						<s:textfield name="appUpdate.url" cssClass="form-control"/>
					</td>
				</tr>
				<tr>
					<td class="info" style="vertical-align: middle;">Version</td>
					<td style="vertical-align: middle;">
						<s:textfield name="appUpdate.version" cssClass="form-control"/>
					</td>
				</tr>
			</table>
		</div>
		<div class="row">
			<table class="table table-condensed table-hover table-bordered" id="tblProperty">
				<caption>Property</caption>
				<tr>
					<th class="info" width="200px" style="text-align:center">Name</th>
					<th class="info" style="text-align:center">Value</th>
				</tr>
				<s:if test="%{appUpdate.listProperty != null && appUpdate.listProperty.size > 0}">
					<s:iterator value="appUpdate.listProperty" status="listPropertyStatus" var="propertyApp">
						<s:set var="trId" value="#listPropertyStatus.index + '_prop'"></s:set>
						<tr id="${trId}">
							<td width="200px">
<%-- 								<s:textfield name="appUpdate.listProperty[%{#listPropertyStatus.index}].propertyName" value="%{#propertyApp.propertyName}" cssClass="form-control txtPropName"/> --%>
								<s:property value="#propertyApp.propertyName"/>
							</td>
							<td>
<%-- 								<s:textfield name="appUpdate.listProperty[%{#listPropertyStatus.index}].propertyValue" value="%{#propertyApp.propertyValue}" cssClass="form-control txtPropValue"/> --%>
								<s:property value="#propertyApp.propertyValue"/>
							</td>
						</tr>
					</s:iterator>
				</s:if>			
			</table>
			<br/><br/>
		</div>
		<div class="row" id="configTable">
			
		</div>

	</s:form>
</div>