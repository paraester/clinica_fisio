package View;

import java.awt.CardLayout;
import javax.swing.JPanel;
import Control.Register;

public class TelaBase extends JPanel {
	// private Register register;
	public TelaBase(MainFrame telainit, Register register) {
		// this.register = register;
		System.out.println("inicio telabase");
		ClientFormCadastroFuncionarios t1;
		ClientFormBuscaPaciente cfbp; // provavel nunca sera usado
		ClientFormAtualizarFuncionario cfbf;
		ClientFormConsultarFuncionarios cfcf;
		ClientFormAtualizarCliente cfac;

		ClientFormConsultarClientes fcc;
		ClientFormConsultarAvaliacoes fcoes;
		ClientFormHome cfh; // ClientFormHome
		ClientFormAvali cfa; // ClientFormAvalia
		ClientFormConsultar cfc; // ClientFormConsultar
		ClientFormCadastroClientes cf; // ClientForm

		setLayout(new CardLayout());
		// t1 = new ClientFormCadastroFuncionarios(telainit, register);
		t1 = new ClientFormCadastroFuncionarios(telainit);
		cf = new ClientFormCadastroClientes(telainit, register);
		cfa = new ClientFormAvali(telainit, register);
		cfh = new ClientFormHome(telainit);
		cfc = new ClientFormConsultar(telainit);
		fcc = new ClientFormConsultarClientes(telainit, register);
		fcoes = new ClientFormConsultarAvaliacoes(telainit, register);
		cfbp = new ClientFormBuscaPaciente(telainit, register);
		cfbf = new ClientFormAtualizarFuncionario(telainit, register);
		cfcf = new ClientFormConsultarFuncionarios(telainit, register);
		cfac = new ClientFormAtualizarCliente(telainit, register);

		add(cfh, "formHome");
		add(cfa, "formAvali");
		add(cf, "formCadastroClientes");
		add(cfc, "formConsultar");
		add(fcc, "formConsultarClientes");
		add(fcoes, "formConsultarAvaliacoes");
		add(t1, "formCadastroFuncionarios");
		add(cfbp, "formClientBuscaPaciente");
		add(cfbf, "formClientBuscaFuncionario");
		add(cfcf, "ClientFormConsultarFuncionarios");
		add(cfac, "ClientFormAtualizarCliente");
	}
}