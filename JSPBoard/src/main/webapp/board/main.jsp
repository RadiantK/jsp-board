<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon"  type="image/x-icon" href="/images/favicon.ico" />
<link href="/css/main.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
<title>JSP게시판</title>
</head>
<body>
  <div id="wrap">
    <header class="head">
      <div class="logo">
        <a href="main"><img src="/images/namhe.png" alt="로고" />
          <span>RadiantK</span></a>  
        
      </div>
      <ul class="menu">
      	<c:if test="${empty sessionId}">
	        <li><a href="login">로그인</a></li>
	        <li><a href="join">회원가입</a></li>
        </c:if>
        <c:if test="${not empty sessionId}">
	        <li>로그인된 아이디: <a href="main" style="color:royalblue;">${sessionId}</a></li>
	        <li><a href="logout">로그아웃</a></li>
        </c:if>
      </ul>
    </header>

    <!-- 메인부분 -->
    <section>
      <div id="container">
        <div id="idx_top">
          <strong><span>JSP 게시판 시스템</span></strong>
        </div>
      </div>
    </section>
    
    <!-- 게시판 List -->
    <section>
      <div class="board_wrap">
        <div class="board_title">
          <strong>게시판</strong>
          <!-- <p>게시판의 내용을 확인하세요.</p> -->
          <form class="search_form">
            <label class="hidden">검색분류</label>
            <select name="t">
              <option ${(param.t == "title") ? "selected" : ""} value="title">제목</option>
              <option ${(param.t == "writer") ? "selected" : ""} value="writer">작성자</option>
            </select>
            <label class="hidden">검색어</label>
            <input class="words" type="text" name="w" value="${param.w}" placeholder="검색어 입력" />
            <input type="submit" value="검색"/>

          </form>
        </div>

        <div class="board_list_wrap">
          <div class="board_list">
            <div class="top">
              <div class="num">번호</div>
              <div class="title">제목</div>
              <div class="writer">작성자</div>
              <div class="date">작성일</div>
              <div class="count">조회수</div>
            </div>
            <c:forEach var="b" items="${list}">
            <div>
              <div class="num">${b.bNo}</div>
              <div class="title"><a href="view?no=${b.bNo}">${b.title}</a></div>
              <div class="writer">${b.writer}</div>
              <div class="date">${b.regDate}</div>
              <div class="count">${b.hit}</div>
            </div>
            </c:forEach> 
          </div>
          
          <!-- empty : 값이 널이거나 비어있는지 조사 -->
          <c:set var="page" value="${(empty param.p) ? 1 : param.p}" />
          <c:set var="startNum" value="${page - ((page-1) % 5)}" />
          <!-- subStringBefore(값, 조건) 조건의 앞의 값만 취해줌 -->
          <c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/5), '.')}" />
         
         <label class="hidden">현재 페이지 표시</label>
         <div class="current_page"><span>${(empty param.p) ? 1 : param.p}</span> / ${lastNum} pages</div>
         
          <div class="board_page">
          	<label class="hidden">이전페이지</label>
          	<c:if test="${startNum > 1}">
	            <a href="?p=${startNum -1}&t=${param.t}&w=${param.w}" class="bt prev">
	              <span class="material-icons">keyboard_double_arrow_left</span>
	            </a>
            </c:if>
            
            <c:if test="${startNum <= 1}">
	              <span class="bt prev material-icons" onclick="alert('이전 페이지가 없습니다.');">
	              keyboard_double_arrow_left
	              </span>
            </c:if>
            
            <!-- 1 2 3 4 5 페이지 만들기 개수제한 조건문 생성 -->
            <c:forEach var="i" begin="0" end="4">
            	<c:if test="${(startNum + i) <= lastNum}">
	            	<a class="num ${(page==(startNum+i))?'blue':''}" href="?p=${startNum+i}&t=${param.t}&w=${param.w}">${startNum+i}</a>
	            </c:if>
            </c:forEach>
            
            
            <label class="hidden">다음페이지</label>
            <c:if test="${startNum + 5 <= lastNum}">
	            <a href="?p=${startNum +5 }&t=${param.t}&w=${param.w}" class="bt next">
	              <span class="material-icons">keyboard_double_arrow_right</span>
	            </a>
            </c:if>
            <c:if test="${startNum + 5 > lastNum}">
	            <span class="bt next material-icons" onclick="alert('다음 페이지가 없습니다.');">
	            keyboard_double_arrow_right
	            </span>
            </c:if>
          </div>
  
  
          <div class="bt_wrap">
          	<c:if test="${not empty sessionId}">
				<a href="insert" class="on">글쓰기</a>
				<!-- <a href="#">수정</a> -->
  			</c:if>

            <c:if test="${empty sessionId}">
				<span class="on" onclick="alert('로그인 후 이용해주세요.');">글쓰기</span>
  			</c:if>
          </div>
        </div>
      </div>
    </section>

    <footer>
      <div class="inner">
        <div class="logo_img"><img src="/images/logo-modified.png" alt="로고"></div>
        <div>
          &copy; <strong><span>RadiantK</span></strong><br/>
          <a href="https://github.com//RadiantK">https://github.com//RadiantK</a><br/>     
        </div>
      </div>
    </footer>
  </div>
</body>
</html>