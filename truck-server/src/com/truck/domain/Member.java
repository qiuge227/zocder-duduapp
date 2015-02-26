package com.truck.domain;

/**
 * ç®¡ç†å‘˜ä¿¡æ?
 * @author bianyixuan
 *
 */
public class Member {
	private int id;   //±àºÅ
	private String mname; //ĞÕÃû
	private String password;  //ÃÜÂë
	private String pdate;  //×¢²áÊ±¼ä
	
	
	 
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
