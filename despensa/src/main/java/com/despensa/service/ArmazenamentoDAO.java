package com.despensa.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import com.despensa.model.Armazenamento;
import com.despensa.model.Categoria;

public class ArmazenamentoDAO extends DAO {
	
	private List<Armazenamento> armazenado;
	private Armazenamento armazenamento;
	private int lastId;
	private int success;
	private Connection connection = null;
	
	String sqlListAll = "select * from LOCAL_ARMAZ";
	
	String sqlInsertArmazenamento = "insert into LOCAL_ARMAZ "
			+ "(DESCRI_LOCAL) values "
			+ "(?)";
	
	String sqlUpdateArmazenamento = "update LOCAL_ARMAZ set "
			+ "LOCAL_ARMAZ.DESCRI_LOCAL = ? "
			+ "where LOCAL_ARMAZ.ID_LOCAL = ?";
	
	String sqlDeletArmazenamento = "delete from LOCAL_ARMAZ where LOCAL_ARMAZ.ID_LOCAL =?";
	
	String sqlListArmazenamentoById = "select * from LOCAL_ARMAZ where LOCAL_ARMAZ.ID_LOCAL =?";
	
	public ArmazenamentoDAO(Connection connection) {
		this.connection = connection;
	}
	
	
	public List<Armazenamento> getArmazenamento() {
		
		armazenado = new ArrayList<Armazenamento>();
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sqlListAll);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Armazenamento armazenamento = new Armazenamento();
				armazenamento.setId(rs.getInt("ID_LOCAL"));
				armazenamento.setDescri_local(rs.getString("DESCRI_LOCAL"));
				//produto.setValidade(rs.getDate("validade"));//
				armazenado.add(armazenamento);	
			}
		} catch (Exception e) {
			//e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return armazenado;	
	}
	
	public int insertCategoria(Armazenamento armazenamento) {
		try {
			//connection = ConnectionFactory.getConnectionSqlServer();
			PreparedStatement stmt = connection.prepareStatement(sqlInsertArmazenamento, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, armazenamento.getDescri_local());
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
	
	public int updateArmazenamento(Armazenamento armazenamento) {
	   try {
		  // connection = ConnectionFactory.getConnectionSqlServer();
		   PreparedStatement stmt = connection.prepareStatement(sqlUpdateArmazenamento);
		   stmt.setString(1, armazenamento.getDescri_local());
		   //stmt.setDate(2, produto.getValidade());
		   stmt.setLong(2, armazenamento.getId());
	       success = stmt.executeUpdate();	   
	   } catch(Exception e) {
		   throw new RuntimeException(e);
	   }
	    return success;
	   }
	
	
	public Armazenamento getArmazenamentoById(long id) {
		try {
			PreparedStatement stmt = connection.prepareStatement(sqlListArmazenamentoById);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Armazenamento armazenamento = new Armazenamento ();
				armazenamento.setId(rs.getInt("id"));
				armazenamento.setDescri_local(rs.getString("Descri_local"));
				this.armazenamento = armazenamento;	
			}
		} catch (Exception e) {
			//e.printStackTrace();
			throw new RuntimeException(e);
		}
		return this.armazenamento;
			
	   }

}
