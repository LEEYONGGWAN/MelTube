<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/static/js/jquery-3.3.1.min.js" />"  ></script>
<script type="text/javascript">
	$().ready(function() {
		$("#registBtn").click(function() {
			$("#registForm").attr({
				"method" : "post",
				"action" : "<c:url value="/join"/>"
			}).submit();
		});
	});
</script>

</head>
<body>

	
	<div id="wrapper" style="text-align:center;">
		<form:form modelAttribute="registForm">
			<div>
				<input type="email" id="email" name="email" placeholder="Email" />
			</div>

			<div>
				<input type="text" id="nickname" name="nickname" placeholder="Nickname"  />
			</div>

			<div>
				<input type="password" id="password" name="password" placeholder="Password" />
			</div>

			<div>
				<input type="password" id="password-confirm" placeholder="Password" />
			</div>

			<div style="text-align: center;">
				<input type="button" id="registBtn" value="회원가입"/>
			</div>

		</form:form>
	</div>
	

</body>
</html>