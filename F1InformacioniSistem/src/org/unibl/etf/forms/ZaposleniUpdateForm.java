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
public class ZaposleniUpdateForm extends JFrame {
	private JTextField imeTextField;
	private JTextField prezimeTextField;
	private JTextField idZaposlenogTextField;
	
	public ZaposleniUpdateForm() {
		setTitle("Izmjena zaposlenog");
		setResizable(false);
		setSize(new Dimension(500, 150));
		getContentPane().setLayout(null);
		
		JButton izmijeniButton = new JButton("Izmijeni");
		izmijeniButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkInputValues()) {
					Zaposleni z = new Zaposleni(Integer.parseInt(idZaposlenogTextField.getText()), imeTextField.getText(), prezimeTextField.getText());
					ZaposleniForm.zaposleniDAO.update(z);
					ZaposleniForm.refresh();
				}
			}
		});
		izmijeniButton.setBounds(356, 71, 89, 23);
		getContentPane().add(izmijeniButton);
		
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
		
		JLabel lblNewLabel_7 = new JLabel("IdZaposlenog:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(50, 70, 157, 21);
		getContentPane().add(lblNewLabel_7);
		
		idZaposlenogTextField = new JTextField();
		idZaposlenogTextField.setBounds(160, 72, 62, 20);
		getContentPane().add(idZaposlenogTextField);
		idZaposlenogTextField.setColumns(10);
		
		JButton popuniButton = new JButton("Popuni");
		popuniButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Zaposleni z = ZaposleniForm.zaposleniDAO.selectOne(Integer.parseInt(idZaposlenogTextField.getText()));
				imeTextField.setText(z.getIme());
				prezimeTextField.setText(z.getPrezime());
			}
		});
		popuniButton.setBounds(236, 71, 89, 23);
		getContentPane().add(popuniButton);
		setVisible(true);
	}
	
	private boolean checkInputValues() {
		try {
			Integer.parseInt(idZaposlenogTextField.getText());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
