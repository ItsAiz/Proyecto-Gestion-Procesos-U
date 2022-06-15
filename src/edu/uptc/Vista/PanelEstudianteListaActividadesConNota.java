package edu.uptc.Vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class PanelEstudianteListaActividadesConNota extends JPanel{
	private DefaultTableModel defaultTableModel;
	private JTable tablaListaActividadesConNota;
	private JScrollPane scroll;
	public PanelEstudianteListaActividadesConNota() {
		setOpaque(false);
		setLayout(null);
		setOpaque(false);
		inicializar();
		caracteristicas();
		agregar();
	}
	private void inicializar() {
		String[] titulos= {"Codigo Actividad","Nombre","Plazo máximo","Codigo Materia","Nota","Porcentaje"};
		defaultTableModel=new DefaultTableModel();
		defaultTableModel.setColumnIdentifiers(titulos);
		tablaListaActividadesConNota=new JTable(defaultTableModel);
		scroll=new JScrollPane(tablaListaActividadesConNota);
	}
	private void caracteristicas() {
		scroll.setBounds(10, 60, 745, 370);
	}
	private void agregar() {
		add(scroll);
		
	}
	public DefaultTableModel getDefaultTableModel() {
		return defaultTableModel;
	}
	public JTable getTablaListaActividadesConNota() {
		return tablaListaActividadesConNota;
	}
}
