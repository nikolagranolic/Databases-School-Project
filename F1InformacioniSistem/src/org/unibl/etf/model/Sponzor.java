package org.unibl.etf.model;

public class Sponzor {
	private int idSponzora;
	private String ime;
	
	public Sponzor(int idSponzora, String ime) {
		super();
		this.idSponzora = idSponzora;
		this.ime = ime;
	}

	public int getIdSponzora() {
		return idSponzora;
	}
	
	public void setIdSponzora(int idSponzora) {
		this.idSponzora = idSponzora;
	}
	
	public String getIme() {
		return ime;
	}
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
}
