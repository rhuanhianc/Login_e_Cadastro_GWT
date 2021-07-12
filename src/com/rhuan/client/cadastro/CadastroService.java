package com.rhuan.client.cadastro;


import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("cadastro")
public interface CadastroService extends RemoteService{
	public String saveCadastro(String login, String senha);
}
