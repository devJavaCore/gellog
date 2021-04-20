package br.com.gellog.view.util;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
 
/**
 *
 *@authorGeorgios Migdos <cyberpython@gmail.com>
 */
public class JSearchTextField extends JIconTextField implements FocusListener {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String textWhenNotFocused;
	private int stringWidth, stringAccent, xCoordinate, yCoordinate;
	
    public JSearchTextField() {
        super();
        this.addFocusListener(this);
    }
 
    public String getTextWhenNotFocused() {
        return this.textWhenNotFocused;
    }
 
    public void setTextWhenNotFocused(String newText) {
        this.textWhenNotFocused = newText;
    }
 
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
 
        FontMetrics fm = g.getFontMetrics();
        if (!this.hasFocus() && this.getText().equals("")) {
        	stringWidth = fm.stringWidth(textWhenNotFocused);
            stringAccent = fm.getAscent();
            xCoordinate = getWidth() / 2 - stringWidth / 2;
            yCoordinate = getHeight() / 2 + stringAccent / 2;
            Font prev = g.getFont();
            Font italic = prev.deriveFont(Font.ITALIC);         
            g.setFont(italic);
            Graphics2D g2d = (Graphics2D) g;
            RenderingHints hints = g2d.getRenderingHints();
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.drawString(textWhenNotFocused, xCoordinate, yCoordinate);
            g2d.setRenderingHints(hints);
            g.setFont(prev);
        }
    }
 
    //FocusListener implementation:
    public void focusGained(FocusEvent e) {
        this.repaint();
    }
 
    public void focusLost(FocusEvent e) {
        this.repaint();
    }
}