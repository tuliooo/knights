package Gui;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fondo extends JPanel {

	public void paintComponent(Graphics g){
		Dimension tam= getSize();
	    ImageIcon imgfondo = new ImageIcon(getClass().getResource("Background.jpg"));
	    g.drawImage(imgfondo.getImage(), 0, 0, tam.width, tam.height, null);
	    setOpaque(false);
	    super.paintComponent(g);
	
	}
}
