package presentacion;
import excepciones.ExisteCategoriaException;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import interfaces.IControladorAltaCategoria;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaCategoria extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JTextField textFieldCategoria;
	private IControladorAltaCategoria icon;

	public AltaCategoria(IControladorAltaCategoria icon) {
		this.icon=icon;
		
		setTitle("ALTA CATEGORIA");
		setBounds(100, 100, 552, 406);
		getContentPane().setLayout(null);
		
		JLabel lblIngreseNombre = new JLabel("Ingrese nombre:");
		lblIngreseNombre.setBounds(48, 131, 153, 15);
		getContentPane().add(lblIngreseNombre);
		
		textFieldCategoria = new JTextField();
		textFieldCategoria.setBounds(181, 129, 114, 19);
		getContentPane().add(textFieldCategoria);
		textFieldCategoria.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConfirmarActionPerformed(e);
			}
		});
		btnConfirmar.setBounds(333, 126, 117, 25);
		getContentPane().add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(333, 163, 117, 25);
		getContentPane().add(btnCancelar);

	}



	protected void btnConfirmarActionPerformed(ActionEvent arg0) {
		String cat = textFieldCategoria.getText();
		if(checkFormulario()){
			try {
				this.icon.altaCategoria(cat);
				JOptionPane.showMessageDialog(this, "Categoria registrada con Exito ", "Alta Categoria", JOptionPane.INFORMATION_MESSAGE);
				this.textFieldCategoria.setText("");
				setVisible(false);
			}catch(ExisteCategoriaException a) {
				JOptionPane.showMessageDialog(this, "La Categoria ya existe, Ingrese un nombre valido", "Alta Categoria", JOptionPane.ERROR_MESSAGE);
				this.textFieldCategoria.setText("");
			}
		}
	}
	
	protected boolean checkFormulario(){
		
		String cat = this.textFieldCategoria.getText();
		if(cat.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Alta Categoria", JOptionPane.ERROR_MESSAGE);
			return false;
			}
		else {
			return true;
		}	
	}
	protected void btnCancelarActionPerformed(ActionEvent arg0) {
				this.textFieldCategoria.setText("");
				setVisible(false);
	}
	
}
