package org.unibl.etf.dao;

import java.util.List;

import org.unibl.etf.model.Konstruktor;

public interface KonstruktorDAO {
	public List<Konstruktor> selectAll();
	public Konstruktor selectOne(int id);
	public int insert(Konstruktor k);
	public int update(Konstruktor k);
	public int delete(Konstruktor k);
}
