package com.human.ex2;

public class MainClass {

	public static void main(String[] args) {
		//1. spring에서 java 코드를 작성해보자.
		// Calculation.java 파일을 만든 다음에 다음을 추가하자. 
		Calculation cal=new Calculation();
		cal.setFirstNum(10);
		cal.setSecondNum(20);
		
		cal.addition();
		cal.subraction();
		cal.multiplication();
		cal.division();
		
	}

}
