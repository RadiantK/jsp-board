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
    <header>
      <div class="logo">
        <a href="main.jsp"><img src="/images/namhe.png" alt="로고" />
          <span>RadiantK</span></a>  
        
      </div>
      <ul class="menu">
        <li><a href="login.jsp">로그인</a></li>
        <li><a href="join.jsp">회원가입</a></li>
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
          <div class="board_write">
            <div class="title">
              <dl>
                <dt>제목</dt>
                <dd><input type="text" placeholder="제목 입력" /></dd>
              </dl>
            </div>
            <div class="info">
              <dl>
                <dt>사용자</dt>
                <dd><input type="text" placeholder="사용자 입력" /></dd>
              </dl>
              <dl>
                <dt>비밀번호</dt>
                <dd><input type="password" placeholder="비밀번호 입력" /></dd>
              </dl>
            </div>
            <div class="content">
              <textarea placeholder="내용 입력"></textarea>
            </div>
          </div>
  
          <div class="bt_wrap">
            <a href="view.jsp" class="on">생성</a>
            <a href="main.jsp">취소</a>
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