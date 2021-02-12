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

public class ClientFormConsultarClientes extends JPanel implements VisualWindow{
	private JButton btvoltar;
	private JButton btcadastro;
	private JButton btavaliacao;
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

	
	public ClientFormConsultarClientes(MainFrame telainit){
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
		nomedoformulario = new JLabel("PROCURAR CLIENTES");
		nomedoformulario.setForeground(Color.blue);
		nomedoformulario.setFont(new Font("Serifa", Font.BOLD, 20));
		nome = new JLabel("Nome do paciente: ");
		idade = new JLabel("Idade: ");
		sexo = new JLabel("Sexo: ");
					
		medicoresponsavel = new JLabel("Médico desta avaliação: ");
		
		nomedoformulario.setBounds(250, 40, 400, 40);//x y w h		

		nome.setBounds(250, 80, 200, 40);//x y w h
		idade.setBounds(250, 110, 170, 40);
		sexo.setBounds(250, 140, 200, 40);
		medicoresponsavel.setBounds(250, 180, 200, 40);//x y w h	
		
	
		btvoltar = new JButton("HOME");
		btcadastro = new JButton("CADASTRAR CLIENTE");
		btavaliacao = new JButton("FAZER AVALIAÇÃO");
		btenviar = new JButton("PROCURAR");
	
		btvoltar.setBounds(10, 50, 200, 30);
		btavaliacao.setBounds(10, 100, 200, 30);	
		btcadastro.setBounds(10, 150, 200, 30);	
		btenviar.setBounds(250, 220, 150, 30);
		
		btvoltar.setBackground(Color.white);
		btvoltar.setOpaque(true);
		btvoltar.setForeground(new Color(0, 0, 0));
		btvoltar.setRequestFocusEnabled(false);
		btvoltar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(224, 224, 224), 2));
		
		btavaliacao.setBackground(Color.white);
		btavaliacao.setOpaque(true);
		btavaliacao.setForeground(new Color(0, 0, 0));
		btavaliacao.setRequestFocusEnabled(false);
		btavaliacao.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(224, 224, 224), 2));
		
		btcadastro.setBackground(Color.white);
		btcadastro.setOpaque(true);
		btcadastro.setForeground(new Color(0, 0, 0));
		btcadastro.setRequestFocusEnabled(false);
		btcadastro.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(224, 224, 224), 2));
		

		add(nomedoformulario);
		add(background);
		add(nome);
		add(idade);
		add(sexo);
		add(medicoresponsavel);

		add(btvoltar);
		add(btavaliacao);
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
		
		btavaliacao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				telainit.trocarTela("formAvali");
			}
		});
		
		btvoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telainit.trocarTela("formHome");
			}
		});
		
		
	}
}