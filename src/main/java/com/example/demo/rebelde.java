package com.example.demo;

import java.sql.Date;

public class rebelde {

	String rebelde;
	String planeta;
	String fecha;
	
	//Constructor 
	public rebelde(String rebelde, String planeta, String fecha) {
		super();
		this.rebelde = rebelde;
		this.planeta = planeta;
		this.fecha = fecha;
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
	
	
}
