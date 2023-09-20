package org.unibl.etf.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.unibl.etf.dao.SezonaDAO;
import org.unibl.etf.model.Sezona;
import org.unibl.etf.util.DBUtil;

public class MySQLSezonaDAO implements SezonaDAO {
	private static final String SQL_SELECT_ALL = "SELECT * FROM `sezona`";
	private static final String SQL_SELECT_ONE = "SELECT * FROM `sezona` WHERE IdSezone=";
	private static final String SQL_INSERT = "INSERT INTO `sezona` (IdSezone, Godina, BrojTrka) VALUES (null, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE `sezona` SET Godina=?, BrojTrka=? WHERE IdSezone=?";
	private static final String SQL_DELETE = "DELETE FROM `sezona` WHERE IdSezone=?";
	
	public List<Sezona> selectAll() {
		List<Sezona> retVal = new ArrayList<Sezona>();
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		
		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			rs = s.executeQuery(SQL_SELECT_ALL);
			
			while (rs.next()) {
				retVal.add(new Sezona(rs.getInt("IdSezone"), rs.getInt("Godina"), rs.getInt("BrojTrka")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, s, c);
		}
		
		return retVal;
	}
	
	public Sezona selectOne(int id) {
		List<Sezona> retVal = new ArrayList<Sezona>();
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		
		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			rs = s.executeQuery(SQL_SELECT_ONE + id);
			
			while (rs.next()) {
				retVal.add(new Sezona(rs.getInt("IdSezone"), rs.getInt("Godina"), rs.getInt("BrojTrka")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, s, c);
		}
		
		return retVal.get(0);
	}
	
	public int insert(Sezona s) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			c = DBUtil.getConnection();
			Object values[] = { s.getGodina(), s.getBrojTrka() };
			ps = DBUtil.prepareStatement(c, SQL_INSERT, true, values);
			retVal = ps.executeUpdate();
			if (retVal != 0) {
				rs = ps.getGeneratedKeys();
				if (rs.next())
					s.setIdSezone(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, c);
		}

		return retVal;
	}
	
	public int update(Sezona s) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			c = DBUtil.getConnection();
			Object values[] = { s.getGodina(), s.getBrojTrka(), s.getIdSezone() };
			ps = DBUtil.prepareStatement(c, SQL_UPDATE, false, values);
			retVal = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(ps, c);
		}
		return retVal;
	}
	
	public int delete(Sezona s) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;

		try {
			c = DBUtil.getConnection();
			Object values[] = { s.getIdSezone() };
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
