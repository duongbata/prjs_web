<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="resources/js/APP02.js"></script>
<s:form action="/APP02_updatePoint">
	A : <s:textfield name="app02DataTrans.point.a" value="%{app02DataTrans.point.a}" id = "p_a"/> <br/>
	B : <s:textfield name="app02DataTrans.point.b" value="%{app02DataTrans.point.b}" id="p_b"/> <br/>
	<input type="button" value="Ajax" id="btnAjax"><br/>
	<s:submit value="Submit"/>
</s:form>
