package org.unibl.etf.util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.unibl.etf.model.Staza;

@SuppressWarnings("serial")
public class StazaDataTableModel extends AbstractTableModel {
	private List<Staza> staze;
	
	public StazaDataTableModel(List<Staza> staze) {
		this.staze = staze;
	}
	
	@Override
	public int getRowCount() {
		return staze.size();
	}
	
	@Override
    public String getColumnName(int column) {
        String name = "??";
        switch (column) {
            case 0:
                name = "IdStaze";
                break;
            case 1:
                name = "Naziv";
                break;
            case 2:
                name = "Mjesto";
                break;
            case 3:
                name = "Drzava";
                break;
            case 4:
                name = "Kapacitet";
                break;
            case 5:
                name = "IsUlicna";
                break;
            case 6:
                name = "Duzina kruga";
                break;
            case 7:
                name = "Broj krugova";
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
		Staza staza = staze.get(rowIndex);
		Object value = null;
		switch (columnIndex) {
        case 0:
            value = staza.getIdStaze();
            break;
        case 1:
            value = staza.getNaziv();
            break;
        case 2:
            value = staza.getMjesto();
            break;
        case 3:
            value = staza.getDrzava();
            break;
        case 4:
            value = staza.getKapacitet();
            break;
        case 5:
        	value = staza.isUlicna();
        	break;
        case 6:
        	value = staza.getDuzinaKruga();
        	break;
        case 7:
        	value = staza.getBrojKrugova();
        	break;
		}
		return value;
	}

}
