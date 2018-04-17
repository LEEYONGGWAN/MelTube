<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/menuCss.css"/>" />
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

<style>
   A:link {TEXT-DECORATION:none}
   A:visited{TEXT-DECORATION:none}
   A:hover{TEXT-DECORATION:underline}
</style>
  

<div style="margin-top: 10pt">


	<c:if test = "${not empty sessionScope.__USER__ }">
	<span class="box">
		<a href="<c:url value="/write"/>"> 
			노래등록
		 </a>
	</span>
	</c:if>
  

	<!-- TODO 장르 리스트 뜨게 하기 -->
	<span class="box" >
		<a href="<c:url value="/distGenre"/>">
			 장르별 보기 
		</a>
	</span>
	
	<!-- TODO 이벤트 페이지 -->
	<span class="box" >
		<a href="<c:url value="/login"/>"> 
			이벤트 
		</a>
	</span>
	
	<span class="box" >
		<a href="<c:url value="/melonChartViewAction"/>"> 
			멜론순위차트 
		</a>
	</span>
	
	
	
	<c:if test = "${empty sessionScope.__USER__ }">
	<span class="box">
		<a href="<c:url value="/join"/>" > 
			회원가입 
		</a>
	</span>
	</c:if>
	
	<c:if test = "${not empty sessionScope.__USER__ }">	
	<span class="box">
		<a href= "<c:url value="/delete/process1/" />"   > 
			회원탈퇴 
		</a>
	</span>
	</c:if>
	
	<hr/>
</div>