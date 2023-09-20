package org.unibl.etf.dao;

import java.util.List;

import org.unibl.etf.model.Zaposleni;

public interface ZaposleniDAO {
	public List<Zaposleni> selectAll();
	public Zaposleni selectOne(int id);
	public int insert(Zaposleni z);
	public int update(Zaposleni z);
	public int delete(Zaposleni z);
}
