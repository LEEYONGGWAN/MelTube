<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Meltube::뮤비가 보고싶을땐 멜튜브</title>

<%-- <link rel="stylesheet" type="text/css"
	href="<c:url value="/static/css/button.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/css/input.css"/>" /> --%>
	
	<link rel="icon" type="image/png" href="<c:url value="static/images/icons/favicon.ico" />"/>
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


<script type="text/javascript" src="<c:url value="/static/js/jquery-3.3.1.min.js" />"  ></script>
<script type="text/javascript">
	$().ready(function() {
		
		$("#email").keyup(function() {
			var value = $(this).val();

			if (value != "") {

				//ajax Call(http://localhost:8080/api/exists/email)
				//가운데 {}는 우리가 받고자하는 객체 -- 여기서 value 는 위에 var value = $(this).val(); 요거임
				// 저 url로 가서 리스펀스를 받으면 함수 실행 저기 response는 정해진거 아니고 맘대로 써도됨~ 실무에선 data라고 많이씀
				$.post("<c:url value="/api/exists/email"  />", { email : value }, function(response) {
					//console.log(response.response);

					if (response.response) {
						$("#email").removeClass("valid");
						$("#email").addClass("invalid");
					} else {
						$("#email").removeClass("invalid");
						$("#email").addClass("valid");
					}
				});
				$(this).removeClass("invalid");
				$(this).addClass("valid");
			} else {
				$(this).removeClass("valid");
				$(this).addClass("invalid");
			}

		});

		$("#nickname").keyup(function() {
			var value = $(this).val();
			if (value != "") {
				$.post("<c:url value="/api/exists/nickname" />", { nickname : value }, function(response) {
					//console.log(response.response)

					if (response.response) {
						$("#nickname").removeClass("valid");
						$("#nickname").addClass("invalid");
					} else {
						$("#nickname").removeClass("invalid");
						$("#nickname").addClass("valid");
					}
				});
				$(this).removeClass("invalid");
				$(this).addClass("valid");

			} else {

				$(this).removeClass("valid");
				$(this).addClass("invalid");

			}

		});
  
		
		
		$("#password").keyup(function() {
			
			var value = $(this).val();
			
			if (value != "") {

				$(this).removeClass("invalid");
				$(this).addClass("valid");

			} else {

				$(this).removeClass("valid");
				$(this).addClass("invalid");

			}

			var password = $("#password-confirm").val();

			if (value != password) {
				$(this).removeClass("valid");
				$(this).addClass("invalid");
				$("#password-confirm").removeClass("valid");
				$("#password-confirm").addClass("invalid");
			} else {
				$(this).removeClass("invalid");
				$(this).addClass("valid");
				$("#password-confirm").removeClass("invalid");
				$("#password-confirm").addClass("valid");

			}

		});

		$("#password-confirm").keyup(function() {
			
			var value = $(this).val();
			
			var password = $("#password").val();

			if (value != password) {
				$(this).removeClass("valid");
				$(this).addClass("invalid");
				$("#password").removeClass("valid");
				$("#password").addClass("invalid");
			} 
			
			else {
				$(this).removeClass("invalid");
				$(this).addClass("valid");
				$("#password").removeClass("invalid");
				$("#password").addClass("valid");

			}
		});

		$("#registBtn").click(function() {

			if ($("#email").val() == "") {
				alert("email을 입력하세요");
				$("#email").focus();
				$("#email").addClass("invalid");
				return false;
			}

			if ($("#email").hasClass("invalid")) {
				alert("이미 사용중인 이메일 입니다.");
				$("#email").focus();
				return false;
			}
			
			if ($("#nickname").hasClass("invalid")) {
				alert("이미 사용중인 닉네임 입니다.");
				$("#nickname").focus();
				return false;
			}
			
			
			
			

			else {

				$.post("<c:url value="/api/exists/email"  />", { email : $("#email").val() }, function(response) {

					if (response.response) {
						alert("이미 사용중인 이메일 입니다.");
						$("#email").removeClass("valid");
						$("#email").addClass("invalid");
						$("#email").focus();
						return false;
					}
					
					if ($("#nickname").val() == "") {
						alert("nickname을 입력하세요");
						$("#nickname").focus();
						$("#nickname").addClass("invalid");
						return false;
					}

					if ($("#password").val() == "") {
						alert("password을 입력하세요");
						$("#password").focus();
						$("#password").addClass("invalid");
						return false;
					}
					
					if ($("#password-confirm").val() == "") {
						alert("password을 똑같이 한번더 입력하세요");
						$("#password-confirm").focus();
						$("#password-confirm").addClass("invalid");
						return false;
					}
					
					$("#registForm").attr({
						"method" : "post",
						"action" : "<c:url value="/join"/>"
					}).submit();
				
					
				});  //ajax 끝

			}//else끝
			

		});//버튼 끝
		
	
	});
</script>

</head>
                                           
<body>
	<jsp:include page="/WEB-INF/view/template/logo.jsp"/>
	<div class="limiter">
		<div class="container-login100" style="background-image: url('/static/img/bg-01.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form class="login100-form validate-form" id="registForm">
					<span class="login100-form-title p-b-49">
						어서오세요!
					</span>

					<div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired">
						<span class="label-input100">Email</span>
							<input class="input100" id="email" type="text" name="Email" placeholder="Type your Email">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
					
					
					<div class="wrap-input100 validate-input m-b-23" data-validate = "Nickname is reauired">
						<span class="label-input100">Nickname</span>
							<input class="input100"  id="nickname" type="text" name="Nickname" placeholder="Type your Nickname">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
					
					
					<div class="wrap-input100 validate-input m-b-23" data-validate = "Password is reauired">
						<span class="label-input100">Password</span>
						<input class="input100" id="password" type="text" name="Password" placeholder="Type your password">
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Password is required">
						<span class="label-input100">Password</span>
						<input class="input100" id="password-confirm" type="password" name="pass" placeholder="Type your password">
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>
					  
					<div class="container-login100-form-btn" style="margin-top:20px">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn">
							
							</div>
							<button id="registBtn" class="login100-form-btn">
								회원가입
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>


	<%-- <div id="wrapper" style="text-align:center;">
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
	</div> --%>
	

</body>
</html>