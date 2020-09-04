package presentacion;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IControladorAltaEdicionCurso;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.UIManager;

import excepcion.UsuarioRepetidoException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaEdicionCursoFrame extends JInternalFrame {
	
	IControladorAltaEdicionCurso icaec;
	
	private static final long serialVersionUID = 1L;
	private JTextField textFieldFechaInicio;
	private JTextField textFieldFechaFin;
	private JTextField textFieldNombre;
	private JTextField textFieldDocente;
	private JTextField textFieldCantidad;
	private JRadioButton rdbtnNewRadioButtonNo;
	private JRadioButton rdbtnNewRadioButtonSi;
	protected JComboBox<String> comboBoxInstituto = new JComboBox<String>();;
	protected JComboBox<String> comboBoxInstitutoCurso  = new JComboBox<String>();;
	private JButton btnNewButtonAniadir;
	
	public AltaEdicionCursoFrame(IControladorAltaEdicionCurso icaec) {
		getContentPane().setBackground(UIManager.getColor("CheckBox.light"));
		this.icaec=icaec;
		setResizable(true);
	    setIconifiable(true);
	    setMaximizable(true);
	    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    setClosable(true);
        setTitle("Alta edicion de curso");
		setBounds(100, 100, 600, 450);
		getContentPane().setLayout(null);
		
		comboBoxInstituto = new JComboBox<String>();
		comboBoxInstituto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verCursos();
			}
		});
		comboBoxInstituto.setBounds(107, 54, 166, 22);
		getContentPane().add(comboBoxInstituto);
		
		JLabel lblNewLabelInstituto = new JLabel("Instituto");
		lblNewLabelInstituto.setBounds(53, 57, 56, 16);
		getContentPane().add(lblNewLabelInstituto);
		
		comboBoxInstitutoCurso.setBounds(107, 107, 166, 22);
		getContentPane().add(comboBoxInstitutoCurso);		
		JLabel lblNewLabelCurso = new JLabel("Curso");
		lblNewLabelCurso.setBounds(67, 110, 42, 16);
		getContentPane().add(lblNewLabelCurso);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de Inicio");
		lblFechaDeInicio.setBounds(324, 57, 89, 16);
		getContentPane().add(lblFechaDeInicio);
		
		JLabel lblNewLabelFechaDeFin = new JLabel("Fecha de Fin");
		lblNewLabelFechaDeFin.setBounds(324, 110, 89, 16);
		getContentPane().add(lblNewLabelFechaDeFin);
		
		textFieldFechaInicio = new JTextField();
		textFieldFechaInicio.setBounds(414, 57, 132, 22);
		getContentPane().add(textFieldFechaInicio);
		textFieldFechaInicio.setColumns(10);
		textFieldFechaInicio.setText("dd/mm/yyyy");
		
		textFieldFechaFin = new JTextField();
		textFieldFechaFin.setBounds(414, 107, 132, 22);
		getContentPane().add(textFieldFechaFin);
		textFieldFechaFin.setColumns(10);
		textFieldFechaFin.setText("dd/mm/yyyy");
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(107, 174, 166, 22);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldDocente = new JTextField();
		textFieldDocente.setColumns(10);
		textFieldDocente.setBounds(107, 228, 166, 22);
		getContentPane().add(textFieldDocente);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(414, 228, 102, 22);
		getContentPane().add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		JLabel lblNewLabelCantidad = new JLabel("Cantidad");
		lblNewLabelCantidad.setBounds(357, 231, 56, 16);
		getContentPane().add(lblNewLabelCantidad);
		
		rdbtnNewRadioButtonSi = new JRadioButton("Si");
		rdbtnNewRadioButtonSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNewRadioButtonSi.setSelected(true);
				rdbtnNewRadioButtonNo.setSelected(false);
				textFieldCantidad.setEnabled(true);
			}
		});
		rdbtnNewRadioButtonSi.setBackground(UIManager.getColor("CheckBox.light"));
		rdbtnNewRadioButtonSi.setBounds(414, 173, 49, 25);
		rdbtnNewRadioButtonSi.setSelected(false);
		getContentPane().add(rdbtnNewRadioButtonSi);
		
		rdbtnNewRadioButtonNo = new JRadioButton("No");
		rdbtnNewRadioButtonNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNewRadioButtonNo.setSelected(true);
				rdbtnNewRadioButtonSi.setSelected(false);
				textFieldCantidad.setText("");
				textFieldCantidad.setEnabled(false);
			}
		});
		rdbtnNewRadioButtonNo.setBackground(UIManager.getColor("CheckBox.light"));
		rdbtnNewRadioButtonNo.setBounds(467, 173, 49, 25);
		rdbtnNewRadioButtonNo.setSelected(true);
		textFieldCantidad.setEnabled(false);
		getContentPane().add(rdbtnNewRadioButtonNo);
		
		JLabel lblNewLabelNombre = new JLabel("Edicion");
		lblNewLabelNombre.setBounds(53, 177, 56, 16);
		getContentPane().add(lblNewLabelNombre);
		
		JLabel lblNewLabelCupos = new JLabel("Cupos");
		lblNewLabelCupos.setBounds(357, 177, 56, 16);
		getContentPane().add(lblNewLabelCupos);
		
		JLabel lblNewLabel = new JLabel("Docente");
		lblNewLabel.setBounds(53, 228, 56, 16);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButtonCancelar = new JButton("Cancelar");
		btnNewButtonCancelar.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnNewButtonCancelar.setBounds(361, 375, 98, 26);
		getContentPane().add(btnNewButtonCancelar);
		
		JButton btnNewButtomAceptar = new JButton("Aceptar");
		btnNewButtomAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aceptarActionPerformed(e);
			}
		});
		btnNewButtomAceptar.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnNewButtomAceptar.setBounds(474, 375, 98, 26);
		getContentPane().add(btnNewButtomAceptar);
		
		btnNewButtonAniadir = new JButton("Añadir Docente");
		btnNewButtonAniadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarDocente();
			}
		});
		btnNewButtonAniadir.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnNewButtonAniadir.setBounds(223, 376, 126, 25);
		getContentPane().add(btnNewButtonAniadir);

	}
	
	public void inicializarInstitutos() {
		List<String> institutos = this.icaec.listarInstitutos();
		String[] inst = new String[institutos.size()];
        int i=0;
        for(String s: institutos) {
        	inst[i]=s;
        	i++;
        }
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(inst);
		comboBoxInstituto.setModel(model);
		comboBoxInstituto.setSelectedIndex(0);
	}
	
	protected void verCursos() {
		this.icaec.ingresarInstituto(comboBoxInstituto.getSelectedItem().toString());
		List<String> cursos = this.icaec.listarCursos();
		if(!cursos.isEmpty()) {
			String[] listCursos = new String[cursos.size()];
	        int i=0;
	        for(String s: cursos) {
	        	listCursos[i]=s;
	        	i++;
	        }
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(listCursos);
			comboBoxInstitutoCurso.setModel(model);
			comboBoxInstitutoCurso.setEnabled(true);
			comboBoxInstitutoCurso.setSelectedIndex(0);
		}else {
			comboBoxInstitutoCurso.setEnabled(false);
			comboBoxInstitutoCurso.setSelectedIndex(-1);
		}
	}
	protected void agregarDocente() {
		String docente = textFieldDocente.getText();
		if(!docente.isEmpty()) {
			try {
				this.icaec.ingresarDocentes(docente);
				textFieldDocente.setText("");
				JOptionPane.showMessageDialog(this, "El docente se añadió con exito ", "Añadir docente", JOptionPane.INFORMATION_MESSAGE);
			}catch(UsuarioRepetidoException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Agregar Docente", JOptionPane.ERROR_MESSAGE);
			}
		}else {
			JOptionPane.showMessageDialog(this, "El campo docente está vacio ", "Añadir docente", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	protected void aceptarActionPerformed(ActionEvent e) {
		String fechaI = textFieldFechaInicio.getText();
		String fechaF = textFieldFechaFin.getText();
		String Nombre = textFieldNombre.getText();
		if(checkFormulario()) {
			String FechaIdia = fechaI.substring(0,2); int FIdia = Integer.parseInt(FechaIdia);
			String FechaFdia = fechaF.substring(0,2); int FFdia = Integer.parseInt(FechaFdia);
			String FechaImes = fechaI.substring(3,5); int FImes = Integer.parseInt(FechaImes);
			String FechaFmes = fechaF.substring(3,5); int FFmes = Integer.parseInt(FechaFmes);
			String FechaIAnio = fechaI.substring(6);  int FIanio= Integer.parseInt(FechaIAnio);
			String FechaFAnio = fechaI.substring(6);  int FFanio= Integer.parseInt(FechaFAnio);
			
		}
	}
	
	protected boolean checkFormulario() {
		String fechaI = textFieldFechaInicio.getText();
		String fechaF = textFieldFechaFin.getText();
		String Nombre = textFieldNombre.getText();
		if(rdbtnNewRadioButtonSi.isSelected()) {
			String cupos = textFieldCantidad.getText();
			if(cupos.isEmpty()) {
				JOptionPane.showMessageDialog(this, "El campo cupos está vacio", "Añadir docente", JOptionPane.ERROR_MESSAGE);
				return false;
			}else {
				try {
					int cupo = Integer.parseInt(cupos);
					if(cupo<=0) {
						JOptionPane.showMessageDialog(this, "Los cupos deben ser un numero mayor a 0 ", "Añadir cupos", JOptionPane.ERROR_MESSAGE);
						return false;
					}
				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(this, "Los cupos deben ser un numero ", "Añadir cupos", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
				
		}
		if(Nombre.isEmpty() || fechaI.isEmpty() || fechaF.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Todos los campos tienen que ser completados ", "Añadir campos", JOptionPane.ERROR_MESSAGE);
			return false;
		}else if(!comboBoxInstitutoCurso.isEnabled()){
			JOptionPane.showMessageDialog(this, "El instituto no tiene cursos asociados ", "Agregar Curso", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		try {
			if(!(fechaI.substring(2,3).equals("/") && fechaI.substring(5,6).equals("/"))) {
				JOptionPane.showMessageDialog(this, "La fecha inicio debe seguir un formato dd/mm/yyyy ", "Formato de fecha incorrecto", JOptionPane.ERROR_MESSAGE);
				textFieldFechaInicio.setText("");
				return false;
			}else if(!fechaF.substring(2,3).equals("/") && fechaF.substring(5,6).equals("/")){
				JOptionPane.showMessageDialog(this, "La fecha fin debe seguir un formato dd/mm/yyyy ", "Formato de fecha incorrecto", JOptionPane.ERROR_MESSAGE);
				textFieldFechaFin.setText("");
				return false;
			}else {
				String FechaIdia = fechaI.substring(0,2); int FIdia = Integer.parseInt(FechaIdia);
				String FechaFdia = fechaF.substring(0,2); int FFdia = Integer.parseInt(FechaFdia);
				String FechaImes = fechaI.substring(3,5); int FImes = Integer.parseInt(FechaImes);
				String FechaFmes = fechaF.substring(3,5); int FFmes = Integer.parseInt(FechaFmes);
				String FechaIAnio = fechaI.substring(6);  int FIanio= Integer.parseInt(FechaIAnio);
				String FechaFAnio = fechaF.substring(6);  int FFanio= Integer.parseInt(FechaFAnio);
				if((FIdia<=31 && FIdia>=1) && (FFdia<=31 && FFdia>=1)) {
					if((FImes<=12 && FImes>=1) && (FFmes<=12 && FFmes>=1)) {
						if((FIanio<=2020 && FIanio>=1900) && (FIanio<=2020 && FIanio>=1900)) {
							if(FFanio>FIanio) {
								return true;
							}else if(FFanio==FIanio) {
								if(FFmes>FImes) {
									return true;
								}else if(FFmes == FImes) {
									if(FFdia>FIdia) {
										return true;
									}else {
										JOptionPane.showMessageDialog(this, "La fecha inicio debe ser menor a la fecha fin", "Agregar Fecha", JOptionPane.ERROR_MESSAGE);
										textFieldFechaInicio.setText("dd/mm/yyyy");
										textFieldFechaFin.setText("dd/mm/yyyy");
										return false;
									}
								}else {
									JOptionPane.showMessageDialog(this, "La fecha inicio debe ser menor a la fecha fin", "Agregar Fecha", JOptionPane.ERROR_MESSAGE);
									textFieldFechaInicio.setText("dd/mm/yyyy");
									textFieldFechaFin.setText("dd/mm/yyyy");
									return false;
								}
							}else {
								JOptionPane.showMessageDialog(this, "La fecha inicio debe ser menor a la fecha fin", "Agregar Fecha", JOptionPane.ERROR_MESSAGE);
								textFieldFechaInicio.setText("dd/mm/yyyy");
								textFieldFechaFin.setText("dd/mm/yyyy");
								return false;
							}							
						}else {
							JOptionPane.showMessageDialog(this, "El anio debe estar entre 1900 y 2020", "Agregar Fecha", JOptionPane.ERROR_MESSAGE);
							textFieldFechaInicio.setText("dd/mm/yyyy");
							textFieldFechaFin.setText("dd/mm/yyyy");
							return false;
						}
					}else {
						JOptionPane.showMessageDialog(this, "El mes debe estar entre 1 y 12", "Agregar Fecha", JOptionPane.ERROR_MESSAGE);
						textFieldFechaInicio.setText("dd/mm/yyyy");
						textFieldFechaFin.setText("dd/mm/yyyy");
						return false;
					}
				}else {
					JOptionPane.showMessageDialog(this, "El dia debe estar entre 1 y 31", "Agregar Fecha", JOptionPane.ERROR_MESSAGE);
					textFieldFechaInicio.setText("dd/mm/yyyy");
					textFieldFechaFin.setText("dd/mm/yyyy");
					return false;
				}		
			}
		}catch(IndexOutOfBoundsException iob) {
			JOptionPane.showMessageDialog(this, "La fecha fin y la fecha inicio deben seguir un formato dd/mm/yyyy ", "Formato de fecha incorrecto", JOptionPane.ERROR_MESSAGE);
			textFieldFechaInicio.setText("dd/mm/yyyy");
			textFieldFechaFin.setText("dd/mm/yyyy");
			return false;
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(this, "La fecha fin y la fecha inicio deben ser numericas ", "Formato de fecha incorrecto", JOptionPane.ERROR_MESSAGE);
			textFieldFechaInicio.setText("dd/mm/yyyy");
			textFieldFechaFin.setText("dd/mm/yyyy");
			return false;
		}
	}
	
	protected void limpiarFormulario(){
		textFieldFechaInicio.setText("dd/mm/yyyy");
		textFieldFechaFin.setText("dd/mm/yyyy");
		textFieldNombre.setText("");
		if(rdbtnNewRadioButtonSi.isEnabled()) {
			textFieldCantidad.setText("");
		}
	}
}
