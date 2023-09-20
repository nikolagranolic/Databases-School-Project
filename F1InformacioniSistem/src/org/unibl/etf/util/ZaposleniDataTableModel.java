package org.unibl.etf.util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.unibl.etf.model.Zaposleni;

@SuppressWarnings("serial")
public class ZaposleniDataTableModel extends AbstractTableModel {
	private List<Zaposleni> zaposleni;

	public ZaposleniDataTableModel(List<Zaposleni> zaposleni) {
		this.zaposleni = zaposleni;
	}
	
	@Override
	public int getRowCount() {
		return zaposleni.size();
	}
	
	@Override
    public String getColumnName(int column) {
        String name = "??";
        switch (column) {
            case 0:
                name = "IdZaposlenog";
                break;
            case 1:
                name = "Ime";
                break;
            case 2:
                name = "Prezime";
                break;
        }
        return name;
    }
	
	@Override
	public int getColumnCount() {
		return 3;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Zaposleni zaposlen = zaposleni.get(rowIndex);
		Object value = null;
		switch (columnIndex) {
	        case 0:
	            value = zaposlen.getIdZaposlenog();
	            break;
	        case 1:
	            value = zaposlen.getIme();
	            break;
	        case 2:
	            value = zaposlen.getPrezime();
	            break;
		}
		return value;
	}
}
