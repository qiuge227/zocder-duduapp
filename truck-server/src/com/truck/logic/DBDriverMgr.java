package com.truck.logic;

import java.util.ArrayList;

import com.truck.domain.DriverInfo;
import com.truck.domain.SimpleDriverInfo;

/**
 * ���ݿ����ӿ�
 * 
 * @author bianyixuan
 * 
 */
public interface DBDriverMgr {

	void insert(DriverInfo driver);

	void update(String phone, String latitude, String longitude);

	void update(String phone, int i);

	boolean loginCheck(String phone, String password);

	/**
	 * ���ݾ�γ�ȣ����������뷶Χ�ڵ�����˾��
	 * 
	 * @param distance
	 * @param latitude
	 * @param longitude
	 * @return
	 */
	ArrayList<SimpleDriverInfo> getSimpleDriverInfosByDistance(double distance,
			double latitude, double longitude);
	/**
	 * ���õ绰�����Ƿ�ע��
	 * @param phone
	 * @return
	 */
	boolean checkPhone(String phone);
	
	/**
	 * �޸�����
	 * @param phone
	 * @param password
	 */
	void update(String phone,String password);
}
