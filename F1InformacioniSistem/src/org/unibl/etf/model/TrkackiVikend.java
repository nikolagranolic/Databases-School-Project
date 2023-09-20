package org.unibl.etf.model;

import java.sql.Date;
import java.sql.Time;

public class TrkackiVikend {
	private int idTrkackogVikenda;
	private int redniBroj;
	private String nazivVelikeNagrade;
	private Date datumPocetka;
	private Date datumKraja;
	private Time vrijemeTrke;
	private Time vrijemeKvalifikacija;
	private Time vrijemePrvogTreninga;
	private Time vrijemeDrugogTreninga;
	private Time vrijemeTrecegTreninga;
	private int idStaze;
	private String staza;
	private int idSezone;
	private int godina;

	
	public TrkackiVikend(int idTrkackogVikenda, int redniBroj, String nazivVelikeNagrade, Date datumPocetka,
			Date datumKraja, Time vrijemeTrke, Time vrijemeKvalifikacija, Time vrijemePrvogTreninga,
			Time vrijemeDrugogTreninga, Time vrijemeTrecegTreninga, int idStaze, String staza, int idSezone,
			int godina) {
		super();
		this.idTrkackogVikenda = idTrkackogVikenda;
		this.redniBroj = redniBroj;
		this.nazivVelikeNagrade = nazivVelikeNagrade;
		this.datumPocetka = datumPocetka;
		this.datumKraja = datumKraja;
		this.vrijemeTrke = vrijemeTrke;
		this.vrijemeKvalifikacija = vrijemeKvalifikacija;
		this.vrijemePrvogTreninga = vrijemePrvogTreninga;
		this.vrijemeDrugogTreninga = vrijemeDrugogTreninga;
		this.vrijemeTrecegTreninga = vrijemeTrecegTreninga;
		this.idStaze = idStaze;
		this.staza = staza;
		this.idSezone = idSezone;
		this.godina = godina;
	}

	public int getIdTrkackogVikenda() {
		return idTrkackogVikenda;
	}

	public void setIdTrkackogVikenda(int idTrkackogVikenda) {
		this.idTrkackogVikenda = idTrkackogVikenda;
	}

	public int getRedniBroj() {
		return redniBroj;
	}

	public void setRedniBroj(int redniBroj) {
		this.redniBroj = redniBroj;
	}

	public String getNazivVelikeNagrade() {
		return nazivVelikeNagrade;
	}

	public void setNazivVelikeNagrade(String nazivVelikeNagrade) {
		this.nazivVelikeNagrade = nazivVelikeNagrade;
	}

	public Date getDatumPocetka() {
		return datumPocetka;
	}

	public void setDatumPocetka(Date datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	public Date getDatumKraja() {
		return datumKraja;
	}

	public void setDatumKraja(Date datumKraja) {
		this.datumKraja = datumKraja;
	}

	public Time getVrijemeTrke() {
		return vrijemeTrke;
	}

	public void setVrijemeTrke(Time vrijemeTrke) {
		this.vrijemeTrke = vrijemeTrke;
	}

	public Time getVrijemeKvalifikacija() {
		return vrijemeKvalifikacija;
	}

	public void setVrijemeKvalifikacija(Time vrijemeKvalifikacija) {
		this.vrijemeKvalifikacija = vrijemeKvalifikacija;
	}

	public Time getVrijemePrvogTreninga() {
		return vrijemePrvogTreninga;
	}

	public void setVrijemePrvogTreninga(Time vrijemePrvogTreninga) {
		this.vrijemePrvogTreninga = vrijemePrvogTreninga;
	}

	public Time getVrijemeDrugogTreninga() {
		return vrijemeDrugogTreninga;
	}

	public void setVrijemeDrugogTreninga(Time vrijemeDrugogTreninga) {
		this.vrijemeDrugogTreninga = vrijemeDrugogTreninga;
	}

	public Time getVrijemeTrecegTreninga() {
		return vrijemeTrecegTreninga;
	}

	public void setVrijemeTrecegTreninga(Time vrijemeTrecegTreninga) {
		this.vrijemeTrecegTreninga = vrijemeTrecegTreninga;
	}

	public int getIdStaze() {
		return idStaze;
	}

	public void setIdStaze(int idStaze) {
		this.idStaze = idStaze;
	}

	public int getIdSezone() {
		return idSezone;
	}

	public void setIdSezone(int idSezone) {
		this.idSezone = idSezone;
	}

	public String getStaza() {
		return staza;
	}

	public void setStaza(String staza) {
		this.staza = staza;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	@Override
	public String toString() {
		return nazivVelikeNagrade;
	}
}
