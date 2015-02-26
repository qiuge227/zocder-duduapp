package com.truck.domain;


/**
 * 根据电话号码获取司机的信息返回的json串的字段名
 * @author bianyixuan
 *
 */
public class JsonResponse_driverByPhone {
	private String name; // 姓名
	private String number;// 车牌
	private String totalWeight; // 限重
	private String register_address; // 注册地址
	private String truck_type; // 车型号
	private Double latitude; //经度
	private Double longitude; //纬度
	
	
	
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getTotalWeight() {
		return totalWeight;
	}
	public void setTotalWeight(String totalWeight) {
		this.totalWeight = totalWeight;
	}
	public String getRegister_address() {
		return register_address;
	}
	public void setRegister_address(String register_address) {
		this.register_address = register_address;
	}
	public String getTruck_type() {
		return truck_type;
	}
	public void setTruck_type(String truck_type) {
		this.truck_type = truck_type;
	}
	
	
}
