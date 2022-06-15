package edu.uptc.Vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.uptc.Control.Control;

public class PanelEstudianteResponderActividad extends JPanel{
	private JTextArea Areapregunta;
	private JLabel lblRespuesta;
	private JTextField fieldRespuesta;
	private JButton btnSubirRespuesta;
	private JButton btnvolver;
	public PanelEstudianteResponderActividad() {
		setOpaque(false);
		setLayout(null);
		setOpaque(false);
		inicializar();
		caracteristicas();
		agregar();
	}

	private void inicializar() {
		Areapregunta=new JTextArea();
		lblRespuesta=new JLabel("Digite su respuesta");
		fieldRespuesta=new JTextField();
		btnSubirRespuesta=new JButton("Subir respuesta");
		btnvolver=new JButton("Volver");
	}

	private void caracteristicas() {
		Areapregunta.setBounds(40, 20, 680, 250);
		lblRespuesta.setBounds(40, 290,100 , 27);
		fieldRespuesta.setBounds(160,290 ,240, 27);
		btnSubirRespuesta.setBounds(550, 450, 170,20);
		btnvolver.setBounds(10, 450, 100, 20);
		
	}

	private void agregar() {
		add(Areapregunta);
		
		add(lblRespuesta);
		add(fieldRespuesta);
		
		add(btnSubirRespuesta);
		add(btnvolver);
	}
	public void asignarListener(Control control) {
		btnSubirRespuesta.setActionCommand(Acciones.SUBIR_RESPUESTA);
		btnSubirRespuesta.addActionListener(control);
		
		btnvolver.setActionCommand(Acciones.VOLVER_LISTA_ACTIVIDADES);
		btnvolver.addActionListener(control);
	}
	public JTextArea getAreapregunta() {
		return Areapregunta;
	}
	public void setAreapregunta(JTextArea areapregunta) {
		Areapregunta = areapregunta;
	}
	public JTextField getFieldRespuesta() {
		return fieldRespuesta;
	}
	public JButton getBtnSubirRespuesta() {
		return btnSubirRespuesta;
	}
}
