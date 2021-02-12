package View;

import javax.swing.JLabel;
import javax.swing.JTextField;
public class ClientCadastAvali {
	private String medicoresponsavel; 
	private String observacaodehoje;
	private String medicamento;		
	private JTextField medicoresponsavelCampo;
	private JTextField observacaodehojeCampo;
	private JTextField medicamentoCampo;

	public ClientCadastAvali(){
		medicoresponsavel = (medicoresponsavelCampo.getText()); 
		observacaodehoje = (observacaodehojeCampo.getText()); 
		medicamento = (medicamentoCampo.getText());
	}

}
