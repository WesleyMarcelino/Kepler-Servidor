package telas;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import objetos.Equipe;
import servidor.Servidor;

public class ListaTelaDeChat {
	private static ArrayList<TelaDeChat> telasDeChat = new ArrayList<TelaDeChat>();

	public static void adicionarTelaDeChat(long id , Equipe equipe ,Socket cliente , Servidor servidor) throws IOException{
	TelaDeChat telaDeChat = new TelaDeChat(equipe,cliente.getInputStream(),servidor);
    telasDeChat.add(telaDeChat);
    }
	
	
	
	public static ArrayList<TelaDeChat> getTelasDeChat() {
		return telasDeChat;
	}

	public static void setTelasDeChat(ArrayList<TelaDeChat> telasDeChat) {
		ListaTelaDeChat.telasDeChat = telasDeChat;
	}
}
