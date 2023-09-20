package org.unibl.etf.model;

import java.sql.Time;

public class Rezultat {
	private int idVozaca;
	private int idTrkackogVikenda;
	
	private String vozacIme;
	private String vozacPrezime;
	private String nazivVelikeNagrade;
	
	private int startnaPozicija;
	private int krajnjaPozicija;
	private Time vrijeme;
	private boolean najbrziKrug;
	private int poeni;
	private int idKonstruktora;
	private String ekipa;
	
	public Rezultat(int idVozaca, int idTrkackogVikenda, String vozacIme, String vozacPrezime,
			String nazivVelikeNagrade, int startnaPozicija, int krajnjaPozicija, Time vrijeme, boolean najbrziKrug,
			int poeni, int idKonstruktora, String ekipa) {
		super();
		this.idVozaca = idVozaca;
		this.idTrkackogVikenda = idTrkackogVikenda;
		this.vozacIme = vozacIme;
		this.vozacPrezime = vozacPrezime;
		this.nazivVelikeNagrade = nazivVelikeNagrade;
		this.startnaPozicija = startnaPozicija;
		this.krajnjaPozicija = krajnjaPozicija;
		this.vrijeme = vrijeme;
		this.najbrziKrug = najbrziKrug;
		this.poeni = poeni;
		this.idKonstruktora = idKonstruktora;
		this.ekipa = ekipa;
	}

	public int getIdVozaca() {
		return idVozaca;
	}

	public void setIdVozaca(int idVozaca) {
		this.idVozaca = idVozaca;
	}

	public int getIdTrkackogVikenda() {
		return idTrkackogVikenda;
	}

	public void setIdTrkackogVikenda(int idTrkackogVikenda) {
		this.idTrkackogVikenda = idTrkackogVikenda;
	}

	public String getVozacIme() {
		return vozacIme;
	}

	public void setVozacIme(String vozacIme) {
		this.vozacIme = vozacIme;
	}

	public String getVozacPrezime() {
		return vozacPrezime;
	}

	public void setVozacPrezime(String vozacPrezime) {
		this.vozacPrezime = vozacPrezime;
	}

	public String getNazivVelikeNagrade() {
		return nazivVelikeNagrade;
	}

	public void setNazivVelikeNagrade(String nazivVelikeNagrade) {
		this.nazivVelikeNagrade = nazivVelikeNagrade;
	}

	public int getStartnaPozicija() {
		return startnaPozicija;
	}

	public void setStartnaPozicija(int startnaPozicija) {
		this.startnaPozicija = startnaPozicija;
	}

	public int getKrajnjaPozicija() {
		return krajnjaPozicija;
	}

	public void setKrajnjaPozicija(int krajnjaPozicija) {
		this.krajnjaPozicija = krajnjaPozicija;
	}

	public Time getVrijeme() {
		return vrijeme;
	}

	public void setVrijeme(Time vrijeme) {
		this.vrijeme = vrijeme;
	}

	public boolean isNajbrziKrug() {
		return najbrziKrug;
	}

	public void setNajbrziKrug(boolean najbrziKrug) {
		this.najbrziKrug = najbrziKrug;
	}

	public int getPoeni() {
		return poeni;
	}

	public void setPoeni(int poeni) {
		this.poeni = poeni;
	}

	public int getIdKonstruktora() {
		return idKonstruktora;
	}

	public void setIdKonstruktora(int idKonstruktora) {
		this.idKonstruktora = idKonstruktora;
	}

	public String getEkipa() {
		return ekipa;
	}

	public void setEkipa(String ekipa) {
		this.ekipa = ekipa;
	}
}
