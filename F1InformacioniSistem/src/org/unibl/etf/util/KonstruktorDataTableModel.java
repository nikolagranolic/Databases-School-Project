package org.unibl.etf.util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.unibl.etf.model.Konstruktor;

@SuppressWarnings("serial")
public class KonstruktorDataTableModel extends AbstractTableModel {
	private List<Konstruktor> konstruktori;

	public KonstruktorDataTableModel(List<Konstruktor> konstruktori) {
		this.konstruktori = konstruktori;
	}

	@Override
	public int getRowCount() {
		return konstruktori.size();
	}

	@Override
	public String getColumnName(int column) {
		String name = "??";
		switch (column) {
		case 0:
			name = "IdKonstruktora";
			break;
		case 1:
			name = "Naziv";
			break;
		case 2:
			name = "Mjesto";
			break;
		case 3:
			name = "Zemlja";
			break;
		case 4:
			name = "ProizvodjacMotora";
			break;
		}
		return name;
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Konstruktor konstruktor = konstruktori.get(rowIndex);
		Object value = null;
		switch (columnIndex) {
		case 0:
			value = konstruktor.getIdKonstruktora();
			break;
		case 1:
			value = konstruktor.getNaziv();
			break;
		case 2:
			value = konstruktor.getMjesto();
			break;
		case 3:
			value = konstruktor.getZemlja();
			break;
		case 4:
			value = konstruktor.getNazivProizvodjacaMotora();
			break;
		}
		return value;
	}
}
