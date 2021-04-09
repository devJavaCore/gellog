package br.com.gellog.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Teste extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teste frame = new Teste();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Teste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 110);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 0.0 };
		getContentPane().setLayout(gridBagLayout);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.YELLOW);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		getContentPane().add(panel_1, gbc_panel_1);

		JLabel lblTabelaDeFrete = new JLabel("Tabela de Frete");
		panel_1.add(lblTabelaDeFrete);

		JCheckBox chckbxTabelaDeFrete = new JCheckBox("Tabela de Frete Padrão", true);
		GridBagConstraints gbc_chckbxTabelaDeFrete = new GridBagConstraints();
		gbc_chckbxTabelaDeFrete.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxTabelaDeFrete.gridx = 0;
		gbc_chckbxTabelaDeFrete.gridy = 2;
		getContentPane().add(chckbxTabelaDeFrete, gbc_chckbxTabelaDeFrete);

		final JButton btnCostumizarTabelaDe = new JButton("Costumizar Tabela de Frete");
		btnCostumizarTabelaDe.setEnabled(false);
		GridBagConstraints gbc_btnCostumizarTabelaDe = new GridBagConstraints();
		gbc_btnCostumizarTabelaDe.gridx = 1;
		gbc_btnCostumizarTabelaDe.gridy = 2;
		getContentPane().add(btnCostumizarTabelaDe, gbc_btnCostumizarTabelaDe);

		chckbxTabelaDeFrete.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					btnCostumizarTabelaDe.setEnabled(false);
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					btnCostumizarTabelaDe.setEnabled(true);
				}
				validate();
				repaint();
			}
		});
	}
}