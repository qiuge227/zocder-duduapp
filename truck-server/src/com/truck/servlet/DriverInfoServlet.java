package com.truck.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.truck.domain.DriverInfo;
import com.truck.logic.impl.DriverInfoDaoImpl;
import com.truck.util.AboutPage;

public class DriverInfoServlet extends HttpServlet {
	private DriverInfoDaoImpl daoImpl = null;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		daoImpl = new DriverInfoDaoImpl();
		String phone = request.getParameter("phone") == null
				|| "".equals(request.getParameter("phone")) ? "" : request
				.getParameter("phone");
		String name = request.getParameter("name") == null
				|| "".equals(request.getParameter("name")) ? "" : request
				.getParameter("name");
		name = new String(name.getBytes("iso-8859-1"), "utf-8");
		String number = request.getParameter("number") == null
				|| "".equals(request.getParameter("number")) ? "" : request
				.getParameter("number");
		String truckType = request.getParameter("truckType") == null
				|| "".equals(request.getParameter("truckType")) ? "" : request
				.getParameter("truckType");
		truckType = new String(truckType.getBytes("iso-8859-1"), "utf-8");
		String isLogin = request.getParameter("isLogin") == null
				|| "".equals(request.getParameter("isLogin")) ? "0" : request
				.getParameter("isLogin");
		String totalWeight = request.getParameter("totalWeight") == null
				|| "".equals(request.getParameter("totalWeight")) ? ""
				: request.getParameter("totalWeight");
		String method = request.getParameter("method") == null
				|| "".equals(request.getParameter("method")) ? "" : request
				.getParameter("method");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		if (method.equals("updateStatus")) {
			if (daoImpl.updateStatus(phone, Integer.parseInt(isLogin))) {
				request.setAttribute("result", "更新嘟嘟司机信息成功！");
			} else {
				request.setAttribute("result", "更新嘟嘟司机信息失败！");
			}
			request.getRequestDispatcher("driverInfo.do?method=driverInfoList")
					.forward(request, response);
		}
		if (method.equals("addDriver")) {
			DriverInfo driverInfo = new DriverInfo();
			driverInfo.setIsLogin(Integer.parseInt(isLogin));
			driverInfo.setName(name);
			driverInfo.setNumber(number);
			driverInfo.setPhone(phone);
			driverInfo.setTotalWeight(totalWeight);
			driverInfo.setTruckType(truckType);
			if (daoImpl.addDriverInfo(driverInfo)) {
				request.setAttribute("result", "添加嘟嘟司机信息成功！");
			} else {
				request.setAttribute("result", "添加嘟嘟司机信息失败！");
			}
			request.getRequestDispatcher("driverInfo.do?method=driverInfoList")
					.forward(request, response);
		}
		if (method.equals("driverInfoList")) {
			int offset = Integer
					.parseInt(request.getParameter("pager.offset") == null ? "0"
							: request.getParameter("pager.offset"));
			String strpage = (String) request.getParameter("page") == null ? ""
					: (String) request.getParameter("page");
			int page = 1;
			if (strpage.equals("")) {
			} else {
				page = Integer.parseInt(strpage);
			}
			AboutPage aboutPage = new AboutPage();
			String sql = "select * from t_driver";
			aboutPage.setTotalAndTotalPage(sql);
			int totalRecord = aboutPage.getTotal();
			int totalPage = aboutPage.getTotalPage();
			if (page <= 0) {
				page = 1;
			}
			if (page > totalPage) {
				offset = (totalPage - 1) * 10;
				page = totalPage;
			}
			List<DriverInfo> driverInfos = new ArrayList<DriverInfo>();
			driverInfos = daoImpl.showDriverInfos(offset, aboutPage,
					driverInfos, 10);
			request.setAttribute("totalRecord", totalRecord);
			request.setAttribute("page", page);
			request.setAttribute("driverInfos", driverInfos);
			request.getRequestDispatcher("/admin/driverInfo/driverInfoList.jsp")
					.forward(request, response);
		}
		if (method.equals("updateDriverInfoBefore")) {
			DriverInfo driverInfo = daoImpl.getDriverInfoById(phone);
			request.setAttribute("driverInfo", driverInfo);
			request.getRequestDispatcher(
					"/admin/driverInfo/updateDriverInfo.jsp").forward(request,
					response);
		}
		if (method.equals("updateDriverInfo")) {
			DriverInfo driverInfo = daoImpl.getDriverInfoById(phone);
			driverInfo.setIsLogin(Integer.parseInt(isLogin));
			driverInfo.setName(name);
			driverInfo.setNumber(number);
			driverInfo.setPhone(phone);
			driverInfo.setTotalWeight(totalWeight);
			driverInfo.setTruckType(truckType);
			if (daoImpl.updateDriverInfo(driverInfo)) {
				request.setAttribute("result", "更新嘟嘟司机信息成功！");
			} else {
				request.setAttribute("result", "更新嘟嘟司机信息失败！");
			}
			request.getRequestDispatcher("driverInfo.do?method=driverInfoList")
					.forward(request, response);
		}
		if (method.equals("deleteDriverInfo")) {
			if (daoImpl.deleteDriverInfo(phone)) {
				request.setAttribute("result", "删除嘟嘟司机信息成功！");
			} else {
				request.setAttribute("result", "删除嘟嘟司机信息失败！");
			}
			request.getRequestDispatcher("driverInfo.do?method=driverInfoList")
					.forward(request, response);
		}
	}
}
