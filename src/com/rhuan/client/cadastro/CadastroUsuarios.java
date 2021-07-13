package com.rhuan.client.cadastro;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.rhuan.client.LoginGWT;


public class CadastroUsuarios {
		
	public static  CadastroServiceAsync  getServico(){
		return GWT.create(CadastroService.class);
		
	}
	public CadastroUsuarios() {
		 Label lblLogin = new Label("Usuario");
		 Label lblEmail = new Label("Email");
		 Label lblSenha = new Label("Senha");
		
		 TextBox txtLogin = new TextBox();
		 TextBox txtEmail = new TextBox();
		 PasswordTextBox txtSenha = new PasswordTextBox();
		
		Button btnVoltar =new Button("Voltar");
		Button btnSalvar =new Button("Salvar");
		
		VerticalPanel vPanel = new VerticalPanel();
		DialogBox dbPanel2 = new DialogBox();
		
			
			vPanel.add(lblLogin);
			vPanel.add(txtLogin);
			vPanel.add(lblSenha);
			vPanel.add(txtSenha);
			vPanel.add(lblEmail);
			vPanel.add(txtEmail);
			vPanel.add(btnVoltar);
			vPanel.add(btnSalvar);
			
			btnVoltar.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
				RootPanel.get().clear();
				LoginGWT.setView( new LoginGWT());
				}

			});
			
			
			btnSalvar.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					getServico().saveCadastro(txtLogin.getText(), txtSenha.getText(), txtEmail.getText(), callback);
					
				}
			});
			dbPanel2.add(vPanel);
			dbPanel2.setText("Digite usuario e senha: ");
			dbPanel2.setAnimationEnabled(true);
			
			
			RootPanel.get().add(dbPanel2);
	}
	AsyncCallback<String> callback = new AsyncCallback<String>() {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("deu erro");
			
		}

		@Override
		public void onSuccess(String result) {
			if(result.equals("gravou")) {
			Window.alert("cadastrado!");
				
			RootPanel.get().add((IsWidget) new LoginGWT());
			}
			else
				Window.alert("Erro ao cadastrar");
		}
		
	};
	}
	
