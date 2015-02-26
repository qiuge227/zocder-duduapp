package com.truck.domain;

public class GoodsOrder {
	private String passengerPhone; // �˿Ͷ����ĵ绰
	private String goodsSendTime;// ʲôʱ�����
	private String goodsSendFrom; // ���ĳ���
	private String goodsSendTo; // ����ȥ
	private String goodsDetail; // ��������
	private String wordToDriver; // ��˾���Ӿ仰
	private int stutas; // ״̬ 0��ʾ�ȴ�������1��ʾ�����ɹ���2��ʾ��������
	private String driverPhone; // �����ɹ���˾���ĵ绰

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
			wordToDriver = "δ֪";
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
			driverPhone = "δ֪";
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
