package com.javaex.vo;

public class GuestVo {
	
	private int no;
	private String name;
	private String password;
	private String content;
	private String guestdate;
	
	public GuestVo() {}

	public GuestVo(int no, String name, String password, String content, String guestdate) {
		this.no = no;
		this.name = name;
		this.password = password;
		this.content = content;
		this.guestdate = guestdate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getGuestdate() {
		return guestdate;
	}

	public void setGuestdate(String guestdate) {
		this.guestdate = guestdate;
	}

	@Override
	public String toString() {
		return "GuestVo [no=" + no + ", name=" + name + ", password=" + password + ", content=" + content
				+ ", guestdate=" + guestdate + "]";
	}
	
	
	


}
