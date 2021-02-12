package View;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import Control.Register;


public class MainFrame extends JFrame implements VisualWindow{
	
	private Register register; //controller básico
    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel2;
    // End of variables declaration          
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenu menuConsulta;
	private JMenuItem home, cadastro, avaliacao, consultar, consultarClientes, consultarAvaliacoes;
	private CardLayout cl;
	private TelaBase base;
	private JLabel jLabel1;

    private final ImageIcon icon = (new ImageIcon(MainFrame.class.getResource("../View/image/middle.gif")));
    //private final Icon iconeJar = new ImageIcon(getClass().getResource("../View/image/alegra.jpg")); 
    //outra maneira de adicionar imagem - p1

	public MainFrame(){
		setupLayout();
		setupComponentes();
		setupEvents();
	}

	@Override
	public void setupLayout() {
		setTitle("Clínica de Fisioterapia"); 
		setLayout(null); // fixo
		setVisible(true);
		setSize(800, 600);
		
		setLayout(new BorderLayout()); // gerenciador de layout que organiza os componentes
		//	getContentPane().setBackground(Color.WHITE);
		// serDefault encerra a execuçao do sistema quando fecha a tela	

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}



	@Override
	public void setupComponentes() {
		register = new Register(); // faz o acesso a base de dados

		 //outra maneira de adicionar imagem - p2
		//JLabel rotuloTitulo = new JLabel("Clinica", iconeJar, SwingConstants.CENTER);
		//add(rotuloTitulo);
		menuBar = new JMenuBar(); // menu
		menu = new JMenu("Cliente");

		cadastro = new JMenuItem("Cadastrar", icon);
		avaliacao = new JMenuItem("Avaliação", icon);
		consultar = new JMenuItem("Consultar", icon);

		menu.add(cadastro);
		menu.add(avaliacao);
		menu.add(consultar);
		menuBar.add(menu);
		//add(menuBar, BorderLayout.NORTH);
		
		menuConsulta = new JMenu("Consultar");
	
		consultarClientes = new JMenuItem("Cliente", icon);
		consultarAvaliacoes = new JMenuItem("Avaliações", icon);
		menuConsulta.add(consultarClientes); //ClientFormConsultarClientes
		menuConsulta.add(consultarAvaliacoes);//ClientFormConsultarAvaliacoes
		menuBar.add(menuConsulta);
		
		
		setJMenuBar(menuBar); // USAR SET ou add.(menuBar.....); mesma funçao

		// -----------------------------------
		
	//	register = new ClientForm();
		//add(register, BorderLayout.CENTER);
		revalidate();
		// -------------
		
		base = new TelaBase(this, register);
		cl = new CardLayout();
		cl = (CardLayout)base.getLayout();
		add(base, BorderLayout.CENTER);
		

		 cadastro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(base, "formCadastro");
			}
		});
		 
		 avaliacao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Close funcionando");
				//cl.show(base, "t1");
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
		});
		 
	}

	@Override
	public void setupEvents() {
		
		
	}
	public void trocarTela(String tela){
		cl.show(base, tela);
	}
        
}