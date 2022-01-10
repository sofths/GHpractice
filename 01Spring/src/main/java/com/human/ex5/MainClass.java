package com.human.ex5;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//
		/*
		 * 다양한 스프링 프로퍼티 설정법을 확인해보자.
		 * MyInfo 나의 정보를 출력하는 클래스
		 * BMICalculator 본인의 몸무게를 확인하는 클래스
		 * 
		 * MyInfo클래스안에 BMICalculator클래스가가 들어 있음
		 * 
		 * 0.MainClass.java
		 * 1.MBICalculator.java
		 * 2.MyInfo.java 
		 * 3.applicationCTX.xml 
		 */
		
		String configLocation="classpath:applicationCTX2.xml";
		AbstractApplicationContext ctx=
				new GenericXmlApplicationContext(configLocation);
		MyInfo myInfo=ctx.getBean("myInfo",MyInfo.class);
		myInfo.getInfo();
		ctx.close();
		
		
	}

}
