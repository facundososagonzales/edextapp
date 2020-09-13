package presentacion;



import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import datatypes.DtProgFormacion;

import interfaces.IControladorCrearProgFormacion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;

import excepciones.ProgForRepetido;

public class CrearProgFormacionFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField_nombre;
	private JTextField textField_des;
	private JTextField textField_fi1;
	private JTextField textField_fi2;
	private JTextField textField_fi3;
	private JTextField textField_ff1;
	private JTextField textField_ff2;
	private JTextField textField_ff3;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private IControladorCrearProgFormacion icpf;
	private JButton btnNewButton_aceptar;

	public CrearProgFormacionFrame(IControladorCrearProgFormacion icpf) {
		setClosable(true);
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		this.icpf=icpf;
		
		setTitle("Crear programa de formaci\u00F3n");
		setBounds(100, 100, 531, 348);
		getContentPane().setLayout(null);
		
		textField_nombre = new JTextField();
		textField_nombre.setBounds(197, 85, 104, 20);
		getContentPane().add(textField_nombre);
		textField_nombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(57, 88, 104, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Crear programa de formaci\u00F3n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(124, 24, 348, 25);
		getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		this.lblNewLabel_2 = new JLabel("Descripci\u00F3n");
		lblNewLabel_2.setBounds(57, 136, 118, 14);
		getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		
		textField_des = new JTextField();
		textField_des.setBounds(197, 133, 104, 20);
		getContentPane().add(textField_des);
		textField_des.setColumns(10);
		textField_des.setVisible(false);
		
		
		this.lblNewLabel_3 = new JLabel("Per\u00EDodo de vigencia:");
		lblNewLabel_3.setBounds(57, 172, 136, 14);
		getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setVisible(false);
		
		
		this.lblNewLabel_4 = new JLabel("Fecha inicio");
		lblNewLabel_4.setBounds(197, 172, 75, 14);
		getContentPane().add(lblNewLabel_4);
		lblNewLabel_4.setVisible(false);
		
		
		this.lblNewLabel_5 = new JLabel("Fecha fin");
		lblNewLabel_5.setBounds(197, 197, 75, 14);
		getContentPane().add(lblNewLabel_5);
		lblNewLabel_5.setVisible(false);
		
		
		textField_fi1 = new JTextField();
		textField_fi1.setBounds(282, 169, 32, 20);
		getContentPane().add(textField_fi1);
		textField_fi1.setColumns(10);
		textField_fi1.setVisible(false);
	
		
		
		textField_fi2 = new JTextField();
		textField_fi2.setBounds(324, 169, 32, 20);
		getContentPane().add(textField_fi2);
		textField_fi2.setColumns(10);
		textField_fi2.setVisible(false);
		
		textField_fi3 = new JTextField();
		textField_fi3.setBounds(366, 169, 32, 20);
		getContentPane().add(textField_fi3);
		textField_fi3.setColumns(10);
		textField_fi3.setVisible(false);
		
		textField_ff1 = new JTextField();
		textField_ff1.setBounds(282, 194, 32, 20);
		getContentPane().add(textField_ff1);
		textField_ff1.setColumns(10);
		textField_ff1.setVisible(false);
		
		textField_ff2 = new JTextField();
		textField_ff2.setBounds(324, 194, 32, 20);
		getContentPane().add(textField_ff2);
		textField_ff2.setColumns(10);
		textField_ff2.setVisible(false);
		
		textField_ff3 = new JTextField();
		textField_ff3.setBounds(366, 194, 32, 20);
		getContentPane().add(textField_ff3);
		textField_ff3.setColumns(10);
		textField_ff3.setVisible(false);
		
		JButton btnNewButton_cancelar = new JButton("Cancelar");
		btnNewButton_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				limpiarFormulario();
				setVisible(false);
				
				lblNewLabel_2.setVisible(false);
				textField_des.setVisible(false);
				lblNewLabel_3.setVisible(false);
				lblNewLabel_4.setVisible(false);
				lblNewLabel_5.setVisible(false);
				textField_fi1.setVisible(false);
				textField_fi2.setVisible(false);
				textField_fi3.setVisible(false);
				textField_ff1.setVisible(false);
				textField_ff2.setVisible(false);
				textField_ff3.setVisible(false);
				btnNewButton_aceptar.setVisible(false);
				
				
				
				
			}
		});
		btnNewButton_cancelar.setBounds(136, 265, 104, 23);
		getContentPane().add(btnNewButton_cancelar);
		
		btnNewButton_aceptar = new JButton("Aceptar");
		btnNewButton_aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AceptarActionPerformed(e);
			}
		});
		btnNewButton_aceptar.setBounds(282, 265, 89, 23);
		getContentPane().add(btnNewButton_aceptar);
		btnNewButton_aceptar.setVisible(false);
		
		JButton btnNewButton = new JButton("Verificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerificarActionPerformed(e);

			}

			
		});
		btnNewButton.setBounds(398, 84, 89, 23);
		getContentPane().add(btnNewButton);
	}
	
	private boolean checkFormulario() {
		String nombre = this.textField_nombre.getText();
		
		
		if(nombre.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Crear Programa de Formaci�n", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;

		
	}
	
	private boolean checkFormulario2() {
		String descripcion = textField_des.getText();
		String fi1 = textField_fi1.getText();
		String fi2 = textField_fi2.getText();
		String fi3 = textField_fi3.getText();
		String ff1 = textField_ff1.getText();
		String ff2 = textField_ff2.getText();
		String ff3 = textField_ff3.getText();
		
		if(descripcion.isEmpty() || fi1.isEmpty() || fi2.isEmpty() || fi3.isEmpty() || ff1.isEmpty() || ff2.isEmpty() || ff3.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Agregar Programa de Formacion", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
	
		return (VerificarFechas(fi1,fi2,fi3)) && (VerificarFechas(ff1,ff2,ff3));
	
	}
	

	
	private boolean VerificarFechas(String fi1, String fi2, String fi3) {
		try {
			int fech1 = Integer.parseInt(fi3);
			int fech2 = Integer.parseInt(fi2);
			int fech3 = Integer.parseInt(fi1);
			if(fech3<=31 && fech3>=1) {
				if(fech2<=12 && fech2>=1) {
					if(fech1<=2020 && fech1>=1900) {
						return true;
					}else {
						JOptionPane.showMessageDialog(this, "El anio debe estar entre 1900 y 2020", "Agregar Fecha", JOptionPane.ERROR_MESSAGE);
						
						return false;
					}
				}else {
					JOptionPane.showMessageDialog(this, "El mes debe estar entre 1 y 12", "Agregar Fecha", JOptionPane.ERROR_MESSAGE);
				
					return false;
				}
			}else {
				JOptionPane.showMessageDialog(this, "El dia debe estar entre 1 y 31", "Agregar Fecha", JOptionPane.ERROR_MESSAGE);
	
				return false;
			}
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "La fecha debe ser numerica", "Agregar Fecha", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
	}

	private void limpiarFormulario() {
		
		textField_des.setText("");
		textField_ff1.setText("");
		textField_ff2.setText("");
		textField_ff3.setText("");
		textField_fi1.setText("");
		textField_fi2.setText("");
		textField_fi3.setText("");
		textField_nombre.setText("");
	
	}
	
	protected void AceptarActionPerformed(ActionEvent e) {
		
		if (checkFormulario2()) {
			
			String descripcion = textField_des.getText();
			String fi1 = textField_fi1.getText();
			String fi2 = textField_fi2.getText();
			String fi3 = textField_fi3.getText();
			String ff1 = textField_ff1.getText();
			String ff2 = textField_ff2.getText();
			String ff3 = textField_ff3.getText();
			
	    	Date FechaInicio = new GregorianCalendar(Integer.parseInt(fi1), Integer.parseInt(fi2)-1, Integer.parseInt(fi3)).getTime();
	    	Date FechaFin = new GregorianCalendar(Integer.parseInt(ff1), Integer.parseInt(ff2)-1, Integer.parseInt(ff3)).getTime();
	    	Date FechaAlta = new Date();

			DtProgFormacion dtpf = new DtProgFormacion(descripcion,FechaInicio,FechaFin,FechaAlta);
			icpf.ingresarDatos(dtpf);
    		JOptionPane.showMessageDialog(this, "El Programa de formaci�n se ha registrado con �xito ", "Crear Programa de Formacion", JOptionPane.INFORMATION_MESSAGE);

			limpiarFormulario();
			setVisible(false);
			
			lblNewLabel_2.setVisible(false);
			textField_des.setVisible(false);
			lblNewLabel_3.setVisible(false);
			lblNewLabel_4.setVisible(false);
			lblNewLabel_5.setVisible(false);
			textField_fi1.setVisible(false);
			textField_fi2.setVisible(false);
			textField_fi3.setVisible(false);
			textField_ff1.setVisible(false);
			textField_ff2.setVisible(false);
			textField_ff3.setVisible(false);
			btnNewButton_aceptar.setVisible(false);
			
		}
	}
	
	protected void VerificarActionPerformed(ActionEvent e) {

		if (checkFormulario()) {
			String nombre = textField_nombre.getText();

			try {
				icpf.ingresarNombreProgFor(nombre);
				
				lblNewLabel_2.setVisible(true);
				textField_des.setVisible(true);
				lblNewLabel_3.setVisible(true);
				lblNewLabel_4.setVisible(true);
				lblNewLabel_5.setVisible(true);
				textField_fi1.setVisible(true);
				textField_fi2.setVisible(true);
				textField_fi3.setVisible(true);
				textField_ff1.setVisible(true);
				textField_ff2.setVisible(true);
				textField_ff3.setVisible(true);
				btnNewButton_aceptar.setVisible(true);
				
				
			} catch (ProgForRepetido e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(), "Alta Curso", JOptionPane.ERROR_MESSAGE);
		        textField_nombre.setText("");
			}	
		}
	
	}
	
}
