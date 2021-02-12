package View;

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
import javax.swing.text.MaskFormatter;
import java.text.ParseException;


public class ClientForm extends JPanel implements VisualWindow{
	private MainFrame telainit;
	private JButton btvoltar;
	private JButton btavaliacao;
	private JButton btenviar;
	private JLabel nomedoformulario;
	private JLabel nome;
	private JLabel idade;
	private JLabel endereco;
	//private JLabel datanascimento;
	private JLabel datanascimento;
	private JLabel sexo;
	String[] sexxo = new String[] {"Feminino", "Masculino"};	
	private JLabel planosaude;
	private JLabel telefone;
	private JLabel responsavel;
	private JLabel especialidade; //( ortopedia, neurologia ,pilates)     
	// define items in a String array:
	String[] especialidades = new String[] {"Ortopedia", "Neurologia", "Pilates", "Outros"};	
	private JLabel datainiciotratamento;
	private JLabel datadaavaliacao;
	private JLabel medicoresponsavel;                         
	private JLabel qtdesessoesrealizadas;
	private JLabel cpfFieldLabel;

	//private JLabel name;
	private JTextField nomeCampo;
	private JTextField idadeCampo;
	private JTextField enderecoCampo;
	private JTextField datanascimentoCampo;
	private JTextField sexoCampo;
	private JTextField planosaudeCampo;
	private JTextField telefoneCampo;
	private JTextField responsavelCampo;
	private JTextField especialidadeCampo; //( ortopedia, neurologia ,pilates)                         
	private JTextField datainiciotratamentoCampo;
	private JTextField datadaavaliacaoCampo;
	private JTextField medicoresponsavelCampo;                         
	private JTextField qtdesessoesrealizadasCampo;
	
	private JFormattedTextField cpfField;
	private JFormattedTextField cepField;
	private JFormattedTextField phoneField;
	
	
	private JButton btnome;
	private JButton btidade;
	private JButton btendereco;
	private JButton btdatanascimento;
	private JButton btsexo; 
	private JButton btplanosaude;
	private JButton bttelefone;
	private JButton btresponsavel;
	private JButton btespecialidade; //( ortopedia, neurologia ,pilates)                         
	private JButton btdatainiciotratamento;
	private JButton btdatadaavaliacao;
	private JButton btmedicoresponsavel;                         
	private JButton btqtdesessoesrealizadas;
	
	public ClientForm(MainFrame telainit){
		this.telainit = telainit;
		setupLayout();
		setupComponentes();
		setupEvents();
	}
	
	@Override
	public void setupLayout(){
		setLayout(null); // fixo
		setBackground(Color.white);
		setVisible(true);
		setSize(800, 550);
	}

	@Override
	public void setupComponentes() {

		nomedoformulario = new JLabel("Cadastro de Clientes");
		nomedoformulario.setForeground(Color.blue);
		nomedoformulario.setFont(new Font("Serifa", Font.BOLD, 20));
		
		nome = new JLabel("Nome: ");
		endereco = new JLabel("Endereço: ");
		telefone = new JLabel("Telefone: ");
		idade = new JLabel("Idade: ");
		datanascimento = new JLabel("Data de nascimento: ");
		sexo = new JLabel("Sexo: ");
		JComboBox<String> comboSexo = new JComboBox<String>(sexxo);
		planosaude = new JLabel("Plano de Saúde: ");
		responsavel = new JLabel("Responsável: ");
		especialidade = new JLabel("Especialidade: ");
		JComboBox<String> comboEspecialidades = new JComboBox<String>(especialidades);
		
		
		datainiciotratamento = new JLabel("Data início tratamento: ");
		datadaavaliacao = new JLabel("Data Avaliação: ");
		medicoresponsavel = new JLabel("Médico responsável: ");                   
		qtdesessoesrealizadas = new JLabel("Quantidade de sessões realizadas: ");
		
		nomeCampo = new JTextField(100);
		enderecoCampo = new JTextField(200);
		telefoneCampo = new JTextField(40);
		idadeCampo = new JTextField(100);
		datanascimentoCampo = new JTextField(100);
	//	sexoCampo = new JTextField(100);
		planosaudeCampo = new JTextField(40);		
		responsavelCampo = new JTextField(40);
	//	especialidadeCampo = new JTextField(40);                
		datainiciotratamentoCampo = new JTextField(100);
		datadaavaliacaoCampo = new JTextField(100);
		medicoresponsavelCampo = new JTextField(100);                         
		qtdesessoesrealizadasCampo = new JTextField(40);	
		
		
		btnome = new JButton("ok nome");
		btendereco  = new JButton("ok endereco");
		bttelefone = new JButton("ok telefone");
		btidade = new JButton("ok idade");
		btdatanascimento = new JButton("ok nascimento");
		btsexo = new JButton("ok sexo");
		btplanosaude = new JButton("ok plano saude");
		btresponsavel = new JButton("ok responsavel");
		btespecialidade = new JButton("ok especialidade");                
		btdatainiciotratamento = new JButton("ok inicio tratamento");
		btdatadaavaliacao = new JButton("ok data avaliação");
		btmedicoresponsavel = new JButton("ok médico responsa");                         
		btqtdesessoesrealizadas = new JButton("ok qtde de sessoes realizadas");

		nomedoformulario.setBounds(250, 40, 400, 40);//x y w h
		nome.setBounds(250, 80, 100, 40);//x y w h
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
		try{
			telefoneCampo = new MaskFormatter("(##)#####-####");
		}
        catch(ParseException excp) {
               System.err.println("Erro na formatação: " + excp.getMessage());
               System.exit(-1);
        }
		JFormattedTextField jFormattedtelefoneCampo = new JFormattedTextField(telefoneCampo);
		jFormattedtelefoneCampo.setBounds(320, 150, 280, 20);
		
		idadeCampo.setBounds(320, 180, 280, 20);


		MaskFormatter mascaradatanascimento = null;
		try{
            mascaradatanascimento = new MaskFormatter("##/##/####");
		}
        catch(ParseException excp) {
               System.err.println("Erro na formatação: " + excp.getMessage());
               System.exit(-1);
        }
		JFormattedTextField jFormatteddatanascimento = new JFormattedTextField(mascaradatanascimento);
		jFormatteddatanascimento.setBounds(400, 210, 200, 20);
		
	//	sexoCampo.setBounds(90, 200, 260, 20);
		comboSexo.setBounds(290, 240, 260, 20);
		planosaudeCampo.setBounds(370, 270, 230, 20);
		responsavelCampo.setBounds(350, 300, 250, 20);                
	//	especialidadeCampo.setBounds(160, 290, 190, 20);
		comboEspecialidades.setBounds(360, 330, 240, 20);//x y w h

		
		MaskFormatter datainiciotratamentoCampo = null;
		try{
			datainiciotratamentoCampo = new MaskFormatter("##/##/####");
		}
        catch(ParseException excp) {
               System.err.println("Erro na formatação: " + excp.getMessage());
               System.exit(-1);
        }
		JFormattedTextField jFormatteddatainiciotratamentoCampo = new JFormattedTextField(datainiciotratamentoCampo);
		jFormatteddatainiciotratamentoCampo.setBounds(420, 360, 180, 20);
		

    
		MaskFormatter datadaavaliacaoCampo = null;
		try{
			datadaavaliacaoCampo = new MaskFormatter("##/##/####");
		}
        catch(ParseException excp) {
               System.err.println("Erro na formatação: " + excp.getMessage());
               System.exit(-1);
        }
		JFormattedTextField jFormatteddatadaavaliacaoCampo = new JFormattedTextField(datadaavaliacaoCampo);
		jFormatteddatadaavaliacaoCampo.setBounds(400, 390, 200, 20); 
		
		
		medicoresponsavelCampo.setBounds(420, 420, 180, 20);
		qtdesessoesrealizadasCampo.setBounds(420, 450, 180, 20);
		
		btvoltar = new JButton("HOME");
		btavaliacao = new JButton("AVALIAÇÃO");
		btenviar = new JButton("SALVAR");
		
		btvoltar.setBounds(10, 50, 200, 30); //botao volta pro home
		btavaliacao.setBounds(10, 100, 200, 30);			
		btenviar.setBounds(250, 480, 100, 30);
	
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
		//add(telefoneCampo);
		add(jFormattedtelefoneCampo);
		add(idadeCampo);
		//add(datanascimentoCampo);
		add(jFormatteddatanascimento);

		add(planosaudeCampo);
		add(responsavelCampo);
	    //add(especialidadeCampo);            
		//add(datainiciotratamentoCampo);
		add(jFormatteddatainiciotratamentoCampo);
		//add(datadaavaliacaoCampo);
		add(jFormatteddatadaavaliacaoCampo);
		add(medicoresponsavelCampo);                         
		add(qtdesessoesrealizadasCampo);
		
		add(btvoltar);
		add(btavaliacao);
		add(btenviar);
		
	}

	@Override
	public void setupEvents() {
		btnome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Nome digitado = " + nomeCampo.getText());
				
			}
		});
		
		btendereco.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Endereço digitado = " + enderecoCampo.getText());
				
			}
		});		
		btidade.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Idade digitada = " + idadeCampo.getText());
				
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
}