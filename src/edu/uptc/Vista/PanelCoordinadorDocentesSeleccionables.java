package edu.uptc.Vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import edu.uptc.Control.Control;

public class PanelCoordinadorDocentesSeleccionables extends JPanel {
	private DefaultTableModel defaultTableModel;
	private JTable tablaListaDocentes;
	private JScrollPane scroll;
	private JButton btnAtras;
	private JButton btnSeleccionar;
	public PanelCoordinadorDocentesSeleccionables() {
		TitledBorder title= new TitledBorder("Lista Docentes");
		title.setTitleFont(new Font("Arial",Font.CENTER_BASELINE , 35));
		title.setTitleJustification(TitledBorder.CENTER);
		setBorder(title);
		setOpaque(false);
		setLayout(null);
		setOpaque(false);
		inicializar();
		caracteristicas();
		agregar();
	}
	private void inicializar() {
		String[] titulos= {"Nombre","Programa","Usuario","Contraseña","Años de experiencia","cedula","Area"};
		defaultTableModel=new DefaultTableModel();
		defaultTableModel.setColumnIdentifiers(titulos);
		tablaListaDocentes=new JTable(defaultTableModel);
		scroll=new JScrollPane(tablaListaDocentes);
		btnAtras=new JButton("Volver");
		btnSeleccionar=new JButton("Seleccionar");
	}

	private void caracteristicas() {
		scroll.setBounds(10, 60, 745, 370);
		btnAtras.setBounds(10, 450, 100, 20);
		btnSeleccionar.setBounds(650, 450, 100,20 );
	}
	private void agregar() {
		add(scroll);
		add(btnAtras);
		add(btnSeleccionar);
		
	}
	public void asignarLister(Control control) {
		btnAtras.setActionCommand(Acciones.VOLVER_CREAR_DOCENTE);
		btnAtras.addActionListener(control);
		
		btnSeleccionar.setActionCommand(Acciones.SELECCION_DOCENTE);
		btnSeleccionar.addActionListener(control);
	}
	public DefaultTableModel getDefaultTableModel() {
		return defaultTableModel;
	}
	public JTable getTablaListaDocentes() {
		return tablaListaDocentes;
	}
	
	
	
	
}
