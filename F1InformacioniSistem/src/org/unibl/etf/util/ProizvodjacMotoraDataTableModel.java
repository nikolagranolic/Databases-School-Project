package org.unibl.etf.util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.unibl.etf.model.ProizvodjacMotora;

@SuppressWarnings("serial")
public class ProizvodjacMotoraDataTableModel extends AbstractTableModel {
	private List<ProizvodjacMotora> proizvodjaciMotora;

	public ProizvodjacMotoraDataTableModel(List<ProizvodjacMotora> proizvodjaciMotora) {
		this.proizvodjaciMotora = proizvodjaciMotora;
	}

	@Override
	public int getRowCount() {
		return proizvodjaciMotora.size();
	}

	@Override
	public String getColumnName(int column) {
		String name = "??";
		switch (column) {
		case 0:
			name = "IdProizvodjacaMotora";
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
		}
		return name;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ProizvodjacMotora proizvodjacMotora = proizvodjaciMotora.get(rowIndex);
		Object value = null;
		switch (columnIndex) {
		case 0:
			value = proizvodjacMotora.getIdProizvodjacaMotora();
			break;
		case 1:
			value = proizvodjacMotora.getNaziv();
			break;
		case 2:
			value = proizvodjacMotora.getMjesto();
			break;
		case 3:
			value = proizvodjacMotora.getZemlja();
			break;
		}
		return value;
	}
}
