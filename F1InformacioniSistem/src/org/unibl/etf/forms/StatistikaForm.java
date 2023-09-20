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
public class StatistikaForm extends JFrame {
    private JTable table;
    private String tip;

    public StatistikaForm(String tip) {
    	this.tip = tip;
        setTitle("Prosjecna " + tip + " Pozicija");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);

        DefaultTableModel tableModel = new DefaultTableModel(
            new Object[][] {},
            new String[] { "Driver ID", "First Name", "Last Name", "Average Position" }
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

            resultSet = statement.executeQuery("CALL CalculateAverage" + tip + "Pozicija()");

            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            while (resultSet.next()) {
                Object[] row = new Object[4];
                row[0] = resultSet.getInt("IdVozaca");
                row[1] = resultSet.getString("Ime");
                row[2] = resultSet.getString("Prezime");
                row[3] = resultSet.getBigDecimal("Avg" + tip + "Pozicija");
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