package com.human.ex3;
//자원은 없고 순수 계산기 기능만 있는 계산기 제작 
public class Calculator {
	public void addition(int firstNum,int secondNum){
		System.out.println("addition()");
		int result=firstNum+secondNum;
		System.out.println(firstNum+"+"+secondNum+"="+result);
	}
	public void subraction(int firstNum,int secondNum){
		System.out.println("subraction()");
		int result=firstNum-secondNum;
		System.out.println(firstNum+"-"+secondNum+"="+result);
	}
	public void multiplication(int firstNum,int secondNum){
		System.out.println("multiplication()");
		int result=firstNum*secondNum;
		System.out.println(firstNum+"*"+secondNum+"="+result);
	}
	public void division(int firstNum,int secondNum){
		System.out.println("division()");
		int result=firstNum/secondNum;
		System.out.println(firstNum+"/"+secondNum+"="+result);
	}
}
