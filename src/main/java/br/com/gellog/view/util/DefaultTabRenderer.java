	package br.com.gellog.view.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

class DefaultTabRenderer extends AbstractTabRenderer implements PropertyChangeListener {

	private Component prototypeComponent;

	public DefaultTabRenderer() {
		super();
		prototypeComponent = generateRendererComponent(getPrototypeText(), getPrototypeIcon(),
				getHorizontalTextAlignment());
		addPropertyChangeListener(this);
	}

	private Component generateRendererComponent(String text, Icon icon, int horizontalTabTextAlignmen) {
		JPanel rendererComponent = new JPanel(new GridBagLayout());
		rendererComponent.setOpaque(false);

		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(3,6,3,5);
		c.fill = GridBagConstraints.HORIZONTAL;
		rendererComponent.add(new JLabel(icon), c);
		c.gridx = 1;
		c.weightx = 1;
		

		JLabel jLabel = new JLabel(text, horizontalTabTextAlignmen);
		jLabel.setForeground(new Color(255, 255, 255));
		jLabel.setFont(new Font("Serif", Font.PLAIN, 17));
		jLabel.setVerticalAlignment(JLabel.BOTTOM);
		jLabel.setVerticalTextPosition(JLabel.BOTTOM);
		rendererComponent.add(jLabel, c);

		return rendererComponent;
	}

	public Component getTabRendererComponent(JTabbedPane tabbedPane, String text, Icon icon, int tabIndex) {
		Component rendererComponent = generateRendererComponent(text, icon, getHorizontalTextAlignment());
		int prototypeWidth = prototypeComponent.getPreferredSize().width;
		int prototypeHeight = prototypeComponent.getPreferredSize().height;
		rendererComponent.setPreferredSize(new Dimension(prototypeWidth, prototypeHeight));
		return rendererComponent;
	}

	public void propertyChange(PropertyChangeEvent evt) {
		String propertyName = evt.getPropertyName();
		if ("prototypeText".equals(propertyName) || "prototypeIcon".equals(propertyName)) {
			this.prototypeComponent = generateRendererComponent(getPrototypeText(), getPrototypeIcon(),
					getHorizontalTextAlignment());
		}
	}
}
