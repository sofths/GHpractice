package com.human.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class HumanDTO {
private String name;
private int age;
private String height;

@DateTimeFormat(pattern="yyyy-MM-dd")
private Date birthday;

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
public String getHeight() {
	return height;
}
public void setHeight(String height) {
	this.height = height;
}
public Date getBirthday() {
	return birthday;
}
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}

}
