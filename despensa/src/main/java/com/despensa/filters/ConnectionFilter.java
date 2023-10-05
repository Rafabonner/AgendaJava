package com.despensa.filters;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import com.despensa.database.ConnectionFactory;

/**
 * Servlet Filter implementation class ConnectionFilter
 */
@WebFilter(filterName = "ConnectionFilter", urlPatterns = {"/*"})
public class ConnectionFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	     
		try {
			// Código executado antes de qualquer requisição
			
			/*System.out.println("Iniciando o filtro");*/
			Connection connection = ConnectionFactory.connectionSqlServer();
			/*System.out.println("Iniciando o filtroddddd"+connection);*/
			request.setAttribute("connection", connection);
		
			chain.doFilter(request, response);
			// Código executado após as requisições
			
//			System.out.println("Encerrando o filtro");
			connection.close();
			
		} catch (Exception e) {
			throw new ServletException();
		}
		
	}

}
