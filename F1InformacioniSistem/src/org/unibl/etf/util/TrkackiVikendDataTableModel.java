package org.unibl.etf.util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.unibl.etf.model.TrkackiVikend;

@SuppressWarnings("serial")
public class TrkackiVikendDataTableModel extends AbstractTableModel {
	private List<TrkackiVikend> trkackiVikendi;

	public TrkackiVikendDataTableModel(List<TrkackiVikend> trkackiVikendi) {
		this.trkackiVikendi = trkackiVikendi;
	}
	
	@Override
	public int getRowCount() {
		return trkackiVikendi.size();
	}

	@Override
	public String getColumnName(int column) {
		String name = "??";
		switch (column) {
		case 0:
			name = "IdTrkackogVikenda";
			break;
		case 1:
			name = "R.b.";
			break;
		case 2:
			name = "Naziv VN";
			break;
		case 3:
			name = "Od";
			break;
		case 4:
			name = "Do";
			break;
		case 5:
			name = "Trka";
			break;
		case 6:
			name = "Kvalifikacije";
			break;
		case 7:
			name = "1. trening";
			break;
		case 8:
			name = "2. trening";
			break;
		case 9:
			name = "3. trening";
			break;
		case 10:
			name = "Staza";
			break;
		case 11:
			name = "Sezona";
			break;
		}
		return name;
	}
	
	@Override
	public int getColumnCount() {
		return 12;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		TrkackiVikend trkackiVikend = trkackiVikendi.get(rowIndex);
		Object value = null;
		switch (columnIndex) {
		case 0:
			value = trkackiVikend.getIdTrkackogVikenda();
			break;
		case 1:
			value = trkackiVikend.getRedniBroj();
			break;
		case 2:
			value = trkackiVikend.getNazivVelikeNagrade();
			break;
		case 3:
			value = trkackiVikend.getDatumPocetka();
			break;
		case 4:
			value = trkackiVikend.getDatumKraja();
			break;
		case 5:
			value = trkackiVikend.getVrijemeTrke();
			break;
		case 6:
			value = trkackiVikend.getVrijemeKvalifikacija();
			break;
		case 7:
			value = trkackiVikend.getVrijemePrvogTreninga();
			break;
		case 8:
			value = trkackiVikend.getVrijemeDrugogTreninga();
			break;
		case 9:
			value = trkackiVikend.getVrijemeTrecegTreninga();
			break;
		case 10:
			value = trkackiVikend.getStaza();
			break;
		case 11:
			value = trkackiVikend.getGodina();
			break;
		}
		return value;
	}
}
