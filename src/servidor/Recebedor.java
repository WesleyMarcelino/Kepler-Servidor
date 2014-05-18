package servidor;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import objetos.Equipe;
import objetos.Equipes;
import principal.KeplerSrv;
import telas.ControladoraDeTelas;
import telas.TelaDeChat;

public class Recebedor implements Runnable {
	private  static String mensagem;
	private Socket cliente;
	private Equipe equipe;
	public Recebedor(Socket cliente) {
    this.cliente = cliente;
 
   }
   

public void recebeMensagem(Equipe equipe, Socket cliente) throws IOException{
	 System.out.println("RUN DE RECEBER MENSAGEM ");
	 Scanner s = new Scanner(cliente.getInputStream());
     while (s.hasNextLine()) {
         if (ControladoraDeTelas.getTelaDeChat().isVisible() == false ){
             System.out.println("tela não visivel");
             KeplerSrv.getS().mostraChat(equipe); //temporario
             }	 
     mensagem = s.nextLine();
     TelaDeChat.setMensagemDoCliente(mensagem);
     System.out.println("mensagem da tela"+TelaDeChat.getMensagemDoCliente());
      }
       s.close();
}



public void run() {
	try {
		recebeMensagem(equipe, cliente);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}


public static String getMensagem() {
	return mensagem;
}


public static void setMensagem(String mensagem) {
	Recebedor.mensagem = mensagem;
}


	
}
