package edu.uptc.Vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import edu.uptc.Control.Control;

@SuppressWarnings("serial")
public class PanelCoordinadorListaDocentes extends JPanel {
	private DefaultTableModel defaultTableModel;
	private JTable tablaListaDocentes;
	private JScrollPane scroll;
	private JButton btnAtras;
	private JButton btnModificar;
	private JButton btnEliminar;
	public PanelCoordinadorListaDocentes() {
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
		btnModificar=new JButton("Modificar");
		btnEliminar=new JButton("Eliminar");
	}

	private void caracteristicas() {
		scroll.setBounds(10, 60, 745, 370);
		btnAtras.setBounds(10, 450, 100, 20);
		btnModificar.setBounds(650, 450, 100,20 );
		btnEliminar.setBounds(420, 450, 100, 20);
	}
	private void agregar() {
		add(scroll);
		add(btnAtras);
		add(btnModificar);
		add(btnEliminar);
		
	}
	public DefaultTableModel getDefaultTableModel() {
		return defaultTableModel;
	}
	public void asignarLister(Control control) {
		btnAtras.setActionCommand(Acciones.VOLVER);
		btnAtras.addActionListener(control);
		
		btnModificar.setActionCommand(Acciones.MODIFICARD);
		btnModificar.addActionListener(control);
		
		btnEliminar.setActionCommand(Acciones.ELIMINARD);
		btnEliminar.addActionListener(control);
	}
	public JTable getTablaListaDocentes() {
		return tablaListaDocentes;
	}
	public JButton getBtnModificar() {
		return btnModificar;
	}
	public JButton getBtnEliminar() {
		return btnEliminar;
	}
}
