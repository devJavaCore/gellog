package br.com.gellog.view.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class GenerateIcon {
	private Icon icon;
	private BufferedImage img;
	public Icon generateIcon(String path) {
		try {
			img = ImageIO.read(new File(path));			
		} catch (IOException e) {
			e.printStackTrace();
		}		
		icon = new ImageIcon(img);
		return icon;
	}
}
