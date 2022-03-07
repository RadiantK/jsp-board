<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

	<c:if test="${empty sessionId}">
		<%="<script>alert('로그인이 되어 있지 않습니다.')" %>
		<%="location.href = 'main'</script>" %>
   </c:if>

  <div id="wrap">
    <header>
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
          <strong><span>직접 만드는 홈페이지</span></strong>
          <p>홈페이지 만들기 연습입니다.</p>
        </div>
      </div>
    </section>
    
    <!-- 게시판 List -->
    <section>
      <div class="board_wrap">
        <div class="board_title">
          <strong>게시판</strong>
          <p>게시판의 내용을 확인하세요.</p>
        </div>

        <div class="board_write_wrap">
          <form action="insert" method="post">
	          <div class="board_write">
	            <div class="title">
	              <dl>
	                <dt>제목</dt>
	                <dd><input type="text" name="title" placeholder="제목 입력" /></dd>
	              </dl>
	            </div>
	            <div class="info">
	              <dl>
	                <dt>사용자</dt>
	                <dd><input type="text" name="writer" value="${sessionId}" readonly /></dd>
	              </dl>
	             <!--  <dl>
	                <dt>비밀번호</dt>
	                <dd><input type="password"  placeholder="비밀번호 입력" /></dd>
	              </dl> -->
	            </div>
	            <div class="content">
	              <textarea name ="content" placeholder="내용 입력"></textarea>
	            </div>
	          </div>
	
	          <div class="bt_wrap">
	            <input class="on" type="submit" value="생성" />
	            <a href="main">취소</a>
	          </div>
          </form>
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