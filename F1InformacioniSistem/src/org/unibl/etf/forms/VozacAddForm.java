package org.unibl.etf.forms;

import javax.swing.JFrame;
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import org.unibl.etf.model.Konstruktor;
import org.unibl.etf.model.Vozac;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class VozacAddForm extends JFrame {
	private JTextField imeTextField;
	private JTextField prezimeTextField;
	private JTextField zemljaTextField;
	private JTextField plataTextField;
	private JTextField preostaloTrajanjeUgovoraTextField;
	private JComboBox<Konstruktor> comboBox;
	
	public VozacAddForm() {
		setTitle("Dodavanje vozaca");
		setResizable(false);
		setSize(new Dimension(500, 300));
		getContentPane().setLayout(null);
		
		JButton dodajButton = new JButton("Dodaj");
		dodajButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkInputValues()) {
					Vozac v = new Vozac(0, imeTextField.getText(), prezimeTextField.getText(), zemljaTextField.getText(), Integer.parseInt(plataTextField.getText()), Integer.parseInt(preostaloTrajanjeUgovoraTextField.getText()), "", ((Konstruktor)comboBox.getSelectedItem()).getIdKonstruktora());
					VozacForm.vozacDAO.insert(v);
					VozacForm.refresh();
				}
			}
		});
		dodajButton.setBounds(199, 218, 89, 23);
		getContentPane().add(dodajButton);
		
		JLabel lblNewLabel = new JLabel("Ime:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(51, 11, 81, 14);
		getContentPane().add(lblNewLabel);
		
		imeTextField = new JTextField();
		imeTextField.setBounds(160, 10, 165, 20);
		getContentPane().add(imeTextField);
		imeTextField.setColumns(10);
		
		prezimeTextField = new JTextField();
		prezimeTextField.setBounds(160, 41, 165, 20);
		getContentPane().add(prezimeTextField);
		prezimeTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Prezime:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(51, 38, 99, 23);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Zemlja:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(51, 72, 81, 23);
		getContentPane().add(lblNewLabel_2);
		
		zemljaTextField = new JTextField();
		zemljaTextField.setBounds(160, 75, 165, 20);
		getContentPane().add(zemljaTextField);
		zemljaTextField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("IdKonstruktora:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(51, 174, 116, 23);
		getContentPane().add(lblNewLabel_2_1);
		
		plataTextField = new JTextField();
		plataTextField.setColumns(10);
		plataTextField.setBounds(160, 109, 165, 20);
		getContentPane().add(plataTextField);
		
		JLabel lblNewLabel_2_2 = new JLabel("Plata:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(51, 106, 81, 23);
		getContentPane().add(lblNewLabel_2_2);
		
		preostaloTrajanjeUgovoraTextField = new JTextField();
		preostaloTrajanjeUgovoraTextField.setColumns(10);
		preostaloTrajanjeUgovoraTextField.setBounds(251, 143, 74, 20);
		getContentPane().add(preostaloTrajanjeUgovoraTextField);
		
		JLabel lblNewLabel_2_3 = new JLabel("Preostalo trajanje ugovora:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_3.setBounds(51, 140, 190, 23);
		getContentPane().add(lblNewLabel_2_3);
		
		
		
		List<Konstruktor> konstruktori = new ArrayList<>();
		for (Konstruktor k : KonstruktorForm.konstruktorDAO.selectAll()) {
			konstruktori.add(k);
		}

		DefaultComboBoxModel<Konstruktor> model = new DefaultComboBoxModel<>(konstruktori.toArray(new Konstruktor[0]));

		
		comboBox = new JComboBox<Konstruktor>(model);
        comboBox.setSelectedIndex(0);

		comboBox.setBounds(160, 176, 165, 22);
		getContentPane().add(comboBox);
		
		setVisible(true);
	}
	
	private boolean checkInputValues() {
		try {
			Integer.parseInt(plataTextField.getText());
			Integer.parseInt(preostaloTrajanjeUgovoraTextField.getText());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
