package objetos;

import java.util.ArrayList;

public class Equipes {
	
	private static ArrayList<Equipe> equipes = new ArrayList<Equipe>();
	
	
	public static ArrayList<Equipe> getEquipes() {
		return equipes;
	}

	public static void setEquipes(ArrayList<Equipe> equipes) {
		Equipes.equipes = equipes;
	}

	public static void adicionarEquipe(Equipe equipe){
		equipes.add(equipe);
	}


}
