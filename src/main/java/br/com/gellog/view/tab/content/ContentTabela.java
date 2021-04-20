package br.com.gellog.view.tab.content;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import br.com.gellog.controller.TabelaController;
import br.com.gellog.model.TabelaFreteModel;
import br.com.gellog.view.TesteOutro;
import br.com.gellog.view.util.JIconButton;
import br.com.gellog.view.util.JIconTextField;
import br.com.gellog.view.util.JTextFiledSettings;
import br.com.gellog.view.util.MyJPanel;
import br.com.gellog.view.util.Events.FormatNumber;

public class ContentTabela {

	private JIconTextField txFBHKG, txFBHExc, txFRMBHKg, txFRMBHExc, txFInterirorKG, txFInterirorExc, txFTxConfins,
			txFKmRodadoFiorino, txFKmRodadoVan, txFFiorinoh, txFVanh, txFFiorino2h, txFVan2h, txFFiorino4h, txFVan4h,
			txFFiorino6h, txFVan6h, txFFiorino8h, txFVan8h;
	private JButton jbtnResetTabelaPadrao;
	private JPanel panel_TxParadoTitulo;
	private JLabel lblTaxaPorTempo;
	private TabelaFreteModel tabelaFreteObject;
	private MyJPanel panel_CalculoPeso, panel_CalculoKm, panel_txParado;

	public JPanel contentTabela() {

		tabelaFreteObject = new TabelaFreteModel();

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
		txFBHKG.setIcon(new ImageIcon(TesteOutro.class.getResource("/br/com/gellog/view/img/currency.png")));
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
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * Tags
		 * =============================================================================
		 * Events, formatting numbers
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

		txFBHKG.getDocument().addDocumentListener(new FormatNumber(txFBHKG));
		txFBHExc.getDocument().addDocumentListener(new FormatNumber(txFBHExc));
		txFRMBHKg.getDocument().addDocumentListener(new FormatNumber(txFRMBHKg));
		txFRMBHExc.getDocument().addDocumentListener(new FormatNumber(txFRMBHExc));
		txFInterirorKG.getDocument().addDocumentListener(new FormatNumber(txFInterirorKG));
		txFInterirorExc.getDocument().addDocumentListener(new FormatNumber(txFInterirorExc));
		txFTxConfins.getDocument().addDocumentListener(new FormatNumber(txFTxConfins));
		txFKmRodadoFiorino.getDocument().addDocumentListener(new FormatNumber(txFKmRodadoFiorino));
		txFKmRodadoVan.getDocument().addDocumentListener(new FormatNumber(txFKmRodadoVan));
		txFFiorinoh.getDocument().addDocumentListener(new FormatNumber(txFFiorinoh));
		txFVanh.getDocument().addDocumentListener(new FormatNumber(txFVanh));
		txFFiorino2h.getDocument().addDocumentListener(new FormatNumber(txFFiorino2h));
		txFVan2h.getDocument().addDocumentListener(new FormatNumber(txFVan2h));
		txFFiorino4h.getDocument().addDocumentListener(new FormatNumber(txFFiorino4h));
		txFVan4h.getDocument().addDocumentListener(new FormatNumber(txFVan4h));
		txFFiorino6h.getDocument().addDocumentListener(new FormatNumber(txFFiorino6h));
		txFVan6h.getDocument().addDocumentListener(new FormatNumber(txFVan6h));
		txFFiorino8h.getDocument().addDocumentListener(new FormatNumber(txFFiorino8h));
		txFVan8h.getDocument().addDocumentListener(new FormatNumber(txFVan8h));

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
				setTextfromjfields(new TabelaController().valorTabelaPadrao());
			}
		});

		return panel;
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Events Formating numbers
	 * =============================================================================
	 * Getting fields
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public TabelaFreteModel getTextfromjfields() {

		try {
			tabelaFreteObject.setBh10kg(new BigDecimal(txFBHKG.getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tabelaFreteObject.setBhExcedente(new BigDecimal(txFBHExc.getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tabelaFreteObject.setRmbh10kg(new BigDecimal(txFRMBHKg.getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tabelaFreteObject.setRmbhExcedente(new BigDecimal(txFRMBHExc.getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tabelaFreteObject.setInterior10kg(new BigDecimal(txFInterirorKG.getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tabelaFreteObject.setInteriorExcedente(new BigDecimal(txFInterirorExc.getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tabelaFreteObject.setConfinsTaxa(new BigDecimal(txFTxConfins.getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tabelaFreteObject.setKmFiorino(new BigDecimal(txFKmRodadoFiorino.getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tabelaFreteObject.setKmVanHR(new BigDecimal(txFKmRodadoVan.getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tabelaFreteObject.setTaxaFiorino1h(new BigDecimal(txFFiorinoh.getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tabelaFreteObject.setTaxaVan1h(new BigDecimal(txFVanh.getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tabelaFreteObject.setTaxaFiorino2h(new BigDecimal(txFFiorino2h.getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tabelaFreteObject.setTaxaVan2h(new BigDecimal(txFVan2h.getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tabelaFreteObject.setTaxaFiorino4h(new BigDecimal(txFFiorino4h.getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tabelaFreteObject.setTaxaVan4h(new BigDecimal(txFVan4h.getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tabelaFreteObject.setTaxaFiorino6h(new BigDecimal(txFFiorino6h.getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tabelaFreteObject.setTaxaVan6h(new BigDecimal(txFVan6h.getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tabelaFreteObject.setTaxaFiorino8h(new BigDecimal(txFFiorino8h.getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tabelaFreteObject.setTaxaVan8h(new BigDecimal(txFVan8h.getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tabelaFreteObject;
	}

	/*
	 * Setting fields
	 * =============================================================================
	 * ============== Getting fields
	 */

	public void setTextfromjfields(TabelaFreteModel textfromjfields) {

			try {
				txFBHKG.setText(textfromjfields.getBh10kg().toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				txFBHExc.setText(textfromjfields.getBhExcedente().toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				txFRMBHKg.setText(textfromjfields.getRmbh10kg().toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				txFRMBHExc.setText(textfromjfields.getRmbhExcedente().toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				txFInterirorKG.setText(textfromjfields.getInterior10kg().toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				txFInterirorExc.setText(textfromjfields.getInteriorExcedente().toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				txFTxConfins.setText(textfromjfields.getConfinsTaxa().toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				txFKmRodadoFiorino.setText(textfromjfields.getKmFiorino().toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				txFKmRodadoVan.setText(textfromjfields.getKmVanHR().toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				txFFiorinoh.setText(textfromjfields.getTaxaFiorino1h().toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				txFVanh.setText(textfromjfields.getTaxaVan1h().toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				txFFiorino2h.setText(textfromjfields.getTaxaFiorino2h().toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				txFVan2h.setText(textfromjfields.getTaxaVan2h().toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				txFFiorino4h.setText(textfromjfields.getTaxaFiorino4h().toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				txFVan4h.setText(textfromjfields.getTaxaVan4h().toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				txFFiorino6h.setText(textfromjfields.getTaxaFiorino6h().toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				txFVan6h.setText(textfromjfields.getTaxaVan6h().toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				txFFiorino8h.setText(textfromjfields.getTaxaFiorino8h().toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				txFVan8h.setText(textfromjfields.getTaxaVan8h().toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}