package org.unibl.etf.forms;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import org.unibl.etf.model.Sezona;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class PoredakVozacaHelperForm extends JFrame {
	private JComboBox<Sezona> sezonaComboBox;

	public PoredakVozacaHelperForm() {
		setSize(new Dimension(445, 178));
		setResizable(false);
		List<Sezona> sezone = new ArrayList<>();
		for (Sezona s : SezonaForm.sezonaDAO.selectAll()) {
			sezone.add(s);
		}

		DefaultComboBoxModel<Sezona> model2 = new DefaultComboBoxModel<>(sezone.toArray(new Sezona[0]));
		getContentPane().setLayout(null);

		sezonaComboBox = new JComboBox<>(model2);
		sezonaComboBox.setBounds(140, 48, 153, 38);
		sezonaComboBox.setSelectedIndex(0);

		getContentPane().add(sezonaComboBox);
		
		JLabel lblNewLabel = new JLabel("Izaberite sezonu:");
		lblNewLabel.setBounds(174, 23, 98, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Prikazi poredak");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PoredakVozacaForm(((Sezona)sezonaComboBox.getSelectedItem()).getIdSezone()).setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(140, 97, 153, 35);
		getContentPane().add(btnNewButton);
		setVisible(true);
	}
}