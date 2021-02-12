package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Graphics;
import java.awt.Image;

//import Control.Register;
//import Model.ClientCadastro;

public class ClientFormCadastroFuncionarios extends JPanel implements VisualWindow {
	// private final ImageIcon IMAGE_BACKGROUND = new
	// ImageIcon(getClass().getResource("/images/alegra.jpg"));
	private final ImageIcon IMAGE_BACKGROUND = new ImageIcon(
			getClass().getResource("/images/alegrainferioresquerdo.jpg"));
	private JButton btvoltar;
	private JButton btenviar;
	private JLabel nomedoformulario;
	private JLabel nome;
	private JLabel idade;
	private JLabel sexo;
	String[] sexxo = new String[] { " ", "Feminino", "Masculino" };
	private JTextField nomeCampo;
	// private JTextArea nomeCampo;

	private JTextField idadeCampo;
	private JComboBox<String> comboSexo;
	// private JTextField enderecoCampo;
	// private JTextField datanascimentoCampo;
	// private JPopupMenu textPopupMenu;
	private MainFrame telainit;

	// private Register register;
	// private ClientCadastro clientecadastro;
	// public ClientFormCadastroFuncionarios(MainFrame telainit, Register
	// register){
	public ClientFormCadastroFuncionarios(MainFrame telainit) {
		// this.register = register;
		this.telainit = telainit;
		// clientecadastro = register.getClient(1); //pegar cliente de id 1
		setupLayout();
		setupComponentes();
		setupEvents();
	}

	@Override
	public void setupLayout() {
		setLayout(null); // fixo
		// background=new JLabel("../View/image/middle.jpg");

		// ImageIcon icon = (new
		// ImageIcon(MainFrame.class.getResource("../View/image/middle.gif")));
		setBackground(Color.white);
		setVisible(true);
		setSize(800, 550);
	}

	@Override
	public void setupComponentes() {
		nomedoformulario = new JLabel("<em construçao>Cadastro de Funcionários<em construçao>");
		nomedoformulario.setBounds(250, 50, 570, 30);
		nomedoformulario.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(204, 50, 153), 2));
		// nomedoformulario.setBorder(javax.swing.BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.lightGray,
		// Color.lightGray));
		nomedoformulario.setForeground(Color.black);
		nomedoformulario.setFont(new Font("Serifa", Font.CENTER_BASELINE, 15));

		nome = new JLabel("Nome do funcionário: ");
		nome.setBounds(250, 80, 400, 40);// x y w h
		nomeCampo = new JTextField(250);
		// nomeCampo = new JTextArea("txt interno holder");
		nomeCampo.setBounds(410, 90, 300, 20);

		sexo = new JLabel("Sexo: ");
		sexo.setBounds(250, 140, 200, 40);
		comboSexo = new JComboBox<String>(sexxo);
		comboSexo.setBounds(300, 150, 150, 20);

		idade = new JLabel("Idade: ");
		idade.setBounds(490, 140, 100, 40);
		idadeCampo = new JTextField(100);
		idadeCampo.setBounds(540, 150, 100, 20);

		btvoltar = new JButton("HOME");
		btenviar = new JButton("SALVAR");
		btvoltar.setBounds(10, 50, 200, 30);
		btenviar.setBounds(250, 420, 100, 30);

		btvoltar.setBackground(Color.white);
		btvoltar.setOpaque(true);
		btvoltar.setForeground(new Color(0, 0, 0));
		btvoltar.setRequestFocusEnabled(false);
		// btvoltar.setBorderPainted(false);
		btvoltar.setContentAreaFilled(false);
		btvoltar.setFocusPainted(false);
		btvoltar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(255, 255, 225), 2));

		add(nomedoformulario);
		// add(background);
		add(nome);
		add(nomeCampo);
		add(sexo);
		add(comboSexo);
		add(idade);
		add(idadeCampo);

		add(btvoltar);
		add(btenviar);

	}

	@Override
	public void setupEvents() {
		nomeCampo.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent e) {
				System.out.println("changedUpdate recebido com texto " + nomeCampo.getText().trim());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				System.out.println("removeUpdate recebido com texto " + nomeCampo.getText().trim());
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				System.out.println("insertUpdate recebido com texto " + nomeCampo.getText().trim());
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
				System.out.println("Iniciar salvamento do funcionário " + nomeCampo.getText());
				// clientecadastro = new ClientCadastro();

				// clientecadastro.setNome(nomeCampo.getText());

				// se nao foi vazio o idadeCampo.getText() dai converter pra
				// inteiro
				// if (idadeCampo.getText().equals("")) {
				// clientecadastro.setIdade(0);
				// } else {
				// clientecadastro.setIdade(Integer.parseInt(idadeCampo.getText()));
				// }

				// clientecadastro.setEndereco(enderecoCampo.getText());
				// clientecadastro.setDatanascimento(jFormatteddatanascimento.getText());

				// String tmpSexo = sexxo[comboSexo.getSelectedIndex()];
				// clientecadastro.setSexo(tmpSexo);

				// clientecadastro.setDatanascimento(jFormatteddatainiciotratamentoCampo.getText());

				// System.out.println("enviar para salvamento do cliente " +
				// nomeCampo.getText());
				// register.salveCliente(clientecadastro);
				// salveCliente(clientecadastro);
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