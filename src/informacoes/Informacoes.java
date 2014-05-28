package informacoes;

public class Informacoes {
	private static final String nomeDoPrograma = "Kepler - Servidor";
	private static final String  versao = "1.0";
	private static String desenvolvedores = "Wesley Marcelino , Talita Yada, Debora Mantova, Aline ";

	public static String getDesenvolvedores() {
		return desenvolvedores;
	}

	public static void setDesenvolvedores(String desenvolvedores) {
		Informacoes.desenvolvedores = desenvolvedores;
	}

	public static String getNomedoprograma() {
		return nomeDoPrograma;
	}

	public static String getVersao() {
		return versao;
	}

}
