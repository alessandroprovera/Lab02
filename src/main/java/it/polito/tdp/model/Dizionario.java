package it.polito.tdp.model;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Dizionario {
	
	private TreeMap<String,List<String>> mappa = new TreeMap<String,List<String>>();
	
	public String traduci(String stringa) {
		String check = "qwertyuiopasdfghjklzxcvbnm";
		stringa.toLowerCase();
		String temp = stringa.replaceAll(" ", "");
		for(char c: temp.toCharArray()) {
			if(check.indexOf(c) == -1)
				return "Errore nell'inserimento dell'input\n";
		}
		
		String divisa[] = stringa.split(" ");
		if(divisa.length == 2)
			return this.nuovaTraduzione(divisa[0], divisa[1]);
		return this.traduciParola(divisa[0]);
			
		
	}
	
	public String nuovaTraduzione(String aliena, String tradotta) {
		if(mappa.containsKey(aliena)) {
			// devo aggiungere la traduzione alla lista
			mappa.get(aliena).add(tradotta);
		}
		else {
			LinkedList<String> lista = new LinkedList<String>();
			lista.add(tradotta);
			mappa.put(aliena, lista);
		}
		return "Nuova coppia aggiunta al dizionario\n";
		
	}
	
	public String traduciParola(String aliena) {
		String daRestituire = "";
		for(String s: mappa.get(aliena)) {
			daRestituire += (s + " ");
		}
		return daRestituire;
		
	}

}
