package com.human.ex;

import java.util.List;

public class Member {
	private String name;
	private String id;
	private String pw;
	private String email;
	private List<String> hobby;
	
	public List<String> getHobby(){
		return hobby;
	}
	public void setHobby(List<String> hobby) {
		this.hobby= hobby;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
