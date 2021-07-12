package com.rhuan.client.cadastro;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CadastroServiceAsync {

	public void saveCadastro(String login, String senha,String email, AsyncCallback<String>callback);
}
