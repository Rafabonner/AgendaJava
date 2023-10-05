package com.despensa.model;

import java.sql.Timestamp;
import java.util.Calendar;

import com.despensa.utils.BCrypt;




public class Usuario {
	
	private int id;
	private String nome;
	private String email;
	private String senha;
	
	public Usuario () {
		
	}
	
	public Usuario(String nome,String email, String senha) {
		this.nome = nome;
		this.email = email;
	//	this.email = this.isValidEmailAddress(email) ? email : null;
		this.senha = senha;
	}
	public String cifrarSenha(String senha) {
		// Gera um salt aleatório
		String saltGerado = BCrypt.gensalt();
		// Gerando a senha hasheada utilizando o saltGerado
		String senhaHasheada = BCrypt.hashpw(senha, saltGerado);
		return senhaHasheada;
	}
	
	public boolean validarSenhaCriptografada(String senhaCifrada, String senha) {
		return BCrypt.checkpw(senhaCifrada, senha);
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
		
}

