<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="resources/js/APP01.js"></script>
<script type="text/javascript" src="resources/js/dygraph-combined.js"></script>
<script type="text/javascript" src="resources/js/dygraph-combined-dev.js"></script>
<div id="graphdiv"></div>
<%-- <script type="text/javascript">
  
  g = new Dygraph(document.getElementById("graphdiv"),
	        [
	          [1,10,100],
	          [2,20,80],
	          [3,50,60],
	          [4,70,80]
	        ],
	        {
	          labels: [ "x", "A", "B" ]
	        });
</script> --%>
<div class="container">
	<div class="row">
		<s:form action="App01_insertData">
			<s:textfield name="name" value="%{name}"></s:textfield> <br/>
			<s:submit value="Submit"/>
			<s:token/>
		</s:form>
	</div>
</div>