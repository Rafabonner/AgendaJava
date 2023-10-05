package com.despensa.actions.restrito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.despensa.actions.Action;

public class FrmCadastroAction implements Action {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/WEB-INF/jsp/cadastro.jsp";
	}

}
