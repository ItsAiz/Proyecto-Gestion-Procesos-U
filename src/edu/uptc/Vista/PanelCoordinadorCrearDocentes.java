package edu.uptc.Vista;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import edu.uptc.Control.Control;
import edu.uptc.Modelo.Area;
import edu.uptc.Modelo.Programa;

@SuppressWarnings("serial")
public class PanelCoordinadorCrearDocentes extends JPanel{
	private JLabel lblNombre;
	private JTextField fieldNombreDocente;
	private JLabel lblPrograma;
	private JComboBox<String> programas;
	private JLabel lblArea;
	private JComboBox<String> areas;
	private JLabel lblUsuario;
	private JTextField fieldUsuarioDocente;
	private JLabel lblCedula;
	private JTextField fieldCedula;
	private JLabel lblContraseña;
	private JPasswordField fieldContraseñaDocente;
	private JButton btnRegistrar;
	private JButton btnAtras;
	private JLabel lblFechaExpedicion;
	private JDateChooser dateChooser;
	private JButton btnModificar;
	public PanelCoordinadorCrearDocentes() {
		setLayout(null);
		setBorder(BorderFactory.createLineBorder(Color.black));
		setOpaque(false);
		inicializar();
		caracteristicas();
		agregar();
	}
	private void inicializar() {
		lblNombre=new JLabel("Nombre");
		fieldNombreDocente=new JTextField("Nombre");
		
		lblPrograma=new JLabel("Programa");
		programas=new JComboBox<String>();
		programas.setModel(new DefaultComboBoxModel(Programa.values()));
		
		lblArea=new JLabel("Area");
		areas=new JComboBox<String>();
		areas.setModel(new DefaultComboBoxModel(Area.values()));
		
		
		lblFechaExpedicion=new JLabel("Fecha tarjeta Profecional");
		dateChooser=new JDateChooser("dd/MM/yyyy","##/##/####",'_');
		dateChooser.setEnabled(true);
		
		lblUsuario=new JLabel("Usuario");
		fieldUsuarioDocente=new JTextField("Usuario");
		
		lblCedula=new JLabel("Cedula");
		fieldCedula=new JTextField("126");
		
		lblContraseña=new JLabel("Contraseña");
		fieldContraseñaDocente=new JPasswordField();
		
		btnAtras=new JButton("Volver");
		btnRegistrar=new JButton("Registrar");
		
		btnModificar=new JButton("Modificar");
		
	}
	private void caracteristicas() {
		lblNombre.setBounds(10, 20, 200, 20);
		lblNombre.setForeground(Color.black);
		fieldNombreDocente.setBounds(100,20,214 , 27);
		
		lblPrograma.setBounds(10, 100, 200, 20);
		lblPrograma.setForeground(Color.black);
		programas.setBounds(100,100,214 , 27);
		
		lblUsuario.setBounds(10, 200, 200, 20);
		lblUsuario.setForeground(Color.black);
		fieldUsuarioDocente.setBounds(100,200,214 , 27);
		
		lblContraseña.setBounds(10,300, 200,20 );
		lblContraseña.setForeground(Color.black);
		fieldContraseñaDocente.setBounds(100,300, 214, 27);
		
		lblFechaExpedicion.setBounds(400, 10, 200, 20);
		lblFechaExpedicion.setForeground(Color.black);
		dateChooser.setBounds(550,10,200, 27);
		
		lblCedula.setBounds(400, 100, 200, 20);
		lblCedula.setForeground(Color.black);
		fieldCedula.setBounds(550,100,200 , 27);
		
		lblArea.setBounds(400, 200, 200,20 );
		lblArea.setForeground(Color.black);
		areas.setBounds(550, 200, 200, 27);
		
		btnAtras.setBounds(10, 450, 100, 20);
		btnRegistrar.setBounds(400, 300,100, 20);
		
		btnModificar.setBounds(650, 300, 100,20 );
		
	}

	private void agregar() {
		add(lblNombre);
		add(fieldNombreDocente);
		
		add(lblPrograma);
		add(programas);
		
		add(lblUsuario);
		add(fieldUsuarioDocente);
		
		add(lblContraseña);
		add(fieldContraseñaDocente);
		
		add(lblFechaExpedicion);
		add(dateChooser);
		
		add(lblCedula);
		add(fieldCedula);
		
		add(lblArea);
		add(areas);
		
		add(btnAtras);
		add(btnRegistrar);
		
		add(btnModificar);
		
	}
	public void asignarLister(Control control) {
		btnAtras.setActionCommand(Acciones.VOLVER);
		btnAtras.addActionListener(control);
		
		btnRegistrar.setActionCommand(Acciones.REGISTRAR_DOCENTE);
		btnRegistrar.addActionListener(control);
		
		btnModificar.setActionCommand(Acciones.MODIFICAR_DOCENTE);
		btnModificar.addActionListener(control);
		
		
		
	}
	public JTextField getFieldNombreDocente() {
		return fieldNombreDocente;
	}
	public JTextField getFieldUsuarioDocente() {
		return fieldUsuarioDocente;
	}
	public JPasswordField getFieldContraseñaDocente() {
		return fieldContraseñaDocente;
	}
	public JTextField getFieldCedula() {
		return fieldCedula;
	}
	public JComboBox<String> getProgramas() {
		return programas;
	}
	public JComboBox<String> getAreas() {
		return areas;
	}
	public JDateChooser getDateChooser() {
		return dateChooser;
	}
	public void setDateChooser(JDateChooser dateChooser) {
		this.dateChooser = dateChooser;
	}
	public JButton getBtnModificar() {
		return btnModificar;
	}
	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}
}
