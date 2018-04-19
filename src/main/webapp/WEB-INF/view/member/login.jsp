<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Meltube::뮤비가 보고싶을땐 멜튜브</title>



<link rel="icon" type="image/png" href="<c:url value="static/images/icons/favicon.ico" />"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/logoCss.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value="static/vendor/bootstrap/css/bootstrap.min.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="static/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="static/fonts/iconic/css/material-design-iconic-font.min.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="static/vendor/animate/animate.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="static/vendor/css-hamburgers/hamburgers.min.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="static/vendor/animsition/css/animsition.min.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="static/vendor/select2/select2.min.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="static/vendor/daterangepicker/daterangepicker.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="static/css/util.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="static/css/main.css"/>"/>

<script type="text/javascript" src="<c:url value="static/js/jquery-3.3.1.min.js" />"></script>
<script type="text/javascript">
 $().ready(function(){
	 
	 $("#loginBtn").click(function() {

			if ($("#email").val() == "") {
				alert("아이디를 입력해주세요!");
				$(location).attr("href", "<c:url value="/"/>");

			}

			else if ($("#password").val() == "") {
				alert("비밀번호를 입력해주세요!");
				$(location).attr("href", "<c:url value="/"/>");
			}

			var loginForm = $("#loginForm");
			loginForm.attr({
				"method" : "post",
				"action" : "<c:url value="/login"/>"
			});
			loginForm.submit();
		});
	 
 });







</script>
</head>
<body>
		<jsp:include page="/WEB-INF/view/template/logo.jsp"/>
		<div class="limiter">
		<div class="container-login100" style="background-image: url('/static/img/bg-01.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form:form id="loginForm" class="login100-form validate-form">
					<span class="login100-form-title p-b-49">
						Login
					</span>

					<div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired">
						<span class="label-input100">Username</span>
						<input id="email" class="input100" type="text" name="email" placeholder="Type your username">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Password is required">
						<span class="label-input100">Password</span>
						<input id="password" class="input100" type="password" name="password" placeholder="Type your password">
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>
					
					<div class="container-login100-form-btn" style="margin-top:20px">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button id="loginBtn" class="login100-form-btn">
								Login
							</button>
						</div>
					</div>

				</form:form>
			</div>
		</div>
	</div>



</body>
</html>