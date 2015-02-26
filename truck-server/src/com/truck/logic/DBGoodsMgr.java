package com.truck.logic;

import java.math.BigInteger;
import java.util.ArrayList;

import com.truck.domain.GoodsOrder;

public interface DBGoodsMgr {

	/**
	 * �򶩵����в�������
	 */
	void insertToGoods(GoodsOrder goodsOrder);

	/**
	 * ����û�й��ڵģ�����û�б������Ķ�������
	 * 
	 * @param currentTime
	 *            ��ǰʱ��
	 * @return ��������
	 */
	ArrayList<GoodsOrder> getGoodsOrders(Long currentTime);

	/**
	 * ���ҵ��ö�������ϸ��Ϣͨ���绰����
	 * 
	 * @param phone
	 * @return
	 */
	ArrayList<GoodsOrder> getGoodsOrderByPhone(String phone);

	/**
	 * ͨ���绰������¶�����״̬��˾���ĵ绰���룬��ʾ��˭�����ɹ�
	 * 
	 * @param phone
	 */
	boolean updateOrderStutasByPhone(String phone, String time,
			String driverPhone);

	/**
	 * ͨ���绰���룬ɾ�����û��Ķ���
	 * 
	 * @param phone
	 */
	void deleteOrderByPhone(String phone, String time);
}
