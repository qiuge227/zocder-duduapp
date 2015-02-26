package com.truck.web;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;
import com.truck.domain.JsonResponse_driver;
import com.truck.domain.SimpleDriverInfo;
import com.truck.util.DriverService;



/**
 * 根据经纬度获取司机的信息
 * @author bianyixuan
 *
 */
public class GetDriverInfosAction {
	Double longitude;
	Double latitude;

	ArrayList<SimpleDriverInfo> drivers;
	ArrayList<JsonResponse_driver> jsonDriverInfo;

	public String execute() {
		// 表示根据经纬度获取司机的信息
		drivers = new ArrayList<SimpleDriverInfo>();
		drivers = DriverService.getDriverInfos(longitude, latitude);
		jsonDriverInfo = new ArrayList<JsonResponse_driver>();
		for (int i = 0; i < drivers.size(); i++) {
			JsonResponse_driver j = new JsonResponse_driver();
			j.setData(drivers.get(i));
			jsonDriverInfo.add(j);
		}

		return Action.SUCCESS;
	}

	public ArrayList<JsonResponse_driver> getDriverInfo() {
		return jsonDriverInfo;
	}

	public void setDriverInfo(ArrayList<JsonResponse_driver> driverInfo) {
		this.jsonDriverInfo = driverInfo;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

}
