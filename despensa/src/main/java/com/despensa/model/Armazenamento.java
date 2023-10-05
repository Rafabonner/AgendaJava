package com.despensa.model;

public class Armazenamento {
	
	private int id;
	private String descri_local;
	
	public Armazenamento () {
		
	}
	
	public Armazenamento(int id, String descri_local) {
		super();
		this.id = id;
		this.descri_local = descri_local;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescri_local() {
		return descri_local;
	}
	public void setDescri_local(String descri_local) {
		this.descri_local = descri_local;
	}

	
	
}
