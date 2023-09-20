package org.unibl.etf.forms;

import javax.swing.JFrame;
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import org.unibl.etf.model.Rezultat;
import org.unibl.etf.model.TrkackiVikend;
import org.unibl.etf.model.Vozac;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class RezultatDeleteForm extends JFrame {
	private JComboBox<Integer> idTrkackogVikendaComboBox;
	private JComboBox<Integer> idVozacaComboBox;
	
	public RezultatDeleteForm() {
		setTitle("Brisanje rezultata");
		setResizable(false);
		setSize(new Dimension(500, 150));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("IdVozaca:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(81, 25, 164, 14);
		getContentPane().add(lblNewLabel_7);
		
		JButton obrisiButton = new JButton("Obrisi");
		obrisiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rezultat r = RezultatForm.rezultatDAO.selectOne((Integer)idVozacaComboBox.getSelectedItem(), (Integer)idTrkackogVikendaComboBox.getSelectedItem());
				RezultatForm.rezultatDAO.delete(r);
				RezultatForm.refresh();
			}
		});
		obrisiButton.setBounds(192, 81, 89, 23);
		getContentPane().add(obrisiButton);
		
		JLabel lblNewLabel_7_1 = new JLabel("IdTrkackogVikenda:");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7_1.setBounds(81, 50, 164, 14);
		getContentPane().add(lblNewLabel_7_1);
		
		List<Integer> vozaci = new ArrayList<>();
		for (Vozac k : VozacForm.vozacDAO.selectAll()) {
			vozaci.add(k.getIdVozaca());
		}

		DefaultComboBoxModel<Integer> model = new DefaultComboBoxModel<>(vozaci.toArray(new Integer[0]));

		idVozacaComboBox = new JComboBox<Integer>(model);
		idVozacaComboBox.setBounds(227, 23, 69, 22);
		getContentPane().add(idVozacaComboBox);
		
		List<Integer> trkackiVikendi = new ArrayList<>();
		for (TrkackiVikend k : TrkackiVikendForm.trkackiVikendDAO.selectAll()) {
			trkackiVikendi.add(k.getIdTrkackogVikenda());
		}

		model = new DefaultComboBoxModel<>(trkackiVikendi.toArray(new Integer[0]));

		idTrkackogVikendaComboBox = new JComboBox<Integer>(model);

		idTrkackogVikendaComboBox.setBounds(227, 48, 69, 22);
		getContentPane().add(idTrkackogVikendaComboBox);
		setVisible(true);
	}
}
