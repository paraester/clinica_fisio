package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;

//import javax.swing.Icon;
//import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import Control.Register;

public class MainFrame extends JFrame implements VisualWindow {
	private Register register;
	private JMenuBar menuBar;
	private JMenu menuCliente;
	private JMenu menuConsulta;
	private JMenu menuFuncionarios;
	private JMenu menuRelatorios;
	private JMenuItem relatorioAulas, relatorioPacientes, relatorioFuncionarios, cadastrarFuncionarios,
			atualizarFuncionarios, cadastrarcliente, avaliacaocliente, atualizarcliente, consultarClientes,
			consultarAvaliacoes, consultarFuncionarios;
	private CardLayout cl;
	private TelaBase base;
	// private final ImageIcon icon = (new
	// ImageIcon("../View/image/middle.jpg"));
	//private Icon icon = new ImageIcon("/images/middle.gif");

	public MainFrame() {
		setupLayout();
		setupComponentes();
		setupEvents();
	}

	@Override
	public void setupLayout() {
		setTitle("Clínica de Fisioterapia");
		setLayout(null); // fixo
		setVisible(true);
		setSize(850, 600);
		setLayout(new BorderLayout());
		setResizable(false);// para desabilitar o botão maximizar
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void setupComponentes() {
		register = new Register(); // faz o acesso a base de dados
		menuBar = new JMenuBar(); // menu

		menuCliente = new JMenu("Paciente");
		menuCliente.setMnemonic(KeyEvent.VK_P);// ALT+P

		cadastrarcliente = new JMenuItem("Cadastrar", KeyEvent.VK_C);
		KeyStroke f2KeyStroke = KeyStroke.getKeyStroke("F2");
		cadastrarcliente.setAccelerator(f2KeyStroke);

		menuCliente.addSeparator();
		avaliacaocliente = new JMenuItem("Avaliar", KeyEvent.VK_A);
		KeyStroke f3KeyStroke = KeyStroke.getKeyStroke("F3");
		avaliacaocliente.setAccelerator(f3KeyStroke);

		menuCliente.addSeparator();
		atualizarcliente = new JMenuItem("Atualizar", KeyEvent.VK_T);
		KeyStroke f4KeyStroke = KeyStroke.getKeyStroke("F4");
		atualizarcliente.setAccelerator(f4KeyStroke);

		menuCliente.add(cadastrarcliente);
		menuCliente.add(avaliacaocliente);
		menuCliente.add(atualizarcliente);
		menuBar.add(menuCliente);
		// inicio menuConsulta
		menuConsulta = new JMenu("Consultar");
		menuConsulta.setMnemonic(KeyEvent.VK_C);// ALT+C

		consultarClientes = new JMenuItem("Paciente", KeyEvent.VK_P);
		KeyStroke f5KeyStroke = KeyStroke.getKeyStroke("F5");
		consultarClientes.setAccelerator(f5KeyStroke);

		consultarAvaliacoes = new JMenuItem("Avaliações", KeyEvent.VK_A);
		KeyStroke f6KeyStroke = KeyStroke.getKeyStroke("F6");
		consultarAvaliacoes.setAccelerator(f6KeyStroke);

		consultarFuncionarios = new JMenuItem("Funcionários", KeyEvent.VK_F);
		KeyStroke f7KeyStroke = KeyStroke.getKeyStroke("F7");
		consultarFuncionarios.setAccelerator(f7KeyStroke);

		menuConsulta.add(consultarClientes); // ClientFormConsultarClientes
		menuConsulta.add(consultarAvaliacoes);// ClientFormConsultarAvaliacoes
		menuConsulta.add(consultarFuncionarios);// ClientFormConsultarAvaliacoes
		menuBar.add(menuConsulta);
		// fim menuConsulta
		// inicio menuFuncionarios
		menuFuncionarios = new JMenu("Funcionários");
		menuFuncionarios.setMnemonic(KeyEvent.VK_F);// ALT+F

		cadastrarFuncionarios = new JMenuItem("Cadastrar", KeyEvent.VK_C);
		KeyStroke f8KeyStroke = KeyStroke.getKeyStroke("F8");
		cadastrarFuncionarios.setAccelerator(f8KeyStroke);

		atualizarFuncionarios = new JMenuItem("Atualizar", KeyEvent.VK_T);
		KeyStroke f9KeyStroke = KeyStroke.getKeyStroke("F9");
		atualizarFuncionarios.setAccelerator(f9KeyStroke);

		menuFuncionarios.add(cadastrarFuncionarios);
		menuFuncionarios.add(atualizarFuncionarios);
		menuBar.add(menuFuncionarios);
		// fim menuConsulta
		// inicio menuRelatorios
		menuRelatorios = new JMenu("Relatórios");
		menuRelatorios.setMnemonic(KeyEvent.VK_F);// ALT+R
		relatorioAulas = new JMenuItem("Pilates");
		relatorioPacientes = new JMenuItem("Pacientes");
		relatorioFuncionarios = new JMenuItem("Funcionários");

		menuRelatorios.add(relatorioAulas);
		menuRelatorios.add(relatorioPacientes);
		menuRelatorios.add(relatorioFuncionarios);
		menuBar.add(menuRelatorios);
		// fim menuConsulta

		setJMenuBar(menuBar);
		revalidate();
		base = new TelaBase(this, register);
		cl = new CardLayout();
		cl = (CardLayout) base.getLayout();

		add(base, BorderLayout.CENTER);

		cadastrarFuncionarios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(base, "formCadastroFuncionarios");
			}
		});

		cadastrarcliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(base, "formCadastroClientes");
			}
		});
		avaliacaocliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(base, "formAvali");
			}
		});
		consultarClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(base, "formConsultarClientes");
			}
		});
		consultarAvaliacoes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(base, "formConsultarAvaliacoes");
			}
		});// faz a busca pelo nome do paciente depois chama a classe
			// ClientFormAtualizarCliente
		atualizarcliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(base, "ClientFormAtualizarCliente");
			}
		});
		atualizarFuncionarios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(base, "formClientBuscaFuncionario");
			}
		});
		consultarFuncionarios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(base, "ClientFormConsultarFuncionarios");
			}
		});

	}

	@Override
	public void setupEvents() {

	}

	public void trocarTela(String tela) {
		cl.show(base, tela);
	}
}