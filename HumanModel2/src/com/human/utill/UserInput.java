package com.human.utill;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UserInput {
	private static Scanner sc=new Scanner(System.in);
	
	public static int inputInt(String st) {
		System.out.println(st);
		return Integer.parseInt(sc.nextLine());
	}
	
	public static double inputDouble(String st) {
		return Double.parseDouble(sc.nextLine());
	}
	
	public static String inputString(String st) {
		System.out.println(st);
		return sc.nextLine();
	}
	
	public static Date inputDate(String st) {
	Date rValue= null; //문자열을 Date 객체로 만드는 기준설정 class
	SimpleDateFormat transFormat = new SimpleDateFormat("yyyy/MM/dd");
	System.out.println(st+"날짜 입력 (yyyy/MM/dd)");
	try {
		rValue =transFormat.parse(sc.nextLine());
	} catch (ParseException e) {
		e.printStackTrace();
	}
	return rValue;
	}
	
	public static Date stringToDate(String st) {
		Date rValue=null;//문자열을 Date 객체로 만드는 기준설정 class
		SimpleDateFormat transFormat = new SimpleDateFormat ("yyyy/MM/dd");
		try {
			rValue = transFormat.parse(st);
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
