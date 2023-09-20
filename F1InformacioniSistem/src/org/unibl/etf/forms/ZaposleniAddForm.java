package org.unibl.etf.forms;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import org.unibl.etf.model.Zaposleni;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ZaposleniAddForm extends JFrame {
	private JTextField imeTextField;
	private JTextField prezimeTextField;
	
	public ZaposleniAddForm() {
		setTitle("Dodavanje zaposlenog");
		setResizable(false);
		setSize(new Dimension(500, 150));
		getContentPane().setLayout(null);
		
		JButton dodajButton = new JButton("Dodaj");
		dodajButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkInputValues()) {
					Zaposleni z = new Zaposleni(0, imeTextField.getText(), prezimeTextField.getText());
					ZaposleniForm.zaposleniDAO.insert(z);
					ZaposleniForm.refresh();
				}
			}
		});
		dodajButton.setBounds(198, 77, 89, 23);
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
