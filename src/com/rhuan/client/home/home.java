package com.rhuan.client.home;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
public class home {
	public home() {
DockLayoutPanel dock = new DockLayoutPanel(Unit.EM);
		
		dock.addNorth(new Label ("Ol� Mundo"), 5);
		
		SplitLayoutPanel split1 = new SplitLayoutPanel();
		SplitLayoutPanel split2 = new SplitLayoutPanel();
		
		dock.add(split1);
		//dock.add(split2);
		
		split1.addWest(barraLateral(), 250);
		split1.add(split2);
		RootLayoutPanel.get().add(dock);
	}
	
	public Widget headers(String image, String text) {
		FlowPanel painel = new FlowPanel();
		painel.add(new Image (image));
		painel.add(new Label (text));
		
		return painel;
	}

	public Widget barraLateral(){
		StackLayoutPanel stack = new StackLayoutPanel(Unit.EM);
		stack.add(opcoesEmail(), "MailBox", 5);
		stack.add(opcoesTarefas(), headers("", "tarefas"), 5);
		return stack;
		
	}
	
	public Widget opcoesEmail () {
		TreeItem home = new TreeItem(headers( "","TESTANDO"));
		TreeItem drafts = new TreeItem();
		TreeItem sent = new TreeItem();
		TreeItem inbox = new TreeItem();
		TreeItem templates = new TreeItem();
		TreeItem trash = new TreeItem();
	
		home.addItem(drafts);
		home.addItem(inbox);
		home.addItem(templates);
		home.addItem(sent);
		home.addItem(trash);
		
		
		Tree opcoesEmail = new Tree();
		opcoesEmail.addItem(home);
		
		return opcoesEmail;
	}
	public Widget opcoesTarefas() {
		VerticalPanel vpanel = new VerticalPanel();
		vpanel.setSpacing(5);
		vpanel.add(new CheckBox("visatar alguem"));
		vpanel.add(new CheckBox("fazer tarefa tal"));
		vpanel.add(new CheckBox("fazer almco"));
		vpanel.add(new CheckBox("vir a tal"));	
		vpanel.add(new CheckBox("checar tal coisa"));
		return vpanel;
	}
}