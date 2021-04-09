package br.com.gellog.view.tab.content;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class ContentCliente {
	private JPanel panel_DadosGeraisTitulo;
	private JLabel lblDadosGerais;
	private JButton btnAdicionar;
	private JTextField txFRazaoSocial, txFCNPJ, txFInscricaoEstadual, txFEmail, txFTelefone, txFCEP, txFCidade, txFEstado, txFBairro, txFLogradouro, txFNumero, txFComplemento, txFNome, txFEmailEmpresa, txFTelefoneEmpresa, txFDescricao;
	public JPanel contentCliente() {
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		JPanel panel_DadosGerais = new JPanel();
		panel_DadosGerais.setBorder(BorderFactory.createBevelBorder(0, new Color(230,230,240), new Color(110,110,135)));
		GridBagConstraints gbc_panel_DadosGerais = new GridBagConstraints();
		gbc_panel_DadosGerais.insets = new Insets(0, 0, 5, 5);
		gbc_panel_DadosGerais.fill = GridBagConstraints.BOTH;
		gbc_panel_DadosGerais.gridx = 0;
		gbc_panel_DadosGerais.gridy = 0;
		GridBagLayout gbl_panel_DadosGerais = new GridBagLayout();
		gbl_panel_DadosGerais.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_DadosGerais.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_DadosGerais.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_DadosGerais.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_DadosGerais.setLayout(gbl_panel_DadosGerais);
		panel.add(panel_DadosGerais, gbc_panel_DadosGerais);
		
		
		
		
		
		
		panel_DadosGeraisTitulo = new JPanel();
		panel_DadosGeraisTitulo.setBackground(new Color(110,110,135));
		GridBagConstraints gbc_panel_DadosGeraisTitulo = new GridBagConstraints();
		gbc_panel_DadosGeraisTitulo.gridwidth = 6;
		gbc_panel_DadosGeraisTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_panel_DadosGeraisTitulo.fill = GridBagConstraints.BOTH;
		gbc_panel_DadosGeraisTitulo.gridx = 0;
		gbc_panel_DadosGeraisTitulo.gridy = 0;
		panel_DadosGerais.add(panel_DadosGeraisTitulo, gbc_panel_DadosGeraisTitulo);
		
		lblDadosGerais = new JLabel("Dados Gerais");
		lblDadosGerais.setForeground(new Color(255,255,255));
		panel_DadosGeraisTitulo.add(lblDadosGerais);
		
		JLabel lblRazoSocial = new JLabel("Razão Social:");
		GridBagConstraints gbc_lblRazoSocial = new GridBagConstraints();
		gbc_lblRazoSocial.anchor = GridBagConstraints.EAST;
		gbc_lblRazoSocial.insets = new Insets(0, 0, 5, 5);
		gbc_lblRazoSocial.gridx = 0;
		gbc_lblRazoSocial.gridy = 1;
		panel_DadosGerais.add(lblRazoSocial, gbc_lblRazoSocial);
		
		txFRazaoSocial = new JTextField();
		GridBagConstraints gbc_txFRazaoSocial = new GridBagConstraints();
		gbc_txFRazaoSocial.insets = new Insets(0, 0, 5, 5);
		gbc_txFRazaoSocial.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFRazaoSocial.gridx = 1;
		gbc_txFRazaoSocial.gridy = 1;
		panel_DadosGerais.add(txFRazaoSocial, gbc_txFRazaoSocial);
		txFRazaoSocial.setColumns(18);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		GridBagConstraints gbc_lblCnpj = new GridBagConstraints();
		gbc_lblCnpj.anchor = GridBagConstraints.EAST;
		gbc_lblCnpj.insets = new Insets(0, 0, 5, 5);
		gbc_lblCnpj.gridx = 2;
		gbc_lblCnpj.gridy = 1;
		panel_DadosGerais.add(lblCnpj, gbc_lblCnpj);
		
		txFCNPJ = new JTextField();
		GridBagConstraints gbc_txFCNPJ = new GridBagConstraints();
		gbc_txFCNPJ.insets = new Insets(0, 0, 5, 5);
		gbc_txFCNPJ.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFCNPJ.gridx = 3;
		gbc_txFCNPJ.gridy = 1;
		panel_DadosGerais.add(txFCNPJ, gbc_txFCNPJ);
		txFCNPJ.setColumns(6);
		
		JLabel lblInscrioEstadual = new JLabel("Inscrição Estadual:");
		GridBagConstraints gbc_lblInscrioEstadual = new GridBagConstraints();
		gbc_lblInscrioEstadual.insets = new Insets(0, 0, 5, 5);
		gbc_lblInscrioEstadual.gridx = 4;
		gbc_lblInscrioEstadual.gridy = 1;
		panel_DadosGerais.add(lblInscrioEstadual, gbc_lblInscrioEstadual);
		
		txFInscricaoEstadual = new JTextField();
		GridBagConstraints gbc_txFInscricaoEstadual = new GridBagConstraints();
		gbc_txFInscricaoEstadual.insets = new Insets(0, 0, 5, 0);
		gbc_txFInscricaoEstadual.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFInscricaoEstadual.gridx = 5;
		gbc_txFInscricaoEstadual.gridy = 1;
		panel_DadosGerais.add(txFInscricaoEstadual, gbc_txFInscricaoEstadual);
		txFInscricaoEstadual.setColumns(6);
		
		JLabel lblEmail = new JLabel("E-mail");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 0, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 2;
		panel_DadosGerais.add(lblEmail, gbc_lblEmail);
		
		txFEmail = new JTextField();
		GridBagConstraints gbc_txFEmail = new GridBagConstraints();
		gbc_txFEmail.insets = new Insets(0, 0, 0, 5);
		gbc_txFEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFEmail.gridx = 1;
		gbc_txFEmail.gridy = 2;
		panel_DadosGerais.add(txFEmail, gbc_txFEmail);
		txFEmail.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.EAST;
		gbc_lblTelefone.insets = new Insets(0, 0, 0, 5);
		gbc_lblTelefone.gridx = 2;
		gbc_lblTelefone.gridy = 2;
		panel_DadosGerais.add(lblTelefone, gbc_lblTelefone);
		
		txFTelefone = new JTextField();
		GridBagConstraints gbc_txFTelefone = new GridBagConstraints();
		gbc_txFTelefone.insets = new Insets(0, 0, 0, 5);
		gbc_txFTelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFTelefone.gridx = 3;
		gbc_txFTelefone.gridy = 2;
		panel_DadosGerais.add(txFTelefone, gbc_txFTelefone);
		txFTelefone.setColumns(10);
		
		
		
		
		
		
		
		//DadosGerais
		//=========================================================================================//
		//Endereço
		
		
		
		
		
		
		
		
		JPanel panel_Endereco = new JPanel();
		panel_Endereco.setBorder(BorderFactory.createBevelBorder(0, new Color(230,230,240), new Color(110,110,135)));
		GridBagConstraints gbc_panel_Endereco = new GridBagConstraints();
		gbc_panel_Endereco.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Endereco.fill = GridBagConstraints.BOTH;
		gbc_panel_Endereco.gridx = 0;
		gbc_panel_Endereco.gridy = 1;
		GridBagLayout gbl_panel_Endereco = new GridBagLayout();
		gbl_panel_Endereco.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_Endereco.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_Endereco.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_Endereco.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_Endereco.setLayout(gbl_panel_Endereco);
		panel.add(panel_Endereco, gbc_panel_Endereco);
			
		
		JPanel panel_Titulo = new JPanel();
		panel_Titulo.setBackground(new Color(110,110,135));
		GridBagConstraints gbc_panel_Titulo = new GridBagConstraints();
		gbc_panel_Titulo.gridwidth = 8;
		gbc_panel_Titulo.insets = new Insets(0, 0, 5, 0);
		gbc_panel_Titulo.fill = GridBagConstraints.BOTH;
		gbc_panel_Titulo.gridx = 0;
		gbc_panel_Titulo.gridy = 0;
		panel_Endereco.add(panel_Titulo, gbc_panel_Titulo);
		
		JLabel lblEndereo = new JLabel("Endereço");
		lblEndereo.setForeground(new Color(255,255,255));
		panel_Titulo.add(lblEndereo);
		
		JLabel lblCep = new JLabel("CEP:");
		GridBagConstraints gbc_lblCep = new GridBagConstraints();
		gbc_lblCep.anchor = GridBagConstraints.EAST;
		gbc_lblCep.insets = new Insets(0, 0, 5, 5);
		gbc_lblCep.gridx = 0;
		gbc_lblCep.gridy = 1;
		panel_Endereco.add(lblCep, gbc_lblCep);
		
		txFCEP = new JTextField();
		GridBagConstraints gbc_txFCEP = new GridBagConstraints();
		gbc_txFCEP.insets = new Insets(0, 0, 5, 5);
		gbc_txFCEP.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFCEP.gridx = 1;
		gbc_txFCEP.gridy = 1;
		panel_Endereco.add(txFCEP, gbc_txFCEP);
		txFCEP.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.anchor = GridBagConstraints.EAST;
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.gridx = 2;
		gbc_lblCidade.gridy = 1;
		panel_Endereco.add(lblCidade, gbc_lblCidade);
		
		txFCidade = new JTextField();
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
		
		txFEstado = new JTextField();
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
		
		txFBairro = new JTextField();
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
		
		txFLogradouro = new JTextField();
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
		
		txFNumero = new JTextField();
		GridBagConstraints gbc_txFNumero = new GridBagConstraints();
		gbc_txFNumero.insets = new Insets(0, 0, 0, 5);
		gbc_txFNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFNumero.gridx = 5;
		gbc_txFNumero.gridy = 2;
		panel_Endereco.add(txFNumero, gbc_txFNumero);
		txFNumero.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		GridBagConstraints gbc_lblComplemento = new GridBagConstraints();
		gbc_lblComplemento.anchor = GridBagConstraints.EAST;
		gbc_lblComplemento.insets = new Insets(0, 0, 0, 5);
		gbc_lblComplemento.gridx = 6;
		gbc_lblComplemento.gridy = 2;
		panel_Endereco.add(lblComplemento, gbc_lblComplemento);
		
		txFComplemento = new JTextField();
		GridBagConstraints gbc_txFComplemento = new GridBagConstraints();
		gbc_txFComplemento.insets = new Insets(0, 0, 0, 5);
		gbc_txFComplemento.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFComplemento.gridx = 7;
		gbc_txFComplemento.gridy = 2;
		panel_Endereco.add(txFComplemento, gbc_txFComplemento);
		txFComplemento.setColumns(10);

		
		
		
		
		
		
		
		
		
		
		
		//Endereço
		//==================================================================================//
		//Contato
		
		
		
		
		
		
		JPanel panel_Contato = new JPanel();
		panel_Contato.setBorder(BorderFactory.createBevelBorder(0, new Color(230,230,240), new Color(110,110,135)));
		GridBagConstraints gbc_panel_Contatos = new GridBagConstraints();
		gbc_panel_Contatos.insets = new Insets(0, 0, 5, 5);
		gbc_panel_Contatos.fill = GridBagConstraints.BOTH;
		gbc_panel_Contatos.gridx = 0;
		gbc_panel_Contatos.gridy = 2;
		GridBagLayout gbl_panel_Contatos = new GridBagLayout();
		gbl_panel_Contatos.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_Contatos.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_Contatos.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_Contatos.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 0.0};
		panel_Contato.setLayout(gbl_panel_Endereco);
		panel.add(panel_Contato, gbc_panel_Contatos);
		
		JPanel panel_TituloContato = new JPanel();
		panel_TituloContato.setBackground(new Color(110,110,135));
		GridBagConstraints gbc_panel_TituloContato = new GridBagConstraints();
		gbc_panel_TituloContato.gridwidth = 8;
		gbc_panel_TituloContato.insets = new Insets(0, 0, 5, 5);
		gbc_panel_TituloContato.fill = GridBagConstraints.BOTH;
		gbc_panel_TituloContato.gridx = 0;
		gbc_panel_TituloContato.gridy = 0;
		panel_Contato.add(panel_TituloContato, gbc_panel_TituloContato);
		
		JLabel lblContatoenviarFaturaenviarConfirmao = new JLabel("Contatos/Enviar Faturas/Enviar Confirmações de Entregas");
		lblContatoenviarFaturaenviarConfirmao.setForeground(new Color(255,255,255));
		panel_TituloContato.add(lblContatoenviarFaturaenviarConfirmao);
		
		JLabel lblNome = new JLabel("Nome:");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		panel_Contato.add(lblNome, gbc_lblNome);
		
		txFNome = new JTextField();
		GridBagConstraints gbc_txFNome = new GridBagConstraints();
		gbc_txFNome.insets = new Insets(0, 0, 5, 5);
		gbc_txFNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFNome.gridx = 1;
		gbc_txFNome.gridy = 1;
		panel_Contato.add(txFNome, gbc_txFNome);
		txFNome.setColumns(10);
		
		JLabel lblEmailEmpresa = new JLabel("E-mail:");
		GridBagConstraints gbc_lblEmailEmpresa = new GridBagConstraints();
		gbc_lblEmailEmpresa.anchor = GridBagConstraints.EAST;
		gbc_lblEmailEmpresa.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmailEmpresa.gridx = 3;
		gbc_lblEmailEmpresa.gridy = 1;
		panel_Contato.add(lblEmailEmpresa, gbc_lblEmailEmpresa);
		
		txFEmailEmpresa = new JTextField();
		GridBagConstraints gbc_txFEmailEmpresa = new GridBagConstraints();
		gbc_txFEmailEmpresa.insets = new Insets(0, 0, 5, 5);
		gbc_txFEmailEmpresa.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFEmailEmpresa.gridx = 4;
		gbc_txFEmailEmpresa.gridy = 1;
		panel_Contato.add(txFEmailEmpresa, gbc_txFEmailEmpresa);
		txFEmailEmpresa.setColumns(10);
		
		JLabel lblTelefoneEmpresa = new JLabel("Telefone:");
		GridBagConstraints gbc_lblTelefoneEmpresa = new GridBagConstraints();
		gbc_lblTelefoneEmpresa.anchor = GridBagConstraints.EAST;
		gbc_lblTelefoneEmpresa.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefoneEmpresa.gridx = 5;
		gbc_lblTelefoneEmpresa.gridy = 1;
		panel_Contato.add(lblTelefoneEmpresa, gbc_lblTelefoneEmpresa);
		
		txFTelefoneEmpresa = new JTextField();
		GridBagConstraints gbc_txFTelefoneEmpresa = new GridBagConstraints();
		gbc_txFTelefoneEmpresa.gridwidth = 2;
		gbc_txFTelefoneEmpresa.insets = new Insets(0, 0, 5, 5);
		gbc_txFTelefoneEmpresa.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFTelefoneEmpresa.gridx = 6;
		gbc_txFTelefoneEmpresa.gridy = 1;
		panel_Contato.add(txFTelefoneEmpresa, gbc_txFTelefoneEmpresa);
		//txFTelefone.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descrição:");
		GridBagConstraints gbc_lblDescrio = new GridBagConstraints();
		gbc_lblDescrio.anchor = GridBagConstraints.EAST;
		gbc_lblDescrio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescrio.gridx = 0;
		gbc_lblDescrio.gridy = 2;
		panel_Contato.add(lblDescrio, gbc_lblDescrio);
		
		txFDescricao = new JTextField();
		GridBagConstraints gbc_txFDescricao = new GridBagConstraints();
		gbc_txFDescricao.gridwidth = 7;
		gbc_txFDescricao.insets = new Insets(0, 0, 5, 5);
		gbc_txFDescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txFDescricao.gridx = 1;
		gbc_txFDescricao.gridy = 2;
		panel_Contato.add(txFDescricao, gbc_txFDescricao);
		//txFDescricao.setColumns(10);
		
		JCheckBox chckbxEnviarFatura = new JCheckBox("Enviar Faturas");
		GridBagConstraints gbc_chckbxEnviarFatura = new GridBagConstraints();
		gbc_chckbxEnviarFatura.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxEnviarFatura.gridx = 1;
		gbc_chckbxEnviarFatura.gridy = 3;
		panel_Contato.add(chckbxEnviarFatura, gbc_chckbxEnviarFatura);
		
		JCheckBox chckbxEnviarConfirmaoDe = new JCheckBox("Enviar Confirmações de Entregas");
		GridBagConstraints gbc_chckbxEnviarConfirmaoDe = new GridBagConstraints();
		gbc_chckbxEnviarConfirmaoDe.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxEnviarConfirmaoDe.gridx = 4;
		gbc_chckbxEnviarConfirmaoDe.gridy = 3;
		panel_Contato.add(chckbxEnviarConfirmaoDe, gbc_chckbxEnviarConfirmaoDe);
		
		
		btnAdicionar = new JButton("Adicionar");
		GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
		gbc_btnAdicionar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdicionar.gridx = 6;
		gbc_btnAdicionar.gridy = 3;
		panel_Contato.add(btnAdicionar, gbc_btnAdicionar);
		
		JTextPane txPContatosAdicionados = new JTextPane();
		JScrollPane spContatosAdicionados = new JScrollPane(txPContatosAdicionados);
		spContatosAdicionados.setPreferredSize(new Dimension(800, 80));
		GridBagConstraints gbc_txPContatosAdicionados = new GridBagConstraints();
		gbc_txPContatosAdicionados.gridwidth = 8;
		gbc_txPContatosAdicionados.insets = new Insets(0, 0, 5, 5);
		gbc_txPContatosAdicionados.fill = GridBagConstraints.BOTH;
		gbc_txPContatosAdicionados.gridx = 0;
		gbc_txPContatosAdicionados.gridy = 4;
		panel_Contato.add(spContatosAdicionados, gbc_txPContatosAdicionados);
		
		JLabel lblLegenda = new JLabel("Legenda:");
		GridBagConstraints gbc_lblLegenda = new GridBagConstraints();
		gbc_lblLegenda.insets = new Insets(0, 0, 0, 5);
		gbc_lblLegenda.gridx = 0;
		gbc_lblLegenda.gridy = 5;
		panel_Contato.add(lblLegenda, gbc_lblLegenda);
		
		JLabel lblEnviarFatura = new JLabel("Enviar Faturas");
		lblEnviarFatura.setOpaque(true);
		lblEnviarFatura.setBackground(Color.YELLOW);
		GridBagConstraints gbc_lblEnviarFatura = new GridBagConstraints();
		gbc_lblEnviarFatura.insets = new Insets(0, 0, 0, 5);
		gbc_lblEnviarFatura.gridx = 1;
		gbc_lblEnviarFatura.gridy = 5;
		panel_Contato.add(lblEnviarFatura, gbc_lblEnviarFatura);
		
		JLabel lblEnviarConfirmaesDe = new JLabel("Enviar Confirmações de Entregas");
		lblEnviarConfirmaesDe.setBackground(Color.GREEN);
		lblEnviarConfirmaesDe.setOpaque(true);
		GridBagConstraints gbc_lblEnviarConfirmaesDe = new GridBagConstraints();
		gbc_lblEnviarConfirmaesDe.insets = new Insets(0, 0, 0, 5);
		gbc_lblEnviarConfirmaesDe.gridx = 4;
		gbc_lblEnviarConfirmaesDe.gridy = 5;
		panel_Contato.add(lblEnviarConfirmaesDe, gbc_lblEnviarConfirmaesDe);
		
		JLabel lblAmbos = new JLabel("Ambos");
		lblAmbos.setBackground(Color.PINK);
		lblAmbos.setOpaque(true);
		GridBagConstraints gbc_lblAmbos = new GridBagConstraints();
		gbc_lblAmbos.insets = new Insets(0, 0, 0, 5);
		gbc_lblAmbos.gridx = 6;
		gbc_lblAmbos.gridy = 5;
		panel_Contato.add(lblAmbos, gbc_lblAmbos);

		
		
		
		
		
		
		
		
		
		
		
		
		
		//contato
		//==============================================================================================================//
		//frete
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		JPanel panel_TabelaFrete = new JPanel();
		panel_TabelaFrete.setBackground(Color.WHITE);
		panel_TabelaFrete.setBorder(BorderFactory.createBevelBorder(0, new Color(230,230,240), new Color(110,110,135)));
		GridBagConstraints gbc_panel_TabelaFrete = new GridBagConstraints();
		gbc_panel_TabelaFrete.insets = new Insets(0, 0, 5, 5);
		gbc_panel_TabelaFrete.fill = GridBagConstraints.BOTH;
		gbc_panel_TabelaFrete.gridx = 0;
		gbc_panel_TabelaFrete.gridy = 3;
		GridBagLayout gbl_panel_CalculoPeso = new GridBagLayout();
		gbl_panel_CalculoPeso.columnWidths = new int[] { 0, 0 };
		gbl_panel_CalculoPeso.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_CalculoPeso.columnWeights = new double[] { 1.0, 1.0 };
		gbl_panel_CalculoPeso.rowWeights = new double[] { 1.0, 1.0, 0.0 };
		panel_TabelaFrete.setLayout(gbl_panel_CalculoPeso);
		panel.add(panel_TabelaFrete, gbc_panel_TabelaFrete);
		
		

		JPanel panel_TituloFrete = new JPanel();
		panel_TituloFrete.setBackground(new Color(110,110,135));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		panel_TabelaFrete.add(panel_TituloFrete, gbc_panel_1);

		JLabel lblTabelaDeFrete = new JLabel("Tabela de Frete");
		lblTabelaDeFrete.setForeground(new Color(255,255,255));
		panel_TituloFrete.add(lblTabelaDeFrete);

		JCheckBox chckbxTabelaDeFrete = new JCheckBox("Tabela de Frete Padrão", true);
		GridBagConstraints gbc_chckbxTabelaDeFrete = new GridBagConstraints();
		gbc_chckbxTabelaDeFrete.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxTabelaDeFrete.gridx = 0;
		gbc_chckbxTabelaDeFrete.gridy = 2;
		panel_TabelaFrete.add(chckbxTabelaDeFrete, gbc_chckbxTabelaDeFrete);

		final JButton btnCostumizarTabelaDe = new JButton("Costumizar Tabela de Frete");
		btnCostumizarTabelaDe.setEnabled(false);
		GridBagConstraints gbc_btnCostumizarTabelaDe = new GridBagConstraints();
		gbc_btnCostumizarTabelaDe.gridx = 1;
		gbc_btnCostumizarTabelaDe.gridy = 2;
		panel_TabelaFrete.add(btnCostumizarTabelaDe, gbc_btnCostumizarTabelaDe);

		chckbxTabelaDeFrete.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					btnCostumizarTabelaDe.setEnabled(false);
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					btnCostumizarTabelaDe.setEnabled(true);
				}
				//validate();
				//repaint();
			}
		});

		
		
	
		return panel;
	}
}
