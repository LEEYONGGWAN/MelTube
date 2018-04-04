<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"  src="<c:url value="/static/js/jquery-3.3.1.min.js"/>" ></script>
<script type="text/javascript">




</script>




</head>




<body>

		<div id="wrapper">
			
			
			<div>
				<h1>제목 : ${community.title} | 장르 : ${community.genre}</h1>
			</div>
			
			<!-- 왼쪽 (영상칸) -->
			<div style="display:inline-block; width:440px;">
			
			<div>
				<video controls autoplay style="width:400px; height:400px" src = "<c:url value="/static/video/${community.id}.mp4"/> "></video>				
			</div>
			
			<p>추천수 : ${community.likeIt} | 발매일 : ${community.releaseDate}</p>
			</div>
		
		
		
			<!-- 오른쪽 (가사칸)-->
			<div style="display:inline-block;  width: 400px; vertical-align:top; background-color:">
			
			<div style="text-align:center">
				가사
			</div>
			<p>${community.lyrics}</p>
	 		<a href= "<c:url value="/"/>">뒤로가기</a>
			<a href="<c:url value="/recommend/${community.id}"/>">  추천하기  </a>
			</div>	
			
		</div>

		

</body>
</html>