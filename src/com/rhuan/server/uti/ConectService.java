package com.rhuan.server.uti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConectService {

	private Connection conexao;
	public Statement statement;
	public ResultSet result;
	public String valido;
	public String url = "jdbc:postgresql://localhost:5432/postgres";
	public String usuariopos = "postgres";
	public String senhapos= "123";
	public String driver = "org.postgresql.Driver";
	
	
	public boolean conecta (String usuariopos, String senhapos, String driver, String banco) {
		boolean result =true;
		try {
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection(url,usuariopos,senhapos);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			result =false;
		}
		return result;
	}
	
	public boolean conecta() {
		boolean result =true;
		try {
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection(url,usuariopos,senhapos);
			statement = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			result =false;
		}
		
		return result;
		
	}
	
	public void desconecta() {
		boolean result =true;
		try {
			conexao.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			result =false;
		}
		
		
	}
	
	public void executeSQL(String sql) {

		try {
			statement = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			result = statement.executeQuery(sql);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			valido ="erro banco "+ e;
		}

	}
	
}

