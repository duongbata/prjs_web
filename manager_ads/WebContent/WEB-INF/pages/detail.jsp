<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript" src="resources/js/detail.js"></script>
<!-- <link type="text/css" rel="stylesheet" href="resources/css/detail.css" /> -->
<s:form action="message">
	<h1>Hello world</h1> <br/>
	Message : <s:textfield name="info.message"/>
	<s:submit value="OK"/> <br/>
	<input type="button" value="Click" id="btnClick"/>
	<br/>
</s:form>
<s:form action="newRow">
	<table id="tblUser">
		<thead>
			<tr>
				<td>Id</td>
				<td>Name</td>
			</tr>
		</thead>
		<tbody>
		<s:iterator value="listUser" status="listStatus" var="user">
			<tr>
				<td>
<%-- 					<s:textfield name="listUser[%{#listStatus.index}].id" value="%z{listUser[#listStatus.index].id}"/> --%>
					<s:textfield name="listUser[%{#listStatus.index}].id" value="%{#user.id}"/>
<%-- 					<s:property value="%{#user.id}"/> --%>
				</td>
				<td>
<%-- 					<s:property value="%{#user.name}"/> --%>
					<s:textfield name="listUser[%{#listStatus.index}].name" value="%{#user.name}"/>
<%-- 					<s:textfield name="listUser[%{#listStatus.index}].name" value="%{listUser[#listStatus.index].name}"/> --%>
				</td>
			</tr>
		</s:iterator>
		</tbody>		
	</table>
	<%-- <s:textfield name="userBean.id"/>
	<s:textfield name="userBean.name"/> --%>
	<br/>
	<input type="button" value="New Row" id="btnAddRow"/> &nbsp;&nbsp;
	<input type="button" value="Del Row" id="btnDelRow">
	<br/>
	<s:submit value="Add"/>
</s:form>
<br/>
<!-- Upload file -->
	<s:form action="doUpload" method="post" enctype="multipart/form-data">
	    <h1>Upload file</h1>
	    <s:file name="upload" label="File"/>
	    <s:submit value="Upload"/>
	</s:form>

<!-- Upload multiple file -->
	<s:form action="doMultiUpload" method="post" enctype="multipart/form-data">
		<h1>Upload multiple file</h1>
		<s:file name="uploads" label="File1"/>
		<s:file name="uploads" label="File2"/>
		<s:file name="uploads" label="File3"/>
		<s:submit value="Upload"/>
	</s:form>
	
	<br/>
	<s:form action="confirms">
		<s:iterator value="listAds" status="listStatus" var="ads">
			<s:textfield name="listAds[%{#listStatus.index}].id" value="%{#ads.id}"/>
			<s:textfield name="listAds[%{#listStatus.index}].name" value="%{#ads.name}"/>
			<br/><br/>
		</s:iterator>
		<s:iterator value="listNetwork" status="listStatus" var="ads">
			<s:textfield name="listNetwork[%{#listStatus.index}].adnetworkName" value="%{#ads.adnetworkName}"/>
			<s:textfield name="listNetwork[%{#listStatus.index}].perForAdmob" value="%{#ads.perForAdmob}"/>
			<br/><br/>
		</s:iterator>
		<s:iterator value="listParent" status="listStatus" var="parent">
			<s:textfield name="listParent[%{#listStatus.index}].id" value="%{#parent.id}"/>
			<s:textfield name="listParent[%{#listStatus.index}].name" value="%{#parent.name}"/>
			<br><br/>
		</s:iterator>
		<s:submit value="Confirm"/>
	</s:form>