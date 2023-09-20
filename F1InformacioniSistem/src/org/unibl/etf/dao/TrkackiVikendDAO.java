package org.unibl.etf.dao;

import java.util.List;

import org.unibl.etf.model.TrkackiVikend;

public interface TrkackiVikendDAO {
	public List<TrkackiVikend> selectAll();
	public TrkackiVikend selectOne(int id);
	public int insert(TrkackiVikend t);
	public int update(TrkackiVikend t);
	public int delete(TrkackiVikend t);
}
