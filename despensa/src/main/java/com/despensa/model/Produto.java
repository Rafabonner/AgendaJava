package com.despensa.model;

import java.sql.Date;
import java.util.Calendar;

public class Produto {
	private int id;
	private String nome_prod;
	private Calendar validade; 
	private String ean;
	private String quant;
	private Categoria categoria;
	private Armazenamento armazenamento;
	private Usuario usuario;
	public Produto () {
		
	}
	
	public Produto (int id,String nome_prod, Calendar validade, String ean, String quant) {
		this.id = id;
		this.nome_prod = nome_prod;
		this.validade = validade;
		this.ean = ean;
		this.quant = quant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome_prod() {
		return nome_prod;
	}

	public void setNome_prod(String nome_prod) {
		this.nome_prod = nome_prod;
	}

	public Calendar getValidade() {
		return validade;
	}

	public void setValidade(Calendar validade) {
		this.validade = validade;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getQuant() {
		return quant;
	}

	public void setQuant(String quant) {
		this.quant = quant;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Armazenamento getArmazenamento() {
		return armazenamento;
	}

	public void setArmazenamento(Armazenamento armazenamento) {
		this.armazenamento = armazenamento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	
	
	
	
	

}
