<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>        



<script type="text/javascript" src="<c:url value="/static/js/jquery-3.3.1.min.js" />" ></script>
<script type="text/javascript">

	$().ready(function(){
		$("#melIcon").click(function() {
			$(location).attr("href", "<c:url value="/"/>");
		});
	});

</script>



<style type="text/css">

#nav>ul {
	padding: 0px;
	margin: 0px;
}

#nav li {
	display: inline-block;
	margin-left: 15px;
}

#nav li:FIRST-CHILD {
	margin-left: 0px;
}
</style>
 
 

<div id="nav">
	
	
			<div id="melIcon" style="margin-left: 20px; display:inline-block">
				<img src="<c:url value="/static/img/mel.png"/>"  style= "width: 100px; "/>
			</div>



		<!-- TODO 자바스크립트 해주고 컨트롤러 및 여러군대에 검색기능 만들어주기 -->
	<span >
		<input type="text" id="searchBox" name="searchBox" placeholder="찾고 싶은 뮤직비디오를 검색하세요!" 
		style="vertical-align:top; width:300px; margin-left:20px; margin-top:20px" />
	</span>
  
	<span>
		<input type="button" id="searchBtn" value="Q" style=" vertical-align:top; margin-top:20px" />
	</span>
	  
    
</div>
