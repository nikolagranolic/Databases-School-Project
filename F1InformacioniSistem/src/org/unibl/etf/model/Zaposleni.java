package org.unibl.etf.model;

public class Zaposleni {
	private int idZaposlenog;
	private String ime;
	private String prezime;
	
	public Zaposleni(int idZaposlenog, String ime, String prezime) {
		super();
		this.idZaposlenog = idZaposlenog;
		this.ime = ime;
		this.prezime = prezime;
	}

	public int getIdZaposlenog() {
		return idZaposlenog;
	}
	
	public void setIdZaposlenog(int idZaposlenog) {
		this.idZaposlenog = idZaposlenog;
	}
	
	public String getIme() {
		return ime;
	}
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
}
