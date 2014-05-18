package servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import objetos.Equipe;
import objetos.Equipes;
import telas.ControladoraDeTelas;
import telas.TelaDeChat;

public class Servidor implements Runnable {
    private	ServerSocket servidor ;
	private Socket cliente;
	private Recebedor recebidor;
	private static List<PrintStream> clientes;

	
	public static List<PrintStream> getClientes() {
		return clientes;
	}
	public static void setClientes(List<PrintStream> clientes) {
		clientes = clientes;
	}
	public Servidor() throws IOException {
		servidor = new ServerSocket(12345);
	    this.clientes = new ArrayList<PrintStream>();
	}
	public void esperaClientes() throws IOException{
		while(true){
		System.out.println("DEBUG DO SEVIDOR - ESPERA CLIENTES OK");
		cliente = servidor.accept();
		System.out.println("Nova conexão com o cliente " +
		cliente.getInetAddress().getHostAddress());
	    converteClienteParaEquipe(cliente);
	    this.clientes.add(new PrintStream(cliente.getOutputStream()));  
	  //  System.out.println("debug, minha lista de clientes"+getClientes().toString());
		
		}
	}
	
	public void esperaMensagem(){
		recebidor = new Recebedor(cliente);
		Thread recebimento = new Thread(recebidor);
		recebimento.start();
		
	}
	
	
	public void iniciaChat(Equipe equipe) throws IOException{
		ControladoraDeTelas.iniciarTelaChat(equipe, cliente, this);
	}
	
	public void mostraChat(Equipe equipe) throws IOException{
		ControladoraDeTelas.mostrarTelaChat();
	}
	
	public void enviaMensagem(String mensagem){
		for (PrintStream cliente : this.clientes) {
			System.out.println(mensagem);  
			cliente.println(mensagem);
		     }
	}
		
	
	public void converteClienteParaEquipe(Socket cliente) throws IOException{	
		long id;
		String nome = cliente.getInputStream().toString();
		String host = cliente.getInetAddress().getHostName();
		String ip = cliente.getInetAddress().getHostAddress().toString();
		Scanner scanner = new Scanner(cliente.getInputStream());
		String auxiliar = scanner.nextLine();
	    nome = auxiliar;
	    id=0;
		Equipe equipe = new Equipe(id,nome, host, ip);
		Equipes.adicionarEquipe(equipe);
		System.out.println(" DEBUG - EQUIPE MONTADA : "+id+nome+host+ip);

	}
	
		
	
	
	public void paraServidor() throws IOException{
		servidor.close();
		cliente.close();
	}

	
	
	public void run() {
		System.out.println("DEBUG ENTRADA NO RUN");
		try {
			this.esperaClientes();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

