package com.human.ex;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.human.dto.AHumanDto;
import com.human.service.AHumanService;

@RestController
@RequestMapping("/human")
public class HumanController {
	@Inject 
	private AHumanService as;
	
	@RequestMapping(value="/all/{name}",method=RequestMethod.GET)
	public ResponseEntity<List<AHumanDto>> list(@PathVariable("name") String name){
		ResponseEntity<List<AHumanDto>> entity=null;
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}
		
		return entity;
		
	}
	@RequestMapping(value="",method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody AHumanDto vo){
		ResponseEntity<String> entity = null;
		try {
		as.addReply(vo);
		entity = new ResponseEntity<String>("SUCCESS" , HttpStatus.OK);
	} catch (Exception e) {
		e.printStackTrace();
		entity = new ResponseEntity<String>(e.getMessage() , HttpStatus.BAD_REQUEST);
	}
	return entity;
}
}
