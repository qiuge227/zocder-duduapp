package com.truck.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.truck.domain.DriverInfo;
import com.truck.logic.impl.DBDriverMgrImpl;

public class getDriverInfoServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html;charset=utf-8");
		DBDriverMgrImpl drImpl = new DBDriverMgrImpl();
		String flag = req.getParameter("flag");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String number = req.getParameter("number");
		String weight = req.getParameter("weight");
		String address = req.getParameter("register_address");
		String truckType = req.getParameter("truckType");
		String latitude = req.getParameter("latitude");
		String longitude = req.getParameter("longitude");
		String password = req.getParameter("password");
		String statusValue = req.getParameter("statusValue");
		// 表示插入数据
		if (flag.equals("add")) {
			name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
			number = new String(number.getBytes("ISO-8859-1"), "UTF-8");
			address = new String(address.getBytes("ISO-8859-1"), "UTF-8");
			truckType = new String(truckType.getBytes("ISO-8859-1"), "UTF-8");
			DriverInfo driver = new DriverInfo();
			driver.setLatitude(Double.parseDouble(latitude));
			driver.setLongitude(Double.parseDouble(longitude));
			driver.setName(name);
			driver.setNumber(number);
			driver.setPassword(password);
			driver.setTruckType(truckType);
			driver.setRegister_address(address);
			driver.setPhone(phone);
			driver.setStutas(2); // 表示不在线
			driver.setTotalWeight(weight);
			drImpl.insert(driver);
			// 更新数据库
		} else if (flag.equals("update_latitude")) {
			drImpl.update(phone, latitude, longitude);
			// 表示只更新状态
		} else if (flag.equals("update_stutas")) {
			drImpl.update(phone, Integer.parseInt(statusValue));
		} else if (flag.equals("checkPhone")) {
			// 表示验证成功
			if (drImpl.checkPhone(phone)) {
				out.print("{success:true,msg:'该手机号已经被注册！'}");
			} else {
				out.print("{success:false,msg:'该手机号没有被注册！'}");
			}
		} else if (flag.equals("update_password")) {
			drImpl.update(phone, password);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html;charset=utf-8");
		out.print("test");
	}
}