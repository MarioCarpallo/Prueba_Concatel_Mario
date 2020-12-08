package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RebeldeControllerTest {
	
	@Test
	void testRebelde() {
		String planeta = "naboo";
		String rebelde = "amidala";
		rebelde resultado = RebeldeController.rebels(planeta, rebelde);
		String[] esperado = {"Amidala", "Naboo", "-", "Introduce un rebelde y un planeta correctos porfavor"};
	}
	
	
	@Test
	void testMayus() {
		String palabra = "naboo"; // Palabra a capitalizar
		String esperado = "Naboo"; // Lo que se espera que devuelva el método.
		String resultado = RebeldeController.mayus(palabra);
		assertEquals(esperado, resultado);
	}

	@Test
	void testFichero() {
		String frase = "Testing para la frase"; // Frase a agregar al archivo
		String esperado = "Frase Agregada"; // Lo esperado será Frase agregada
		String resultado = RebeldeController.fichero(frase);
		assertEquals(esperado, resultado);
	}

}
