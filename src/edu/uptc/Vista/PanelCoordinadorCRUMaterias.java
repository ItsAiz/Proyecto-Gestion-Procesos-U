package edu.uptc.Vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import edu.uptc.Control.Control;

public class PanelCoordinadorCRUMaterias extends JPanel {
	private JButton btnListaMaterias;
	private JButton btnCrearMaterias;
	private JButton btnActualizarMaterias;
	public PanelCoordinadorCRUMaterias() {
		TitledBorder title= new TitledBorder("Materias");
		title.setTitleFont(new Font("Arial",Font.CENTER_BASELINE , 35));
		title.setTitleJustification(TitledBorder.CENTER);
		setLayout(null);
		setOpaque(false);
		setBorder(title);
		setBorder(BorderFactory.createLineBorder(Color.black));
		inicializar();
		caracteristicas();
		agregar();
	}
	private void inicializar() {
		btnListaMaterias=new JButton("Lista Materias");
		btnCrearMaterias=new JButton("Crear Materias");
		btnActualizarMaterias=new JButton("Actualizar Materias");
		
	}
	private void caracteristicas() {
		btnListaMaterias.setBounds(80, 50 ,200, 30);
		btnCrearMaterias.setBounds(280, 150 ,170, 30);
		btnActualizarMaterias.setBounds(450, 50 ,200,30);
		
	}
	private void agregar() {
		add(btnListaMaterias);
		add(btnCrearMaterias);
		add(btnActualizarMaterias);
	}
	public void asignarListener(Control control) {
		btnListaMaterias.setActionCommand(Acciones.LISTA_MATERIAS);
		btnListaMaterias.addActionListener(control);
		
		btnCrearMaterias.setActionCommand(Acciones.CREAR_MATERIAS);
		btnCrearMaterias.addActionListener(control);
		
		btnActualizarMaterias.setActionCommand(Acciones.ACTUALIZAR_MATERIAS);
		btnActualizarMaterias.addActionListener(control);
	}
}
