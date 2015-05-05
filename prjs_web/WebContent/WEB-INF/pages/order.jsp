<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container" style="margin-top: 50px;">
	<div class="row">
		<s:form action="order_submit">
			<s:textfield name="a" value="%{a}"/>
			<s:textfield name="name"/>
			<s:submit value="Submit" cssClass="btn btn-primary"/>		
		</s:form>
	</div>
</div>