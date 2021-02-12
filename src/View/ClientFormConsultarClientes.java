package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
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

public class ClientFormConsultarClientes extends JPanel implements VisualWindow {
	private JButton btvoltar;
	private JButton btcadastro;
	private JButton btavaliacao;
	private JButton btenviar;
	private MainFrame telainit;
	private Register register;
	private JLabel nome; // que veio do banco de dados
	private JLabel idade; // que veio do banco de dados
	private JLabel sexo; // que veio do banco de dados
	private JLabel medicoresponsavel; // que veio do banco de dados
	private JLabel especialidade;
	private final ImageIcon IMAGE_BACKGROUND = new ImageIcon(
			getClass().getResource("/images/alegrainferioresquerdoBusca.jpg"));

	private JLabel nomedoformulario;
	private JTextField nomeCampo;
	private JTextField idadeCampo;
	private JTextField sexoCampo;
	private JTextField medicoresponsavelCampo;
	private JTextField especialidadeCampo;

	private JPanel gridListagem;
	private JTable tabelaJTable;
	private JScrollPane tableContainer;
	// private DefaultTableModel tabelaInterno;
	// private Object [][] dados;
	private TabelaClientes tabelaClientes;

	private JPopupMenu popupOpcoes;// DigitandoEaparecendo
	private ActionListener menuListener;// DigitandoEaparecendo
	private String nomeBuscado = "";// DigitandoEaparecendo
	private ClientCadastro clientecadastro; // DigitandoEaparecendo

	public ClientFormConsultarClientes(MainFrame telainit, Register register) {
		this.telainit = telainit;
		this.register = register;
		clientecadastro = register.getClient(1); // pegar cliente de id 1
		setupLayout();
		setupComponentes();
		setupEvents();
	}

	@Override
	public void setupLayout() {
		setLayout(null); // fixo
		// ImageIcon icon = (new
		// ImageIcon(MainFrame.class.getResource("../View/image/middle.gif")));
		setBackground(Color.white);
		setVisible(true);
		setSize(800, 550);
	}

	@Override
	public void setupComponentes() {
		nomedoformulario = new JLabel("FORMULÁRIO PARA CONSULTAR PACIENTES CADASTRADOS");
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
		btcadastro = new JButton("CADASTRAR CLIENTE");
		btavaliacao = new JButton("FAZER AVALIAÇÃO");
		btenviar = new JButton("PROCURAR");
		btenviar.setBounds(450, 200, 150, 30);

		btvoltar.setBounds(10, 50, 200, 30);
		btavaliacao.setBounds(10, 100, 200, 30);
		btcadastro.setBounds(10, 150, 200, 30);

		btvoltar.setBackground(Color.white);
		btvoltar.setOpaque(true);
		btvoltar.setForeground(new Color(0, 0, 0));
		btvoltar.setRequestFocusEnabled(false);
		// btvoltar.setBorderPainted(false);
		btvoltar.setContentAreaFilled(false);
		btvoltar.setFocusPainted(false);
		btvoltar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(255, 255, 225), 2));

		btavaliacao.setBackground(Color.white);
		btavaliacao.setOpaque(true);
		btavaliacao.setForeground(new Color(0, 0, 0));
		btavaliacao.setRequestFocusEnabled(false);
		// btavaliacao.setBorderPainted(false);
		btavaliacao.setContentAreaFilled(false);
		btavaliacao.setFocusPainted(false);
		btavaliacao.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(255, 255, 225), 2));

		btcadastro.setBackground(Color.white);
		btcadastro.setOpaque(true);
		btcadastro.setForeground(new Color(0, 0, 0));
		btcadastro.setRequestFocusEnabled(false);
		// btvoltar.setBorderPainted(false);
		btcadastro.setContentAreaFilled(false);
		btcadastro.setFocusPainted(false);
		btcadastro.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(255, 255, 225), 2));

		add(nomedoformulario);
		add(nome);
		add(idade);
		add(sexo);
		add(especialidade);
		add(especialidadeCampo);
		add(medicoresponsavel);
		add(nomeCampo);
		add(idadeCampo);
		add(sexoCampo);
		add(medicoresponsavelCampo);

		add(btvoltar);
		add(btavaliacao);
		add(btcadastro);
		add(btenviar);

		// cria o modelo de Produto
		tabelaClientes = new TabelaClientes();
		// atribui o modelo à tabela
		tabelaJTable = new JTable(tabelaClientes);
		tableContainer = new JScrollPane(tabelaJTable);
		gridListagem = new JPanel();
		// gridListagem.setBackground(Color.blue);
		// gridListagem.setVisible(true);
		gridListagem.setLayout(new BorderLayout());
		gridListagem.setBounds(10, 250, 830, 290);

		// ate somar 780 de largura dada acima
		for (int i = 0; i < tabelaClientes.getColumnCount(); i++) {
			TableColumn column = tabelaJTable.getColumnModel().getColumn(i);
			if (i == 0)
				column.setPreferredWidth(260); // nome
			if (i == 1)
				column.setPreferredWidth(40); // idade
			if (i == 2)
				column.setPreferredWidth(110); // telefone
			if (i == 3)
				column.setPreferredWidth(80); // nascimento
			if (i == 4)
				column.setPreferredWidth(100); // especialidade
			if (i == 5)
				column.setPreferredWidth(210); // medico
		}
		gridListagem.add(tableContainer, BorderLayout.CENTER);
		gridListagem.setVisible(false);
		add(gridListagem);
	}

	public void exibirListaEncontrada() {
		ArrayList<ArrayList<String>> matrizClientes;
		// limpar tabela antes de nova busca??
		tabelaClientes.zerar();
		matrizClientes = register.buscaListaClientes(0, nomeCampo.getText(), idadeCampo.getText(), sexoCampo.getText(),
				especialidadeCampo.getText(), medicoresponsavelCampo.getText());
		gridListagem.setVisible(true);

		tabelaClientes.renovar(matrizClientes);
	}

	@Override
	public void setupEvents() {

		tabelaJTable.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				int row = tabelaJTable.rowAtPoint(e.getPoint());
				int col = tabelaJTable.columnAtPoint(e.getPoint());
				// para etapa 3 pegar o campo e jogar para outra tela e editar
				// ou só mostrar
				System.out.println("CLICADO Value in the cell (" + row + ", " + col + ") clicked :"
						+ tabelaJTable.getValueAt(row, col).toString());
			}
		});

		btenviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exibirListaEncontrada();
			}
		});

		btcadastro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				telainit.trocarTela("formCadastroClientes");
			}
		});

		btavaliacao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				telainit.trocarTela("formAvali");
			}
		});

		btvoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				telainit.trocarTela("formHome");
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
		//DigitandoEaparecendo
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