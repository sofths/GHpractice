package com.human.ex8;

public class Familly {
	String papaName;
	String mamiName;
	String sisterName;
	String brotherName;
	
	public Familly(String papaName, String mamiName) {
		super();
		this.papaName = papaName;
		this.mamiName = mamiName;
	}
	public String getPapaName() {
		return papaName;
	}
	public void setPapaName(String papaName) {
		this.papaName = papaName;
	}
	public String getMamiName() {
		return mamiName;
	}
	public void setMamiName(String mamiName) {
		this.mamiName = mamiName;
	}
	public String getSisterName() {
		return sisterName;
	}
	public void setSisterName(String sisterName) {
		this.sisterName = sisterName;
	}
	public String getBrotherName() {
		return brotherName;
	}
	public void setBrotherName(String brotherName) {
		this.brotherName = brotherName;
	}
	

}
