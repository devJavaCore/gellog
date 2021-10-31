package br.com.gellog.view.tab.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
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

import br.com.gellog.controller.MotoristaController;
import br.com.gellog.controller.VeiculoController;
import br.com.gellog.model.Motorista;
import br.com.gellog.model.Pessoa;
import br.com.gellog.model.Veiculo;
import br.com.gellog.util.TipoVeiculo;
import br.com.gellog.view.tab.TabMotorista;

public class ContentMotoristaBusca {

	private JTable table;
	private JFormattedTextField txFNome;
	private List<Veiculo> listaVeiculos;
	private List<Pessoa> listaMotorista;
	private DefaultTableModel tableModel;
	private static int idMotorista;
	
	public JPanel contentMotoristaBusca() {

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

		JLabel lblFiltroMotorista = new JLabel("Filtro de Motoristas");
		lblFiltroMotorista.setForeground(new Color(255, 255, 255));
		panel_Titulo.add(lblFiltroMotorista);

		JLabel lblMotoristas = new JLabel("Nome: ");
		GridBagConstraints gbc_lblMotoristas = new GridBagConstraints();
		gbc_lblMotoristas.anchor = GridBagConstraints.EAST;
		gbc_lblMotoristas.insets = new Insets(0, 0, 5, 5);
		gbc_lblMotoristas.gridx = 0;
		gbc_lblMotoristas.gridy = 1;
		panel.add(lblMotoristas, gbc_lblMotoristas);

		txFNome = new JFormattedTextField();
		GridBagConstraints gbc_txNome = new GridBagConstraints();
		gbc_txNome.insets = new Insets(0, 0, 5, 5);
		gbc_txNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txNome.gridx = 1;
		gbc_txNome.gridy = 1;
		panel.add(txFNome, gbc_txNome);
		txFNome.setColumns(10);
		
		
		txFNome.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

				Runnable format = new Runnable() {

					public void run() {
						// TODO Auto-generated method stub

						if (!StringUtils.isAlphaSpace(txFNome.getText())) {
							String text = txFNome.getText();
							txFNome.setText(Optional.ofNullable(text).filter(str -> str.length() != 0)
									.map(str -> str.substring(0, str.length() - 1)).orElse(text));

						}
						try {
							listaMotorista = MotoristaController.getMotoristaPeloNome(txFNome.getText());
							tableModel.setRowCount(0);
							reiniciaTabela();
							for (Pessoa motorista : listaMotorista) {
								tableModel.addRow(new Object[] {motorista.getId(), motorista.getNome(), motorista.getTelefone(),
										((Motorista) motorista).getVeiculo().get(0).getModelo(), motorista.getTelefone2(),
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

		
		});

		JLabel lblVeiculo = new JLabel("Veiculo:");
		GridBagConstraints gbc_lblVeiculo = new GridBagConstraints();
		gbc_lblVeiculo.anchor = GridBagConstraints.EAST;
		gbc_lblVeiculo.insets = new Insets(0, 0, 5, 5);
		gbc_lblVeiculo.gridx = 2;
		gbc_lblVeiculo.gridy = 1;
		panel.add(lblVeiculo, gbc_lblVeiculo);

		
		
		GridBagConstraints gbc_Veiculo = new GridBagConstraints();
		gbc_Veiculo.fill = GridBagConstraints.HORIZONTAL;
		gbc_Veiculo.insets = new Insets(0, 0, 5, 0);
		gbc_Veiculo.gridx = 3;
		gbc_Veiculo.gridy = 1;
		JComboBox<TipoVeiculo> jComboBox = new JComboBox<TipoVeiculo>(TipoVeiculo.values());
		panel.add(jComboBox, gbc_Veiculo);

		jComboBox.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
				try {
					listaVeiculos = VeiculoController.getVeiculosTipo(jComboBox.getSelectedItem().toString());
					tableModel.setRowCount(0);
					reiniciaTabela();
					for (Veiculo veiculo : listaVeiculos) {
						Motorista motorista = new Motorista(); 
					
						motorista = MotoristaController.getMotoristaPeloId(veiculo.getMotorista().getId());
						tableModel.addRow(new Object[] {motorista.getId(), motorista.getNome(), motorista.getTelefone(), veiculo.getModelo(), motorista.getTelefone2(), new ImageIcon("src/main/java/br/com/gellog/view/img/iconAtualizar.png") });
					}
				} catch (Exception evt) {
					// TODO Auto-generated catch block
					evt.printStackTrace();
				}
		    }
		});
		


		String[] header = {"ID", "Nome", "Telefone", "Veiculo", "AindaNaoSei", "Alterar" };

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
						idMotorista = (Integer) table.getValueAt(table.getSelectedRow(), 0);
						TabMotorista.alteraMotorista(MotoristaController.getMotoristaPeloId(idMotorista));
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
