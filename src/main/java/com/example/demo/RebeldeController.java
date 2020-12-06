package com.example.demo;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RebeldeController {
	
	//Frase la cual tendrá 3 variables, el rebelde, planeta, y fecha.
	private static final String frase = "El rebelde %s fue avistado en el planeta %s el día %s";
		
	//Mensaje donde explica donde ir para introducir los rebeldes
	@RequestMapping("/")
	public String saludo() {
		return "Para introducir nuevos rebeldes dirijase a /rebels";

	}
	
	//Metodo para poder introducir el rebelde y el planeta con el RequestParam
	@RequestMapping("/rebels")
	public rebelde rebels(@RequestParam(value="rebelde", defaultValue = "-") String rebelde,
						  @RequestParam(value="planeta", defaultValue = "-") String planeta) {
		
		rebelde result = new rebelde("-", "-", "-", "Introduce un rebelde y un planeta correctos porfavor");
		
		try {
		//Recojemos la fecha en milisegundos
		System.currentTimeMillis();
		
		//La formateamos
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'a las' HH:mm:ss z");
		
		//Creamos nueva fecha con los milisegundos obtenidos
		Date d = new Date(System.currentTimeMillis());
		
		//Le damos formato a la fecha
		String date = formatter.format(d);
        
		//Control de errores (Que no entren a la raíz de la api sin nada)
		if(!rebelde.equals("-") && !planeta.equals("-")) {
			String fraseFichero = String.format(frase, capitalize(rebelde), capitalize(planeta), date);
			
			fichero(fraseFichero);
			
			return new rebelde(capitalize(rebelde), capitalize(planeta), date, fraseFichero);
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		return result;
		
		}
	
	//Metodo para poner la primera letra del nombre del rebelde/planeta en mayúscula
	public static String capitalize(String str) {
	    if(str == null || str.isEmpty()) {
	        return str;
	    }

	    return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
	
	public static String fichero(String frase) {
		String ficheroReturn = "Escrito con éxito";
		
		try {
			String ruta = "output_rebeldes/rebeldes.txt";
			File archivo = new File(ruta);
			BufferedWriter bw;
			bw = new BufferedWriter(new FileWriter(archivo, true));
			if(archivo.exists()) {
			    bw.write(frase+"\n");
			    bw.close();
			}
		}catch(Exception e) {
			ficheroReturn = "Hubo algún problema: "+e;
			System.out.print("Hubo algún problema: "+e);
		}
		return ficheroReturn;
	}
	
	

}
