package org.unibl.etf.forms;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import org.unibl.etf.model.Vozac;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VozacUpdateForm extends JFrame {
	private JTextField imeTextField;
	private JTextField prezimeTextField;
	private JTextField idVozacaTextField;
	private JTextField zemljaTextField;
	private JTextField idKonstruktoraTextField;
	private JTextField preostaloTrajanjeUgovoraTextField;
	private JTextField plataTextField;
	
	public VozacUpdateForm() {
		setTitle("Izmjena vozaca");
		setResizable(false);
		setSize(new Dimension(500, 280));
		getContentPane().setLayout(null);
		
		JButton izmijeniButton = new JButton("Izmijeni");
		izmijeniButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkInputValues()) {
					Vozac v = new Vozac(Integer.parseInt(idVozacaTextField.getText()), imeTextField.getText(), prezimeTextField.getText(), zemljaTextField.getText(), Integer.parseInt(plataTextField.getText()), Integer.parseInt(preostaloTrajanjeUgovoraTextField.getText()), "", Integer.parseInt(idKonstruktoraTextField.getText()));
					VozacForm.vozacDAO.update(v);
					VozacForm.refresh();
				}
			}
		});
		izmijeniButton.setBounds(389, 211, 89, 23);
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
		
		JLabel lblNewLabel_7 = new JLabel("IdVozaca:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(51, 213, 157, 14);
		getContentPane().add(lblNewLabel_7);
		
		idVozacaTextField = new JTextField();
		idVozacaTextField.setBounds(218, 212, 62, 20);
		getContentPane().add(idVozacaTextField);
		idVozacaTextField.setColumns(10);
		
		JButton popuniButton = new JButton("Popuni");
		popuniButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vozac v = VozacForm.vozacDAO.selectOne(Integer.parseInt(idVozacaTextField.getText()));
				imeTextField.setText(v.getIme());
				prezimeTextField.setText(v.getPrezime());
				zemljaTextField.setText(v.getZemlja());
				plataTextField.setText(v.getPlata() + "");
				preostaloTrajanjeUgovoraTextField.setText(v.getPreostaloTrajanjeUgovora() + "");
				idKonstruktoraTextField.setText(v.getIdKonstruktora() + "");
			}
		});
		popuniButton.setBounds(290, 211, 89, 23);
		getContentPane().add(popuniButton);
		
		JLabel lblNewLabel_2 = new JLabel("Zemlja:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(51, 72, 99, 14);
		getContentPane().add(lblNewLabel_2);
		
		zemljaTextField = new JTextField();
		zemljaTextField.setBounds(160, 71, 165, 20);
		getContentPane().add(zemljaTextField);
		zemljaTextField.setColumns(10);
		
		idKonstruktoraTextField = new JTextField();
		idKonstruktoraTextField.setColumns(10);
		idKonstruktoraTextField.setBounds(218, 161, 107, 20);
		getContentPane().add(idKonstruktoraTextField);
		
		JLabel lblNewLabel_2_1 = new JLabel("IdKonstruktora:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(51, 164, 157, 14);
		getContentPane().add(lblNewLabel_2_1);
		
		preostaloTrajanjeUgovoraTextField = new JTextField();
		preostaloTrajanjeUgovoraTextField.setColumns(10);
		preostaloTrajanjeUgovoraTextField.setBounds(242, 130, 83, 20);
		getContentPane().add(preostaloTrajanjeUgovoraTextField);
		
		plataTextField = new JTextField();
		plataTextField.setColumns(10);
		plataTextField.setBounds(160, 100, 165, 20);
		getContentPane().add(plataTextField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Plata:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(51, 97, 99, 23);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Preostalo trajanje ugovora:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(51, 131, 181, 14);
		getContentPane().add(lblNewLabel_2_2);
		setVisible(true);
	}
	
	private boolean checkInputValues() {
		try {
			Integer.parseInt(plataTextField.getText());
			Integer.parseInt(preostaloTrajanjeUgovoraTextField.getText());
			Integer.parseInt(idVozacaTextField.getText());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
