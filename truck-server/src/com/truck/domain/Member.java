package com.truck.domain;

/**
 * 管理员信�?
 * @author bianyixuan
 *
 */
public class Member {
	private int id;   //���
	private String mname; //����
	private String password;  //����
	private String pdate;  //ע��ʱ��
	
	
	 
	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMname() {
		return mname;
	}

	public String getPassword() {
		return password;
	}

	 
	
	public void setMname(String mname) {
		this.mname = mname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	 
}
