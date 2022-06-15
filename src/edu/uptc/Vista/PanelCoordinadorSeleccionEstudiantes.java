package edu.uptc.Vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import edu.uptc.Control.Control;

public class PanelCoordinadorSeleccionEstudiantes extends JPanel {
	private DefaultTableModel defaultTableModel;
	private JTable tablaListaEstudiantes;
	private JScrollPane scroll;
	private JButton btnSeleccionar;
	private TableColumn tableColumn;
	public PanelCoordinadorSeleccionEstudiantes() {
		TitledBorder title= new TitledBorder("Lista Estudiantes");
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
		String[] titulos= {"Nombre","Programa","Usuario","Contraseña","Correo","Semestre","Codigo","Seleccionar"};
		defaultTableModel=new DefaultTableModel();
		defaultTableModel.setColumnIdentifiers(titulos);
		tablaListaEstudiantes=new JTable(defaultTableModel);
		scroll=new JScrollPane(tablaListaEstudiantes);
		añadirSeleccionEstudiantes(7, tablaListaEstudiantes);
		btnSeleccionar=new JButton("Añadir");
	}
	public void añadirSeleccionEstudiantes(int columna,JTable table) {
		tableColumn=table.getColumnModel().getColumn(columna);
		tableColumn.setCellEditor(table.getDefaultEditor(Boolean.class));
		tableColumn.setCellRenderer(table.getDefaultRenderer(Boolean.class));
	}
	private void caracteristicas() {
		scroll.setBounds(10, 60, 745, 370);
		btnSeleccionar.setBounds(650, 450, 100,20 );
	}
	private void agregar() {
		add(scroll);
		add(btnSeleccionar);
		
	}
	public void asignarLister(Control control) {
		btnSeleccionar.setActionCommand(Acciones.ESTUDIANTES_SELECCIONADOS);
		btnSeleccionar.addActionListener(control);
	}
	public DefaultTableModel getDefaultTableModel() {
		return defaultTableModel;
	}
	public void setDefaultTableModel(DefaultTableModel defaultTableModel) {
		this.defaultTableModel = defaultTableModel;
	}
	public JTable getTablaListaEstudiantes() {
		return tablaListaEstudiantes;
	}
	public void setTablaListaEstudiantes(JTable tablaListaEstudiantes) {
		this.tablaListaEstudiantes = tablaListaEstudiantes;
	}
	public JScrollPane getScroll() {
		return scroll;
	}
	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}
	public JButton getBtnSeleccionar() {
		return btnSeleccionar;
	}
	public void setBtnSeleccionar(JButton btnSeleccionar) {
		this.btnSeleccionar = btnSeleccionar;
	}
	public TableColumn getTableColumn() {
		return tableColumn;
	}
	public void setTableColumn(TableColumn tableColumn) {
		this.tableColumn = tableColumn;
	}
	
}
