package edu.uptc.Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import edu.uptc.Control.Control;

public class PanelOpcionesEstudiante extends JPanel{
	private JButton btnListaActividades;
	private JButton btnHistorialActividades;
	private JButton btnPromedioAcomulado;
	public PanelOpcionesEstudiante() {
		setLayout(new GridLayout());
		setOpaque(false);
		inicializar();
		agregar();
	}
	private void inicializar() {
		btnListaActividades=new JButton("Lista Actividades");
		btnHistorialActividades=new JButton("Historial Actividades");
		btnPromedioAcomulado=new JButton("Promedio acomulado");

	}
	private void agregar() {
		add(btnListaActividades);
		add(btnHistorialActividades);
		add(btnPromedioAcomulado);
	}
	public void asignarListener(Control control) {
		btnListaActividades.setActionCommand(Acciones.LISTA_ACTIVIDADES_ESTUDIANTE);
		btnListaActividades.addActionListener(control);
		
		btnHistorialActividades.setActionCommand(Acciones.HISTORIAL_ACTIVIDADES);
		btnHistorialActividades.addActionListener(control);
		
		btnPromedioAcomulado.setActionCommand(Acciones.PROMEDIO_ACUMULADO);
		btnPromedioAcomulado.addActionListener(control);
	}
}
