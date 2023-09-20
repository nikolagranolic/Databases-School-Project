package org.unibl.etf.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.unibl.etf.dao.ZaposleniDAO;
import org.unibl.etf.model.Zaposleni;
import org.unibl.etf.util.DBUtil;

public class MySQLZaposleniDAO implements ZaposleniDAO {
	private static final String SQL_SELECT_ALL = "SELECT * FROM `zaposleni`";
	private static final String SQL_SELECT_ONE = "SELECT * FROM `zaposleni` WHERE IdZaposlenog=";
	private static final String SQL_INSERT = "INSERT INTO `zaposleni` (IdZaposlenog, Ime, Prezime) VALUES (null, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE `zaposleni` SET Ime=?, Prezime=? WHERE IdZaposlenog=?";
	private static final String SQL_DELETE = "DELETE FROM `zaposleni` WHERE IdZaposlenog=?";
	
	public List<Zaposleni> selectAll() {
		List<Zaposleni> retVal = new ArrayList<Zaposleni>();
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		
		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			rs = s.executeQuery(SQL_SELECT_ALL);
			
			while (rs.next()) {
				retVal.add(new Zaposleni(rs.getInt("IdZaposlenog"), rs.getString("Ime"), rs.getString("Prezime")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, s, c);
		}
		
		return retVal;
	}
	
	public Zaposleni selectOne(int id) {
		List<Zaposleni> retVal = new ArrayList<Zaposleni>();
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		
		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			rs = s.executeQuery(SQL_SELECT_ONE + id);
			
			while (rs.next()) {
				retVal.add(new Zaposleni(rs.getInt("IdZaposlenog"), rs.getString("Ime"), rs.getString("Prezime")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, s, c);
		}
		
		return retVal.get(0);
	}
	
	public int insert(Zaposleni z) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			c = DBUtil.getConnection();
			Object values[] = { z.getIme(), z.getPrezime() };
			ps = DBUtil.prepareStatement(c, SQL_INSERT, true, values);
			retVal = ps.executeUpdate();
			if (retVal != 0) {
				rs = ps.getGeneratedKeys();
				if (rs.next())
					z.setIdZaposlenog(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, c);
		}

		return retVal;
	}
	
	public int update(Zaposleni z) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			c = DBUtil.getConnection();
			Object values[] = { z.getIme(), z.getPrezime(), z.getIdZaposlenog() };
			ps = DBUtil.prepareStatement(c, SQL_UPDATE, false, values);
			retVal = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(ps, c);
		}
		return retVal;
	}
	
	public int delete(Zaposleni z) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;

		try {
			c = DBUtil.getConnection();
			Object values[] = { z.getIdZaposlenog() };
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
