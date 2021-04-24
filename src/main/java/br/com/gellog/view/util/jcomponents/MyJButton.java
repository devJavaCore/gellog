package br.com.gellog.view.util.jcomponents;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class MyJButton extends JButton{



        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Color hoverBackgroundColor;
        private Color pressedBackgroundColor;
        
        
        public MyJButton() {
			super();
			// TODO Auto-generated constructor stub
		}
        
        @Override
        public void setBounds(int x, int y, int width, int height) {
        	// TODO Auto-generated method stub
        	super.setBounds(x, y, width, height);
        }
        @Override
        public void setBackground(Color bg) {
        	// TODO Auto-generated method stub
        	super.setBackground(bg);
        }
        @Override
        public void setForeground(Color fg) {
        	// TODO Auto-generated method stub
        	super.setForeground(fg);
        }

		public MyJButton(String text) {
            super(text);
            super.setContentAreaFilled(false);
        }
		

        public MyJButton(Action a) {
			super(a);
			// TODO Auto-generated constructor stub
		}

		public MyJButton(Icon icon) {
			super(icon);
			// TODO Auto-generated constructor stub
		}

		public MyJButton(String text, Icon icon) {
			super(text, icon);
			// TODO Auto-generated constructor stub
		}

		@Override
        protected void paintComponent(Graphics g) {
            if (getModel().isPressed()) {
                g.setColor(pressedBackgroundColor);
            } else if (getModel().isRollover()) {
                g.setColor(hoverBackgroundColor);
            } else {
                g.setColor(getBackground());
            }
            g.fillRect(0, 0, getWidth(), getHeight());
            super.paintComponent(g);
        }

        @Override
        public void setContentAreaFilled(boolean b) {
        }

        public Color getHoverBackgroundColor() {
            return hoverBackgroundColor;
        }

        public void setHoverBackgroundColor(Color hoverBackgroundColor) {
            this.hoverBackgroundColor = hoverBackgroundColor;
        }

        public Color getPressedBackgroundColor() {
            return pressedBackgroundColor;
        }

        public void setPressedBackgroundColor(Color pressedBackgroundColor) {
            this.pressedBackgroundColor = pressedBackgroundColor;
        }
    }
