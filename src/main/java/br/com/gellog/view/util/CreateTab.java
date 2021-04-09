package br.com.gellog.view.util;

import javax.swing.Icon;

public class CreateTab {
	GenerateIcon generateIcon;
	private Icon iconHome, iconCliente, iconMotorista, iconTabela, iconColeta, iconEntrega, iconFaturamento,
	iconRelatorio, iconGellog, iconConfirmacoes;
	
	protected void createTab(JXTabbedPane tabbedPane) {
		generateIcon = new GenerateIcon();
		iconHome = generateIcon.generateIcon("src/main/java/br/com/gellog/view/img/home.png");
		iconCliente = generateIcon.generateIcon("src/main/java/br/com/gellog/view/img/cliente.png");
		iconMotorista = generateIcon.generateIcon("src/main/java/br/com/gellog/view/img/motorista.png");
		iconTabela = generateIcon.generateIcon("src/main/java/br/com/gellog/view/img/tabela.png");
		iconColeta = generateIcon.generateIcon("src/main/java/br/com/gellog/view/img/coleta.png");
		iconEntrega = generateIcon.generateIcon("src/main/java/br/com/gellog/view/img/entrega.png");
		iconConfirmacoes = generateIcon.generateIcon("src/main/java/br/com/gellog/view/img/confirmacoes.png");
		iconFaturamento = generateIcon.generateIcon("src/main/java/br/com/gellog/view/img/faturamento.png");
		iconRelatorio = generateIcon.generateIcon("src/main/java/br/com/gellog/view/img/relatorio.png");
		iconGellog = generateIcon.generateIcon("src/main/java/br/com/gellog/view/img/gellog.png");

		CreateEmptyPanel createEmptyPanel = new CreateEmptyPanel();
		tabbedPane.addTab("   Home", iconHome, createEmptyPanel.createEmptyPanel(), "Tela Principal");
		tabbedPane.addTab("   Clientes", iconCliente, createEmptyPanel.createEmptyPanel(), "Cadastro de Clientes");
		tabbedPane.addTab("   Motoristas", iconMotorista, createEmptyPanel.createEmptyPanel(),
				"Cadastro de Motoristas");
		tabbedPane.addTab("   Tabela", iconTabela, createEmptyPanel.createEmptyPanel(), "Cadastro da Tabela");
		tabbedPane.addTab("   Coletas", iconColeta, createEmptyPanel.createEmptyPanel(), "Cadastro de Coletas");
		tabbedPane.addTab("   Entregas", iconEntrega, createEmptyPanel.createEmptyPanel(), "Cadastro de Entregas");
		tabbedPane.addTab("   Confirmações", iconConfirmacoes, createEmptyPanel.createEmptyPanel(),
				"Enviar Confirações de Faturamento");
		tabbedPane.addTab("   Faturamento", iconFaturamento, createEmptyPanel.createEmptyPanel(),
				"Envio de Faturamento");
		tabbedPane.addTab("   Relatórios", iconRelatorio, createEmptyPanel.createEmptyPanel(), "Gera Relatórios");
		tabbedPane.addTab("   Gellog", iconGellog, createEmptyPanel.createEmptyPanel(), "Institucional");
	
        
        
      		
	}
}