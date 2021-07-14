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
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
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
	static DialogBox dbPanel= new DialogBox(){;
    protected void beginDragging(MouseDownEvent event) {
        event.preventDefault();
    };
};
	private Label lblLogin = new Label("Usuario:");
	private Label lblSenha = new Label("Senha:");
	private Label lblLoginErrado = new Label("Usuario ou senha invalidos!");
	private Label lblLoginBranco = new Label("Preencha todos os campos!");
	
	private TextBox txtLogin = new TextBox();
	
	private PasswordTextBox txtSenha = new PasswordTextBox();
	
	Button btnEntrar =new Button("Entrar");
	Button btnCadastrar =new Button("Cadastrar");
	
	FlexTable flTable = new FlexTable();
	VerticalPanel vPanel = new VerticalPanel();
	Image image = new Image("images/usericon.png");
	Timer t = new Timer() {
	      @Override
	      public void run() {
	    	  lblLoginErrado.setVisible(false);
	    	  lblLoginBranco.setVisible(false);
	      }
	};
	public void onModuleLoad() {
		
		vPanel.add(image);
		vPanel.add(lblLogin);
		vPanel.add(txtLogin);
		vPanel.add(lblSenha);
		vPanel.add(txtSenha);
		vPanel.add(lblLoginErrado);
		vPanel.add(lblLoginBranco);
		lblLoginErrado.setStyleName("erro");
		lblLoginBranco.setStyleName("erro");
		flTable.setWidget(0, 0, btnCadastrar);
		flTable.setWidget(0, 8, btnEntrar);
		
		flTable.setCellPadding(5);
		lblLoginErrado.setVisible(false);
		lblLoginBranco.setVisible(false);
		vPanel.add(flTable);
		txtLogin.getElement().setPropertyString("placeholder", "Digite o nome de usuario");
		txtSenha.getElement().setPropertyString("placeholder", "Digite a sua senha");
	
		btnEntrar.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
					getServico().valLogin(txtLogin.getText(), txtSenha.getText(), callback);
				
			}
		});
		
	
		dbPanel.add(vPanel);
		dbPanel.center();
		dbPanel.setAnimationEnabled(true);
		
	btnCadastrar.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get().clear();
				dbPanel.hide();
				 new CadastroUsuarios();

			}
		});
		
		
		RootPanel.get().add(dbPanel);
		dbPanel.center();
	}
	
	
	
	
	AsyncCallback<String> callback = new AsyncCallback<String>() {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("deu erro");
			
		}

		@Override
		public void onSuccess(String result) {
			if (result.equals("valido")) {
				RootPanel.get().clear();
				dbPanel.hide();

				RootPanel.get().add((IsWidget) new home());
			}

			else {
				if (txtLogin.getText().isEmpty() || txtSenha.getText().isEmpty()) {
					lblLoginBranco.setVisible(true);
					t.schedule(5000);
				} else {
					lblLoginErrado.setVisible(true);
					t.schedule(5000);
				}
			}
		}

	};
	public static void setView(LoginGWT loginGWT) {
		// TODO Auto-generated method stub
		dbPanel.show();
	}
}