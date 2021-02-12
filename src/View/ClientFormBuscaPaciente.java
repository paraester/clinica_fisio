package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import java.awt.Graphics;
import java.awt.Image;
import Control.Register;
import Model.ClientCadastro;

public class ClientFormBuscaPaciente extends JPanel implements VisualWindow {
	private final ImageIcon IMAGE_BACKGROUND = new ImageIcon(
			getClass().getResource("/images/alegrainferioresquerdo.jpg"));
	private JButton btvoltar;
	private JButton btcadastro;
	private JButton btbuscar;
	private JLabel nome; // que veio do banco de dados
	private JTextField nomeCampo;
	private JLabel nomedoformulario;
	private MainFrame telainit;
	private Register register;
	private ClientCadastro clientecadastro;

	/*
	 * Esta classe, após a busca no BD, deverá chamar a classe
	 * ClientFormAtualizarCliente
	 */

	public ClientFormBuscaPaciente(MainFrame telainit, Register register) {
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
		nomedoformulario = new JLabel("ATUALIZAR INFORMAÇÕES DO PACIENTE");
		nomedoformulario.setBounds(250, 50, 500, 30);
		nomedoformulario.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 150), 2));
		nomedoformulario.setBorder(
				javax.swing.BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.lightGray, Color.lightGray));
		nomedoformulario.setForeground(Color.black);
		nomedoformulario.setFont(new Font("Serifa", Font.CENTER_BASELINE, 15));
		nome = new JLabel("Nome do paciente: ");
		nomeCampo = new JTextField(clientecadastro.getNome());

		nome.setBounds(250, 180, 400, 40);// x y w h
		nomeCampo.setBounds(400, 190, 300, 20);

		btvoltar = new JButton("HOME");
		btcadastro = new JButton("CADASTRAR CLIENTE");
		btbuscar = new JButton("BUSCAR");
		btvoltar.setBounds(10, 50, 200, 30);
		btcadastro.setBounds(10, 100, 200, 30);
		btbuscar.setBounds(250, 220, 100, 30);

		btcadastro.setBackground(Color.white);
		btcadastro.setOpaque(true);
		btcadastro.setForeground(new Color(0, 0, 0));
		btcadastro.setRequestFocusEnabled(false);
		// btvoltar.setBorderPainted(false);
		btcadastro.setContentAreaFilled(false);
		btcadastro.setFocusPainted(false);
		btcadastro.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(255, 255, 225), 2));

		btvoltar.setBackground(Color.white);
		btvoltar.setOpaque(true);
		btvoltar.setForeground(new Color(0, 0, 0));
		btvoltar.setRequestFocusEnabled(false);
		// btvoltar.setBorderPainted(false);
		btvoltar.setContentAreaFilled(false);
		btvoltar.setFocusPainted(false);
		btvoltar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(255, 255, 225), 2));

		add(nomedoformulario);
		add(nome);
		add(nomeCampo);

		add(btvoltar);
		add(btcadastro);
		add(btbuscar);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image img = IMAGE_BACKGROUND.getImage();
		g.drawImage(img, 0, 0, this);
	}

	@Override
	public void setupEvents() {

		btcadastro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				telainit.trocarTela("formCadastroClientes");
			}
		});
		btvoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				telainit.trocarTela("formHome");
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

}