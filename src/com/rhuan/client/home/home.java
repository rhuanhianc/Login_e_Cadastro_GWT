package com.rhuan.client.home;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.rhuan.client.LoginGWT;

public class home {
	private VerticalPanel mainPanel = new VerticalPanel();
	private FlexTable botoesPanel= new FlexTable();
	private FlexTable botoesPanelUsuarios= new FlexTable();
	private VerticalPanel addPanel = new VerticalPanel();
	private HorizontalPanel sexoPanel = new HorizontalPanel();
	DialogBox dbPanelUsuarios = new DialogBox() {
		;
		protected void beginDragging(MouseDownEvent event) {
			event.preventDefault();
		};
	};
	DialogBox dbPanelCadastro = new DialogBox() {
		;
		protected void beginDragging(MouseDownEvent event) {
			event.preventDefault();
		};
	};
	private FlexTable tbPessoas = new FlexTable();

	private Label lblNome = new Label("Nome:");
	private TextBox txtNome = new TextBox();
	private TextBox txtEndereco = new TextBox();
	private Label lblendereco = new Label("Endereço:");

	private Button btnCadastrar = new Button("Cadastrar");
	private Button btnAdicionar = new Button("Adicionar Pessoas");
	private Button btnVoltar = new Button("Voltar");
	private Button btnVoltarLogin = new Button("Sair");
	private Button btnAlterar = new Button("Alterar");
	private Button btnDeletar = new Button("Deletar");
	

	private Label lblSexo = new Label("Sexo");
	private RadioButton rdFem = new RadioButton("sexo", "Feminino");
	private RadioButton rdMasc = new RadioButton("sexo", "Masculino");
	
	

	private List<Pessoa> listaPessoas = new ArrayList<>();

	public home() {
		
			
		
		txtNome.getElement().setPropertyString("placeholder", "Digite um nome");
		txtEndereco.getElement().setPropertyString("placeholder", "Digite um endereço");
		
		tbPessoas.setText(0, 0, "Nome");
		tbPessoas.setText(0, 1, "Endereço");
		tbPessoas.setText(0, 2, "Sexo");
		tbPessoas.setText(0, 3, "Alterar");
		tbPessoas.setText(0, 4, "Deletar");
		tbPessoas.setCellPadding(25);
		tbPessoas.setCellSpacing(10);
		tbPessoas.setStyleName("tabela_cadastro");
		
		
		rdMasc.setValue(true);
		//Painel Cadastrar
		addPanel.add(lblNome);
		addPanel.add(txtNome);
		addPanel.add(lblendereco);
		addPanel.add(txtEndereco);
		addPanel.add(lblSexo);
		


		sexoPanel.add(rdFem);
		sexoPanel.add(rdMasc);
		
		
		
		addPanel.add(sexoPanel);
		//Botoes cadastrar
		botoesPanel.setWidget(0, 0, btnVoltar);
		botoesPanel.setWidget(0, 8, btnCadastrar);
		botoesPanel.setCellPadding(5);
		
	
		
		addPanel.add(botoesPanel);
		
		
		
		botoesPanelUsuarios.setWidget(0, 0, btnVoltarLogin);
		botoesPanelUsuarios.setWidget(0, 8, btnAdicionar);
		botoesPanelUsuarios.setCellPadding(5);
		
		mainPanel.add(tbPessoas);
		mainPanel.add(botoesPanelUsuarios);
		

		dbPanelUsuarios.add(mainPanel);
		dbPanelCadastro.add(addPanel);
		
		RootPanel.get().add(dbPanelUsuarios);
		RootPanel.get().add(dbPanelCadastro);
	
		
		dbPanelUsuarios.center();
		dbPanelUsuarios.setAnimationEnabled(true);
		
		dbPanelCadastro.center();
		dbPanelCadastro.hide();
		dbPanelCadastro.setAnimationEnabled(true);
		
		
		
		//Botao de adicionar Pessoa
		btnAdicionar.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				dbPanelCadastro.show();
			}
		});
		//Botao de Voltar
		btnVoltar.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				dbPanelCadastro.hide();

			}
		});
		//Botao de Voltar Login
				btnVoltarLogin.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						RootPanel.get().clear();
						LoginGWT.setView(new LoginGWT());

					}
				});
		//Botao de Cadastrar Pessoa
		btnCadastrar.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				addPessoa();
			}
		});
		
		
		
	}
	

	private void addPessoa() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(txtNome.getText());
		pessoa.setEndereco(txtEndereco.getText());
		pessoa.setSexo(rdMasc.getValue() ? "Masculino" : "Feminino");
		listaPessoas.add(pessoa);

		int row = tbPessoas.getRowCount();
		tbPessoas.setText(row, 0, pessoa.getNome());
		tbPessoas.setText(row, 1, pessoa.getEndereco());
		tbPessoas.setText(row, 2, pessoa.getSexo());
		tbPessoas.setWidget(row, 3, btnAlterar = new Button("Alterar"));
		tbPessoas.setWidget(row, 4, btnDeletar = new Button("Deletar"));
		
		// Botao de Alterar
				btnAlterar.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						int rowIndex = tbPessoas.getCellForEvent(event).getRowIndex();
					txtNome.setText(tbPessoas.getText(rowIndex, 0));
					txtEndereco.setText(tbPessoas.getText(rowIndex, 1));
					dbPanelCadastro.show();
					tbPessoas.removeRow(rowIndex);
				
					}
				});
				
		// Botao de Deletar
		btnDeletar.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				int rowIndex = tbPessoas.getCellForEvent(event).getRowIndex();
				tbPessoas.removeRow(rowIndex);
			}
		});
	}

}
