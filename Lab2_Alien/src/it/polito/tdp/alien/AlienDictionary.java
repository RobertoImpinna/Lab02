package it.polito.tdp.alien;

import java.util.TreeMap;

public class AlienDictionary {
	TreeMap <String, Word> vocabolario;
	public AlienDictionary() {
		vocabolario=new TreeMap<String, Word>();
	}
	
	public void add(String a, Word f) {
		vocabolario.put(a, f);
	}
	
	public String trova(String a) {
		if(vocabolario.containsKey(a))
			return vocabolario.get(a).traduzione();
		else
			return null;
	}
	
	public Word getWord(String g) {
		return vocabolario.get(g);
	}
	
	public void aggiorna(String a, Word f) {
		vocabolario.replace(a, f);
	}
	
	public void aggiungiVarianti(String a, String b) {
		vocabolario.get(a).sinonimo(b);
	}
	
	public boolean equals(String a) {
		if(this.trova(a)==null)
			return false;
		else
				return true;
	}
	
	
}
