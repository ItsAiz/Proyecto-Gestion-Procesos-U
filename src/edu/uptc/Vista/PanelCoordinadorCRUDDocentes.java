package edu.uptc.Vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import edu.uptc.Control.Control;

@SuppressWarnings("serial")
public class PanelCoordinadorCRUDDocentes extends JPanel {
	private JButton btnListaDocentes;
	private JButton btnCrearDocentes;
	private JButton btnActualizarDocentes;
	private JButton btnEliminarDocentes;
	public PanelCoordinadorCRUDDocentes() {
		TitledBorder title= new TitledBorder("Docentes");
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
		btnListaDocentes=new JButton("Lista Docentes");
		btnCrearDocentes=new JButton("Crear Docentes");
		btnActualizarDocentes=new JButton("Actualizar Docentes");
		btnEliminarDocentes=new JButton("Eliminar Docentes");
		
	}
	private void caracteristicas() {
		btnListaDocentes.setBounds(80, 50 ,200, 30);
		btnCrearDocentes.setBounds(80, 150 ,200, 30);
		btnActualizarDocentes.setBounds(450, 50 ,200,30);
		btnEliminarDocentes.setBounds(450, 150 ,200, 30);
		
	}
	private void agregar() {
		add(btnListaDocentes);
		add(btnCrearDocentes);
		add(btnActualizarDocentes);
		add(btnEliminarDocentes);
	}
	public void asignarListener(Control control) {
		btnListaDocentes.setActionCommand(Acciones.LISTA_DOCENTES);
		btnListaDocentes.addActionListener(control);
		
		btnCrearDocentes.setActionCommand(Acciones.CREAR_DOCENTES);
		btnCrearDocentes.addActionListener(control);
		
		btnActualizarDocentes.setActionCommand(Acciones.ACTUALIZAR_DOCENTES);
		btnActualizarDocentes.addActionListener(control);
		
		btnEliminarDocentes.setActionCommand(Acciones.ELIMINAR_DOCENTES);
		btnEliminarDocentes.addActionListener(control);
	}
}
