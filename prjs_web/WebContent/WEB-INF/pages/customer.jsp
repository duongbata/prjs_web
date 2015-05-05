<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container" style="margin-top: 50px;">
	<div class="row">
		<s:form action="/insert-name">
			<s:textfield name="name"/>
			<s:submit value="Submit" cssClass="btn btn-primary"/>
			<s:token cssClass="cssToken"/>		
		</s:form>
	</div>
	<div class="row">
		<s:form action="/update-name">
			<s:textfield name="name"/>
			<s:submit value="Submit" cssClass="btn btn-primary"/>
			<s:token/>		
		</s:form>
	</div>
</div>