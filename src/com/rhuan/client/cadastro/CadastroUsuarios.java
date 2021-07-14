package com.rhuan.client.cadastro;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
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
		 Label lblLogin = new Label("Usuario:");
		 Label lblEmail = new Label("Email:");
		 Label lblSenha = new Label("Senha:");
		 Label lblLoginBranco = new Label("Preencha todos os campos!");
		 Label lblCadastro = new Label("Cadastrado com sucesso!");
			Timer t = new Timer() {
			      @Override
			      public void run() {
			    	  lblLoginBranco.setVisible(false);
			    	  lblCadastro.setVisible(false);
			      }
			};
		 
			final  DialogBox dbPanel2= new DialogBox(){;
		    protected void beginDragging(MouseDownEvent event) {
		        event.preventDefault();
		    };
		};
		
		 TextBox txtLogin = new TextBox();
		 TextBox txtEmail = new TextBox();
		 PasswordTextBox txtSenha = new PasswordTextBox();
		
		Button btnVoltar =new Button("Voltar");
		Button btnSalvar =new Button("Enviar");
		FlexTable flTable = new FlexTable();
		VerticalPanel vPanel = new VerticalPanel();
		
		
			
			vPanel.add(lblLogin);
			vPanel.add(txtLogin);
			vPanel.add(lblSenha);
			vPanel.add(txtSenha);
			vPanel.add(lblEmail);
			vPanel.add(txtEmail);
			vPanel.add(lblLoginBranco);
			vPanel.add(lblCadastro);
			lblLoginBranco.setStyleName("erro");
			lblCadastro.setStyleName("correto");
			flTable.setWidget(0, 0, btnVoltar);
			flTable.setWidget(0, 8, btnSalvar);
			flTable.setCellPadding(5);
			vPanel.add(flTable);
			
			lblLoginBranco.setVisible(false);
			lblCadastro.setVisible(false);
			
			txtLogin.getElement().setPropertyString("placeholder", "Digite um nome de usuario");
			txtSenha.getElement().setPropertyString("placeholder", "Digite uma senha");
			txtEmail.getElement().setPropertyString("placeholder", "Digite um email");
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
					if(!txtLogin.getText().isEmpty() && !txtSenha.getText().isEmpty() && !txtEmail.getText().isEmpty()) {
					getServico().saveCadastro(txtLogin.getText(), txtSenha.getText(), txtEmail.getText(), callback);
					lblCadastro.setVisible(true);
					t.schedule(5000);
					} else {
						lblLoginBranco.setVisible(true);
						t.schedule(5000);
					}
				}
			});
			dbPanel2.add(vPanel);
			
			
			dbPanel2.setAnimationEnabled(true);
			
			dbPanel2.center();
			
			RootPanel.get().add(dbPanel2);
			dbPanel2.center();
	}
	AsyncCallback<String> callback = new AsyncCallback<String>() {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("deu erro");
			
		}

		@Override
		public void onSuccess(String result) {
			if(result.equals("gravou")) {
			RootPanel.get().clear();	
			LoginGWT.setView( new LoginGWT());
			}
			else
				Window.alert("Erro ao cadastrar");
		}
		
	};
	}
	
