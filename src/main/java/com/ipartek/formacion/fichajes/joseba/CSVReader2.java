package com.ipartek.formacion.fichajes.joseba;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CSVReader2 {

	private HashMap<String, People> hMap = new HashMap<>();

	
	public CSVReader2() {
			
		hMap.put("Joseba", new People());
		hMap.put("Jose", new People());
		hMap.put("Raul", new People());
		hMap.put("Javier", new People());
		hMap.put("Ander", new People());
		hMap.put("Unai", new People());
		hMap.put("Ariel", new People());
		hMap.put("Guillermo", new People());
		hMap.put("Violeta", new People());
		hMap.put("Rober", new People());
		hMap.put("Dani", new People());
		hMap.put("Alfredo", new People());
		hMap.put("Xabier", new People());
		hMap.put("Alvaro", new People());
		hMap.put("Sebastian", new People());
		hMap.put("Paz", new People());
		
		
		//TODO dentro del try mejor
		BufferedReader reader;
		
		try   {	
			reader = new BufferedReader(new FileReader( CSVApp.PATH_FILE ));
			
			
			String line = reader.readLine(); //omitir linea cabecera
			
			while ((line = reader.readLine()) != null){

				String[] fields = line.split(",");
				
				//TODO usar constantes y cambiar nombres de variables
				String str = fields[0];
				String strNew = str.replace("\"", "");
				if ( fields != null && fields.length == 5 ) {	
					String str2 = fields[4];
					String str2New = str2.replace("Minutos", "");
					String str2New2 = str2New.replaceAll(" ", "");
					String str2New3 = str2New2.replace("\"", "");
			
				
				switch (strNew) {
				
					case "Joseba":
						
						hMap.get("Joseba").setName(strNew);
						hMap.get("Joseba").setTime(hMap.get("Joseba").getTime() + Integer.parseInt(str2New3));
						hMap.get("Joseba").setNumConnection(hMap.get("Joseba").getNumConnection() + 1);
						
						break;
						
					case "Jose":
						
						hMap.get("Jose").setName(strNew);
						hMap.get("Jose").setTime(hMap.get("Jose").getTime() + Integer.parseInt(str2New3));
						hMap.get("Jose").setNumConnection(hMap.get("Jose").getNumConnection() + 1);
						
						break;
						
					case "Raul":
						
						hMap.get("Raul").setName(strNew);
						hMap.get("Raul").setTime(hMap.get("Raul").getTime() + Integer.parseInt(str2New3));
						hMap.get("Raul").setNumConnection(hMap.get("Raul").getNumConnection() + 1);
						
						break;
						
					case "Javier":
						
						hMap.get("Javier").setName(strNew);
						hMap.get("Javier").setTime(hMap.get("Javier").getTime() + Integer.parseInt(str2New3));
						hMap.get("Javier").setNumConnection(hMap.get("Javier").getNumConnection() + 1);
						
						break;
						
					case "Ander":
						
						hMap.get("Ander").setName(strNew);
						hMap.get("Ander").setTime(hMap.get("Ander").getTime() + Integer.parseInt(str2New3));
						hMap.get("Ander").setNumConnection(hMap.get("Ander").getNumConnection() + 1);
						
						break;
						
					case "Unai":
						
						hMap.get("Unai").setName(strNew);
						hMap.get("Unai").setTime(hMap.get("Unai").getTime() + Integer.parseInt(str2New3));
						hMap.get("Unai").setNumConnection(hMap.get("Unai").getNumConnection() + 1);
						
						break;
						
					case "Ariel":
						
						hMap.get("Ariel").setName(strNew);
						hMap.get("Ariel").setTime(hMap.get("Ariel").getTime() + Integer.parseInt(str2New3));
						hMap.get("Ariel").setNumConnection(hMap.get("Ariel").getNumConnection() + 1);
						
						break;
						
					case "Guillermo":
						
						hMap.get("Guillermo").setName(strNew);
						hMap.get("Guillermo").setTime(hMap.get("Guillermo").getTime() + Integer.parseInt(str2New3));
						hMap.get("Guillermo").setNumConnection(hMap.get("Guillermo").getNumConnection() + 1);
						
						break;
					
					case "Violeta":
						
						hMap.get("Violeta").setName(strNew);
						hMap.get("Violeta").setTime(hMap.get("Violeta").getTime() + Integer.parseInt(str2New3));
						hMap.get("Violeta").setNumConnection(hMap.get("Violeta").getNumConnection() + 1);
						
						break;

					case "Rober":
						
						hMap.get("Rober").setName(strNew);
						hMap.get("Rober").setTime(hMap.get("Rober").getTime() + Integer.parseInt(str2New3));
						hMap.get("Rober").setNumConnection(hMap.get("Rober").getNumConnection() + 1);
						
						break;

					case "Dani":
						
						hMap.get("Dani").setName(strNew);
						hMap.get("Dani").setTime(hMap.get("Dani").getTime() + Integer.parseInt(str2New3));
						hMap.get("Dani").setNumConnection(hMap.get("Dani").getNumConnection() + 1);
						
						break;

					case "Alfredo":
						
						hMap.get("Alfredo").setName(strNew);
						hMap.get("Alfredo").setTime(hMap.get("Alfredo").getTime() + Integer.parseInt(str2New3));
						hMap.get("Alfredo").setNumConnection(hMap.get("Alfredo").getNumConnection() + 1);

						break;

					case "Xabier":

						hMap.get("Xabier").setName(strNew);
						hMap.get("Xabier").setTime(hMap.get("Xabier").getTime() + Integer.parseInt(str2New3));
						hMap.get("Xabier").setNumConnection(hMap.get("Xabier").getNumConnection() + 1);

						break;

					case "Alvaro":

						hMap.get("Alvaro").setName(strNew);
						hMap.get("Alvaro").setTime(hMap.get("Alvaro").getTime() + Integer.parseInt(str2New3));
						hMap.get("Alvaro").setNumConnection(hMap.get("Alvaro").getNumConnection() + 1);

						break;

					case "Sebastian":

						hMap.get("Sebastian").setName(strNew);
						hMap.get("Sebastian").setTime(hMap.get("Sebastian").getTime() + Integer.parseInt(str2New3));
						hMap.get("Sebastian").setNumConnection(hMap.get("Sebastian").getNumConnection() + 1);

						break;

					case "Paz":

						hMap.get("Paz").setName(strNew);
						hMap.get("Paz").setTime(hMap.get("Paz").getTime() + Integer.parseInt(str2New3));
						hMap.get("Paz").setNumConnection(hMap.get("Paz").getNumConnection() + 1);

						break;
				}
				
				
				}// if

			}	
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<People> getAll() {
		
		ArrayList<People> people = new ArrayList<People>(hMap.values());
		
		return people;		
	}
}