package com.human.ex10;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Bean
	public Student student2(){
		ArrayList<String> hobbys=new ArrayList<String>();
		hobbys.add("수영2");
		hobbys.add("요리2");
		
		Student student=new Student("홍길2",20,hobbys);
		student.setHeight(1802);
		student.setWeight(802);
		return student;		
	}

}
