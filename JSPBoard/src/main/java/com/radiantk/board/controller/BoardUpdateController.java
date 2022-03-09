package com.radiantk.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.radiantk.board.Entity.Board;
import com.radiantk.board.dao.BoardDao;

@SuppressWarnings("serial")
@WebServlet("/board/update")
public class BoardUpdateController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardDao bd = new BoardDao();
		Board board = bd.detailBoard(no);
		
		request.setAttribute("board", board);
		
		request.getRequestDispatcher("/board/update.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("boardTitle");
		String content = request.getParameter("boardContent");
		int no = Integer.parseInt(request.getParameter("boardNum"));
		
		BoardDao bd = new BoardDao();
		bd.updateBoard(title, content, no);
		
		response.sendRedirect("view?no="+no);
	}
}
