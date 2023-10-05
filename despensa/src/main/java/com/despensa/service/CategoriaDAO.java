package com.despensa.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import com.despensa.model.Categoria;

public class CategoriaDAO extends DAO  {
	
	private List<Categoria> categorias;
	private Categoria categoria;
	private int lastId;
	private int success;
	private Connection connection = null;
	
	String sqlListAll = "select * from CATEGORIA";
	
	String sqlInsertCategoria = "insert into CATEGORIA "
			+ "(descri_categ) values "
			+ "(?)";
	
	String sqlUpdateCategoria = "update CATEGORIA set "
			+ "CATEGORIA.descri_categ = ?,"
			+ "where CATEGORIA.id = ?";
	
	String sqlDeletCategoria = "delete from CATEGORIA where CATEGORIA.ID_CATEGORIA =?";
	
	String sqlListCategoriaById = "select * from CATEGORIA where CATEGORIA.ID_CATEGORIA =?";
	
	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}
	
	
	public List<Categoria> getCategoria() {
		
		categorias = new ArrayList<Categoria>();
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sqlListAll);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Categoria categoria = new Categoria ();
				categoria.setId(rs.getInt("ID_CATEGORIA"));
				categoria.setDescri_categ(rs.getString("DESCRI_CATEG"));
				//produto.setValidade(rs.getDate("validade"));//
				categorias.add(categoria);	
			}
		} catch (Exception e) {
			//e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return categorias;	
	}
	
	public int insertCategoria(Categoria categoria) {
		try {
			//connection = ConnectionFactory.getConnectionSqlServer();
			PreparedStatement stmt = connection.prepareStatement(sqlInsertCategoria, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, categoria.getDescri_categ());
			//stmt.setDate(2, produto.getValidade());
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
	
	public int updateCategoria(Categoria categoria) {
	   try {
		  // connection = ConnectionFactory.getConnectionSqlServer();
		   PreparedStatement stmt = connection.prepareStatement(sqlUpdateCategoria);
		   stmt.setString(1, categoria.getDescri_categ());
		   //stmt.setDate(2, produto.getValidade());
		   stmt.setLong(2, categoria.getId());
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
	
	public Categoria getProdutoById(long id) {
		try {
			//connection = ConnectionFactory.getConnectionSqlServer();
			PreparedStatement stmt = connection.prepareStatement(sqlListCategoriaById);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Categoria categoria = new Categoria ();
				categoria.setId(rs.getInt("id"));
				categoria.setDescri_categ(rs.getString("descri_categ"));
				this.categoria = categoria;	
			}
		} catch (Exception e) {
			//e.printStackTrace();
			throw new RuntimeException(e);
		}
		return this.categoria;
			
	   }
	
	}

