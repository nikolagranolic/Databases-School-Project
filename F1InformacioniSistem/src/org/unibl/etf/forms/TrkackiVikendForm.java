package org.unibl.etf.forms;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.unibl.etf.dao.mysql.MySQLTrkackiVikendDAO;
import org.unibl.etf.model.TrkackiVikend;
import org.unibl.etf.util.TrkackiVikendDataTableModel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TrkackiVikendForm extends JFrame {
	private static List<TrkackiVikend> trkackiVikendi = null;
	public static MySQLTrkackiVikendDAO trkackiVikendDAO = new MySQLTrkackiVikendDAO();
	
	public static void refresh() {
		trkackiVikendi = trkackiVikendDAO.selectAll();
		TrkackiVikendDataTableModel sdTableModel = new TrkackiVikendDataTableModel(trkackiVikendi);
		tblTrkackiVikendi.setModel(sdTableModel);	
	}
	
	public TrkackiVikendForm() {
		setSize(new Dimension(901, 674));
		trkackiVikendi = trkackiVikendDAO.selectAll();
		
		initComponents();
	}
	
	private void initComponents() {
		jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTrkackiVikendi = new javax.swing.JTable();
        btnCreateTrkackiVikend = new javax.swing.JButton();
        btnCreateTrkackiVikend.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new TrkackiVikendAddForm().setVisible(true);
        	}
        });
        btnCreateTrkackiVikend.setText("Dodaj trkacki vikend");
        btnUpdateTrkackiVikend = new javax.swing.JButton();
        btnUpdateTrkackiVikend.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new TrkackiVikendUpdateForm().setVisible(true);
        	}
        });
        btnUpdateTrkackiVikend.setText("Izmijeni trkacki vikend");
        btnDeleteTrkackiVikend = new javax.swing.JButton();
        btnDeleteTrkackiVikend.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new TrkackiVikendDeleteForm().setVisible(true);
        	}
        });
        btnDeleteTrkackiVikend.setText("Obrisi trkacki vikend");
        
        TrkackiVikendDataTableModel sdTableModel = new TrkackiVikendDataTableModel(trkackiVikendi);
		tblTrkackiVikendi.setModel(sdTableModel);	
        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Trkacki vikendi");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new Font("Tahoma", Font.PLAIN, 23)); // NOI18N
        jLabel2.setText("                              Trkacki vikendi");

        
        jScrollPane1.setViewportView(tblTrkackiVikendi);

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
                        .addComponent(btnCreateTrkackiVikend)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdateTrkackiVikend)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteTrkackiVikend, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(btnCreateTrkackiVikend)
                    .addComponent(btnUpdateTrkackiVikend)
                    .addComponent(btnDeleteTrkackiVikend))
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
	
	private JButton btnCreateTrkackiVikend;
    private JButton btnUpdateTrkackiVikend;
    private JButton btnDeleteTrkackiVikend;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private static JTable tblTrkackiVikendi;
}
