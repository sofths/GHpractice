package com.human.ex6;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.Student.java  학생클래스
		//2.StudentInfo.java 학생정보 출력 클래스
		//3.applicatonCTX3.xml 
		//4.main에서 코드작업
		
		String configLocation="classpath:applicationCTX3.xml";
		AbstractApplicationContext ctx=
				new GenericXmlApplicationContext(configLocation);
		
		StudentInfo studentInfo=
				ctx.getBean("studentInfo",StudentInfo.class);
		studentInfo.getStudentInfoFunction();
		
		Student st1=ctx.getBean("student1",Student.class);
		Student st2=ctx.getBean("student2",Student.class);
		Student st3=ctx.getBean("student1",Student.class);
		
		if(st1==st3) {
			System.out.println("같음");
		}
		if(st1==st2) {
			System.out.println("같음");
		}else {
			System.out.println("다름");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
