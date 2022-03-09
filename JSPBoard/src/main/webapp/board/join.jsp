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
  <div id="wrap">
    <header class="head">
      <div class="logo">
        <a href="main"><img src="/images/namhe.png" alt="로고" />
          <span>RadiantK</span></a>  
      </div>
      
      <c:if test="${not empty sessionId}">
     	<%="<script>alert('로그아웃 후 이용해주세요'); location.href = '/board/main'</script>" %>
     	<% out.flush(); %>
      </c:if>
      
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
    
    <!-- 로그인 -->
    <section class='signin'>
      <h1>로그인</h1>
      <div class="signin__page">
        <h2>
          <strong>Welcome!</strong> 페이지에 오신것을 환영합니다.
        </h2>
        <form action="join" method="post">
          <input type="text" name="userId" placeholder="아이디" />
          <input type="password" name="password" placeholder="비밀번호" />
          <input type="text" name="userName" placeholder="이름" />
          <input type="email" name="email" placeholder="이메일" />
          <input type="submit" value="회원가입">
        </form>
        <div class="actions">
          <a href="main">취소</a>
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