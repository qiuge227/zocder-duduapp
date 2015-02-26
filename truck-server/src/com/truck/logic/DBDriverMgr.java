package com.truck.logic;

import java.util.ArrayList;

import com.truck.domain.DriverInfo;
import com.truck.domain.SimpleDriverInfo;

/**
 * 数据库管理接口
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
	 * 根据经纬度，算出满足距离范围内的所有司机
	 * 
	 * @param distance
	 * @param latitude
	 * @param longitude
	 * @return
	 */
	ArrayList<SimpleDriverInfo> getSimpleDriverInfosByDistance(double distance,
			double latitude, double longitude);
	/**
	 * 检测该电话号码是否被注册
	 * @param phone
	 * @return
	 */
	boolean checkPhone(String phone);
	
	/**
	 * 修改密码
	 * @param phone
	 * @param password
	 */
	void update(String phone,String password);
}
