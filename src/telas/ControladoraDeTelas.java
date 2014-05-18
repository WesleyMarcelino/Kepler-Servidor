package telas;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import objetos.Equipe;
import objetos.Industria;
import servidor.Servidor;

public class ControladoraDeTelas {
	private static TelaInicial telaInicial ;
	private static TelaPrincipal telaPrincipal;
	private static CadastrarIndustria cadastrarIndustria = new CadastrarIndustria();
	private static TelaIndustria telaDaIndustria;
	private static TelaDeChat telaDeChat;
	private static boolean telaDeChatIniciada = false;
	
	public static boolean isTelaDeChatVisivel() {
		return telaDeChatIniciada;
	}
	public static void setTelaDeChatVisivel(boolean telaDeChatVisivel) {
		ControladoraDeTelas.telaDeChatIniciada = telaDeChatVisivel;
	}
	public static void mostrarTelaInicial(){
		telaInicial = new TelaInicial(); 
	    telaInicial.setVisible(true);
	}
	public static void esconderTelaInicial(){
		telaInicial.dispose();
		}
	public static void mostrarTelaPrincipal() throws IOException{
		telaPrincipal = new TelaPrincipal();
		telaPrincipal.setVisible(true);
	}
	public static void esconderTelaPrincipal(){
		telaPrincipal.dispose();
		}
	public static void mostrarCadastrarIndustrias(){
		cadastrarIndustria.setVisible(true);
	}
	public static void esconderCadastrarIndustrias(){
		cadastrarIndustria.dispose();
	}
	public static void mostrarTelaIndustria(Industria industria){
	telaDaIndustria = new TelaIndustria(industria);
	telaDaIndustria.setVisible(true);
	}
	public static void esconderTelaIndustria(){
    telaDaIndustria.dispose();
	}
	
	public static void iniciarTelaChat(Equipe equipe ,Socket cliente , Servidor servidor)throws IOException {
		 telaDeChat = new TelaDeChat(equipe,cliente.getInputStream(),servidor);
		 new Thread(telaDeChat).start();
	}
	
	public static void mostrarTelaChat() throws IOException{//pedir id
		 telaDeChat.setVisible(true);// pegar a tela de acordo com o id
	/*	 for (int i =0; i>=ListaTelaDeChat.getTelasDeChat().size();i++){
		      if (ListaTelaDeChat.getTelasDeChat().get(i).getIdTelaDechat() == id){
		         ListaTelaDeChat.getTelasDeChat().get(i).setVisible(true);
		         break;
		  }  		 
		 }
		 
		 */
	}
	public static TelaDeChat getTelaDeChat() {
		return telaDeChat;
	}
	public static void setTelaDeChat(TelaDeChat telaDeChat) {
		ControladoraDeTelas.telaDeChat = telaDeChat;
	}
	
	
	
}
