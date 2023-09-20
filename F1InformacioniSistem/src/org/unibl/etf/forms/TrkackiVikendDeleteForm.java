package org.unibl.etf.forms;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.unibl.etf.model.TrkackiVikend;

@SuppressWarnings("serial")
public class TrkackiVikendDeleteForm extends JFrame {
	private JTextField idTrkackogVikenda;

	public TrkackiVikendDeleteForm() {
		setTitle("Brisanje trkackog vikenda");
		setResizable(false);
		setSize(new Dimension(500, 150));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("IdTrkackogVikenda:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(71, 47, 164, 14);
		getContentPane().add(lblNewLabel_7);
		
		idTrkackogVikenda = new JTextField();
		idTrkackogVikenda.setBounds(234, 46, 62, 20);
		getContentPane().add(idTrkackogVikenda);
		idTrkackogVikenda.setColumns(10);
		
		JButton obrisiButton = new JButton("Obrisi");
		obrisiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrkackiVikend t = TrkackiVikendForm.trkackiVikendDAO.selectOne(Integer.parseInt(idTrkackogVikenda.getText()));
				TrkackiVikendForm.trkackiVikendDAO.delete(t);
				TrkackiVikendForm.refresh();
			}
		});
		obrisiButton.setBounds(317, 45, 89, 23);
		getContentPane().add(obrisiButton);
		setVisible(true);
	}

}
