package com.ipartek.formacion.fichajes.joseba;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CSVReader {
	
	private ArrayList<People> peopleWithDups = new ArrayList<People>();
	private ArrayList<People> people = new ArrayList<People>();
	private Set<String> hSet = new HashSet<>();
	
	public CSVReader() {
		
		BufferedReader reader;
		
		try {	
			reader = new BufferedReader(new FileReader(CSVApp.PATH_FILE));
			
			reader.readLine();
			String line=null;
			
			while ((line = reader.readLine()) != null){

				String[] fields = line.split(",");
				if ( fields != null && fields.length == 5 ) {				
					String str = fields[4];
					String strNew = str.replace("Minutos", "");
					String strNew2 = strNew.replaceAll(" ", "");
					String strNew3 = strNew2.replace("\"", "");
					
					peopleWithDups.add(new People(fields[0], Integer.parseInt(strNew3), 0));
				}	
			}	
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void removeDuplicates() {
		
		for (People p : peopleWithDups) {
			
			if (hSet.add(p.getName())) {
				
				people.add(p);
				
			} else {
				
				for (People p2 : people) {
					
					if (p.getName().equals(p2.getName()) ) {
						
						p2.setTime(p.getTime() + p2.getTime());
					}
				}
			}
		}	
	}
	
	public ArrayList<People> getAll() {
		
		return people;		
	}
}