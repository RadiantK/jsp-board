package com.radiantk.board.entity;

import java.util.Date;

public class Board {
	private int bNo; // 게시물 번호
	private String title; // 타이틀
	private String writer; // 작성자
	private Date regDate; // 등록일
	private int hit; // 조회수
	private String content; //  상세내용
	
	public Board() {}

	public Board(int bNo, String title, String writer, Date regDate, int hit, String content) {
		this.bNo = bNo;
		this.title = title;
		this.writer = writer;
		this.regDate = regDate;
		this.hit = hit;
		this.content = content;
	}



	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String conten) {
		this.content = conten;
	};

}
