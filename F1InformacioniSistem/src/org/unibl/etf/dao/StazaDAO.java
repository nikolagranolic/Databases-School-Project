package org.unibl.etf.dao;

import java.util.List;
import org.unibl.etf.model.Staza;

public interface StazaDAO {
	public List<Staza> selectAll();
	public Staza selectOne(int id);
	public int insert(Staza s);
	public int update(Staza s);
	public int delete(Staza s);
}
