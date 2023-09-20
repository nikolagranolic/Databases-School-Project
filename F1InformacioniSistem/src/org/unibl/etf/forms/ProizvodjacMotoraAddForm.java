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
public class ProizvodjacMotoraAddForm extends JFrame {
	private JTextField nazivTextField;
	private JTextField mjestoTextField;
	private JTextField zemljaTextField;
	
	public ProizvodjacMotoraAddForm() {
		setTitle("Dodavanje proizvodjaca motora");
		setResizable(false);
		setSize(new Dimension(500, 200));
		getContentPane().setLayout(null);
		
		JButton dodajButton = new JButton("Dodaj");
		dodajButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkInputValues()) {
					ProizvodjacMotora p = new ProizvodjacMotora(0, nazivTextField.getText(), mjestoTextField.getText(), zemljaTextField.getText());
					ProizvodjacMotoraForm.proizvodjaciMotoraDAO.insert(p);
					ProizvodjacMotoraForm.refresh();
				}
			}
		});
		dodajButton.setBounds(198, 120, 89, 23);
		getContentPane().add(dodajButton);
		
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
		
		JLabel lblNewLabel_2 = new JLabel("Zemlja:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(51, 72, 81, 23);
		getContentPane().add(lblNewLabel_2);
		
		zemljaTextField = new JTextField();
		zemljaTextField.setBounds(160, 75, 165, 20);
		getContentPane().add(zemljaTextField);
		zemljaTextField.setColumns(10);
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
