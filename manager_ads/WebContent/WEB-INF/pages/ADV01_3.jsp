<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="resources/js/ADV01_3.js"></script>
	<div class="container">
	<div class="row">
        <div class="span12">
    		<table class="table table-condensed table-hover table-bordered">
    			<caption align="top">Add App</caption>
    			<tbody>
    				<tr>
    					<td class="info">ID</td>
    					<td>
    						<s:textfield name="adsAdd.id"  id="id"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info">Name</td>
    					<td>
    						<s:textfield name="adsAdd.name"  id="name"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info">Description</td>
    					<td>
    						<s:textfield name="adsAdd.description"  id="description"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info">OS</td>
    					<td>
    						<s:select name="adsAdd.osId" list="allOs" listKey="key" listValue="value"  id="osId"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info">URL</td>
    					<td>
    						<s:textfield name="adsAdd.url"  id="url"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info">Status</td>
    					<td>
    						<s:select name="adsAdd.statusId" list="allStatus" listKey="key" listValue="value"  id="statusId"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info">Message</td>
    					<td>
    						<s:textfield name="adsAdd.message"  id="message"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info">Facebook page</td>
    					<td>
    						<s:textfield name="adsAdd.page"  id="page"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info">AdsAdnetworkId</td>
    					<td>
    						<s:textfield name="adsAdd.adsAdnetworkId"  id="adsAdnetworkId"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info">AdsAdnetworkIdBk</td>
    					<td>
    						<s:textfield name="adsAdd.adsAdnetworkIdBk"  id="adsAdnetworkIdBk"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info">AdsAdnetworkName</td>
    					<td>
<%--     						<s:textfield name="adsAdd.adsAdnetworkId" /> --%>
    						<s:select name="adsAdd.networkId" list="allAdNetwork" listKey="key" listValue="value"  id="networkId"/>
    					</td>
    				</tr>
    				<tr>
    					<td colspan="2">
    						<button type="submit" class="btn btn-success" id="btnOk">
    							<i class="icon-shopping-cart icon-white"></i> OK »
    						</button>
    					</td>
    				</tr>
    			</tbody>
    		</table>
    	</div>
	</div>
</div>