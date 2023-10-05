package com.despensa.actions;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.despensa.model.Usuario;
import com.despensa.service.UsuarioDAO;

public class InserirUsuarioAction implements Action {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha =  request.getParameter("senha"); 
		
	
		Usuario usuario = new Usuario();
		
		
		usuario.setSenha(usuario.cifrarSenha(senha));
		usuario.setNome(nome);
		usuario.setEmail(email);
//		Random random = new Random();
//		aluno.setSenha(Integer.toString(random.nextInt(100000))); // senha provisï¿½ria
		
		Connection connection = (Connection) request.getAttribute("connection");
		UsuarioDAO usuarioDao = new UsuarioDAO(connection);
		
		
		
		

		if (usuarioDao.insertUsuario(usuario) != 0) {
			System.out.println("Usuario inserido com sucesso!");
		} else {
			System.out.println("Erro: Usuario não inserido !!");
		}

		return "/WEB-INF/jsp/login.jsp";
		
		

	}

}
