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
	<!-- 큰틀 -->
	<div
		style="display: inline-block; width: 1200px; height: 1000px; border-top: 1px solid #000; border-left: 1px solid #000; border-bottom: 1px solid #000; border-right: 1px solid #000;">
		<!-- 왼쪽 리스트 칸-->

		<div
			style="display: inline-block; vertical-align: top; width: 350px; height: 900px; border-top: 1px solid #000; border-left: 1px solid #000; border-bottom: 1px solid #000; border-right: 1px solid #000;">

		</div>

		<!-- 가운데 최신곡 -->
		<div
			style="display: inline-block; vertical-align: top; width: 500px; border-top: 1px solid #000; border-left: 1px solid #000; border-bottom: 1px solid #000; border-right: 1px solid #000;">
			<table>
				<tr>
					<th>번호</th>
					<th>장르</th>
					<th>제목</th>
					<th>가수</th>
					<th>발매일</th>

					<th><input type="button" id="goToWrite" value="노래 등록" /></th>

				</tr>
				<c:forEach items="${communityList}" var="community">
					<tr>

						<td>${community.id}</td>
						<td>${community.genre}</td>

						<td><a href="<c:url value="/read/${community.id}"/>">${community.title}</a></td>

						<td>${community.singer}</td>
						<td>${community.releaseDate}</td>
					</tr>

				</c:forEach>

			</table>
		</div>

		<!-- 오른쪽 아이디&좋아요 많은곡  -->
		<div
			style="display: inline-block; vertical-align: top; width: 330px; border-top: 1px solid #000; border-left: 1px solid #000; border-bottom: 1px solid #000; border-right: 1px solid #000;">

			<form:form modelAttribute="loginForm">
				<!-- 로그인 박스-->
				<div>
					<div style="display: inline-block; width: 2300px">

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

							<div>
								<input type="button" id="join" value="회원가입" />
							</div>


						</c:if>
					</div>

					<c:if test="${not empty sessionScope.__USER__ }">
						<div>
							${sessionScope.__USER__.nickname}님(${sessionScope.__USER__.email})
						</div>
						<div>환영합니다.</div>

						<div>
							<input type="button" id="logout" value="로그아웃" />
						</div>
					</c:if>


				</div>
			</form:form>





		</div>


		<!-- 좋아요 많은곡 -->
		<div
			style="vertical-align: top; width: 330px; border-top: 1px solid #000; border-left: 1px solid #000; border-bottom: 1px solid #000; border-right: 1px solid #000;">
			<div>좋아요 많은 랭킹</div>
		</div>


	</div>


	</div>
</body>
</html>