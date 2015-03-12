<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%-- <s:if test="%{#appConfig.listConfigBean != null && #appConfig.listConfigBean.size > 0}">
	<s:iterator value="#appConfig.listConfigBean" status="listConfigBeanStatus" var="appConfigBean">
		<s:property value="%{(#listConfigBeanStatus.index + 1)}"/>.<s:property value="%{#appConfigBean.nameConfig}"/>
		<s:if test="%{#appConfigBean.listFieldBean != null && #appConfigBean.listFieldBean.size > 0}">
			<s:iterator value="#appConfigBean.listFieldBean" status="listFieldBeanStatus" var="fieldBean">
				<s:textfield name="%{#parentName}.listConfigBean[%{#listConfigBeanStatus.index}].listFieldBean[%{#listFieldBeanStatus.index}].name" value="%{#fieldBean.name}"/><br/>
			</s:iterator>
		</s:if>
		<s:if test="%{#appConfigBean.listConfigBean != null && #appConfigBean.listConfigBean.size > 0}">
			<s:set var="parentName" value="%{#parentName + '.listConfigBean[' + #listConfigBeanStatus.index + ']'}" />
			<s:set var="appConfig" value="appConfigBean"/>
			<tiles:insertDefinition name="NODE"/>
		</s:if>
	</s:iterator>
</s:if> --%>
<table  class="table table-condensed table-hover table-bordered" style="margin: 0px">
<s:if test="%{#appConfig.listConfigBean != null && #appConfig.listConfigBean.size > 0}">
	
		<s:iterator value="#appConfig.listConfigBean" status="listConfigBeanStatus" var="appConfigBean">
			<tr>
				<td class="info" width="100px;">
					<s:property value="%{#appConfigBean.nameConfig}"/> <br/>
					<input type="button" class="btn btn-default btn-xs btn-primary" value="Delete Object">
				</td>
				<td style="padding: 0px;">
					<s:if test="%{#appConfigBean.listFieldBean != null && #appConfigBean.listFieldBean.size > 0}">
						<table  class="table table-condensed table-hover table-bordered"  style="margin: 0px">
							<s:iterator value="#appConfigBean.listFieldBean" status="listFieldBeanStatus" var="fieldBean">
								<tr>
									<td class="info" width="100px;">
										<s:property value="%{#fieldBean.name}"/>
									</td>
									<td>
										<s:textfield value="%{#fieldBean.value}"/>
									</td>
									<td>
										<input type="button" class="btn btn-default btn-xs btn-primary" value="Delete Field">
									</td>
								</tr>
							</s:iterator>						
						</table>
					</s:if>
					<s:if test="%{#appConfigBean.listConfigBean != null && #appConfigBean.listConfigBean.size > 0}">
						<s:set var="parentName" value="%{#parentName + '.listConfigBean[' + #listConfigBeanStatus.index + ']'}" />
						<s:set var="appConfig" value="appConfigBean"/>
						<tiles:insertDefinition name="NODE"/>
					</s:if>
				</td>
			</tr>
		</s:iterator>
</s:if>
	<tr>
		<td>
			<input type="button" class="btn btn-default btn-xs btn-success" value="Insert Field">
		</td>
		<td>
			<input type="text">
		</td>
	</tr>
	<tr>
		<td>
			<input type="button" class="btn btn-default btn-xs btn-success" value="Insert Object">
		</td>
		<td>
			<input type="text">
		</td>
	</tr>
</table>