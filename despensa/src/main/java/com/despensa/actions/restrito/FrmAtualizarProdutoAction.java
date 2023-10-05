package com.despensa.actions.restrito;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.despensa.actions.Action;
import com.despensa.model.Produto;
import com.despensa.service.ProdutoDAO;


public class FrmAtualizarProdutoAction implements Action{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
	 
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		Connection connection = (Connection) request.getAttribute("connection");
		ProdutoDAO produtoDao = new ProdutoDAO(connection);
		
		Produto produto = produtoDao.getProdutoById(id);
			
	
		request.setAttribute("produto", produto);
		
	
		return "/WEB-INF/jsp/frm-produto-atualizado-crud.jsp";
		
	}

	
}


