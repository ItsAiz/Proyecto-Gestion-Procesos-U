package edu.uptc.Vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import edu.uptc.Control.Control;

public class PanelEstudianteListaActividades extends JPanel {
	private DefaultTableModel defaultTableModel;
	private JTable tablaListaActividades;
	private JScrollPane scroll;
	private JButton btnResponder;
	public PanelEstudianteListaActividades() {
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
		tablaListaActividades=new JTable(defaultTableModel);
		scroll=new JScrollPane(tablaListaActividades);
		btnResponder=new JButton("Responder");
	}
	private void caracteristicas() {
		scroll.setBounds(10, 60, 745, 370);
		btnResponder.setBounds(650, 450, 100,20);
	}
	private void agregar() {
		add(scroll);
		add(btnResponder);
		
	}
	public DefaultTableModel getDefaultTableModel() {
		return defaultTableModel;
	}
	public void asignarLister(Control control) {
		btnResponder.setActionCommand(Acciones.SELECCION_ACTIVIDAD_RESPONDER);
		btnResponder.addActionListener(control);
		
	}
	public JTable getTablaListaActividades() {
		return tablaListaActividades;
	}
	public JButton getBtnResponder() {
		return btnResponder;
	}
}
