package com.radiantk.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.radiantk.board.Entity.User;
import com.radiantk.board.util.DatabaseUtil;

public class UserDao {

	public int join(User user) {
		String sql = "INSERT INTO USERS(USERID, PASSWORD, USERNAME, EMAIL) "
				+ " VALUES(?,?,?,?)";
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DatabaseUtil.getConnection();
			st = con.prepareStatement(sql);
			st.setString(1, user.getUserId());
			st.setString(2, user.getPassword());
			st.setString(3, user.getUserName());
			st.setString(4, user.getEmail());
			
			return st.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(st != null) st.close();
				if(con != null) con.close();
			} catch(Exception e) {}
		}
		return -1; // 회원등록 실패
	}
	
	public int login(String userId, String password) {
		String sql = "SELECT password FROM USERS WHERE USERID = ?";
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = DatabaseUtil.getConnection();
			st = con.prepareStatement(sql);
			st.setString(1, userId);
			rs = st.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("password").equals(password)) return 1; // 로그인 성공
			} else {
				return 0; // 비밀번호가 일치하지 않음
			}
			return -1; // 빈 값 존재
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(st != null) st.close();
				if(con != null) con.close();
			} catch(Exception e) {}
		}
		return -2; // db에러
	}
}
