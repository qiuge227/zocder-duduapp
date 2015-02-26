package com.truck.logic.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.truck.domain.Member;
import com.truck.logic.MemberDao;
import com.truck.util.AboutPage;
import com.truck.util.DButil;

public class MemberDaoImpl implements MemberDao {

	public boolean addMember(Member member) {
		boolean flag = false;
		Connection conn = DButil.getConnection();
		String sql = "insert into T_Manager values(?,?,?)";
		PreparedStatement pstmt = DButil.prepareStatement(conn, sql);
		try {
			pstmt.setString(1, member.getMname());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getPdate());
			pstmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("添加管理员出错！");
		} finally {
			DButil.close(pstmt);
			DButil.close(conn);
		}
		return flag;
	}

	public Member getMemberById(int id) {
		Member member = null;
		Connection conn = DButil.getConnection();
		Statement stmt = DButil.createStatement(conn);
		String sql = "select * from T_Manager where id = " + id;
		ResultSet rs = DButil.executeQuery(stmt, sql);
		try {
			while (rs.next()) {
				member = new Member();
				member.setId(rs.getInt("id"));
				member.setMname((rs.getString("mname")));
				member.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			System.out.println("获取管理员失败！！");
			e.printStackTrace();
		} finally {
			DButil.close(rs);
			DButil.close(stmt);
			DButil.close(conn);
		}
		return member;
	}

	@SuppressWarnings("unchecked")
	public List<Member> showMembers(int offset, AboutPage aboutPage,
			List<Member> members, int pageSize) {
		String getDataSql = "SELECT * FROM T_manager LIMIT " + offset * 10
				+ "," + pageSize;
		Member member = new Member();
		members = aboutPage.getDatas(getDataSql, member);
		return members;
	}

	public boolean deleteMember(int id) {
		boolean flag = false;
		Connection conn = DButil.getConnection();
		String sql = "delete from T_Manager where id = " + id;
		try {
			DButil.executeUpdate(conn, sql);
			flag = true;
		} catch (Exception e) {
			System.out.println("删除管理员失败！");
			e.printStackTrace();
		} finally {
			DButil.close(conn);
		}
		return flag;

	}

	public boolean checkUsername(String username) {
		boolean flag = false;
		Connection conn = DButil.getConnection();
		String sql = "select * from T_Manager where mname = '" + username + "'";
		Statement stmt = DButil.createStatement(conn);
		ResultSet rs = DButil.executeQuery(stmt, sql);
		try {
			if (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean updateMember(Member member) {
		boolean flag = false;
		Connection conn = DButil.getConnection();
		String sql = "update T_Manager set pdate = ?,mname = ?,password = ? where id="
				+ member.getId();
		PreparedStatement pstmt = DButil.prepareStatement(conn, sql);
		try {
			pstmt.setString(1, member.getPdate());
			pstmt.setString(2, member.getMname());
			pstmt.setString(3, member.getPassword());
			pstmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			System.out.println("更新管理员失败！");
			e.printStackTrace();
		} finally {
			DButil.close(pstmt);
			DButil.close(conn);
		}
		return flag;
	}

	public boolean login(String name, String password) {
		boolean flag = false;
		String pw = "";
		Connection conn = DButil.getConnection();
		Statement stmt = DButil.createStatement(conn);
		String sql = "select * from T_Manager where mname = '" + name + "'";
		ResultSet rs = DButil.executeQuery(stmt, sql);
		try {
			while (rs.next()) {
				pw = rs.getString("password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (pw.equals(password)) {
			flag = true;
		}
		return flag;

	}
}
