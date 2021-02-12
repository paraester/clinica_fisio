package Control;

import Model.BD;
import Model.AcessoBaseDeDados;
import Model.Client;

public class Register {

	//private BD bd;
	private AcessoBaseDeDados bd;	
	
	public Register(){
		// este objeto eh criado na classe MainFrame
		
		//bd = new BD();
		bd = new AcessoBaseDeDados();
	}
	public Client getClient(){
		return new Client();
	}
	public void SaveClient(Client client){
		//BD.clients.add(client);
		bd.addClient(client);
		System.out.println("salvo no banco o(a) cliente " + client.getName());
	}
}