package org.unibl.etf.model;

public class Vozac {
	private int idVozaca;
	private String ime;
	private String prezime;
	private String zemlja;
	private int plata;
	private int preostaloTrajanjeUgovora;
	private String tim;
	private int idKonstruktora;
	
	public Vozac(int idVozaca, String ime, String prezime, String zemlja, int plata, int preostaloTrajanjeUgovora,
			String tim, int idKonstruktora) {
		super();
		this.idVozaca = idVozaca;
		this.ime = ime;
		this.prezime = prezime;
		this.zemlja = zemlja;
		this.plata = plata;
		this.preostaloTrajanjeUgovora = preostaloTrajanjeUgovora;
		this.tim = tim;
		this.idKonstruktora = idKonstruktora;
	}
	
	public int getIdVozaca() {
		return idVozaca;
	}
	public void setIdVozaca(int idVozaca) {
		this.idVozaca = idVozaca;
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
	public String getZemlja() {
		return zemlja;
	}
	public void setZemlja(String zemlja) {
		this.zemlja = zemlja;
	}
	public int getPlata() {
		return plata;
	}
	public void setPlata(int plata) {
		this.plata = plata;
	}
	public int getPreostaloTrajanjeUgovora() {
		return preostaloTrajanjeUgovora;
	}
	public void setPreostaloTrajanjeUgovora(int preostaloTrajanjeUgovora) {
		this.preostaloTrajanjeUgovora = preostaloTrajanjeUgovora;
	}
	public String getTim() {
		return tim;
	}
	public void setTim(String tim) {
		this.tim = tim;
	}
	public int getIdKonstruktora() {
		return idKonstruktora;
	}
	public void setIdKonstruktora(int idKonstruktora) {
		this.idKonstruktora = idKonstruktora;
	}

	@Override
	public String toString() {
		return ime + " " + prezime;
	}
}
