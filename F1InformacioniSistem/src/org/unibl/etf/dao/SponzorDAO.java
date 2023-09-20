package org.unibl.etf.dao;

import java.util.List;

import org.unibl.etf.model.Sponzor;

public interface SponzorDAO {
	public List<Sponzor> selectAll();
	public Sponzor selectOne(int id);
	public int insert(Sponzor s);
	public int update(Sponzor s);
	public int delete(Sponzor s);
}
