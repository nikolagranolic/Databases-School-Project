package org.unibl.etf.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.unibl.etf.dao.KonstruktorDAO;
import org.unibl.etf.model.Konstruktor;
import org.unibl.etf.util.DBUtil;

public class MySQLKonstruktorDAO implements KonstruktorDAO {
	private static final String SQL_SELECT_ALL = "SELECT konstruktor.IdKonstruktora, konstruktor.Naziv, konstruktor.Mjesto, konstruktor.Zemlja, proizvodjac_motora.Naziv AS ProizvodjacMotoraNaziv "
			+ "FROM konstruktor "
			+ "JOIN proizvodjac_motora ON konstruktor.IdProizvodjacaMotora = proizvodjac_motora.IdProizvodjacaMotora "
			+ "ORDER BY proizvodjac_motora.Naziv ASC";
	private static final String SQL_SELECT_ONE = "SELECT * FROM `konstruktor` WHERE IdKonstruktora=";
	private static final String SQL_INSERT = "INSERT INTO `f1_infsys`.`konstruktor` (`Naziv`, `Mjesto`, `Zemlja`, `IdProizvodjacaMotora`) VALUES (?, ?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE `konstruktor` SET Naziv=?, Mjesto=?, Zemlja=?, IdProizvodjacaMotora=? WHERE IdKonstruktora=?";
	private static final String SQL_DELETE = "DELETE FROM `konstruktor` WHERE IdKonstruktora=?";

	public List<Konstruktor> selectAll() {
		List<Konstruktor> retVal = new ArrayList<Konstruktor>();
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;

		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			rs = s.executeQuery(SQL_SELECT_ALL);

			while (rs.next()) {
				retVal.add(new Konstruktor(rs.getInt("IdKonstruktora"), rs.getString("Naziv"), rs.getString("Mjesto"),
						rs.getString("Zemlja"), rs.getString("ProizvodjacMotoraNaziv"), -1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, s, c);
		}

		return retVal;
	}

	public Konstruktor selectOne(int id) {
		List<Konstruktor> retVal = new ArrayList<Konstruktor>();
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;

		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			rs = s.executeQuery(SQL_SELECT_ONE + id);

			while (rs.next()) {
				retVal.add(new Konstruktor(rs.getInt("IdKonstruktora"), rs.getString("Naziv"),
						rs.getString("Mjesto"), rs.getString("Zemlja"), "", rs.getInt("IdProizvodjacaMotora")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, s, c);
		}

		return retVal.get(0);
	}

	public int insert(Konstruktor k) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			c = DBUtil.getConnection();
			Object values[] = { k.getNaziv(), k.getMjesto(), k.getZemlja(), k.getFk_idProizvodjacaMotora() };
			ps = DBUtil.prepareStatement(c, SQL_INSERT, true, values);
			retVal = ps.executeUpdate();
			if (retVal != 0) {
				rs = ps.getGeneratedKeys();
				if (rs.next())
					k.setIdKonstruktora(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, c);
		}

		return retVal;
	}

	public int update(Konstruktor k) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;

		try {
			c = DBUtil.getConnection();
			Object values[] = { k.getNaziv(), k.getMjesto(), k.getZemlja(), k.getFk_idProizvodjacaMotora(),
					k.getIdKonstruktora() };
			ps = DBUtil.prepareStatement(c, SQL_UPDATE, false, values);
			retVal = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(ps, c);
		}
		return retVal;
	}

	public int delete(Konstruktor k) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;

		try {
			c = DBUtil.getConnection();
			Object values[] = { k.getIdKonstruktora() };
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
