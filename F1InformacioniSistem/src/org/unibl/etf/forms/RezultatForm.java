package org.unibl.etf.forms;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JFrame;
import org.unibl.etf.dao.mysql.MySQLRezultatDAO;
import org.unibl.etf.model.Rezultat;
import org.unibl.etf.util.RezultatDataTableModel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class RezultatForm extends JFrame {
	private static List<Rezultat> rezultati = null;
	public static MySQLRezultatDAO rezultatDAO = new MySQLRezultatDAO();
	
	public static void refresh() {
		rezultati = rezultatDAO.selectAll();
		RezultatDataTableModel sdTableModel = new RezultatDataTableModel(rezultati);
		tblRezultati.setModel(sdTableModel);	
	}
	
	public RezultatForm() {
		setSize(new Dimension(1000, 500));
		rezultati = rezultatDAO.selectAll();
		
		initComponents();
	}
	
	private void initComponents() {
		jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRezultati = new javax.swing.JTable();
        btnCreateRezultat = new javax.swing.JButton();
        btnCreateRezultat.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new RezultatAddForm().setVisible(true);
        	}
        });
        btnCreateRezultat.setText("Dodaj rezultat");
        btnUpdateRezultat = new javax.swing.JButton();
        btnUpdateRezultat.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
//        		new RezultatUpdateForm().setVisible(true);
        	}
        });
        btnUpdateRezultat.setText("Izmijeni rezultat");
        btnDeleteRezultat = new javax.swing.JButton();
        btnDeleteRezultat.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new RezultatDeleteForm().setVisible(true);
        	}
        });
        btnDeleteRezultat.setText("Obrisi rezultat");
        
        RezultatDataTableModel sdTableModel = new RezultatDataTableModel(rezultati);
		tblRezultati.setModel(sdTableModel);	
        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Rezultati");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new Font("Tahoma", Font.PLAIN, 23)); // NOI18N
        jLabel2.setText("                              Rezultati");

        
        jScrollPane1.setViewportView(tblRezultati);

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
                        .addComponent(btnCreateRezultat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdateRezultat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteRezultat, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(btnCreateRezultat)
                    .addComponent(btnUpdateRezultat)
                    .addComponent(btnDeleteRezultat))
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
	
	private JButton btnCreateRezultat;
    private JButton btnUpdateRezultat;
    private JButton btnDeleteRezultat;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private static JTable tblRezultati;
}
