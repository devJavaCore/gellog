package br.com.gellog.view.util.jcomponents;

import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.JButton;

import br.com.gellog.view.util.GenerateIcon;
import br.com.gellog.view.util.Events.EnterKeyClick;

public class JIconButton extends JButton {

	private static final long serialVersionUID = 1L;
	private Icon icon, iconSelected;
	private JIconButton jButton;

	public JIconButton() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JIconButton(String text, Icon icon) {
		super(text, icon);
		// TODO Auto-generated constructor stub

		setBorderPainted(false);
		setBorder(null);
		setMargin(new Insets(0, 0, 0, 0));
		setContentAreaFilled(false);

	}

	public JButton botaoAtualizar() {
		icon = new GenerateIcon().generateIcon("src/main/java/br/com/gellog/view/img/atualizar.png");
		jButton = new JIconButton("", icon);
		iconSelected = new GenerateIcon().generateIcon("src/main/java/br/com/gellog/view/img/atualizarSelected.png");
		jButton.setPressedIcon(iconSelected);
		jButton.setDisabledIcon(icon);

		jButton.addKeyListener(new EnterKeyClick(jButton));

		return jButton;
	}

	public JButton botaoCancelar() {
		icon = new GenerateIcon().generateIcon("src/main/java/br/com/gellog/view/img/cancelar.png");
		jButton = new JIconButton("", icon);
		iconSelected = new GenerateIcon().generateIcon("src/main/java/br/com/gellog/view/img/cancelarSelected.png");
		jButton.setPressedIcon(iconSelected);
		jButton.setDisabledIcon(icon);

		jButton.addKeyListener(new EnterKeyClick(jButton));

		return jButton;
	}

	public JButton botaoResetar() {
		icon = new GenerateIcon().generateIcon("src/main/java/br/com/gellog/view/img/resetTable.png");
		jButton = new JIconButton("", icon);
		iconSelected = new GenerateIcon().generateIcon("src/main/java/br/com/gellog/view/img/resetTableSelected.png");
		jButton.setPressedIcon(iconSelected);
		jButton.setDisabledIcon(icon);

		jButton.addKeyListener(new EnterKeyClick(jButton));

		return jButton;
	}

	public JButton botaoSalvar() {
		icon = new GenerateIcon().generateIcon("src/main/java/br/com/gellog/view/img/salvar.png");
		jButton = new JIconButton("", icon);
		iconSelected = new GenerateIcon().generateIcon("src/main/java/br/com/gellog/view/img/salvarSelected.png");
		jButton.setPressedIcon(iconSelected);
		jButton.setDisabledIcon(icon);

		jButton.addKeyListener(new EnterKeyClick(jButton));

		return jButton;
	}

	public JButton botaoVoltar() {
		icon = new GenerateIcon().generateIcon("src/main/java/br/com/gellog/view/img/voltar.png");
		jButton = new JIconButton("", icon);
		iconSelected = new GenerateIcon().generateIcon("src/main/java/br/com/gellog/view/img/voltarSelected.png");
		jButton.setPressedIcon(iconSelected);
		jButton.setDisabledIcon(icon);

		jButton.addKeyListener(new EnterKeyClick(jButton));

		return jButton;
	}
}