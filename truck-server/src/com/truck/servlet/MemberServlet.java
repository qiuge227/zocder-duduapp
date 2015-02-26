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

import com.truck.domain.Member;
import com.truck.logic.impl.MemberDaoImpl;
import com.truck.util.AboutPage;

public class MemberServlet extends HttpServlet {
	private MemberDaoImpl daoImpl = null;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		daoImpl = new MemberDaoImpl();
		int id = Integer.parseInt(request.getParameter("id") == null
				|| "".equals(request.getParameter("id")) ? "0" : request
				.getParameter("id"));
		String name = request.getParameter("name") == null
				|| "".equals(request.getParameter("name")) ? "" : request
				.getParameter("name");
		String password = request.getParameter("password") == null
				|| "".equals(request.getParameter("password")) ? "" : request
				.getParameter("password");
		String method = request.getParameter("method") == null
				|| "".equals(request.getParameter("method")) ? "" : request
				.getParameter("method");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		if (method.equals("addMember")) {
			Member member = new Member();
			member.setMname(name);
			member.setPassword(password);
			member.setPdate(format.format(new Date()));
			if (daoImpl.checkUsername(name)) {
				request.setAttribute("result", "已有此管理员，请重新添加！");
				request.getRequestDispatcher("/admin/member/addMember.jsp")
						.forward(request, response);
				return;
			} else {
				if (daoImpl.addMember(member)) {
					request.setAttribute("result", "添加管理员成功！");
				} else {
					request.setAttribute("result", "添加管理员失败！");
				}
			}
			request.getRequestDispatcher("member.do?method=memberList")
					.forward(request, response);
		}
		if (method.equals("memberList")) {
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
			String sql = "select * from T_Manager";
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
			List<Member> members = new ArrayList<Member>();
			members = daoImpl.showMembers(offset, aboutPage, members, 10);
			request.setAttribute("totalRecord", totalRecord);
			request.setAttribute("page", page);
			request.setAttribute("members", members);
			request.getRequestDispatcher("/admin/member/memberList.jsp")
					.forward(request, response);
		}
		if (method.equals("updateMemberBefore")) {
			Member member = daoImpl.getMemberById(id);
			request.setAttribute("member", member);
			request.getRequestDispatcher("/admin/member/updateMember.jsp")
					.forward(request, response);
		}
		if (method.equals("updateMember")) {
			Member member = daoImpl.getMemberById(id);
			member.setMname(name);
			member.setPassword(password);
			member.setPdate(format.format(new Date()));
			if (daoImpl.updateMember(member)) {
				request.setAttribute("result", "更新管理员成功！");
			} else {
				request.setAttribute("result", "更新管理员失败！");
			}
			request.getRequestDispatcher("member.do?method=memberList")
					.forward(request, response);
		}
		if (method.equals("deleteMember")) {
			if (daoImpl.deleteMember(id)) {
				request.setAttribute("result", "删除管理员成功！");
			} else {
				request.setAttribute("result", "删除管理员失败！");
			}
			request.getRequestDispatcher("member.do?method=memberList")
					.forward(request, response);
		}
	}
}
