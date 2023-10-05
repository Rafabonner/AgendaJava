package com.despensa.actions;


import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.despensa.model.Usuario;
import com.despensa.service.UsuarioDAO;

public class LoginAction implements Action{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection connection = (Connection) request.getAttribute("connection");
	
		request.getSession().invalidate();
		String email = request.getParameter("email");
		String senha = request.getParameter("password");
		
		String action = "";
		
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);
		
		UsuarioDAO UsuarioDAO = new UsuarioDAO(connection);
		HttpSession session = request.getSession();
		
		Usuario usuarioBd = UsuarioDAO.login(usuario);
		if(usuarioBd != null) {
			session.setAttribute("email", usuarioBd.getEmail());
			session.setAttribute("id_usuario", usuarioBd.getId());
			//System.out.println("Usuário Logado!");	
			action = "/despensa/restrito?action=HomeAction";
		}else {
			System.out.println("Usuário não encontrado!");	
			action = "/despensa/home?action=FrmLoginAction&box=1";
		}
		 return action;
		 
	}

}
