package com.truck.domain;

public class SimpleDriverInfo {
	private String phone;// ��ϵ��ʽ
	private double longitude; // ����
	private double latitude;// γ��
	private int stutas;// ״̬ 0��ʾæµ��1��ʾ���У�2��ʾ����

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
