package com.ipartek.formacion.fichajes.joseba;

public class CSVApp {
	
	static final String PATH_FILE = "/home/javaee/eclipse-workspace/supermercado-java/src/main/resources/tiemposdeconexion.csv";
	
	static CSVReader csvreader = new CSVReader();
	static CSVReader2 csvreaderHashmap = new CSVReader2();
	
	public static void main(String[] args) {

		
		System.out.println( "joseba Garcia".contains("Jose Ramon") );

		/*
		
		for (int i = 0; i < csvreaderHashmap.getAll().size(); i++) {
			
			System.out.println(csvreaderHashmap.getAll().get(i));
		}
		
		*/
		
	}
}
