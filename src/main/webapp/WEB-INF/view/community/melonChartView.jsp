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
	src="<c:url value="/static/js/jquery-3.3.1.min.js" />"></script>
<script type="text/javascript">
	
</script>



</head>



<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/view/template/logo.jsp" />
		<jsp:include page="/WEB-INF/view/template/menu.jsp" />
		<h3 style="margin-left:270px">실시간 멜론차트 순위(50위)</h3>

		<div>
			<table>
				<tr>
					<th style="width:50px">순위</th>
					<th style="width:80px"></th>
					<th style="width:460px; text-align:left">제목</th>
					<th style="width:320px">가수</th>
  
				</tr>
				
				<c:forEach items="${mChart}" var="mc">

					<tr>
					
						<td style="text-align:center">
							<span>${mc.rank}</span>
							
						</td>
						
						<td style="text-align:left">
							<img style="width: 60px; height: 60px;" src="${mc.mImage}" alt="image"/>
						</td>
						
						<td>
							${mc.mTitle}
						</td>
						
						<td style="text-align:center">${mc.mSinger}</td>
					</tr>

				</c:forEach>

			</table>

		</div>

	</div>
</body>
</html>