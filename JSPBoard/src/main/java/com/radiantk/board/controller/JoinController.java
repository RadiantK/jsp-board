package com.radiantk.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.radiantk.board.Entity.User;
import com.radiantk.board.dao.UserDao;

@SuppressWarnings("serial")
@WebServlet("/board/join")
public class JoinController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/board/join.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String userId_ = request.getParameter("userId");
		String userId = "";
		if(userId_ != null && !userId_.equals("")) userId = userId_;
		
		String password_ = request.getParameter("password");
		String password = "";
		if(password_ != null && !password_.equals("")) password = password_;
		
		String userName_ = request.getParameter("userName");
		String userName = "";
		if(userName_ != null && !userName_.equals("")) userName = userName_;
		
		String email_ = request.getParameter("email");	
		String email = "";
		if(email_ != null && !email_.equals("")) email = email_;
		
		if(userId_ == null || userId_.equals("") ||	password_ == null || password_.equals("") ||
				email_ == null || email_.equals("") || userName_ == null || userName_.equals("")) {
			System.out.println("비어있는 부분이 있습니다.");
			response.sendRedirect("/WEB-INF/board/join");
		} else {
			User user = new User(userId, password, userName, email);
			
			UserDao ud = new UserDao();
			int result = ud.join(user);

			if(result == -1) {
				System.out.println("회원가입 실패.");
				response.sendRedirect("/WEB-INF/board/join");
			} else {
				System.out.println("회원가입이 완료되었습니다.");
				response.sendRedirect("/WEB-INF/board/main");
			}
		}
	}
}
