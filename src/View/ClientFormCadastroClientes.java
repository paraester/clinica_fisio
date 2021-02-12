package View;

import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import Control.Register;
import Model.ClientCadastro;

public class ClientFormCadastroClientes extends JPanel implements VisualWindow {
	private MainFrame telainit;
	private JButton btvoltar;
	private JButton btavaliacao;
	private JButton btenviar;
	private JButton btlimpar;
	private JLabel nomedoformulario;
	private JLabel linha;
	private JLabel linha1;
	private JLabel nome;
	private JLabel idade;
	private JLabel endereco;
	private JLabel datanascimento;
	private JLabel sexo;
	String[] sexxo = new String[] { " ", "Feminino", "Masculino" };
	private JLabel planosaude;
	private JLabel telefone;
	private JLabel responsavel;
	private JLabel especialidade; // ( ortopedia, neurologia ,pilates)
	// define items in a String array:
	String[] especialidades = new String[] { "Selecione uma", "Ortopedia", "Neurologia", "Pilates", "Outros" };
	private JLabel datainiciotratamento;
	private JLabel datadaavaliacao;
	private JLabel medicoresponsavel;
	private JLabel qtdesessoesrealizadas;

	// private JLabel name;
	private JTextField nomeCampo;
	private JTextField idadeCampo;
	private JTextField enderecoCampo;
	private JTextField planosaudeCampo;
	private JTextField responsavelCampo;
	private JTextField medicoresponsavelCampo;
	private JTextField qtdesessoesrealizadasCampo;

	private JComboBox<String> comboSexo;
	private JComboBox<String> comboEspecialidades;
	private JFormattedTextField jFormattedtelefoneCampo;
	private JFormattedTextField jFormatteddatanascimento;
	private JFormattedTextField jFormatteddatainiciotratamentoCampo;
	private JFormattedTextField jFormatteddatadaavaliacaoCampo;
	// private final ImageIcon IMAGE_BACKGROUND = new
	// ImageIcon(getClass().getResource("/images/alegrainferioresquerdo.jpg"));

	private Register register;
	private ClientCadastro clientecadastro;

	public ClientFormCadastroClientes(MainFrame telainit, Register register) {

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

		nomedoformulario = new JLabel("   Formulário para Cadastro de Clientes");
		nomedoformulario.setBounds(10, 10, 810, 30);
		nomedoformulario.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 150), 2));
		nomedoformulario.setBorder(
				javax.swing.BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.lightGray, Color.lightGray));
		nomedoformulario.setForeground(Color.black);
		nomedoformulario.setFont(new Font("Serifa", Font.CENTER_BASELINE, 15));

		linha1 = new JLabel(" Informações pessoais");
		linha1.setBounds(10, 80, 810, 20);
		linha1.setOpaque(true);
		linha1.setBackground(Color.lightGray);
		linha1.setForeground(Color.BLUE);
		linha1.setFont(new Font("Serifa", Font.CENTER_BASELINE, 12));

		nome = new JLabel("Nome: ");
		// nome.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 0,
		// 0, Color.pink));
		nomeCampo = new JTextField(250);
		nome.setBounds(10, 100, 100, 40);// x y w h
		nomeCampo.setBounds(60, 110, 580, 20);

		sexo = new JLabel("Sexo: ");
		comboSexo = new JComboBox<String>(sexxo);
		// sexoCampo.setBounds(90, 200, 260, 20);
		sexo.setBounds(670, 100, 50, 40);
		comboSexo.setBounds(720, 110, 100, 20);

		endereco = new JLabel("Endereço: ");
		enderecoCampo = new JTextField(200);
		endereco.setBounds(10, 140, 100, 40);
		enderecoCampo.setBounds(90, 150, 550, 20);

		idade = new JLabel("Idade: ");
		idade.setBounds(670, 140, 100, 40);
		// telefoneCampo = new JTextField(40);
		idadeCampo = new JTextField(100);
		idadeCampo.setBounds(720, 150, 100, 20);

		telefone = new JLabel("Telefone: ");
		telefone.setBounds(10, 180, 100, 40);
		MaskFormatter telefoneCampo = null;
		try {
			telefoneCampo = new MaskFormatter("(##)####-####*");
		} catch (ParseException excp) {
			System.err.println("Erro na formatação: " + excp.getMessage());
			System.exit(-1);
		}
		jFormattedtelefoneCampo = new JFormattedTextField(telefoneCampo);
		jFormattedtelefoneCampo.setBounds(85, 190, 120, 20);

		planosaude = new JLabel("Plano de Saúde: ");
		planosaudeCampo = new JTextField(40);
		planosaude.setBounds(210, 190, 130, 20);
		planosaudeCampo.setBounds(330, 190, 230, 20);

		datanascimento = new JLabel("Data de nascimento: ");
		datanascimento.setBounds(570, 190, 210, 20);
		MaskFormatter mascaradatanascimento = null;
		try {
			mascaradatanascimento = new MaskFormatter("##/##/####");
		} catch (ParseException excp) {
			System.err.println("Erro na formatação: " + excp.getMessage());
			System.exit(-1);
		}
		jFormatteddatanascimento = new JFormattedTextField(mascaradatanascimento);
		jFormatteddatanascimento.setBounds(720, 190, 100, 20);

		responsavel = new JLabel("Responsável: ");
		responsavelCampo = new JTextField(40);
		responsavel.setBounds(10, 230, 150, 20);
		responsavelCampo.setBounds(110, 230, 530, 20);

		linha = new JLabel(" Informações específicas");
		linha.setBounds(10, 280, 810, 20);
		// linha.setBorder(javax.swing.BorderFactory.createLineBorder(new
		// Color(0, 0, 0), 1));
		linha.setOpaque(true);
		linha.setBackground(Color.lightGray);
		linha.setForeground(Color.BLUE);
		linha.setFont(new Font("Serifa", Font.CENTER_BASELINE, 12));

		especialidade = new JLabel("Especialidade: ");
		comboEspecialidades = new JComboBox<String>(especialidades);
		especialidade.setBounds(10, 330, 210, 20);
		// especialidadeCampo.setBounds(160, 290, 190, 20);
		comboEspecialidades.setBounds(120, 330, 240, 20);// x y w h

		qtdesessoesrealizadas = new JLabel("Quantidade de sessões realizadas: ");
		qtdesessoesrealizadasCampo = new JTextField(40);
		qtdesessoesrealizadas.setBounds(370, 330, 350, 20);
		qtdesessoesrealizadasCampo.setBounds(630, 330, 50, 20);

		datainiciotratamento = new JLabel("Data início tratamento: ");
		datainiciotratamento.setBounds(10, 380, 210, 20);
		MaskFormatter datainiciotratamentoCampo = null;
		try {
			datainiciotratamentoCampo = new MaskFormatter("##/##/####");
		} catch (ParseException excp) {
			System.err.println("Erro na formatação: " + excp.getMessage());
			System.exit(-1);
		}
		jFormatteddatainiciotratamentoCampo = new JFormattedTextField(datainiciotratamentoCampo);
		jFormatteddatainiciotratamentoCampo.setBounds(180, 380, 180, 20);

		datadaavaliacao = new JLabel("Data Avaliação: ");
		datadaavaliacao.setBounds(400, 380, 340, 20);
		MaskFormatter datadaavaliacaoCampo = null;
		try {
			datadaavaliacaoCampo = new MaskFormatter("##/##/####");
		} catch (ParseException excp) {
			System.err.println("Erro na formatação: " + excp.getMessage());
			System.exit(-1);
		}
		jFormatteddatadaavaliacaoCampo = new JFormattedTextField(datadaavaliacaoCampo);
		jFormatteddatadaavaliacaoCampo.setBounds(550, 380, 200, 20);

		medicoresponsavelCampo = new JTextField(100);
		medicoresponsavel = new JLabel("Médico responsável: ");
		medicoresponsavel.setBounds(10, 430, 200, 20);
		medicoresponsavelCampo.setBounds(170, 430, 650, 20);

		btenviar = new JButton("SALVAR");
		btenviar.setBounds(250, 480, 100, 30);
		btenviar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(95, 159, 159), 2));

		btvoltar = new JButton("HOME");
		btvoltar.setBounds(580, 480, 110, 30); // botao volta pro home
		btvoltar.setBackground(Color.white);
		btvoltar.setOpaque(true);
		btvoltar.setForeground(new Color(0, 0, 0));
		btvoltar.setRequestFocusEnabled(false);
		// btvoltar.setBorderPainted(false);
		btvoltar.setContentAreaFilled(false);
		btvoltar.setFocusPainted(false);
		btvoltar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(95, 159, 159), 2));

		btavaliacao = new JButton("AVALIAÇÃO");
		btavaliacao.setBounds(460, 480, 110, 30);
		btavaliacao.setBackground(Color.white);
		btavaliacao.setOpaque(true);
		btavaliacao.setForeground(new Color(0, 0, 0));
		btavaliacao.setRequestFocusEnabled(false);
		// btavaliacao.setBorderPainted(false);
		btavaliacao.setContentAreaFilled(false);
		btavaliacao.setFocusPainted(false);
		btavaliacao.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(95, 159, 159), 2));

		btlimpar = new JButton("LIMPAR");
		btlimpar.setBounds(360, 480, 90, 30);
		btlimpar.setContentAreaFilled(false);
		btlimpar.setFocusPainted(false);
		btlimpar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(95, 159, 159), 2));

		add(nomedoformulario, BorderLayout.PAGE_START);
		add(linha1);
		add(nome);
		add(endereco);
		add(telefone);
		add(idade);
		add(datanascimento);
		add(sexo);
		add(comboSexo);
		add(planosaude);
		add(responsavel);
		add(linha);
		add(especialidade);
		add(comboEspecialidades);
		add(datainiciotratamento);
		add(datadaavaliacao);
		add(medicoresponsavel);
		add(qtdesessoesrealizadas);
		add(nomeCampo);
		add(enderecoCampo);
		add(jFormattedtelefoneCampo);
		add(idadeCampo);
		add(jFormatteddatanascimento);
		add(planosaudeCampo);
		add(responsavelCampo);
		add(jFormatteddatainiciotratamentoCampo);
		add(jFormatteddatadaavaliacaoCampo);
		add(medicoresponsavelCampo);
		add(qtdesessoesrealizadasCampo);
		add(btvoltar);
		// add(btavaliacao);
		add(btenviar);
		add(btlimpar);

	}

	@Override
	public void setupEvents() {
		btenviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientecadastro = new ClientCadastro();
				clientecadastro.setNome(nomeCampo.getText());
				// se nao foi fazio o idadeCampo.getText() dai converter pra
				// inteiro
				if (idadeCampo.getText().equals("")) {
					clientecadastro.setIdade(0);
				} else {
					clientecadastro.setIdade(Integer.parseInt(idadeCampo.getText()));
				}
				clientecadastro.setEndereco(enderecoCampo.getText());
				clientecadastro.setDatanascimento(jFormatteddatanascimento.getText());
				String tmpSexo = sexxo[comboSexo.getSelectedIndex()];
				clientecadastro.setSexo(tmpSexo);
				clientecadastro.setPlanosaude(planosaudeCampo.getText());
				clientecadastro.setTelefone(jFormattedtelefoneCampo.getText());
				clientecadastro.setResponsavel(responsavelCampo.getText());
				String tmpEspecialidade = especialidades[comboEspecialidades.getSelectedIndex()];
				if (tmpEspecialidade.equals("Selecione uma")) {
					tmpEspecialidade = "";
				}
				clientecadastro.setEspecialidade(tmpEspecialidade);
				clientecadastro.setDatanascimento(jFormatteddatainiciotratamentoCampo.getText());
				clientecadastro.setDatadaavaliacao(jFormatteddatadaavaliacaoCampo.getText());
				clientecadastro.setMedicoresponsavel(medicoresponsavelCampo.getText());
				if (idadeCampo.getText().equals("")) {
					clientecadastro.setQtdesessoesrealizadas(0);
				} else {
					clientecadastro.setQtdesessoesrealizadas(Integer.parseInt(qtdesessoesrealizadasCampo.getText()));
				}
				// System.out.println("enviar para salvamento do cliente " +
				// nomeCampo.getText());
				if (register.salveCliente(clientecadastro)) {
					limpeCamposPoisSalvou();
				}
			}
		});
		/*
		 * estará disponível na versão 3 com a função salvar o cadastro já
		 * redirecionando para avaliação. Aqui será necessário um nível de
		 * restrição no login, por exemplo esta opção só será visivel pra
		 * médicos btavaliacao.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * telainit.trocarTela("formAvali"); } });
		 * 
		 */
		btvoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				telainit.trocarTela("formHome");
			}
		});
		btlimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				limpeCamposPoisSalvou();
			}
		});

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Image img = IMAGE_BACKGROUND.getImage();
		// g.drawImage(img, 0, 0, this);
	}

	public void salveCliente(ClientCadastro cc) {

		System.out.println("bla bla bla" + cc.getNome());
	}

	public void limpeCamposPoisSalvou() {
		nomeCampo.setText("");
		idadeCampo.setText("");
		enderecoCampo.setText("");
		jFormatteddatanascimento.setText("");
		comboSexo.setSelectedIndex(0);
		planosaudeCampo.setText("");
		jFormattedtelefoneCampo.setText("");
		responsavelCampo.setText("");
		comboEspecialidades.setSelectedIndex(0);
		jFormatteddatainiciotratamentoCampo.setText("");
		jFormatteddatadaavaliacaoCampo.setText("");
		medicoresponsavelCampo.setText("");
		qtdesessoesrealizadasCampo.setText("");

	}

}