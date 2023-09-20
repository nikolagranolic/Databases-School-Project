package org.unibl.etf.forms;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import org.unibl.etf.model.Konstruktor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class KonstruktorDeleteForm extends JFrame {
	private JTextField idKonstruktoraTextField;
	
	public KonstruktorDeleteForm() {
		setTitle("Brisanje konstruktora");
		setResizable(false);
		setSize(new Dimension(500, 150));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("IdKonstruktora:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(71, 47, 164, 14);
		getContentPane().add(lblNewLabel_7);
		
		idKonstruktoraTextField = new JTextField();
		idKonstruktoraTextField.setBounds(234, 46, 62, 20);
		getContentPane().add(idKonstruktoraTextField);
		idKonstruktoraTextField.setColumns(10);
		
		JButton obrisiButton = new JButton("Obrisi");
		obrisiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Konstruktor k = KonstruktorForm.konstruktorDAO.selectOne(Integer.parseInt(idKonstruktoraTextField.getText()));
				KonstruktorForm.konstruktorDAO.delete(k);
				KonstruktorForm.refresh();
			}
		});
		obrisiButton.setBounds(317, 45, 89, 23);
		getContentPane().add(obrisiButton);
		setVisible(true);
	}
}
