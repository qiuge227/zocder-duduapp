package com.truck.domain;

/**
 * ˾��ʵ����
 * 
 * @author bianyixuan
 * 
 */
public class DriverInfo {
	private String name; // ����
	private String number;// ����
	private String phone;// ��ϵ��ʽ
	private String totalWeight; // ����
	private double longitude; // ����
	private double latitude;// γ��
	private String register_address; // ע���ַ
	private String truckType; // ���ͺ�
	private int stutas;// ״̬ 0��ʾæµ��1��ʾ���У�2��ʾ����
	private int isLogin; // 0��ʾ����ֹ��1��ʾ����
	private String password; // ˾����¼����

	public int getIsLogin() {
		return isLogin;
	}

	public void setIsLogin(int isLogin) {
		this.isLogin = isLogin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegister_address() {
		return register_address;
	}

	public void setRegister_address(String register_address) {
		this.register_address = register_address;
	}

	 
	public String getTruckType() {
		return truckType;
	}

	public void setTruckType(String truckType) {
		this.truckType = truckType;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(String totalWeight) {
		this.totalWeight = totalWeight;
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

}
