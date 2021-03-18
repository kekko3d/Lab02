package model;

public class Parola {

	
	String alieno;
	String traduzione;
	
	public Parola(String alieno, String traduzione) {
		this.alieno = alieno;
		this.traduzione = traduzione;
	}
	
	
	public String getAlieno() {
		return alieno;
	}
	public void setAlieno(String alieno) {
		this.alieno = alieno;
	}
	public String getTraduzione() {
		return traduzione;
	}
	public void setTraduzione(String traduzione) {
		this.traduzione = traduzione;
	}

	@Override
	public String toString() {
		return alieno +" "+ traduzione ;
	}
	
	
	
}
