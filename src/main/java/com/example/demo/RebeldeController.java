package com.example.demo;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RebeldeController {
	
	private static final String template = "Hello, %s";
	
	
	
	//Mensaje donde explica donde ir para introducir los rebeldes
	@RequestMapping("/")
	public String saludo() {
		return "Para introducir nuevos rebeldes dirijase a /rebels";
	}
	
	
	@RequestMapping("/rebels")
	public rebelde rebels() {

		System.currentTimeMillis();
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'a las' HH:mm:ss z");
		Date d = new Date(System.currentTimeMillis());
		String date = formatter.format(d);
		return new rebelde("t", "t", date);
	}

}
