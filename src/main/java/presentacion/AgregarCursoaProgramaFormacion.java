package presentacion;

import java.util.ArrayList;



import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IControladorAgregarCursoAProgDeFormacion;
import javax.swing.JTextPane;

import datatypes.DtCursoBase;
import datatypes.DtInfoPFormacion;
import excepciones.ExisteCursoException;
import excepciones.ExisteProgramaException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class AgregarCursoaProgramaFormacion extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private IControladorAgregarCursoAProgDeFormacion icon;
	private JTextField textFieldProgFormacion;
	private JTextField textFieldNomCurso;
	private JButton btnCancelarTodo;
	private JButton btnConfirmarAgregar;
	private JTextPane textPaneCursos_1;
	private JTextPane textPaneProgFormacion_1;

	public AgregarCursoaProgramaFormacion(IControladorAgregarCursoAProgDeFormacion icon) {
		
		
		this.icon = icon;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setTitle("AGREGAR CURSO A PROGRAMA DE FORMACION");
		setBounds(100, 100, 523, 351);
		getContentPane().setLayout(null);
		
		JTextPane textPaneProgFormacion_1 = new JTextPane();
		textPaneProgFormacion_1.setBounds(12, 12, 208, 93);
		getContentPane().add(textPaneProgFormacion_1);
		textPaneProgFormacion_1.setEditable(false);
		//-----------
		ArrayList<DtInfoPFormacion> programas = icon.listarProgsFormacion();
		String datos = "PROGRAMAS DE FORMACION:\n";
		for(DtInfoPFormacion d: programas ) {
			datos = datos + "\n"+d.toString();
		}
		//-----------
		textPaneProgFormacion_1.setText(datos);
		this.textPaneProgFormacion_1 =textPaneProgFormacion_1; 
				
		JButton btnConfirmarAgregar = new JButton("Confirmar");
		btnConfirmarAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConfirmarAgregarActionPerformed(e);
			}
		});
		btnConfirmarAgregar.setBounds(106, 263, 117, 25);
		getContentPane().add(btnConfirmarAgregar);
		
		JButton btnCancelarTodo = new JButton("Cancelar");
		btnCancelarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarTodoActionPerformed(e);
			}
		});
		btnCancelarTodo.setBounds(257, 263, 117, 25);
		getContentPane().add(btnCancelarTodo);
		
		JLabel lblProgramaDeFormacion = new JLabel("Seleccionar Programa de Formacion");
		lblProgramaDeFormacion.setBounds(238, 12, 260, 15);
		getContentPane().add(lblProgramaDeFormacion);
		
		
		JLabel lblNombre_1 = new JLabel("[* nombre = nombre pFormacion *]");
		lblNombre_1.setBounds(238, 27, 251, 15);
		getContentPane().add(lblNombre_1);
		
		JLabel lblIngreseNombrePrograma = new JLabel("Ingrese nombre:");
		lblIngreseNombrePrograma.setBounds(232, 53, 142, 15);
		getContentPane().add(lblIngreseNombrePrograma);
		
		textFieldProgFormacion = new JTextField();
		textFieldProgFormacion.setBounds(386, 49, 114, 19);
		getContentPane().add(textFieldProgFormacion);
		textFieldProgFormacion.setColumns(10);
		
		JButton btnSeleccionarProgF = new JButton("Seleccionar");
		btnSeleccionarProgF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSeleccionarProgFActionPerformed(e);
			}
		});
		btnSeleccionarProgF.setBounds(242, 90, 117, 25);
		getContentPane().add(btnSeleccionarProgF);
		
		
		JButton btnCancelarProgF = new JButton("Cancelar");
		btnCancelarProgF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarProgramaActionPerformed(e);
			}
		});
		btnCancelarProgF.setBounds(381, 90, 117, 25);
		getContentPane().add(btnCancelarProgF);
		
		JTextPane textPaneCursos_1 = new JTextPane();
		textPaneCursos_1.setBounds(15, 124, 208, 129);
		getContentPane().add(textPaneCursos_1);
		textPaneCursos_1.setEditable(false);
		textPaneCursos_1.setText("");
		this.textPaneCursos_1 = textPaneCursos_1;
			
		JLabel lblSeleccionarCurso = new JLabel("Seleccionar Curso");
		lblSeleccionarCurso.setBounds(238, 127, 146, 21);
		getContentPane().add(lblSeleccionarCurso);
			
		JLabel lblNombre = new JLabel("[* nombre = nombre del Curso *]");
		lblNombre.setBounds(237, 146, 239, 21);
		getContentPane().add(lblNombre);
			
		JLabel lblIngreseNombre = new JLabel("Ingrese nombre:");
		lblIngreseNombre.setBounds(223, 179, 117, 15);
		getContentPane().add(lblIngreseNombre);
			
		textFieldNomCurso = new JTextField();
		textFieldNomCurso.setBounds(384, 179, 114, 19);
		
		getContentPane().add(textFieldNomCurso);
		textFieldNomCurso.setColumns(10);
			
		JButton btnSeleccionarCurso = new JButton("Seleccionar");
		btnSeleccionarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSeleccionarCursoActionPerformed(e);
			}
		});
		btnSeleccionarCurso.setBounds(238, 210, 117, 25);
		getContentPane().add(btnSeleccionarCurso);
			
		JButton btnCancelarCurso = new JButton("Cancelar");
		btnCancelarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarCursoActionPerformed(e);
			}
		});
		btnCancelarCurso.setBounds(381, 210, 117, 25);
		getContentPane().add(btnCancelarCurso);
			

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(197, 12, 17, 93);
		getContentPane().add(scrollBar);	

	}
	/*
	private boolean checkFormulario() {
		String nomProgFormacion = textFieldProgFormacion.getText();
		String nomCurso = textFieldNomCurso.getText();
		
		 if (nomProgFormacion.isEmpty() || nomCurso.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Agregar Socio",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
		 return true;
	}*/
	
	private boolean checkFormulario() {
		String nomProgFormacion = textFieldProgFormacion.getText();
		
		 if (nomProgFormacion.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Agregar Socio",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
		 return true;
	}
	
	private boolean checkFormularioAux() {		
		String nomCurso = textFieldNomCurso.getText();
		
		 if ( nomCurso.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Agregar Socio",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
		 return true;
	}
	
	protected void btnSeleccionarProgFActionPerformed(ActionEvent arg0) {
		String nomProg = textFieldProgFormacion.getText();
		if(checkFormulario()) {
			try {
				ArrayList<DtCursoBase> cursos = icon.seleccionarProgFormacion(nomProg);
				
				String datos= "CURSOS\n";
				for(DtCursoBase dt: cursos) {
					datos = datos +"\n"+ dt.toString();
				}
				textPaneCursos_1.setText(datos);
				
				
			}catch(ExisteProgramaException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error el nombre del Programa de Formacion "+nomProg+" no es correcto", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	protected void btnCancelarProgramaActionPerformed(ActionEvent arg0) {
		setVisible(false); 
		
		textFieldProgFormacion.setText("");
		
	}
	
	protected void btnSeleccionarCursoActionPerformed(ActionEvent arg0) {
		String nomCurso = textFieldNomCurso.getText();
		if(checkFormularioAux()) {
			try {
				//btnCancelarTodo.setVisible(true);
				//btnConfirmarAgregar.setVisible(true);
				icon.seleccionarCurso(nomCurso);
				
			}catch(ExisteCursoException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error el nombre del Curso "+nomCurso+" no es correcto", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

	protected void btnCancelarCursoActionPerformed(ActionEvent arg0) {
		setVisible(false); 
		//textPaneProgFormacion_1.setText("");
		textFieldProgFormacion.setText("");
		textFieldNomCurso.setText("");
		textPaneCursos_1.setText("");
		
		//getContentPane().setVisible(false);
	}
	
	protected void btnConfirmarAgregarActionPerformed(ActionEvent arg0) {
		icon.confirmar();
		JOptionPane.showMessageDialog(this, "OPERACION EXITOSA ", "", JOptionPane.INFORMATION_MESSAGE);
		setVisible(false);	
		//textPaneProgFormacion_1.setText("");
		textFieldProgFormacion.setText("");
		textFieldNomCurso.setText("");
		textPaneCursos_1.setText(""); 
		
	}
		
	protected void btnCancelarTodoActionPerformed(ActionEvent arg0) {
		setVisible(false);	
		//textPaneProgFormacion_1.setText("");
		textFieldProgFormacion.setText("");
		textFieldNomCurso.setText("");
		textPaneCursos_1.setText(""); 
			//getContentPane().setVisible(false);
		}
}
