package Control;

import java.util.ArrayList;

import Model.AcessoBaseDeDados;
import Model.ClientCadastro;

public class Register {
	// private BD bd;
	private AcessoBaseDeDados bd;

	public Register() {
		// este objeto eh criado na classe MainFrame
		// bd = new BD();
		bd = new AcessoBaseDeDados();
	}

	public ClientCadastro getClient(int id) {
		ClientCadastro cliente = bd.getClient(id);
		return cliente;
	}

	public void salveAvaliacao(ClientCadastro client) {
		System.out.println("salveAvaliacao pront pra enviar ao banco");
		bd.salveAvaliacao(client);
	}

	public boolean salveCliente(ClientCadastro client) {
		return bd.salveCliente(client);
	}

	// metodo que pega no campo nome string por string
	public ArrayList<String> getFewClients(String nomeParte) {
		return bd.getFewClients(nomeParte);
	}

	// pegar cliente pelo texto inicial do Nome
	public ClientCadastro getClientByName(String inicioNome) {
		return bd.getClientByName(inicioNome);
	}

	// pegar dados dos clientes via buscas
	public ArrayList<ArrayList<String>> buscaListaClientes(int chave, String nome, String idade, String sexo,
			String espec, String medico) {
		return bd.buscaListaClientes(chave, nome, idade, sexo, espec, medico);
	}

}