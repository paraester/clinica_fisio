package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Control.Register;
import Model.Client;

public class ClientFormAvali extends JPanel implements VisualWindow{
	//private JLabel labelCep = new JLabel("CEP: ");
	
	private JButton btvoltar;
	private JButton btcadastro;
	private JButton btenviar;
	private MainFrame telainit;
	private JLabel nome; //que veio do banco de dados
	private JLabel idade; // que veio do banco de dados
	private JLabel sexo; // que veio do banco de dados
	private JLabel medicoresponsavel; // que veio do banco de dados
	private JLabel observacaodehoje;
	private JLabel medicamento;
	private JLabel background;
	private JLabel nomedoformulario;

	private JTextField medicoresponsavelCampo;
	private JTextField observacaodehojeCampo;
	private JTextField medicamentoCampo;

	private JButton btobservacaodehoje;
	private JButton btmedicoresponsavel;
	private JButton btmedicamento;
	private Register register;
	
	public ClientFormAvali(MainFrame telainit, Register register){
		this.register = register;
		this.telainit = telainit;
		setupLayout();
		setupComponentes();
		setupEvents();
	}
	
	@Override
	public void setupLayout() {
		setLayout(null); // fixo
		background=new JLabel(new ImageIcon(MainFrame.class.getResource("../View/image/middle.gif")));
		//ImageIcon icon = (new ImageIcon(MainFrame.class.getResource("../View/image/middle.gif")));
		setBackground(Color.white);
		setVisible(true);
		setSize(800, 550);
	
	}
	@Override
	public void setupComponentes() {
		nomedoformulario = new JLabel("Formulário para Avaliação Clínica");
		nomedoformulario.setForeground(Color.blue);
		nomedoformulario.setFont(new Font("Serifa", Font.BOLD, 20));
		
		//labelCep.setBounds(50,20,100,20);
		//MaskFormatter mascaraCep = null;
		nome = new JLabel("Nome do paciente: ");
		idade = new JLabel("Idade: ");
		sexo = new JLabel("Sexo: ");
		

		
		medicoresponsavel = new JLabel("Médico desta avaliação: ");
		observacaodehoje = new JLabel("Observação: ");
		medicamento = new JLabel("Medicamento em uso: ");
		//try{
            //mascaraCep = new MaskFormatter("#####-###");
		//}
        //catch(ParseException excp) {
               //System.err.println("Erro na formatação: " + excp.getMessage());
               //System.exit(-1);
       // }		
		
		medicoresponsavelCampo = new JTextField(100);
		observacaodehojeCampo = new JTextField(100);
		medicamentoCampo = new JTextField(200);
		

		
		btmedicoresponsavel = new JButton(" ok medico");
		btobservacaodehoje = new JButton(" ok observação");
		btmedicamento = new JButton(" ok medicamento");
		nomedoformulario.setBounds(250, 40, 400, 40);//x y w h		

		nome.setBounds(250, 80, 200, 40);//x y w h
		idade.setBounds(250, 110, 170, 40);
		sexo.setBounds(250, 140, 200, 40);
		medicoresponsavel.setBounds(250, 180, 200, 40);//x y w h	
		medicamento.setBounds(250, 230, 240, 40);	
		observacaodehoje.setBounds(250, 270, 170, 40);
		
		medicoresponsavelCampo.setBounds(440, 190, 210, 20);
		medicamentoCampo.setBounds(410, 240, 240, 20);
		observacaodehojeCampo.setBounds(350, 290, 300, 100);
	
		btvoltar = new JButton("HOME");
		btcadastro = new JButton("CADASTRAR CLIENTE");
		btenviar = new JButton("SALVAR");
	
		
		btvoltar.setBounds(10, 50, 200, 30);
		btcadastro.setBounds(10, 100, 200, 30);	
		btenviar.setBounds(250, 420, 100, 30);
		
		
		btcadastro.setBackground(Color.white);
		btcadastro.setOpaque(true);
		btcadastro.setForeground(new Color(0, 0, 0));
		btcadastro.setRequestFocusEnabled(false);
		btcadastro.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(224, 224, 224), 2));
	   
		btvoltar.setBackground(Color.white);
		btvoltar.setOpaque(true);
		btvoltar.setForeground(new Color(0, 0, 0));
		btvoltar.setRequestFocusEnabled(false);
		btvoltar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(224, 224, 224), 2));

		add(nomedoformulario);
		add(background);
		add(nome);
		add(idade);
		add(sexo);
		add(medicoresponsavel);
		add(medicamento);
		add(observacaodehoje);
		add(medicoresponsavelCampo);
		add(medicamentoCampo);
		add(observacaodehojeCampo);
		

		add(btvoltar);
		add(btcadastro);
		add(btenviar);
	}
	
	
	@Override
	public void setupEvents() {

		btcadastro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				telainit.trocarTela("formCadastro");
			}
		});
		
		
		btvoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				telainit.trocarTela("formHome");
			}
		});
		btenviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Client client = register.getClient();
				client.setName(medicoresponsavelCampo.getText());
				register.SaveClient(client);
			}
		});
		
		
	}
}