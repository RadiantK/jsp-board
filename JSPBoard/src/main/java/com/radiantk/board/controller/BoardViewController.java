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
@WebServlet("/board/view")
public class BoardViewController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardDao bd = new BoardDao();
		Board board = bd.detailBoard(no);
		request.setAttribute("board", board);
		
		request.getRequestDispatcher("/board/view.jsp").forward(request, response);
	}
}
