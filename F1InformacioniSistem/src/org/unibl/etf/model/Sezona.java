package org.unibl.etf.model;

public class Sezona {
	private int idSezone;
	private int godina;
	private int brojTrka;
	
	public Sezona(int idSezone, int godina, int brojTrka) {
		super();
		this.idSezone = idSezone;
		this.godina = godina;
		this.brojTrka = brojTrka;
	}

	public int getIdSezone() {
		return idSezone;
	}

	public void setIdSezone(int idSezone) {
		this.idSezone = idSezone;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	public int getBrojTrka() {
		return brojTrka;
	}

	public void setBrojTrka(int brojTrka) {
		this.brojTrka = brojTrka;
	}
	
	@Override
	public String toString() {
		return godina + "";
	}
}
