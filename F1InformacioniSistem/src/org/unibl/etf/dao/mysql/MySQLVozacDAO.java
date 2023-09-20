package org.unibl.etf.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.unibl.etf.dao.VozacDAO;
import org.unibl.etf.model.Vozac;
import org.unibl.etf.util.DBUtil;

public class MySQLVozacDAO implements VozacDAO {
	private static final String SQL_SELECT_ALL = "SELECT vozac.IdVozaca, vozac.Ime, vozac.Prezime, vozac.Zemlja, vozac.Plata, vozac.PreostaloTrajanjeUgovora, konstruktor.Naziv AS Ekipa "
			+ "FROM vozac "
			+ "JOIN konstruktor ON vozac.IdKonstruktora = konstruktor.IdKonstruktora "
			+ "ORDER BY konstruktor.Naziv ASC";
	private static final String SQL_SELECT_ONE = "SELECT * FROM `vozac` WHERE IdVozaca=";
	private static final String SQL_INSERT = "INSERT INTO `f1_infsys`.`vozac` (`Ime`, `Prezime`, `Zemlja`, `Plata`, `PreostaloTrajanjeUgovora`, `IdKonstruktora`) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE `vozac` SET Ime=?, Prezime=?, Zemlja=?, Plata=?, PreostaloTrajanjeUgovora=?, IdKonstruktora=? WHERE IdVozaca=?";
	private static final String SQL_DELETE = "DELETE FROM `vozac` WHERE IdVozaca=?";

	public List<Vozac> selectAll() {
		List<Vozac> retVal = new ArrayList<Vozac>();
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;

		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			rs = s.executeQuery(SQL_SELECT_ALL);

			while (rs.next()) {
				retVal.add(new Vozac(rs.getInt("IdVozaca"), rs.getString("Ime"), rs.getString("Prezime"), rs.getString("Zemlja"),
						rs.getInt("Plata"), rs.getInt("PreostaloTrajanjeUgovora"), rs.getString("Ekipa"), -1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, s, c);
		}

		return retVal;
	}

	public Vozac selectOne(int id) {
		List<Vozac> retVal = new ArrayList<Vozac>();
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;

		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			rs = s.executeQuery(SQL_SELECT_ONE + id);

			while (rs.next()) {
				retVal.add(new Vozac(rs.getInt("IdVozaca"), rs.getString("Ime"), rs.getString("Prezime"), rs.getString("Zemlja"),
						rs.getInt("Plata"), rs.getInt("PreostaloTrajanjeUgovora"), "", rs.getInt("IdKonstruktora")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, s, c);
		}

		return retVal.get(0);
	}

	public int insert(Vozac v) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			c = DBUtil.getConnection();
			Object values[] = { v.getIme(), v.getPrezime(), v.getZemlja(), v.getPlata(), v.getPreostaloTrajanjeUgovora(), v.getIdKonstruktora() };
			ps = DBUtil.prepareStatement(c, SQL_INSERT, true, values);
			retVal = ps.executeUpdate();
			if (retVal != 0) {
				rs = ps.getGeneratedKeys();
				if (rs.next())
					v.setIdVozaca(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, c);
		}

		return retVal;
	}

	public int update(Vozac v) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;

		try {
			c = DBUtil.getConnection();
			Object values[] = { v.getIme(), v.getPrezime(), v.getZemlja(), v.getPlata(), v.getPreostaloTrajanjeUgovora(), v.getIdKonstruktora(),
					v.getIdVozaca() };
			ps = DBUtil.prepareStatement(c, SQL_UPDATE, false, values);
			retVal = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(ps, c);
		}
		return retVal;
	}

	public int delete(Vozac v) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;

		try {
			c = DBUtil.getConnection();
			Object values[] = { v.getIdVozaca() };
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
