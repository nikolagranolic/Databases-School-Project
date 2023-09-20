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
public class KonstruktorUpdateForm extends JFrame {
	private JTextField nazivTextField;
	private JTextField mjestoTextField;
	private JTextField idKonstruktoraTextField;
	private JTextField zemljaTextField;
	private JTextField idProizvodjacaMotoraTextField;
	
	public KonstruktorUpdateForm() {
		setTitle("Izmjena konstruktora");
		setResizable(false);
		setSize(new Dimension(500, 230));
		getContentPane().setLayout(null);
		
		JButton izmijeniButton = new JButton("Izmijeni");
		izmijeniButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkInputValues()) {
					Konstruktor k = new Konstruktor(Integer.parseInt(idKonstruktoraTextField.getText()), nazivTextField.getText(), mjestoTextField.getText(), zemljaTextField.getText(), "", Integer.parseInt(idProizvodjacaMotoraTextField.getText()));
					KonstruktorForm.konstruktorDAO.update(k);
					KonstruktorForm.refresh();
				}
			}
		});
		izmijeniButton.setBounds(389, 146, 89, 23);
		getContentPane().add(izmijeniButton);
		
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
		
		JLabel lblNewLabel_7 = new JLabel("IdKonstruktora:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(51, 148, 157, 14);
		getContentPane().add(lblNewLabel_7);
		
		idKonstruktoraTextField = new JTextField();
		idKonstruktoraTextField.setBounds(218, 147, 62, 20);
		getContentPane().add(idKonstruktoraTextField);
		idKonstruktoraTextField.setColumns(10);
		
		JButton popuniButton = new JButton("Popuni");
		popuniButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Konstruktor k = KonstruktorForm.konstruktorDAO.selectOne(Integer.parseInt(idKonstruktoraTextField.getText()));
				nazivTextField.setText(k.getNaziv());
				mjestoTextField.setText(k.getMjesto());
				zemljaTextField.setText(k.getZemlja());
				idProizvodjacaMotoraTextField.setText(k.getFk_idProizvodjacaMotora() + "");
			}
		});
		popuniButton.setBounds(290, 146, 89, 23);
		getContentPane().add(popuniButton);
		
		JLabel lblNewLabel_2 = new JLabel("Zemlja:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(51, 72, 99, 14);
		getContentPane().add(lblNewLabel_2);
		
		zemljaTextField = new JTextField();
		zemljaTextField.setBounds(160, 71, 165, 20);
		getContentPane().add(zemljaTextField);
		zemljaTextField.setColumns(10);
		
		idProizvodjacaMotoraTextField = new JTextField();
		idProizvodjacaMotoraTextField.setColumns(10);
		idProizvodjacaMotoraTextField.setBounds(218, 102, 107, 20);
		getContentPane().add(idProizvodjacaMotoraTextField);
		
		JLabel lblNewLabel_2_1 = new JLabel("IdProizvodjacaMotora:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(51, 105, 157, 14);
		getContentPane().add(lblNewLabel_2_1);
		setVisible(true);
	}
	
	private boolean checkInputValues() {
		try {
			Integer.parseInt(idKonstruktoraTextField.getText());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
