<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link type="text/css" rel="stylesheet" href="resources/css/bootstrap-datetimepicker.min.css" />

<script type="text/javascript" src="resources/js/moment.js"></script>
<script type="text/javascript" src="resources/js/vi.js"></script>
<script type="text/javascript" src="resources/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="resources/js/ADV03_4.js"></script>
<script type="text/javascript">
	
</script>
<div class="container">
	<s:form action="/ADV03_saveListCampaign">
		<s:set var="oldSize" value="%{listCampaign.size}"/>
		<s:hidden name="oldSize"/>
		<div class="row">
			<div class="panel filterable">
				<div class="">
					<div class="pull-left">
						<s:submit  cssClass="btn btn-default btn-xs" id="btnSave" value="Save" disabled="true"/>
					</div>
					<div class="pull-right">
						<s:a href="ADV03_initCreate" cssClass="btn btn-default btn-xs" style="width:150px">
							<span class="glyphicon glyphicon-th-list"></span> Create Banner
						</s:a>	
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
							<th style="background-color: #337ab7"><input type="text" class="form-control" placeholder="Descirption"
								disabled></th>
							<th style="background-color: #337ab7"><input type="text" class="form-control" placeholder="Start"
								disabled></th>
							<th style="background-color: #337ab7"><input type="text" class="form-control" placeholder="Stop"
								disabled></th>
							<th style="background-color: #337ab7">Edit</th>
							<th style="background-color: #337ab7">Delete</th>
						</tr>
					</thead>
					<tbody id="listCamp">
						<s:if test="%{listCampaign.size != null && listCampaign.size > 0 }">
							<s:iterator value="listCampaign" status="listCampaignStatus" var="campaign">
								<tr>
									<td style="vertical-align: middle;">
										<s:label value="%{#listCampaignStatus.index + 1}"/>
									</td>
									<td style="vertical-align: middle;">
										<s:set var="link">/ADV03_init.action?campaignId=${campaignId}</s:set>
										<s:a value="%{#link}">
											<s:property value="#campaign.campaignId"/>
										</s:a>
										<s:hidden name="listCampaign[%{#listCampaignStatus.index}].campaignId" value="%{#campaign.campaignId}"></s:hidden>
									</td>
									<td>
										<s:textfield name="listCampaign[%{#listCampaignStatus.index}].campaignName" value="%{#campaign.campaignName}" cssClass="form-control forSearch"/>
									</td>
									<td>
										<s:textfield name="listCampaign[%{#listCampaignStatus.index}].description" value="%{#campaign.description}" cssClass="form-control forSearch"/>
									</td>
									<td style="width:200px;">
	<%-- 									<s:textfield name="#campaign.startTime" cssClass="form-control forSearch"/> --%>
										<div class='input-group date datetimepicker'>
											<span class="input-group-addon">
						                    	<span class="glyphicon glyphicon-calendar"></span>
						                    </span>
						                    <s:textfield name="listCampaign[%{#listCampaignStatus.index}].startTime" value="%{#campaign.startTime}" cssClass="form-control forSearch" id="startTime">
						                    	<s:param name="value">
						                    		<s:date name="%{#campaign.startTime}" format="dd/MM/yyyy HH:mm"/>
						                    	</s:param>
						                    </s:textfield>
						                </div>
									</td>
									<td style="width:200px;">
	<%-- 									<s:textfield name="#campaign.stopTime" cssClass="form-control forSearch"/> --%>
										<div class='input-group date datetimepicker'>
											<span class="input-group-addon">
						                    	<span class="glyphicon glyphicon-calendar"></span>
						                    </span>
						                    <s:textfield name="listCampaign[%{#listCampaignStatus.index}].stopTime" value="%{#campaign.stopTime}" cssClass="form-control forSearch" id="stopTime">
						                    	<s:param name="value">
						                    		<s:date name="%{#campaign.stopTime}" format="dd/MM/yyyy HH:mm"/>
						                    	</s:param>
						                    </s:textfield>
						                </div>
									</td>
									<td style="vertical-align: middle;">
										<button type="button" class="btn btn-default btn-xs btnEdit">
											<span class="glyphicon glyphicon-edit"></span> Edit
										</button>
									</td>
									<td style="vertical-align: middle;">
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
		</div>
	</s:form>
	<div class="row">
		<div class="pull-right">
			<button type="button" class="btn btn-default btn-xs" id="btnAdd"
				style="width: 100px; ">
				<span class="glyphicon glyphicon-plus"></span> Add
			</button>
		</div>
	</div>
</div>
