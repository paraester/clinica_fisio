package View;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Control.Register;
import Model.ClientCadastro;

public class ClientFormConsultarFuncionarios extends JPanel implements VisualWindow {
	private final ImageIcon IMAGE_BACKGROUND = new ImageIcon(
			getClass().getResource("/images/alegrainferioresquerdo.jpg"));

	private JButton btvoltar;
	private JButton btconsultarClientes;
	private JButton btbuscar;
	private MainFrame telainit;
	private JLabel nome; // que veio do banco de dados
	// private JLabel idade; // que veio do banco de dados
	// private JLabel medicoresponsavel; // que veio do banco de dados
	private JLabel nomedoformulario;
	private JTextField nomeCampo;
	private ClientCadastro clientecadastro;
	private Register register;

	public ClientFormConsultarFuncionarios(MainFrame telainit, Register register) {
		this.register = register;
		this.telainit = telainit;
		clientecadastro = register.getClient(1); // pegar cliente de id 1
		setupLayout();
		setupComponentes();
		setupEvents();
	}

	@Override
	public void setupLayout() {
		setLayout(null); // fixo
		setBackground(Color.white);
		setVisible(true);
		setSize(800, 550);

	}

	@Override
	public void setupComponentes() {
		nomedoformulario = new JLabel(" <em construçao> LISTA FUNCIONÁRIOS  <em construçao> ");
		nomedoformulario.setBounds(250, 50, 570, 30);
		nomedoformulario.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(204, 50, 153), 2));
		// nomedoformulario.setBorder(javax.swing.BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.lightGray,
		// Color.lightGray));
		nomedoformulario.setForeground(Color.black);
		nomedoformulario.setFont(new Font("Serifa", Font.CENTER_BASELINE, 15));
		nome = new JLabel("Nome: ");
		nome.setBounds(250, 90, 300, 40);// x y w h
		nomeCampo = new JTextField(clientecadastro.getNome());
		nomeCampo.setBounds(310, 100, 350, 20);

		btbuscar = new JButton("PROCURAR");
		btbuscar.setBounds(670, 100, 120, 20);

		btvoltar = new JButton("HOME");
		btvoltar.setBounds(10, 50, 200, 30);
		btvoltar.setBackground(Color.white);
		btvoltar.setOpaque(true);
		btvoltar.setForeground(new Color(0, 0, 0));
		btvoltar.setRequestFocusEnabled(false);
		// btvoltar.setBorderPainted(false);
		btvoltar.setContentAreaFilled(false);
		btvoltar.setFocusPainted(false);
		btvoltar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(255, 255, 225), 2));

		btconsultarClientes = new JButton("CADASTRAR CLIENTE");
		btconsultarClientes.setBounds(10, 100, 200, 30);
		btconsultarClientes.setBackground(Color.white);
		btconsultarClientes.setOpaque(true);
		btconsultarClientes.setForeground(new Color(0, 0, 0));
		btconsultarClientes.setRequestFocusEnabled(false);
		btconsultarClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(224, 224, 224), 2));

		add(nomedoformulario);
		add(nome);
		add(nomeCampo);

		add(btvoltar);
		add(btconsultarClientes);
		add(btbuscar);
	}

	@Override
	public void setupEvents() {

		btconsultarClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				telainit.trocarTela("formConsultarClientes");
			}
		});

		btbuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientecadastro.setNome(nome.getText());
				register.salveAvaliacao(clientecadastro);
			}
		});

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image img = IMAGE_BACKGROUND.getImage();
		g.drawImage(img, 0, 0, this);
	}

}