package com.truck.logic.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.truck.domain.DriverInfo;
import com.truck.logic.DriverInfoDao;
import com.truck.util.AboutPage;
import com.truck.util.DButil;

public class DriverInfoDaoImpl implements DriverInfoDao {

	public boolean addDriverInfo(DriverInfo driverInfo) {
		boolean flag = false;
		Connection conn = DButil.getConnection();
		String sql = "insert into t_driver (number,name,phone,totalWeight,truckType,isLogin,password) values(?,?,?,?,?,?,?)";
		PreparedStatement pstmt = DButil.prepareStatement(conn, sql);
		try {
			pstmt.setString(1, driverInfo.getNumber());
			pstmt.setString(2, driverInfo.getName());
			pstmt.setString(3, driverInfo.getPhone());
			pstmt.setString(4, driverInfo.getTotalWeight());
			pstmt.setString(5, driverInfo.getTruckType());
			pstmt.setInt(6, 0);
			pstmt.setString(7, "123456");
			pstmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("添加嘟嘟司机信息出错！");
		} finally {
			DButil.close(pstmt);
			DButil.close(conn);
		}
		return flag;
	}

	public DriverInfo getDriverInfoById(String phone) {
		DriverInfo driverInfo = null;
		Connection conn = DButil.getConnection();
		Statement stmt = DButil.createStatement(conn);
		String sql = "select * from t_driver where phone = '" + phone + "'";
		ResultSet rs = DButil.executeQuery(stmt, sql);
		try {
			while (rs.next()) {
				driverInfo = new DriverInfo();
				driverInfo.setIsLogin(rs.getInt("isLogin"));
				driverInfo.setNumber(rs.getString("number"));
				driverInfo.setName(rs.getString("name"));
				driverInfo.setPhone(rs.getString("phone"));
				driverInfo.setTotalWeight(rs.getString("totalWeight"));
				driverInfo.setTruckType(rs.getString("truckType"));
			}
		} catch (SQLException e) {
			System.out.println("获取管理员失败！！");
			e.printStackTrace();
		} finally {
			DButil.close(rs);
			DButil.close(stmt);
			DButil.close(conn);
		}
		return driverInfo;
	}

	@SuppressWarnings("unchecked")
	public List<DriverInfo> showDriverInfos(int offset, AboutPage aboutPage,
			List<DriverInfo> driverInfos, int pageSize) {
		String getDataSql = "SELECT * FROM t_driver LIMIT " + offset * 10 + ","
				+ pageSize;
		DriverInfo driverInfo = new DriverInfo();
		driverInfos = aboutPage.getDatas(getDataSql, driverInfo);
		return driverInfos;
	}

	public boolean deleteDriverInfo(String phone) {
		System.out.println(phone);
		boolean flag = false;
		Connection conn = DButil.getConnection();
		String sql = "delete from t_driver where phone = '" + phone + "'";
		try {
			DButil.executeUpdate(conn, sql);
			flag = true;
		} catch (Exception e) {
			System.out.println("删除嘟嘟司机信息失败！");
			e.printStackTrace();
		} finally {
			DButil.close(conn);
		}
		return flag;

	}

	public boolean updateStatus(String phone, int isLogin) {
		System.out.println(phone);
		boolean flag = false;
		Connection conn = DButil.getConnection();
		String sql = "update t_driver set isLogin=" + isLogin
				+ " where phone = '" + phone + "'";
		try {
			DButil.executeUpdate(conn, sql);
			flag = true;
		} catch (Exception e) {
			System.out.println("删除嘟嘟司机信息失败！");
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

	public boolean updateDriverInfo(DriverInfo driverInfo) {
		boolean flag = false;
		Connection conn = DButil.getConnection();
		String sql = "update t_driver set name = ?,number = ?,phone = ?,totalWeight=?,truckType=? where phone='"
				+ driverInfo.getPhone() + "'";
		PreparedStatement pstmt = DButil.prepareStatement(conn, sql);
		try {
			pstmt.setString(1, driverInfo.getName());
			pstmt.setString(2, driverInfo.getNumber());
			pstmt.setString(3, driverInfo.getPhone());
			pstmt.setString(4, driverInfo.getTotalWeight());
			pstmt.setString(5, driverInfo.getTruckType());
			pstmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			System.out.println("更新嘟嘟司机信息失败！");
			e.printStackTrace();
		} finally {
			DButil.close(pstmt);
			DButil.close(conn);
		}
		return flag;
	}

}
