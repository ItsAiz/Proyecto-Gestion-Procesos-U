package edu.uptc.Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import edu.uptc.Control.Control;

public class PanelDocenteOpciones extends JPanel{
	private JButton btnListaMateriasDocente;
	private JButton btnAsignarActividades;
	private JButton btnCalificarActividades;
	public PanelDocenteOpciones() {
		TitledBorder title= new TitledBorder("Materias");
		title.setTitleFont(new Font("Arial",Font.CENTER_BASELINE , 35));
		title.setTitleJustification(TitledBorder.CENTER);
		setLayout(new GridLayout());
		setOpaque(false);
		setBorder(title);
		setBorder(BorderFactory.createLineBorder(Color.black));
		inicializar();
		agregar();
	}
	private void inicializar() {
		btnListaMateriasDocente=new JButton("Lista Materias");
		btnAsignarActividades=new JButton("Asignar Actividades");
		btnCalificarActividades=new JButton("Calificar Actividades");

	}
	private void agregar() {
		add(btnListaMateriasDocente);
		add(btnAsignarActividades);
		add(btnCalificarActividades);
	}
	public void asignarListener(Control control) {
		btnListaMateriasDocente.setActionCommand(Acciones.LISTA_MATERIAS_DOCENTE);
		btnListaMateriasDocente.addActionListener(control);
		
		btnAsignarActividades.setActionCommand(Acciones.ASIGNAR_ACTIVIDADES);
		btnAsignarActividades.addActionListener(control);
		
		btnCalificarActividades.setActionCommand(Acciones.CALIFICAR_ACTIVIDADES);
		btnCalificarActividades.addActionListener(control);
		
	}
}
