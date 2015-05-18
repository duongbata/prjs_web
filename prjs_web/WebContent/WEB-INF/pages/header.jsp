<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="container" style="margin-bottom: 20px">
	<div style="display: none">
		<form action="j_spring_security_logout" method="post" id="logoutForm">
		  	<input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				var flgExit = confirm("Đăng xuất?");
				if (!flgExit) {
					return;
				}
				document.getElementById("logoutForm").submit();
			}
		</script>
	</div>
	<div class="row">
		<nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
			<div class="navbar-header">
				 <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
		            <span class="sr-only">Toggle navigation</span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		        </button>
<!-- 		        <a href="#" class="navbar-brand">Brand</a> -->
			</div>
			 <div id="navbarCollapse" class="collapse navbar-collapse">
		        <ul class="nav navbar-nav">
		           <li>
						<s:a href="APP03_init">
							Bootstrap
						</s:a>
					</li>
					<li>
						<s:a href="APP02_init">
							APP02
						</s:a>
					</li>
					<li>
						<%-- <s:a href="APP01_init">
							APP01
						</s:a> --%>
						<a href="${pageContext.request.contextPath}/APP01_init">APP01</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/customer-init">token</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/order/12/trung">
							Order
						</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/scr01/23/trunks">
							SCR01
						</a>
					</li>
		        </ul>
		        <ul class="nav navbar-nav navbar-right">
		            <li>
		            	<s:if test="%{info.user != null && info.user.id != null && info.user.id != 0}">
							<a href="javascript:formSubmit()">Thoát</a>
							<s:hidden name="info.user.id" id="userId"/>
						</s:if>
		            </li>
		        </ul>
		    </div>
		</nav>
	</div>
</div>
