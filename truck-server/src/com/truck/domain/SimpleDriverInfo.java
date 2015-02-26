package com.truck.domain;

public class SimpleDriverInfo {
	private String phone;// 联系方式
	private double longitude; // 经度
	private double latitude;// 纬度
	private int stutas;// 状态 0表示忙碌，1表示空闲，2表示离线

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public int getStutas() {
		return stutas;
	}

	public void setStutas(int stutas) {
		this.stutas = stutas;
	}

	@Override
	public String toString() {
		return "SimpleDriverInfo [phone=" + phone + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", stutas=" + stutas + "]";
	}

	
	
}
