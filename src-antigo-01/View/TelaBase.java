package View;

import java.awt.CardLayout;

import javax.swing.JPanel;

import Control.Register;

public class TelaBase extends JPanel{
	
	private Register register;

	public TelaBase(MainFrame telainit, Register register){
		this.register = register;
		Tela1Cadastro t1;
		ClientFormConsultarClientes fcc;
		ClientFormConsultarAvaliacoes fcoes;
		ClientFormHome cfh; //ClientFormHome
		ClientFormAvali cfa; //ClientFormAvalia 
		ClientFormConsultar cfc; //ClientFormConsultar 
		ClientForm cf; //ClientForm 

		setLayout(new CardLayout());
		t1 = new Tela1Cadastro();

		cf = new ClientForm(telainit);
		cfa = new ClientFormAvali(telainit, register);
		cfh = new ClientFormHome(telainit);
		cfc = new ClientFormConsultar(telainit);
		fcc = new ClientFormConsultarClientes(telainit);
		fcoes = new ClientFormConsultarAvaliacoes(telainit);
		
		//add(t1, "t1");
		
		add(cfh, "formHome");
		add(cfa, "formAvali");
		add(cf, "formCadastro");
		add(cfc, "formConsultar");
		add(fcc, "formConsultarClientes");
		add(fcoes, "formConsultarAvaliacoes");

	}
}