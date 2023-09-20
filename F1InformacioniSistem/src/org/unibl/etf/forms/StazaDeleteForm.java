package org.unibl.etf.forms;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import org.unibl.etf.model.Staza;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class StazaDeleteForm extends JFrame {
	private JTextField idStazeTextField;
	
	public StazaDeleteForm() {
		setTitle("Brisanje staze");
		setResizable(false);
		setSize(new Dimension(500, 150));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("IdStaze:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(71, 47, 99, 14);
		getContentPane().add(lblNewLabel_7);
		
		idStazeTextField = new JTextField();
		idStazeTextField.setBounds(198, 46, 62, 20);
		getContentPane().add(idStazeTextField);
		idStazeTextField.setColumns(10);
		
		JButton obrisiButton = new JButton("Obrisi");
		obrisiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Staza s = StazaForm.stazaDAO.selectOne(Integer.parseInt(idStazeTextField.getText()));
				StazaForm.stazaDAO.delete(s);
				StazaForm.refresh();
			}
		});
		obrisiButton.setBounds(317, 45, 89, 23);
		getContentPane().add(obrisiButton);
		setVisible(true);
	}
}
