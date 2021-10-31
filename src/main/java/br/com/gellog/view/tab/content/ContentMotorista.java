package br.com.gellog.view.tab.content;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.gellog.controller.EnderecoController;
import br.com.gellog.controller.MotoristaController;
import br.com.gellog.controller.VeiculoController;
import br.com.gellog.model.Motorista;
import br.com.gellog.model.Veiculo;
import br.com.gellog.util.CEPConnection;
import br.com.gellog.util.TipoVeiculo;
import br.com.gellog.view.tab.TabMotorista;
import br.com.gellog.view.util.Events.EmailFormat;
import br.com.gellog.view.util.Events.OnlyNumber;
import br.com.gellog.view.util.Events.OnlyWords;
import br.com.gellog.view.util.Events.PhoneFormat;
import br.com.gellog.view.util.jcomponents.JIconButton;
import br.com.gellog.view.util.jcomponents.JbtnRoundedBorder;
import br.com.gellog.view.util.jcomponents.MyJPanel;

public class ContentMotorista {

	// private static FrameTabela frame;
	private JPanel panel_DadosGeraisTitulo, panel, panel_Titulo, panel_TituloVeiculos;
	private MyJPanel panel_DadosGerais, panel_Endereco, panel_Veiculos;
	private JLabel lblDadosGerais;
	private JButton btnAdicionar, botaoVoltar, botaoCancelar, botaoSalvar;
	private JFormattedTextField txFNome, txFCPF, txFEmail, txFTelefone, txFTelefone2, txFCEP, txFCidade, txFEstado,
			txFBairro, txFLogradouro, txFNumero, txFComplemento, txFModelo, txFPlaca, txFDescricao;
	private String auxCpf;
	
	private JTable tbAdicionados;
	private DefaultTableModel tableModel;
	private List<Veiculo> listaVeiculos;

	public JPanel contentMotorista(boolean novoMotorista, Motorista motorista) {

		panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNovoCliente = new JLabel("Motorista / Adiciona");
		lblNovoCliente.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		GridBagConstraints gbc_panel_lblNCliente = new GridBagConstraints();
		gbc_panel_lblNCliente.insets = new Insets(0, 0, 5, 5);
		gbc_panel_lblNCliente.fill = GridBagConstraints.BOTH;
		gbc_panel_lblNCliente.gridx = 0;
		gbc_panel_lblNCliente.gridy = 0;
		panel.add(lblNovoCliente, gbc_panel_lblNCliente);

		panel_DadosGerais = new MyJPanel();
		panel_DadosGerais.setBorder(new EmptyBorder(0, 5, 5, 5));
		GridBagConstraints gbc_panel_DadosGerais = new GridBagConstraints();
		gbc_panel_DadosGerais.insets = new Insets(0, 0, 5, 5);
		gbc_panel_DadosGerais.fill = GridBagConstraints.BOTH;
		gbc_panel_DadosGerais.gridx = 0;
		gbc_panel_DadosGerais.gridy = 1;
		GridBagLayout gbl_panel_DadosGerais = new GridBagLayout();
		gbl_panel_DadosGerais.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_DadosGerais.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel_DadosGerais.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_DadosGerais.rowWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_DadosGerais.setLayout(gbl_panel_DadosGerais);
		panel.add(panel_DadosGerais, gbc_panel_DadosGerais);

		panel_DadosGeraisTitulo = new JPanel();
		panel_DadosGeraisTitulo.setBackground(new Color(110, 110, 135));
		GridBagConstraints gbc_panel_DadosGeraisTitulo = new GridBagConstraints();
		gbc_panel_DadosGeraisTitulo.gridwidth = 6;
		gbc_panel_DadosGeraisTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_panel_DadosGeraisTitulo.fill = GridBagConstraints.BOTH;
		gbc_panel_DadosGeraisTitulo.gridx = 0;
		gbc_panel_DadosGeraisTitulo.gridy = 0;
		panel_DadosGerais.add(panel_DadosGeraisTitulo, gbc_panel_DadosGeraisTitulo);

		lblDadosGerais = new JLabel("Dados Gerais do Motorista");
		lblDadosGerais.setForeground(new Color(255, 255, 255));
		panel_DadosGeraisTitulo.add(lblDadosGerais);

		JLabel lblNome = new JLabel("Nome:");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		panel_DadosGerais.add(lblNome, gbc_lblNome);

		txFNome = new JFormattedTextField();
		GridBagConstraints gbc_txFNome = new GridBagConstraints();
		gbc_txFNome.insets = new Insets(0, 0, 5, 5);
		gbc_txFNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFNome.gridx = 1;
		gbc_txFNome.gridy = 1;
		panel_DadosGerais.add(txFNome, gbc_txFNome);
		txFNome.setColumns(18);
		txFNome.getDocument().addDocumentListener(new OnlyWords(txFNome));

		JLabel lblTelefone = new JLabel("Telefone:");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.EAST;
		gbc_lblTelefone.insets = new Insets(0, 0, 0, 5);
		gbc_lblTelefone.gridx = 2;
		gbc_lblTelefone.gridy = 1;
		panel_DadosGerais.add(lblTelefone, gbc_lblTelefone);

		txFTelefone = new JFormattedTextField();
		GridBagConstraints gbc_txFTelefone = new GridBagConstraints();
		gbc_txFTelefone.insets = new Insets(0, 0, 0, 5);
		gbc_txFTelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFTelefone.gridx = 3;
		gbc_txFTelefone.gridy = 1;
		panel_DadosGerais.add(txFTelefone, gbc_txFTelefone);
		txFTelefone.setColumns(10);
		txFTelefone.getDocument().addDocumentListener(new PhoneFormat(txFTelefone));

		JLabel lblTelefone2 = new JLabel("Telefone:");
		GridBagConstraints gbc_lblTelefone2 = new GridBagConstraints();
		gbc_lblTelefone2.anchor = GridBagConstraints.EAST;
		gbc_lblTelefone2.insets = new Insets(0, 0, 0, 5);
		gbc_lblTelefone2.gridx = 4;
		gbc_lblTelefone2.gridy = 1;
		panel_DadosGerais.add(lblTelefone2, gbc_lblTelefone2);

		txFTelefone2 = new JFormattedTextField();
		GridBagConstraints gbc_txFTelefone2 = new GridBagConstraints();
		gbc_txFTelefone2.insets = new Insets(0, 0, 0, 5);
		gbc_txFTelefone2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFTelefone2.gridx = 5;
		gbc_txFTelefone2.gridy = 1;
		panel_DadosGerais.add(txFTelefone2, gbc_txFTelefone2);
		txFTelefone2.setColumns(10);
		txFTelefone2.getDocument().addDocumentListener(new PhoneFormat(txFTelefone2));

		JLabel lblEmail = new JLabel("E-mail");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 0, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 2;
		panel_DadosGerais.add(lblEmail, gbc_lblEmail);

		txFEmail = new JFormattedTextField();
		GridBagConstraints gbc_txFEmail = new GridBagConstraints();
		gbc_txFEmail.insets = new Insets(0, 0, 0, 5);
		gbc_txFEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFEmail.gridx = 1;
		gbc_txFEmail.gridy = 2;
		panel_DadosGerais.add(txFEmail, gbc_txFEmail);
		txFEmail.setColumns(10);
		txFEmail.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (!EmailFormat.validate(txFEmail.getText())) {
					txFEmail.setText(null);
				}
			}

			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel lblCpf = new JLabel("CPF:");
		GridBagConstraints gbc_lblCnpj = new GridBagConstraints();
		gbc_lblCnpj.anchor = GridBagConstraints.EAST;
		gbc_lblCnpj.insets = new Insets(0, 0, 5, 5);
		gbc_lblCnpj.gridx = 2;
		gbc_lblCnpj.gridy = 2;
		panel_DadosGerais.add(lblCpf, gbc_lblCnpj);

		try {
			txFCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		GridBagConstraints gbc_txFCPF = new GridBagConstraints();
		gbc_txFCPF.insets = new Insets(0, 0, 5, 5);
		gbc_txFCPF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFCPF.gridx = 3;
		gbc_txFCPF.gridy = 2;
		panel_DadosGerais.add(txFCPF, gbc_txFCPF);
		txFCPF.setColumns(6);

		// DadosGerais
		// =========================================================================================//
		// Endereço

		panel_Endereco = new MyJPanel();
		panel_Endereco.setBorder(new EmptyBorder(0, 5, 5, 5));
		GridBagConstraints gbc_panel_Endereco = new GridBagConstraints();
		gbc_panel_Endereco.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Endereco.fill = GridBagConstraints.BOTH;
		gbc_panel_Endereco.gridx = 0;
		gbc_panel_Endereco.gridy = 2;
		GridBagLayout gbl_panel_Endereco = new GridBagLayout();
		gbl_panel_Endereco.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_Endereco.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel_Endereco.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_Endereco.rowWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_Endereco.setLayout(gbl_panel_Endereco);
		panel.add(panel_Endereco, gbc_panel_Endereco);

		panel_Titulo = new JPanel();
		panel_Titulo.setBackground(new Color(110, 110, 135));
		GridBagConstraints gbc_panel_Titulo = new GridBagConstraints();
		gbc_panel_Titulo.gridwidth = 8;
		gbc_panel_Titulo.insets = new Insets(0, 0, 5, 0);
		gbc_panel_Titulo.fill = GridBagConstraints.BOTH;
		gbc_panel_Titulo.gridx = 0;
		gbc_panel_Titulo.gridy = 0;
		panel_Endereco.add(panel_Titulo, gbc_panel_Titulo);

		JLabel lblEndereo = new JLabel("Endereço");
		lblEndereo.setForeground(new Color(255, 255, 255));
		panel_Titulo.add(lblEndereo);

		JLabel lblCep = new JLabel("CEP:");
		GridBagConstraints gbc_lblCep = new GridBagConstraints();
		gbc_lblCep.anchor = GridBagConstraints.EAST;
		gbc_lblCep.insets = new Insets(0, 0, 5, 5);
		gbc_lblCep.gridx = 0;
		gbc_lblCep.gridy = 1;
		panel_Endereco.add(lblCep, gbc_lblCep);

		txFCEP = new JFormattedTextField();

		try {
			txFCEP = new JFormattedTextField(new MaskFormatter("#####-###"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		GridBagConstraints gbc_txFCEP = new GridBagConstraints();
		gbc_txFCEP.insets = new Insets(0, 0, 5, 5);
		gbc_txFCEP.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFCEP.gridx = 1;
		gbc_txFCEP.gridy = 1;
		panel_Endereco.add(txFCEP, gbc_txFCEP);
		txFCEP.setColumns(10);
		txFCEP.addFocusListener(new FocusListener() {
			CEPConnection conectaCep = new CEPConnection();

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (txFCEP.getText().length() > 7) {
					try {
						conectaCep.buscarCep(txFCEP.getText());
					} catch (Exception event) {
						// TODO Auto-generated catch block
						event.printStackTrace();
					}
					txFLogradouro.setText(conectaCep.getLogradouro());
					txFBairro.setText(conectaCep.getBairro());
					txFCidade.setText(conectaCep.getCidade());
					txFEstado.setText(conectaCep.getUf());
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel lblCidade = new JLabel("Cidade:");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.EAST;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 2;
		gbc_lblCidade.gridy = 1;
		panel_Endereco.add(lblCidade, gbc_lblCidade);

		txFCidade = new JFormattedTextField();
		GridBagConstraints gbc_txFCidade = new GridBagConstraints();
		gbc_txFCidade.insets = new Insets(0, 0, 5, 5);
		gbc_txFCidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFCidade.gridx = 3;
		gbc_txFCidade.gridy = 1;
		panel_Endereco.add(txFCidade, gbc_txFCidade);
		txFCidade.setColumns(10);

		JLabel lblEstado = new JLabel("Estado:");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 4;
		gbc_lblEstado.gridy = 1;
		panel_Endereco.add(lblEstado, gbc_lblEstado);

		txFEstado = new JFormattedTextField();
		GridBagConstraints gbc_txFEstado = new GridBagConstraints();
		gbc_txFEstado.insets = new Insets(0, 0, 5, 5);
		gbc_txFEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFEstado.gridx = 5;
		gbc_txFEstado.gridy = 1;
		panel_Endereco.add(txFEstado, gbc_txFEstado);
		txFEstado.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro:");
		GridBagConstraints gbc_lblBairro = new GridBagConstraints();
		gbc_lblBairro.anchor = GridBagConstraints.EAST;
		gbc_lblBairro.insets = new Insets(0, 0, 5, 5);
		gbc_lblBairro.gridx = 6;
		gbc_lblBairro.gridy = 1;
		panel_Endereco.add(lblBairro, gbc_lblBairro);

		txFBairro = new JFormattedTextField();
		GridBagConstraints gbc_txFBairro = new GridBagConstraints();
		gbc_txFBairro.insets = new Insets(0, 0, 5, 0);
		gbc_txFBairro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFBairro.gridx = 7;
		gbc_txFBairro.gridy = 1;
		panel_Endereco.add(txFBairro, gbc_txFBairro);
		txFBairro.setColumns(10);

		JLabel lblLogradouro = new JLabel("Logradouro:");
		GridBagConstraints gbc_lblLogradouro = new GridBagConstraints();
		gbc_lblLogradouro.anchor = GridBagConstraints.EAST;
		gbc_lblLogradouro.insets = new Insets(0, 0, 0, 5);
		gbc_lblLogradouro.gridx = 0;
		gbc_lblLogradouro.gridy = 2;
		panel_Endereco.add(lblLogradouro, gbc_lblLogradouro);

		txFLogradouro = new JFormattedTextField();
		GridBagConstraints gbc_txFLogradouro = new GridBagConstraints();
		gbc_txFLogradouro.gridwidth = 3;
		gbc_txFLogradouro.insets = new Insets(0, 0, 0, 5);
		gbc_txFLogradouro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFLogradouro.gridx = 1;
		gbc_txFLogradouro.gridy = 2;
		panel_Endereco.add(txFLogradouro, gbc_txFLogradouro);
		txFLogradouro.setColumns(10);

		JLabel lblNmero = new JLabel("Número");
		GridBagConstraints gbc_lblNmero = new GridBagConstraints();
		gbc_lblNmero.anchor = GridBagConstraints.EAST;
		gbc_lblNmero.insets = new Insets(0, 0, 0, 5);
		gbc_lblNmero.gridx = 4;
		gbc_lblNmero.gridy = 2;
		panel_Endereco.add(lblNmero, gbc_lblNmero);

		txFNumero = new JFormattedTextField();
		GridBagConstraints gbc_txFNumero = new GridBagConstraints();
		gbc_txFNumero.insets = new Insets(0, 0, 0, 5);
		gbc_txFNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFNumero.gridx = 5;
		gbc_txFNumero.gridy = 2;
		panel_Endereco.add(txFNumero, gbc_txFNumero);
		txFNumero.setColumns(10);
		txFNumero.getDocument().addDocumentListener(new OnlyNumber(txFNumero));

		JLabel lblComplemento = new JLabel("Complemento:");
		GridBagConstraints gbc_lblComplemento = new GridBagConstraints();
		gbc_lblComplemento.anchor = GridBagConstraints.EAST;
		gbc_lblComplemento.insets = new Insets(0, 0, 0, 5);
		gbc_lblComplemento.gridx = 6;
		gbc_lblComplemento.gridy = 2;
		panel_Endereco.add(lblComplemento, gbc_lblComplemento);

		txFComplemento = new JFormattedTextField();
		GridBagConstraints gbc_txFComplemento = new GridBagConstraints();
		gbc_txFComplemento.insets = new Insets(0, 0, 0, 5);
		gbc_txFComplemento.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFComplemento.gridx = 7;
		gbc_txFComplemento.gridy = 2;
		panel_Endereco.add(txFComplemento, gbc_txFComplemento);
		txFComplemento.setColumns(10);

		// Endereço
		// ==================================================================================//
		// Veiculos

		panel_Veiculos = new MyJPanel();
		panel_Veiculos.setBorder(new EmptyBorder(0, 5, 5, 5));
		GridBagConstraints gbc_panel_Veiculos = new GridBagConstraints();
		gbc_panel_Veiculos.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Veiculos.fill = GridBagConstraints.BOTH;
		gbc_panel_Veiculos.gridx = 0;
		gbc_panel_Veiculos.gridy = 3;
		GridBagLayout gbl_panel_Veiculos = new GridBagLayout();
		gbl_panel_Veiculos.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_Veiculos.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel_Veiculos.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_Veiculos.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, 0.0 };
		panel_Veiculos.setLayout(gbl_panel_Veiculos);
		panel.add(panel_Veiculos, gbc_panel_Veiculos);

		panel_TituloVeiculos = new JPanel();
		panel_TituloVeiculos.setBackground(new Color(110, 110, 135));
		GridBagConstraints gbc_panel_TituloVeiculos = new GridBagConstraints();
		gbc_panel_TituloVeiculos.gridwidth = 8;
		gbc_panel_TituloVeiculos.insets = new Insets(0, 0, 5, 5);
		gbc_panel_TituloVeiculos.fill = GridBagConstraints.BOTH;
		gbc_panel_TituloVeiculos.gridx = 0;
		gbc_panel_TituloVeiculos.gridy = 0;
		panel_Veiculos.add(panel_TituloVeiculos, gbc_panel_TituloVeiculos);

		JLabel lblVeiculoenviarFaturaenviarConfirmao = new JLabel("Veiculo");
		lblVeiculoenviarFaturaenviarConfirmao.setForeground(new Color(255, 255, 255));
		panel_TituloVeiculos.add(lblVeiculoenviarFaturaenviarConfirmao);

		JLabel lblVeiculo = new JLabel("Veiculo:");
		GridBagConstraints gbc_lblVeiculo = new GridBagConstraints();
		gbc_lblVeiculo.anchor = GridBagConstraints.EAST;
		gbc_lblVeiculo.insets = new Insets(0, 0, 5, 5);
		gbc_lblVeiculo.gridx = 0;
		gbc_lblVeiculo.gridy = 1;
		panel_Veiculos.add(lblVeiculo, gbc_lblVeiculo);

		GridBagConstraints gbc_txFVeiculo = new GridBagConstraints();
		gbc_txFVeiculo.insets = new Insets(0, 0, 5, 5);
		gbc_txFVeiculo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFVeiculo.gridx = 1;
		gbc_txFVeiculo.gridy = 1;
		JComboBox<TipoVeiculo> jComboBox = new JComboBox<TipoVeiculo>(TipoVeiculo.values());
		panel_Veiculos.add(jComboBox , gbc_txFVeiculo);
		//tipoVeiculo.setColumns(10);

		JLabel lblModelo = new JLabel("Modelo:");
		GridBagConstraints gbc_lblModelo = new GridBagConstraints();
		gbc_lblModelo.anchor = GridBagConstraints.EAST;
		gbc_lblModelo.insets = new Insets(0, 0, 5, 5);
		gbc_lblModelo.gridx = 3;
		gbc_lblModelo.gridy = 1;
		panel_Veiculos.add(lblModelo, gbc_lblModelo);

		txFModelo = new JFormattedTextField();
		GridBagConstraints gbc_txFModelo = new GridBagConstraints();
		gbc_txFModelo.insets = new Insets(0, 0, 5, 5);
		gbc_txFModelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFModelo.gridx = 4;
		gbc_txFModelo.gridy = 1;
		panel_Veiculos.add(txFModelo, gbc_txFModelo);
		txFModelo.setColumns(10);

		JLabel lblPlaca = new JLabel("Placa:");
		GridBagConstraints gbc_lblPlaca = new GridBagConstraints();
		gbc_lblPlaca.anchor = GridBagConstraints.EAST;
		gbc_lblPlaca.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlaca.gridx = 5;
		gbc_lblPlaca.gridy = 1;
		panel_Veiculos.add(lblPlaca, gbc_lblPlaca);

		txFPlaca = new JFormattedTextField();
		GridBagConstraints gbc_txFPlaca = new GridBagConstraints();
		gbc_txFPlaca.gridwidth = 2;
		gbc_txFPlaca.insets = new Insets(0, 0, 5, 5);
		gbc_txFPlaca.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFPlaca.gridx = 6;
		gbc_txFPlaca.gridy = 1;
		panel_Veiculos.add(txFPlaca, gbc_txFPlaca);
		txFTelefone.setColumns(10);

		JLabel lblDescrio = new JLabel("Descrição:");
		GridBagConstraints gbc_lblDescrio = new GridBagConstraints();
		gbc_lblDescrio.anchor = GridBagConstraints.EAST;
		gbc_lblDescrio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescrio.gridx = 0;
		gbc_lblDescrio.gridy = 2;
		panel_Veiculos.add(lblDescrio, gbc_lblDescrio);

		txFDescricao = new JFormattedTextField();
		GridBagConstraints gbc_txFDescricao = new GridBagConstraints();
		gbc_txFDescricao.gridwidth = 7;
		gbc_txFDescricao.insets = new Insets(0, 0, 5, 5);
		gbc_txFDescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFDescricao.gridx = 1;
		gbc_txFDescricao.gridy = 2;
		panel_Veiculos.add(txFDescricao, gbc_txFDescricao);
		// txFDescricao.setColumns(10);

		btnAdicionar = new JButton("Incluir Veículo");
		btnAdicionar.setBorder(new JbtnRoundedBorder(5));
		btnAdicionar.setBackground(new Color(110, 110, 135));
		btnAdicionar.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
		gbc_btnAdicionar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdicionar.gridx = 6;
		gbc_btnAdicionar.gridy = 3;
		panel_Veiculos.add(btnAdicionar, gbc_btnAdicionar);

		btnAdicionar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnAdicionar.doClick();
				}
			}
		});
		btnAdicionar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				tableModel.addRow(new Object[] { jComboBox.getSelectedItem().toString(), txFModelo.getText(),
						txFPlaca.getText(), txFDescricao.getText(),
						new ImageIcon("src/main/java/br/com/gellog/view/img/iconExcluir.png") });

				//txFNome.setText(null);
				txFModelo.setText(null);
				txFPlaca.setText(null);
				txFDescricao.setText(null);
			}
		});

		String[] header = { "Veículo", "Modelo", "Placa", "Descrição", "Excluir" };
		tableModel = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 4:
					return ImageIcon.class;
				default:
					return String.class;
				}
			}
		};
		tbAdicionados = new JTable(tableModel);
		tbAdicionados.setAutoCreateRowSorter(true);
		for (String column : header) {
			tableModel.addColumn(column);
		}
		JScrollPane spAdicionados = new JScrollPane(tbAdicionados);
		spAdicionados.setPreferredSize(new Dimension(800, 80));
		GridBagConstraints gbc_txPAdicionados = new GridBagConstraints();
		gbc_txPAdicionados.gridwidth = 8;
		gbc_txPAdicionados.insets = new Insets(0, 0, 5, 5);
		gbc_txPAdicionados.fill = GridBagConstraints.BOTH;
		gbc_txPAdicionados.gridx = 0;
		gbc_txPAdicionados.gridy = 4;
		panel_Veiculos.add(spAdicionados, gbc_txPAdicionados);

		tbAdicionados.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (tbAdicionados.getSelectedColumn() == 4) {
					try {

						int row = tbAdicionados.getSelectedRow();
						row = tbAdicionados.convertRowIndexToModel(row);
						tableModel.removeRow(row);

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		// contato
		// ==============================================================================================================//

		JPanel panel_buttons = new JPanel();
		panel_buttons.setBorder(new EmptyBorder(20, 0, 0, 0));
		GridBagConstraints gbc_panel_buttons = new GridBagConstraints();
		gbc_panel_buttons.gridwidth = 2;
		gbc_panel_buttons.anchor = GridBagConstraints.SOUTH;
		gbc_panel_buttons.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_buttons.gridx = 0;
		gbc_panel_buttons.gridy = 5;
		panel.add(panel_buttons, gbc_panel_buttons);

		botaoVoltar = new JIconButton().botaoVoltar();
		botaoCancelar = new JIconButton().botaoCancelar();
		botaoSalvar = new JIconButton().botaoSalvar();
		panel_buttons.add(botaoVoltar);
		panel_buttons.add(botaoCancelar);
		panel_buttons.add(botaoSalvar);
		botaoVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TabMotorista.voltarListaMotorista();
				reiniciaCampos();
			}
		});

		botaoCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TabMotorista.voltarListaMotorista();
				reiniciaCampos();
			}
		});

		botaoSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (txFCPF != null || !txFCPF.getText().isEmpty()) {
					auxCpf = txFCPF.getText().replaceAll("[^0-9]", "");
				} else {
					auxCpf = null;
				}
				if (motorista == null) {

					EnderecoController.endereco(txFBairro.getText(), txFCEP.getText(), txFCidade.getText(),
							txFComplemento.getText(), txFEstado.getText(), txFLogradouro.getText(),
							txFNumero.getText());
					
					MotoristaController.adicionaMotorista(txFNome.getText(), txFCPF.getText(), txFTelefone.getText(), txFTelefone2.getText(), txFEmail.getText());

					for (int i = 0; i < tableModel.getRowCount(); i++) {

						VeiculoController.veiculo((String) tableModel.getValueAt(i, 1),
								(String) tableModel.getValueAt(i, 2), (String) tableModel.getValueAt(i, 0), (String) tableModel.getValueAt(i, 3));

						
					}
					reiniciaCampos();
					TabMotorista.voltarListaMotorista();
				} else {

					EnderecoController.updateEndereco(motorista.getEndereco(), txFBairro.getText(), txFCEP.getText(),
							txFCidade.getText(), txFComplemento.getText(), txFEstado.getText(), txFLogradouro.getText(),
							txFNumero.getText());
					
					MotoristaController.updateMotorista(motorista, txFNome.getText(), txFCPF.getText(), txFTelefone.getText(), txFTelefone2.getText(), txFEmail.getText());

				

					VeiculoController.deletaVeiculo(motorista);

					for (int i = 0; i < tableModel.getRowCount(); i++) {

						VeiculoController.veiculo((String) tableModel.getValueAt(i, 1),
								(String) tableModel.getValueAt(i, 2), (String) tableModel.getValueAt(i, 0), (String) tableModel.getValueAt(i, 3));

					}
					reiniciaCampos();
					TabMotorista.voltarListaMotorista();
				}
			}
		});

		if (!novoMotorista && motorista != null) {
			preencheMotorista(motorista);
		}

		return panel;
	}


	public void reiniciaCampos() {
		txFBairro.setText(null);
		txFCEP.setText(null);
		txFCidade.setText(null);
		txFComplemento.setText(null);
		txFEstado.setText(null);
		txFLogradouro.setText(null);
		txFNumero.setText(null);
		txFCPF.setText(null);
		txFEmail.setText(null);
		txFTelefone2.setText(null);
		txFNome.setText(null);
		txFTelefone.setText(null);
		txFPlaca.setText(null);
		txFModelo.setText(null);

		int rowCount = tableModel.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			tableModel.fireTableDataChanged();
			tableModel.setRowCount(0);
			tableModel.removeRow(i);
		}
	}

	public void preencheMotorista(Motorista motorista) {
		try {
			txFBairro.setText(motorista.getEndereco().getBairro());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			txFCEP.setText(motorista.getEndereco().getCep());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			txFCidade.setText(motorista.getEndereco().getCidade());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			txFComplemento.setText(motorista.getEndereco().getComplemento());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			txFEstado.setText(motorista.getEndereco().getEstado());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			txFLogradouro.setText(motorista.getEndereco().getLogradouro());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			txFNumero.setText(motorista.getEndereco().getNumero().toString());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		try {
			txFCPF.setText(motorista.getCpf());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			txFEmail.setText(motorista.getEmail());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		try {
			txFNome.setText(motorista.getNome());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txFTelefone.setText(motorista.getTelefone());
		txFTelefone2.setText(motorista.getTelefone());

		try {
			listaVeiculos = VeiculoController.getVeiculos(motorista.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Veiculo veiculo : listaVeiculos) {
			tableModel.addRow(new Object[] {veiculo.getTipo(), veiculo.getModelo(), veiculo.getPlaca(), veiculo.getDescricao(),
					new ImageIcon("src/main/java/br/com/gellog/view/img/iconExcluir.png") });
		}
	}
}
