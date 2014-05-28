package objetos;

import java.util.ArrayList;

public class Industrias {

	public static ArrayList<Industria> industrias = new ArrayList<Industria>();

	public static void adicionarIndustria(Industria industria) {
		industrias.add(industria);
	}

	public static void limparIndustrias() {
		industrias.clear();
	}

	public static void limparIndustriasPorId(int id) {
		System.out.println("DEBUG LIMPAR INDUSTRIAS POR ID:");
		try {
			System.out.println("INDUSTRIA A SER REMOVIDA"
					+ industrias.get(id).getNome());
			industrias.remove(id);
		} catch (java.lang.IndexOutOfBoundsException eraOUltimo) {
			System.out.println("INDUSTRIA A SER REMOVIDA"
					+ industrias.get(id - 1).getNome());
			industrias.remove(id - 1);

		}
	}

	public static ArrayList<Industria> getIndustrias() {
		return industrias;
	}

	public static void setIndustrias(ArrayList<Industria> industrias) {
		Industrias.industrias = industrias;
	}

}
