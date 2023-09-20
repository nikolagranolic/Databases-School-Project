package org.unibl.etf.dao;

import java.util.List;
import org.unibl.etf.model.Sezona;

public interface SezonaDAO {
	public List<Sezona> selectAll();
	public Sezona selectOne(int id);
	public int insert(Sezona s);
	public int update(Sezona s);
	public int delete(Sezona s);
}
