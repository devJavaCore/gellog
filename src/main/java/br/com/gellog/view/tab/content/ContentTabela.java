package br.com.gellog.view.tab.content;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.gellog.controller.TabelaController;
import br.com.gellog.view.frame.FrameTabela;
import br.com.gellog.view.util.Events.NumberFormatter;
import br.com.gellog.view.util.Events.SetZero;
import br.com.gellog.view.util.jcomponents.JIconButton;
import br.com.gellog.view.util.jcomponents.JIconTextField;
import br.com.gellog.view.util.jcomponents.JTextFiledSettings;
import br.com.gellog.view.util.jcomponents.MyJPanel;

public class ContentTabela {

	private JIconTextField txFBHKG, txFBHExc, txFRMBHKg, txFRMBHExc, txFInterirorKG, txFInterirorExc, txFTxConfins,
			txFKmRodadoFiorino, txFKmRodadoVan, txFFiorinoh, txFVanh, txFFiorino2h, txFVan2h, txFFiorino4h, txFVan4h,
			txFFiorino6h, txFVan6h, txFFiorino8h, txFVan8h;
	private JButton jbtnResetTabelaPadrao, botaoCancelar, botaoAtualizar;
	private JPanel panel_TxParadoTitulo;
	private JLabel lblTaxaPorTempo;
	private MyJPanel panel_CalculoPeso, panel_CalculoKm, panel_txParado;
	public JPanel contentTabela(boolean tabelaPadrao) {
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		panel_CalculoPeso = new MyJPanel();
		panel_CalculoPeso.setBorder(new EmptyBorder(0, 5, 5, 5));
		GridBagConstraints gbc_panel_CalculoPeso = new GridBagConstraints();
		gbc_panel_CalculoPeso.insets = new Insets(0, 0, 5, 5);
		gbc_panel_CalculoPeso.fill = GridBagConstraints.BOTH;
		gbc_panel_CalculoPeso.gridx = 0;
		gbc_panel_CalculoPeso.gridy = 0;
		GridBagLayout gbl_panel_CalculoPeso = new GridBagLayout();
		gbl_panel_CalculoPeso.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_CalculoPeso.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_CalculoPeso.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_CalculoPeso.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_CalculoPeso.setLayout(gbl_panel_CalculoPeso);
		panel.add(panel_CalculoPeso, gbc_panel_CalculoPeso);

		JPanel panel_CalculoPesoTitulo = new JPanel();
		panel_CalculoPesoTitulo.setBackground(new Color(110, 110, 135));
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

		txFBHKG = new JIconTextField();
		panel_CalculoPeso.add(txFBHKG, new JTextFiledSettings().basicAndGbConstrainstConfig(txFBHKG, 0, 0, 5, 5, 1, 2));

		txFBHExc = new JIconTextField();
		panel_CalculoPeso.add(txFBHExc,
				new JTextFiledSettings().basicAndGbConstrainstConfig(txFBHExc, 0, 0, 5, 0, 2, 2));

		JLabel lblRmbh = new JLabel("RMBH");
		GridBagConstraints gbc_lblRmbh = new GridBagConstraints();
		gbc_lblRmbh.anchor = GridBagConstraints.EAST;
		gbc_lblRmbh.insets = new Insets(0, 0, 5, 5);
		gbc_lblRmbh.gridx = 0;
		gbc_lblRmbh.gridy = 3;
		panel_CalculoPeso.add(lblRmbh, gbc_lblRmbh);

		txFRMBHKg = new JIconTextField();
		panel_CalculoPeso.add(txFRMBHKg,
				new JTextFiledSettings().basicAndGbConstrainstConfig(txFRMBHKg, 0, 0, 5, 5, 1, 3));

		txFRMBHExc = new JIconTextField();
		panel_CalculoPeso.add(txFRMBHExc,
				new JTextFiledSettings().basicAndGbConstrainstConfig(txFRMBHExc, 0, 0, 5, 0, 2, 3));

		JLabel lblInterior = new JLabel("Interior");
		GridBagConstraints gbc_lblInterior = new GridBagConstraints();
		gbc_lblInterior.insets = new Insets(0, 0, 5, 5);
		gbc_lblInterior.anchor = GridBagConstraints.EAST;
		gbc_lblInterior.gridx = 0;
		gbc_lblInterior.gridy = 4;
		panel_CalculoPeso.add(lblInterior, gbc_lblInterior);

		txFInterirorKG = new JIconTextField();
		panel_CalculoPeso.add(txFInterirorKG,
				new JTextFiledSettings().basicAndGbConstrainstConfig(txFInterirorKG, 0, 0, 5, 5, 1, 4));

		txFInterirorExc = new JIconTextField();
		panel_CalculoPeso.add(txFInterirorExc,
				new JTextFiledSettings().basicAndGbConstrainstConfig(txFInterirorExc, 0, 0, 5, 0, 2, 4));

		JLabel lblTaxaConfins = new JLabel("Taxa Confins");
		txFBHKG.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			txFBHKG.setIcon(new ImageIcon(ImageIO.read(new File("/br/com/gellog/view/img/currency.png"))));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		GridBagConstraints gbc_lblTaxaConfins = new GridBagConstraints();
		gbc_lblTaxaConfins.anchor = GridBagConstraints.EAST;
		gbc_lblTaxaConfins.insets = new Insets(0, 0, 0, 5);
		gbc_lblTaxaConfins.gridx = 0;
		gbc_lblTaxaConfins.gridy = 5;
		panel_CalculoPeso.add(lblTaxaConfins, gbc_lblTaxaConfins);

		txFTxConfins = new JIconTextField();
		panel_CalculoPeso.add(txFTxConfins,
				new JTextFiledSettings().basicAndGbConstrainstConfig(txFTxConfins, 0, 0, 0, 5, 1, 5));

		/*
		 * Calculo Peso
		 * =============================================================================
		 * ========================== Calculo Km
		 */

		panel_CalculoKm = new MyJPanel();
		panel_CalculoKm.setBorder(new EmptyBorder(0, 5, 5, 5));
		GridBagConstraints gbc_panel_CalculoKm = new GridBagConstraints();
		gbc_panel_CalculoKm.insets = new Insets(0, 0, 5, 0);
		gbc_panel_CalculoKm.fill = GridBagConstraints.NORTH;
		gbc_panel_CalculoKm.anchor = GridBagConstraints.NORTH;
		gbc_panel_CalculoKm.gridx = 1;
		gbc_panel_CalculoKm.gridy = 0;
		// createTabStructureAndContent.panel_east.add(panel_CalculoKm,
		// gbc_panel_CalculoKm);
		GridBagLayout gbl_panel_CalculoKm = new GridBagLayout();
		gbl_panel_CalculoKm.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_CalculoKm.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_CalculoKm.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_CalculoKm.rowWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_CalculoKm.setLayout(gbl_panel_CalculoKm);
		panel.add(panel_CalculoKm, gbc_panel_CalculoKm);

		JPanel panel_CalculoKmTitulo = new JPanel();
		panel_CalculoKmTitulo.setBackground(new Color(110, 110, 135));
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

		txFKmRodadoFiorino = new JIconTextField();
		panel_CalculoKm.add(txFKmRodadoFiorino,
				new JTextFiledSettings().basicAndGbConstrainstConfig(txFKmRodadoFiorino, 0, 0, 5, 5, 1, 2));

		txFKmRodadoVan = new JIconTextField();
		panel_CalculoKm.add(txFKmRodadoVan,
				new JTextFiledSettings().basicAndGbConstrainstConfig(txFKmRodadoVan, 0, 0, 5, 0, 2, 2));

		/*
		 * Calculo Km
		 * =============================================================================
		 * Taxa
		 */

		panel_txParado = new MyJPanel();
		panel_txParado.setBorder(new EmptyBorder(0, 5, 5, 5));
		GridBagConstraints gbc_panel_txParado = new GridBagConstraints();
		gbc_panel_txParado.anchor = GridBagConstraints.NORTH;
		gbc_panel_txParado.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_txParado.gridx = 0;
		gbc_panel_txParado.gridy = 1;
		GridBagLayout gbl_panel_txParado = new GridBagLayout();
		gbl_panel_txParado.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_txParado.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_txParado.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_txParado.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_txParado.setLayout(gbl_panel_txParado);
		panel.add(panel_txParado, gbc_panel_txParado);

		panel_TxParadoTitulo = new JPanel();
		panel_TxParadoTitulo.setBackground(new Color(110, 110, 135));
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

		txFFiorinoh = new JIconTextField();
		panel_txParado.add(txFFiorinoh,
				new JTextFiledSettings().basicAndGbConstrainstConfig(txFFiorinoh, 0, 0, 5, 5, 1, 2));

		txFVanh = new JIconTextField();
		panel_txParado.add(txFVanh, new JTextFiledSettings().basicAndGbConstrainstConfig(txFVanh, 0, 0, 5, 0, 2, 2));

		JLabel lblAt = new JLabel("Até 02:30h");
		GridBagConstraints gbc_lblAt = new GridBagConstraints();
		gbc_lblAt.anchor = GridBagConstraints.EAST;
		gbc_lblAt.insets = new Insets(0, 0, 5, 5);
		gbc_lblAt.gridx = 0;
		gbc_lblAt.gridy = 3;
		panel_txParado.add(lblAt, gbc_lblAt);

		txFFiorino2h = new JIconTextField();
		panel_txParado.add(txFFiorino2h,
				new JTextFiledSettings().basicAndGbConstrainstConfig(txFFiorino2h, 0, 0, 5, 5, 1, 3));

		txFVan2h = new JIconTextField();
		panel_txParado.add(txFVan2h, new JTextFiledSettings().basicAndGbConstrainstConfig(txFVan2h, 0, 0, 5, 0, 2, 3));

		JLabel lblAte = new JLabel("Até 04:00h");
		GridBagConstraints gbc_lblAte = new GridBagConstraints();
		gbc_lblAte.anchor = GridBagConstraints.EAST;
		gbc_lblAte.insets = new Insets(0, 0, 5, 5);
		gbc_lblAte.gridx = 0;
		gbc_lblAte.gridy = 4;
		panel_txParado.add(lblAte, gbc_lblAte);

		txFFiorino4h = new JIconTextField();
		panel_txParado.add(txFFiorino4h,
				new JTextFiledSettings().basicAndGbConstrainstConfig(txFFiorino4h, 0, 0, 5, 5, 1, 4));

		txFVan4h = new JIconTextField();
		panel_txParado.add(txFVan4h, new JTextFiledSettings().basicAndGbConstrainstConfig(txFVan4h, 0, 0, 5, 0, 2, 4));

		JLabel lblAt_1 = new JLabel("Até 06:00h");
		GridBagConstraints gbc_lblAt_1 = new GridBagConstraints();
		gbc_lblAt_1.anchor = GridBagConstraints.EAST;
		gbc_lblAt_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAt_1.gridx = 0;
		gbc_lblAt_1.gridy = 5;
		panel_txParado.add(lblAt_1, gbc_lblAt_1);

		txFFiorino6h = new JIconTextField();
		panel_txParado.add(txFFiorino6h,
				new JTextFiledSettings().basicAndGbConstrainstConfig(txFFiorino6h, 0, 0, 5, 5, 1, 5));

		txFVan6h = new JIconTextField();
		panel_txParado.add(txFVan6h, new JTextFiledSettings().basicAndGbConstrainstConfig(txFVan6h, 0, 0, 5, 0, 2, 5));

		JLabel lblAt_2 = new JLabel("Até 08:00h");
		GridBagConstraints gbc_lblAt_2 = new GridBagConstraints();
		gbc_lblAt_2.anchor = GridBagConstraints.EAST;
		gbc_lblAt_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblAt_2.gridx = 0;
		gbc_lblAt_2.gridy = 6;
		panel_txParado.add(lblAt_2, gbc_lblAt_2);

		txFFiorino8h = new JIconTextField();
		panel_txParado.add(txFFiorino8h,
				new JTextFiledSettings().basicAndGbConstrainstConfig(txFFiorino8h, 0, 0, 0, 5, 1, 6));

		txFVan8h = new JIconTextField();
		panel_txParado.add(txFVan8h, new JTextFiledSettings().basicAndGbConstrainstConfig(txFVan8h, 0, 0, 0, 0, 2, 6));

		jbtnResetTabelaPadrao = new JIconButton().botaoResetar();
		GridBagConstraints gbc_jbtnResetTabelaPadrao = new GridBagConstraints();
		gbc_jbtnResetTabelaPadrao.anchor = GridBagConstraints.SOUTH;
		gbc_jbtnResetTabelaPadrao.fill = GridBagConstraints.HORIZONTAL;
		gbc_jbtnResetTabelaPadrao.gridx = 1;
		gbc_jbtnResetTabelaPadrao.gridy = 1;
		panel.add(jbtnResetTabelaPadrao, gbc_jbtnResetTabelaPadrao);

		/*
		 * Tags
		 * =============================================================================
		 * Events, formatting numbers
		 */
		// Setting 0 in null fields
		txFBHKG.addFocusListener(new SetZero(txFBHKG));
		txFBHExc.addFocusListener(new SetZero(txFBHExc));
		txFRMBHKg.addFocusListener(new SetZero(txFRMBHKg));
		txFRMBHExc.addFocusListener(new SetZero(txFRMBHExc));
		txFInterirorKG.addFocusListener(new SetZero(txFInterirorKG));
		txFInterirorExc.addFocusListener(new SetZero(txFInterirorExc));
		txFTxConfins.addFocusListener(new SetZero(txFTxConfins));
		txFKmRodadoFiorino.addFocusListener(new SetZero(txFKmRodadoFiorino));
		txFKmRodadoVan.addFocusListener(new SetZero(txFKmRodadoVan));
		txFFiorinoh.addFocusListener(new SetZero(txFFiorinoh));
		txFVanh.addFocusListener(new SetZero(txFVanh));
		txFFiorino2h.addFocusListener(new SetZero(txFFiorino2h));
		txFVan2h.addFocusListener(new SetZero(txFVan2h));
		txFFiorino4h.addFocusListener(new SetZero(txFFiorino4h));
		txFVan4h.addFocusListener(new SetZero(txFVan4h));
		txFFiorino6h.addFocusListener(new SetZero(txFFiorino6h));
		txFVan6h.addFocusListener(new SetZero(txFVan6h));
		txFFiorino8h.addFocusListener(new SetZero(txFFiorino8h));
		txFVan8h.addFocusListener(new SetZero(txFVan8h));

		// Monetary format
		txFBHKG.getDocument().addDocumentListener(new NumberFormatter(txFBHKG));
		txFBHExc.getDocument().addDocumentListener(new NumberFormatter(txFBHExc));
		txFRMBHKg.getDocument().addDocumentListener(new NumberFormatter(txFRMBHKg));
		txFRMBHExc.getDocument().addDocumentListener(new NumberFormatter(txFRMBHExc));
		txFInterirorKG.getDocument().addDocumentListener(new NumberFormatter(txFInterirorKG));
		txFInterirorExc.getDocument().addDocumentListener(new NumberFormatter(txFInterirorExc));
		txFTxConfins.getDocument().addDocumentListener(new NumberFormatter(txFTxConfins));
		txFKmRodadoFiorino.getDocument().addDocumentListener(new NumberFormatter(txFKmRodadoFiorino));
		txFKmRodadoVan.getDocument().addDocumentListener(new NumberFormatter(txFKmRodadoVan));
		txFFiorinoh.getDocument().addDocumentListener(new NumberFormatter(txFFiorinoh));
		txFVanh.getDocument().addDocumentListener(new NumberFormatter(txFVanh));
		txFFiorino2h.getDocument().addDocumentListener(new NumberFormatter(txFFiorino2h));
		txFVan2h.getDocument().addDocumentListener(new NumberFormatter(txFVan2h));
		txFFiorino4h.getDocument().addDocumentListener(new NumberFormatter(txFFiorino4h));
		txFVan4h.getDocument().addDocumentListener(new NumberFormatter(txFVan4h));
		txFFiorino6h.getDocument().addDocumentListener(new NumberFormatter(txFFiorino6h));
		txFVan6h.getDocument().addDocumentListener(new NumberFormatter(txFVan6h));
		txFFiorino8h.getDocument().addDocumentListener(new NumberFormatter(txFFiorino8h));
		txFVan8h.getDocument().addDocumentListener(new NumberFormatter(txFVan8h));

		jbtnResetTabelaPadrao.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jbtnResetTabelaPadrao.doClick();
				}
			}
		});

		jbtnResetTabelaPadrao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				resetaTabelaPadrao();
			}
		});

		JPanel panel_buttons = new JPanel();
		panel_buttons.setBorder(new EmptyBorder(20, 0, 0, 0));
		GridBagConstraints gbc_panel_buttons = new GridBagConstraints();
		gbc_panel_buttons.gridwidth = 2;
		gbc_panel_buttons.anchor = GridBagConstraints.SOUTH;
		gbc_panel_buttons.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_buttons.gridx = 0;
		gbc_panel_buttons.gridy = 2;
		panel.add(panel_buttons, gbc_panel_buttons);

		botaoCancelar = new JIconButton().botaoCancelar();
		botaoAtualizar = new JIconButton().botaoAtualizar();
		panel_buttons.add(botaoCancelar);
		panel_buttons.add(botaoAtualizar);
		botaoAtualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					TabelaController.updateTabelaPadrao(tabelaPadrao, new BigDecimal(txFBHKG.getText()),
							new BigDecimal(txFBHExc.getText()), new BigDecimal(txFRMBHKg.getText()),
							new BigDecimal(txFRMBHExc.getText()), new BigDecimal(txFInterirorKG.getText()),
							new BigDecimal(txFInterirorExc.getText()), new BigDecimal(txFTxConfins.getText()),
							new BigDecimal(txFKmRodadoFiorino.getText()), new BigDecimal(txFKmRodadoVan.getText()),
							new BigDecimal(txFFiorinoh.getText()), new BigDecimal(txFVanh.getText()),
							new BigDecimal(txFFiorino2h.getText()), new BigDecimal(txFVan2h.getText()),
							new BigDecimal(txFFiorino4h.getText()), new BigDecimal(txFVan4h.getText()),
							new BigDecimal(txFFiorino6h.getText()), new BigDecimal(txFVan6h.getText()),
							new BigDecimal(txFFiorino8h.getText()), new BigDecimal(txFVan8h.getText()));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!tabelaPadrao) {
					FrameTabela.setInvisible();
					}
			}
		});
		
		botaoCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!tabelaPadrao) {
				FrameTabela.setInvisible();
				}
			}
		});

		TabelaController.preencheTabelaPadrao(this);

		return panel;
	}

	public void setTxFBHKG(String txFBHKG) {
		this.txFBHKG.setText(txFBHKG);
	}

	public void setTxFBHExc(String txFBHExc) {
		this.txFBHExc.setText(txFBHExc);
	}

	public void setTxFRMBHKg(String txFRMBHKg) {
		this.txFRMBHKg.setText(txFRMBHKg);
	}

	public void setTxFRMBHExc(String txFRMBHExc) {
		this.txFRMBHExc.setText(txFRMBHExc);
	}

	public void setTxFInterirorKG(String txFInterirorKG) {
		this.txFInterirorKG.setText(txFInterirorKG);
	}

	public void setTxFInterirorExc(String txFInterirorExc) {
		this.txFInterirorExc.setText(txFInterirorExc);
	}

	public void setTxFTxConfins(String txFTxConfins) {
		this.txFTxConfins.setText(txFTxConfins);
	}

	public void setTxFKmRodadoFiorino(String txFKmRodadoFiorino) {
		this.txFKmRodadoFiorino.setText(txFKmRodadoFiorino);
	}

	public void setTxFKmRodadoVan(String txFKmRodadoVan) {
		this.txFKmRodadoVan.setText(txFKmRodadoVan);
	}

	public void setTxFFiorinoh(String txFFiorinoh) {
		this.txFFiorinoh.setText(txFFiorinoh);
	}

	public void setTxFVanh(String txFVanh) {
		this.txFVanh.setText(txFVanh);
	}

	public void setTxFFiorino2h(String txFFiorino2h) {
		this.txFFiorino2h.setText(txFFiorino2h);
	}

	public void setTxFVan2h(String txFVan2h) {
		this.txFVan2h.setText(txFVan2h);
	}

	public void setTxFFiorino4h(String txFFiorino4h) {
		this.txFFiorino4h.setText(txFFiorino4h);
	}

	public void setTxFVan4h(String txFVan4h) {
		this.txFVan4h.setText(txFVan4h);
	}

	public void setTxFFiorino6h(String txFFiorino6h) {
		this.txFFiorino6h.setText(txFFiorino6h);
	}

	public void setTxFVan6h(String txFVan6h) {
		this.txFVan6h.setText(txFVan6h);
	}

	public void setTxFFiorino8h(String txFFiorino8h) {
		this.txFFiorino8h.setText(txFFiorino8h);
	}

	public void setTxFVan8h(String txFVan8h) {
		this.txFVan8h.setText(txFVan8h);
	}

	public void resetaTabelaPadrao() {
		TabelaController.preencheTabelaPadrao(this);
	}	
}