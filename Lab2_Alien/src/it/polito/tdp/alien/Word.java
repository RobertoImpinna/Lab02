package it.polito.tdp.alien;

import java.util.LinkedList;

public class Word {
	
	private String array [];
	
	private String alienWord;
	private String traslation;
	
	LinkedList <String> sinonimi= new LinkedList <String>();
	public Word(String alienWord, String traslation) {
		super();
		this.alienWord = alienWord;
		this.traslation = traslation;
		array = new String[2];
		array[0]=alienWord;
		array[1]=traslation;
	}
	
	public String traduzione() {
		String fine=""+array[1]+"";
		for(String f:sinonimi) {
			fine=fine+", "+f;
		}
		return fine;
	}
	
	public void sinonimo(String b) {
		sinonimi.add(b);
	}
	
	
	
	
	
	

}
