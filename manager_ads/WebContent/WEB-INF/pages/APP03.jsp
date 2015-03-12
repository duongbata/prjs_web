<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="resources/js/APP03.js"></script>
<script type="text/javascript" src="resources/js/jquery-latest.min.js"></script>
<div class="container">
	<div class="row">
			<div class="panel filterable">
				<div class="">
					<div class="pull-right">
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
							<th style="background-color: #337ab7"><input type="text" class="form-control" placeholder="OS"
								disabled></th>
						</tr>
					</thead>
					<tbody>
						<s:if test="%{listAppBean != null && listAppBean.size > 0}">
							<s:iterator value="listAppBean" status="listAppBeanStatus" var="appBean">
								<tr>
									<td>
										<s:property value="%{#listAppBeanStatus.index + 1}"/>
									</td>
									<td> 
										<s:set var="link">/APP03_detailApp.action?appId=${appId}</s:set>
										<s:a value="%{#link}">
											<s:property value="#appBean.appId"/>
										</s:a>
									</td>
									<td>
										<s:property value="#appBean.osId"/>
									</td>
								</tr>
							</s:iterator>	
						</s:if>	
					</tbody>
				</table>
			</div>
	</div>
</div>
