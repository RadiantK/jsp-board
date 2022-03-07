package com.radiantk.board.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.radiantk.board.entity.Board;

@SuppressWarnings("serial")
@WebServlet("/board/main")
public class BoardListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM board ORDER BY regdate DESC";
			String url = "jdbc:mysql://localhost/board";
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "board", "board");
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			List<Board> list = new ArrayList<>();
			
			while(rs.next()) {
				int bNo = rs.getInt("bNo");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				Date regDate = rs.getDate("regdate");
				int hit = rs.getInt("hit");
				String content = rs.getString("content");
				
				Board bo = new Board(bNo, title, writer, regDate, hit, content);
				
				list.add(bo);
			}
			
			request.setAttribute("list", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("/board/main.jsp");
			rd.include(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
			} catch (Exception e) {}
			try {
				if(st != null) st.close();
			} catch (Exception e) {}
			try {
				if(con != null) con.close();
			} catch (Exception e) {}
		}
	}
}
