package com.truck.web;

import com.opensymphony.xwork2.Action;
import com.truck.domain.DriverInfo;
import com.truck.domain.JsonResponse_driverByPhone;
import com.truck.util.DriverService;

/**
 * 根据电话号码获取司机的对象
 * 
 * @author bianyixuan
 * 
 */
public class getDriverInfosByPhoneAction {
	private String phone;
	private DriverInfo driverInfo;
	JsonResponse_driverByPhone jsonDriverInfo;

	public String execute() {

		driverInfo = DriverService.getDriverInfoByPhone(phone);

		jsonDriverInfo = new JsonResponse_driverByPhone();

		jsonDriverInfo.setName(driverInfo.getName());
		jsonDriverInfo.setNumber(driverInfo.getNumber());
		jsonDriverInfo.setRegister_address(driverInfo.getRegister_address());
		jsonDriverInfo.setTotalWeight(driverInfo.getTotalWeight());
		jsonDriverInfo.setTruck_type(driverInfo.getTruckType());
		jsonDriverInfo.setLatitude(driverInfo.getLatitude());
		jsonDriverInfo.setLongitude(driverInfo.getLongitude());
		return Action.SUCCESS;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public JsonResponse_driverByPhone getDriverInfo() {
		return jsonDriverInfo;
	}

}
