package com.truck.logic.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.truck.domain.DriverInfo;
import com.truck.domain.GoodsOrder;
import com.truck.domain.SimpleDriverInfo;
import com.truck.logic.DBDriverMgr;
import com.truck.util.DButil;
import com.truck.util.DistanceUtil;

public class DBDriverMgrImpl implements DBDriverMgr {

	/**
	 * 插入操作，将司机数据插入到数据库中
	 * 
	 * @param driver
	 * @return
	 */
	@Override
	public void insert(DriverInfo driver) {
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "insert into t_driver (name,number,phone,totalWeight,latitude,longitude,stutas,truckType,register_address,password) values(?,?,?,?,?,?,?,?,?,?)";
		connection = DButil.getConnection();
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, driver.getName());
			ps.setString(2, driver.getNumber());
			ps.setString(3, driver.getPhone());
			ps.setString(4, driver.getTotalWeight());
			ps.setDouble(5, driver.getLatitude());
			ps.setDouble(6, driver.getLongitude());
			ps.setInt(7, driver.getStutas());
			ps.setString(8, driver.getTruckType());
			ps.setString(9, driver.getRegister_address());
			ps.setString(10, driver.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("操作异常！");
		} finally {
			DButil.close(connection);
			DButil.close(ps);
		}
	}

	/**
	 * 通过电话号码，定时的更新数据库中的经纬度
	 * 
	 * @param phone
	 * @param latitude
	 * @param longitude
	 */
	public void update(String phone, String latitude, String longitude) {
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "update t_driver set latitude=?,longitude=?  where phone=?";
		connection = DButil.getConnection();
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, latitude);
			ps.setString(2, longitude);
			ps.setString(3, phone);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("更新数据库异常！");
		} finally {
			DButil.close(connection);
			DButil.close(ps);
		}
	}

	/**
	 * 通过电话号码，改变司机的状态
	 * 
	 * @param phone
	 *            司机的电话号码标示
	 * @param i
	 *            表示司机的状态
	 */
	public void update(String phone, int i) {
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "update  t_driver set stutas=? where phone=?";
		connection = DButil.getConnection();
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, i);
			ps.setString(2, phone);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("更新数据库异常！");
		} finally {
			DButil.close(connection);
			DButil.close(ps);
		}
	}

	/**
	 * 根据电话号码和密码检查用户登录账号是否合法
	 * 
	 * @param phone
	 *            用户电话号码
	 * @param password
	 *            用户密码
	 * @return
	 */
	public boolean loginCheck(String phone, String password) {
		int a = 0;
		boolean flag = false;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(*) from t_driver where phone=? and password=?";
		connection = DButil.getConnection();
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, phone);
			ps.setString(2, password);
			rs = ps.executeQuery();
			rs.first();
			a = rs.getInt(1);
			if (a != 0) { // 表示有数据
				flag = true;
			}
		} catch (SQLException e) {
			System.out.println("查询语句异常！");
		} finally {
			DButil.close(connection);
			DButil.close(ps);
			DButil.close(rs);
		}
		return flag;
	}
	
	/**
	 * 根据电话号码和密码检查用户登录账号是否合法
	 * 
	 * @param phone
	 *            用户电话号码
	 * @param password
	 *            用户密码
	 * @return
	 */
	public boolean statusCheck(String phone) {
		int a = 0;
		boolean flag = false;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from t_driver where phone=?";
		connection = DButil.getConnection();
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, phone);
			rs = ps.executeQuery();
			while (rs.next()) {
				a = rs.getInt("isLogin");
			}
			if (a != 0) { // 表示没有被禁止
				flag = true;
			}
		} catch (SQLException e) {
			System.out.println("查询语句异常！");
		} finally {
			DButil.close(connection);
			DButil.close(ps);
			DButil.close(rs);
		}
		return flag;
	}

	@Override
	public ArrayList<SimpleDriverInfo> getSimpleDriverInfosByDistance(
			double distance, double lat2, double lng2) {
		ArrayList<SimpleDriverInfo> driverInfos = new ArrayList<SimpleDriverInfo>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from t_driver where stutas!=?";
		connection = DButil.getConnection();
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, 2);
			rs = ps.executeQuery();
			while (rs.next()) {
				SimpleDriverInfo simpleDriverInfo;
				double lat1 = rs.getDouble("latitude");
				double lng1 = rs.getDouble("longitude");
				double dis = DistanceUtil.GetDistance(lat1, lng1, lat2, lng2);
				if (dis < distance) {
					simpleDriverInfo = new SimpleDriverInfo();
					int stutas = rs.getInt("stutas");
					String phone = rs.getString("phone");
					simpleDriverInfo.setLatitude(lat1);
					simpleDriverInfo.setLongitude(lng1);
					simpleDriverInfo.setPhone(phone);
					simpleDriverInfo.setStutas(stutas);
					driverInfos.add(simpleDriverInfo);
				}
			}
		} catch (SQLException e) {
			System.out.println("sql语句异常");
		}
		return driverInfos;
	}

	/**
	 * 检查该电话号码是否存在
	 */
	@Override
	public boolean checkPhone(String phone) {
		int a = 0;
		boolean flag = false;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(*) from t_driver where phone=?";
		connection = DButil.getConnection();
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, phone);
			rs = ps.executeQuery();
			rs.first();
			a = rs.getInt(1);
			if (a != 0) { // 表示有数据
				flag = true;
			}
		} catch (SQLException e) {
			System.out.println("查询语句异常！");
		} finally {
			DButil.close(connection);
			DButil.close(ps);
			DButil.close(rs);
		}
		return flag;
	}

	@Override
	public void update(String phone, String password) {
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "update  t_driver set password=? where phone=?";
		connection = DButil.getConnection();
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, phone);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("更新数据库异常！");
		} finally {
			DButil.close(connection);
			DButil.close(ps);
		}
	}

}
