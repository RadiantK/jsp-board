package com.radiantk.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.radiantk.board.dao.BoardDao;

@SuppressWarnings("serial")
@WebServlet("/board/insert")
public class BoardInsertController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.getRequestDispatcher("/board/insert.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title_ = request.getParameter("title");
		String title = "";
		if(title_ != null && !title_.equals("")) title = title_;
		
		String writer_ = request.getParameter("writer");
		String writer = "";
		if(writer_ != null && !writer_.equals("")) writer = writer_;
		
		String content_ = request.getParameter("content");
		String content = "";
		if(content_ != null && !content_.equals("")) content = content_;
		
		if(title_ == null || title_.equals("") || content_ == null || content_.equals("")) {
			System.out.println("비어있는 내용이 있습니다.");
			response.sendRedirect("/board/insert");
//		} else if(!request.getSession().getAttribute("sessionId").equals(writer_)) {
//			System.out.println("아이디가 다릅니다.");
//			response.sendRedirect("/board/insert");
		}
		else {
			BoardDao bd = new BoardDao();
			
			int result = bd.insert(title, writer, content);
			if(result == 1) {
				System.out.println("글쓰기에 성공.");
				response.sendRedirect("/board/main");
			} else {
				System.out.println("글쓰기에 실패했습니다.");
				response.sendRedirect("/board/insert");
			}
		}
	}
	
}
