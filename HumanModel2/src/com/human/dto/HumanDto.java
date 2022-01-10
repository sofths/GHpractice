package com.human.dto;

import java.util.Date;

public class HumanDto { //DB 값 저장
	private String name;
	private int age;
	private double height;
	private Date birthday;
	public HumanDto () {}
	public HumanDto(String name, int age, double height, Date birthday) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.birthday = birthday;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
