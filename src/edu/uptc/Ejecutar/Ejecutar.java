package edu.uptc.Ejecutar;

import edu.uptc.Control.Control;
import edu.uptc.Vista.VentanaPrincipal;

public class Ejecutar {
	public static void main(String[] args) {
		VentanaPrincipal ventanaPrincipal=new VentanaPrincipal();
		Control control=new Control(ventanaPrincipal);
		ventanaPrincipal.iniciarPrograma(control);
	}
}
