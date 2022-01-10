package com.human.ex7;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. MainClass 제작
		//2. pecil.java인터페이스 제작
		//3. 인터페이스를 상속받아 4b,6b 등 자식클레스를 제작
		//4. xml 제작
		//5. MainClass 코드 제작
		
		
		String configLocation="classpath:applicationCTX4.xml";
		AbstractApplicationContext ctx=
				new GenericXmlApplicationContext(configLocation);
		Pencil pecil=ctx.getBean("pencil",Pencil.class);
		pecil.use();
		ctx.close();
		
		
		

	}

}
