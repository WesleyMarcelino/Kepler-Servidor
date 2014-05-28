package servidor;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Enviador implements Runnable {
	private Servidor servidor;

	public Enviador(Servidor servidor) {
		this.servidor = servidor;
	}

	public void enviaMensagem() {
		System.out
				.println("to no run do servidor - mais precisamente em enviar mensagem");
		Scanner s = new Scanner(System.in);
		while (s.hasNextLine()) {
			servidor.enviaMensagem(s.nextLine());
		}
		s.close();
	}

	public void run() {
		enviaMensagem();

	}

}
