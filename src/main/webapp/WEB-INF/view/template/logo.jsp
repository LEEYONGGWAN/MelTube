<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>        



<script type="text/javascript" src="<c:url value="/static/js/jquery-3.3.1.min.js" />" ></script>
<script type="text/javascript">
	$().ready(function() { 
		$("#melIcon").click(function() {
			$(location).attr("href", "<c:url value="/"/>");
		});

		
/* 		$("#searchBox").keypress(function(event){
			if( event.key == "Enter" ){
				var something = $("#searchBox").val();
				console.log(something);
				alert("ok");
				$(location).attr("href", "<c:url value='/searchView/" + something + "'/>");
			}
		});  */
		


			
		$("#searchBox").keypress(function(event){
			if(event.which ==13){
				$("#searchBtn").click();
				return false;
			}
		});
			
			
		$("#searchBtn").click(function() {
			var something = $("#searchBox").val();
			console.log(something);
			$(location).attr("href", "<c:url value='/searchView/" + something + "'/>");
		});


		
	
	});
  
</script>
 

<div>
		<div id="melIcon" style="margin-left: 20px; display:inline-block">
			<img src="<c:url value="/static/img/mel.png"/>"  style= "width: 100px; "/>
		</div>


		<!-- <!-- <a id="rap&hiphop" href="<c:url value="/distGenre?id=rap&hiphop" />"> --> 
		<!-- TODO 자바스크립트 해주고 컨트롤러 및 여러군대에 검색기능 만들어주기 -->
	  <form:form modelAttribute="searchForm" style="display:inline-block; vertical-align:top">
		<span>
			<input type="text" id="searchBox" name="searchBox" placeholder="찾고 싶은 뮤직비디오를 검색하세요!" 
			style="vertical-align:top; width:300px; margin-left:20px; margin-top:20px" />
		</span>
	  
		<span>
			<input type="button" id="searchBtn" value="Q" style=" vertical-align:top; margin-top:20px" />
		</span>
	</form:form> 
    
</div>
