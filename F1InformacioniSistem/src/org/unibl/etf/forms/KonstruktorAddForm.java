package org.unibl.etf.forms;

import javax.swing.JFrame;
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import org.unibl.etf.model.Konstruktor;
import org.unibl.etf.model.ProizvodjacMotora;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class KonstruktorAddForm extends JFrame {
	private JTextField nazivTextField;
	private JTextField mjestoTextField;
	private JTextField zemljaTextField;
	private JComboBox<ProizvodjacMotora> comboBox;
	
	public KonstruktorAddForm() {
		setTitle("Dodavanje konstruktora");
		setResizable(false);
		setSize(new Dimension(500, 250));
		getContentPane().setLayout(null);
		
		JButton dodajButton = new JButton("Dodaj");
		dodajButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkInputValues()) {
					Konstruktor k = new Konstruktor(0, nazivTextField.getText(), mjestoTextField.getText(), zemljaTextField.getText(), "", ((ProizvodjacMotora)comboBox.getSelectedItem()).getIdProizvodjacaMotora());
					KonstruktorForm.konstruktorDAO.insert(k);
					KonstruktorForm.refresh();
				}
			}
		});
		dodajButton.setBounds(198, 154, 89, 23);
		getContentPane().add(dodajButton);
		
		JLabel lblNewLabel = new JLabel("Naziv:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(51, 11, 81, 14);
		getContentPane().add(lblNewLabel);
		
		nazivTextField = new JTextField();
		nazivTextField.setBounds(160, 10, 165, 20);
		getContentPane().add(nazivTextField);
		nazivTextField.setColumns(10);
		
		mjestoTextField = new JTextField();
		mjestoTextField.setBounds(160, 41, 165, 20);
		getContentPane().add(mjestoTextField);
		mjestoTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mjesto:");
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
		
		
		List<ProizvodjacMotora> proizvodjaciMotora = new ArrayList<>();
		for (ProizvodjacMotora p : ProizvodjacMotoraForm.proizvodjaciMotoraDAO.selectAll()) {
			proizvodjaciMotora.add(p);
		}
		
		DefaultComboBoxModel<ProizvodjacMotora> model = new DefaultComboBoxModel<>(proizvodjaciMotora.toArray(new ProizvodjacMotora[0]));

		
		comboBox = new JComboBox<>(model);
        comboBox.setSelectedIndex(0);

		comboBox.setBounds(218, 106, 107, 22);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_2_1 = new JLabel("Proizvodjac motora:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(51, 103, 157, 23);
		getContentPane().add(lblNewLabel_2_1);
		setVisible(true);
	}
	
	private boolean checkInputValues() {
		try {
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
