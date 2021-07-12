package com.rhuan.server;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.rhuan.client.LoginService;
import com.rhuan.server.uti.ConectService;

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService{

	@Override
	public String valLogin(String login, String senha) {

		return conexao( login, senha );
		
	}

	ConectService conectaUsuario;

	public String valido = "invalido";

	
	public String conexao(String login, String senha) {
		
		try {
			conectaUsuario = new ConectService();
			conectaUsuario.conecta();
			String sql = "SELECT * FROM login WHERE usuario LIKE '"+login+"' "
					+ "and senha LIKE '"+senha+"'";
			conectaUsuario.executeSQL(sql);
			if(conectaUsuario.result.first() == true) 
				valido = "valido";
			else 
				valido ="invalido";
			
		} catch (Exception e) {
			// TODO: handle exception
			valido ="invalido";
		}
		
		return valido ;

	}
	
}
