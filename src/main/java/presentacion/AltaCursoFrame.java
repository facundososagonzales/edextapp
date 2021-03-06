package presentacion;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import javax.swing.JTextField;

import datatypes.DtCursoDetalle;
import interfaces.IControladorAltaCurso;
import excepciones.CursoRepetido;
import excepciones.ExisteCategoriaException;
import excepciones.PreviaYaExiste;
import excepciones.InstitutoNoCargadoException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class AltaCursoFrame extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private IControladorAltaCurso icac;
	private JTextField textField_instituto;
	private JTextField textField_curso;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_Cancelar;
	private JTextField textField_descripcion;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_duracion;
	private JLabel lblNewLabel_4;
	private JTextField textField_canthoras;
	private JLabel lblNewLabel_5;
	private JTextField textField_creditos;
	private JTextField textField_f1;
	private JTextField textField_f2;
	private JTextField textField_f3;
	private JLabel lblNewLabel_6;
	private JTextField textField_url;
	private JLabel lblNewLabel_7;
	private JButton btnNewButton_aceptar2;
	private JLabel lblNewLabel_8;
	private JTextField textField_p1;
	private JButton btnNewButton;
	private JRadioButton rdbtnNewRadioButton_no;
	private JRadioButton rdbtnNewRadioButton_SI;
	private JLabel lblNewLabel_9;
	private JCheckBox checkBox;
	private JLabel lbldeseaAgregarleCategoriaas;
	private JComboBox<String> comboBoxCategoria;
	private JButton btnAnadir;
	
	

public AltaCursoFrame(IControladorAltaCurso icac) {
	getContentPane().setLayout(null);
	
	textField_instituto = new JTextField();
	textField_instituto.setBounds(253, 37, 86, 20);
	getContentPane().add(textField_instituto);
	textField_instituto.setColumns(10);
	
	textField_curso = new JTextField();
	textField_curso.setText("");
	textField_curso.setBounds(253, 68, 86, 20);
	getContentPane().add(textField_curso);
	textField_curso.setColumns(10);
	
	JButton btnNewButton_Aceptar1 = new JButton("Aceptar");
	btnNewButton_Aceptar1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			AceptarActionPerformed(e);

		}	
	});
	btnNewButton_Aceptar1.setBounds(385, 67, 89, 23);
	getContentPane().add(btnNewButton_Aceptar1);
	
	lblNewLabel = new JLabel("Ingrese nombre del curso");
	lblNewLabel.setBounds(59, 71, 154, 14);
	getContentPane().add(lblNewLabel);
	
	lblNewLabel_1 = new JLabel("Ingrese nombre del instituto");
	lblNewLabel_1.setBounds(59, 40, 190, 14);
	getContentPane().add(lblNewLabel_1);
	
	btnNewButton_Cancelar = new JButton("Cancelar");
	btnNewButton_Cancelar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			limpiarFormulario();
			icac.limpiarDatos();
	        setVisible(false);
	        lblNewLabel_9.setVisible(false);
	        textField_descripcion.setVisible(false);
			lblNewLabel_2.setVisible(false);
			lblNewLabel_3.setVisible(false);
			textField_duracion.setVisible(false);
			lblNewLabel_4.setVisible(false);
			textField_canthoras.setVisible(false);
			lblNewLabel_5.setVisible(false);
			textField_creditos.setVisible(false);
			textField_f1.setVisible(false);
			textField_f2.setVisible(false);
			textField_f3.setVisible(false);
			lblNewLabel_6.setVisible(false);
			textField_url.setVisible(false);
			lblNewLabel_7.setVisible(false);
			btnNewButton_aceptar2.setVisible(false);
			lblNewLabel_8.setVisible(false);
			rdbtnNewRadioButton_no.setVisible(false);
			rdbtnNewRadioButton_SI.setVisible(false);
			btnNewButton.setVisible(false);
			textField_p1.setVisible(false);
			lbldeseaAgregarleCategoriaas.setVisible(false);
			checkBox.setVisible(false);
			comboBoxCategoria.setVisible(false);
			lbldeseaAgregarleCategoriaas.setVisible(false);
			btnAnadir.setVisible(false);
			checkBox.setVisible(false);
			checkBox.setSelected(false);
		}
	});
	btnNewButton_Cancelar.setBounds(151, 436, 112, 23);
	getContentPane().add(btnNewButton_Cancelar);
	
	textField_descripcion = new JTextField();
	textField_descripcion.setBounds(199, 127, 342, 20);
	textField_descripcion.setVisible(false);
	getContentPane().add(textField_descripcion);
	textField_descripcion.setColumns(10);
	
	lblNewLabel_2 = new JLabel("Descripci\u00F3n");
	lblNewLabel_2.setBounds(79, 130, 86, 14);
	lblNewLabel_2.setVisible(false);
	getContentPane().add(lblNewLabel_2);
	
	lblNewLabel_3 = new JLabel("Duracion");
	lblNewLabel_3.setBounds(79, 155, 86, 14);
	lblNewLabel_3.setVisible(false);
	getContentPane().add(lblNewLabel_3);
	
	textField_duracion = new JTextField();
	textField_duracion.setBounds(199, 152, 38, 20);
	textField_duracion.setVisible(false);
	getContentPane().add(textField_duracion);
	textField_duracion.setColumns(10);
	
	lblNewLabel_4 = new JLabel("Cantidad de horas");
	lblNewLabel_4.setBounds(79, 180, 112, 14);
	lblNewLabel_4.setVisible(false);
	getContentPane().add(lblNewLabel_4);
	
	textField_canthoras = new JTextField();
	textField_canthoras.setBounds(199, 177, 50, 20);
	textField_canthoras.setVisible(false);
	getContentPane().add(textField_canthoras);
	textField_canthoras.setColumns(10);
	
	lblNewLabel_5 = new JLabel("Cr\u00E9ditos");
	lblNewLabel_5.setBounds(79, 205, 52, 14);
	lblNewLabel_5.setVisible(false);
	getContentPane().add(lblNewLabel_5);
	
	textField_creditos = new JTextField();
	textField_creditos.setBounds(199, 202, 38, 20);
	textField_creditos.setVisible(false);
	getContentPane().add(textField_creditos);
	textField_creditos.setColumns(10);
	
	textField_f1 = new JTextField();
	textField_f1.setBounds(199, 227, 38, 20);
	textField_f1.setVisible(false);
	getContentPane().add(textField_f1);
	textField_f1.setColumns(10);
	
	textField_f2 = new JTextField();
	textField_f2.setBounds(252, 227, 39, 20);
	textField_f2.setVisible(false);
	getContentPane().add(textField_f2);
	textField_f2.setColumns(10);
	
	textField_f3 = new JTextField();
	textField_f3.setBounds(301, 227, 38, 20);
	textField_f3.setVisible(false);
	getContentPane().add(textField_f3);
	textField_f3.setColumns(10);
	
	lblNewLabel_6 = new JLabel("Fecha");
	lblNewLabel_6.setBounds(79, 230, 46, 14);
	lblNewLabel_6.setVisible(false);
	getContentPane().add(lblNewLabel_6);
	
	textField_url = new JTextField();
	textField_url.setBounds(199, 256, 240, 20);
	textField_url.setVisible(false);
	getContentPane().add(textField_url);
	textField_url.setColumns(10);
	
	lblNewLabel_7 = new JLabel("URL");
	lblNewLabel_7.setBounds(79, 259, 46, 14);
	lblNewLabel_7.setVisible(false);
	getContentPane().add(lblNewLabel_7);
	
	btnNewButton_aceptar2 = new JButton("Aceptar");
	btnNewButton_aceptar2.setVisible(false);
	btnNewButton_aceptar2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			altaCursoActionPerformed(e);
		}
	});
	btnNewButton_aceptar2.setBounds(320, 436, 101, 23);
	getContentPane().add(btnNewButton_aceptar2);
	
	lblNewLabel_8 = new JLabel("\u00BFTiene previas?");
	lblNewLabel_8.setBounds(79, 297, 122, 14);
	lblNewLabel_8.setVisible(false);
	getContentPane().add(lblNewLabel_8);
	
	rdbtnNewRadioButton_no = new JRadioButton("No");
	rdbtnNewRadioButton_no.setVisible(false);

	rdbtnNewRadioButton_no.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			rdbtnNewRadioButton_SI.setSelected(false);
			rdbtnNewRadioButton_no.setSelected(true);
			btnNewButton.setVisible(false);
			textField_p1.setVisible(false);
			textField_p1.setText("");
		}
	});
	rdbtnNewRadioButton_no.setBounds(199, 318, 64, 23);
	getContentPane().add(rdbtnNewRadioButton_no);
	
	textField_p1 = new JTextField();
	textField_p1.setVisible(false);
	textField_p1.setBounds(296, 294, 86, 20);
	getContentPane().add(textField_p1);
	textField_p1.setColumns(10);
	
	btnNewButton = new JButton("A\u00F1adir previa");
	btnNewButton.setVisible(false);
	btnNewButton.setBounds(429, 293, 154, 23);
	getContentPane().add(btnNewButton);
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		
			anadirPreviaActionPerformed(e);
			
			}
			
	
	});
	
	
	
	this.rdbtnNewRadioButton_SI = new JRadioButton("Si");
	rdbtnNewRadioButton_SI.setVisible(false);
	rdbtnNewRadioButton_SI.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			rdbtnNewRadioButton_SI.setSelected(true);
			rdbtnNewRadioButton_no.setSelected(false);
			btnNewButton.setVisible(true);
			textField_p1.setVisible(true);
    		
			
		}
	});
	rdbtnNewRadioButton_SI.setBounds(197, 293, 86, 23);
	getContentPane().add(rdbtnNewRadioButton_SI);
	
	this.lblNewLabel_9 = new JLabel("hh:mm:ss");
    lblNewLabel_9.setVisible(false);
	lblNewLabel_9.setForeground(Color.GRAY);
	lblNewLabel_9.setBounds(260, 180, 79, 14);
	getContentPane().add(lblNewLabel_9);
	
	JLabel lbldeseaAgregarleCategoriaas = new JLabel("??Desea agregar a Categoria/as?");
	lbldeseaAgregarleCategoriaas.setBounds(79, 361, 240, 15);
	getContentPane().add(lbldeseaAgregarleCategoriaas);
	this.lbldeseaAgregarleCategoriaas=lbldeseaAgregarleCategoriaas;
	lbldeseaAgregarleCategoriaas.setVisible(false);
	
	JButton btnAnadir = new JButton("A??adir categoria");
	this.btnAnadir=btnAnadir;
	btnAnadir.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			btnAgregarCategoriaActionPerformed(e);
		}
	});
	btnAnadir.setBounds(417, 387, 166, 25);
	getContentPane().add(btnAnadir);
	btnAnadir.setVisible(false);
	
	
	JCheckBox checkBox = new JCheckBox("");
	checkBox.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if(checkBox.isSelected()) {
			comboBoxCategoria.setVisible(true);
			verCategorias();
			btnAnadir.setVisible(true);
			}else {
				comboBoxCategoria.setVisible(false);
				btnAnadir.setVisible(false);
			}
		}
	});
	checkBox.setBounds(310, 356, 38, 23);
	getContentPane().add(checkBox);
	checkBox.setVisible(false);
	this.checkBox=checkBox;

	
	comboBoxCategoria = new JComboBox<String>();
	comboBoxCategoria.setBounds(359, 357, 166, 22);
	getContentPane().add(comboBoxCategoria);
	comboBoxCategoria.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		}
	});
	comboBoxCategoria.setVisible(false);

		this.icac=icac;
		setResizable(true);
	    setIconifiable(true);
	    setMaximizable(true);
	    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    setClosable(true);
        setTitle("Alta de Curso");
		setBounds(100, 100, 628, 503);
		
	
} 

private boolean checkFormulario() {
	String nombre = this.textField_instituto.getText();
	String instituto = this.textField_curso.getText();
	
	if(nombre.isEmpty() || instituto.isEmpty() ) {
		JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Agregar Curso", JOptionPane.ERROR_MESSAGE);
		return false;
	}
	return true;

	
}

private void limpiarFormulario() {
    textField_instituto.setText("");
    textField_curso.setText("");
    textField_canthoras.setText("");
    textField_creditos.setText("");
    textField_descripcion.setText("");
    textField_duracion.setText("");
    textField_f1.setText("");
    textField_f2.setText("");
    textField_f3.setText("");
    textField_p1.setText("");
    textField_url.setText("");
    

}



protected void anadirPreviaActionPerformed(ActionEvent e) {
	String previa = textField_p1.getText();
	rdbtnNewRadioButton_no.setVisible(false);

	if (icac.AgregarPrevias2(previa)){
		JOptionPane.showMessageDialog(this, "Previa erronea", "Aniadir previas", JOptionPane.ERROR_MESSAGE);
	}else
		JOptionPane.showMessageDialog(this, "La previa se ingreso con exito", "A???adir Previas", JOptionPane.INFORMATION_MESSAGE);
	
}



protected void AceptarActionPerformed(ActionEvent e) {
String nombre = textField_curso.getText();
String instituto = textField_instituto.getText();


if (checkFormulario()) {
	
	if (icac.ingresarInstituto(instituto)) {
		JOptionPane.showMessageDialog(this, "El instituto no existe", "Alta Curso", JOptionPane.ERROR_MESSAGE);
        textField_instituto.setText("");
	}else if (icac.ingresarCurso(nombre)) {
		JOptionPane.showMessageDialog(this, "El curso ya existe", "Alta Curso", JOptionPane.ERROR_MESSAGE);
		textField_instituto.setText("");
	}
	
		textField_descripcion.setVisible(true);
		lblNewLabel_2.setVisible(true);
		lblNewLabel_3.setVisible(true);
		textField_duracion.setVisible(true);
        lblNewLabel_9.setVisible(true);

		lblNewLabel_4.setVisible(true);
		textField_canthoras.setVisible(true);
		lblNewLabel_5.setVisible(true);
		textField_creditos.setVisible(true);
		textField_f1.setVisible(true);
		textField_f2.setVisible(true);
		textField_f3.setVisible(true);
		lblNewLabel_6.setVisible(true);
		textField_url.setVisible(true);
		lblNewLabel_7.setVisible(true);
		btnNewButton_aceptar2.setVisible(true);
		lblNewLabel_8.setVisible(true);
		rdbtnNewRadioButton_no.setVisible(true);
		rdbtnNewRadioButton_SI.setVisible(true);
		lbldeseaAgregarleCategoriaas.setVisible(true);
		checkBox.setVisible(true);
	
							
}

}



protected void altaCursoActionPerformed(ActionEvent e) {
	
	String duracion = textField_duracion.getText();
	String descripcion = textField_descripcion.getText();
	String fecha1 = textField_f1.getText();
	String fecha2 = textField_f2.getText();
	String fecha3 = textField_f3.getText();
	String canthoras = textField_canthoras.getText();
	String creditos = textField_creditos.getText();
	String url = textField_url.getText();
	String nombre = textField_instituto.getText();
	
	if (checkFormulario2()) {
		
	    	Date Fecha = new GregorianCalendar(Integer.parseInt(fecha3), Integer.parseInt(fecha2)-1, Integer.parseInt(fecha1)).getTime();
	    	Integer cred = Integer.parseInt(creditos); 
	    	Time cantihoras = Time.valueOf(canthoras); //el formato de hora ingresado debe ser hh:mm:ss
	    	
	    	String[] previas = icac.getPrevias();
	    	
	    	if (previas.length>=0) {
	    		
	    		DtCursoDetalle dcursoing= new DtCursoDetalle(nombre,descripcion,duracion,cantihoras,cred,Fecha,url);
	    		icac.ingresarDatos(dcursoing);
	    		JOptionPane.showMessageDialog(this, "El Curso se ha registrado con ???xito ", "Alta Curso", JOptionPane.INFORMATION_MESSAGE);
	            limpiarFormulario();
	            icac.limpiarDatos() ;
	            setVisible(false);
	            
	    		
	    		
	    	}else {
	    		DtCursoDetalle dcursoing= new DtCursoDetalle(nombre,descripcion,duracion,cantihoras,cred,Fecha,url);
	    		icac.ingresarDatos(dcursoing);
	    		JOptionPane.showMessageDialog(this, "El Curso se ha registrado con ???xito ", "Alta Curso", JOptionPane.INFORMATION_MESSAGE);
	            limpiarFormulario();
	            icac.limpiarDatos();
	            setVisible(false);
	    	}
	    	
	    	 textField_descripcion.setVisible(false);
				lblNewLabel_2.setVisible(false);
				lblNewLabel_3.setVisible(false);
				textField_duracion.setVisible(false);
		        lblNewLabel_9.setVisible(false);

				lblNewLabel_4.setVisible(false);
				textField_canthoras.setVisible(false);
				lblNewLabel_5.setVisible(false);
				textField_creditos.setVisible(false);
				textField_f1.setVisible(false);
				textField_f2.setVisible(false);
				textField_f3.setVisible(false);
				lblNewLabel_6.setVisible(false);
				textField_url.setVisible(false);
				lblNewLabel_7.setVisible(false);
				btnNewButton_aceptar2.setVisible(false);
				lblNewLabel_8.setVisible(false);
				rdbtnNewRadioButton_no.setVisible(false);
				rdbtnNewRadioButton_SI.setVisible(false);
				btnNewButton.setVisible(false);
				textField_p1.setVisible(false);
				btnAnadir.setVisible(false);
				checkBox.setSelected(false);
				checkBox.setVisible(false);
				lbldeseaAgregarleCategoriaas.setVisible(false);
				comboBoxCategoria.setVisible(false);
	} 


}

private boolean checkFormulario2() {
	
	String duracion = textField_duracion.getText();
	String descripcion = textField_descripcion.getText();
	String fecha1 = textField_f1.getText();
	String fecha2 = textField_f2.getText();
	String fecha3 = textField_f3.getText();
	String canthoras = textField_canthoras.getText();
	String url = textField_url.getText();
	String creditos = textField_creditos.getText();

	

	if(duracion.isEmpty() || descripcion.isEmpty() || fecha1.isEmpty() || fecha2.isEmpty() || fecha3.isEmpty() || canthoras.isEmpty() || creditos.isEmpty() || url.isEmpty()) {
		JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Agregar Curso", JOptionPane.ERROR_MESSAGE);
		return false;
	}
	
	try {
		Integer.parseInt(creditos);
	}catch(NumberFormatException e){
		JOptionPane.showMessageDialog(this, "Los cr???ditos deben ser ingresados en formato num???rico ", "Agregar Fecha", JOptionPane.ERROR_MESSAGE);
		return false;
	}
	
		try {
			int fech1 = Integer.parseInt(fecha3);
			int fech2 = Integer.parseInt(fecha2);
			int fech3 = Integer.parseInt(fecha1);
			if(fech3<=31 && fech3>=1) {
				if(fech2<=12 && fech2>=1) {
					if(fech1<=2020 && fech1>=1900) {
						return true;
					}else {
						JOptionPane.showMessageDialog(this, "El anio debe estar entre 1900 y 2020", "Agregar Fecha", JOptionPane.ERROR_MESSAGE);
						this.textField_f3.setText("");
						return false;
					}
				}else {
					JOptionPane.showMessageDialog(this, "El mes debe estar entre 1 y 12", "Agregar Fecha", JOptionPane.ERROR_MESSAGE);
					this.textField_f2.setText("");
					return false;
				}
			}else {
				JOptionPane.showMessageDialog(this, "El dia debe estar entre 1 y 31", "Agregar Fecha", JOptionPane.ERROR_MESSAGE);
				this.textField_f1.setText("");
				return false;
			}
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "La fecha debe ser numerica", "Agregar Fecha", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	
	}
	
	public void verCategorias() {
			
		String[] listCats = icac.listarCategorias();
		if(listCats.length!=0) {

			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(listCats);
			comboBoxCategoria.setModel(model);
			comboBoxCategoria.setEnabled(true);
			comboBoxCategoria.setSelectedIndex(0);
			
		}else {
			comboBoxCategoria.setEnabled(false);
			comboBoxCategoria.setSelectedIndex(-1);
		}
		
	}
	
	public void btnAgregarCategoriaActionPerformed(ActionEvent e) {
		String cat = comboBoxCategoria.getSelectedItem().toString();
		
		if (icac.agregarCategoria(cat)) {
			JOptionPane.showMessageDialog(this, "La categoria ya ha sido ingresada", "Agregar Categoria", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "Categoria agregada con exito ", "Agregar categoria", JOptionPane.INFORMATION_MESSAGE);
	
		}
	}
}
