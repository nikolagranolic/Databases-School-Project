package org.unibl.etf.model;

public class ProizvodjacMotora {
	private int idProizvodjacaMotora;
	private String naziv;
	private String mjesto;
	private String zemlja;
	
	public ProizvodjacMotora(int idProizvodjacaMotora, String naziv, String mjesto, String zemlja) {
		super();
		this.idProizvodjacaMotora = idProizvodjacaMotora;
		this.naziv = naziv;
		this.mjesto = mjesto;
		this.zemlja = zemlja;
	}

	public int getIdProizvodjacaMotora() {
		return idProizvodjacaMotora;
	}

	public void setIdProizvodjacaMotora(int idProizvodjacaMotora) {
		this.idProizvodjacaMotora = idProizvodjacaMotora;
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

	@Override
	public String toString() {
		return naziv;
	}
	
}
