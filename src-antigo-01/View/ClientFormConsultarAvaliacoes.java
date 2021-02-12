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

public class ClientFormConsultarAvaliacoes extends JPanel implements VisualWindow{
	private JButton btvoltar;
	private JButton btconsultarClientes;
	private JButton btenviar;
	
	private MainFrame telainit;
	private JLabel nome; //que veio do banco de dados
	private JLabel idade; // que veio do banco de dados
	private JLabel medicoresponsavel; // que veio do banco de dados
	private JLabel background;
	private JLabel nomedoformulario;

	private JTextField nomeCampo;
	private JTextField idadeCampo;
	private JTextField medicoresponsavelCampo;

	
	public ClientFormConsultarAvaliacoes(MainFrame telainit){
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
		nomedoformulario = new JLabel("Consultar Avaliações");
		nomedoformulario.setForeground(Color.blue);
		nomedoformulario.setFont(new Font("Serifa", Font.BOLD, 20));
		nome = new JLabel("Nome do paciente: ");
		idade = new JLabel("Idade: ");
		medicoresponsavel = new JLabel("Médico desta avaliação: ");
		nomeCampo = new JTextField(100);
		idadeCampo = new JTextField(100);
		medicoresponsavelCampo = new JTextField(100);


		nomedoformulario.setBounds(250, 40, 400, 40);//x y w h		

		nome.setBounds(250, 80, 200, 40);//x y w h
		idade.setBounds(250, 110, 170, 40);
		medicoresponsavel.setBounds(250, 140, 200, 40);
		
		nomeCampo.setBounds(390, 90, 310, 20);
		idadeCampo.setBounds(300, 120, 310, 20);
		medicoresponsavelCampo.setBounds(430, 150, 270, 20);
		
	
		btvoltar = new JButton("HOME");
		btconsultarClientes = new JButton("CADASTRAR CLIENTE");
		btenviar = new JButton("PROCURAR");
	
		btvoltar.setBounds(10, 50, 200, 30);
		btconsultarClientes.setBounds(10, 100, 200, 30);	
		btenviar.setBounds(250, 300, 150, 30);
		
		btvoltar.setBackground(Color.white);
		btvoltar.setOpaque(true);
		btvoltar.setForeground(new Color(0, 0, 0));
		btvoltar.setRequestFocusEnabled(false);
		btvoltar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(224, 224, 224), 2));
		
		btconsultarClientes.setBackground(Color.white);
		btconsultarClientes.setOpaque(true);
		btconsultarClientes.setForeground(new Color(0, 0, 0));
		btconsultarClientes.setRequestFocusEnabled(false);
		btconsultarClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(224, 224, 224), 2));
		

		add(nomedoformulario);
		add(background);
		add(nome);
		add(idade);
		add(medicoresponsavel);
		add(nomeCampo);
		add(idadeCampo);
		add(medicoresponsavelCampo);
		

		add(btvoltar);

		add(btconsultarClientes);
		add(btenviar);
	}
	
	
	@Override
	public void setupEvents() {
		
		btconsultarClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				telainit.trocarTela("formConsultarClientes");
			}
		});
		
		
		btvoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telainit.trocarTela("formHome");
			}
		});
		
		
	}
}