package com.rhuan.client.home;
import java.util.ArrayList;
import java.util.List;
import com.rhuan.client.home.Pessoa;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
public class home {
	private VerticalPanel mainPanel = new VerticalPanel();
	private VerticalPanel addPanel = new VerticalPanel();
	private HorizontalPanel sexoPanel = new HorizontalPanel();
	
	FlexTable tbPessoas = new FlexTable();
	
	private Label lblNome = new Label("Nome:");
	private TextBox txtNome = new TextBox();
	private TextBox txtEndereco = new TextBox();
	private Label lblendereco = new Label("Endereço:");
	
	
	private Button btnCadastrar = new Button("Cadastrar");
	
	private Label lblSexo = new Label("Sexo");
	private RadioButton rdFem = new RadioButton("sexo", "Feminino");
	private RadioButton rdMasc = new RadioButton("sexo", "Masculino");
	private List<Pessoa> listaPessoas = new ArrayList<>();
	
	
	public home() {

			tbPessoas.setText(0, 0, "Nome");
			tbPessoas.setText(0, 1, "Endereço");
			tbPessoas.setText(0, 2, "Sexo");
			tbPessoas.setText(0, 3, "Alterar");
			tbPessoas.setText(0, 4, "Deletar");
			tbPessoas.setCellPadding(5);
			tbPessoas.setCellSpacing(5);
			tbPessoas.setBorderWidth(1);
			rdMasc.setValue(true);
			
			addPanel.add(lblNome);
			addPanel.add(txtNome);
			addPanel.add(lblendereco);
			addPanel.add(txtEndereco);
			addPanel.add(lblSexo);
			
			sexoPanel.add(rdFem);
			sexoPanel.add(rdMasc);
			
			addPanel.add(sexoPanel);
			
			addPanel.add(btnCadastrar);
			
			mainPanel.add(addPanel);
			mainPanel.add(tbPessoas);
			
			RootPanel.get().add(mainPanel);
		
			
			btnCadastrar.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
					addPessoa();
					Window.alert("Adicionada com sucesso!");
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
	}
	

	}
