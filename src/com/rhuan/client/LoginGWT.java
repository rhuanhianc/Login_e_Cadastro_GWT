package com.rhuan.client;

import com.rhuan.client.cadastro.CadastroUsuarios;
import com.rhuan.client.home.home;
import com.rhuan.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class LoginGWT implements EntryPoint {

	public static  LoginServiceAsync  getServico(){
		return GWT.create(LoginService.class);
		
	}
	private Label lblLogin = new Label("Usuario");
	private Label lblSenha = new Label("Senha");
	
	private TextBox txtLogin = new TextBox();
	private PasswordTextBox txtSenha = new PasswordTextBox();
	
	Button btnEntrar =new Button("Entrar");
	Button btnCadastrar =new Button("Cadastrar");
	
	VerticalPanel vPanel = new VerticalPanel();
	DialogBox dbPanel = new DialogBox();
	public void onModuleLoad() {
		
		vPanel.add(lblLogin);
		vPanel.add(txtLogin);
		vPanel.add(lblSenha);
		vPanel.add(txtSenha);
		vPanel.add(btnEntrar);
		vPanel.add(btnCadastrar);
		
		
		btnEntrar.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				getServico().valLogin(txtLogin.getText(), txtSenha.getText(), callback);
				
			}
		});
		
		btnCadastrar.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get().clear();
			RootPanel.get().add((IsWidget) new CadastroUsuarios());
				
			}
		});
		dbPanel.add(vPanel);
		dbPanel.setText("Digite usuario e senha: ");
		dbPanel.setAnimationEnabled(true);
		
		
		RootPanel.get().add(dbPanel);
	}
	
	
	
	
	AsyncCallback<String> callback = new AsyncCallback<String>() {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("deu erro");
			
		}

		@Override
		public void onSuccess(String result) {
			if(result.equals("valido")) {
			RootPanel.get().clear();	
			RootPanel.get().add((IsWidget) new home());
			}
			else
				Window.alert("usuario ou senha invalida");
		}
		
	};
}