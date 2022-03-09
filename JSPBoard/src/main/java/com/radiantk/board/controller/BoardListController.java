package com.radiantk.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.radiantk.board.Entity.Board;
import com.radiantk.board.dao.BoardDao;

@SuppressWarnings("serial")
@WebServlet("/board/main")
public class BoardListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// list?p=t=w=
		String type_ = request.getParameter("t");
		String type = "title";
		if(type_ != null && !type_.equals("")) type = type_;
		
		String word_ = request.getParameter("w");
		String word = "";
		if(word_ != null && !word_.equals("")) word = word_;
		
		String page_ = request.getParameter("p");
		int page = 1;
		if(page_ != null && !page_.equals("")) page = Integer.parseInt(page_);
		
		BoardDao bd = new BoardDao();
		List<Board> list = bd.getBoardList(type, word, page);
		int count = bd.getBoardCount(type, word);
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);

		RequestDispatcher rd = request.getRequestDispatcher("/board/main.jsp");
		rd.forward(request, response);
	}
}
