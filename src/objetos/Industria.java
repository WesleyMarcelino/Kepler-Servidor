package objetos;

import java.sql.Date;

public class Industria {
	private long id;
	private String nome;
	private String endereco;
	private String status;

	public Industria(long id, String nome, String endereco, String status) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String toString() {
		return ("Id :" + this.getId() + "Industria :" + this.getNome()
				+ "Endereço :" + this.getEndereco() + "Status :" + this
					.getStatus());
	}

	public String paraBotao() {
		return ("<html>Industria : " + this.getNome() + "<br/>Status : "
				+ this.getStatus() + "</html>");
	}

	public long getId() {

		return id;
	}

}
