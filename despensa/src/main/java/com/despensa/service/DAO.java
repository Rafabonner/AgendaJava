package com.despensa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.despensa.model.Usuario;

public abstract class DAO {
	protected int lastId;
	protected int success;
	protected Connection connection = null;
	private Usuario usuario;
	
//	String sqlListUserByEmail = "select * from USUARIO where USUARIO.EMAIL=?";
	
	
	public DAO(Connection connection) {
	  this.connection = connection;
		
	}
	


	
	public DAO() {
	
		
	}

} 
   
