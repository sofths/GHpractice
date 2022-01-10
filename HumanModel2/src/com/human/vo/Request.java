package com.human.vo;

import java.util.HashMap;

public class Request {
	private HashMap<String,Object> hm = new HashMap<String,Object>();
	//Parameter 		문자열
	//key value 형태로 value에 문자열을 넣는 메소드
	public void setParameter(String key,String value) {
		hm.put(key,value);
	}
	public String getParameter(String key) {
		return (String)hm.get(key);
	}
	//ParameterValues 문자열 배열처리
	public void setParameterValues (String key,String[] value) {
		hm.put(key,value);
	}
	public String[] getParameterValues(String key){
		return (String[])hm.get(key);
		}
	//Attribute 		객체처리 
	public void setAttribute(String key,Object value) {
		hm.put(key,value);
	}
	public Object getAttribute(String key) {
		return hm.get(key);
	}
}
