package com.despensa.actions.restrito;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.despensa.actions.Action;
import com.despensa.model.Armazenamento;
import com.despensa.model.Categoria;
import com.despensa.model.Produto;
import com.despensa.model.Usuario;
import com.despensa.service.ProdutoDAO;

public class InserirProdutoAction implements Action {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String nome_prod = request.getParameter("nome_prod");
		String validade = request.getParameter("validade");
		String quant =  request.getParameter("quant"); 
		String ean = request.getParameter("ean");
				
		int id_categoria = Integer.parseInt(request.getParameter("categoria"));
		
		int id_armazenamento = Integer.parseInt(request.getParameter("armazenamento"));

		HttpSession sess = ((HttpServletRequest) request).getSession(true);
		
		int id_usuario =    (int) sess.getAttribute("id_usuario");
				
		Produto produto = new Produto();
		
		produto.setNome_prod(nome_prod);
				
		Calendar cal = Calendar.getInstance();
		Date dt = new SimpleDateFormat("yyyy-MM-dd").parse(validade);
		cal.setTime(dt);
		produto.setValidade(cal);
				
		produto.setQuant(quant);
				
		produto.setEan(ean);
			
		
		Categoria categoria = new Categoria();
		categoria.setId(id_categoria);
				
		Armazenamento armazenamento = new Armazenamento ();
		armazenamento.setId(id_armazenamento);
				
		produto.setCategoria(categoria);
		produto.setArmazenamento(armazenamento);
		
		Usuario usuario = new Usuario();
		usuario.setId(id_usuario);
		
		produto.setUsuario(usuario);
		
		Connection connection = (Connection) request.getAttribute("connection");
		ProdutoDAO produtoDao = new ProdutoDAO(connection);
				
		if (produtoDao.insertProduto(produto) != 0) {
		
			System.out.println("Produto inserido com sucesso!");
		} else {
			System.out.println("Erro: Produto não inserido !!");
		}

		return "/WEB-INF/jsp/produto-inserido-sucesso.jsp";
		
	}
	}
