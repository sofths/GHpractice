package com.human.dto;

import java.util.Date;

public class HumanDto {
	private String name;
	private int age;
	private double height;
	private Date birthday;
	
	public HumanDto(String name, int age, double height,Date birthday1) {
		
		this.name = name;
		this.age = age;
		this.height = height;
		this.birthday = birthday1;
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
