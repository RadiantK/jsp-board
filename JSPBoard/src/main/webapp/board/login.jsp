<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <li><a href="login.jsp">로그인</a></li>
        <li><a href="join.jsp">회원가입</a></li>
      </ul>
    </header>

    <!-- 로그인 -->
    <section class='signin'>
      <h1>로그인</h1>
      <div class="signin__page">
        <h2>
          <strong>Welcome!</strong> 페이지에 오신것을 환영합니다.
        </h2>
        <form action="login" method="post">
          <input type="text" name="userId" placeholder="아이디를 입력하세요.">
          <input type="password" name="password" placeholder="비밀번호를 입력하세요.">
          <input type="submit" value="로그인">
          <p>
            * 비밀번호를 타 사이트와 같이 사용할 경우 도용 위험이 있으니,<br/>
            정기적으로 비밀번호를 변경하세요.
          </p>
        </form>
        <div class="actions">
          <a href="join">회원가입</a>
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