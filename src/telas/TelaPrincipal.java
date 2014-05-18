package telas;

import informacoes.Informacoes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import objetos.Equipes;
import objetos.Industrias;
import principal.KeplerSrv;
import servidor.Servidor;

public class TelaPrincipal extends JFrame {
	private JPanel titulo;
	private JLabel textoDoTitulo;
	private JLabel tituloIndustrias;
	private Font fonteTextoDoTitulo;
	private JPanel rodape;
	private JTextField textoRodape;
	private Font fonteTextoRodape;
	private JPanel industria;
	private JPanel chat;
	private JLabel tituloChat;
	private Font fontChat;
	private Font fontTituloChat;
	private JButton[] botoesIndustrias;
	private JButton[] botoesEquipes;
	private JButton adicionarIndustrias;
	
	public TelaPrincipal() throws IOException{
		BorderLayout layoutTelaPrincipal = new BorderLayout();
		this.setTitle(Informacoes.getNomedoprograma()+" "+Informacoes.getVersao());
		this.setLayout(layoutTelaPrincipal);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800,600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);		
		this.add(Titulo(), layoutTelaPrincipal.NORTH);
		this.add(Rodape(),layoutTelaPrincipal.SOUTH);
		this.add(Industrias(),layoutTelaPrincipal.WEST);
		this.add(Chat(), layoutTelaPrincipal.CENTER);
	}
	
	
	private JPanel Industrias(){
		GridLayout layoutIndustrias = new GridLayout(10,1);
		industria = new JPanel();
		industria.setLayout(layoutIndustrias);
		tituloIndustrias = new JLabel();
		tituloIndustrias.setText("Industrias cadastradas : ");
		adicionarIndustrias = new JButton();
		adicionarIndustrias.addActionListener( new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
            	System.out.println("clicou");
             ControladoraDeTelas.mostrarCadastrarIndustrias();
            }  
   }); 
		adicionarIndustrias.setText("Adicionar Industria");
		
		botoesIndustrias = new JButton[Industrias.getIndustrias().size()];
		industria.add(tituloIndustrias);
		for (int i = 0; i < Industrias.getIndustrias().size(); i++){
			criarBotoes(i);
	    	industria.add(botoesIndustrias[i]);
		}
			industria.add(adicionarIndustrias);
		return industria;
	}

	private JButton criarBotoes(final int index) {
		botoesIndustrias[index] = new JButton();
		botoesIndustrias[index].setText(Industrias.getIndustrias().get(index).paraBotao());
		botoesIndustrias[index].addActionListener( new ActionListener() {  
	      public void actionPerformed(ActionEvent e) {
	     System.out.println("debug : Clicou na Industria :" +Industrias.getIndustrias().get(index).getNome());
	     ControladoraDeTelas.mostrarTelaIndustria(Industrias.getIndustrias().get(index));
	       }  
		}); 
		return botoesIndustrias[index];
	}
	private JButton criarBotoesEquipes (final int index) throws IOException {
		botoesEquipes[index] = new JButton();
		KeplerSrv.getS().iniciaChat(Equipes.getEquipes().get(index));
		botoesEquipes[index].setText(Equipes.getEquipes().get(index).paraBotao());
		botoesEquipes[index].addActionListener( new ActionListener() {  
	      public void actionPerformed(ActionEvent e) {
	    	 try {
				KeplerSrv.getS().mostraChat(Equipes.getEquipes().get(index));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	      }  
		}); 
		return botoesEquipes[index];
	}
	
	
	
	
	private JPanel Titulo(){ 
		fonteTextoDoTitulo = new Font("Calibri", Font.PLAIN, 24);
		titulo = new JPanel();
		textoDoTitulo = new JLabel();
		textoDoTitulo.setFont(fonteTextoDoTitulo);
		textoDoTitulo.setText("Secretaria de Estado do Meio Ambiente");
	    titulo.add(textoDoTitulo);
	    return titulo;
	}
	
	
	private JPanel Chat() throws IOException{
		GridLayout layoutChat = new GridLayout(10,1);
		chat = new JPanel();
		chat.setLayout(layoutChat);
		fontTituloChat = new Font("Calibri", Font.PLAIN, 24);
		tituloChat = new JLabel();
		tituloChat.setText("Equipes conectadas : ");
		chat.add(tituloChat);
		botoesEquipes = new JButton[Equipes.getEquipes().size()];
		for (int i = 0; i < Equipes.getEquipes().size(); i++){
		criarBotoesEquipes(i);
		chat.add(botoesEquipes[i]);
		}
		return chat;	
	}
	
	
	
	
	public JPanel Rodape(){
		rodape = new JPanel();
		textoRodape = new JTextField();
		textoRodape.setEditable(false);
		textoRodape.setText("Desenvolvido por :" +Informacoes.getDesenvolvedores());
		rodape.add(textoRodape);
		return rodape;		
	}
	
	
	
	
	
	
	

}
