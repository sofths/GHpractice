package com.human.ex5;

//비만인지 아닌지 정상인지 판별해주는 클래스
//비만 미달 정상 ... 등의 수치를 사용가 설정할수 있는 
public class BMICalculator {
	private double lowWeight;	//저체중
	private double normal;		//정상
	private double overWeight;	//과체중
	private double obsity;		//비만
	public void bmicalculation(double weight,double height){
		//bim지수를 구해서 사용자가 설정한 등급에 맞게 출력하는 함수
		double h=height*0.1;
		double result=(weight/(h*h))*100;

		System.out.println("BMI 지수:"+(int)result);
		if(result>obsity){
			System.out.println("비만");
		}else if(result>overWeight){
			System.out.println("과체중");			
		}else if(result>normal){
			System.out.println("정상");
		}else if(result>lowWeight){
			System.out.println("저체중");
		}
	}
	
	public double getLowWeight() {
		return lowWeight;
	}
	public void setLowWeight(double lowWeight) {
		this.lowWeight = lowWeight;
	}
	public double getNormal() {
		return normal;
	}
	public void setNormal(double normal) {
		this.normal = normal;
	}
	public double getOverWeight() {
		return overWeight;
	}
	public void setOverWeight(double overWeight) {
		this.overWeight = overWeight;
	}
	public double getObsity() {
		return obsity;
	}
	public void setObsity(double obsity) {
		this.obsity = obsity;
	}

}
