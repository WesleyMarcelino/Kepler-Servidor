package db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import objetos.Industria;
import objetos.Industrias;

/*
 * Classe responsavel por gerar/ler txt com os dados sobre as industrias 
 */

public class IndustriaTxt {

	public static FileWriter escritorIndustrias;
	public static FileInputStream leitorIndustrias;

	public static void inserirIndustriaTxt(long id, String nome,
			String endereco, String status) {
		String novaLinha = System.getProperty("line.separator");
		try {
			escritorIndustrias = new FileWriter("industrias.txt", true);
			escritorIndustrias.write("ID" + id + "NOME" + id + nome
					+ "ENDERECO" + id + endereco + "STATUS" + id + status + ";"
					+ novaLinha);
			escritorIndustrias.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void apagarIndustriaTxt() {
		File file = new File("industrias.txt");
		if (file.exists()) {
			file.delete();
		} else {

		}
	}

	public static boolean verSeExisteIndustriaTxt() {
		File file = new File("industrias.txt");
		if (file.exists()) {
			return true;
		} else {
			return false;
		}
	}

	public static void lerIndustriaTxt(long id) {
		int posicao1;
		int posicao2;
		int i = 0;
		Industrias.limparIndustrias();
		try {
			leitorIndustrias = new FileInputStream("industrias.txt");
			Scanner leitor = new Scanner(leitorIndustrias);
			// equanto houver mais linhas
			while (leitor.hasNextLine()) {
				System.out.println("TEM PROXIMA LINHA : "
						+ leitor.hasNextLine());
				String nomeIndustria;
				String enderecoIndustria;
				String statusIndustria;
				String idAuxiliar;

				Industria industria;
				String temp;
				String aux = null;

				temp = leitor.nextLine();
				System.out.println("temp pra valer" + temp);
				System.out.println("ID ATUAL DEPOIS DO TEMP" + id);
				// Limpando o lixo do TXT
				// try{
				// PEGANDO O ID
				posicao1 = temp.indexOf("ID");
				System.out.println("Começa em " + posicao1);
				posicao2 = temp.indexOf("NOME");
				System.out.println("começa em " + posicao2);
				aux = temp.substring(posicao1, posicao2);
				idAuxiliar = aux.replaceAll("ID", "");
				id = Long.parseLong(idAuxiliar);
				System.out.println("porra" + id);
				long idIndustria = id;
				// PEGANDO O NOME
				posicao1 = temp.indexOf("NOME" + id);
				System.out.println("começa em " + posicao1);
				posicao2 = temp.lastIndexOf("ENDERECO" + id);
				System.out.println("começa em " + posicao2);
				System.out.println("id" + id);
				aux = temp.substring(posicao1, posicao2);
				nomeIndustria = aux.replaceAll("NOME" + id, "");
				System.out.println("NOME FINAL DA INDUSTRIA :" + nomeIndustria);
				// System.out.println(nomeIndustria);
				// PEGANDO O ENDEREÇO
				posicao1 = temp.indexOf("ENDERECO" + id);
				posicao2 = temp.lastIndexOf("STATUS" + id);
				aux = temp.substring(posicao1, posicao2);
				enderecoIndustria = aux.replaceAll("ENDERECO" + id, "");
				// System.out.println(enderecoIndustria);
				// PEGANDO O STATUS
				posicao1 = temp.indexOf("STATUS" + id);
				posicao2 = temp.lastIndexOf(";");
				aux = temp.substring(posicao1, posicao2);
				statusIndustria = aux.replaceAll("STATUS" + id, "");
				// System.out.println(statusIndustria);
				System.out.println("debug ***" + idIndustria + nomeIndustria
						+ enderecoIndustria + statusIndustria);
				industria = new Industria(idIndustria, nomeIndustria,
						enderecoIndustria, statusIndustria);
				Industrias.adicionarIndustria(industria);
				System.out.println("id da industria i " + industria.getId());
				// }catch(java.lang.StringIndexOutOfBoundsException e){
				// System.out.println("ERRO , SEM INDUSTRIA PARA ID "+id);
				// }
				i++;
				id++;
				System.out.println("TEM PROXIMA LINHA NO FINALLY : "
						+ leitor.hasNextLine());
			}

			leitor.close();
			leitorIndustrias.close();
		} catch (IOException generico) {
			System.out.println("Não existe industrias.txt");

		}

	}

	public static void criarIndustriaTxt(String nome) {

	}

}
