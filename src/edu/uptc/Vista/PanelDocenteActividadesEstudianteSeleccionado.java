package edu.uptc.Vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import edu.uptc.Control.Control;

public class PanelDocenteActividadesEstudianteSeleccionado extends JPanel{
	private DefaultTableModel defaultTableModel;
	private JTable tablaListaActividadesEstudianteSeleccionado;
	private JScrollPane scroll;
	private JButton btnCalificar;
	private JButton btnVolverCalificarActividades;
	public PanelDocenteActividadesEstudianteSeleccionado() {
		TitledBorder title= new TitledBorder("Lista Actividades");
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
		String[] titulos= {"Codigo Actividad","Nombre","Plazo máximo","Codigo Materia"};
		defaultTableModel=new DefaultTableModel();
		defaultTableModel.setColumnIdentifiers(titulos);
		tablaListaActividadesEstudianteSeleccionado=new JTable(defaultTableModel);
		scroll=new JScrollPane(tablaListaActividadesEstudianteSeleccionado);
		btnCalificar=new JButton("Calificar");
		btnVolverCalificarActividades=new JButton("Volver");
	}
	private void caracteristicas() {
		scroll.setBounds(10, 60, 745, 370);
		btnCalificar.setBounds(650, 450, 100,20);
		btnVolverCalificarActividades.setBounds(10, 450, 100, 20);
	}
	private void agregar() {
		add(scroll);
		add(btnCalificar);
		add(btnVolverCalificarActividades);
	}
	public DefaultTableModel getDefaultTableModel() {
		return defaultTableModel;
	}
	public void asignarLister(Control control) {
		btnCalificar.setActionCommand(Acciones.CALIFICAR_ACTIVIDAD_SELECCIONADA);
		btnCalificar.addActionListener(control);
		
		btnVolverCalificarActividades.setActionCommand(Acciones.VOLVER_CALIFICAR_ACTIVIDADES);
		btnVolverCalificarActividades.addActionListener(control);
	}
	public JTable getTablaListaActividadesEstudianteSeleccionado() {
		return tablaListaActividadesEstudianteSeleccionado;
	}
	public JButton getBtnCalificar() {
		return btnCalificar;
	}
	public JButton getBtnVolverCalificarActividades() {
		return btnVolverCalificarActividades;
	}
}

