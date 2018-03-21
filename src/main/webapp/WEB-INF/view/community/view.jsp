<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>제목 : ${community.title} | 장르 : ${community.genre}</h1>
		
		<div>
			<video controls autoplay style="width:100px; height:100px">
				<sources src="bossbaby.mp4" />
			</video>
		</div>
		
		<p>추천수 : ${community.likeIt} | 발매일 : ${community.releaseDate}</p>
		<p></p>
		
		<p>
			가사 : ${community.lyrics}
		</p>
 		<a href= "<c:url value="/"/>">뒤로가기</a>
		<a href="<c:url value="/recommend/${community.id}"/>">  추천하기  </a>

</body>
</html>