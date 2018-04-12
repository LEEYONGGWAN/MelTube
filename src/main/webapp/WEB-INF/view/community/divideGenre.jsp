<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src=" <c:url value=" /static/js/jquery-3.3.1.min.js "/> "></script>
<script type="text/javascript">
	$().ready(function() {
		alert("ok");
	});
</script>

</head>
<body>
	<jsp:include page="/WEB-INF/view/template/logo.jsp" />
	<jsp:include page="/WEB-INF/view/template/menu.jsp" />
	
	
	<div id="wrapper">
			<div style="margin-top: 20px;">
				<!-- a 태그에 아이디 줘서 스크립트에서 같이 값을 넘기자 ㅇㅋ? -->
				<span style="margin-left:30px">
					<a id="ballad" href="<c:url value="/distGenre" />"> 
						발라드
					</a>
				</span>
		
				<span style="margin-left:30px">
					<a id="rap&hiphop" href="<c:url value="/distGenre" />">
						랩/힙합
					</a>
				</span>
		
				<span style="margin-left:30px">
					<a id="RnB/Soul" href="<c:url value="/distGenre" />">
						R&B/Soul
					</a>
				</span>
		
				<span style="margin-left:30px">
					<a id="rock/metal" href="<c:url value="/distGenre" />">
						록/메탈
					</a>
				</span>
		
				<span style="margin-left:30px">
					<a id="dance" href="<c:url value="/distGenre" />">
						댄스
					</a>
				</span>
			</div>
			
			<div>
				<table>
							<tr>
								
								
								<th>제목</th>
								<th>가수</th>
								<th>♥</th>
		
							</tr>
							
							<c:forEach items="${genreList}" var="genre">
		
								<tr>
									<td style="text-align: center"><a
										href="<c:url value="/view/${genre.id}"/>">${genre.title}</a></td>
		
									<td style="text-align: center">${genre.singer}</td>
									
									<td style="text-align: center">${genre.likeIt}</td>
								</tr>
		
							</c:forEach>

				</table>
			
			</div>
	</div>
	
	
</body>
</html>