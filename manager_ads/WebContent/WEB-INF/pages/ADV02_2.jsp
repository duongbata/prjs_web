<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="resources/js/ADV02_2.js"></script>
<div class="container">
	<div class="row">
		<table class="table table-condensed table-hover table-bordered">
			<thead>
				<tr style="background-color:#F7E7CE">
					<th style="text-align: center">#</th>
					<th style="text-align: center">ID</th>
					<th style="text-align: center">Name</th>
					<th style="text-align: center">Image</th>
				</tr>
			</thead>
			<tbody>
				<s:if test="listGroupAds != null && listGroupAds.size > 0">
					<s:iterator value="listGroupAds" status="listGroupAdsStatus" var="groupAds">
						<tr>
							<td style="vertical-align: middle;text-align: center">
								<input type="checkbox" name="checkApp">
							</td>
							<td style="vertical-align: middle;">
								<s:label name="#groupAds.id"/>
								<s:hidden name="#groupAds.id" cssClass="adsId"/>
							</td>
							<td style="vertical-align: middle;">
								<s:label name="#groupAds.name"/>
								<s:hidden name="#groupAds.name" cssClass="adsName"/>
							</td>
							<td style="vertical-align: middle;text-align: center">
								<s:if test="%{#groupAds.urlImage != null && #groupAds.urlImage != ''}">
									<img height="50px" width="40px" src='<s:url value="%{#groupAds.urlImage}"/>'>	
									<s:hidden name="#groupAds.urlImage" cssClass="adsImg"/>							
								</s:if>
							</td>
						</tr>
					</s:iterator>
				</s:if>
			</tbody>
		</table>
	</div>
	<button type="button" class="btn btn-default btn-xs" id="btnAdd" style="width: 100px; background-color: #b3cee1" >
		<span class="glyphicon glyphicon-plus"></span> Add
	</button>
</div>