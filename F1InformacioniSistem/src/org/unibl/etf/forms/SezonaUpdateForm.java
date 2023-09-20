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
public class SezonaUpdateForm extends JFrame {
	private JTextField godinaTextField;
	private JTextField brojTrkaTextField;
	private JTextField idSezoneTextField;
	
	public SezonaUpdateForm() {
		setTitle("Izmjena sezone");
		setResizable(false);
		setSize(new Dimension(500, 175));
		getContentPane().setLayout(null);
		
		JButton izmijeniButton = new JButton("Izmijeni");
		izmijeniButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkInputValues()) {
					Sezona s = new Sezona(Integer.parseInt(idSezoneTextField.getText()), Integer.parseInt(godinaTextField.getText()), Integer.parseInt(brojTrkaTextField.getText()));
					SezonaForm.sezonaDAO.update(s);
					SezonaForm.refresh();
				}
			}
		});
		izmijeniButton.setBounds(355, 95, 89, 23);
		getContentPane().add(izmijeniButton);
		
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
		
		JLabel lblNewLabel_7 = new JLabel("IdSezone:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(51, 97, 99, 14);
		getContentPane().add(lblNewLabel_7);
		
		idSezoneTextField = new JTextField();
		idSezoneTextField.setBounds(160, 96, 62, 20);
		getContentPane().add(idSezoneTextField);
		idSezoneTextField.setColumns(10);
		
		JButton popuniButton = new JButton("Popuni");
		popuniButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sezona s = SezonaForm.sezonaDAO.selectOne(Integer.parseInt(idSezoneTextField.getText()));
				godinaTextField.setText(s.getGodina() + "");
				brojTrkaTextField.setText(s.getBrojTrka() + "");
			}
		});
		popuniButton.setBounds(236, 95, 89, 23);
		getContentPane().add(popuniButton);
		setVisible(true);
	}
	
	private boolean checkInputValues() {
		try {
			Integer.parseInt(godinaTextField.getText());
			Integer.parseInt(brojTrkaTextField.getText());
			Integer.parseInt(idSezoneTextField.getText());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
