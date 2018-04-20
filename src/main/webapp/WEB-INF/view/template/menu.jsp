<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/menuCss.css"/>" />
<script type="text/javascript" src= "<c:url value="/static/js/jquery-3.3.1.min.js" />" ></script>
<script type="text/javascript">
</script>

<style>
   A:link {TEXT-DECORATION:none}
   A:visited{TEXT-DECORATION:none}
   A:hover{TEXT-DECORATION:none}
</style>
  

<%-- <div style="margin-top: 10pt; width:950px" >
 
 
	<c:if test = "${not empty sessionScope.__USER__ }">
	<span class="box">
		<a href="<c:url value="/write"/>"> 
			노래등록
		 </a>
	</span>
	</c:if>
  

	<span class="box" >
		<a href="<c:url value="/distGenre"/>">
			 장르별 보기 
		</a>
	</span>
	
	<span class="box" >
		<a href="<c:url value="http://pds.joins.com/news/component/htmlphoto_mmdata/200608/htm_2006080118332730003010-001.JPG"/>"> 
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
	
	<div style="margin:10px; border-bottom-color: #9FC93C; border-bottom-style: solid;"></div>	
	
	
</div> --%>


		<div id="sideBar" style="display: inline-block; vertical-align: top; height:2000px" >
			<div class="hide">
				
				<div class="menu">
					<img class="menuImg" src="<c:url value="/static/img/home.PNG"/>" />
					<a href="<c:url value="/"/>"> 홈 </a>
				
				</div>
				
				
				<div class="menu">
					<img class="menuImg" src="<c:url value="/static/img/music.PNG"/>" />
					<a href="<c:url value="/distGenre"/>"> 장르별 보기 </a>
				</div>


				<div class="menu">
					<img class="menuImg" src="<c:url value="/static/img/event.PNG"/>" />
					<a href="<c:url value="http://pds.joins.com/news/component/htmlphoto_mmdata/200608/htm_2006080118332730003010-001.JPG"/>">
					이벤트 
				</a>
			 	</div>
				
				
				<div class="menu">
					<img class="menuImg" src="<c:url value="/static/img/melon.PNG"/>" />
					<a href="<c:url value="/melonChartViewAction"/>"> 멜론순위차트 </a>
				</div>

				<c:if test="${not empty sessionScope.__USER__ }">
					 <div class="menu">
					 <img class="menuImg" src="<c:url value="/static/img/write.PNG"/>" />
					 <a href="<c:url value="/write"/>"> 노래등록  </a>
					 </div>
				</c:if>

				<c:if test="${empty sessionScope.__USER__ }">
					<div class="menu">
					<img class="menuImg" src="<c:url value="/static/img/menuBar.PNG"/>" />
					<a href="<c:url value="/join"/>"> 회원가입 </a>
					</div>
				</c:if>

				<c:if test="${not empty sessionScope.__USER__ }">
					 <div class="menu">
					 <img class="menuImg" src="<c:url value="/static/img/byebye.PNG"/>" />
					 <a href="<c:url value="/delete/process1/" />"> 회원탈퇴 </a>
					 </div>
				</c:if>
				
				
			</div>
		</div>