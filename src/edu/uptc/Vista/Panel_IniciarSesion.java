package edu.uptc.Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import edu.uptc.Control.Control;

@SuppressWarnings("serial")
public class Panel_IniciarSesion extends JPanel{
	private JLabel txtlUsuario;
	private JTextField fieldtUsuario;
	private JLabel txtContraseña;
	private JPasswordField fieldContraseña;
	private JButton btnIngresar;
	public Panel_IniciarSesion() {
		TitledBorder title= new TitledBorder("Iniciar Sesión");
		title.setTitleFont(new Font("Arial",Font.CENTER_BASELINE , 35));
		title.setTitleJustification(TitledBorder.CENTER);
		setBorder(title);
		setLayout(null);
		setOpaque(false);
		inicializar();
		caracteristicas();
		agregar();
	}

	private void inicializar() {
		txtlUsuario=new JLabel("Usuario: ");
		txtContraseña=new JLabel("Contraseña: ");
		fieldtUsuario=new JTextField();
		fieldContraseña=new JPasswordField();
		btnIngresar=new JButton("Ingresar");
	
	}
	private void caracteristicas() {
		txtlUsuario.setFont(new Font("Arial", 10, 15));
		txtlUsuario.setForeground(Color.black);
		txtContraseña.setFont(new Font("Arial", 10, 15));
		txtContraseña.setForeground(Color.black);
		txtlUsuario.setBounds(250,190, 200, 100);
		fieldtUsuario.setBounds(320,230, 200, 19);
		txtContraseña.setBounds(250, 215, 200, 100);
		fieldContraseña.setBounds(330,255,190,19);
		Color color=new Color(117,174,72);
		btnIngresar.setBounds(330, 280, 188, 19);
		btnIngresar.setBackground(color);
	}
	private void agregar() {
		add(txtlUsuario);
		add(fieldtUsuario);
		add(txtContraseña);
		add(fieldContraseña);
		add(btnIngresar);
		
	}
	public void asignarLister(Control control) {
		btnIngresar.setActionCommand(Acciones.INGRESAR);
		btnIngresar.addActionListener(control);
	}
	public JTextField getFieldtUsuario() {
		return fieldtUsuario;
	}
	public String getFieldContraseña() {
		return fieldContraseña.getText();
	}
	
	
}
