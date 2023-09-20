package org.unibl.etf.forms;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import org.unibl.etf.model.Sezona;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SezonaAddForm extends JFrame {
	private JTextField godinaTextField;
	private JTextField brojTrkaTextField;
	
	public SezonaAddForm() {
		setTitle("Dodavanje sezone");
		setResizable(false);
		setSize(new Dimension(500, 150));
		getContentPane().setLayout(null);
		
		JButton dodajButton = new JButton("Dodaj");
		dodajButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkInputValues()) {
					Sezona s = new Sezona(0, Integer.parseInt(godinaTextField.getText()), Integer.parseInt(brojTrkaTextField.getText()));
					SezonaForm.sezonaDAO.insert(s);
					SezonaForm.refresh();
				}
			}
		});
		dodajButton.setBounds(199, 72, 89, 23);
		getContentPane().add(dodajButton);
		
		JLabel lblNewLabel = new JLabel("Godina:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(51, 11, 81, 14);
		getContentPane().add(lblNewLabel);
		
		godinaTextField = new JTextField();
		godinaTextField.setBounds(160, 10, 165, 20);
		getContentPane().add(godinaTextField);
		godinaTextField.setColumns(10);
		
		brojTrkaTextField = new JTextField();
		brojTrkaTextField.setBounds(160, 41, 165, 20);
		getContentPane().add(brojTrkaTextField);
		brojTrkaTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Broj trka:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(51, 38, 99, 23);
		getContentPane().add(lblNewLabel_1);
		setVisible(true);
	}
	
	private boolean checkInputValues() {
		try {
			Integer.parseInt(godinaTextField.getText());
			Integer.parseInt(brojTrkaTextField.getText());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
