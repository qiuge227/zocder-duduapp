package com.truck.web;

import com.opensymphony.xwork2.Action;
import com.truck.domain.JsonResponse_login;
import com.truck.logic.impl.DBDriverMgrImpl;

/**
 * ��¼��֤
 * 
 * @author bianyixuan
 * 
 */
public class loginAction {
	private String phone; // �û��绰����
	private String password; // �û�����
	JsonResponse_login jsonLogin;
	private DBDriverMgrImpl dbMgrImpl;

	public String execute() {
		dbMgrImpl = new DBDriverMgrImpl();
		jsonLogin = new JsonResponse_login();
		if (dbMgrImpl.statusCheck(phone)) {
			if (dbMgrImpl.loginCheck(phone, password)) {
				jsonLogin.setSuccess(true);
				jsonLogin.setMsg("��¼�ɹ�");
			} else {
				jsonLogin.setSuccess(false);
				jsonLogin.setMsg("�û������������");
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
