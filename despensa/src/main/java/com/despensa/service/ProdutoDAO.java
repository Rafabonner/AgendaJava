package com.despensa.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import com.despensa.model.Produto;

public class ProdutoDAO   {
	
	private List<Produto> produtos;
	private Produto produto;
	private int lastId;
	private int success;
	private Connection connection = null;
	
	String sqlListAll = "select * from PRODUTOS";
	
	String sqlInsertProdutos = "insert into PRODUTOS "
			+ "(NOME_PROD,VALIDADE,EAN, QUANT, ID_CATEGORIA, ID_LOCAL, ID_USUARIO) values "
			+ "(?,?,?,?,?,?,?)";
	
	String sqlUpdateProdutos = "update PRODUTOS set "
			+ "PRODUTOS.NOME_PROD = ?,"
			+ "PRODUTOS.VALIDADE = ?, "
			+ "PRODUTOS.EAN = ?, "
			+ "PRODUTOS.QUANT = ? "
			+ "where PRODUTOS.COD_PROD = ?";
	
	String sqlDeleteProduto = "delete from PRODUTOS where PRODUTOS.COD_PROD =?";
	
	String sqlListProdutoById = "select * from PRODUTOS where PRODUTOS.COD_PROD =?";
	
	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}
	
	
	public List<Produto> getProduto() {
		
		produtos = new ArrayList<Produto>();
		
		try {
			//connection = ConnectionFactory.getConnectionSqlServer();
			PreparedStatement stmt = connection.prepareStatement(sqlListAll);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Produto produto = new Produto ();
				produto.setId(rs.getInt("COD_PROD"));
				produto.setNome_prod(rs.getString("NOME_PROD"));
				//produto.setValidade(rs.getDate("validade"));//
				Calendar validade = Calendar.getInstance();
				validade.setTime(rs.getDate("VALIDADE"));
				produto.setValidade(validade);
				produto.setQuant(rs.getString("QUANT"));
				produtos.add(produto);	
			}
		} catch (Exception e) {
			//e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return produtos;	
	}
	
	public int insertProduto(Produto produto) {
		try {
			//connection = ConnectionFactory.getConnectionSqlServer();
			PreparedStatement stmt = connection.prepareStatement(sqlInsertProdutos, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, produto.getNome_prod());
			//stmt.setDate(2, produto.getValidade());
			stmt.setDate(2, new Date(produto.getValidade().getTimeInMillis()));
			stmt.setString(3, produto.getEan());
			stmt.setString(4, produto.getQuant());
			stmt.setInt(5, produto.getCategoria().getId());
			stmt.setInt(6, produto.getArmazenamento().getId());
			stmt.setInt(7, produto.getUsuario().getId());
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
	
	public int updateProduto(Produto produto) {
	   try {
		  // connection = ConnectionFactory.getConnectionSqlServer();
		   PreparedStatement stmt = connection.prepareStatement(sqlUpdateProdutos);
		   stmt.setString(1, produto.getNome_prod());
		   stmt.setDate(2, new Date(produto.getValidade().getTimeInMillis()));
		   stmt.setString(3, produto.getEan());
		   stmt.setString(4, produto.getQuant());
	       stmt.setInt(5, produto.getId());
	       success = stmt.executeUpdate();	   
	   } catch(Exception e) {
		   throw new RuntimeException(e);
	   }
	    return success;
	   }
	
	public int deleteProduto(int id) {
	   
		try {			  
			   PreparedStatement stmt = connection.prepareStatement(sqlDeleteProduto);
			   stmt.setInt(1, id);
		       success = stmt.executeUpdate();   
		     } catch(Exception e) {
			   throw new RuntimeException(e);
		   }
		  return success;
       }
	
	public Produto getProdutoById(int id) {
		try {
			//connection = ConnectionFactory.getConnectionSqlServer();
			PreparedStatement stmt = connection.prepareStatement(sqlListProdutoById);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt("COD_PROD"));
				produto.setNome_prod(rs.getString("NOME_PROD"));
				produto.setQuant(rs.getString("QUANT"));
				//produto.setValidade(rs.getDate("validade"));
				Calendar validade = Calendar.getInstance();
				validade.setTime(rs.getDate("VALIDADE"));
				produto.setValidade(validade);
				produto.setEan(rs.getString("EAN"));
				this.produto = produto;	
			}
		} catch (Exception e) {
			//e.printStackTrace();
			throw new RuntimeException(e);
		}
		return this.produto;
			
	   }
	
	}
