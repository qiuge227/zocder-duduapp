package com.truck.web;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;
import com.truck.domain.JsonResponse_driver;
import com.truck.domain.SimpleDriverInfo;
import com.truck.logic.impl.DBDriverMgrImpl;

public class getDriverInfoByDistance {
	private String distance; // æ‡¿Î∑∂Œß
	private String latitude; // Œ≥∂»
	private String longitude; // æ≠∂»
	ArrayList<JsonResponse_driver> jsonDriverInfo;

	public String execute() {
		ArrayList<SimpleDriverInfo> simpleDriverInfos = new ArrayList<SimpleDriverInfo>();
		simpleDriverInfos = new DBDriverMgrImpl().getSimpleDriverInfosByDistance(
				Double.valueOf(distance), Double.valueOf(latitude),
				Double.valueOf(longitude));
		jsonDriverInfo = new ArrayList<JsonResponse_driver>();
		for (int i = 0; i < simpleDriverInfos.size(); i++) {
			JsonResponse_driver driver = new JsonResponse_driver();
			driver.setData(simpleDriverInfos.get(i));
			jsonDriverInfo.add(driver);
		}
		return Action.SUCCESS;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public ArrayList<JsonResponse_driver> getDriverInfo() {
		return jsonDriverInfo;
	}

}
