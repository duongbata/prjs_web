<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="resources/js/ADV03_5.js"></script>
<div class="container">
	<s:form action="ADV03_insertBannerToCampaign" id="insertForm">
		<s:hidden name="campaignId"></s:hidden>
		<div class="row">
			<button type="button" class="btn btn-default btn-xs" id="btnAddBanner" style="width:100px">
				<span class="glyphicon glyphicon-save"></span> Add
			</button>
		</div>
		<div class="row">
			<table class="table table-bordered">
				<thead style="background-color: #5cb85c">
					<tr>
						<th>
							#
						</th>
						<th>
							Name
						</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="listSampleBanner" status="listSampleBannerStatus" var="sampleBanner">
						<tr>
							<td>
								<s:checkbox name="listSampleBanner[%{#listSampleBannerStatus.index}].flagSelected"/>
							</td>
							<td>
								<s:hidden name="listSampleBanner[%{#listSampleBannerStatus.index}].bannerId"/>
								<s:property value="#sampleBanner.bannerName"/>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</s:form>
</div> 