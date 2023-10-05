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


public class FrmExcluirProdutoAction implements Action {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		
	
		Connection connection = (Connection) request.getAttribute("connection");
		ProdutoDAO produtoDao = new ProdutoDAO(connection);
		
		

		if (produtoDao.deleteProduto(id) != 0) {
			System.out.println("Produto excluído com sucesso!");
		} else {
			System.out.println("Erro: Produto não excluído !!");
		}

		return "/WEB-INF/jsp/frm-produto-excluido-crud.jsp";
	}

}


