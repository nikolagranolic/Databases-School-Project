package org.unibl.etf.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.unibl.etf.dao.SponzorDAO;
import org.unibl.etf.model.Sponzor;
import org.unibl.etf.util.DBUtil;

public class MySQLSponzorDAO implements SponzorDAO {
	private static final String SQL_SELECT_ALL = "SELECT * FROM `sponzor`";
	private static final String SQL_SELECT_ONE = "SELECT * FROM `sponzor` WHERE IdSponzora=";
	private static final String SQL_INSERT = "INSERT INTO `sponzor` (IdSponzora, Naziv) VALUES (null, ?)";
	private static final String SQL_UPDATE = "UPDATE `sponzor` SET Naziv=? WHERE IdSponzora=?";
	private static final String SQL_DELETE = "DELETE FROM `sponzor` WHERE IdSponzora=?";
	
	public List<Sponzor> selectAll() {
		List<Sponzor> retVal = new ArrayList<Sponzor>();
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		
		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			rs = s.executeQuery(SQL_SELECT_ALL);
			
			while (rs.next()) {
				retVal.add(new Sponzor(rs.getInt("IdSponzora"), rs.getString("Naziv")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, s, c);
		}
		
		return retVal;
	}
	
	public Sponzor selectOne(int id) {
		List<Sponzor> retVal = new ArrayList<Sponzor>();
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		
		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			rs = s.executeQuery(SQL_SELECT_ONE + id);
			
			while (rs.next()) {
				retVal.add(new Sponzor(rs.getInt("IdSponzora"), rs.getString("Naziv")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, s, c);
		}
		
		return retVal.get(0);
	}
	
	public int insert(Sponzor s) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			c = DBUtil.getConnection();
			Object values[] = { s.getIme() };
			ps = DBUtil.prepareStatement(c, SQL_INSERT, true, values);
			retVal = ps.executeUpdate();
			if (retVal != 0) {
				rs = ps.getGeneratedKeys();
				if (rs.next())
					s.setIdSponzora(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, c);
		}

		return retVal;
	}
	
	public int update(Sponzor s) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			c = DBUtil.getConnection();
			Object values[] = { s.getIme(), s.getIdSponzora() };
			ps = DBUtil.prepareStatement(c, SQL_UPDATE, false, values);
			retVal = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(ps, c);
		}
		return retVal;
	}
	
	public int delete(Sponzor s) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;

		try {
			c = DBUtil.getConnection();
			Object values[] = { s.getIdSponzora() };
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
