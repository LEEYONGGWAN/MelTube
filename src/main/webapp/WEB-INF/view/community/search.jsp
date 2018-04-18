<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Meltube::뮤비가 보고싶을땐 멜튜브</title>




<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/searchCss.css"/>" />
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
	<div id="wrapper" style="width: 800px">


		<div style="text-align: center">검색결과 입니다.</div>

		<div style="margin-left: 20px; margin-top:40px;">
			<div class="greenLine">◎아티스트명으로 검색</div>


			<div>
				<table>
					<tr>
						<th style="width: 64px"></th>
						<th style="width: 300px">제목</th>
						<th style="width: 320px">가수</th>
						<th style="width: 50px">좋아요</th>
	
					</tr>
					
					<c:forEach items="${singerList}" var="singerList">
						<tr>
							<td style="text-align: left; ">
								<img alt="사진 img" src="<c:url value="/getS/${singerList.id}"  />" />
							</td>
							<td>
								<a style="text-algin: top" href="<c:url value="/view/${singerList.id}"/>">
									${singerList.title} 
								</a>
							</td>
	
							<td style="text-align: center">${singerList.singer}</td>
							<td style="text-align: center">♥${singerList.likeIt}</td>
						</tr>
					</c:forEach>
	
					<c:if test="${empty singerList}">
						<tr>
							<td  colspan="5" style="text-align:center">검색내용이 없습니다.</td>
						</tr>
					</c:if>
	
	
	
	
				</table>
			</div>




		</div>

		<div style="margin-left: 20px; margin-top:40px">
			<div class="greenLine">◎곡명으로 검색</div>

			<table>
				<tr>
					<th style="width: 64px"></th>
					<th style="width: 300px">제목</th>
					<th style="width: 320px">가수</th>
					<th style="width: 50px">좋아요</th>

				</tr>


				<c:forEach items="${titleList}" var="titleList">

					<tr>
						<td style="text-align: left">
							<img alt="사진 img" src="<c:url value="/getS/${titleList.id}"  />" />
						</td>

						<td>
							<a style="text-algin: top" href="<c:url value="/view/${titleList.id}"/>">
								${titleList.title} 
							</a>
						</td>

						<td style="text-align: center">${titleList.singer}</td>

						<td style="text-align: center">♥${titleList.likeIt}</td>
					</tr>

				</c:forEach>

				<c:if test="${empty titleList}">
					<tr>
						<td  colspan="5" style="text-align:center">검색내용이 없습니다.</td>
					</tr>
				</c:if>

  
			</table>
		</div>






		<div style="margin-left: 20px; margin-top:40px">
			<div class="greenLine">◎가사로 검색</div>
			<table>
				<tr>
					<th style="width: 64px"></th>
					<th style="width: 300px">제목</th>
					<th style="width: 320px">가수</th>
					<th style="width: 50px">좋아요</th>

				</tr>


				<c:forEach items="${lyList}" var="lyList">

					<tr>
						<td style="text-align: left">
							<img alt="사진 img" src="<c:url value="/getS/${lyList.id}"  />" />
						</td>

						<td>
							<a style="text-algin: top" href="<c:url value="/view/${lyList.id}"/>"> 
								${lyList.title} 
							</a>
						</td>

						<td style="text-align: center">${lyList.singer}</td>

						<td style="text-align: center">♥${lyList.likeIt}</td>
					</tr>

				</c:forEach>


				<c:if test="${empty lyList}">
					<tr>
						<td  colspan="5" style="text-align:center">검색내용이 없습니다.</td>
					</tr>
				</c:if>


			</table>

		</div>
  
	</div>

</body>
</html>