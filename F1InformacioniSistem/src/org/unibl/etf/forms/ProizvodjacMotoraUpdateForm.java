package org.unibl.etf.forms;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import org.unibl.etf.model.ProizvodjacMotora;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ProizvodjacMotoraUpdateForm extends JFrame {
	private JTextField nazivTextField;
	private JTextField mjestoTextField;
	private JTextField idProizvodjacaMotoraTextField;
	private JTextField zemljaTextField;
	
	public ProizvodjacMotoraUpdateForm() {
		setTitle("Izmjena proizvodjaca motora");
		setResizable(false);
		setSize(new Dimension(500, 175));
		getContentPane().setLayout(null);
		
		JButton izmijeniButton = new JButton("Izmijeni");
		izmijeniButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkInputValues()) {
					ProizvodjacMotora p = new ProizvodjacMotora(Integer.parseInt(idProizvodjacaMotoraTextField.getText()), nazivTextField.getText(), mjestoTextField.getText(), zemljaTextField.getText());
					ProizvodjacMotoraForm.proizvodjaciMotoraDAO.update(p);
					ProizvodjacMotoraForm.refresh();
				}
			}
		});
		izmijeniButton.setBounds(389, 113, 89, 23);
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
		
		JLabel lblNewLabel_7 = new JLabel("IdProizvodjacaMotora:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(51, 115, 157, 14);
		getContentPane().add(lblNewLabel_7);
		
		idProizvodjacaMotoraTextField = new JTextField();
		idProizvodjacaMotoraTextField.setBounds(218, 114, 62, 20);
		getContentPane().add(idProizvodjacaMotoraTextField);
		idProizvodjacaMotoraTextField.setColumns(10);
		
		JButton popuniButton = new JButton("Popuni");
		popuniButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProizvodjacMotora s = ProizvodjacMotoraForm.proizvodjaciMotoraDAO.selectOne(Integer.parseInt(idProizvodjacaMotoraTextField.getText()));
				nazivTextField.setText(s.getNaziv());
				mjestoTextField.setText(s.getMjesto());
				zemljaTextField.setText(s.getZemlja());
			}
		});
		popuniButton.setBounds(290, 113, 89, 23);
		getContentPane().add(popuniButton);
		
		JLabel lblNewLabel_2 = new JLabel("Zemlja:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(51, 72, 99, 14);
		getContentPane().add(lblNewLabel_2);
		
		zemljaTextField = new JTextField();
		zemljaTextField.setBounds(160, 71, 165, 20);
		getContentPane().add(zemljaTextField);
		zemljaTextField.setColumns(10);
		setVisible(true);
	}
	
	private boolean checkInputValues() {
		try {
			Integer.parseInt(idProizvodjacaMotoraTextField.getText());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
