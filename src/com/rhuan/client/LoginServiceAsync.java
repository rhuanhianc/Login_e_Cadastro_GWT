package com.rhuan.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {

	public void valLogin(String login, String senha, AsyncCallback<String>callback);
}
