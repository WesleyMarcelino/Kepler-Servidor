package telas;

import informacoes.Informacoes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import objetos.Equipe;
import principal.KeplerSrv;
import servidor.Enviador;
import servidor.Recebidor;
import servidor.Servidor;

public class TelaDeChat extends JFrame implements Runnable {
	   private static long idTelaDechat ;
	   private InputStream cliente;
	   private static Servidor servidor;
	   private static  Equipe equipe;
	   private static JPanel campoDeMensagem;
	   private static JButton botaoEnviarMensagem;
	   private static JTextField escritaDeMensagem;
	   private static JPanel campoDeConversa;
	   private JPanel atualizaCampoDeConversa;
	   private static JTextArea conversas = new JTextArea();
	   // private JTextField envioPeloServidor;
	  // private JTextField recebidoPeloServidor;
	   private Recebidor recebidor;
	   private String origem;
	   private String mensagem;
	   private static String mensagemDoCliente = null;
	   
	public TelaDeChat(Equipe equipe, InputStream cliente, Servidor servidor){
		TelaDeChat.equipe = equipe;
		this.cliente = cliente;
		this.servidor = servidor;
		Enviador enviador = new Enviador(servidor);
		Thread threadDeEnvio = new Thread(enviador);
		threadDeEnvio.start();
		this.setTitle(equipe.getNome());
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.add(campoDeConversa(), BorderLayout.CENTER);
		this.add(CampoDeMensagem(), BorderLayout.SOUTH);
		this.setSize(800,600);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		}
	
	
	
	
	
	public static JPanel CampoDeMensagem(){
		FlowLayout layoutCampoDeMensagem = new FlowLayout();
		campoDeMensagem = new JPanel();
		campoDeMensagem.setLayout(layoutCampoDeMensagem);
		escritaDeMensagem = new JTextField(60);
		escritaDeMensagem.setText("Digite aqui sua mensagem");
		botaoEnviarMensagem = new JButton();
		botaoEnviarMensagem.addActionListener( new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
          enviaMensagemGrafica(escritaDeMensagem.getText().toString());
          atualizaCampoDeConversa("servidor",escritaDeMensagem.getText());
          campoDeConversa.repaint();
          escritaDeMensagem.setText("");
            }  
   }); 
		botaoEnviarMensagem.setText("Enviar");
		campoDeMensagem.add(escritaDeMensagem);
		campoDeMensagem.add(botaoEnviarMensagem);
		return campoDeMensagem;
	}
	
	public JPanel campoDeConversa(){
		campoDeConversa = new JPanel();
		conversas.setEditable(false);
		campoDeConversa.add(conversas);
		return campoDeConversa;
	}
	

	public static JPanel atualizaCampoDeConversa(String origem , String mensagem){
		String conversasAnteriores = conversas.getText();
		if (origem.equals("servidor")){
		conversas.setText(conversasAnteriores+"Você : " + mensagem+"\n");
		return null;
		}
		else if (origem.equals("cliente")){
		System.out.println("vindo do cliente");
		conversas.setText(conversasAnteriores+ equipe.getNome()+" : "+mensagem+"\n");
		return null;
		}
	return null;
	}
	
	
	public static void enviaMensagemGrafica(String mensagem){
	      servidor.enviaMensagem(mensagem);
	}
	
	
	public void enviaMensagemConsole(){
		 Scanner s = new Scanner(this.cliente);
	     while (s.hasNextLine()) {
	     System.out.println(s.nextLine());
	     }
	     s.close();
	}
	
	
	
	public void run() {
		KeplerSrv.getS().esperaMensagem();
		}





	public static String getMensagemDoCliente() {
		System.out.println("dentro do get "+TelaDeChat.mensagemDoCliente);
		return TelaDeChat.mensagemDoCliente;
	}





	public static void setMensagemDoCliente(String mensagemDoCliente) {

		TelaDeChat.mensagemDoCliente = mensagemDoCliente;
		System.out.println("dentro do set "+TelaDeChat.mensagemDoCliente);
		atualizaCampoDeConversa("cliente", TelaDeChat.mensagemDoCliente);
		campoDeConversa.repaint();
		
	}

	   public static long getIdTelaDechat() {
			return idTelaDechat;
		}





		public static void setIdTelaDechat(long idTelaDechat) {
			TelaDeChat.idTelaDechat = idTelaDechat;
		}





}
