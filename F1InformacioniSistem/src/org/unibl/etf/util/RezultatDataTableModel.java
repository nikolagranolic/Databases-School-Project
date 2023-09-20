package org.unibl.etf.util;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.unibl.etf.model.Rezultat;

@SuppressWarnings("serial")
public class RezultatDataTableModel extends AbstractTableModel {
	private List<Rezultat> rezultati;

	public RezultatDataTableModel(List<Rezultat> rezultati) {
		this.rezultati = rezultati;
	}
	
	@Override
	public int getRowCount() {
		return rezultati.size();
	}

	@Override
	public String getColumnName(int column) {
		String name = "??";
		switch (column) {
		case 0:
			name = "IdVozaca";
			break;
		case 1:
			name = "IdTrke";
			break;
		case 2:
			name = "Ime";
			break;
		case 3:
			name = "Prezime";
			break;
		case 4:
			name = "Ekipa";
			break;
		case 5:
			name = "Trka";
			break;
		case 6:
			name = "Krajnja pozicija";
			break;
		case 7:
			name = "Poeni";
			break;
		}
		return name;
	}
	
	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Rezultat rezultat = rezultati.get(rowIndex);
		Object value = null;
		switch (columnIndex) {
		case 0:
			value = rezultat.getIdVozaca();
			break;
		case 1:
			value = rezultat.getIdTrkackogVikenda();
			break;
		case 2:
			value = rezultat.getVozacIme();
			break;
		case 3:
			value = rezultat.getVozacPrezime();
			break;
		case 4:
			value = rezultat.getEkipa();
			break;
		case 5:
			value = rezultat.getNazivVelikeNagrade();
			break;
		case 6:
			value = rezultat.getKrajnjaPozicija();
			break;
		case 7:
			value = rezultat.getPoeni();
			break;
		}
		return value;
	}
}
