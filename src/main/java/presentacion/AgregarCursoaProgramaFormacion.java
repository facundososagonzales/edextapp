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
import javax.swing.JScrollPane;

public class AgregarCursoaProgramaFormacion extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private IControladorAgregarCursoAProgDeFormacion icon;
	private JTextField textFieldProgFormacion;
	private JTextField textFieldNomCurso;
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
		setBounds(100, 100, 639, 413);
		getContentPane().setLayout(null);
		
		JTextPane textPaneProgFormacion_1 = new JTextPane();
		textPaneProgFormacion_1.setBounds(12, 12, 276, 129);
		getContentPane().add(textPaneProgFormacion_1);
		textPaneProgFormacion_1.setEditable(false);
		this.textPaneProgFormacion_1 =textPaneProgFormacion_1;
		JScrollPane sp = new JScrollPane(textPaneProgFormacion_1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		sp.setBounds(12, 12, 276, 129);
		getContentPane().add(sp);
		
				
		JLabel lblProgramaDeFormacion = new JLabel("Seleccionar Programa de Formacion");
		lblProgramaDeFormacion.setBounds(306, 12, 260, 15);
		getContentPane().add(lblProgramaDeFormacion);
		
		
		JLabel lblNombre_1 = new JLabel("[* nombre = nombre pFormacion *]");
		lblNombre_1.setBounds(316, 26, 251, 15);
		getContentPane().add(lblNombre_1);
		
		JLabel lblIngreseNombrePrograma = new JLabel("Ingrese nombre:");
		lblIngreseNombrePrograma.setBounds(313, 53, 142, 15);
		getContentPane().add(lblIngreseNombrePrograma);
		
		textFieldProgFormacion = new JTextField();
		textFieldProgFormacion.setBounds(452, 51, 114, 19);
		getContentPane().add(textFieldProgFormacion);
		textFieldProgFormacion.setColumns(10);
		
		JButton btnSeleccionarProgF = new JButton("Seleccionar");
		btnSeleccionarProgF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSeleccionarProgFActionPerformed(e);
			}
		});
		btnSeleccionarProgF.setBounds(323, 80, 117, 25);
		getContentPane().add(btnSeleccionarProgF);
		
		
		JButton btnCancelarProgF = new JButton("Cancelar");
		btnCancelarProgF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarProgramaActionPerformed(e);
			}
		});
		btnCancelarProgF.setBounds(449, 80, 117, 25);
		getContentPane().add(btnCancelarProgF);
		
		JTextPane textPaneCursos_1 = new JTextPane();
		textPaneCursos_1.setBounds(12, 169, 276, 129);
		getContentPane().add(textPaneCursos_1);
		textPaneCursos_1.setEditable(false);
		textPaneCursos_1.setText("");
		this.textPaneCursos_1 = textPaneCursos_1;
		
		JScrollPane sp2 = new JScrollPane(textPaneCursos_1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		sp2.setBounds(12, 169, 276, 129);
		getContentPane().add(sp2);
		
		
		JLabel lblSeleccionarCurso = new JLabel("Seleccionar Curso");
		lblSeleccionarCurso.setBounds(327, 190, 146, 21);
		getContentPane().add(lblSeleccionarCurso);
			
		JLabel lblNombre = new JLabel("[* nombre = nombre del Curso *]");
		lblNombre.setBounds(327, 211, 239, 21);
		getContentPane().add(lblNombre);
			
		JLabel lblIngreseNombre = new JLabel("Ingrese nombre:");
		lblIngreseNombre.setBounds(323, 244, 117, 15);
		getContentPane().add(lblIngreseNombre);
			
		textFieldNomCurso = new JTextField();
		textFieldNomCurso.setBounds(452, 242, 114, 19);
		
		getContentPane().add(textFieldNomCurso);
		textFieldNomCurso.setColumns(10);
			
		JButton btnAgregarCurso = new JButton("Agregar");
		btnAgregarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAgregarCursoActionPerformed(e);
			}
		});
		btnAgregarCurso.setBounds(323, 276, 117, 25);
		getContentPane().add(btnAgregarCurso);
			
		JButton btnCancelarCurso = new JButton("Cancelar");
		btnCancelarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarCursoActionPerformed(e);
			}
		});
		btnCancelarCurso.setBounds(449, 276, 117, 25);
		getContentPane().add(btnCancelarCurso);
			

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(197, 12, 17, 93);
		getContentPane().add(scrollBar);	

	}
	
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
		textPaneProgFormacion_1.setText("");
		textFieldProgFormacion.setText("");
		textFieldNomCurso.setText("");
		textPaneCursos_1.setText("");
		
	}
	
	protected void btnAgregarCursoActionPerformed(ActionEvent arg0) {
		String nomCurso = textFieldNomCurso.getText();
		if(checkFormularioAux()) {
			try {
				icon.seleccionarCurso(nomCurso);
				icon.confirmar();
				JOptionPane.showMessageDialog(this, "OPERACION EXITOSA ", "", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);	
				textFieldProgFormacion.setText("");
				textFieldNomCurso.setText("");
				textPaneCursos_1.setText(""); 
								
			}catch(ExisteCursoException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error el nombre del Curso "+nomCurso+" no es correcto", JOptionPane.ERROR_MESSAGE);
			}catch(ExisteProgramaException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(), "Ya existe progFormacion_curso", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

	protected void btnCancelarCursoActionPerformed(ActionEvent arg0) {
		setVisible(false); 
		textPaneProgFormacion_1.setText("");
		textFieldProgFormacion.setText("");
		textFieldNomCurso.setText("");
		textPaneCursos_1.setText("");
	}
	
	public void operacionListarTextPane() {
		
		ArrayList<DtInfoPFormacion> programas = icon.listarProgsFormacion();
		String datos = "PROGRAMAS DE FORMACION:\n";
		for(DtInfoPFormacion d: programas ) {
			datos = datos + "\n"+d.toString();
		}
		
		textPaneProgFormacion_1.setText(datos);				
	}
	
}
