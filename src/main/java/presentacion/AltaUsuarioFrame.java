package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import datatypes.DtDocente;
import datatypes.DtEstudiante;
import datatypes.DtUsuario;
import interfaces.IControladorAltaUsuario;
import excepcion.InstitutoNoCargadoException;
import excepcion.UsuarioRepetidoException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

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
	private JTextField textFieldDia;
	private JTextField textFieldMes;
	private JTextField textFieldAnio;
	private JLabel lblNewLabelDia;
	private JLabel lblNewLabelMes;
	private JLabel lblNewLabelAnio;
	private JLabel lblNewLabelFecha;
	private JLabel lblNewLabelRol;
	private JTextField textFieldInstituto;
	private JComboBox<String> comboBox; 
	private JPanel panel;

	public AltaUsuarioFrame(IControladorAltaUsuario icau) {
		getContentPane().setBackground(UIManager.getColor("CheckBox.light"));
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
		textFieldNombre.setBounds(99, 46, 129, 22);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNewNombre = new JLabel("Nombre");
		lblNewNombre.setBounds(42, 49, 56, 16);
		getContentPane().add(lblNewNombre);
		
		textFieldNick = new JTextField();
		textFieldNick.setBounds(99, 131, 129, 22);
		getContentPane().add(textFieldNick);
		textFieldNick.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(318, 46, 116, 22);
		getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(318, 131, 196, 22);
		getContentPane().add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		lblNewNick = new JLabel("Nick");
		lblNewNick.setBounds(60, 134, 38, 16);
		getContentPane().add(lblNewNick);
		
		lblNewApellido = new JLabel("Apellido");
		lblNewApellido.setBounds(263, 49, 56, 16);
		getContentPane().add(lblNewApellido);
		
		lblNewLabelCorreo = new JLabel("Correo");
		lblNewLabelCorreo.setBounds(263, 134, 56, 16);
		getContentPane().add(lblNewLabelCorreo);
		
		textFieldDia = new JTextField();
		textFieldDia.setBounds(82, 238, 38, 22);
		getContentPane().add(textFieldDia);
		textFieldDia.setColumns(10);
		
		textFieldMes = new JTextField();
		textFieldMes.setColumns(10);
		textFieldMes.setBounds(156, 238, 38, 22);
		getContentPane().add(textFieldMes);
		
		textFieldAnio = new JTextField();
		textFieldAnio.setColumns(10);
		textFieldAnio.setBounds(227, 238, 38, 22);
		getContentPane().add(textFieldAnio);
		
		lblNewLabelDia = new JLabel("Dia");
		lblNewLabelDia.setBounds(60, 241, 26, 16);
		getContentPane().add(lblNewLabelDia);
		
		lblNewLabelMes = new JLabel("Mes");
		lblNewLabelMes.setBounds(125, 241, 33, 16);
		getContentPane().add(lblNewLabelMes);
		
		lblNewLabelAnio = new JLabel("Año");
		lblNewLabelAnio.setBounds(203, 241, 26, 16);
		getContentPane().add(lblNewLabelAnio);
		
		lblNewLabelFecha = new JLabel("Fecha de nacimiento");
		lblNewLabelFecha.setBounds(98, 209, 129, 16);
		getContentPane().add(lblNewLabelFecha);
		
		lblNewLabelRol = new JLabel("Rol");
		lblNewLabelRol.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabelRol.setBounds(364, 223, 55, 16);
		getContentPane().add(lblNewLabelRol);
		
		textFieldInstituto = new JTextField();
		textFieldInstituto.setColumns(10);
		textFieldInstituto.setBounds(396, 278, 129, 22);
		getContentPane().add(textFieldInstituto);
		
		JLabel lblInstituto = new JLabel("Instituto");
		lblInstituto.setFont(new Font("Dialog", Font.BOLD, 14));
		lblInstituto.setBounds(335, 280, 84, 16);
		getContentPane().add(lblInstituto);
		
		JButton btnNewButtonCancelar = new JButton("Cancelar");
		btnNewButtonCancelar.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnNewButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuarioCancelarActionPerforme(e);
			}
		});
		btnNewButtonCancelar.setBounds(42, 365, 98, 26);
		getContentPane().add(btnNewButtonCancelar);
		
		JButton btnNewButtomAceptar = new JButton("Aceptar");
		btnNewButtomAceptar.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnNewButtomAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuarioActionPerformed(e);
			}
		});
		
		btnNewButtomAceptar.setBounds(454, 365, 98, 26);
		getContentPane().add(btnNewButtomAceptar);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(396, 221, 116, 22);
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
			
		
		panel = new JPanel();
		panel.setBackground(UIManager.getColor("CheckBox.light"));
		panel.setBounds(318, 209, 222, 109);
		getContentPane().add(panel);

	}
	protected void altaUsuarioActionPerformed(ActionEvent e) {

		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldApellido.getText();
		String nick = this.textFieldNick.getText();
		String correo = this.textFieldCorreo.getText();
		String dia = this.textFieldDia.getText();
		String mes = this.textFieldMes.getText();
		String anio = this.textFieldAnio.getText();
		String instituto = this.textFieldInstituto.getText();
		if (checkForumalrio()) {
			try {
		    	Date fechaNac = new GregorianCalendar(Integer.parseInt(anio), (Integer.parseInt(mes)-1), Integer.parseInt(dia)).getTime();
				DtUsuario usuarioing = null;
				if (comboBox.getSelectedIndex()==1) {
					this.icau.ingresarInstituto(instituto);
					usuarioing = new DtDocente (nick,nombre,apellido,correo,fechaNac);
				}else {
					usuarioing = new DtEstudiante(nick,nombre,apellido,correo,fechaNac);
				}
				this.icau.ingresarUser(usuarioing);
				this.icau.altaUsuario();
				JOptionPane.showMessageDialog(this, "El Usuario se ha registrado con éxito ", "Alta Usuario", JOptionPane.INFORMATION_MESSAGE);
	            limpiarFormulario();
	            setVisible(false);
			}catch(UsuarioRepetidoException ex){
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Alta Usuario", JOptionPane.ERROR_MESSAGE);
    	        textFieldNick.setText("");
    	        textFieldCorreo.setText("");
			}catch(InstitutoNoCargadoException iner) {
                JOptionPane.showMessageDialog(this, iner.getMessage(), "Alta Usuario", JOptionPane.ERROR_MESSAGE);
    	        textFieldInstituto.setText("");
			}
		}
	}
	 
	
	private boolean checkForumalrio() {
		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldApellido.getText();
		String nick = this.textFieldNick.getText();
		String correo = this.textFieldCorreo.getText();
		String dia = this.textFieldDia.getText();
		String mes = this.textFieldMes.getText();
		String anio = this.textFieldAnio.getText();
		String instituto = this.textFieldInstituto.getText();
		if(nombre.isEmpty() || apellido.isEmpty() || nick.isEmpty() || correo.isEmpty() || dia.isEmpty() || mes.isEmpty() || anio.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Agregar Usuario", JOptionPane.ERROR_MESSAGE);
			return false;
		}else if (comboBox.getSelectedIndex()==1 && instituto.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Agregar Usuario", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		try {
			int dia1 = Integer.parseInt(dia);
			int mes1 = Integer.parseInt(mes);
			int anio1 = Integer.parseInt(anio);
			if(dia1<=31 && dia1>=1) {
				if(mes1<=12 && mes1>=1) {
					if(anio1<=2020 && anio1>=1900) {
						return true;
					}else {
						JOptionPane.showMessageDialog(this, "El anio debe estar entre 1900 y 2020", "Agregar Fecha", JOptionPane.ERROR_MESSAGE);
						this.textFieldAnio.setText("");
						return false;
					}
				}else {
					JOptionPane.showMessageDialog(this, "El mes debe estar entre 1 y 12", "Agregar Fecha", JOptionPane.ERROR_MESSAGE);
					this.textFieldMes.setText("");
					return false;
				}
			}else {
				JOptionPane.showMessageDialog(this, "El dia debe estar entre 1 y 31", "Agregar Fecha", JOptionPane.ERROR_MESSAGE);
				this.textFieldDia.setText("");
				return false;
			}
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "La fecha debe ser numerica", "Agregar Fecha", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	private void limpiarFormulario() {
	        textFieldNombre.setText("");
	        textFieldApellido.setText("");
	        textFieldNick.setText("");
	        textFieldCorreo.setText("");
	        textFieldDia.setText("");
	        textFieldMes.setText("");
	        textFieldAnio.setText("");
	        textFieldInstituto.setText("");
	 }
	protected void altaUsuarioCancelarActionPerforme(ActionEvent e) {
		limpiarFormulario();
        setVisible(false);
	}
	
	
	
	
	
}
