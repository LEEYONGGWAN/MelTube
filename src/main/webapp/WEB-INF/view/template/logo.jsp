<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>        



<script type="text/javascript" src="<c:url value="/static/js/jquery-3.3.1.min.js" />" ></script>
<script type="text/javascript">

	$().ready(function(){
		$("#melIcon").click(function() {
			$(location).attr("href", "<c:url value="/"/>");
		});
	});

</script>



<style type="text/css">

#nav>ul {
	padding: 0px;
	margin: 0px;
}

#nav li {
	display: inline-block;
	margin-left: 15px;
}

#nav li:FIRST-CHILD {
	margin-left: 0px;
}
</style>
 
 

<div id="nav">
	<ul>
		<li>
			<div id="melIcon" style="margin-left: 20px; border-bottom: 3px solid #333; width:1200px">
				<img src="<c:url value="/static/img/mel.png"/>"  style= "width: 100px; "/>
			</div>
		</li>
	
	</ul>
</div>