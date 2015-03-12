<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link type="text/css" rel="stylesheet" href="resources/css/ADV03.css" />
<link type="text/css" rel="stylesheet" href="resources/css/bootstrap-datetimepicker.min.css" />

<script type="text/javascript" src="resources/js/moment.js"></script>
<script type="text/javascript" src="resources/js/vi.js"></script>
<script type="text/javascript" src="resources/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="resources/js/ADV03.js"></script>
<%-- <script type="text/javascript" src="resources/js/jquery-latest.min.js"></script> --%>
<script>
	$(function () {
	    $('.datetimepicker').datetimepicker();
	});
	
</script>
<s:form action="/ADV03_init" id="formListBanner">
	<s:if test="%{campaignId != null && campaignId != 0}">
		<s:hidden name="campaignId" id="campaignId"/>
	</s:if>
	<div class="container">
	<div class="row">
	<div class="panel filterable">
		<div class="">
			<%-- <div class="pull-left">
				<s:a href="ADV01_init" cssClass="btn btn-default btn-xs" style="width:100px">
					<span class="glyphicon glyphicon-th-list"></span> App
				</s:a>
			</div> --%>
			<div class="pull-right">
				<button type="button" class="btn btn-default btn-xs" id="btnAdd"
					style="width: 100px; ">
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
					<th style="background-color: #337ab7"><input type="text" class="form-control" placeholder="Name"
						disabled></th>
					<th style="background-color: #337ab7"><input type="text" class="form-control" placeholder="Start"
						disabled></th>
					<th style="background-color: #337ab7"><input type="text" class="form-control" placeholder="Stop"
						disabled></th>
					<th style="background-color: #337ab7"><input type="text" class="form-control" placeholder="Click"
						disabled></th>
					<th style="background-color: #337ab7"><input type="text" class="form-control" placeholder="View"
						disabled></th>
					<th style="background-color: #337ab7"><input type="text" class="form-control" placeholder="OS"
						disabled></th>
					<th style="background-color: #337ab7">More</th>
				</tr>
			</thead>
			<tbody>
				<s:if test="%{listBanner.size != null && listBanner.size > 0 }">
					<s:iterator value="listBanner" status="listBannerStatus" var="banner">
						<tr>
							<td style="vertical-align: middle;">
								<s:set var="bannerIdx" value="%{#listBannerStatus.index}"/>
								<s:property value="%{#listBannerStatus.index+1}"/>
							</td>
							<td style="vertical-align: middle;">
								<s:hidden cssClass="bannerId" value="%{#banner.bannerId}" id="banner_%{#banner.bannerId}"/>
								<s:label name="#banner.bannerName"/>
							</td>
							<%-- <td style="vertical-align: middle;">
								<s:label name="#banner.statusName"/>
							</td> --%>
							<td style="vertical-align: middle;" width="200px;">
								<div class='input-group date datetimepicker'>
									<span class="input-group-addon">
				                    	<span class="glyphicon glyphicon-calendar"></span>
				                    </span>
				                    <s:textfield name="#banner.startTime" cssClass="form-control startTime">
				                    	<s:param name="value">
				                    		<s:date name="%{#banner.startTime}" format="dd/MM/yyyy HH:mm"/>
				                    	</s:param>
				                    </s:textfield>
				                </div>
							</td>
							<td style="vertical-align: middle;" width="200px;">
								<div class='input-group date datetimepicker'>
									<span class="input-group-addon">
				                    	<span class="glyphicon glyphicon-calendar"></span>
				                    </span>
				                    <s:textfield name="#banner.stopTime" cssClass="form-control stopTime">
				                    	<s:param name="value">
				                    		<s:date name="%{#banner.stopTime}" format="dd/MM/yyyy HH:mm"/>
				                    	</s:param>
				                    </s:textfield>
				                </div>
							</td>
							<td style="vertical-align: middle;">
								<s:textfield name="listBanner[%{#listBannerStatus.index}].maxClick" value="%{#banner.maxClick}" cssClass="form-control txtMaxClick"/>
							</td>
							<td style="vertical-align: middle;">
								<s:textfield name="listBanner[%{#listBannerStatus.index}].maxView" value="%{#banner.maxView}" cssClass="form-control txtMaxView"/>
							</td>
							<td style="vertical-align: middle;">
								<s:if test="%{#banner.androidUrl != null && #banner.androidUrl != ''}">Android <br/></s:if>
								<s:if test="%{#banner.iosUrl != null && #banner.iosUrl != ''}">IOS <br/></s:if>
								<s:if test="%{#banner.windowsUrl != null && #banner.windowsUrl != ''}">Winphone </s:if>
							</td>
							<td style="vertical-align: middle;width: 150px;">
								<%-- <button type="button" class="btn btn-default btn-xs btnMore">
									<span class="glyphicon glyphicon-edit"></span> Edit
								</button> --%>
								<a class="accordion-toggle btnMoreInfo"  data-toggle="collapse" href="#more_${bannerIdx}">Edit</a>
								<div id="more_${bannerIdx}" class="accordion-body collapse">
									<div class="accordion-inner">
										<button type="button" class="btn btn-default btn-xs btnEdit">
											<span class="glyphicon glyphicon-edit"></span> Save
										</button>
										<button type="button" class="btn btn-default btn-xs btnMore">
											<span class="glyphicon glyphicon-edit"></span> More
										</button>
										<button type="button" class="btn btn-default btn-xs btnDel">
											<span class="glyphicon glyphicon-remove"></span> Del
										</button>
									</div>
								</div>
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