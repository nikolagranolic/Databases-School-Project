package org.unibl.etf.forms;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.unibl.etf.dao.mysql.MySQLKonstruktorDAO;
import org.unibl.etf.model.Konstruktor;
import org.unibl.etf.util.KonstruktorDataTableModel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class KonstruktorForm extends JFrame {
	private static List<Konstruktor> konstruktori = null;
	public static MySQLKonstruktorDAO konstruktorDAO = new MySQLKonstruktorDAO();
	
	public static void refresh() {
		konstruktori = konstruktorDAO.selectAll();
		KonstruktorDataTableModel sdTableModel = new KonstruktorDataTableModel(konstruktori);
		tblKonstruktori.setModel(sdTableModel);	
	}
	
	public KonstruktorForm() {
		setResizable(false);
		setSize(new Dimension(800, 500));
		konstruktori = konstruktorDAO.selectAll();
		
		initComponents();
	}
	
	private void initComponents() {
		jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKonstruktori = new javax.swing.JTable();
        btnCreateKonstruktor = new javax.swing.JButton();
        btnCreateKonstruktor.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new KonstruktorAddForm().setVisible(true);
        	}
        });
        btnCreateKonstruktor.setText("Dodaj konstruktora");
        btnUpdateKonstruktor = new javax.swing.JButton();
        btnUpdateKonstruktor.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new KonstruktorUpdateForm().setVisible(true);
        	}
        });
        btnUpdateKonstruktor.setText("Izmijeni konstruktora");
        btnDeleteKonstruktor = new javax.swing.JButton();
        btnDeleteKonstruktor.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new KonstruktorDeleteForm().setVisible(true);
        	}
        });
        btnDeleteKonstruktor.setText("Obrisi konstruktora");
        
        KonstruktorDataTableModel sdTableModel = new KonstruktorDataTableModel(konstruktori);
		tblKonstruktori.setModel(sdTableModel);	
        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Konstruktori");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new Font("Tahoma", Font.PLAIN, 23)); // NOI18N
        jLabel2.setText("                         Konstruktori");

        
        jScrollPane1.setViewportView(tblKonstruktori);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCreateKonstruktor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdateKonstruktor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteKonstruktor, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateKonstruktor)
                    .addComponent(btnUpdateKonstruktor)
                    .addComponent(btnDeleteKonstruktor))
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
	}
	
	private JButton btnCreateKonstruktor;
    private JButton btnUpdateKonstruktor;
    private JButton btnDeleteKonstruktor;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private static JTable tblKonstruktori;
}
