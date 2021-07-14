package com.rhuan.server;


import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.rhuan.client.cadastro.CadastroService;
import com.rhuan.server.uti.ConectService;

public class CadastroServiceImpl extends RemoteServiceServlet implements CadastroService{

	@Override
	public String saveCadastro(String login, String senha, String email) {

		return conexao( login, senha, email );
		
	}

	ConectService conectaUsuario;

	public String valido = "nao gravou";

	
	public String conexao(String login, String senha, String email) {
		
		try {
			conectaUsuario = new ConectService();
			conectaUsuario.conecta();
			String sql =  "insert into login(usuario,senha,email) values ( '"+login+"','"+senha+"','"+email+"')";
			conectaUsuario.statement.executeUpdate(sql);
			
				valido = "gravou";
			
		} catch (Exception e) {
			// TODO: handle exception
			valido ="nao gravou"+ e;
		}
		
		return valido ;

	}
	
}
