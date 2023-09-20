package org.unibl.etf.forms;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import org.unibl.etf.model.Staza;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class StazaAddForm extends JFrame {
	private JTextField nazivTextField;
	private JTextField mjestoTextField;
	private JTextField drzavaTextField;
	private JTextField kapacitetTextField;
	private JTextField duzinaKrugaTextBox;
	private JTextField brojKrugovaTextBox;
	private JCheckBox ulicnaCheckBox;
	
	public StazaAddForm() {
		setTitle("Kreiranje staze");
		setResizable(false);
		setSize(new Dimension(500, 300));
		getContentPane().setLayout(null);
		
		JButton dodajButton = new JButton("Dodaj");
		dodajButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkInputValues()) {
					Staza s = new Staza(0, nazivTextField.getText(), mjestoTextField.getText(), drzavaTextField.getText(),
							Integer.parseInt(kapacitetTextField.getText()), ulicnaCheckBox.isSelected(), 
							Float.parseFloat(duzinaKrugaTextBox.getText()), Integer.parseInt(brojKrugovaTextBox.getText()));
					StazaForm.stazaDAO.insert(s);
					StazaForm.refresh();
				}
			}
		});
		dodajButton.setBounds(199, 227, 89, 23);
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
		
		drzavaTextField = new JTextField();
		drzavaTextField.setBounds(160, 72, 165, 20);
		getContentPane().add(drzavaTextField);
		drzavaTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Drzava:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(51, 75, 99, 14);
		getContentPane().add(lblNewLabel_2);
		
		kapacitetTextField = new JTextField();
		kapacitetTextField.setBounds(160, 103, 165, 20);
		getContentPane().add(kapacitetTextField);
		kapacitetTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Kapacitet:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(51, 106, 99, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ulicna:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(51, 137, 48, 14);
		getContentPane().add(lblNewLabel_4);
		
		ulicnaCheckBox = new JCheckBox("");
		ulicnaCheckBox.setBounds(226, 135, 99, 23);
		getContentPane().add(ulicnaCheckBox);
		
		duzinaKrugaTextBox = new JTextField();
		duzinaKrugaTextBox.setBounds(160, 165, 165, 20);
		getContentPane().add(duzinaKrugaTextBox);
		duzinaKrugaTextBox.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Duzina kruga:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(51, 162, 99, 23);
		getContentPane().add(lblNewLabel_5);
		
		brojKrugovaTextBox = new JTextField();
		brojKrugovaTextBox.setBounds(160, 196, 165, 20);
		getContentPane().add(brojKrugovaTextBox);
		brojKrugovaTextBox.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Broj krugova:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(51, 193, 104, 23);
		getContentPane().add(lblNewLabel_6);
		setVisible(true);
	}
	
	private boolean checkInputValues() {
		try {
			Integer.parseInt(kapacitetTextField.getText());
			Float.parseFloat(duzinaKrugaTextBox.getText());
			Integer.parseInt(brojKrugovaTextBox.getText());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
