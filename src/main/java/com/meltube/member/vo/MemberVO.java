package com.meltube.member.vo;

public class MemberVO {
	private String id;
	private String nickname;
	private String password;
	private String email;
	private int registDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRegistDate() {
		return registDate;
	}

	public void setRegistDate(int registDate) {
		this.registDate = registDate;
	}

}
