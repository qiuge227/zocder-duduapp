package com.truck.web;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;
import com.truck.domain.GoodsOrder;
import com.truck.domain.JsonResponse_OrderByPhone;
import com.truck.logic.impl.DBGoodsMgrImpl;

/**
 * 通过电话号码获取订单的集合
 * 
 * @author bianyixuan
 * 
 */
public class getGoodsOrderByPhoneAction {
	private String phone;
	ArrayList<JsonResponse_OrderByPhone> jsonOrders;

	public String execute() {

		ArrayList<GoodsOrder> goodsOrders = new ArrayList<GoodsOrder>();
		goodsOrders = new DBGoodsMgrImpl().getGoodsOrderByPhone(phone);
		jsonOrders = new ArrayList<JsonResponse_OrderByPhone>();
		for (int i = 0; i < goodsOrders.size(); i++) {
			JsonResponse_OrderByPhone orderByPhone = new JsonResponse_OrderByPhone();
			orderByPhone.setData(goodsOrders.get(i));
			jsonOrders.add(orderByPhone);
		}
		return Action.SUCCESS;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ArrayList<JsonResponse_OrderByPhone> getDriverInfo() {
		return jsonOrders;
	}

}
