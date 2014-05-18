package objetos;

import java.util.ArrayList;

public class StatusLista {
	
	private static ArrayList<Status> estados = new ArrayList<Status>();
	
	
	public static void criaEstado(String estado){
	Status status = new Status(estado);
	estados.add(status);	
	}
	
	
	public static ArrayList<Status> getEstados() {
		return estados;
	}

	public static void setStatus(ArrayList<Status> estados) {
		StatusLista.estados = estados;
	}

	public static void adicionarEstado(Status estado){
		estados.add(estado);
	}


}
