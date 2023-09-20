package org.unibl.etf.model;

public class Staza {
	private int idStaze;
	private String naziv;
	private String mjesto;
	private String drzava;
	private int kapacitet;
	private boolean isUlicna;
	private float duzinaKruga;
	private int brojKrugova;
	
	public Staza(int idStaze, String naziv, String mjesto, String drzava, int kapacitet, boolean isUlicna,
			float duzinaKruga, int brojKrugova) {
		super();
		this.idStaze = idStaze;
		this.naziv = naziv;
		this.mjesto = mjesto;
		this.drzava = drzava;
		this.kapacitet = kapacitet;
		this.isUlicna = isUlicna;
		this.duzinaKruga = duzinaKruga;
		this.brojKrugova = brojKrugova;
	}

	public int getIdStaze() {
		return idStaze;
	}

	public void setIdStaze(int idStaze) {
		this.idStaze = idStaze;
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

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public int getKapacitet() {
		return kapacitet;
	}

	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}

	public boolean isUlicna() {
		return isUlicna;
	}

	public void setUlicna(boolean isUlicna) {
		this.isUlicna = isUlicna;
	}

	public float getDuzinaKruga() {
		return duzinaKruga;
	}

	public void setDuzinaKruga(float duzinaKruga) {
		this.duzinaKruga = duzinaKruga;
	}

	public int getBrojKrugova() {
		return brojKrugova;
	}

	public void setBrojKrugova(int brojKrugova) {
		this.brojKrugova = brojKrugova;
	}
	
	@Override
	public String toString() {
		return naziv;
	}
}
