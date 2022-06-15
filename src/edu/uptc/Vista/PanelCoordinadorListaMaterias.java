package edu.uptc.Vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import edu.uptc.Control.Control;

public class PanelCoordinadorListaMaterias extends JPanel {
	private DefaultTableModel defaultTableModel;
	private JTable tablaListaMaterias;
	private JScrollPane scroll;
	private JButton btnAtras;
	private JButton btnModificar;
	public PanelCoordinadorListaMaterias() {
		TitledBorder title= new TitledBorder("Lista Materias");
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
		String[] titulos= {"Código","Nombre","Semestre","Creditos","Cédula docente","Prorama"};
		defaultTableModel=new DefaultTableModel();
		defaultTableModel.setColumnIdentifiers(titulos);
		tablaListaMaterias=new JTable(defaultTableModel);
		scroll=new JScrollPane(tablaListaMaterias);
		btnAtras=new JButton("Volver");
		btnModificar=new JButton("Modificar");
	}

	private void caracteristicas() {
		scroll.setBounds(10, 20, 745, 370);
		btnAtras.setBounds(10, 450, 100, 20);
		btnModificar.setBounds(650, 450, 100,20 );
	}
	private void agregar() {
		add(scroll);
		add(btnAtras);
		add(btnModificar);
		
	}
	public DefaultTableModel getDefaultTableModel() {
		return defaultTableModel;
	}
	public void asignarLister(Control control) {
		btnAtras.setActionCommand(Acciones.VOLVER);
		btnAtras.addActionListener(control);
		
		btnModificar.setActionCommand(Acciones.MODIFICARM);
		btnModificar.addActionListener(control);
		
	}
	public JTable getTablaListaMaterias() {
		return tablaListaMaterias;
	}
	public void setTablaListaMaterias(JTable tablaListaMaterias) {
		this.tablaListaMaterias = tablaListaMaterias;
	}
	public JScrollPane getScroll() {
		return scroll;
	}
	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}
	public JButton getBtnAtras() {
		return btnAtras;
	}
	public void setBtnAtras(JButton btnAtras) {
		this.btnAtras = btnAtras;
	}
	public JButton getBtnModificar() {
		return btnModificar;
	}
	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}
	public void setDefaultTableModel(DefaultTableModel defaultTableModel) {
		this.defaultTableModel = defaultTableModel;
	}
	
}
