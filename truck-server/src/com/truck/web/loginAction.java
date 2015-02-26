package com.truck.web;

import com.opensymphony.xwork2.Action;
import com.truck.domain.JsonResponse_login;
import com.truck.logic.impl.DBDriverMgrImpl;

/**
 * 登录验证
 * 
 * @author bianyixuan
 * 
 */
public class loginAction {
	private String phone; // 用户电话号码
	private String password; // 用户密码
	JsonResponse_login jsonLogin;
	private DBDriverMgrImpl dbMgrImpl;

	public String execute() {
		dbMgrImpl = new DBDriverMgrImpl();
		jsonLogin = new JsonResponse_login();
		if (dbMgrImpl.statusCheck(phone)) {
			if (dbMgrImpl.loginCheck(phone, password)) {
				jsonLogin.setSuccess(true);
				jsonLogin.setMsg("登录成功");
			} else {
				jsonLogin.setSuccess(false);
				jsonLogin.setMsg("用户名或密码错误！");
			}
		} else {
			jsonLogin.setSuccess(false);
			jsonLogin.setMsg("limit");
		}
		return Action.SUCCESS;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public JsonResponse_login getJsonLogin() {
		return jsonLogin;
	}

}
