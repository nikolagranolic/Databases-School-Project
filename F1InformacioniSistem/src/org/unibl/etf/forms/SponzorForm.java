package org.unibl.etf.forms;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.unibl.etf.dao.mysql.MySQLSponzorDAO;
import org.unibl.etf.model.Sponzor;
import org.unibl.etf.util.SponzorDataTableModel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SponzorForm extends JFrame {
	private static List<Sponzor> sponzori = null;
	public static MySQLSponzorDAO sponzorDAO = new MySQLSponzorDAO();
	
	public static void refresh() {
		sponzori = sponzorDAO.selectAll();
		SponzorDataTableModel sdTableModel = new SponzorDataTableModel(sponzori);
		tblSponzori.setModel(sdTableModel);	
	}
	
	public SponzorForm() {
		setResizable(false);
		setSize(new Dimension(800, 500));
		sponzori = sponzorDAO.selectAll();
		
		initComponents();
	}
	
	private void initComponents() {
		jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSponzori = new javax.swing.JTable();
        btnCreateSponzor = new javax.swing.JButton();
        btnCreateSponzor.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new SponzorAddForm().setVisible(true);
        	}
        });
        btnCreateSponzor.setText("Dodaj sponzora");
        btnUpdateSponzor = new javax.swing.JButton();
        btnUpdateSponzor.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new SponzorUpdateForm().setVisible(true);
        	}
        });
        btnUpdateSponzor.setText("Izmijeni sponzora");
        btnDeleteSponzor = new javax.swing.JButton();
        btnDeleteSponzor.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new SponzorDeleteForm().setVisible(true);
        	}
        });
        btnDeleteSponzor.setText("Obrisi sponzora");
        
        SponzorDataTableModel sdTableModel = new SponzorDataTableModel(sponzori);
		tblSponzori.setModel(sdTableModel);	
        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Sponzor");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new Font("Tahoma", Font.PLAIN, 23)); // NOI18N
        jLabel2.setText("                              Sponzor");

        
        jScrollPane1.setViewportView(tblSponzori);

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
                        .addComponent(btnCreateSponzor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdateSponzor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteSponzor, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(btnCreateSponzor)
                    .addComponent(btnUpdateSponzor)
                    .addComponent(btnDeleteSponzor))
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
	
	private JButton btnCreateSponzor;
    private JButton btnUpdateSponzor;
    private JButton btnDeleteSponzor;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private static JTable tblSponzori;
}
