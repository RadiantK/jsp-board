package com.radiantk.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.radiantk.board.Entity.Board;
import com.radiantk.board.util.DatabaseUtil;

public class BoardDao {

	public List<Board> getBoardList() {
		return getBoardList("title", "", 1);
	}
	
	// 전체 게시물 가져오기 게시판 페이지당 5개
	public List<Board> getBoardList(String type, String searchWord, int page) {
		List<Board> board = new ArrayList<>();
		
		String sql = "SELECT * "
				+ " FROM (SELECT ROW_NUMBER() OVER(ORDER BY regdate DESC) RN, "
				+ " BOARD.* FROM BOARD WHERE "+type+" LIKE ? AND available = 1) B"
				+ " WHERE RN BETWEEN ? AND ?";
		Connection con = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		
		try {
			con = DatabaseUtil.getConnection();
			st = con.prepareStatement(sql);
			st.setString(1, "%"+searchWord+"%");
			st.setInt(2, 1 + (page - 1) * 5); // 1 6 11 16 등차수열
			st.setInt(3, page * 5); // 5 10 15 20 25 등차수열 1~5개만 출력하도록 설정
			rs = st.executeQuery();
			
			while(rs.next()) {
				int bNo = rs.getInt("bNo"); // 게시물 번호
				String title = rs.getString("title"); // 타이틀
				String writer = rs.getString("writer"); // 작성자
				Date regDate = rs.getDate("regdate"); // 등록일
				int hit = rs.getInt("hit"); // 조회수
				String content = rs.getString("content"); //  상세내용
				int available = rs.getInt("available");
				
				Board bo = new Board(bNo, title, writer, regDate, hit, content, available);
				
				board.add(bo);
			}
					
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
		
		return board;
	}
	
	// 게시물의 상세 정보
	public Board detailBoard(int no) {
		Board board = null;
		
		String sql = "SELECT * FROM BOARD WHERE BNO = ?";
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = DatabaseUtil.getConnection();
			st = con.prepareStatement(sql);
			st.setInt(1, no);
			rs = st.executeQuery();
			
			if(rs.next()) {
				int bNo = rs.getInt("bNo");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				Date regDate = rs.getDate("regdate");
				int hit = rs.getInt("hit");
				String content = rs.getString("content");
				int available = rs.getInt("available");
				
				board = new Board(bNo, title, writer, regDate, hit, content, available);
			}
			
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
		return board;
	}
	
	public int updateBoard(String title, String content, int no) {
		String sql = "UPDATE BOARD SET title = ?, content = ? WHERE BNO = ?";
		
		Connection con = null;
		PreparedStatement st = null;
		
		try {
			con = DatabaseUtil.getConnection();
			st = con.prepareStatement(sql);
			st.setString(1, title);
			st.setString(2, content);
			st.setInt(3, no);
	
			return st.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(st != null) st.close();
			} catch (Exception e) {}
			try {
				if(con != null) con.close();
			} catch (Exception e) {}
		}
		return -1; // db 오류
	}
	
	public int deleteBoard(int no) {
		String sql = "UPDATE BOARD SET available = 0 WHERE BNO = ?";
		
		Connection con = null;
		PreparedStatement st = null;
		
		try {
			con = DatabaseUtil.getConnection();
			st = con.prepareStatement(sql);
			st.setInt(1, no);
	
			return st.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(st != null) st.close();
			} catch (Exception e) {}
			try {
				if(con != null) con.close();
			} catch (Exception e) {}
		}
		return -1; // db 오류
	}
	
	public int getBoardCount(String type, String searchWord) {
		int count = 0;
		
		String sql = "SELECT COUNT(BNO) AS COUNT "
				+ " FROM (SELECT ROW_NUMBER() OVER(ORDER BY regdate DESC) RN, "
				+ " BOARD.* FROM BOARD WHERE "+type+" LIKE ? AND available = 1) B";
		Connection con = null;
		PreparedStatement st = null;	
		ResultSet rs = null;
		
		try {
			con = DatabaseUtil.getConnection();
			st = con.prepareStatement(sql);
			st.setString(1, "%"+searchWord+"%");
			rs = st.executeQuery();
			
			if(rs.next()) count = rs.getInt("count");
					
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
		
		return count;
	}
	
	// 게시물의 번호
	public int nextNum() {
		String sql = "SELECT BNO FROM BOARD ORDER BY BNO DESC";
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = DatabaseUtil.getConnection();
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1) + 1; // 내림차순 정렬한 첫번째 게시물의 +1 로 번호를 넣어줌
			}
			return 1; // 첫번째 게시물인 경우
		}catch(Exception e) {
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
		return -1; // 데이터베이스 오류
	}
	
	// 새로운 게시물 생성
	public int insert(String title, String writer, String content) {
		
		String sql = "INSERT INTO BOARD(bno, title, writer, content) "
				+ " VALUES(?, ?, ?, ?)";
		Connection con = null;
		PreparedStatement st = null;
		
		try {
			con = DatabaseUtil.getConnection();
			st = con.prepareStatement(sql);
			st.setInt(1, nextNum());
			st.setString(2, title);
			st.setString(3, writer);
			st.setString(4, content);
			
			return st.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(st != null) st.close();
			} catch (Exception e) {}
			try {
				if(con != null) con.close();
			} catch (Exception e) {}
		}
		return -1; // 데이터베이스 오류
	}
}
