package com.rhuan.server;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.rhuan.client.LoginService;
import com.rhuan.client.cadastro.CadastroService;
import com.rhuan.server.uti.ConectService;

public class CadastroServiceImpl extends RemoteServiceServlet implements CadastroService{

	@Override
	public String saveCadastro(String login, String senha) {

		return conexao( login, senha );
		
	}

	ConectService conectaUsuario;

	public String valido = "nao gravou";

	
	public String conexao(String login, String senha) {
		
		try {
			conectaUsuario = new ConectService();
			conectaUsuario.conecta();
			String sql =  "insert into login(usuario,senha) values ( 'teste','001')";
			conectaUsuario.executeSQL(sql);
			if(conectaUsuario.result.first() == true) 
				valido = "gravou";
			else 
				valido ="invalido";
			
		} catch (Exception e) {
			// TODO: handle exception
			valido ="nao gravou";
		}
		
		return valido ;

	}
	
}
