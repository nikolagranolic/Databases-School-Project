package org.unibl.etf.forms;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.unibl.etf.model.Konstruktor;
import org.unibl.etf.model.Rezultat;
import org.unibl.etf.model.TrkackiVikend;
import org.unibl.etf.model.Vozac;

@SuppressWarnings("serial")
public class RezultatAddForm extends JFrame {
	private JComboBox<Integer> krajnjaPozicijaComboBox;
	private JTextField vrijemeTextField;
	private JComboBox<Boolean> najbrziKrugComboBox;
	private JComboBox<Konstruktor> idKonstruktoraComboBox;
	private JComboBox<Integer> startnaPozicijaComboBox;
	private JComboBox<TrkackiVikend> idTrkackogVikendaComboBox;
	private JComboBox<Vozac> idVozacaComboBox;

	public RezultatAddForm() {
		setTitle("Dodavanje rezultata");
		setResizable(false);
		setSize(new Dimension(500, 313));
		getContentPane().setLayout(null);

		JButton dodajButton = new JButton("Dodaj");
		dodajButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int poeni;
				switch ((int) krajnjaPozicijaComboBox.getSelectedItem()) {
				case 1:
					poeni = 25;
					break;
				case 2:
					poeni = 18;
					break;
				case 3:
					poeni = 15;
					break;
				case 4:
					poeni = 12;
					break;
				case 5:
					poeni = 10;
					break;
				case 6:
					poeni = 8;
					break;
				case 7:
					poeni = 6;
					break;
				case 8:
					poeni = 4;
					break;
				case 9:
					poeni = 2;
					break;
				case 10:
					poeni = 1;
					break;
				default:
					poeni = 0;
				}
				if ((int) krajnjaPozicijaComboBox.getSelectedItem() <= 10 && (boolean) najbrziKrugComboBox.getSelectedItem()) {
					poeni++;
				}
				if (checkInputValues()) {
					Rezultat r = new Rezultat(((Vozac) idVozacaComboBox.getSelectedItem()).getIdVozaca(),
							((TrkackiVikend) idTrkackogVikendaComboBox.getSelectedItem()).getIdTrkackogVikenda(), "",
							"", "", (int) startnaPozicijaComboBox.getSelectedItem(),
							(int) krajnjaPozicijaComboBox.getSelectedItem(), Time.valueOf(vrijemeTextField.getText()),
							(boolean) najbrziKrugComboBox.getSelectedItem(), poeni,
							((Konstruktor) idKonstruktoraComboBox.getSelectedItem()).getIdKonstruktora(), "");

					RezultatForm.rezultatDAO.insert(r);
					RezultatForm.refresh();
				}
			}
		});
		dodajButton.setBounds(193, 241, 89, 23);
		getContentPane().add(dodajButton);

		JLabel lblNewLabel = new JLabel("Vozac:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(51, 11, 81, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Trka:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(51, 38, 165, 23);
		getContentPane().add(lblNewLabel_1);

		JLabel textfield2 = new JLabel("Startna pozicija:");
		textfield2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textfield2.setBounds(51, 72, 139, 23);
		getContentPane().add(textfield2);

		List<Integer> pozicije = new ArrayList<>();

		for (int i = 1; i <= 20; i++) {
			pozicije.add(i);
		}

		DefaultComboBoxModel<Integer> model = new DefaultComboBoxModel<>(pozicije.toArray(new Integer[0]));

		krajnjaPozicijaComboBox = new JComboBox<>(model);
		krajnjaPozicijaComboBox.setSelectedIndex(0);
		krajnjaPozicijaComboBox.setBounds(226, 106, 99, 22);
		getContentPane().add(krajnjaPozicijaComboBox);

		List<Integer> pozicije2 = new ArrayList<>();

		for (int i = 1; i <= 20; i++) {
			pozicije2.add(i);
		}

		DefaultComboBoxModel<Integer> model2 = new DefaultComboBoxModel<>(pozicije2.toArray(new Integer[0]));

		startnaPozicijaComboBox = new JComboBox<Integer>(model2);
		startnaPozicijaComboBox.setSelectedIndex(0);
		startnaPozicijaComboBox.setBounds(226, 74, 99, 22);
		getContentPane().add(startnaPozicijaComboBox);

		JLabel lblNewLabel_2_1 = new JLabel("Konstruktor:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(51, 207, 157, 23);
		getContentPane().add(lblNewLabel_2_1);

		JLabel textfield3 = new JLabel("Krajnja pozicija:");
		textfield3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textfield3.setBounds(51, 105, 139, 23);
		getContentPane().add(textfield3);

		JLabel textfield4 = new JLabel("Vrijeme:");
		textfield4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textfield4.setBounds(51, 139, 139, 23);
		getContentPane().add(textfield4);

		JLabel textfield6 = new JLabel("Najbrzi krug:");
		textfield6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textfield6.setBounds(51, 173, 139, 23);
		getContentPane().add(textfield6);

		vrijemeTextField = new JTextField();
		vrijemeTextField.setColumns(10);
		vrijemeTextField.setBounds(226, 142, 99, 20);
		getContentPane().add(vrijemeTextField);

		List<Boolean> najbrziKrug = new ArrayList<>();
		najbrziKrug.add(true);
		najbrziKrug.add(false);
		for (int i = 1; i <= 20; i++) {
			pozicije.add(i);
		}

		DefaultComboBoxModel<Boolean> model1 = new DefaultComboBoxModel<>(najbrziKrug.toArray(new Boolean[0]));

		najbrziKrugComboBox = new JComboBox<Boolean>(model1);
		najbrziKrugComboBox.setSelectedIndex(0);
		najbrziKrugComboBox.setBounds(226, 175, 99, 22);
		getContentPane().add(najbrziKrugComboBox);

		List<Konstruktor> konstruktori = new ArrayList<>();
		for (Konstruktor k : KonstruktorForm.konstruktorDAO.selectAll()) {
			konstruktori.add(k);
		}

		DefaultComboBoxModel<Konstruktor> modelK = new DefaultComboBoxModel<>(konstruktori.toArray(new Konstruktor[0]));

		idKonstruktoraComboBox = new JComboBox<Konstruktor>(modelK);
		idKonstruktoraComboBox.setSelectedIndex(0);
		idKonstruktoraComboBox.setBounds(226, 209, 99, 22);
		getContentPane().add(idKonstruktoraComboBox);

		List<TrkackiVikend> trkackiVikendi = new ArrayList<>();
		for (TrkackiVikend t : TrkackiVikendForm.trkackiVikendDAO.selectAll()) {
			trkackiVikendi.add(t);
		}

		DefaultComboBoxModel<TrkackiVikend> modelT = new DefaultComboBoxModel<>(
				trkackiVikendi.toArray(new TrkackiVikend[0]));

		idTrkackogVikendaComboBox = new JComboBox<TrkackiVikend>(modelT);
		idTrkackogVikendaComboBox.setBounds(226, 40, 99, 22);
		getContentPane().add(idTrkackogVikendaComboBox);

		List<Vozac> vozaci = new ArrayList<>();
		for (Vozac v : VozacForm.vozacDAO.selectAll()) {
			vozaci.add(v);
		}

		DefaultComboBoxModel<Vozac> modelV = new DefaultComboBoxModel<>(vozaci.toArray(new Vozac[0]));

		idVozacaComboBox = new JComboBox<Vozac>(modelV);
		idVozacaComboBox.setBounds(226, 9, 99, 22);
		getContentPane().add(idVozacaComboBox);

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
