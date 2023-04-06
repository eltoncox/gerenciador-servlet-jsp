package com.elton.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


//@WebFilter(urlPatterns = "/entrada")
public class MonitoramentoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("MonitoramentoFilter");
		
		long antes = System.currentTimeMillis();// tempo de execução
		
		String acao = request.getParameter("acao");
		
		//executa a ação
		chain.doFilter(request, response);
		
		long depois = System.currentTimeMillis();// tempo de execução		
		System.out.println("Tempo de execução da ação  "+ acao +"  ->  " + (depois - antes) );// resultado da execução
	}

}
