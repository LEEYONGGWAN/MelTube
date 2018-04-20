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
	href="<c:url value="/static/css/writeInput.css"/>" />
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
	<jsp:include page="/WEB-INF/view/template/logo.jsp" />
	<jsp:include page="/WEB-INF/view/template/menu.jsp" />
	<div style="display: inline-block">
		<form:form id="writeForm" enctype="multipart/form-data">
			<div id="wrapper" style="text-align: left">

				<div style="width: 800px">
					<div style="display: inline-block">
						제 목 : <input type="text" id="title" name="title" placeholder="제목"
							value="${communityVO.title}" />
					</div>
					<div style="display: inline-block">
						노래 이미지 : <input type="file" id="sImg" name="sImg" />
					</div>
				</div>

				<div style="width: 800px">
					<div style="display:inline-block">
						앨범명 : <input type="text" id="album" name="album" placeholder="앨범"
							value="${communityVO.album}" />
					</div>
  

					<div style="display:inline-block">
						장 르 : <select id="genre" name="genre">
							<option>ballad</option>
							<option>rap&hiphop</option>
							<option>RnB/Soul</option>
							<option>rock/metal</option>
							<option>dance</option>
						</select>
					</div>

				</div>
						<div style="width: 800px">
							가 수 : <input type="text" id="singer" name="singer"
								placeholder="가수" value="${communityVO.singer}" class="tt" />
						</div>

						<div style="width: 800px">
							발매 날짜 : <input type="date" id="releaseDate" name="releaseDate"
								placeholder="발매 날짜" value="${communityVO.releaseDate}"
								class="tt" />
						</div>

						<div style="width: 800px">
							<span style="vertical-align: top; margin-top: 7px"> 가 사 :
							</span> <span> <textarea id="lyrics" name="lyrics"
									placeholder="가사" value="${communityVO.lyrics}"
									style="width:531px; height:220px"></textarea>
							</span>

						</div>

						<div>
							<input type="hidden" id="userId" name="userId"
								value="${sessionScope.__USER__.id}" />
						</div>

						<div>
							동영상 파일 : <input type="file" id="file" name="file" />
						</div>




						<div>
							<input type="button" id="writeBtn" value="등록" class="tt" />
						</div>




					</div>
		</form:form>
	</div>

</body>
</html>