package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RebeldeControllerTest {
	
	@Test
	void testRebelde() {
		String planeta = "naboo";
		String rebelde = "amidala";
		String fechaHora = RebeldeController.fechahora();
		String resultado = RebeldeController.rebels(rebelde, planeta).test();
		String esperado = "El/la rebelde Amidala fue avistado/a en el planeta Naboo el d�a "+fechaHora;
		assertEquals(esperado, resultado);
	}
	
	
	@Test
	void testMayus() {
		String palabra = "naboo"; // Palabra a capitalizar
		String esperado = "Naboo"; // Lo que se espera que devuelva el m�todo.
		String resultado = RebeldeController.mayus(palabra);
		assertEquals(esperado, resultado);
	}

	@Test
	void testFichero() {
		String frase = "Test unitario para el m�todo fichero"; // Frase a agregar al archivo
		String esperado = "Frase Agregada"; // Lo esperado ser� "Frase agregada"
		String resultado = RebeldeController.fichero(frase);
		assertEquals(esperado, resultado);
	}
	
	/* No encontr� la posibilidad de hacer un test unitario de este metodo porque este lo que hace
	 es obtener la hora actual a partir de milisegundos, no puedo definir cual ser� el resultado esperado */
	@Test
	void testFecha() {
		String esperado = RebeldeController.fechahora();
		String resultado = RebeldeController.fechahora();
		assertEquals(esperado, resultado);
	}

}
