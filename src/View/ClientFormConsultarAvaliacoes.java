package View;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
//import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Control.Register;
import Model.ClientCadastro;

public class ClientFormConsultarAvaliacoes extends JPanel implements VisualWindow {
	private final ImageIcon IMAGE_BACKGROUND = new ImageIcon(
			getClass().getResource("/images/alegrainferioresquerdoBusca.jpg"));
	private JButton btvoltar;
	private JButton btconsultarClientes;
	private JButton btenviar;

	private MainFrame telainit;
	private Register register;

	private JLabel nome; // que veio do banco de dados
	private JLabel idade; // que veio do banco de dados
	private JLabel medicoresponsavel; // que veio do banco de dados
	private JLabel nomedoformulario;
	private JLabel especialidade;
	private JTextField especialidadeCampo;
	private JLabel sexo; // que veio do banco de dados
	private JTextField sexoCampo;
	private JTextField nomeCampo;
	private JTextField idadeCampo;
	private JTextField medicoresponsavelCampo;

	private JPanel gridListagem;
	private JTable tabelaJTable;
	private JScrollPane tableContainer;
	// private DefaultTableModel tabelaInterno;
	// private Object [][] dados;
	private TabelaAvaliacoes tabelaAvaliacoes;

	private JPopupMenu popupOpcoes;// DigitandoEaparecendo
	private ActionListener menuListener;// DigitandoEaparecendo
	private String nomeBuscado = "";// DigitandoEaparecendo
	private ClientCadastro clientecadastro; // DigitandoEaparecendo

	public ClientFormConsultarAvaliacoes(MainFrame telainit, Register register) {
		this.telainit = telainit;
		this.register = register;
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
		nomedoformulario = new JLabel("CONSULTAR AVALIAÇÕES CADASTRADAS  ");
		nomedoformulario.setHorizontalAlignment(SwingConstants.CENTER);
		nomedoformulario.setBounds(250, 50, 570, 20);
		nomedoformulario.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 150), 2));
		nomedoformulario.setBorder(
				javax.swing.BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.lightGray, Color.lightGray));
		nomedoformulario.setForeground(Color.black);
		nomedoformulario.setFont(new Font("Serifa", Font.CENTER_BASELINE, 12));

		nome = new JLabel("Paciente: ");
		nome.setBounds(250, 90, 200, 20);// x y w h
		nomeCampo = new JTextField(250);
		nomeCampo.setBounds(320, 90, 500, 20);

		// idade = new JLabel("Idade: " + clientecadastro.getIdade());
		idade = new JLabel("Idade: ");
		idade.setBounds(250, 130, 170, 20);
		idadeCampo = new JTextField(100);
		idadeCampo.setBounds(300, 130, 50, 20);

		sexo = new JLabel("Sexo: ");
		sexo.setBounds(360, 130, 80, 20);
		sexoCampo = new JTextField(100);
		sexoCampo.setBounds(400, 130, 80, 20);

		especialidade = new JLabel("Especialidade: ");
		especialidade.setBounds(490, 130, 150, 20);
		especialidadeCampo = new JTextField(100);
		especialidadeCampo.setBounds(600, 130, 220, 20);

		medicoresponsavel = new JLabel("Médico responsável: ");
		medicoresponsavel.setBounds(250, 170, 200, 20);// x y w h
		medicoresponsavelCampo = new JTextField(100);
		medicoresponsavelCampo.setBounds(400, 170, 420, 20);

		btvoltar = new JButton("HOME");
		btconsultarClientes = new JButton("CADASTRAR CLIENTE");

		btenviar = new JButton("PROCURAR");
		btenviar.setBounds(450, 200, 150, 30);

		btvoltar.setBounds(10, 50, 200, 30);
		btconsultarClientes.setBounds(10, 100, 200, 30);

		btvoltar.setBackground(Color.white);
		btvoltar.setOpaque(true);
		btvoltar.setForeground(new Color(0, 0, 0));
		btvoltar.setRequestFocusEnabled(false);
		// btvoltar.setBorderPainted(false);
		btvoltar.setContentAreaFilled(false);
		btvoltar.setFocusPainted(false);
		btvoltar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(255, 255, 225), 2));

		btconsultarClientes.setBackground(Color.white);
		btconsultarClientes.setOpaque(true);
		btconsultarClientes.setForeground(new Color(0, 0, 0));
		btconsultarClientes.setRequestFocusEnabled(false);
		btconsultarClientes.setContentAreaFilled(false);
		btconsultarClientes.setFocusPainted(false);
		btconsultarClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(255, 255, 225), 2));

		add(nomedoformulario);
		add(nome);
		add(idade);
		add(sexo);
		add(sexoCampo);
		add(medicoresponsavel);
		add(nomeCampo);
		add(idadeCampo);
		add(medicoresponsavelCampo);
		add(especialidade);
		add(especialidadeCampo);

		add(btvoltar);
		add(btconsultarClientes);
		add(btenviar);

		// cria o modelo de Produto
		tabelaAvaliacoes = new TabelaAvaliacoes();

		// atribui o modelo à tabela
		tabelaJTable = new JTable(tabelaAvaliacoes);

		tableContainer = new JScrollPane(tabelaJTable);
		gridListagem = new JPanel();
		// gridListagem.setBackground(Color.blue);
		// gridListagem.setVisible(true);
		gridListagem.setLayout(new BorderLayout());
		gridListagem.setBounds(10, 250, 830, 290);

		// ate somar 780 de largura dada acima
		for (int i = 0; i < tabelaAvaliacoes.getColumnCount(); i++) {
			TableColumn column = tabelaJTable.getColumnModel().getColumn(i);
			if (i == 0)
				column.setPreferredWidth(260); // nome
			if (i == 1)
				column.setPreferredWidth(40); // idade
			if (i == 2)
				column.setPreferredWidth(110); // medico
			if (i == 3)
				column.setPreferredWidth(80); // medicamento
			if (i == 4)
				column.setPreferredWidth(310); // observação
		}
		gridListagem.add(tableContainer, BorderLayout.CENTER);
		gridListagem.setVisible(false);
		add(gridListagem);

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
			@Override
			public void actionPerformed(ActionEvent e) {
				telainit.trocarTela("formHome");
			}
		});

		btenviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exibirListaEncontrada();
			}
		});

		// DigitandoEaparecendo
		// monitorar se foi escrito algo no campo nomecampo
		nomeCampo.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent e) {
				mostrarOpcoesNomes(nomeCampo.getText().trim(), "changedUpdate");
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				mostrarOpcoesNomes(nomeCampo.getText().trim(), "removeUpdate");
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				mostrarOpcoesNomes(nomeCampo.getText().trim(), "insertUpdate");
			}
		});
		
		// para escutar escolha de nomes nas opcoes
		menuListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String clienteClicado = event.getActionCommand();
				// System.out.println("Popup menu item ["+ clienteClicado + "]
				// was pressed.");
				preencherFormComCliente(clienteClicado);
			}
		};

	}

	public void exibirListaEncontrada() {
		ArrayList<ArrayList<String>> matrizClientes;
		// limpar tabela antes de nova busca??
		tabelaAvaliacoes.zerar();
		matrizClientes = register.buscaListaClientes(1, nomeCampo.getText(), idadeCampo.getText(), sexoCampo.getText(),
				especialidadeCampo.getText(), medicoresponsavelCampo.getText());
		gridListagem.setVisible(true);

		tabelaAvaliacoes.renovar(matrizClientes);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image img = IMAGE_BACKGROUND.getImage();
		g.drawImage(img, 0, 0, this);
	}

	// DigitandoEaparecendo
	public void preencherFormComCliente(String clienteClicado) {
		clientecadastro = register.getClientByName(clienteClicado); // pegar
																	// cliente
		nomeBuscado = clientecadastro.getNome(); // para evitar nova busca
		nomeCampo.setText(clientecadastro.getNome());
	}

	// DigitandoEaparecendo
	public void mostrarOpcoesNomes(String nomeParte, String op) {
		String cliente;
		popupOpcoes = new JPopupMenu();

		if (nomeParte.equals(nomeBuscado)) {
			return;
		}
		if (!(nomeParte.equals(""))) {
			// Buscar na base de dados esse cliente nomeParte
			ArrayList<String> algunsClientes = register.getFewClients(nomeParte);

			for (int i = 0; i < algunsClientes.size(); i++) {
				cliente = algunsClientes.get(i);
				JMenuItem item = new JMenuItem(cliente);
				item.addActionListener(menuListener);
				popupOpcoes.add(item);
			}

			// para nao buscar duas vezes o mesmo texto seguidamente
			nomeBuscado = nomeParte;
		}
		popupOpcoes.setVisible(true);
		popupOpcoes.setFocusable(false);
		try {
			popupOpcoes.show(nomeCampo, 10, 20);
		} catch (Exception e1) {
			System.err.println(e1.getClass().getName() + ": " + e1.getMessage());
			System.out.println("erro em popupOpcoes ao tentar método show");
		}
	}

}