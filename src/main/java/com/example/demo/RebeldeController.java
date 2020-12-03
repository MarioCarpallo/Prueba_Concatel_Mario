package com.example.demo;


import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RebeldeController {
	
	//Frase la cual tendrá 3 variables, el rebelde, planeta, y fecha.
	private static final String frase = "El rebelde %s fue avistado en el planeta %s en la fecha %s";
	
	
	//Mensaje donde explica donde ir para introducir los rebeldes
	@RequestMapping("/")
	public String saludo() {
		return "Para introducir nuevos rebeldes dirijase a /rebels";
	}
	
	//Metodo para poder introducir el rebelde y el planeta con el RequestParam
	@RequestMapping("/rebels")
	public rebelde rebels(@RequestParam(value="rebelde", defaultValue = "-") String rebelde,
						  @RequestParam(value="planeta", defaultValue = "-") String planeta) {
		
		//Recojemos la fecha en milisegundos
		System.currentTimeMillis();
		
		//La formateamos
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'a las' HH:mm:ss z");
		
		//Creamos nueva fecha con los milisegundos obtenidos
		Date d = new Date(System.currentTimeMillis());
		
		//Le damos formato a la fecha
		String date = formatter.format(d);
       
				return new rebelde(rebelde, planeta, date, String.format(frase, rebelde, planeta, date));
		}

}
