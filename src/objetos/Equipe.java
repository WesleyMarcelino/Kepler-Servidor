package objetos;

public class Equipe {
	private long id;
	private String nome;
	private String ip;
	private String host;

	public Equipe(long id, String nome, String ip, String host) {
		this.id = id;
		this.nome = nome;
		this.ip = ip;
		this.host = host;
	}

	public String paraBotao() {
		return ("<html>Equipe : " + this.getNome() + "<br/>Host : "
				+ this.getHost() + "</html");
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String toString() {
		return (nome);
	}

}
