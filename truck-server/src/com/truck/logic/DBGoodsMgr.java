package com.truck.logic;

import java.math.BigInteger;
import java.util.ArrayList;

import com.truck.domain.GoodsOrder;

public interface DBGoodsMgr {

	/**
	 * 向订单表中插入数据
	 */
	void insertToGoods(GoodsOrder goodsOrder);

	/**
	 * 查找没有过期的，并且没有被抢单的订单集合
	 * 
	 * @param currentTime
	 *            当前时间
	 * @return 订单集合
	 */
	ArrayList<GoodsOrder> getGoodsOrders(Long currentTime);

	/**
	 * 查找到该订单的详细信息通过电话号码
	 * 
	 * @param phone
	 * @return
	 */
	ArrayList<GoodsOrder> getGoodsOrderByPhone(String phone);

	/**
	 * 通过电话号码更新订单的状态和司机的电话号码，表示是谁抢单成功
	 * 
	 * @param phone
	 */
	boolean updateOrderStutasByPhone(String phone, String time,
			String driverPhone);

	/**
	 * 通过电话号码，删除该用户的订单
	 * 
	 * @param phone
	 */
	void deleteOrderByPhone(String phone, String time);
}
