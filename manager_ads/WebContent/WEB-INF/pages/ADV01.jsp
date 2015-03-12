<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="resources/js/ADV01.js"></script>
<script type="text/javascript" src="resources/js/jquery-latest.min.js"></script>
<link type="text/css" rel="stylesheet" href="resources/css/ADV01.css" />
<s:form action="/ADV01_init" id="listAdsForm">
	<div class="container">
	<div class="row">
	<div class="panel filterable">
		<div class="">
<!-- 			<h3 class="panel-title">Danh sách app</h3> -->
			<%-- <div class="pull-left">
				<s:a href="ADV02_init" cssClass="btn btn-default btn-xs" style="width:100px">
					<span class="glyphicon glyphicon-cog"></span> Quản lý
				</s:a>&nbsp;&nbsp;
				<s:a href="ADV03_init" cssClass="btn btn-default btn-xs" style="width:100px">
					<span class="glyphicon glyphicon-th-list"></span> Banner
				</s:a>
			</div> --%>
			<div class="pull-right">
				<button type="button" class="btn btn-default btn-xs" id="btnAdd"
					style="width: 100px;">
					<span class="glyphicon glyphicon-plus"></span> Add
				</button> &nbsp;&nbsp;
				<button type="button" class="btn btn-default btn-xs btn-filter"
					style="width: 100px;">
					<span class="glyphicon glyphicon-filter"></span> Filter
				</button>
			</div>
		</div>
		<br/><br/>
		<table class="table table-bordered table-hover">
			<thead>
				<tr class="filters">
					<th style="background-color: #337ab7">#</th>
					<th style="background-color: #337ab7"><input type="text" class="form-control" placeholder="id"
						disabled></th>
					<th style="background-color: #337ab7"><input type="text" class="form-control" placeholder="Name"
						disabled></th>
					<th style="background-color: #337ab7"><input type="text" class="form-control"
						placeholder="Description" disabled></th>
					<th style="background-color: #337ab7">
						<input type="text" class="form-control" placeholder="OS" disabled>
					</th>
					<th style="background-color: #337ab7"><input type="text" class="form-control" placeholder="Url"
						disabled></th>
					<th style="background-color: #337ab7">More</th>
					<th style="background-color: #337ab7">Delete</th>
				</tr>
			</thead>
			<tbody>
				<s:if test="%{listAds != null && listAds.size  > 0 }">
					<s:iterator value="listAds" status="listAdsStatus" var="ads">
						<s:if test="%{#ads.status == 'Readly'}">
							<tr class="success">
						</s:if>
						<s:elseif test="%{#ads.status == 'Waiting'}">
							<tr class="warning">
						</s:elseif>
						<s:else>
							<tr class="danger">						
						</s:else>
							<s:hidden cssClass="adsId" value="%{#ads.id}" id="%{#ads.id}"/>
							<td>
								<s:property value="%{#listAdsStatus.index+1}"/>
							</td>
							<td>
								<s:label name="#ads.id" id="%{#ads.id}_id"/>
<%-- 								<s:property value="#ads.id"/> --%>
							</td>
							<td>
								<s:label name="#ads.name" id="%{#ads.id}_name"/>
<%-- 								<s:property value="#ads.name" /> --%>
							</td>
							<td>
								<s:label name="#ads.description" id="%{#ads.id}_description"/>
<%-- 								<s:property value="#ads.description"/> --%>
							</td>
							<td>
								<s:label name="#ads.os" id="%{#ads.id}_os"></s:label>
<%-- 								<s:property value="#ads.os"/> --%>
							</td>
							<td>
								<s:if test="%{#ads.url != null && #ads.url != ''}">
<%-- 									<a href="<s:url value="%{#ads.url}"/>" target="_blank" id="#ads.id">URL</a> --%>
									<s:a name="#ads.url" value="%{#ads.url}" id="%{#ads.id}_url" >URL</s:a>								
								</s:if>
							</td>
							<td>
								<button type="button" class="btn btn-default btn-xs btnMore">
									<span class="glyphicon glyphicon-edit"></span> More
								</button>
							</td>
							<td>
								<button type="button" class="btn btn-default btn-xs btnDel">
									<span class="glyphicon glyphicon-remove"></span> Del
								</button>
							</td>
						</tr>
					</s:iterator>
				</s:if>
			</tbody>
		</table>
	</div>
	<br/>
</div>
</div>
</s:form>
