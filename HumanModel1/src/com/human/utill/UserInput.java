package com.human.utill;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UserInput {

public static int userInput(String st) {
	System.out.println(st);
	return Integer.parseInt(st);
}
public static double inputDouble(String st) {
	System.out.println(st);
	return Double.parseDouble(st);
}
public static String inputString(String st) {
	System.out.println(st);
	return st;
	
}
public static Date inputDate(String st) {
	Date rValue = null; // 문자열을 Date 객체로 만드는 기준설정 클래스
	SimpleDateFormat transFormat
	= new SimpleDateFormat ("yyyyMMdd");
	System.out.println(st+"날짜 입력 (yyyy/MM/dd)>>");
	try {
	 rValue=transFormat.parse(st);
	} catch (ParseException e) {
		e.printStackTrace();
	}
	return rValue;
}
public static Date stringToDate(String st) {
	Date rValue = null; // 문자열을 Date 객체로 만드는 기준설정 클래스
	SimpleDateFormat transFormat
	= new SimpleDateFormat ("yyyy/MM/dd");
	try {
	 rValue=transFormat.parse(st);
	} catch (ParseException e) {
		e.printStackTrace();
	}
	return rValue; 
}
public static String dateToString(Date date) {
	SimpleDateFormat transFormat = new SimpleDateFormat("yyyy/MM/dd");
	return transFormat.format(date);
}

}
