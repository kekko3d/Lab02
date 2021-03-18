package model;

import java.util.LinkedList;
import java.util.List;

public class ParolaMultipla {

	
	String alieno;
	List <String> traduzione;
	
	public ParolaMultipla(String alieno, String traduzione) {
		this.alieno = alieno;
		this.traduzione = new LinkedList <String> ();
		this.traduzione.add(traduzione);
	}
	
	public String getAlieno() {
		return alieno;
	}
	public void setAlieno(String alieno) {
		this.alieno = alieno;
	}
	public List<String> getTraduzione() {
		return traduzione;
	}
	public void addTraduzione (String str) {
		if(!traduzione.contains(str))
			this.traduzione.add(str);
	}
	public String toStringTraduzioni() {
		String temp = "";
		for(String t : traduzione)
			temp = temp+" "+t;
		return temp;
	}
	
	
}
