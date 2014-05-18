package principal;

import java.io.IOException;

import db.IndustriaM;
import db.IndustriaTxt;
import objetos.Industria;
import objetos.StatusLista;
import servidor.Servidor;
import telas.ControladoraDeTelas;
import telas.TelaInicial;

public class KeplerSrv {
     	static Servidor s ;
	public static void main(String args[]) throws IOException{
		//Criando estados aqui 
		StatusLista.criaEstado("PENDENTE DE VERIFICA��O");
		StatusLista.criaEstado("EM VERIFICA��O");
		StatusLista.criaEstado("INDUSTRIA APROVADA");
		StatusLista.criaEstado("INDUSTRIA REPROVADA");
		
		s = new Servidor();
		Thread threadDoServidor = new Thread(s);
		threadDoServidor.start();
		IndustriaTxt.lerIndustriaTxt(0);//lendo  a lista toda
    	ControladoraDeTelas.mostrarTelaInicial();
		
	}
	public static Servidor getS() {
		return s;
	}
	public static void setS(Servidor s) {
		KeplerSrv.s = s;
	}

}
