package org.unibl.etf.dao;

import java.util.List;

import org.unibl.etf.model.Rezultat;

public interface RezultatDAO {
	public List<Rezultat> selectAll();
	public Rezultat selectOne(int idTrkackogVikenda, int idVozaca);
	public int insert(Rezultat r);
	public int update(Rezultat r);
	public int delete(Rezultat r);
}
