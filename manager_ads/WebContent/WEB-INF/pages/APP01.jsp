<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container">
	<s:form action="APP01_insertGroup">
		<div class="row">
			<br/><s:submit value="Save" cssStyle="width:100px" cssClass="btn btn-default btn-xs btn-primary"/> <br/><br/>
		</div>
		<div class="row">
			<table class="table table-condensed table-hover table-bordered">
				<tr>
					<td class="info" style="vertical-align: middle;">ID</td>
					<td style="vertical-align: middle;">
						<s:textfield name="groupAppInsert.groupId" cssClass="form-control" value=""/>
					</td>
				</tr>
				<tr>
					<td class="info" style="vertical-align: middle;">Name</td>
					<td style="vertical-align: middle;">
						<s:textfield name="groupAppInsert.groupName" cssClass="form-control"/>
					</td>
				</tr>
				<tr>
					<td class="info" style="vertical-align: middle;">Icon</td>
					<td style="vertical-align: middle;">
						<s:textfield name="groupAppInsert.groupIcon" cssClass="form-control"/>
					</td>
				</tr>
				<tr>
					<td class="info" style="vertical-align: middle;">Title</td>
					<td style="vertical-align: middle;">
						<s:textfield name="groupAppInsert.groupTitle" cssClass="form-control"/>
					</td>
				</tr>
				<tr>
					<td class="info" style="vertical-align: middle;">Description</td>
					<td style="vertical-align: middle;">
						<s:textfield name="groupAppInsert.groupDescription" cssClass="form-control"/>
					</td>
				</tr>
				<tr>
					<td class="info" style="vertical-align: middle;">Image Banner</td>
					<td style="vertical-align: middle;">
						<s:textfield name="groupAppInsert.imgBanner" cssClass="form-control"/>
					</td>
				</tr>
				<tr>
					<td class="info" style="vertical-align: middle;">Image Vertical</td>
					<td style="vertical-align: middle;">
						<s:textfield name="groupAppInsert.imgVertical" cssClass="form-control"/>
					</td>
				</tr>
				<tr>
					<td class="info" style="vertical-align: middle;">Image Horizontal</td>
					<td style="vertical-align: middle;">
						<s:textfield name="groupAppInsert.imgHorizontal" cssClass="form-control"/>
					</td>
				</tr>
				<%-- <tr>
					<td class="info" style="vertical-align: middle;">User</td>
					<td style="vertical-align: middle;">
						<table>
							<s:iterator value="listDev" status="listDevStatus" var="dev">
								<tr>
									<td>
										<s:checkbox name="listDev[%{#listDevStatus.index}].flgSelected"/> &nbsp;
										<s:property value="#dev.name"/>
										<s:hidden name="listDev[%{#listDevStatus.index}].id"/>
									</td>
								</tr>
							</s:iterator>
						</table>
					</td>
				</tr> --%>
				<s:iterator value="groupAppInsert.listOsConfig" status="listOsConfigStatus" var="osConfig">
					<tr>
						<td  class="info" style="vertical-align: middle;">
							<s:if test="osId == 1 ">
								Ios
							</s:if>
							<s:if test="osId == 2 ">
								Android
							</s:if>
							<s:if test="osId == 3 ">
								Windows
							</s:if>
							<s:hidden name="groupAppInsert.listOsConfig[%{#listOsConfigStatus.index}].osId"></s:hidden>
						</td>
						<td>
							<table class="table-hover">
								<tr>
									<td width="150px;">
										AdmodIDBanner 
									</td>
									<td>
										<s:textfield name="groupAppInsert.listOsConfig[%{#listOsConfigStatus.index}].admodIdBanner" cssStyle="width:200px" cssClass="form-control"/>
									</td>
								</tr>
								<tr>
									<td>
										AdmodIDPopup 
									</td>
									<td>
										<s:textfield name="groupAppInsert.listOsConfig[%{#listOsConfigStatus.index}].admodIdPopup" cssStyle="width:200px" cssClass="form-control"/>
									</td>
								</tr>
								<tr>
									<td>
										User 
									</td>
									<td>
										<s:select name="groupAppInsert.listOsConfig[%{#listOsConfigStatus.index}].uid" list="listDev" listKey="id" listValue="name" value="-1" cssClass="form-control" cssStyle="width:200px"/>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</s:form>
</div>