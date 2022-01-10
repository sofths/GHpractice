package com.human.ex;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.sql.*;
import com.human.dao.HumanDao;
import com.human.utill.UserInput;
import com.human.dto.*;

public class HumanMain {
public static void main(String[] args) {
	HumanDao dao=new HumanDao();
	boolean isFlag=true;
	while (isFlag) {
		System.out.println("메뉴선택 1.insert 2.update 3.delete"+"4.select 5.종료 ");
		Scanner sc = new Scanner(System.in);
		String user=sc.nextLine();
		switch (UserInput.userInput(user)) {
		case 1:
			//insert
			System.out.println("human 데이터 입력하세요 ");
			System.out.println("이름을 입력하세요>");
			String name=sc.nextLine();
			String name1 = UserInput.inputString(name);
			System.out.println("나이를 입력하세요>");
			String age=sc.nextLine();
			int age1=UserInput.userInput(age);
			System.out.println("키를 입력하세용>");
			String height=sc.nextLine();
			double height1 = UserInput.inputDouble(height);
			System.out.println("생일을 입력하세요>");
			String birthday=sc.nextLine();
			Date birthday1=UserInput.inputDate(birthday);
			HumanDto dto = new HumanDto(name1,age1,height1,birthday1);
			
			int result=dao.insert(dto);
			System.out.println(result+"의 데이터가 변경되었습니다.");
			break;
		case 2:
			//update
			System.out.println("찾을 이름을 입력하세요>");
			String name2 =sc.nextLine();
			 name2=UserInput.inputString(name2);
			System.out.println("변경할 이름을 입력하세요>");
			String name3 = sc.nextLine();
			name3=UserInput.inputString(name3);
			
			dao.update(name2,name3);
			
			System.out.println(name2+"의 이름이"+name3+"로 변경.");
			break;
		case 3:
			//delete작업
			System.out.println("찾을 이름을 입력하세요>");
			String name4=sc.nextLine();
			name4=UserInput.inputString(name4);
			dao.delete(name4);
			System.out.println(name4+"님을 삭제하였씁니다.");
		case 4:
			//select 작업
			System.out.println("휴먼 테이블의 검색을 요청하였습니다.");
			ArrayList<HumanDto> dtos=dao.select();
			
			System.out.println("검색결과는 다음과 같습니다.");
			for(HumanDto hDto:dtos) {
				System.out.println(hDto);
			}
			break;
		case 5:
				System.out.println("종료");
			isFlag=false;
		}
	}
}
}
