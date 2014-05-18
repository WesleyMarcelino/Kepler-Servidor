package db;

import objetos.Industria;



public class IndustriaM {

	public static void inserirIndustria(Industria industria){
	IndustriaTxt.inserirIndustriaTxt(industria.getId(),industria.getNome(), industria.getEndereco(), industria.getStatus());
	}
	public static void apagarIndustriaDB(){
	IndustriaTxt.apagarIndustriaTxt();	
	}
	public static void lerIndustria(Industria industria){
	IndustriaTxt.lerIndustriaTxt(industria.getId());
	}
	public static void criarIndustria(){
		
	}
	public static boolean verificarSeExisteDb(){
	return IndustriaTxt.verSeExisteIndustriaTxt();
	}
	
	
	
	
	
	
	
	
}
