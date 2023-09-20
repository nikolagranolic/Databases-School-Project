package org.unibl.etf.forms;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class MainMenuForm extends JFrame {
	public MainMenuForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(1000, 700));
		setTitle("Formula 1");
		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Formula 1 informacioni sistem");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel2 = new JPanel();
		getContentPane().add(panel2, BorderLayout.CENTER);
		panel2.setLayout(new GridLayout(3, 7, 10, 20));
		
		JPanel panel_1 = new JPanel();
		panel2.add(panel_1);
		
		JButton statistikaStartButton = new JButton("StatistikaSTART");
		statistikaStartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StatistikaForm("Startna").setVisible(true);
			}
		});
		panel2.add(statistikaStartButton);
		
		JButton konstruktorButton = new JButton("Konstruktor");
		konstruktorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new KonstruktorForm().setVisible(true);
			}
		});
		panel2.add(konstruktorButton);
		
		JButton poredakVButton = new JButton("Poredak V");
		poredakVButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PoredakVozacaHelperForm().setVisible(true);
			}
		});
		poredakVButton.setToolTipText("Poredak u konkurenciji vozaca");
		panel2.add(poredakVButton);
		
		JButton komponenteButton = new JButton("Komponente");
		komponenteButton.setEnabled(false);
		komponenteButton.setToolTipText("Koristene komponente");
		panel2.add(komponenteButton);
		
		JButton poredakKButton = new JButton("Poredak K");
		poredakKButton.setEnabled(false);
		poredakKButton.setToolTipText("Poredak u konkurenciji konstruktora");
		panel2.add(poredakKButton);
		
		JPanel panel_2 = new JPanel();
		panel2.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel2.add(panel_3);
		
		JButton statistikaFinishButton = new JButton("StatistikaFINISH");
		statistikaFinishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StatistikaForm("Krajnja").setVisible(true);
			}
		});
		statistikaFinishButton.setToolTipText("");
		panel2.add(statistikaFinishButton);
		
		JButton proizvodjacMotoraButton = new JButton("Proizv. motora");
		proizvodjacMotoraButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProizvodjacMotoraForm().setVisible(true);
			}
		});
		proizvodjacMotoraButton.setToolTipText("Proizvodjac motora");
		panel2.add(proizvodjacMotoraButton);
		
		JButton rezultatButton = new JButton("Rezultat");
		rezultatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RezultatForm().setVisible(true);
			}
		});
		panel2.add(rezultatButton);
		
		JButton sezonaButton = new JButton("Sezona");
		sezonaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SezonaForm().setVisible(true);
			}
		});
		panel2.add(sezonaButton);
		
		JButton sponzorButton = new JButton("Sponzor");
		sponzorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SponzorForm().setVisible(true);
			}
		});
		panel2.add(sponzorButton);
		
		JPanel panel_4 = new JPanel();
		panel2.add(panel_4);
		
		JPanel panel_6 = new JPanel();
		panel2.add(panel_6);
		
		JButton stazaButton = new JButton("Staza");
		stazaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StazaForm().setVisible(true);
			}
		});
		panel2.add(stazaButton);
		
		JButton trkackiVikendButton = new JButton("Trkacki vikend");
		trkackiVikendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TrkackiVikendForm().setVisible(true);
			}
		});
		panel2.add(trkackiVikendButton);
		
		JButton vozacButton = new JButton("Vozac");
		vozacButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VozacForm().setVisible(true);
			}
		});
		panel2.add(vozacButton);
		
		JButton vSponzorstvoButton = new JButton("V. sponzorstvo");
		vSponzorstvoButton.setEnabled(false);
		vSponzorstvoButton.setToolTipText("Vozacev sponzorski ugovor");
		panel2.add(vSponzorstvoButton);
		
		JButton zaposleniButton = new JButton("Zaposleni");
		zaposleniButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ZaposleniForm().setVisible(true);
			}
		});
		panel2.add(zaposleniButton);
		
		JPanel panel = new JPanel();
		panel2.add(panel);
		panel2.setVisible(true);
	}
}
