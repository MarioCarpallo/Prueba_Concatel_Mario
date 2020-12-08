package com.example.demo;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RebeldeController {
	
	//Frase la cual tendr� 3 variables, el rebelde, planeta, y fecha.
	private static final String frase = "El/la rebelde %s fue avistado/a en el planeta %s el d�a %s";
		
	//Inicializamos la librer�a log4j (Habiendola importado ya)
	final static Logger logger = Logger.getLogger(RebeldeController.class);
	
	//M�todo que mostrar� un mensaje que explica donde ir para introducir los rebeldes
	@RequestMapping("/")
	public String saludo() {
		return "Para introducir nuevos rebeldes dirijase a /rebels";
	}
	
	//Metodo para poder introducir el rebelde y el planeta con el RequestParam
	@RequestMapping("/rebels")
	public static rebelde rebels(@RequestParam(value="rebelde", defaultValue = "-") String rebelde,
						  @RequestParam(value="planeta", defaultValue = "-") String planeta) {
		
		//Por defecto existir� la frase de tal forma como si hubiera un error.
		rebelde result = new rebelde("-", "-", "-", "Introduce un rebelde y un planeta correctos porfavor");
		
		try {
		
		//Control de errores (Que no entren a la ra�z de la api sin nada o con espacios)
		if(!rebelde.equals("-") && !planeta.equals("-") && !rebelde.equals(" ") && !planeta.equals(" ")) {
			
			// Llamamos a la funci�n para recoger la fecha/hora
			String date = fechahora();
			
			String fraseFichero = String.format(frase, mayus(rebelde), mayus(planeta), date);
			
			// Llamamos a la funci�n para insertarla en el fichero
			fichero(fraseFichero);
			
			// Retornamos a la api el resultado total.
			result = new rebelde(mayus(rebelde), mayus(planeta), date, fraseFichero);
			System.out.print(result.toString());
			return new rebelde(mayus(rebelde), mayus(planeta), date, fraseFichero);
		}
		}catch(Exception e) {
			System.out.println(e);
			logger.error("Error al acceder al apartado /rebels: "+e);
		}
		
		// Si hay cualquier fallo se retornar�a la frase por defecto.
		return result;
		
		}
	
	// M�todo para poner la primera letra del nombre del rebelde/planeta en may�scula
	public static String mayus(String str) {
		String result = str;
		try {
	    if(str == null || str.isEmpty()) {
	        return str;
	    }
	    result = str.substring(0, 1).toUpperCase() + str.substring(1);
		}catch(Exception e) {
			logger.error("Error al intentar poner en may�scula la letra"+e);
		}
	    return result;
	}
	
	//M�todo para escribir en un fichero el nombre de los reveldes con el planeta y fecha.
	public static String fichero(String frase) {
		String ficheroReturn = "-";

		try {
			// Si la frase est� vac�a se retorna un aviso.
			if(frase.equals(null) || frase.equals("")) {
				ficheroReturn = "La frase est� vac�a";
				return ficheroReturn;
			}
			
			String ruta = "output_rebeldes/rebeldes.txt";
			File archivo = new File(ruta);
			BufferedWriter bw;
			bw = new BufferedWriter(new FileWriter(archivo, true));
			
			if(archivo.exists()) {
			    bw.write(frase+"\n");
			    bw.close();
			}
			ficheroReturn = "Frase Agregada";
		}catch(Exception e) {
			ficheroReturn = "Hubo alg�n problema: "+e;
			logger.error("Error al importar la frase en el fichero: "+e);
		}
		return ficheroReturn;
	}
	
	// M�todo para obtener la fecha y hora con formato personalizado.
	public static String fechahora() {
		String fechahora = "";
		try {
			//Recogemos la fecha en milisegundos
			System.currentTimeMillis();
					
			//La formateamos
			SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'a las' HH:mm:ss z");
					
			//Creamos nueva fecha con los milisegundos obtenidos
			Date d = new Date(System.currentTimeMillis());
					
			//Le damos formato a la fecha
			String date = formatter.format(d);
			fechahora = date;
		}catch(Exception e) {
			logger.error("Error al intentar obtener la fecha y hora: "+e);
		}
		return fechahora;
	}
	
	

}
