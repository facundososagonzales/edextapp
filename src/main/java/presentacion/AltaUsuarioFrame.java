package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import datatypes.DtDocente;
import datatypes.DtEstudiante;
import datatypes.DtUsuario;
import excepciones.InstitutoNoCargadoException;
import excepciones.PasswordRepetidaException;
import excepciones.UsuarioRepetidoException;
import interfaces.IControladorAltaUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;

public class AltaUsuarioFrame extends JInternalFrame {
	
	private IControladorAltaUsuario icau;
	
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private JTextField textFieldNick;
	private JTextField textFieldApellido;
	private JTextField textFieldCorreo;
	private JLabel lblNewNick;
	private JLabel lblNewApellido;
	private JLabel lblNewLabelCorreo;
	private JLabel lblNewLabelRol;
	private JTextField textFieldInstituto;
	private JComboBox<String> comboBox; 
	private JPasswordField textPassWord;
	private JPasswordField textFieldPasswordV;
	private JTextField textField_FechaNac;
	private JLabel lblFechaDeNacimiento;

	public AltaUsuarioFrame(IControladorAltaUsuario icau) {
		this.icau=icau;
		setResizable(true);
	    setIconifiable(true);
	    setMaximizable(true);
	    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    setClosable(true);
        setTitle("Alta de un Usuario");
		setBounds(100, 100, 600, 450);
		getContentPane().setLayout(null);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(99, 89, 129, 22);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNewNombre = new JLabel("Nombre");
		lblNewNombre.setBounds(42, 91, 48, 16);
		getContentPane().add(lblNewNombre);
		
		textFieldNick = new JTextField();
		textFieldNick.setBounds(99, 46, 129, 22);
		getContentPane().add(textFieldNick);
		textFieldNick.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(314, 89, 131, 22);
		getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(314, 46, 196, 22);
		getContentPane().add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		lblNewNick = new JLabel("Nick");
		lblNewNick.setBounds(60, 49, 38, 16);
		getContentPane().add(lblNewNick);
		
		lblNewApellido = new JLabel("Apellido");
		lblNewApellido.setBounds(259, 92, 56, 16);
		getContentPane().add(lblNewApellido);
		
		lblNewLabelCorreo = new JLabel("Correo");
		lblNewLabelCorreo.setBounds(259, 49, 56, 16);
		getContentPane().add(lblNewLabelCorreo);
		
		lblNewLabelRol = new JLabel("Rol");
		lblNewLabelRol.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabelRol.setBounds(68, 187, 22, 16);
		getContentPane().add(lblNewLabelRol);
		
		textFieldInstituto = new JTextField();
		textFieldInstituto.setColumns(10);
		textFieldInstituto.setBounds(316, 185, 129, 22);
		getContentPane().add(textFieldInstituto);
		
		JLabel lblInstituto = new JLabel("Instituto");
		lblInstituto.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblInstituto.setBounds(259, 187, 84, 16);
		getContentPane().add(lblInstituto);
		
		JButton btnNewButtonCancelar = new JButton("Cancelar");

		btnNewButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuarioCancelarActionPerforme(e);
			}
		});
		btnNewButtonCancelar.setBounds(42, 365, 98, 26);
		getContentPane().add(btnNewButtonCancelar);
		
		JButton btnNewButtomAceptar = new JButton("Aceptar");
		btnNewButtomAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuarioActionPerformed(e);
			}
		});
		
		btnNewButtomAceptar.setBounds(454, 365, 98, 26);
		getContentPane().add(btnNewButtomAceptar);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(99, 184, 129, 22);
		comboBox.addItem("Estudiante");
		comboBox.addItem("Docente");
		comboBox.setSelectedItem("Docente");
		getContentPane().add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()==1) {
					textFieldInstituto.setText("");
					textFieldInstituto.setEnabled(true);
				}else {
					textFieldInstituto.setText("");
					textFieldInstituto.setEnabled(false);
				}
			}
		});
		
		this.textPassWord = new JPasswordField();
		textPassWord.setColumns(10);
		textPassWord.setBounds(99, 132, 129, 22);
		//textPassWord.setEchoChar('*');
		getContentPane().add(textPassWord);
		
		JLabel lblNewPassword = new JLabel("Password");
		lblNewPassword.setBounds(42, 135, 56, 16);
		getContentPane().add(lblNewPassword);
		
		this.textFieldPasswordV = new JPasswordField();
		textFieldPasswordV.setColumns(10);
		//textFieldPasswordV.setEchoChar('*');
		textFieldPasswordV.setBounds(316, 132, 129, 22);
		getContentPane().add(textFieldPasswordV);
		
		JLabel lblNewNombre_1_1 = new JLabel("Password");
		lblNewNombre_1_1.setBounds(259, 135, 56, 16);
		getContentPane().add(lblNewNombre_1_1);
		
		textField_FechaNac = new JTextField();
		textField_FechaNac.setColumns(10);
		textField_FechaNac.setBounds(99, 236, 129, 22);
		getContentPane().add(textField_FechaNac);
		textField_FechaNac.setText("dd/mm/yyyy");
		
		lblFechaDeNacimiento = new JLabel("Nacimiento");
		lblFechaDeNacimiento.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblFechaDeNacimiento.setBounds(26, 237, 72, 16);
		getContentPane().add(lblFechaDeNacimiento);
		
	}
	protected void altaUsuarioActionPerformed(ActionEvent e) {

		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldApellido.getText();
		String nick = this.textFieldNick.getText();
		String correo = this.textFieldCorreo.getText();
		String instituto = this.textFieldInstituto.getText();
		String password = new String (this.textPassWord.getPassword());
		String vPassword = new String (this.textFieldPasswordV.getPassword());
		if (checkForumalrio()) {
			try {
				String fechaNac = this.textField_FechaNac.getText();
				String fechaNacDia = fechaNac.substring(0,2); int FNdia = Integer.parseInt(fechaNacDia);
				String fechaNacMes = fechaNac.substring(3,5); int FNmes = Integer.parseInt(fechaNacMes);
				String fechaNacAnio = fechaNac.substring(6);  int FNanio= Integer.parseInt(fechaNacAnio);
		    	Date fechaNacimiento = new GregorianCalendar(FNanio, (FNmes-1), FNdia).getTime();
				DtUsuario usuarioing = null;
				if (comboBox.getSelectedIndex()==1) {
					this.icau.ingresarInstituto(instituto);
					usuarioing = new DtDocente (nick,nombre,apellido,correo,fechaNacimiento);
				}else {
					usuarioing = new DtEstudiante(nick,nombre,apellido,correo,fechaNacimiento);
				}
				this.icau.ingresarPassword(password);
				this.icau.verificarPassword(vPassword);
				this.icau.ingresarUser(usuarioing);
				this.icau.altaUsuario();
				JOptionPane.showMessageDialog(this, "El Usuario se ha registrado con Exito ", "Alta Usuario", JOptionPane.INFORMATION_MESSAGE);
	            limpiarFormulario();
	            setVisible(false);
			}catch(UsuarioRepetidoException ex){
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Alta Usuario", JOptionPane.ERROR_MESSAGE);
    	        textFieldNick.setText("");
    	        textFieldCorreo.setText("");
			}catch(InstitutoNoCargadoException iner) {
                JOptionPane.showMessageDialog(this, iner.getMessage(), "Alta Usuario", JOptionPane.ERROR_MESSAGE);
    	        textFieldInstituto.setText("");
			}catch(PasswordRepetidaException pre) {
                JOptionPane.showMessageDialog(this, pre.getMessage(), "Alta Usuario", JOptionPane.ERROR_MESSAGE);
                textPassWord.setText("");
                textFieldPasswordV.setText("");
			}
		}
	}
	 
	
	private boolean checkForumalrio() {
		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldApellido.getText();
		String nick = this.textFieldNick.getText();
		String correo = this.textFieldCorreo.getText();
		String fechaNac = this.textField_FechaNac.getText();
		String instituto = this.textFieldInstituto.getText();
		String password = new String (this.textPassWord.getPassword());
		String vPassword = new String (this.textFieldPasswordV.getPassword());
		if(nombre.isEmpty() || apellido.isEmpty() || nick.isEmpty() || correo.isEmpty() || fechaNac.isEmpty() || password.isEmpty() || vPassword.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Agregar Usuario", JOptionPane.ERROR_MESSAGE);
			textField_FechaNac.setText("dd/mm/yyyy");
			return false;
		}else if (comboBox.getSelectedIndex()==1 && instituto.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Agregar Usuario", JOptionPane.ERROR_MESSAGE);
			textField_FechaNac.setText("dd/mm/yyyy");
			return false;
		}
		try {
			
			if(!(fechaNac.substring(2,3).equals("/") && fechaNac.substring(5,6).equals("/"))) {
				JOptionPane.showMessageDialog(this, "La fecha de nacimiento debe seguir un formato dd/mm/yyyy ", "Formato de fecha incorrecto", JOptionPane.ERROR_MESSAGE);
				textField_FechaNac.setText("dd/mm/yyyy");
				return false;
			}else {
				String fechaNacDia = fechaNac.substring(0,2); int FNdia = Integer.parseInt(fechaNacDia);
				String fechaNacMes = fechaNac.substring(3,5); int FNmes = Integer.parseInt(fechaNacMes);
				String fechaNacAnio = fechaNac.substring(6);  int FNanio= Integer.parseInt(fechaNacAnio);
				
				if(FNdia<=31 && FNdia>=1) {
					if(FNmes<=12 && FNmes>=1){
						if(FNanio<=2020 && FNanio>=1900) {
							return true;
						}else {
							JOptionPane.showMessageDialog(this, "El anio debe estar entre 1900 y 2020", "Agregar Fecha", JOptionPane.ERROR_MESSAGE);
							textField_FechaNac.setText("dd/mm/yyyy");
							return false;
						}
					}else {
						JOptionPane.showMessageDialog(this, "El mes debe estar entre 1 y 12", "Agregar Fecha", JOptionPane.ERROR_MESSAGE);
						textField_FechaNac.setText("dd/mm/yyyy");
						return false;
					}
				}else {
					JOptionPane.showMessageDialog(this, "El dia debe estar entre 1 y 31", "Agregar Fecha", JOptionPane.ERROR_MESSAGE);
					textField_FechaNac.setText("dd/mm/yyyy");
					return false;
				}		
			}
		}catch(IndexOutOfBoundsException iob) {
			JOptionPane.showMessageDialog(this, "La fecha de nacimiento debe seguir un formato dd/mm/yyyy ", "Formato de fecha incorrecto", JOptionPane.ERROR_MESSAGE);
			textField_FechaNac.setText("dd/mm/yyyy");
			return false;
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(this, "La fecha de nacimiento debe ser numerica ", "Formato de fecha incorrecto", JOptionPane.ERROR_MESSAGE);
			textField_FechaNac.setText("dd/mm/yyyy");
			return false;
		}
	}
	
	private void limpiarFormulario() {
	        textFieldNombre.setText("");
	        textFieldApellido.setText("");
	        textFieldNick.setText("");
	        textFieldCorreo.setText("");
			textField_FechaNac.setText("dd/mm/yyyy");
	        textFieldInstituto.setText("");
	        textFieldPasswordV.setText("");
	        textPassWord.setText("");
	 }
	
	protected void altaUsuarioCancelarActionPerforme(ActionEvent e) {
		limpiarFormulario();
        setVisible(false);
	}
}
