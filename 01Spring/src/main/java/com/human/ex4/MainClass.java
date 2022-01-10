package com.human.ex4;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MyCalculator클래스를 만들어서 나만에 계산기를 사용할수있는
		//클래스를 만들어보자.
		/* 26ppt 어떻게 마무리 되었는지 확인해 보자.
		 * 2차 계산기를 더욱 부품화하여 나눈다. Calculator.java MyCalculator.java
		 *  인터페이스로 만들었다면 YouCaculator도 만들 수 있었을 것이다.
		 *  
		 *  계산기의 주요기능은 변경되지 않고  부가기능들은 주입객체를 변경해서
		 *  출력 형태를 변경 할 수 있다.
		MyCalculator myCalculator=new MyCalculator();
		myCalculator.setCalculator(new Calculator());
		
		myCalculator.setFirstNum(10);
		myCalculator.setSecondNum(2);
		
		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
		myCalculator.div();
		*/
		//다음을 xml로 구현해 보자.
		/*
		 * 스프링이 적용되지 않을때에는 직접 생성을 하였다.
		 * 
		 * xml를 보고   (주무서) 객체를 만들어서 처리하는 코드이다.   appplicationCTX.xml파일을 추가 
		 * Spring Bean Configuration File  new-other에서 찾아서 상의 xml파일추가
		 * 이것이 스프링의 DI 의존객체 삽입방법이다.*/
		String configLocation ="classpath:applicationCTX1.xml";
		AbstractApplicationContext  
		ctx	=new GenericXmlApplicationContext(configLocation);
		
		
		MyCalculator myCalculator= 
				ctx.getBean("myCalculator",MyCalculator.class);
		
		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
		myCalculator.div();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}
