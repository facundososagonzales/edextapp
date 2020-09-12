package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import datatypes.DtUsuario;

import interfaces.IControladorModificarDatosUsuario;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ModificarDUsuarios extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private IControladorModificarDatosUsuario icmdu;
	protected JComboBox<String> usuarios;
	
	 
	
	public ModificarDUsuarios(IControladorModificarDatosUsuario icmdu) {
		this.icmdu = icmdu;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		usuarios = new JComboBox<String>();
		usuarios.addItem("Seleccione un usuario");
		usuarios.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				mostraritemStateChanged( e);
				
			}
		});
		usuarios.setBounds(44, 49, 358, 20);
		getContentPane().add(usuarios);
		
		JLabel lblNewLabel = new JLabel("Usuarios");
		lblNewLabel.setBounds(10, 24, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(44, 120, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(172, 117, 86, 20);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(44, 160, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(172, 157, 86, 20);
		getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent m) {
				cmdModificarUsuarioActionPerformed(m);
			}

			
		});
		btnModificar.setBounds(220, 236, 89, 23);
		getContentPane().add(btnModificar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(313, 236, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent c) {
                limpiarFormulario();
                setVisible(false);
            }
        });
		getContentPane().add(btnCancelar);

	}
	
	public void listarUsuario() {
			
			String[] usus = this.icmdu.listarUsuario();
			DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<String>();
			
			for(int i = 0; i < usus.length; i++){
			        modelo.addElement(usus[i]);
			}
			usuarios.setModel(modelo);
			
			//usuarios.setSelectedIndex(-1);
			
			
	    }
	
	public void mostraritemStateChanged(ItemEvent e) {
		String usu = (String)usuarios.getSelectedItem();
		//if(!usu.isEmpty()) {
		DtUsuario usuario = this.icmdu.elegirUsuario(usu);
		if(usuario!=null) {
		this.textFieldNombre.setText(usuario.getNombre());
		this.textFieldApellido.setText(usuario.getApellido());
		}
	}
	
	protected void cmdModificarUsuarioActionPerformed(ActionEvent m) {
	    String nombreU = this.textFieldNombre.getText();
	    String apellidoU = this.textFieldApellido.getText();
	
	    if (checkFormulario()) {
	        	
	        	DtUsuario usuario = new DtUsuario(nombreU,apellidoU);
	        	this.icmdu.modificar(usuario);
	
	            JOptionPane.showMessageDialog(this, "El Usuario ha sido modificado con éxito", "Modificar datos del Usuario",
	                    JOptionPane.INFORMATION_MESSAGE);
	
	        
	        limpiarFormulario();
	        setVisible(false);
	    }
	}
	
	private boolean checkFormulario() {
	    String nombreU = this.textFieldNombre.getText();
	    String apellidoU = this.textFieldApellido.getText();
	
	    if (nombreU.isEmpty() || apellidoU.isEmpty() ) {
	        JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Modificar datos del Usuario",
	                JOptionPane.ERROR_MESSAGE);
	        return false;
	    }
	    return true;
	}
	
	private void limpiarFormulario() {
	    textFieldNombre.setText("");
	    textFieldApellido.setText("");
	}

}
