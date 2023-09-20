package org.unibl.etf.forms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.unibl.etf.util.DBUtil;

import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class PoredakVozacaForm extends JFrame {
    private JTable table;
    private int idSezone;

    public PoredakVozacaForm(int idSezone) {
    	this.idSezone = idSezone;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);

        DefaultTableModel tableModel = new DefaultTableModel(
            new Object[][] {},
            new String[] { "Ime", "Prezime", "BrojPoena", "Pozicija" }
        );

        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        fetchAndPopulateData();

        setVisible(true);
    }

    private void fetchAndPopulateData() {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();

            statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT\r\n"
            		+ "    v.Ime,\r\n"
            		+ "    v.Prezime, p.BrojPoena,\r\n"
            		+ "    (SELECT COUNT(*) + 1 FROM poredak_u_konkurenciji_vozaca p2 WHERE p2.Sezona_IdSezone = p.Sezona_IdSezone AND p2.BrojPoena > p.BrojPoena) AS Pozicija\r\n"
            		+ "FROM\r\n"
            		+ "    vozac v\r\n"
            		+ "    JOIN poredak_u_konkurenciji_vozaca p ON v.IdVozaca = p.Vozac_IdVozaca\r\n"
            		+ "WHERE\r\n"
            		+ "    p.Sezona_IdSezone = " + idSezone + "\r\n"
            		+ "ORDER BY\r\n"
            		+ "    p.BrojPoena DESC;\r\n");

            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            while (resultSet.next()) {
                Object[] row = new Object[4];
                row[0] = resultSet.getString("Ime");
                row[1] = resultSet.getString("Prezime");
                row[2] = resultSet.getInt("BrojPoena");
                row[3] = resultSet.getInt("Pozicija");
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}