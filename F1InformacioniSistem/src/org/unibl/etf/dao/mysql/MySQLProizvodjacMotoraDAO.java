package org.unibl.etf.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.unibl.etf.dao.ProizvodjacMotoraDAO;
import org.unibl.etf.model.ProizvodjacMotora;
import org.unibl.etf.util.DBUtil;

public class MySQLProizvodjacMotoraDAO implements ProizvodjacMotoraDAO {
	private static final String SQL_SELECT_ALL = "SELECT * FROM `proizvodjac_motora`";
	private static final String SQL_SELECT_ONE = "SELECT * FROM `proizvodjac_motora` WHERE IdProizvodjacaMotora=";
	private static final String SQL_INSERT = "INSERT INTO `proizvodjac_motora` (IdProizvodjacaMotora, Naziv, Mjesto, Zemlja) VALUES (null, ?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE `proizvodjac_motora` SET Naziv=?, Mjesto=?, Zemlja=? WHERE IdProizvodjacaMotora=?";
	private static final String SQL_DELETE = "DELETE FROM `proizvodjac_motora` WHERE IdProizvodjacaMotora=?";
	
	public List<ProizvodjacMotora> selectAll() {
		List<ProizvodjacMotora> retVal = new ArrayList<ProizvodjacMotora>();
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		
		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			rs = s.executeQuery(SQL_SELECT_ALL);
			
			while (rs.next()) {
				retVal.add(new ProizvodjacMotora(rs.getInt("IdProizvodjacaMotora"), rs.getString("Naziv"), rs.getString("Mjesto"), rs.getString("Zemlja")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, s, c);
		}
		
		return retVal;
	}
	
	public ProizvodjacMotora selectOne(int id) {
		List<ProizvodjacMotora> retVal = new ArrayList<ProizvodjacMotora>();
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		
		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			rs = s.executeQuery(SQL_SELECT_ONE + id);
			
			while (rs.next()) {
				retVal.add(new ProizvodjacMotora(rs.getInt("IdProizvodjacaMotora"), rs.getString("Naziv"), rs.getString("Mjesto"), rs.getString("Zemlja")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, s, c);
		}
		
		return retVal.get(0);
	}
	
	public int insert(ProizvodjacMotora p) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			c = DBUtil.getConnection();
			Object values[] = { p.getNaziv(), p.getMjesto(), p.getZemlja() };
			ps = DBUtil.prepareStatement(c, SQL_INSERT, true, values);
			retVal = ps.executeUpdate();
			if (retVal != 0) {
				rs = ps.getGeneratedKeys();
				if (rs.next())
					p.setIdProizvodjacaMotora(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, c);
		}

		return retVal;
	}
	
	public int update(ProizvodjacMotora p) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			c = DBUtil.getConnection();
			Object values[] = { p.getNaziv(), p.getMjesto(), p.getZemlja(), p.getIdProizvodjacaMotora() };
			ps = DBUtil.prepareStatement(c, SQL_UPDATE, false, values);
			retVal = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(ps, c);
		}
		return retVal;
	}
	
	public int delete(ProizvodjacMotora p) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;

		try {
			c = DBUtil.getConnection();
			Object values[] = { p.getIdProizvodjacaMotora() };
			ps = DBUtil.prepareStatement(c, SQL_DELETE, false, values);
			retVal = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(ps, c);
		}
		return retVal;
	}
}
