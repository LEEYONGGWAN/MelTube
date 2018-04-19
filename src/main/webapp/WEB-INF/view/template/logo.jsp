<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/css/logoCss.css"/>" />
<script type="text/javascript"
	src="<c:url value="/static/js/jquery-3.3.1.min.js" />"></script>
<script type="text/javascript">
	$().ready(function() {
						$("#melIcon").click(function() {
							$(location).attr("href", "<c:url value="/"/>");
						});

						/* 		$("#searchBox").keypress(function(event){
						 if( event.key == "Enter" ){
						 var something = $("#searchBox").val();
						 console.log(something);
						 alert("ok");
						 $(location).attr("href", "<c:url value='/searchView/" + something + "'/>");
						 }
						 });  */

						$("#searchBox").keypress(function(event) {
							if (event.which == 13) {
								$("#searchBtn").click();
								return false;
							}
						});

						$("#searchBtn")
								.click(
										function() {
											var something = $("#searchBox")
													.val();
											console.log(something);
											$(location)
													.attr("href",
															"<c:url value='/searchView/" + something + "'/>");
										});

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

						//회원가입
						$("#join").click(function() {
							$(location).attr("href", "<c:url value="/join"/>");
						});

					});
</script>


<div style="width: 1000px;">
	<form:form modelAttribute="searchForm">
		
		<div id="menuBar">
			<img src="<c:url value="/static/img/menuBar.PNG"/>"/>
		</div>
				
		<div id="melIcon">
			<img src="<c:url value="/static/img/mel.png"/>" style="width: 100px;" />
		</div>



		<span> <input type="text" id="searchBox" name="searchBox"
			placeholder="찾고 싶은 뮤직비디오를 검색하세요!" />
		</span>

		<span> <input type="button" id="searchBtn" value="Q" />
		</span>


		<c:if test="${not empty sessionScope.__USER__ }">
			<div id="aftLogin">
				<div>(${sessionScope.__USER__.nickname}님)</div>
				<div>
					<a href="<c:url value="/logout"/>">로그아웃 </a>
				</div>
			</div>
		</c:if>

		<c:if test="${empty sessionScope.__USER__ }">
			<span id="loginbox"> <a style="display: inline-block"
				id="loginbox" href="<c:url value="/login"/>"> 로그인 </a>
			</span>
		</c:if>

	</form:form>

</div>
