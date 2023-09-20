package org.unibl.etf.forms;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.unibl.etf.model.TrkackiVikend;

@SuppressWarnings("serial")
public class TrkackiVikendUpdateForm extends JFrame {
	private JTextField redniBrojTextField;
	private JTextField nazivTextField;
	private JTextField pocetakTextField;
	private JTextField idSezoneTextField;
	private JTextField krajTextField;
	private JTextField trkaTextField;
	private JTextField idStazeTextField;
	private JTextField kvalifikacijeTextField;
	private JTextField prviTreningTextField;
	private JTextField drugiTreningTextField;
	private JTextField treciTreningTextField;
	private JTextField idTrkackogVikendaTextField;

	public TrkackiVikendUpdateForm() {
		setTitle("Izmjena trkackog vikenda");
		setResizable(false);
		setSize(new Dimension(500, 529));
		getContentPane().setLayout(null);

		JButton popuniButton = new JButton("Popuni");
		popuniButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrkackiVikend t = TrkackiVikendForm.trkackiVikendDAO.selectOne(Integer.parseInt(idTrkackogVikendaTextField.getText()));
				redniBrojTextField.setText(t.getRedniBroj() + "");
				nazivTextField.setText(t.getNazivVelikeNagrade());
				pocetakTextField.setText(t.getDatumPocetka() + "");
				krajTextField.setText(t.getDatumKraja() + "");
				trkaTextField.setText(t.getVrijemeTrke() + "");
				kvalifikacijeTextField.setText(t.getVrijemeKvalifikacija() + "");
				prviTreningTextField.setText(t.getVrijemePrvogTreninga() + "");
				drugiTreningTextField.setText(t.getVrijemeDrugogTreninga() + "");
				treciTreningTextField.setText(t.getVrijemeTrecegTreninga() + "");
				idStazeTextField.setText(t.getIdStaze() + "");
				idSezoneTextField.setText(t.getIdSezone() + "");
			}
		});
		popuniButton.setBounds(200, 444, 89, 23);
		getContentPane().add(popuniButton);

		JLabel lblNewLabel = new JLabel("R.b. trkackog vikenda:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(51, 11, 165, 14);
		getContentPane().add(lblNewLabel);

		redniBrojTextField = new JTextField();
		redniBrojTextField.setBounds(214, 10, 111, 20);
		getContentPane().add(redniBrojTextField);
		redniBrojTextField.setColumns(10);

		nazivTextField = new JTextField();
		nazivTextField.setBounds(160, 41, 165, 20);
		getContentPane().add(nazivTextField);
		nazivTextField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Naziv VN:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(51, 38, 127, 23);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Datum pocetka:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(51, 72, 127, 23);
		getContentPane().add(lblNewLabel_2);

		pocetakTextField = new JTextField();
		pocetakTextField.setText("yyyy-mm-dd");
		pocetakTextField.setToolTipText("yyyy-mm-dd");
		pocetakTextField.setBounds(214, 75, 111, 20);
		getContentPane().add(pocetakTextField);
		pocetakTextField.setColumns(10);

		idSezoneTextField = new JTextField();
		idSezoneTextField.setColumns(10);
		idSezoneTextField.setBounds(214, 346, 111, 20);
		getContentPane().add(idSezoneTextField);

		JLabel lblNewLabel_2_1 = new JLabel("IdSezone:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(51, 343, 165, 23);
		getContentPane().add(lblNewLabel_2_1);

		krajTextField = new JTextField();
		krajTextField.setToolTipText("yyyy-mm-dd");
		krajTextField.setText("yyyy-mm-dd");
		krajTextField.setColumns(10);
		krajTextField.setBounds(214, 109, 111, 20);
		getContentPane().add(krajTextField);

		JLabel lblNewLabel_2_2 = new JLabel("Datum kraja:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(51, 106, 127, 23);
		getContentPane().add(lblNewLabel_2_2);

		trkaTextField = new JTextField();
		trkaTextField.setToolTipText("hh:mm:ss");
		trkaTextField.setText("hh:mm:ss");
		trkaTextField.setColumns(10);
		trkaTextField.setBounds(214, 143, 111, 20);
		getContentPane().add(trkaTextField);

		JLabel lblNewLabel_2_3 = new JLabel("Vrijeme trke:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_3.setBounds(51, 140, 149, 23);
		getContentPane().add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_1_1 = new JLabel("IdStaze:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(51, 310, 165, 23);
		getContentPane().add(lblNewLabel_2_1_1);

		idStazeTextField = new JTextField();
		idStazeTextField.setColumns(10);
		idStazeTextField.setBounds(214, 313, 111, 20);
		getContentPane().add(idStazeTextField);

		kvalifikacijeTextField = new JTextField();
		kvalifikacijeTextField.setToolTipText("hh:mm:ss");
		kvalifikacijeTextField.setText("hh:mm:ss");
		kvalifikacijeTextField.setColumns(10);
		kvalifikacijeTextField.setBounds(214, 177, 111, 20);
		getContentPane().add(kvalifikacijeTextField);

		JLabel lblNewLabel_2_3_1 = new JLabel("Vrijeme kvalifikacija:");
		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_3_1.setBounds(51, 174, 149, 23);
		getContentPane().add(lblNewLabel_2_3_1);

		prviTreningTextField = new JTextField();
		prviTreningTextField.setToolTipText("hh:mm:ss");
		prviTreningTextField.setText("hh:mm:ss");
		prviTreningTextField.setColumns(10);
		prviTreningTextField.setBounds(214, 211, 111, 20);
		getContentPane().add(prviTreningTextField);

		JLabel lblNewLabel_2_3_2 = new JLabel("Vrijeme 1. treninga:");
		lblNewLabel_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_3_2.setBounds(51, 208, 149, 23);
		getContentPane().add(lblNewLabel_2_3_2);

		drugiTreningTextField = new JTextField();
		drugiTreningTextField.setText("hh:mm:ss");
		drugiTreningTextField.setToolTipText("hh:mm:ss");
		drugiTreningTextField.setColumns(10);
		drugiTreningTextField.setBounds(214, 245, 111, 20);
		getContentPane().add(drugiTreningTextField);

		JLabel lblNewLabel_2_3_3 = new JLabel("Vrijeme 2. treninga:");
		lblNewLabel_2_3_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_3_3.setBounds(51, 242, 149, 23);
		getContentPane().add(lblNewLabel_2_3_3);

		treciTreningTextField = new JTextField();
		treciTreningTextField.setToolTipText("hh:mm:ss");
		treciTreningTextField.setText("hh:mm:ss");
		treciTreningTextField.setColumns(10);
		treciTreningTextField.setBounds(214, 279, 111, 20);
		getContentPane().add(treciTreningTextField);

		JLabel lblNewLabel_2_3_3_1 = new JLabel("Vrijeme 3. treninga:");
		lblNewLabel_2_3_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_3_3_1.setBounds(51, 276, 149, 23);
		getContentPane().add(lblNewLabel_2_3_3_1);
		
		idTrkackogVikendaTextField = new JTextField();
		idTrkackogVikendaTextField.setColumns(10);
		idTrkackogVikendaTextField.setBounds(214, 413, 111, 20);
		getContentPane().add(idTrkackogVikendaTextField);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("IdTrkackogVikenda:");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_2.setBounds(51, 410, 165, 23);
		getContentPane().add(lblNewLabel_2_1_2);
		
		JButton izmijeniBtn = new JButton("Izmijeni");
		izmijeniBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkInputValues()) {
					TrkackiVikend t = new TrkackiVikend(Integer.parseInt(idTrkackogVikendaTextField.getText()), Integer.parseInt(redniBrojTextField.getText()),
							nazivTextField.getText(), Date.valueOf(pocetakTextField.getText()),
							Date.valueOf(krajTextField.getText()), Time.valueOf(trkaTextField.getText()),
							Time.valueOf(kvalifikacijeTextField.getText()),
							Time.valueOf(prviTreningTextField.getText()), Time.valueOf(drugiTreningTextField.getText()),
							Time.valueOf(treciTreningTextField.getText()), Integer.parseInt(idStazeTextField.getText()),
							"", Integer.parseInt(idSezoneTextField.getText()), -1);
					TrkackiVikendForm.trkackiVikendDAO.update(t);
					TrkackiVikendForm.refresh();
				}
			}
		});
		izmijeniBtn.setBounds(357, 444, 89, 23);
		getContentPane().add(izmijeniBtn);
		setVisible(true);
	}
	
	private boolean checkInputValues() {
		try {
			Integer.parseInt(idSezoneTextField.getText());
			Integer.parseInt(idStazeTextField.getText());
			Integer.parseInt(redniBrojTextField.getText());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
