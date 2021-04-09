package br.com.gellog.view.tab.content;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ContentTabela {
	
	private JTextField txFBHKG;
	private JTextField txFBHExc;
	private JTextField txFRMBHKg;
	private JTextField txFRMBHExc;
	private JTextField txFInterirorKG;
	private JTextField txFInterirorExc;
	private JTextField txFTxConfins;
	private JTextField txFKmRodadoFiorino;
	private JTextField txFKmRodadoVan;

	private JTextField txFFiorinoh;
	private JTextField txFVanh;
	private JTextField txFFiorino2h;
	private JTextField txFVan2h;
	private JTextField txFFiorino4h;
	private JTextField txFVan4h;
	private JTextField txFFiorino6h;
	private JTextField txFVan6h;
	private JTextField txFFiorino8h;
	private JTextField txFVan8h;
	private JButton jbtnResetTabelaPadrao;
	private JPanel panel_TxParadoTitulo;
	private JLabel lblTaxaPorTempo;
	
	
	public JPanel contentTabela() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		
		JPanel panel_CalculoPeso = new JPanel();
		panel_CalculoPeso.setBackground(Color.WHITE);
		panel_CalculoPeso.setBorder(BorderFactory.createBevelBorder(0, new Color(230,230,240), new Color(110,110,135)));
		GridBagConstraints gbc_panel_CalculoPeso = new GridBagConstraints();
		gbc_panel_CalculoPeso.insets = new Insets(0, 0, 5, 5);
		gbc_panel_CalculoPeso.fill = GridBagConstraints.BOTH;
		gbc_panel_CalculoPeso.gridx = 0;
		gbc_panel_CalculoPeso.gridy = 0;
		GridBagLayout gbl_panel_CalculoPeso = new GridBagLayout();
		gbl_panel_CalculoPeso.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_CalculoPeso.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_CalculoPeso.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_CalculoPeso.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_CalculoPeso.setLayout(gbl_panel_CalculoPeso);
		panel.add(panel_CalculoPeso, gbc_panel_CalculoPeso);
		
		JPanel panel_CalculoPesoTitulo = new JPanel();
		panel_CalculoPesoTitulo.setBackground(new Color(110,110,135));
		GridBagConstraints gbc_panel_CalculoPesoTitulo = new GridBagConstraints();
		gbc_panel_CalculoPesoTitulo.gridwidth = 3;
		gbc_panel_CalculoPesoTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_panel_CalculoPesoTitulo.fill = GridBagConstraints.BOTH;
		gbc_panel_CalculoPesoTitulo.gridx = 0;
		gbc_panel_CalculoPesoTitulo.gridy = 0;
		panel_CalculoPeso.add(panel_CalculoPesoTitulo, gbc_panel_CalculoPesoTitulo);
		
		JLabel lblClculoPorPeso = new JLabel("Cálculo por Peso");
		lblClculoPorPeso.setForeground(Color.WHITE);
		panel_CalculoPesoTitulo.add(lblClculoPorPeso);
		
		JLabel lblAtKg = new JLabel("Até 10 KG");
		GridBagConstraints gbc_lblAtKg = new GridBagConstraints();
		gbc_lblAtKg.insets = new Insets(0, 0, 5, 5);
		gbc_lblAtKg.gridx = 1;
		gbc_lblAtKg.gridy = 1;
		panel_CalculoPeso.add(lblAtKg, gbc_lblAtKg);
		
		JLabel lblExcedente = new JLabel("Excedente");
		GridBagConstraints gbc_lblExcedente = new GridBagConstraints();
		gbc_lblExcedente.insets = new Insets(0, 0, 5, 0);
		gbc_lblExcedente.gridx = 2;
		gbc_lblExcedente.gridy = 1;
		panel_CalculoPeso.add(lblExcedente, gbc_lblExcedente);
		
		JLabel lblBh = new JLabel("BH");
		GridBagConstraints gbc_lblBh = new GridBagConstraints();
		gbc_lblBh.anchor = GridBagConstraints.EAST;
		gbc_lblBh.insets = new Insets(0, 0, 5, 5);
		gbc_lblBh.gridx = 0;
		gbc_lblBh.gridy = 2;
		panel_CalculoPeso.add(lblBh, gbc_lblBh);
		
		txFBHKG = new JTextField();
		GridBagConstraints gbc_txFBHKG = new GridBagConstraints();
		gbc_txFBHKG.insets = new Insets(0, 0, 5, 5);
		gbc_txFBHKG.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFBHKG.gridx = 1;
		gbc_txFBHKG.gridy = 2;
		panel_CalculoPeso.add(txFBHKG, gbc_txFBHKG);
		txFBHKG.setColumns(10);
		
		txFBHExc = new JTextField();
		GridBagConstraints gbc_txFBHExc = new GridBagConstraints();
		gbc_txFBHExc.insets = new Insets(0, 0, 5, 0);
		gbc_txFBHExc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFBHExc.gridx = 2;
		gbc_txFBHExc.gridy = 2;
		panel_CalculoPeso.add(txFBHExc, gbc_txFBHExc);
		txFBHExc.setColumns(10);
		
		JLabel lblRmbh = new JLabel("RMBH");
		GridBagConstraints gbc_lblRmbh = new GridBagConstraints();
		gbc_lblRmbh.anchor = GridBagConstraints.EAST;
		gbc_lblRmbh.insets = new Insets(0, 0, 5, 5);
		gbc_lblRmbh.gridx = 0;
		gbc_lblRmbh.gridy = 3;
		panel_CalculoPeso.add(lblRmbh, gbc_lblRmbh);
		
		txFRMBHKg = new JTextField();
		GridBagConstraints gbc_txFRMBHKg = new GridBagConstraints();
		gbc_txFRMBHKg.insets = new Insets(0, 0, 5, 5);
		gbc_txFRMBHKg.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFRMBHKg.gridx = 1;
		gbc_txFRMBHKg.gridy = 3;
		panel_CalculoPeso.add(txFRMBHKg, gbc_txFRMBHKg);
		txFRMBHKg.setColumns(10);
		
		txFRMBHExc = new JTextField();
		GridBagConstraints gbc_txFRMBHExc = new GridBagConstraints();
		gbc_txFRMBHExc.insets = new Insets(0, 0, 5, 0);
		gbc_txFRMBHExc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFRMBHExc.gridx = 2;
		gbc_txFRMBHExc.gridy = 3;
		panel_CalculoPeso.add(txFRMBHExc, gbc_txFRMBHExc);
		txFRMBHExc.setColumns(10);
		
		JLabel lblInterior = new JLabel("Interior");
		GridBagConstraints gbc_lblInterior = new GridBagConstraints();
		gbc_lblInterior.insets = new Insets(0, 0, 5, 5);
		gbc_lblInterior.anchor = GridBagConstraints.EAST;
		gbc_lblInterior.gridx = 0;
		gbc_lblInterior.gridy = 4;
		panel_CalculoPeso.add(lblInterior, gbc_lblInterior);
		
		txFInterirorKG = new JTextField();
		GridBagConstraints gbc_txFInterirorKG = new GridBagConstraints();
		gbc_txFInterirorKG.insets = new Insets(0, 0, 5, 5);
		gbc_txFInterirorKG.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFInterirorKG.gridx = 1;
		gbc_txFInterirorKG.gridy = 4;
		panel_CalculoPeso.add(txFInterirorKG, gbc_txFInterirorKG);
		txFInterirorKG.setColumns(10);
		
		txFInterirorExc = new JTextField();
		GridBagConstraints gbc_txFInterirorExc = new GridBagConstraints();
		gbc_txFInterirorExc.insets = new Insets(0, 0, 5, 0);
		gbc_txFInterirorExc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFInterirorExc.gridx = 2;
		gbc_txFInterirorExc.gridy = 4;
		panel_CalculoPeso.add(txFInterirorExc, gbc_txFInterirorExc);
		txFInterirorExc.setColumns(10);
		
		JLabel lblTaxaConfins = new JLabel("Taxa Confins");
		GridBagConstraints gbc_lblTaxaConfins = new GridBagConstraints();
		gbc_lblTaxaConfins.anchor = GridBagConstraints.EAST;
		gbc_lblTaxaConfins.insets = new Insets(0, 0, 0, 5);
		gbc_lblTaxaConfins.gridx = 0;
		gbc_lblTaxaConfins.gridy = 5;
		panel_CalculoPeso.add(lblTaxaConfins, gbc_lblTaxaConfins);
		
		txFTxConfins = new JTextField();
		GridBagConstraints gbc_txFTxConfins = new GridBagConstraints();
		gbc_txFTxConfins.insets = new Insets(0, 0, 0, 5);
		gbc_txFTxConfins.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFTxConfins.gridx = 1;
		gbc_txFTxConfins.gridy = 5;
		panel_CalculoPeso.add(txFTxConfins, gbc_txFTxConfins);
		txFTxConfins.setColumns(10);
		
		JPanel panel_CalculoKm = new JPanel();
		panel_CalculoKm.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_CalculoKm = new GridBagConstraints();
		panel_CalculoKm.setBorder(BorderFactory.createBevelBorder(0, new Color(230,230,240), new Color(110,110,135)));
		gbc_panel_CalculoKm.insets = new Insets(0, 0, 5, 0);
		gbc_panel_CalculoKm.fill = GridBagConstraints.NORTH;
		gbc_panel_CalculoKm.anchor = GridBagConstraints.NORTH;
		gbc_panel_CalculoKm.gridx = 1;
		gbc_panel_CalculoKm.gridy = 0;
		//createTabStructureAndContent.panel_east.add(panel_CalculoKm, gbc_panel_CalculoKm);
		GridBagLayout gbl_panel_CalculoKm = new GridBagLayout();
		gbl_panel_CalculoKm.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_CalculoKm.rowHeights = new int[]{0, 0, 0};
		gbl_panel_CalculoKm.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_CalculoKm.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_CalculoKm.setLayout(gbl_panel_CalculoKm);
		panel.add(panel_CalculoKm, gbc_panel_CalculoKm);
		
		JPanel panel_CalculoKmTitulo = new JPanel();
		panel_CalculoKmTitulo.setBackground(new Color(110,110,135));
		GridBagConstraints gbc_panel_CalculoKmTitulo = new GridBagConstraints();
		gbc_panel_CalculoKmTitulo.gridwidth = 3;
		gbc_panel_CalculoKmTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_panel_CalculoKmTitulo.fill = GridBagConstraints.BOTH;
		gbc_panel_CalculoKmTitulo.gridx = 0;
		gbc_panel_CalculoKmTitulo.gridy = 0;
		panel_CalculoKm.add(panel_CalculoKmTitulo, gbc_panel_CalculoKmTitulo);
		
		JLabel lblClculoPorQuilometragem = new JLabel("Cálculo por Quilometragem");
		lblClculoPorQuilometragem.setForeground(Color.WHITE);
		panel_CalculoKmTitulo.add(lblClculoPorQuilometragem);
		
		
		JLabel lblFiorino = new JLabel("Fiorino");
		GridBagConstraints gbc_lblFiorino = new GridBagConstraints();
		gbc_lblFiorino.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiorino.gridx = 1;
		gbc_lblFiorino.gridy = 1;
		panel_CalculoKm.add(lblFiorino, gbc_lblFiorino);
		
		JLabel lblVanhr = new JLabel("Van/HR");
		GridBagConstraints gbc_lblVanhr = new GridBagConstraints();
		gbc_lblVanhr.insets = new Insets(0, 0, 5, 0);
		gbc_lblVanhr.gridx = 2;
		gbc_lblVanhr.gridy = 1;
		panel_CalculoKm.add(lblVanhr, gbc_lblVanhr);
		
		JLabel lblKmRodado = new JLabel("KM Rodado");
		GridBagConstraints gbc_lblKmRodado = new GridBagConstraints();
		gbc_lblKmRodado.anchor = GridBagConstraints.EAST;
		gbc_lblKmRodado.insets = new Insets(0, 0, 5, 5);
		gbc_lblKmRodado.gridx = 0;
		gbc_lblKmRodado.gridy = 2;
		panel_CalculoKm.add(lblKmRodado, gbc_lblKmRodado);
		
		txFKmRodadoFiorino = new JTextField();
		GridBagConstraints gbc_txFKmRodadoFiorino = new GridBagConstraints();
		gbc_txFKmRodadoFiorino.insets = new Insets(0, 0, 5, 5);
		gbc_txFKmRodadoFiorino.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFKmRodadoFiorino.gridx = 1;
		gbc_txFKmRodadoFiorino.gridy = 2;
		panel_CalculoKm.add(txFKmRodadoFiorino, gbc_txFKmRodadoFiorino);
		txFKmRodadoFiorino.setColumns(10);
		
		txFKmRodadoVan = new JTextField();
		GridBagConstraints gbc_txFKmRodadoVan = new GridBagConstraints();
		gbc_txFKmRodadoVan.insets = new Insets(0, 0, 5, 0);
		gbc_txFKmRodadoVan.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFKmRodadoVan.gridx = 2;
		gbc_txFKmRodadoVan.gridy = 2;
		panel_CalculoKm.add(txFKmRodadoVan, gbc_txFKmRodadoVan);
		txFKmRodadoVan.setColumns(10);

		
	
		
		/*===================================================================================*/				

		
		
		
		JPanel panel_txParado = new JPanel();
		GridBagConstraints gbc_panel_txParado = new GridBagConstraints();
		panel_txParado.setBackground(Color.WHITE);
		panel_txParado.setBorder(BorderFactory.createBevelBorder(0, new Color(230,230,240), new Color(110,110,135)));
		gbc_panel_txParado.anchor = GridBagConstraints.NORTH;
		gbc_panel_txParado.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_txParado.gridx = 0;
		gbc_panel_txParado.gridy = 1;
		//createTabStructureAndContent.panel_west.add(panel_txParado, gbc_panel_txParado);
		GridBagLayout gbl_panel_txParado = new GridBagLayout();
		gbl_panel_txParado.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_txParado.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_txParado.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_txParado.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_txParado.setLayout(gbl_panel_txParado);
		panel.add(panel_txParado, gbc_panel_txParado);
		
		panel_TxParadoTitulo = new JPanel();
		panel_TxParadoTitulo.setBackground(new Color(110,110,135));
		GridBagConstraints gbc_panel_TxParadoTitulo = new GridBagConstraints();
		gbc_panel_TxParadoTitulo.gridwidth = 3;
		gbc_panel_TxParadoTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_panel_TxParadoTitulo.fill = GridBagConstraints.BOTH;
		gbc_panel_TxParadoTitulo.gridx = 0;
		gbc_panel_TxParadoTitulo.gridy = 0;
		panel_txParado.add(panel_TxParadoTitulo, gbc_panel_TxParadoTitulo);
		
		lblTaxaPorTempo = new JLabel("Taxa por Tempo Parado");
		lblTaxaPorTempo.setForeground(Color.WHITE);
		panel_TxParadoTitulo.add(lblTaxaPorTempo);
		
		JLabel lblFiorino_Tempo = new JLabel("Fiorino");
		GridBagConstraints gbc_lblFiorino_Tempo = new GridBagConstraints();
		gbc_lblFiorino_Tempo.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiorino_Tempo.gridx = 1;
		gbc_lblFiorino_Tempo.gridy = 1;
		panel_txParado.add(lblFiorino_Tempo, gbc_lblFiorino_Tempo);
		
		JLabel lblVanhr_Tempo = new JLabel("Van/HR");
		GridBagConstraints gbc_lblVanhr_Tempo = new GridBagConstraints();
		gbc_lblVanhr_Tempo.insets = new Insets(0, 0, 5, 0);
		gbc_lblVanhr_Tempo.gridx = 2;
		gbc_lblVanhr_Tempo.gridy = 1;
		panel_txParado.add(lblVanhr_Tempo, gbc_lblVanhr_Tempo);
		
		JLabel lblAtHs = new JLabel("Até 01:30h");
		GridBagConstraints gbc_lblAtHs = new GridBagConstraints();
		gbc_lblAtHs.anchor = GridBagConstraints.EAST;
		gbc_lblAtHs.insets = new Insets(0, 0, 5, 5);
		gbc_lblAtHs.gridx = 0;
		gbc_lblAtHs.gridy = 2;
		panel_txParado.add(lblAtHs, gbc_lblAtHs);
		
		txFFiorinoh = new JTextField();
		GridBagConstraints gbc_txFFiorinoh = new GridBagConstraints();
		gbc_txFFiorinoh.insets = new Insets(0, 0, 5, 5);
		gbc_txFFiorinoh.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFFiorinoh.gridx = 1;
		gbc_txFFiorinoh.gridy = 2;
		panel_txParado.add(txFFiorinoh, gbc_txFFiorinoh);
		txFFiorinoh.setColumns(10);
		
		txFVanh = new JTextField();
		GridBagConstraints gbc_txFVanh = new GridBagConstraints();
		gbc_txFVanh.insets = new Insets(0, 0, 5, 0);
		gbc_txFVanh.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFVanh.gridx = 2;
		gbc_txFVanh.gridy = 2;
		panel_txParado.add(txFVanh, gbc_txFVanh);
		txFVanh.setColumns(10);
		
		JLabel lblAt = new JLabel("Até 02:30h");
		GridBagConstraints gbc_lblAt = new GridBagConstraints();
		gbc_lblAt.anchor = GridBagConstraints.EAST;
		gbc_lblAt.insets = new Insets(0, 0, 5, 5);
		gbc_lblAt.gridx = 0;
		gbc_lblAt.gridy = 3;
		panel_txParado.add(lblAt, gbc_lblAt);
		
		txFFiorino2h = new JTextField();
		GridBagConstraints gbc_txFFiorino2h = new GridBagConstraints();
		gbc_txFFiorino2h.insets = new Insets(0, 0, 5, 5);
		gbc_txFFiorino2h.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFFiorino2h.gridx = 1;
		gbc_txFFiorino2h.gridy = 3;
		panel_txParado.add(txFFiorino2h, gbc_txFFiorino2h);
		txFFiorino2h.setColumns(10);
		
		txFVan2h = new JTextField();
		GridBagConstraints gbc_txFVan2h = new GridBagConstraints();
		gbc_txFVan2h.insets = new Insets(0, 0, 5, 0);
		gbc_txFVan2h.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFVan2h.gridx = 2;
		gbc_txFVan2h.gridy = 3;
		panel_txParado.add(txFVan2h, gbc_txFVan2h);
		txFVan2h.setColumns(10);
		
		JLabel lblAte = new JLabel("Até 04:00h");
		GridBagConstraints gbc_lblAte = new GridBagConstraints();
		gbc_lblAte.anchor = GridBagConstraints.EAST;
		gbc_lblAte.insets = new Insets(0, 0, 5, 5);
		gbc_lblAte.gridx = 0;
		gbc_lblAte.gridy = 4;
		panel_txParado.add(lblAte, gbc_lblAte);
		
		txFFiorino4h = new JTextField();
		GridBagConstraints gbc_txFFiorino4h = new GridBagConstraints();
		gbc_txFFiorino4h.insets = new Insets(0, 0, 5, 5);
		gbc_txFFiorino4h.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFFiorino4h.gridx = 1;
		gbc_txFFiorino4h.gridy = 4;
		panel_txParado.add(txFFiorino4h, gbc_txFFiorino4h);
		txFFiorino4h.setColumns(10);
		
		txFVan4h = new JTextField();
		GridBagConstraints gbc_txFVan4h = new GridBagConstraints();
		gbc_txFVan4h.insets = new Insets(0, 0, 5, 0);
		gbc_txFVan4h.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFVan4h.gridx = 2;
		gbc_txFVan4h.gridy = 4;
		panel_txParado.add(txFVan4h, gbc_txFVan4h);
		txFVan4h.setColumns(10);
		
		JLabel lblAt_1 = new JLabel("Até 06:00h");
		GridBagConstraints gbc_lblAt_1 = new GridBagConstraints();
		gbc_lblAt_1.anchor = GridBagConstraints.EAST;
		gbc_lblAt_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAt_1.gridx = 0;
		gbc_lblAt_1.gridy = 5;
		panel_txParado.add(lblAt_1, gbc_lblAt_1);
		
		txFFiorino6h = new JTextField();
		GridBagConstraints gbc_txFFiorino6h = new GridBagConstraints();
		gbc_txFFiorino6h.insets = new Insets(0, 0, 5, 5);
		gbc_txFFiorino6h.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFFiorino6h.gridx = 1;
		gbc_txFFiorino6h.gridy = 5;
		panel_txParado.add(txFFiorino6h, gbc_txFFiorino6h);
		txFFiorino6h.setColumns(10);
		
		txFVan6h = new JTextField();
		GridBagConstraints gbc_txFVan6h = new GridBagConstraints();
		gbc_txFVan6h.insets = new Insets(0, 0, 5, 0);
		gbc_txFVan6h.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFVan6h.gridx = 2;
		gbc_txFVan6h.gridy = 5;
		panel_txParado.add(txFVan6h, gbc_txFVan6h);
		txFVan6h.setColumns(10);
		
		JLabel lblAt_2 = new JLabel("Até 08:00h");
		GridBagConstraints gbc_lblAt_2 = new GridBagConstraints();
		gbc_lblAt_2.anchor = GridBagConstraints.EAST;
		gbc_lblAt_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblAt_2.gridx = 0;
		gbc_lblAt_2.gridy = 6;
		panel_txParado.add(lblAt_2, gbc_lblAt_2);
		
		txFFiorino8h = new JTextField();
		GridBagConstraints gbc_txFFiorino8h = new GridBagConstraints();
		gbc_txFFiorino8h.insets = new Insets(0, 0, 0, 5);
		gbc_txFFiorino8h.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFFiorino8h.gridx = 1;
		gbc_txFFiorino8h.gridy = 6;
		panel_txParado.add(txFFiorino8h, gbc_txFFiorino8h);
		txFFiorino8h.setColumns(10);
		
		txFVan8h = new JTextField();
		GridBagConstraints gbc_txFVan8h = new GridBagConstraints();
		gbc_txFVan8h.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFVan8h.gridx = 2;
		gbc_txFVan8h.gridy = 6;
		panel_txParado.add(txFVan8h, gbc_txFVan8h);
		txFVan8h.setColumns(10);
	
		
		jbtnResetTabelaPadrao = new JButton("Resetar Valores da Tabela");
		GridBagConstraints gbc_jbtnResetTabelaPadrao = new GridBagConstraints();
		gbc_jbtnResetTabelaPadrao.anchor = GridBagConstraints.SOUTH;
		gbc_jbtnResetTabelaPadrao.fill = GridBagConstraints.HORIZONTAL;
		gbc_jbtnResetTabelaPadrao.gridx = 1;
		gbc_jbtnResetTabelaPadrao.gridy = 1;
		panel.add(jbtnResetTabelaPadrao, gbc_jbtnResetTabelaPadrao);
		
		
		
		return panel;
	}
}
