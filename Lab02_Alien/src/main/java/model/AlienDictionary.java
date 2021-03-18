package model;

import java.util.LinkedList;
import java.util.List;


public class AlienDictionary {
	
	private List <ParolaMultipla> dictionary; 
	int num = 0;
	String alienQuestionMark;
	String theRestQuestionMark;

	public AlienDictionary() {
		this.dictionary = new LinkedList <ParolaMultipla>();
	}

	public void add(String alienWord, String translation) {
		if(alienWord.contains("?"))
			return;
		for(ParolaMultipla d : dictionary) {
			if(d.getAlieno().toUpperCase().equals(alienWord.toUpperCase())) {
				d.addTraduzione(translation);
				return;
			}
		}
		this.dictionary.add(new ParolaMultipla(alienWord, translation));
	}
	
	public String doTranslate(String alienWord) {
		String temp = "";
		if(alienWord.contains("?")) {
			num = alienWord.indexOf('?');
			alienQuestionMark = alienWord.substring(0, num) + alienWord.substring(num+1);
			for(ParolaMultipla d : dictionary) {
				theRestQuestionMark = d.getAlieno().substring(0, num) + d.getAlieno().substring(num+1);
				if(theRestQuestionMark.toUpperCase().equals(alienQuestionMark.toUpperCase())) {
					temp =d.toStringTraduzioni() + '\n'+ temp;
				}
			}
			return temp.strip();
		}
		for(ParolaMultipla d : this.dictionary) {
			if(d.getAlieno().toUpperCase().equals(alienWord.toUpperCase()))
				return d.toStringTraduzioni();
		}
		return null;
	}

	@Override
	public String toString() {
		String temp = "";
		for(ParolaMultipla d: dictionary) {
			temp =  d.getAlieno() + "" +d.toStringTraduzioni() + '\n'+ temp;
		}
	return temp.trim();
	}
	
	
	public void clear() {
		dictionary.clear();;
	}
	
	
	

}
