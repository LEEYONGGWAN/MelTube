<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Meltube::뮤비가 보고싶을땐 멜튜브</title>

<script type="text/javascript"
	src="<c:url value="/static/js/jquery-3.3.1.min.js"/>"></script>
<script type="text/javascript">
	$().ready(function() {
	});
</script>
</head>


<body>
	<jsp:include page="/WEB-INF/view/template/logo.jsp" />
	<jsp:include page="/WEB-INF/view/template/menu.jsp" />
	<div id="wrapper">

		<div>
			<div>아티스트명으로 검색</div>

			<table>
				<tr>
					<th style="width: 60px"></th>
					<th style="width: 400px">제목</th>
					<th style="width: 320px">가수</th>
					<th style="width: 50px">♥</th>

				</tr>

				<c:forEach items="${SearchList}" var="search">

					<tr>
						<td style="text-align: left"><img
							style="width: 60px; height: 60px;" alt="사진 img"
							src="<c:url value="/getS/${search.id}"  />" /></td>
						<td><a style="text-algin: top"
							href="<c:url value="/view/${search.id}"/>"> ${search.title} </a>
						</td>

						<td style="text-align: center">${search.singer}</td>

						<td style="text-align: center">${search.likeIt}</td>
					</tr>

				</c:forEach>

			</table>
		</div>


		<div>곡명으로 검색</div>









	</div>

</body>
</html>