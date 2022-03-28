# JSP 게시판

## 사용한 환경
- JAVA(JDK11)
- Eclipse IDE
- MySQL 8.27
- tomcat 9.0.56

<br/>

## MySQL 데이터베이스 생성
- 데이터베이스와 사용자도 새로 생성을 해서 사용했습니다.<br/>

- 유저 생성
```sql
	CREATE USER 'board'@'localhost' identified by 'board';
	GRANT ALL PRIVILEGES ON *.* TO 'board'@'localhost';
	flush PRIVILEGES;
```

- 게시판
```sql
CREATE TABLE BOARD (
	BNO INTEGER, -- 글 번호
	TITLE VARCHAR(50) NOT NULL, -- 제목
	WRITER VARCHAR(20) NOT NULL, -- 작성자 아이디
	REGDATE TIMESTAMP DEFAULT NOW(), -- 등록일
	HIT INTEGER DEFAULT 0, -- 조회수
	CONTENT VARCHAR(1000), -- 내용
	AVAILABLE INTEGER DEFAULT 1,  -- 등록 / 삭제 여부
	PRIMARY KEY(BNO)
);
```

- 유저
```sql
CREATE TABLE USERS (
	USERID VARCHAR(20) NOT NULL UNIQUE, -- 회원 아이디
	PASSWORD VARCHAR(20) NOT NULL, -- 회원 비밀번호
	USERNAME VARCHAR(20) NOT NULL, -- 회원 이름
	EMAIL VARCHAR(50) NOT NULL, -- 회원 이메일
	REGDATE TIMESTAMP DEFAULT NOW(), -- 회원가입일
	PRIMARY KEY(USERID)
);
```

## 페이지 경로
- 프로젝트 이름을 제외한 루트 경로로 사용
- 프로젝트 우클릭 Properties => Web Project Settings => Context root을 / 로 설정

<br/>

## 게시판 사용법
1. 회원등록
   1. 회원가입
   1. 로그인
<br/>
<br/>

2. 메인페이지 게시물 등록
    1. 회원 등록 후 로그인하여 사용가능
    1. 메인 페이지에서 글쓰기에서 게시물 등록
    1. 게시글을 클릭하여 세부내용 확인 가능
    1. 수정 및 삭제는 자신이 작성한 글만 가능
<br/>
<br/>

3. 로그이웃
    1. 화면 상단의 로그아웃 메뉴를 사용

<br/>

## 구성
- JAVA src
1. Controller : DAO를 통해 얻어온 DB를 통해서 GET,POST 요청 처리
1. Dao : 데이터 베이스 접근 객체
1. Entity : 데이터 베이스 속성값
1. Filter : 인코딩 필터(UTF-8지정)
1. Util : DB와의 연결을 위한 Connection객체를 따로 클래스로 만듬

- WEPAPP<br/>
1. board폴더 : JSP 구성 파일
1. css폴더 : css 구성 파일
1. images폴더 : 페이지 구성에 사용한 이미지 파일

<br/>

## 사용한 외부 라이브러리
- javax.servlet.jsp.jstl-1.2.1.jar
- javax.servlet.jsp.jstl-app-1.2.1.jar
- mysql-connector-java-8.0.27.jar
