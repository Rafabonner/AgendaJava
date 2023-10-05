 package com.despensa.actions.restrito;


import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.despensa.actions.Action;
import com.despensa.model.Produto;
import com.despensa.service.ProdutoDAO;


public class ListarProdutoAction implements Action{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection connection = (Connection) request.getAttribute("connection");
		ProdutoDAO produtoDao = new ProdutoDAO(connection);
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.addAll(produtoDao.getProduto());


		System.out.println(produtos.size() + "teste" );
		request.setAttribute("listaDeProdutos", produtos);
		
		return "/WEB-INF/jsp/index.jsp";
		
		
	}

}
