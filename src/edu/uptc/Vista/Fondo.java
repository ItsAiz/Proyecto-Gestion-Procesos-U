package edu.uptc.Vista;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fondo extends JPanel {
	private Image fondo;
	public void paint(Graphics g) {
		fondo=new ImageIcon("imagenes/fondo.jpg").getImage();
		g.drawImage(fondo, 0, 0,getWidth(),getHeight(),this);
		setOpaque(false);
		super.paint(g);
	}
}
