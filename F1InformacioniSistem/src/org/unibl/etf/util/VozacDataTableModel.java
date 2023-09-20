package org.unibl.etf.util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.unibl.etf.model.Vozac;

@SuppressWarnings("serial")
public class VozacDataTableModel extends AbstractTableModel {
	private List<Vozac> vozaci;

	public VozacDataTableModel(List<Vozac> vozaci) {
		this.vozaci = vozaci;
	}

	@Override
	public int getRowCount() {
		return vozaci.size();
	}
	
	@Override
	public String getColumnName(int column) {
		String name = "??";
		switch (column) {
		case 0:
			name = "IdVozaca";
			break;
		case 1:
			name = "Ime";
			break;
		case 2:
			name = "Prezime";
			break;
		case 3:
			name = "Zemlja";
			break;
		case 4:
			name = "Plata";
			break;
		case 5:
			name = "Preostalo trajanje ugovora";
			break;
		case 6:
			name = "Ekipa";
			break;
		}
		return name;
	}
	
	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Vozac vozac = vozaci.get(rowIndex);
		Object value = null;
		switch (columnIndex) {
		case 0:
			value = vozac.getIdVozaca();
			break;
		case 1:
			value = vozac.getIme();
			break;
		case 2:
			value = vozac.getPrezime();
			break;
		case 3:
			value = vozac.getZemlja();
			break;
		case 4:
			value = vozac.getPlata();
			break;
		case 5:
			value = vozac.getPreostaloTrajanjeUgovora();
			break;
		case 6:
			value = vozac.getTim();
			break;
		}
		return value;
	}
}
