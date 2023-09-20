package org.unibl.etf.forms;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.unibl.etf.dao.mysql.MySQLStazaDAO;
import org.unibl.etf.model.Staza;
import org.unibl.etf.util.StazaDataTableModel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class StazaForm extends JFrame {
	private static List<Staza> staze = null;
	public static MySQLStazaDAO stazaDAO = new MySQLStazaDAO();
	
	public static void refresh() {
		staze = stazaDAO.selectAll();
		StazaDataTableModel sdTableModel = new StazaDataTableModel(staze);
		tblStaze.setModel(sdTableModel);	
	}
	
	public StazaForm() {
		setResizable(false);
		setSize(new Dimension(800, 500));
		staze = stazaDAO.selectAll();
		
		initComponents();
	}
	
	private void initComponents() {
		jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStaze = new javax.swing.JTable();
        btnCreateStaza = new javax.swing.JButton();
        btnCreateStaza.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new StazaAddForm().setVisible(true);
        	}
        });
        btnCreateStaza.setText("Dodaj stazu");
        btnUpdateStaza = new javax.swing.JButton();
        btnUpdateStaza.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new StazaUpdateForm().setVisible(true);
        	}
        });
        btnUpdateStaza.setText("Izmijeni stazu");
        btnDeleteStaza = new javax.swing.JButton();
        btnDeleteStaza.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new StazaDeleteForm().setVisible(true);
        	}
        });
        btnDeleteStaza.setText("Obrisi stazu");
        
        StazaDataTableModel sdTableModel = new StazaDataTableModel(staze);
		tblStaze.setModel(sdTableModel);	
        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Staze");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new Font("Tahoma", Font.PLAIN, 23)); // NOI18N
        jLabel2.setText("                                 Staze");

        
        jScrollPane1.setViewportView(tblStaze);

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
                        .addComponent(btnCreateStaza)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdateStaza)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteStaza, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(btnCreateStaza)
                    .addComponent(btnUpdateStaza)
                    .addComponent(btnDeleteStaza))
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
	
	private JButton btnCreateStaza;
    private JButton btnUpdateStaza;
    private JButton btnDeleteStaza;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private static JTable tblStaze;
}
