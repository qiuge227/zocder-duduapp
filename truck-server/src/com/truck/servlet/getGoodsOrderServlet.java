package com.truck.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.truck.domain.GoodsOrder;
import com.truck.logic.impl.DBGoodsMgrImpl;

public class getGoodsOrderServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html;charset=utf-8");
		DBGoodsMgrImpl goodsMgrImpl = new DBGoodsMgrImpl();
		String flag = req.getParameter("flag"); // 标示
		String passengerPhone = req.getParameter("passengerPhone");
		String time = req.getParameter("time");
		time = new String(time.getBytes("ISO-8859-1"), "utf-8");
		if (flag.equals("insert")) {
			String to = req.getParameter("to");
			to = new String(to.getBytes("ISO-8859-1"), "utf-8");
			String from = req.getParameter("from");
			from = new String(from.getBytes("ISO-8859-1"), "utf-8");

			String word = req.getParameter("word");
			word = new String(word.getBytes("ISO-8859-1"), "utf-8");
			String detail = req.getParameter("detail");
			detail = new String(detail.getBytes("ISO-8859-1"), "utf-8");
			GoodsOrder goodsOrder = new GoodsOrder();
			goodsOrder.setPassengerPhone(passengerPhone);
			goodsOrder.setGoodsDetail(detail);
			goodsOrder.setGoodsSendFrom(from);
			goodsOrder.setGoodsSendTime(time);
			goodsOrder.setWordToDriver(word);
			goodsOrder.setGoodsSendTo(to);
			goodsOrder.setStutas(0);// 表示没有被抢单的状态
			goodsMgrImpl.insertToGoods(goodsOrder);
		} else if (flag.equals("delete")) {
			goodsMgrImpl.deleteOrderByPhone(passengerPhone, time);
		} else if (flag.equals("update")) {
			String driverPhone = req.getParameter("driverPhone");
			if (goodsMgrImpl.updateOrderStutasByPhone(passengerPhone, time,
					driverPhone)) {
				// 表示更新成功
				out.print("{success:true,msg:'成功抢购该订单！'}");
			} else {
				out.print("{success:false,msg:'该订单已被抢！'}");
			}
		}
	}
}
