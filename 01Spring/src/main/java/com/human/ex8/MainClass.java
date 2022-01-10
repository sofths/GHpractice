package com.human.ex8;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args){
		/*
		 * 1.MainClass 작성
		 * 2.Student 클래스 학생정보
		 * 3.Family 클래스
		 *   StudentInfo 클래스  상위 2개 클래스에서 Student클래스를 사용
		 * 4.xml 파일 2개를 만들어서 클래스생성 부분을 분리
		 * 5.MainClass작성
		 */
		String configLocation1="classpath:applicationCTX5.xml";
		String configLocation2="classpath:applicationCTX6.xml";
		AbstractApplicationContext ctx=
				new GenericXmlApplicationContext(configLocation1,configLocation2);
		
		Student student1=ctx.getBean("student1",Student.class);
		System.out.println(student1.getName());
		System.out.println(student1.getHobbys());
		
		StudentInfo studentInfo
			=ctx.getBean("studentInfo1",StudentInfo.class);
		studentInfo.studentInfoFunction();
		
		//family
		Familly family = ctx.getBean("familly", Familly.class);
		System.out.println(family.getPapaName());
		System.out.println(family.getMamiName());
		System.out.println(family.getSisterName());
		System.out.println(family.getBrotherName());
		
		ctx.close();
		
	
	}

}




