package com.truck.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.directory.DirContext;

import com.truck.domain.DriverInfo;
import com.truck.domain.SimpleDriverInfo;

public class DriverService {

	/**
	 * 通过电话号码获取司机的详细信息
	 * 
	 * @return
	 */
	public static DriverInfo getDriverInfoByPhone(String phone) {
		DriverInfo driver = new DriverInfo();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from T_driver where phone=?";
		con = DButil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, phone);
			rs = ps.executeQuery();
			while (rs.next()) {
				driver.setName(rs.getString("name"));
				driver.setNumber(rs.getString("number"));
				driver.setTotalWeight(rs.getString("totalWeight"));
				driver.setTruckType(rs.getString("truckType"));
				driver.setRegister_address(rs.getString("register_address"));
				driver.setLatitude(rs.getDouble("latitude"));
				driver.setLongitude(rs.getDouble("longitude"));
			}
		} catch (SQLException e) {
			System.out.println("获取信息异常");
		}
		return driver;
	}

	/**
	 * 根据经纬度获取在线或者忙碌司机的位置信息
	 * 
	 * @param longitude
	 *            经度
	 * @param latitude
	 *            纬度
	 * @return
	 */
	public static ArrayList<SimpleDriverInfo> getDriverInfos(Double longitude,
			Double latitude) {

		ArrayList<SimpleDriverInfo> drivers = new ArrayList<SimpleDriverInfo>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from T_driver where longitude>? and longitude<? and latitude>? and latitude<? and stutas!=?";
		con = DButil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setDouble(1, longitude - 20);
			ps.setDouble(2, longitude + 20);
			ps.setDouble(3, latitude - 20);
			ps.setDouble(4, latitude + 20);
			ps.setInt(5, 2);
			rs = ps.executeQuery();
			while (rs.next()) {
				SimpleDriverInfo driver = new SimpleDriverInfo();
				driver.setLatitude(rs.getDouble("latitude"));
				driver.setLongitude(rs.getDouble("longitude"));
				driver.setPhone(rs.getString("phone"));
				driver.setStutas(rs.getInt("stutas"));
				drivers.add(driver);
			}
		} catch (SQLException e) {
			System.out.println("数据库获取信息异常");
		}
		return drivers;
	}
}
