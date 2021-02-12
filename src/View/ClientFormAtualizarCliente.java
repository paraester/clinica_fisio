package View;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import Control.Register;
import Model.ClientCadastro;

public class ClientFormAtualizarCliente extends JPanel implements VisualWindow {
	private MainFrame telainit;
	private JButton btvoltar;
	private JButton btavaliacao;
	private JButton btenviar;
	private JLabel nomedoformulario;
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
	private final ImageIcon IMAGE_BACKGROUND = new ImageIcon(
			getClass().getResource("/images/alegrainferioresquerdo.jpg"));

	private Register register;
	private ClientCadastro clientecadastro;

	public ClientFormAtualizarCliente(MainFrame telainit, Register register) {

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

		nomedoformulario = new JLabel("<em construçao>ATUALIZAR CLIENTES <em construçao>");
		nomedoformulario.setBounds(250, 50, 500, 30);
		nomedoformulario.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(204, 50, 153), 2));
		// nomedoformulario.setBorder(javax.swing.BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.lightGray,
		// Color.lightGray));
		nomedoformulario.setForeground(Color.black);
		nomedoformulario.setFont(new Font("Serifa", Font.CENTER_BASELINE, 15));

		nome = new JLabel("Nome: ");
		endereco = new JLabel("Endereço: ");
		telefone = new JLabel("Telefone: ");
		idade = new JLabel("Idade: ");
		datanascimento = new JLabel("Data de nascimento: ");
		sexo = new JLabel("Sexo: ");
		comboSexo = new JComboBox<String>(sexxo);
		planosaude = new JLabel("Plano de Saúde: ");
		responsavel = new JLabel("Responsável: ");
		especialidade = new JLabel("Especialidade: ");
		comboEspecialidades = new JComboBox<String>(especialidades);

		datainiciotratamento = new JLabel("Data início tratamento: ");
		datadaavaliacao = new JLabel("Data Avaliação: ");
		medicoresponsavel = new JLabel("Médico responsável: ");
		qtdesessoesrealizadas = new JLabel("Quantidade de sessões realizadas: ");

		nomeCampo = new JTextField(250);
		enderecoCampo = new JTextField(200);
		idadeCampo = new JTextField(100);
		planosaudeCampo = new JTextField(40);
		responsavelCampo = new JTextField(40);
		medicoresponsavelCampo = new JTextField(100);
		qtdesessoesrealizadasCampo = new JTextField(40);
		nome.setBounds(250, 80, 100, 40);// x y w h
		endereco.setBounds(250, 110, 100, 40);
		telefone.setBounds(250, 140, 100, 40);
		idade.setBounds(250, 170, 100, 40);
		datanascimento.setBounds(250, 210, 210, 20);
		sexo.setBounds(250, 230, 100, 40);
		planosaude.setBounds(250, 270, 130, 20);
		responsavel.setBounds(250, 300, 150, 20);
		especialidade.setBounds(250, 330, 210, 20);
		datainiciotratamento.setBounds(250, 360, 210, 20);
		datadaavaliacao.setBounds(250, 390, 340, 20);
		medicoresponsavel.setBounds(250, 420, 370, 20);
		qtdesessoesrealizadas.setBounds(250, 450, 210, 20);

		nomeCampo.setBounds(300, 90, 300, 20);
		enderecoCampo.setBounds(325, 120, 275, 20);

		MaskFormatter telefoneCampo = null;
		try {
			telefoneCampo = new MaskFormatter("(##)#####-####");
		} catch (ParseException excp) {
			System.err.println("Erro na formatação: " + excp.getMessage());
			System.exit(-1);
		}
		jFormattedtelefoneCampo = new JFormattedTextField(telefoneCampo);
		jFormattedtelefoneCampo.setBounds(320, 150, 280, 20);

		idadeCampo.setBounds(320, 180, 280, 20);

		MaskFormatter mascaradatanascimento = null;
		try {
			mascaradatanascimento = new MaskFormatter("##/##/####");
		} catch (ParseException excp) {
			System.err.println("Erro na formatação: " + excp.getMessage());
			System.exit(-1);
		}
		jFormatteddatanascimento = new JFormattedTextField(mascaradatanascimento);
		jFormatteddatanascimento.setBounds(400, 210, 200, 20);

		// sexoCampo.setBounds(90, 200, 260, 20);
		comboSexo.setBounds(290, 240, 260, 20);
		planosaudeCampo.setBounds(370, 270, 230, 20);
		responsavelCampo.setBounds(350, 300, 250, 20);
		// especialidadeCampo.setBounds(160, 290, 190, 20);
		comboEspecialidades.setBounds(360, 330, 240, 20);// x y w h

		MaskFormatter datainiciotratamentoCampo = null;
		try {
			datainiciotratamentoCampo = new MaskFormatter("##/##/####");
		} catch (ParseException excp) {
			System.err.println("Erro na formatação: " + excp.getMessage());
			System.exit(-1);
		}
		jFormatteddatainiciotratamentoCampo = new JFormattedTextField(datainiciotratamentoCampo);
		jFormatteddatainiciotratamentoCampo.setBounds(420, 360, 180, 20);

		MaskFormatter datadaavaliacaoCampo = null;
		try {
			datadaavaliacaoCampo = new MaskFormatter("##/##/####");
		} catch (ParseException excp) {
			System.err.println("Erro na formatação: " + excp.getMessage());
			System.exit(-1);
		}
		jFormatteddatadaavaliacaoCampo = new JFormattedTextField(datadaavaliacaoCampo);
		jFormatteddatadaavaliacaoCampo.setBounds(400, 390, 200, 20);

		medicoresponsavelCampo.setBounds(420, 420, 180, 20);
		qtdesessoesrealizadasCampo.setBounds(420, 450, 180, 20);

		btvoltar = new JButton("HOME");
		btavaliacao = new JButton("AVALIAÇÃO");
		btenviar = new JButton("SALVAR");

		btvoltar.setBounds(10, 50, 200, 30); // botao volta pro home
		btavaliacao.setBounds(10, 100, 200, 30);
		btenviar.setBounds(250, 480, 100, 30);

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

		add(nomedoformulario, BorderLayout.PAGE_START);
		add(nome);
		add(endereco);
		add(telefone);
		add(idade);
		add(datanascimento);
		add(sexo);
		add(comboSexo);
		add(planosaude);
		add(responsavel);
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
		add(btavaliacao);
		add(btenviar);
	}

	@Override
	public void setupEvents() {
		btenviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Iniciar salvamento do cliente " + nomeCampo.getText());
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
				clientecadastro.setEspecialidade(tmpEspecialidade);

				clientecadastro.setDatanascimento(jFormatteddatainiciotratamentoCampo.getText());

				clientecadastro.setDatadaavaliacao(jFormatteddatadaavaliacaoCampo.getText());

				clientecadastro.setMedicoresponsavel(medicoresponsavelCampo.getText());

				if (idadeCampo.getText().equals("")) {
					clientecadastro.setQtdesessoesrealizadas(0);
				} else {
					clientecadastro.setQtdesessoesrealizadas(Integer.parseInt(qtdesessoesrealizadasCampo.getText()));
				}

				System.out.println("enviar para salvamento do cliente " + nomeCampo.getText());
				register.salveCliente(clientecadastro);
				// salveCliente(clientecadastro);
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
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image img = IMAGE_BACKGROUND.getImage();
		g.drawImage(img, 0, 0, this);
	}

	public void salveCliente(ClientCadastro cc) {

		System.out.println("bla bla bla" + cc.getNome());
	}
}