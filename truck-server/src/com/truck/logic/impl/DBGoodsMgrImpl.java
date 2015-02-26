package com.truck.logic.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.truck.domain.GoodsOrder;
import com.truck.logic.DBGoodsMgr;
import com.truck.util.DButil;

public class DBGoodsMgrImpl implements DBGoodsMgr {

	@Override
	public void insertToGoods(GoodsOrder goodsOrder) {
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "insert into t_goodsOrder (goodsSendTime,goodsFrom,goodsTo,goodsDetail,wordToDriver,passengerPhone,stutas) values(?,?,?,?,?,?,?)";
		connection = DButil.getConnection();
		try {
			ps = connection.prepareStatement(sql);
			ps.setLong(1, Long.valueOf(goodsOrder.getGoodsSendTime()));
			ps.setString(2, goodsOrder.getGoodsSendFrom());
			ps.setString(3, goodsOrder.getGoodsSendTo());
			ps.setString(4, goodsOrder.getGoodsDetail());
			ps.setString(5, goodsOrder.getWordToDriver());
			ps.setString(6, goodsOrder.getPassengerPhone());
			ps.setInt(7, goodsOrder.getStutas());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("插入语句异常");
		} finally {
			DButil.close(connection);
			DButil.close(ps);
		}
	}

	@Override
	public ArrayList<GoodsOrder> getGoodsOrders(Long currentTime) {
		ArrayList<GoodsOrder> goodsOrders = new ArrayList<GoodsOrder>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from t_goodsOrder where stutas=? and goodsSendTime>?";
		connection = DButil.getConnection();
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, 0);
			ps.setLong(2, currentTime);
			rs = ps.executeQuery();
			while (rs.next()) {
				GoodsOrder order = new GoodsOrder();
				order.setGoodsSendFrom(rs.getString("goodsFrom"));
				order.setGoodsSendTime(rs.getLong("goodsSendTime") + "");
				order.setGoodsSendTo(rs.getString("goodsTo"));
				order.setPassengerPhone(rs.getString("passengerPhone"));
				goodsOrders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(connection);
			DButil.close(rs);
			DButil.close(ps);
		}
		return goodsOrders;
	}

	@Override
	public ArrayList<GoodsOrder> getGoodsOrderByPhone(String phone) {
		ArrayList<GoodsOrder> orders = new ArrayList<GoodsOrder>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from t_goodsOrder where passengerPhone=?";
		connection = DButil.getConnection();
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, phone);
			rs = ps.executeQuery();
			while (rs.next()) {
				GoodsOrder gOrder = new GoodsOrder();
				gOrder.setGoodsSendFrom(rs.getString("goodsFrom"));
				gOrder.setGoodsSendTime(rs.getLong("goodsSendTime") + "");
				gOrder.setGoodsSendTo(rs.getString("goodsTo"));
				gOrder.setPassengerPhone(rs.getString("passengerPhone"));
				gOrder.setGoodsDetail(rs.getString("goodsDetail"));
				gOrder.setPassengerPhone(phone);
				gOrder.setStutas(rs.getInt("stutas"));
				gOrder.setWordToDriver(rs.getString("wordToDriver"));
				gOrder.setDriverPhone(rs.getString("driverPhone"));
				orders.add(gOrder);
			}
		} catch (SQLException e) {
			System.out.println("查询数据异常");
		} finally {
			DButil.close(connection);
			DButil.close(rs);
			DButil.close(ps);
		}
		return orders;
	}

	@Override
	public boolean updateOrderStutasByPhone(String phone, String time,
			String driverPhone) {
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "update  t_goodsOrder set stutas=? , driverPhone=? where passengerPhone=? and stutas=? and goodsSendTime=?";
		connection = DButil.getConnection();
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setString(2, driverPhone);
			ps.setString(3, phone);
			ps.setInt(4, 0);
			ps.setLong(5, Long.valueOf(time));
			int a = ps.executeUpdate();
			if (a > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DButil.close(connection);
			DButil.close(ps);
		}
	}

	@Override
	public void deleteOrderByPhone(String phone, String time) {
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "delete from  t_goodsOrder where passengerPhone=? and goodsSendTime=?";
		connection = DButil.getConnection();
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, phone);
			ps.setLong(2, Long.valueOf(time));
			ps.execute();
		} catch (SQLException e) {
			System.out.println("删除语句异常");
		} finally {
			DButil.close(connection);
			DButil.close(ps);
		}
	}

}
