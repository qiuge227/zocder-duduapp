package com.truck.domain;


/**
 * ���ݵ绰�����ȡ˾������Ϣ���ص�json�����ֶ���
 * @author bianyixuan
 *
 */
public class JsonResponse_driverByPhone {
	private String name; // ����
	private String number;// ����
	private String totalWeight; // ����
	private String register_address; // ע���ַ
	private String truck_type; // ���ͺ�
	private Double latitude; //����
	private Double longitude; //γ��
	
	
	
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
