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
public class SponzorDeleteForm extends JFrame {
	private JTextField idSponzoraTextField;
	
	public SponzorDeleteForm() {
		setTitle("Brisanje sponzora");
		setResizable(false);
		setSize(new Dimension(500, 150));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("IdSponzora:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(71, 47, 164, 14);
		getContentPane().add(lblNewLabel_7);
		
		idSponzoraTextField = new JTextField();
		idSponzoraTextField.setBounds(234, 46, 62, 20);
		getContentPane().add(idSponzoraTextField);
		idSponzoraTextField.setColumns(10);
		
		JButton obrisiButton = new JButton("Obrisi");
		obrisiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sponzor s = SponzorForm.sponzorDAO.selectOne(Integer.parseInt(idSponzoraTextField.getText()));
				SponzorForm.sponzorDAO.delete(s);
				SponzorForm.refresh();
			}
		});
		obrisiButton.setBounds(317, 45, 89, 23);
		getContentPane().add(obrisiButton);
		setVisible(true);
	}
}
