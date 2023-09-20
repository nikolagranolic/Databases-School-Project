package org.unibl.etf.model;

public class Konstruktor {
	private int idKonstruktora;
	private String naziv;
	private String mjesto;
	private String zemlja;
	private String nazivProizvodjacaMotora;
	private int fk_idProizvodjacaMotora;
	
	public Konstruktor(int idKonstruktora, String naziv, String mjesto, String zemlja, String nazivProizvodjacaMotora, int fk_idProizvodjacaMotora) {
		super();
		this.idKonstruktora = idKonstruktora;
		this.naziv = naziv;
		this.mjesto = mjesto;
		this.zemlja = zemlja;
		this.nazivProizvodjacaMotora = nazivProizvodjacaMotora;
		this.fk_idProizvodjacaMotora = fk_idProizvodjacaMotora;
	}

	public int getFk_idProizvodjacaMotora() {
		return fk_idProizvodjacaMotora;
	}

	public void setFk_idProizvodjacaMotora(int fk_idProizvodjacaMotora) {
		this.fk_idProizvodjacaMotora = fk_idProizvodjacaMotora;
	}

	public int getIdKonstruktora() {
		return idKonstruktora;
	}

	public void setIdKonstruktora(int idKonstruktora) {
		this.idKonstruktora = idKonstruktora;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getMjesto() {
		return mjesto;
	}

	public void setMjesto(String mjesto) {
		this.mjesto = mjesto;
	}

	public String getZemlja() {
		return zemlja;
	}

	public void setZemlja(String zemlja) {
		this.zemlja = zemlja;
	}

	public String getNazivProizvodjacaMotora() {
		return nazivProizvodjacaMotora;
	}

	public void setNazivProizvodjacaMotora(String nazivProizvodjacaMotora) {
		this.nazivProizvodjacaMotora = nazivProizvodjacaMotora;
	}

	@Override
	public String toString() {
		return naziv;
	}
}
