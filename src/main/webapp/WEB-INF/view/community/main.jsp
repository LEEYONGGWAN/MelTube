<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>meltube</title>

<script type="text/javascript"
	src="<c:url value="/static/js/jquery-3.3.1.min.js" />"></script>
<script type="text/javascript">
	$().ready(function() {

		$("#loginBtn").click(function() {

			if( $("#email").val() == ""  ){
				alert("아이디를 입력해주세요!");
				$(location).attr("href", "<c:url value="/"/>");
				
			}
			 	
			else if( $("#password").val() == "" ){
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

		$("#writeBtn").click(function() {
			var writeForm = $("#writeForm");
			writeForm.attr({
				"method" : "post",
				"action" : "<c:url value="/write"/>"
			});
			writeForm.submit();
		});

		//가사 등록하러 가는 버튼
		$("#goToWrite").click(function() {
			$(location).attr("href", "<c:url value="/write"/>");
		});
		//회원가입
		$("#join").click(function() {
			$(location).attr("href", "<c:url value="/join"/>");
		});

	});
</script>

</head>
<body>


	<div style="width: 1200px;">
		<!-- img -->
		<jsp:include page="/WEB-INF/view/template/logo.jsp"/>
		<jsp:include page="/WEB-INF/view/template/menu.jsp"/>
		
	</div>



	<!-- 큰틀 -->
	<div
		style="display: inline-block; width: 1800px; height: 1000px;">

		<!-- 왼쪽 리스트 칸-->

		<div
			style="display: inline-block; vertical-align: top; width: 200px; height: 900px; margin-left: 20px; margin-top: 20px">

			<div style="text-align: center">장르별 보기</div>

		</div>

		<!-- 가운데 최신곡 -->
		<div
			style="display: inline-block; vertical-align: top; width: 500px; margin-left: 20px; margin-top: 20px">

			<div style="text-align: center">새로나온 뮤비</div>

			<table>
				<tr>
					<th>장르</th>
					<th>제목</th>
					<th>가수</th>
					<th>발매일</th>
					<c:if test="${not empty sessionScope.__USER__ }">
						<th><input type="button" id="goToWrite" value="노래 등록" /></th>
					</c:if>
				</tr>
				<c:forEach items="${communityList}" var="community">
					<tr>

						<td style="text-align:center">${community.genre}</td>

						<td style="text-align:center"><a href="<c:url value="/view/${community.id}"/>">${community.title}</a></td>

						<td style="text-align:center">${community.singer}</td>
						<td style="text-align:center">${community.releaseDate}</td>
					</tr>

				</c:forEach>

			</table>
		</div>
  
		<!-- 오른쪽 아이디&좋아요 많은곡  -->
		<div
			style="display: inline-block; vertical-align: top; width: 400px; margin-left: 20px; margin-top: 20px">





			<form:form modelAttribute="loginForm">
				<!-- 로그인 박스-->
				<div>
					<div style="display: inline-block; width: 400px">

						<c:if test="${empty sessionScope.__USER__ }">

							<div>
								ID : <input type="text" id="email" name="email"
									placeholder="ID(email)" />
							</div>

							<div>
								PW : <input type="password" id="password" name="password"
									placeholder="Password" />
							</div>


							<div
								style="display: inline-block; width: 90x; vertical-align: top;">
								<input type="button" id="loginBtn" value="로그인" />
							</div>

							<div style="display: inline-block;">
								<input type="button" id="join" value="회원가입" />
							</div>


						</c:if>

						<c:if test="${not empty sessionScope.__USER__ }">

							<div>
								${sessionScope.__USER__.nickname}님(${sessionScope.__USER__.email})
							</div>

							<div>환영합니다.</div>

							<div>
								<a href="<c:url value="/logout" />"> <input type="button" id="logout" value="로그아웃" />  </a>
							</div>


						</c:if>

  

					</div>
				</div>
			</form:form>
  
			<!-- 좋아요 많은곡 -->
			<div
				style="vertical-align: top; width: 480px; border-top: 1px solid #000; margin-top: 10px">

				<div style="text-align:center">좋아요 랭킹</div>


				<table>
				<tr>
					<th>좋아요</th>
					<th>장르</th>
					<th>제목</th>
					<th>가수</th>
					
				</tr>
				<c:forEach items="${sortList}" var="sort">
						
					<tr>
						<td style="text-align:center">${sort.likeIt} </td>
						<td style="text-align:center">${sort.genre}</td>

						<td style="text-align:center"><a href="<c:url value="/view/${sort.id}"/>">${sort.title}</a></td>

						<td style="text-align:center">${sort.singer}</td>
					</tr>

				</c:forEach>

			</table>























			</div>



		</div>

	</div>


</body>
</html>