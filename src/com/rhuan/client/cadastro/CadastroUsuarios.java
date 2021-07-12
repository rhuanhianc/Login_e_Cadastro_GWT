package com.rhuan.client.cadastro;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CadastroUsuarios {

	public CadastroUsuarios() {
		 Label lblLogin = new Label("Usuario");
		 Label lblEmail = new Label("Email");
		 Label lblSenha = new Label("Senha");
		
		 TextBox txtLogin = new TextBox();
		 TextBox txtEmail = new TextBox();
		 PasswordTextBox txtSenha = new PasswordTextBox();
		
		Button btnVoltar =new Button("Voltar");
		Button btnCadastrar =new Button("Cadastrar");
		
		VerticalPanel vPanel = new VerticalPanel();
		DialogBox dbPanel = new DialogBox();
		
			
			vPanel.add(lblLogin);
			vPanel.add(txtLogin);
			vPanel.add(lblSenha);
			vPanel.add(txtSenha);
			vPanel.add(lblEmail);
			vPanel.add(txtEmail);
			vPanel.add(btnVoltar);
			vPanel.add(btnCadastrar);
			
			
			btnCadastrar.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
					
				}
			});
			dbPanel.add(vPanel);
			dbPanel.setText("Digite usuario e senha: ");
			dbPanel.setAnimationEnabled(true);
			
			
			RootPanel.get().add(dbPanel);
	}
	}
	
