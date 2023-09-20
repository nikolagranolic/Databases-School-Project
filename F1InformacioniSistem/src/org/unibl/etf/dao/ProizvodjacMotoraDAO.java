package org.unibl.etf.dao;

import java.util.List;

import org.unibl.etf.model.ProizvodjacMotora;

public interface ProizvodjacMotoraDAO {
	public List<ProizvodjacMotora> selectAll();
	public ProizvodjacMotora selectOne(int id);
	public int insert(ProizvodjacMotora p);
	public int update(ProizvodjacMotora p);
	public int delete(ProizvodjacMotora p);
}
