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
public class SezonaDeleteForm extends JFrame {
	private JTextField idSezoneTextField;
	
	public SezonaDeleteForm() {
		setTitle("Brisanje sezone");
		setResizable(false);
		setSize(new Dimension(500, 150));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("IdSezone:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(71, 47, 99, 14);
		getContentPane().add(lblNewLabel_7);
		
		idSezoneTextField = new JTextField();
		idSezoneTextField.setBounds(198, 46, 62, 20);
		getContentPane().add(idSezoneTextField);
		idSezoneTextField.setColumns(10);
		
		JButton obrisiButton = new JButton("Obrisi");
		obrisiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sezona s = SezonaForm.sezonaDAO.selectOne(Integer.parseInt(idSezoneTextField.getText()));
				SezonaForm.sezonaDAO.delete(s);
				SezonaForm.refresh();
			}
		});
		obrisiButton.setBounds(317, 45, 89, 23);
		getContentPane().add(obrisiButton);
		setVisible(true);
	}
}
