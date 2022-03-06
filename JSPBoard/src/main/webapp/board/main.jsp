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
            <select name="search">
              <option value="title">제목</option>
              <option value="writer">작성자</option>
            </select>
            <label class="hidden">검색어</label>
            <input type="text" placeholder="검색어 입력" />
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
            <div>
              <div class="num">5</div>
              <div class="title"><a href="view.jsp">글의 제목이 들어갑니다.</a></div>
              <div class="writer">radiantk</div>
              <div class="date">2020-02-02</div>
              <div class="count">55</div>
            </div>
            <div>
              <div class="num">4</div>
              <div class="title"><a href="view.jsp">글의 제목이 들어갑니다.</a></div>
              <div class="writer">radiantk</div>
              <div class="date">2020-02-02</div>
              <div class="count">55</div>
            </div>
            <div>
              <div class="num">3</div>
              <div class="title"><a href="view.jsp">글의 제목이 들어갑니다.</a></div>
              <div class="writer">radiantk</div>
              <div class="date">2020-02-02</div>
              <div class="count">55</div>
            </div>
            <div>
              <div class="num">2</div>
              <div class="title"><a href="view.jsp">글의 제목이 들어갑니다.</a></div>
              <div class="writer">radiantk</div>
              <div class="date">2020-02-02</div>
              <div class="count">55</div>
            </div>
            <div>
              <div class="num">1</div>
              <div class="title"><a href="view.jsp">글의 제목이 들어갑니다.</a></div>
              <div class="writer">radiantk</div>
              <div class="date">2020-02-02</div>
              <div class="count">55</div>
            </div>
          </div>
  
          <div class="board_page">
            <a href="#" class="bt prev">
              <span class="material-icons">keyboard_double_arrow_left</span>
            </a>
            <a href="" class="num on">1</a>
            <a href="" class="num">2</a>
            <a href="" class="num">3</a>
            <a href="" class="num">4</a>
            <a href="" class="num">5</a>
            <a href="#" class="bt next">
              <span class="material-icons">keyboard_double_arrow_right</span>
            </a>
          </div>
  
          <div class="bt_wrap">
            <a href="insert.jsp" class="on">생성</a>
            <!-- <a href="#">수정</a> -->
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