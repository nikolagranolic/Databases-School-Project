package org.unibl.etf.util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.unibl.etf.model.Sponzor;

@SuppressWarnings("serial")
public class SponzorDataTableModel extends AbstractTableModel {
	private List<Sponzor> sponzor;

	public SponzorDataTableModel(List<Sponzor> sponzor) {
		this.sponzor = sponzor;
	}
	
	@Override
	public int getRowCount() {
		return sponzor.size();
	}
	
	@Override
    public String getColumnName(int column) {
        String name = "??";
        switch (column) {
            case 0:
                name = "IdSponzora";
                break;
            case 1:
                name = "Ime";
                break;
        }
        return name;
    }
	
	@Override
	public int getColumnCount() {
		return 2;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Sponzor zaposlen = sponzor.get(rowIndex);
		Object value = null;
		switch (columnIndex) {
	        case 0:
	            value = zaposlen.getIdSponzora();
	            break;
	        case 1:
	            value = zaposlen.getIme();
	            break;
		}
		return value;
	}
}
