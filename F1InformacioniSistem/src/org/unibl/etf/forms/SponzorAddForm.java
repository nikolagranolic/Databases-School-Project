package org.unibl.etf.forms;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import org.unibl.etf.model.Sponzor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SponzorAddForm extends JFrame {
	private JTextField imeTextField;
	
	public SponzorAddForm() {
		setTitle("Dodavanje sponzora");
		setResizable(false);
		setSize(new Dimension(500, 120));
		getContentPane().setLayout(null);
		
		JButton dodajButton = new JButton("Dodaj");
		dodajButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkInputValues()) {
					Sponzor s = new Sponzor(0, imeTextField.getText());
					SponzorForm.sponzorDAO.insert(s);
					SponzorForm.refresh();
				}
			}
		});
		dodajButton.setBounds(200, 51, 89, 23);
		getContentPane().add(dodajButton);
		
		JLabel lblNewLabel = new JLabel("Ime:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(51, 11, 81, 14);
		getContentPane().add(lblNewLabel);
		
		imeTextField = new JTextField();
		imeTextField.setBounds(160, 10, 165, 20);
		getContentPane().add(imeTextField);
		imeTextField.setColumns(10);
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
