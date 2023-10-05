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


public class AtualizarProdutoAction implements Action {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		
		int id = Integer.parseInt(request.getParameter("cod_prod"));		
		String nome_prod = request.getParameter("nome_prod");		
		String validade = request.getParameter("validade");		
		String ean = request.getParameter("ean");		
		String quant = request.getParameter("quant");
			
		Produto produto = new Produto();
		produto.setId(id);
		produto.setNome_prod(nome_prod);			
		
		Calendar cal = Calendar.getInstance();
		Date dt = new SimpleDateFormat("yyyy-MM-dd").parse(validade);
		cal.setTime(dt);
		produto.setValidade(cal);
		produto.setEan(ean);
		produto.setQuant(quant);		
			
		Connection connection = (Connection) request.getAttribute("connection");
		ProdutoDAO produtoDao = new ProdutoDAO(connection);
		
		

		if (produtoDao.updateProduto(produto) != 0) {
			System.out.println("Produto atualizado com sucesso!");
		} else {
			System.out.println("Erro: Produto não atualizado !!");
		}

		return "/WEB-INF/jsp/produto-atualizado-sucesso.jsp";
	}

}
