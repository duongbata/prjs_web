<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="resources/js/ADV01_2.js"></script>
	<div class="container">
	<div class="row">
        <div class="span12">
    		<table class="table table-condensed table-hover table-bordered">
    			<caption align="top">Thông tin chi tiết</caption>
    			<tbody>
    				<tr>
    					<td class="info">ID</td>
    					<td>
    						<%-- <s:textfield name="adsEdit.id" disabled="true"/> --%>
    						<%-- <s:label name="adsEdit.id"/> --%>
    						<s:property value="adsEdit.id"/>
    						<s:hidden name="adsEdit.id" id="id"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info">Name</td>
    					<td>
    						<s:textfield name="adsEdit.name" disabled="true" id="name"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info">Description</td>
    					<td>
    						<s:textfield name="adsEdit.description" disabled="true" id="description"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info">OS</td>
    					<td>
    						<s:select name="adsEdit.osId" list="allOs" listKey="key" listValue="value" disabled="true" id="osId"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info">URL</td>
    					<td>
    						<s:textfield name="adsEdit.url" disabled="true" id="url"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info">Status</td>
    					<td>
    						<s:select name="adsEdit.statusId" list="allStatus" listKey="key" listValue="value" disabled="true" id="statusId"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info">Message</td>
    					<td>
    						<s:textfield name="adsEdit.message" disabled="true" id="message"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info">Facebook page</td>
    					<td>
    						<s:textfield name="adsEdit.page" disabled="true" id="page"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info">AdsAdnetworkId</td>
    					<td>
    						<s:textfield name="adsEdit.adsAdnetworkId" disabled="true" id="adsAdnetworkId"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info">AdsAdnetworkIdBk</td>
    					<td>
    						<s:textfield name="adsEdit.adsAdnetworkIdBk" disabled="true" id="adsAdnetworkIdBk"/>
    					</td>
    				</tr>
    				<tr>
    					<td class="info">AdsAdnetworkName</td>
    					<td>
<%--     						<s:textfield name="adsEdit.adsAdnetworkId" disabled="true"/> --%>
    						<s:select name="adsEdit.networkId" list="allAdNetwork" listKey="key" listValue="value" disabled="true" id="networkId"/>
    					</td>
    				</tr>
    				<tr>
    					<td colspan="2">
<!--     						<a class="btn btn-success" href="#"><i class="icon-shopping-cart icon-white"></i> Order »</a> -->
    						<button type="button" class="btn btn-success" id="btnEdit">
    							<i class="icon-shopping-cart icon-white"></i> Edit »
    						</button>
    						&nbsp;&nbsp;
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