<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Meltube::뮤비가 보고싶을땐 멜튜브</title>
<script type="text/javascript"  src="<c:url value="/static/js/jquery-3.3.1.min.js"/>" ></script>
<script type="text/javascript">
</script>
</head>




<body>
		<jsp:include page="/WEB-INF/view/template/logo.jsp"/>
	
	
	
		<jsp:include page="/WEB-INF/view/template/menu.jsp"/>
		<div id="wrapper" style="display:inline-block">
			<!-- 왼쪽 (영상칸) -->
			<div style="display:inline-block; width:440px;">
			
					<div>
							<video controls autoplay style="width:400px; height:400px">
								<source src="<c:url value="/get/${community.id}"/>" type="video/mp4">
							</video>				
					</div>
					
					<p>추천수 : ${community.likeIt} | 발매일 : ${community.releaseDate}</p>
			</div>
		
		
		
			<!-- 오른쪽 (정보칸)-->
			<div style="display:inline-block;  width: 400px; vertical-align:top; background-color:">
			
					<div style="margin-top:20px">
			
							<div style="display:inline-block;">
								<img  style="width:100px; height:100px;"  alt="사진 img" src="<c:url value="/getS/${community.id}"  />"  />		
							</div>
				 
							<div style="display:inline-block; vertical-align:top;">
								<h3>제목 : ${community.title}</h3>
								<h4>장르 : ${community.genre}</h4>
							</div>
							 
					</div>
				
			
			
			
			
					<div style="text-align:center">	가사 	</div>
					
					<p>${community.lyrics}</p>
					
			 		<a href= "<c:url value="/"/>"> 
			 			<input type="button" id="backBtn" value="뒤로가기"  /> 
			 		</a>
			 		
					<a href="<c:url value="/likeIt/${community.id}"/>">  
						<input type="button" id="backBtn" value="좋아요♥ "  /> 
					</a>
					
			</div>	
			
		</div>

		

</body>
</html>