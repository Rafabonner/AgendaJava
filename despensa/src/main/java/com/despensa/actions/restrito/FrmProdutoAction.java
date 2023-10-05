package com.despensa.actions.restrito;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.despensa.actions.Action;
import com.despensa.model.Armazenamento;
import com.despensa.model.Categoria;
import com.despensa.service.ArmazenamentoDAO;
import com.despensa.service.CategoriaDAO;


public class FrmProdutoAction implements Action {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		Connection connection = (Connection) request.getAttribute("connection");
		CategoriaDAO categoriaDao = new CategoriaDAO(connection);
		List<Categoria> categoria = new ArrayList<Categoria>();
		categoria.addAll(categoriaDao.getCategoria());
		request.setAttribute("listaDeCategorias", categoria);

		ArmazenamentoDAO armazenamentoDao = new ArmazenamentoDAO(connection);
		List<Armazenamento> armazenamento = new ArrayList<Armazenamento>();
		armazenamento.addAll(armazenamentoDao.getArmazenamento());
		request.setAttribute("listaDeArmazem", armazenamento);

		return "/WEB-INF/jsp/frmProduto.jsp";
	}

}
