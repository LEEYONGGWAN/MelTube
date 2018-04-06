<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/css/menuCss.css"/>" />


<script type="text/javascript" src= "<c:url value="/static/js/jquery-3.3.1.min.js" />" ></script>
<script type="text/javascript">
/* 	$().ready(function() {
		$(".box").on("mouseover", function() {
			$(this).animate({
				font : #FFF;
			});
		});
			
		
		$(".box").on("mouseout", function() {
			$(this).animate({
				font-color : #f3f3f3;
			});
		});
	}); */


</script>




<div style="margin-top: 10pt">
	<span class="box" style="font-size:15pt;  margin:55pt;">
		<a href="<c:url value="/login"/>"> 
			노래등록
		 </a>
	</span>

	<span class="box" style="font-size:15pt; margin:55pt">
		<a href="<c:url value="/login"/>">
			 장르별 보기 
		</a>
	</span>
	
	<span class="box" style="font-size:15pt; margin:55pt">
		<a href="<c:url value="/login"/>"> 
			이벤트 
		</a>
	</span>
	
	<span class="box" style="font-size:15pt; margin:55pt">
		<a href="<c:url value="/login"/>" > 
			회원가입 
		</a>
	</span>
		
	<span class="box" style="font-size:15pt; margin:55pt">
		<a href= "<c:url value="/login" />"   > 
			회원탈퇴 
		</a>
	</span>
	
	
	<hr/>
</div>