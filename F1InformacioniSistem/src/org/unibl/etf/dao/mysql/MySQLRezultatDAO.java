package org.unibl.etf.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.unibl.etf.dao.RezultatDAO;
import org.unibl.etf.model.Rezultat;
import org.unibl.etf.util.DBUtil;

public class MySQLRezultatDAO implements RezultatDAO {
	private static final String SQL_SELECT_ALL = "SELECT * FROM rezultati_simplified";
	private static final String SQL_SELECT_ONE = "SELECT * FROM `rezultat` WHERE `Vozac_IdVozaca`=? AND `Trkacki vikend_IdTrkackogVikenda`=?";
	private static final String SQL_INSERT = "INSERT INTO `rezultat`"
			+ "(`Vozac_IdVozaca`, `Trkacki vikend_IdTrkackogVikenda`, `StartnaPozicija`, `KrajnjaPozicija`, `Vrijeme`, `NajbrziKrug`, `Poeni`, `Konstruktor_IdKonstruktora`)"
			+ " VALUES"
			+ " (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_DELETE = "DELETE FROM `f1_infsys`.`rezultat` WHERE (`Vozac_IdVozaca` = ?) and (`Trkacki vikend_IdTrkackogVikenda` = ?);";
	@Override
	public List<Rezultat> selectAll() {
		List<Rezultat> retVal = new ArrayList<Rezultat>();
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;

		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			rs = s.executeQuery(SQL_SELECT_ALL);

			while (rs.next()) {
				retVal.add(new Rezultat(
						rs.getInt("IdVozaca"), rs.getInt("IdTrke"), rs.getString("Ime"), rs.getString("Prezime"), rs.getString("Trka"),
						-1, rs.getInt("KrajnjaPozicija"), null, false, rs.getInt("Poeni"),
						0, rs.getString("Ekipa")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, s, c);
		}

		return retVal;
	}

	@Override
	public Rezultat selectOne(int idVozaca, int idTrkackogVikenda) {
		List<Rezultat> retVal = new ArrayList<Rezultat>();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			c = DBUtil.getConnection();
			Object values[] = { idVozaca, idTrkackogVikenda };
			ps = DBUtil.prepareStatement(c, SQL_SELECT_ONE, false, values);
			rs = ps.executeQuery();

			while (rs.next()) {
				retVal.add(new Rezultat(
						rs.getInt("Vozac_IdVozaca"), rs.getInt("Trkacki vikend_IdTrkackogVikenda"), "", "", "",
						-1, -1, null, false, -1,
						0, ""));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, c);
		}

		return retVal.get(0);
	}

	@Override
	public int insert(Rezultat r) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			c = DBUtil.getConnection();
			Object values[] = { r.getIdVozaca(), r.getIdTrkackogVikenda(), r.getStartnaPozicija(), r.getKrajnjaPozicija(), r.getVrijeme(), r.isNajbrziKrug(), r.getPoeni(), r.getIdKonstruktora() };
			ps = DBUtil.prepareStatement(c, SQL_INSERT, true, values);
			retVal = ps.executeUpdate();
			if (retVal != 0) {
				rs = ps.getGeneratedKeys();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, c);
		}

		return retVal;
	}

	@Override
	public int update(Rezultat r) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int delete(Rezultat r) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;

		try {
			c = DBUtil.getConnection();
			Object values[] = { r.getIdVozaca(), r.getIdTrkackogVikenda() };
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
