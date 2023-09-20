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
public class SponzorUpdateForm extends JFrame {
	private JTextField imeTextField;
	private JTextField idSponzoraTextField;
	
	public SponzorUpdateForm() {
		setTitle("Izmjena sponzora");
		setResizable(false);
		setSize(new Dimension(500, 120));
		getContentPane().setLayout(null);
		
		JButton izmijeniButton = new JButton("Izmijeni");
		izmijeniButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkInputValues()) {
					Sponzor s = new Sponzor(Integer.parseInt(idSponzoraTextField.getText()), imeTextField.getText());
					SponzorForm.sponzorDAO.update(s);
					SponzorForm.refresh();
				}
			}
		});
		izmijeniButton.setBounds(357, 40, 89, 23);
		getContentPane().add(izmijeniButton);
		
		JLabel lblNewLabel = new JLabel("Ime:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(51, 11, 81, 14);
		getContentPane().add(lblNewLabel);
		
		imeTextField = new JTextField();
		imeTextField.setBounds(160, 10, 165, 20);
		getContentPane().add(imeTextField);
		imeTextField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("IdSponzora:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(51, 39, 157, 21);
		getContentPane().add(lblNewLabel_7);
		
		idSponzoraTextField = new JTextField();
		idSponzoraTextField.setBounds(160, 41, 62, 20);
		getContentPane().add(idSponzoraTextField);
		idSponzoraTextField.setColumns(10);
		
		JButton popuniButton = new JButton("Popuni");
		popuniButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sponzor s = SponzorForm.sponzorDAO.selectOne(Integer.parseInt(idSponzoraTextField.getText()));
				imeTextField.setText(s.getIme());
			}
		});
		popuniButton.setBounds(236, 40, 89, 23);
		getContentPane().add(popuniButton);
		setVisible(true);
	}
	
	private boolean checkInputValues() {
		try {
			Integer.parseInt(idSponzoraTextField.getText());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
