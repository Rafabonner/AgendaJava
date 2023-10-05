package com.despensa.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import com.despensa.model.Usuario;

public class UsuarioDAO   {
	
	private List<Usuario> usuarios;
	private Usuario usuario;
	private int lastId;
	private int success;
	private Connection connection = null;
	
	String sqlListAll = "select * from USUARIO";
	
	String sqlInsertUsuario = "insert into USUARIO "
			+ "(NOME,EMAIL,SENHA) values "
			+ "(?,?,?)";
	
	String sqlUpdateUsuario = "update USUARIO set "
			+ "USUARIO.NOME = ?,"
			+ "USUARIO.EMAIL = ? "
			+ "where USUARIO.ID_USUARIO = ?";
	
	String sqlDeleteUsuario = "delete from USUARIO where USUARIO.ID_USUARIO =?";
	
	String sqlListUsuarioById = "select * from USUARIO where USUARIO.ID_USUARIO =?";
	
	String sqlListUserByEmail = "select * from USUARIO where USUARIO.EMAIL=?";
	
	//public UsuarioDAO(Connection connection) {
	//	super(connection);
	//}

	
	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}
	
	
	
	
	public List<Usuario> getUsuario() {
		
		usuarios = new ArrayList<Usuario>();
		
		try {
			//connection = ConnectionFactory.getConnectionSqlServer();
			PreparedStatement stmt = connection.prepareStatement(sqlListAll);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("ID_USUARIO"));
				usuario.setNome(rs.getString("NOME"));
				usuarios.add(usuario);	
			}
		} catch (Exception e) {
			//e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return usuarios;	
	}
	
	public int insertUsuario(Usuario usuario) {
		try {
			//connection = ConnectionFactory.getConnectionSqlServer();
			PreparedStatement stmt = connection.prepareStatement(sqlInsertUsuario, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
		
			if(rs.next()) {
				lastId = rs.getInt(1);
			}	
			
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		return lastId;
	}
	
	public int updateAluno(Usuario usuario) {
	   try {
		  // connection = ConnectionFactory.getConnectionSqlServer();
		   PreparedStatement stmt = connection.prepareStatement(sqlUpdateUsuario);
		   stmt.setString(1, usuario.getNome());
		   stmt.setString(2, usuario.getEmail());
	       stmt.setLong(3, usuario.getId());
	       success = stmt.executeUpdate();	   
	   } catch(Exception e) {
		   throw new RuntimeException(e);
	   }
	    return success;
	   }
	
//	public int deleteAluno(long id) {
//		   
//		try {
//			  // connection = ConnectionFactory.getConnectionSqlServer();
//			   PreparedStatement stmt = connection.prepareStatement(sqlDeleteAluno);
//			   stmt.setLong(1, id);
//		       success = stmt.executeUpdate();   
//		     } catch(Exception e) {
//			   throw new RuntimeException(e);
//		   }
//		  return success;
//       }
	
	public Usuario getUsuarioById(long id) {
		try {
			//connection = ConnectionFactory.getConnectionSqlServer();
			PreparedStatement stmt = connection.prepareStatement(sqlListUsuarioById);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id_usuario"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				this.usuario = usuario;	
			}
		} catch (Exception e) {
			//e.printStackTrace();
			throw new RuntimeException(e);
		}
		return this.usuario;
			
	   }
	

	public Usuario login(Usuario usuario) {
		
		try {
			
			
			Usuario usuarioBanco = this.findUserByEmail(usuario.getEmail());
		
			if(usuarioBanco != null) {
				// Verificação da senha
				System.out.println(	usuarioBanco.getSenha());
				if(usuarioBanco.validarSenhaCriptografada(usuario.getSenha(), usuarioBanco.getSenha())) {
				   this.usuario = usuarioBanco;	
				}else {
					this.usuario = null;
				}
				
				
			}else {
				this.usuario = null;
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	
		return this.usuario;
	}

	protected Usuario findUserByEmail(String email) {
		try {
		//	System.out.println(email);
			PreparedStatement stmt = connection.prepareStatement(sqlListUserByEmail);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			int numUser = 0;
			while(rs.next()) {
				Usuario us = new Usuario();
				us.setId(rs.getInt("ID_USUARIO"));
				us.setNome(rs.getString("NOME"));
				us.setEmail(rs.getString("EMAIL"));
				us.setSenha(rs.getString("SENHA"));
				numUser++;
				this.usuario = us;
			}
			
			if(numUser  == 0) {
				this.usuario = null;
			}
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return this.usuario;
	}
	
	
		
	}





