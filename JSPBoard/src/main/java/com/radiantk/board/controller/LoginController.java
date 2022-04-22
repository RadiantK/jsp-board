package com.radiantk.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.radiantk.board.dao.UserDao;

@SuppressWarnings("serial")
@WebServlet("/board/login")
public class LoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/board/login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String loginId = null;
		if(request.getSession().getAttribute("sessionId") != null) {
			loginId = (String) request.getSession().getAttribute("sessionId");
		}
		if(loginId != null) {
			System.out.println("이미 로그인 된 아이디 입니다.");
			response.sendRedirect("/board/main");
		}
		
		String userId_ = request.getParameter("userId");
		String userId = "";
		if(userId != null && !userId_.equals("")) userId = userId_;
		
		String password_ = request.getParameter("password");
		String password = "";
		if(password_ != null && !password_.equals("")) password = password_;
		
		UserDao ud = new UserDao();
		
		int result = ud.login(userId, password);
		
		if(result == 1) {
			System.out.println("로그인 완료!");
			HttpSession session = request.getSession();
			session.setAttribute("sessionId", userId);
			
			response.sendRedirect("/board/main");
		}
		else if (result == 0) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			response.sendRedirect("/board/login");

		} 
		else if(result == -1) {
			System.out.println("아이디가 없습니다.");
			response.sendRedirect("/board/login");

		} 
		else if(result == -2) {
			System.out.println("데이터베이스 오류 입니다..");
			response.sendRedirect("/board/login");

		}
	}
}
