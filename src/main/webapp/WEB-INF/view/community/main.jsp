<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Meltube::뮤비가 보고싶을땐 멜튜브</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/css/mainCss.css"/>" />

<script type="text/javascript"
	src="<c:url value="/static/js/jquery-3.3.1.min.js" />"></script>
<script type="text/javascript">
	$().ready(function() {

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

	});
</script>

<style>
.hover_wrapper {
	position: relative;
	width: 156px;
	height: 156px;
	overflow: hidden
}

.hover_cont {
	display: none;
	position: absolute;
	top: 0;
	left: 0;
	z-index: 1;
	width: 100%;
	line-height: 156px;
	color: #FFFFFF;
	text-align: center;
}

.hover_cont::before {
	content: '';
	display: block;
	position: absolute;
	top: 0;
	left: 0;
	z-index: -1;
	opacity: 0.4;
	width: 100%;
	height: 100%;
	background: #070707;
}

.hover_wrapper:hover .hover_cont {
	display: block
}

A:link {
	TEXT-DECORATION: none
}

A:visited {
	TEXT-DECORATION: none
}

A:hover {
	TEXT-DECORATION: none
}

a.imgToView:-webkit-any-link {
	color: #FFFFFF;
}

.hide {
	margin: -1px;
	display: none;
}
</style>
</head>





<body>
	<jsp:include page="/WEB-INF/view/template/logo.jsp" />
	

	<div style="width: 2200px">

		<!-- 왼쪽 메뉴바 -->
		<jsp:include page="/WEB-INF/view/template/menu.jsp" />

		<!-- 오른쪽 큰틀 -->
		<div style="width: 1800px; height: 1000px; display: inline-block">









			<!-- 맨위 최신 5곡 -->
			<div style="margin-left: 60px; margin-top: 30px; margin-bottm: 0px; color:">
				신규 뮤비</div>

			<div id="six">

				<ul>
					<c:forEach items="${communityList}" var="community" end="4">
						<li>
							<div class="hover_wrapper" style="display: inline-block;">
								<a href="<c:url value="/view/${community.id}"/>"> <img
									class="main" alt="사진 img"
									src="<c:url value="/getS/${community.id}"  />" />
								</a>

								<div class="hover_cont">
									<a class="imgToView"
										href="<c:url value="/view/${community.id}"/>">
										${community.title} </a>
								</div>

							</div>


						</li>

					</c:forEach>
				</ul>

			</div>






			<!-- 중간 인기 5곡 -->
			<div style="margin-left: 60px; margin-top: 30px; margin-bottm: 0px; color:">
				인기
			</div>


			<div id="six">

				<ul>
					<c:forEach items="${sortList}" var="sort" end="4">
						<li>
							<div class="hover_wrapper" style="display: inline-block;">
								<a href="<c:url value="/view/${sort.id}"/>"> <img
									class="main" alt="사진 img"
									src="<c:url value="/getS/${sort.id}"  />" />
								</a>

								<div class="hover_cont">
									<div>
										<a class="imgToView" href="<c:url value="/view/${sort.id}"/>">
											${sort.title} </a>
									</div>
								</div>

							</div>
						</li>

					</c:forEach>
				</ul>

			</div>



			<div id="rightBigDiv">

				<!-- 좋아요 많은곡 -->
				<div
					style="vertical-align: top; width: 370px; border-top: 2px solid #EAEAEA;">

					<div style="text-align: center; font: bold">멜튜브 차트</div>


					<table>
						<tr>
							<th style="width: 45px">좋아요</th>
							<th>장르</th>
							<th style="width: 150px">제목</th>
							<th style="width: 90px">가수</th>

						</tr>
						<c:forEach items="${sortList}" var="sort">

							<tr>
								<td style="width: 45px">♥${sort.likeIt}</td>
								<td>${sort.genre}</td>

								<td><a style="width: 150px"
									href="<c:url value="/view/${sort.id}"/>"> ${sort.title} </a></td>

								<td style="width: 90px">${sort.singer}</td>
							</tr>

						</c:forEach>

					</table>


				</div>



			</div>

		</div>

	</div>
</body>
</html>