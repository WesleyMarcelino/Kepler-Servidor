package objetos;

public class Status {
	private long id;
	private String estado;


	public Status(String estado){
		this.estado = estado;
	}
	
	public String toString(){
		return (estado); 
	}

}