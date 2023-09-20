package org.unibl.etf.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.unibl.etf.dao.TrkackiVikendDAO;
import org.unibl.etf.model.TrkackiVikend;
import org.unibl.etf.util.DBUtil;

public class MySQLTrkackiVikendDAO implements TrkackiVikendDAO {
	private static final String SQL_SELECT_ALL = "SELECT trkacki_vikend.IdTrkackogVikenda, trkacki_vikend.RedniBroj, trkacki_vikend.NazivVelikeNagrade, trkacki_vikend.DatumPocetka,\r\n"
			+ "trkacki_vikend.DatumKraja, trkacki_vikend.VrijemeTrke, trkacki_vikend.VrijemeKvalifikacija,\r\n"
			+ "trkacki_vikend.VrijemePrvogTreninga, trkacki_vikend.VrijemeDrugogTreninga, trkacki_vikend.VrijemeTrecegTreninga,\r\n"
			+ "staza.Naziv AS Staza, sezona.Godina AS Sezona\r\n"
			+ "FROM trkacki_vikend\r\n"
			+ "JOIN staza ON trkacki_vikend.Staza_IdStaze = staza.IdStaze\r\n"
			+ "JOIN sezona ON trkacki_vikend.Sezona_IdSezone = sezona.IdSezone\r\n"
			+ "ORDER BY trkacki_vikend.RedniBroj ASC;";
	private static final String SQL_SELECT_ONE = "SELECT * FROM `trkacki_vikend` WHERE IdTrkackogVikenda=";
	private static final String SQL_INSERT = "INSERT INTO `f1_infsys`.`trkacki_vikend` (`RedniBroj`, `NazivVelikeNagrade`, `DatumPocetka`, `DatumKraja`, `VrijemeTrke`, `VrijemeKvalifikacija`, `VrijemePrvogTreninga`, `VrijemeDrugogTreninga`, `VrijemeTrecegTreninga`, `Staza_IdStaze`, `Sezona_IdSezone`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE `trkacki_vikend` SET RedniBroj=?, NazivVelikeNagrade=?, DatumPocetka=?, DatumKraja=?, VrijemeTrke=?, VrijemeKvalifikacija=?, VrijemePrvogTreninga=?, VrijemeDrugogTreninga=?, VrijemeTrecegTreninga=?, Staza_IdStaze=?, Sezona_IdSezone=? WHERE IdTrkackogVikenda=?";
	private static final String SQL_DELETE = "DELETE FROM `trkacki_vikend` WHERE IdTrkackogVikenda=?";
	
	public List<TrkackiVikend> selectAll() {
		List<TrkackiVikend> retVal = new ArrayList<TrkackiVikend>();
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;

		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			rs = s.executeQuery(SQL_SELECT_ALL);

			while (rs.next()) {
				retVal.add(new TrkackiVikend(rs.getInt("IdTrkackogVikenda"), rs.getInt("RedniBroj"), rs.getString("NazivVelikeNagrade"), rs.getDate("DatumPocetka"), rs.getDate("DatumKraja"),
						rs.getTime("VrijemeTrke"), rs.getTime("VrijemeKvalifikacija"), rs.getTime("VrijemePrvogTreninga"), rs.getTime("VrijemeDrugogTreninga"), rs.getTime("VrijemeTrecegTreninga"),
						-1, rs.getString("Staza"), -1, rs.getInt("Sezona")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, s, c);
		}

		return retVal;
	}

	public TrkackiVikend selectOne(int id) {
		List<TrkackiVikend> retVal = new ArrayList<TrkackiVikend>();
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;

		try {
			c = DBUtil.getConnection();
			s = c.createStatement();
			rs = s.executeQuery(SQL_SELECT_ONE + id);

			while (rs.next()) {
				retVal.add(new TrkackiVikend(rs.getInt("IdTrkackogVikenda"), rs.getInt("RedniBroj"), rs.getString("NazivVelikeNagrade"), rs.getDate("DatumPocetka"), rs.getDate("DatumKraja"),
						rs.getTime("VrijemeTrke"), rs.getTime("VrijemeKvalifikacija"), rs.getTime("VrijemePrvogTreninga"), rs.getTime("VrijemeDrugogTreninga"), rs.getTime("VrijemeTrecegTreninga"),
						rs.getInt("Staza_IdStaze"), "", rs.getInt("Sezona_IdSezone"), 0));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, s, c);
		}

		return retVal.get(0);
	}

	public int insert(TrkackiVikend t) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			c = DBUtil.getConnection();
			Object values[] = { t.getRedniBroj(), t.getNazivVelikeNagrade(), t.getDatumPocetka(), t.getDatumKraja(), t.getVrijemeTrke(), t.getVrijemeKvalifikacija(), t.getVrijemePrvogTreninga(), t.getVrijemeDrugogTreninga(), t.getVrijemeTrecegTreninga(), t.getIdStaze(), t.getIdSezone() };
			ps = DBUtil.prepareStatement(c, SQL_INSERT, true, values);
			retVal = ps.executeUpdate();
			if (retVal != 0) {
				rs = ps.getGeneratedKeys();
				if (rs.next())
					t.setIdTrkackogVikenda(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, c);
		}

		return retVal;
	}

	public int update(TrkackiVikend t) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;

		try {
			c = DBUtil.getConnection();
			Object values[] = { t.getRedniBroj(), t.getNazivVelikeNagrade(), t.getDatumPocetka(), t.getDatumKraja(),
					t.getVrijemeTrke(), t.getVrijemeKvalifikacija(), t.getVrijemePrvogTreninga(), t.getVrijemeDrugogTreninga(),
					t.getVrijemeTrecegTreninga(), t.getIdStaze(), t.getIdSezone(),
					t.getIdTrkackogVikenda() };
			ps = DBUtil.prepareStatement(c, SQL_UPDATE, false, values);
			retVal = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(ps, c);
		}
		return retVal;
	}

	public int delete(TrkackiVikend t) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;

		try {
			c = DBUtil.getConnection();
			Object values[] = { t.getIdTrkackogVikenda() };
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
