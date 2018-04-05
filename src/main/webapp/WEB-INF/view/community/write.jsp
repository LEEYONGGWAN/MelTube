<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="<c:url value="/static/js/jquery-3.3.1.min.js"/>"
	type="text/javascript"></script>
<script type="text/javascript">
	$().ready(function() {

		$("#writeBtn").click(function() {

			var writeForm = $("#writeForm");
			console.log(file);
			writeForm.attr({
				"method" : "post",
				"action" : "<c:url value="/write"/>"
			});

			writeForm.submit();
		});

	});
</script>
<style>
	   #wrapper {
      width: 50%;
      margin: 0 auto;
    }
    
</style>

</head>
<body>

	
	<form:form id="writeForm" enctype="multipart/form-data">
	<div id="wrapper" style="text-align:right">
		<div>
			제 목 : <input type="text" id="title" name="title" placeholder="제목"
				value="${communityVO.title}" />
		</div>

		<div>
			앨범명 : <input type="text" id="album" name="album" placeholder="앨범"
							value="${communityVO.album}"/>
		</div>
		
		

		<div>
			장 르 : <input type="text" id="genre" name="genre" placeholder="장르"
				value="${communityVO.genre}" />
		</div>

		<div>
			가 수 : <input type="text" id="singer" name="singer" placeholder="가수"
				value="${communityVO.singer}" />
		</div>

		<div>
			발매 날짜 : <input type="date" id="releaseDate" name="releaseDate"
				placeholder="발매 날짜" value="${communityVO.releaseDate}" />
		</div>

		<div>
			가 사 :
			<textarea id="lyrics" name="lyrics" placeholder="가사" value="${communityVO.lyrics}"></textarea>
		</div>
		
		<div>
			<input type="hidden" id="userId" name="userId" value="${sessionScope.__USER__.id}"/>
		</div>

		<div>
			<input type="file" id="file" name="file"/>
		</div>
   
		<div>
			<input type="button" id="writeBtn" value="등록" />
		</div>

</div>

	</form:form>


</body>
</html>