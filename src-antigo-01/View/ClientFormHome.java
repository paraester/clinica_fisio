
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

import javax.swing.UIManager;
import javax.swing.SwingUtilities;
import java.awt.GridLayout;

import Control.Mensagem;

public class ClientFormHome extends JPanel implements VisualWindow {

	private JLabel mensagem = new JLabel("Médico desta avaliação ");
	private JButton btcadastro = new JButton("CADASTRAR CLIENTE");;
	private JButton btavaliacao = new JButton("FAZER AVALIAÇÃO");
	private JButton btconsultar = new JButton("CONSULTAR");
	private MainFrame telainit;
	private ImageIcon icon;

	private ImageIcon cadastrocliente = (new ImageIcon(MainFrame.class.getResource("../View/image/cadastrarcliente.png")));
	private JButton btcadastrocliente = new JButton();
	private ImageIcon fazeravaliacao = (new ImageIcon(MainFrame.class.getResource("../View/image/botaofundo.jpeg")));
	private JButton btfazeravaliacao = new JButton();
	private ImageIcon fazerconsulta = (new ImageIcon(MainFrame.class.getResource("../View/image/botaofundo.jpeg")));
	private JButton btfazerconsulta = new JButton();

	
	
	public ClientFormHome(MainFrame telainit) {
		this.telainit = telainit; // referencia para o objeto criado
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
		//menu figurass
		btcadastrocliente.setIcon(cadastrocliente);
		//btcadastrocliente.setSize(35, 35);
		btcadastrocliente.setBounds(10, 5, 35, 35);
		btcadastrocliente.setForeground(new Color(0, 0, 0));
		btcadastrocliente.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0), 0));
		
		btfazeravaliacao.setIcon(fazeravaliacao);
		btfazeravaliacao.setBounds(50, 5, 35, 35);
		btfazeravaliacao.setForeground(new Color(0, 0, 0));
		btfazeravaliacao.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0), 0));
		
		btfazerconsulta.setIcon(fazerconsulta);
		btfazerconsulta.setBounds(95, 5, 35, 35);
		btfazerconsulta.setForeground(new Color(0, 0, 0));
		btfazerconsulta.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0), 0));
		
		add(btfazerconsulta);
		add(btfazeravaliacao);
		add(btcadastrocliente);
		//fim menu figurass
		
		  btcadastro.setBackground(Color.white);
	      btcadastro.setOpaque(true);
	      btcadastro.setForeground(new Color(0, 0, 0));
	      btcadastro.setRequestFocusEnabled(false);
	      btcadastro.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(224, 224, 224), 2));
	      
	      btavaliacao.setBackground(Color.white);
	      btavaliacao.setOpaque(true);
	      btavaliacao.setForeground(new Color(0, 0, 0));
	      btavaliacao.setRequestFocusEnabled(false);
	      btavaliacao.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(224, 224, 224), 2));
	   
	      btconsultar.setBackground(Color.white);
	      btconsultar.setOpaque(true);
	      btconsultar.setForeground(new Color(0, 0, 0));
	      btconsultar.setRequestFocusEnabled(false);
	      btavaliacao.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(224, 224, 224), 2));
	      
		btcadastro.setBounds(10, 50, 200, 30);
		btavaliacao.setBounds(10, 100, 200, 30);
		btconsultar.setBounds(10, 150, 200, 30);
        // Defining Panel		
		
		add(btcadastro);
		add(btavaliacao);
		add(btconsultar);

		fundoTela();
	}

	public void fundoTela() {
		JLabel fundo;
		ImageIcon icon = new ImageIcon("src/images/alegra.jpg");
		fundo = new JLabel(icon);
		fundo.setBounds(250, 70, 400, 400);
		fundo.setVisible(true);
		add(fundo);
	}

	@Override
	public void setupEvents() {
		btcadastro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				telainit.trocarTela("formCadastro");
			}
		});
		btavaliacao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				telainit.trocarTela("formAvali");
			}
		});
		btconsultar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				telainit.trocarTela("formConsultar");
			}
		});
		
	}
}