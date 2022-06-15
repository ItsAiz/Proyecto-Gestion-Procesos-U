package edu.uptc.Vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import edu.uptc.Control.Control;

public class PanelDocenteCalificarActividadEstudiante extends JPanel {
	private JTextArea Areapregunta;
	private JLabel lblRespuestaEstudiante;
	private JTextField fieldRespuesta;
	private JLabel lblCalificacion;
	private JTextField fieldNota;
	private JButton btnSubirNota;
	private JButton btnvolver;
	public PanelDocenteCalificarActividadEstudiante() {
		TitledBorder title= new TitledBorder("Actividad");
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
		Areapregunta=new JTextArea();
		lblRespuestaEstudiante=new JLabel("Respuesta del estudiante");
		fieldRespuesta=new JTextField();
		lblCalificacion=new JLabel("Digite la nota");
		fieldNota=new JTextField();
		btnSubirNota=new JButton("Subir nota");
		btnvolver=new JButton("Volver");
	}

	private void caracteristicas() {
		Areapregunta.setBounds(40, 40, 680, 250);
		lblRespuestaEstudiante.setBounds(40, 310,150, 27);
		fieldRespuesta.setBounds(190,310 ,290, 27);
		lblCalificacion.setBounds(40, 340, 100, 27);
		fieldNota.setBounds(160, 340, 240, 27);
		btnSubirNota.setBounds(550, 450, 170,20);
		btnvolver.setBounds(10, 450, 100, 20);
	}

	private void agregar() {
		add(Areapregunta);
		add(lblRespuestaEstudiante);
		add(fieldRespuesta);
		add(lblCalificacion);
		add(fieldNota);
		
		add(btnSubirNota);
		add(btnvolver);
	}
	public void asignarListener(Control control) {
		btnSubirNota.setActionCommand(Acciones.SUBIR_NOTA_ACTIVIDAD_SELECCIONADA);
		btnSubirNota.addActionListener(control);
		
		btnvolver.setActionCommand(Acciones.VOLVER_CALIFICAR_ACTIVIDAD_SELECCIONADA);
		btnvolver.addActionListener(control);
	}
	public JTextField getFieldNota() {
		return fieldNota;
	}
	public JTextField getFieldRespuesta() {
		return fieldRespuesta;
	}
	public JTextArea getAreapregunta() {
		return Areapregunta;
	}
	public JButton getBtnSubirNota() {
		return btnSubirNota;
	}
	public JButton getBtnvolver() {
		return btnvolver;
	}
}
