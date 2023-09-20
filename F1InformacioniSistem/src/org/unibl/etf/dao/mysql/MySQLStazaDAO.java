package org.unibl.etf.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.unibl.etf.dao.StazaDAO;
import org.unibl.etf.model.Staza;
import org.unibl.etf.util.DBUtil;

public class MySQLStazaDAO implements StazaDAO {
	private static final String SQL_SELECT_ALL = "SELECT * FROM `staza`";
	private static final String SQL_SELECT_ONE = "SELECT * FROM `staza` WHERE IdStaze=";
	private static final String SQL_INSERT = "INSERT INTO `staza` (IdStaze, Naziv, Mjesto, Drzava, Kapacitet, IsUlicna, DuzinaKruga, BrojKrugova) VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE `staza` SET Naziv=?, Mjesto=?, Drzava=?, Kapacitet=?, IsUlicna=?, DuzinaKruga=?, BrojKrugova=? WHERE IdStaze=?";
	private static final String SQL_DELETE = "DELETE FROM `staza` WHERE IdStaze=?";
	
	public List<Staza> selectAll() {
		List<Staza> retVal = new ArrayList<Staza>();
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		
		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			rs = s.executeQuery(SQL_SELECT_ALL);
			
			while (rs.next()) {
				retVal.add(new Staza(rs.getInt("IdStaze"), rs.getString("Naziv"), rs.getString("Mjesto"), rs.getString("Drzava"),
						rs.getInt("Kapacitet"), rs.getInt("IsUlicna") > 0 ? true : false, rs.getFloat("DuzinaKruga"), rs.getInt("BrojKrugova")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, s, c);
		}
		
		return retVal;
	}
	
	public Staza selectOne(int id) {
		List<Staza> retVal = new ArrayList<Staza>();
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		
		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			rs = s.executeQuery(SQL_SELECT_ONE + id);
			
			while (rs.next()) {
				retVal.add(new Staza(rs.getInt("IdStaze"), rs.getString("Naziv"), rs.getString("Mjesto"), rs.getString("Drzava"),
						rs.getInt("Kapacitet"), rs.getInt("IsUlicna") > 0 ? true : false, rs.getFloat("DuzinaKruga"), rs.getInt("BrojKrugova")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, s, c);
		}
		
		return retVal.get(0);
	}
	
	public int insert(Staza s) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			c = DBUtil.getConnection();
			Object values[] = { s.getNaziv(), s.getMjesto(), s.getDrzava(), s.getKapacitet(), s.isUlicna(), s.getDuzinaKruga(), s.getBrojKrugova() };
			ps = DBUtil.prepareStatement(c, SQL_INSERT, true, values);
			retVal = ps.executeUpdate();
			if (retVal != 0) {
				rs = ps.getGeneratedKeys();
				if (rs.next())
					s.setIdStaze(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, c);
		}

		return retVal;
	}
	
	public int update(Staza s) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			c = DBUtil.getConnection();
			Object values[] = { s.getNaziv(), s.getMjesto(), s.getDrzava(), s.getKapacitet(), s.isUlicna(), s.getDuzinaKruga(), s.getBrojKrugova(), s.getIdStaze() };
			ps = DBUtil.prepareStatement(c, SQL_UPDATE, false, values);
			retVal = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(ps, c);
		}
		return retVal;
	}
	
	public int delete(Staza s) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;

		try {
			c = DBUtil.getConnection();
			Object values[] = { s.getIdStaze() };
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
