package br.com.gellog.view.util;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JTabbedPane;

interface ITabRenderer {

    public Component getTabRendererComponent(JTabbedPane tabbedPane, String text, Icon icon, int tabIndex);

}
