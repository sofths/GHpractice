package com.human.dto;

import java.text.ParseException;
import java.util.Date;

public class HumanDto {
	private String name;
	private int age;
	private double tall;
	private Date birth;
	
	@Override
	public String toString() {
		return "HumanDto [name=" + name + ", age=" + age + ", tall=" + tall + ", birth=" + birth + "]";
	}
	public HumanDto() {}
	public HumanDto(String name, int age, double tall, Date birth) {
		super();
		this.name = name;
		this.age = age;
		this.tall = tall;
		this.birth = birth;
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
	public double getTall() {
		return tall;
	}
	public void setTall(double tall) {
		this.tall = tall;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getBirthString() {
		String rValue="1990-01-01 00:00:00";
		java.text.DateFormat formatter=
				new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(birth!=null) {
			rValue= formatter.format(birth);
		}
		return rValue;
	}
	// "yyyy-MM-dd'T'HH:mm"
	public void setBirthString(String time) {
		java.text.DateFormat formatter=
				new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		try {
			birth=formatter.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}









