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

	public class ClientFormConsultar extends JPanel implements VisualWindow{
		private JButton btconsultarClientes;
		private JButton btconsultarAvaliacoes;
		private JButton btconsultar;
		private JButton btvoltar;
		private JLabel nomedoformulario;
		private MainFrame telainit;
		private ImageIcon icon;
		
		public ClientFormConsultar(MainFrame telainit){
			this.telainit = telainit;
			setupLayout();
			setupComponentes();
			setupEvents();
			
		}
		
		@Override
		public void setupLayout() {
			setLayout(null); // fixo
			setVisible(true);
			setBackground(Color.white);
			setSize(800, 600);
		
		}
		@Override
		public void setupComponentes() {
			nomedoformulario = new JLabel("CONSULTAR");
			nomedoformulario.setForeground(Color.MAGENTA); 
			nomedoformulario.setFont(new Font("Serifa", Font.BOLD, 25));
		//	nome = new JLabel("Nome do paciente: ");
		//	nomeCampo = new JTextField(200);
			
			nomedoformulario.setBounds(300, 50, 400, 40);//x y w h		

		//	nome.setBounds(250, 80, 200, 40);//x y w h
		//	nomeCampo.setBounds(250, 110, 170, 40);
			btvoltar = new JButton("HOME");
			btconsultarClientes = new JButton("CLIENTES");
			btconsultarAvaliacoes = new JButton("AVALIAÇÕES");
			btvoltar.setBounds(10, 50, 200, 30);
			btconsultarClientes.setBounds(10, 100, 200, 30);
			btconsultarAvaliacoes.setBounds(10, 150, 200, 30);
			
			btvoltar.setBackground(Color.white);
			btvoltar.setOpaque(true);
			btvoltar.setForeground(new Color(0, 0, 0));
			btvoltar.setRequestFocusEnabled(false);
			btvoltar.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(224, 224, 224), 2));
			
			btconsultarClientes.setBackground(Color.white);
			btconsultarClientes.setOpaque(true);
			btconsultarClientes.setForeground(new Color(0, 0, 0));
			btconsultarClientes.setRequestFocusEnabled(false);
			btconsultarClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(224, 224, 224), 2));

			btconsultarAvaliacoes.setBackground(Color.white);
			btconsultarAvaliacoes.setOpaque(true);
			btconsultarAvaliacoes.setForeground(new Color(0, 0, 0));
			btconsultarAvaliacoes.setRequestFocusEnabled(false);
			btconsultarAvaliacoes.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(224, 224, 224), 2));
			
			add(nomedoformulario);
		//	add(nome);
		//	add(nomeCampo);
			add(btvoltar);
			add(btconsultarClientes);
			add(btconsultarAvaliacoes);
			fundoTela();
		}
		
		
		@Override
		public void setupEvents() {
			btvoltar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					telainit.trocarTela("formHome");
				}
			});
			btconsultarClientes.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					telainit.trocarTela("formConsultarClientes");
				}
			});
			
			btconsultarAvaliacoes.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					telainit.trocarTela("formConsultarAvaliacoes");
				}
			});
			
		}
		public void fundoTela() {
			JLabel fundo;
			ImageIcon icon = new ImageIcon("src/images/alegra.jpg");
			fundo = new JLabel(icon);
			fundo.setBounds(250, 70, 400, 400);
			fundo.setVisible(true);
			add(fundo);
		}

	}