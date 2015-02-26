package com.truck.domain;

public class GoodsOrder {
	private String passengerPhone; // 顾客订单的电话
	private String goodsSendTime;// 什么时候出发
	private String goodsSendFrom; // 从哪出发
	private String goodsSendTo; // 到哪去
	private String goodsDetail; // 货物描述
	private String wordToDriver; // 给司机捎句话
	private int stutas; // 状态 0表示等待抢单，1表示抢单成功，2表示订单过期
	private String driverPhone; // 抢购成功后司机的电话

	public String getPassengerPhone() {
		return passengerPhone;
	}

	public void setPassengerPhone(String passengerPhone) {
		this.passengerPhone = passengerPhone;
	}

	public String getGoodsSendTime() {
		return goodsSendTime;
	}

	public void setGoodsSendTime(String goodsSendTime) {
		this.goodsSendTime = goodsSendTime;
	}

	public String getGoodsSendFrom() {
		return goodsSendFrom;
	}

	public void setGoodsSendFrom(String goodsSendFrom) {
		this.goodsSendFrom = goodsSendFrom;
	}

	public String getGoodsSendTo() {
		return goodsSendTo;
	}

	public void setGoodsSendTo(String goodsSendTo) {
		this.goodsSendTo = goodsSendTo;
	}

	public String getGoodsDetail() {
		return goodsDetail;
	}

	public void setGoodsDetail(String goodsDetail) {
		this.goodsDetail = goodsDetail;
	}

	public String getWordToDriver() {
		return wordToDriver;
	}

	public void setWordToDriver(String wordToDriver) {
		if (wordToDriver == null) {
			wordToDriver = "未知";
		}
		this.wordToDriver = wordToDriver;
	}

	public int getStutas() {
		return stutas;
	}

	public void setStutas(int stutas) {
		this.stutas = stutas;
	}

	public String getDriverPhone() {
		return driverPhone;
	}

	public void setDriverPhone(String driverPhone) {
		if (driverPhone == null) {
			driverPhone = "未知";
		}
		this.driverPhone = driverPhone;
	}

	@Override
	public String toString() {
		return "GoodsOrder [passengerPhone=" + passengerPhone
				+ ", goodsSendTime=" + goodsSendTime + ", goodsSendFrom="
				+ goodsSendFrom + ", goodsSendTo=" + goodsSendTo
				+ ", goodsDetail=" + goodsDetail + ", wordToDriver="
				+ wordToDriver + ", stutas=" + stutas + ", driverPhone="
				+ driverPhone + "]";
	}

}
