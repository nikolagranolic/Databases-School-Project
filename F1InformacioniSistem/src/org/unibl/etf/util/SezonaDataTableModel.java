package org.unibl.etf.util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.unibl.etf.model.Sezona;

@SuppressWarnings("serial")
public class SezonaDataTableModel extends AbstractTableModel {
	private List<Sezona> sezone;

	public SezonaDataTableModel(List<Sezona> sezone) {
		this.sezone = sezone;
	}
	
	@Override
	public int getRowCount() {
		return sezone.size();
	}
	
	@Override
    public String getColumnName(int column) {
        String name = "??";
        switch (column) {
            case 0:
                name = "IdSezone";
                break;
            case 1:
                name = "Godina";
                break;
            case 2:
                name = "Broj trka";
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
		Sezona sezona = sezone.get(rowIndex);
		Object value = null;
		switch (columnIndex) {
        case 0:
            value = sezona.getIdSezone();
            break;
        case 1:
            value = sezona.getGodina();
            break;
        case 2:
            value = sezona.getBrojTrka();
            break;
		}
		return value;
	}
}
