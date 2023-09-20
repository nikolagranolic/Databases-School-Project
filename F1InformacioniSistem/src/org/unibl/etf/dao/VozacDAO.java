package org.unibl.etf.dao;

import java.util.List;

import org.unibl.etf.model.Vozac;

public interface VozacDAO {
	public List<Vozac> selectAll();
	public Vozac selectOne(int id);
	public int insert(Vozac v);
	public int update(Vozac v);
	public int delete(Vozac v);
}
