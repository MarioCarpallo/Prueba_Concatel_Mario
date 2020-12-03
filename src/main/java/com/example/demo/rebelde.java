package com.example.demo;


public class rebelde {

	String rebelde;
	String planeta;
	String fecha;
	String frase;


	//Constructor 
	public rebelde(String rebelde, String planeta, String fecha, String frase) {
		super();
		this.rebelde = rebelde;
		this.planeta = planeta;
		this.fecha = fecha;
		this.frase = frase;
	}
	
	//Getters
	public String getRebelde() {
		return rebelde;
	}

	public String getPlaneta() {
		return planeta;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public String getFrase() {
		return frase;
	}

	
	//Setters 
	public void setRebelde(String rebelde) {
		this.rebelde = rebelde;
	}
	
	public void setPlaneta(String planeta) {
		this.planeta = planeta;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setFrase(String frase) {
		this.frase = frase;
	}
	
}
