package br.com.gellog.view.tab.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import java.util.Optional;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.lang3.StringUtils;

import br.com.gellog.controller.EmpresaController;
import br.com.gellog.model.Empresa;
import br.com.gellog.view.tab.TabCliente;

public class ContentClienteBusca {

	private JTable table;
	private JFormattedTextField txFRazaoSocial, txFCNPJ;
	private List<Empresa> listaEmpresas;
	private DefaultTableModel tableModel;
	private static int idEmpresa;
	public JPanel contentClienteBusca() {

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(0, 0));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
		mainPanel.add(panel, BorderLayout.CENTER);

		JPanel panel_Titulo = new JPanel();
		panel_Titulo.setBackground(new Color(110, 110, 135));
		GridBagConstraints gbc_panel_Titulo = new GridBagConstraints();
		gbc_panel_Titulo.gridwidth = 4;
		gbc_panel_Titulo.insets = new Insets(0, 0, 20, 0);
		gbc_panel_Titulo.fill = GridBagConstraints.BOTH;
		gbc_panel_Titulo.gridx = 0;
		gbc_panel_Titulo.gridy = 0;
		panel.add(panel_Titulo, gbc_panel_Titulo);

		JLabel lblFiltroClientes = new JLabel("Filtro de Clientes");
		lblFiltroClientes.setForeground(new Color(255, 255, 255));
		panel_Titulo.add(lblFiltroClientes);

		JLabel lblRazosocial = new JLabel("Razão Social:");
		GridBagConstraints gbc_lblRazosocial = new GridBagConstraints();
		gbc_lblRazosocial.anchor = GridBagConstraints.EAST;
		gbc_lblRazosocial.insets = new Insets(0, 0, 5, 5);
		gbc_lblRazosocial.gridx = 0;
		gbc_lblRazosocial.gridy = 1;
		panel.add(lblRazosocial, gbc_lblRazosocial);

		txFRazaoSocial = new JFormattedTextField();
		GridBagConstraints gbc_txRazaoSocial = new GridBagConstraints();
		gbc_txRazaoSocial.insets = new Insets(0, 0, 5, 5);
		gbc_txRazaoSocial.fill = GridBagConstraints.HORIZONTAL;
		gbc_txRazaoSocial.gridx = 1;
		gbc_txRazaoSocial.gridy = 1;
		panel.add(txFRazaoSocial, gbc_txRazaoSocial);
		txFRazaoSocial.setColumns(10);
		txFRazaoSocial.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

				Runnable format = new Runnable() {

					public void run() {
						// TODO Auto-generated method stub

						if (!StringUtils.isAlphaSpace(txFRazaoSocial.getText())) {
							String text = txFRazaoSocial.getText();
							txFRazaoSocial.setText(Optional.ofNullable(text).filter(str -> str.length() != 0)
									.map(str -> str.substring(0, str.length() - 1)).orElse(text));

						}
						try {
							listaEmpresas = EmpresaController.getEmpresaPeloNome(txFRazaoSocial.getText());
							tableModel.setRowCount(0);
							reiniciaTabela();
							for (Empresa empresa : listaEmpresas) {
								tableModel.addRow(new Object[] {empresa.getId(), empresa.getNome(), empresa.getCnpj(),
										empresa.getTelefone(), empresa.getEmail(),
										new ImageIcon("src/main/java/br/com/gellog/view/img/iconAtualizar.png") });

							}

						} catch (Exception evt) {
							// TODO Auto-generated catch block
							evt.printStackTrace();
						}
					}
				};
				SwingUtilities.invokeLater(format);

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel lblCnpj = new JLabel("CNPJ:");
		GridBagConstraints gbc_lblCnpj = new GridBagConstraints();
		gbc_lblCnpj.anchor = GridBagConstraints.EAST;
		gbc_lblCnpj.insets = new Insets(0, 0, 5, 5);
		gbc_lblCnpj.gridx = 2;
		gbc_lblCnpj.gridy = 1;
		panel.add(lblCnpj, gbc_lblCnpj);

		
		txFCNPJ = new JFormattedTextField();
		GridBagConstraints gbc_txCNPJ = new GridBagConstraints();
		gbc_txCNPJ.fill = GridBagConstraints.HORIZONTAL;
		gbc_txCNPJ.insets = new Insets(0, 0, 5, 0);
		gbc_txCNPJ.gridx = 3;
		gbc_txCNPJ.gridy = 1;
		panel.add(txFCNPJ, gbc_txCNPJ);
		txFCNPJ.setColumns(10);
		txFCNPJ.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				Runnable format = new Runnable() {

					public void run() {
						// TODO Auto-generated method stub
						if (!StringUtils.isNumeric(txFCNPJ.getText())) {
							String text = txFCNPJ.getText();
							txFCNPJ.setText(Optional.ofNullable(text).filter(str -> str.length() != 0)
									.map(str -> str.substring(0, str.length() - 1)).orElse(text));
						}

						try {
							listaEmpresas = EmpresaController.getEmpresaPeloCNPJ(txFCNPJ.getText());
							tableModel.setRowCount(0);
							reiniciaTabela();
							for (Empresa empresa : listaEmpresas) {
								tableModel.addRow(new Object[] {empresa.getId(), empresa.getNome(), empresa.getCnpj(), empresa.getTelefone(), empresa.getEmail(), new ImageIcon("src/main/java/br/com/gellog/view/img/iconAtualizar.png") });
							}
						} catch (Exception evt) {
							// TODO Auto-generated catch block
							evt.printStackTrace();
						}
					}
				};
				SwingUtilities.invokeLater(format);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
			}
		});

		String[] header = {"ID", "Razão Social", "CNPJ", "Telefone", "Email", "Alterar" };

		tableModel = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 5:
					return ImageIcon.class;
				default:
					return String.class;
				}
			}
		};
		for (String column : header) {
			tableModel.addColumn(column);
		}
		table = new JTable(tableModel);
		table.getColumnModel().getColumn(0).setWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		
		JScrollPane sp = new JScrollPane(table);
		sp.setPreferredSize(new Dimension(800, 200));
		GridBagConstraints gbc_sp = new GridBagConstraints();
		gbc_sp.insets = new Insets(20, 0, 5, 5);
		gbc_sp.gridwidth = 4;
		gbc_sp.fill = GridBagConstraints.BOTH;
		gbc_sp.gridx = 0;
		gbc_sp.gridy = 2;
		panel.add(sp, gbc_sp);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
					try {
						idEmpresa = (Integer) table.getValueAt(table.getSelectedRow(), 0);
						TabCliente.alteraClientes(EmpresaController.getEmpresaPeloId(idEmpresa));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		});
		
		return mainPanel;
	}

	public void reiniciaTabela() {
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			tableModel.removeRow(i);
		}
	}
}
