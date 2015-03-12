<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="resources/js/APP04.js"></script>
<div class="container" style="margin-top: 15px;">
	<s:form action="/APP04_saveProperty" onsubmit="return validateInsert();">
		<div class="row" style="margin-bottom: 10px;">
			<s:submit cssClass="btn btn-default btn-xs btn-primary btnDelProp" value="Save" cssStyle="width:100px"></s:submit>
		</div>
		<div class="row" style="margin-bottom: 10px;">
			<s:if test="%{message != null && message != ''}">
				<s:property value="message"/>
			</s:if>
		</div>
		<div class="row">
			<table class="table table-condensed table-hover table-bordered">
				<thead>
					<tr>
						<th class="info" style="text-align: center">Name</th>
						<th class="info" style="text-align: center">Value</th>
						<th class="info" style="text-align: center">Del</th>
					</tr>
				</thead>
				<tbody id="tbodyProp">
					<s:if test="%{listProperty != null && listProperty.size > 0}">
						<s:iterator value="listProperty" status="listPropertyStatus" var="propertyBean">
							<s:set var="idx" value="%{#listPropertyStatus.index}"/>
							<tr id="${idx}_prop">
								<td style="text-align: center">
									<s:textfield name="listProperty[%{#listPropertyStatus.index}].propertyName" cssClass="form-control txtPropName" value="%{#propertyBean.propertyName}"/>
								</td>
								<td style="text-align: center">
									<s:textfield name="listProperty[%{#listPropertyStatus.index}].propertyValue" cssClass="form-control txtPropValue" value="%{#propertyBean.propertyValue}"/>
								</td>
								<td style="text-align: center; vertical-align:middle; ">
									
									<input type="button" class="btn btn-default btn-xs btn-primary btnDelProp" id="btnDel_${idx}" value="Delete">
								</td>
							</tr>					
						</s:iterator>
					</s:if>
				</tbody>
			</table>
		</div>
	</s:form>
	<div class="row" style="margin-top: 15px">
		<input type="button" class="btn btn-default btn-xs btn-primary btnAddProp" style="width:100px" value="Add">
	</div>
</div>
