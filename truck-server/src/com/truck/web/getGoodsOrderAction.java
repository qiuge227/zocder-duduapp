package com.truck.web;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;
import com.truck.domain.GoodsOrder;
import com.truck.domain.JsonResponse_goodsOrder;
import com.truck.logic.impl.DBGoodsMgrImpl;

public class getGoodsOrderAction {
	ArrayList<JsonResponse_goodsOrder> goodsOrders;
	ArrayList<GoodsOrder> orders;

	public String execute() {
		DBGoodsMgrImpl goodsMgrImpl = new DBGoodsMgrImpl();
		Long currentTime = System.currentTimeMillis();
		orders = new ArrayList<GoodsOrder>();
		orders = goodsMgrImpl.getGoodsOrders(currentTime);
		goodsOrders = new ArrayList<JsonResponse_goodsOrder>();
		for (int i = 0; i < orders.size(); i++) {
			JsonResponse_goodsOrder goodsOrder = new JsonResponse_goodsOrder();
			goodsOrder.setData(orders.get(i));
			goodsOrders.add(goodsOrder);
		}

		return Action.SUCCESS;
	}

	public ArrayList<JsonResponse_goodsOrder> getGoodsOrders() {
		return goodsOrders;
	}

}
