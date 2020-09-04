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

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarCursoaProgramaFormacion extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IControladorAgregarCursoAProgDeFormacion icon;
	private JTextField textFieldProgFormacion;
	private JTextField textFieldNomCurso;
//	private JPanel panelProgsFormacion;
	private JPanel panel;
	private JButton btnCancelarTodo;
	private JButton btnConfirmarAgregar;
	private JTextPane textPaneCursos;
	private JTextPane textPaneProgFormacion;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
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
		
		JPanel panelProgsFormacion = new JPanel();
		panelProgsFormacion.setBounds(12, 12, 489, 117);
		getContentPane().add(panelProgsFormacion);
		panelProgsFormacion.setLayout(null);
		
		JTextPane textPaneProgFormacion = new JTextPane();
		textPaneProgFormacion.setBounds(12, 12, 208, 93);
		panelProgsFormacion.add(textPaneProgFormacion);
		//-----------
		ArrayList<DtInfoPFormacion> programas = icon.listarProgsFormacion();
		String datos = "PROGRAMAS DE FORMACION:\n";
		for(DtInfoPFormacion d: programas ) {
			datos = datos + "\n"+d.toString();
		}
		//-----------
		textPaneProgFormacion.setText(datos);
		
		JLabel lblIngreseNombrePrograma = new JLabel("Ingrese nombre:");
		lblIngreseNombrePrograma.setBounds(238, 53, 142, 15);
		panelProgsFormacion.add(lblIngreseNombrePrograma);
		
		JLabel lblProgramaDeFormacion = new JLabel("Seleccionar Programa de Formacion");
		lblProgramaDeFormacion.setBounds(229, 12, 260, 15);
		panelProgsFormacion.add(lblProgramaDeFormacion);
		
		textFieldProgFormacion = new JTextField();
		textFieldProgFormacion.setBounds(366, 51, 114, 19);
		panelProgsFormacion.add(textFieldProgFormacion);
		textFieldProgFormacion.setColumns(10);
		
		JButton btnSeleccionarInstituto = new JButton("Seleccionar");
		btnSeleccionarInstituto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSeleccionarInstitutoActionPerformed(e);
			}
		});
		btnSeleccionarInstituto.setBounds(232, 80, 117, 25);
		panelProgsFormacion.add(btnSeleccionarInstituto);
		
		JButton btnCancelarInstituto = new JButton("Cancelar");
		btnCancelarInstituto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarProgramaActionPerformed(e);
			}
		});
		btnCancelarInstituto.setBounds(363, 80, 117, 25);
		panelProgsFormacion.add(btnCancelarInstituto);
		
		JLabel lblNombre_1 = new JLabel("[* nombre = nombre pFormacion *]");
		lblNombre_1.setBounds(238, 26, 251, 15);
		panelProgsFormacion.add(lblNombre_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 134, 489, 117);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		JTextPane textPaneCursos = new JTextPane();
		textPaneCursos.setBounds(12, 12, 208, 93);
		panel.add(textPaneCursos);
		
		JLabel lblSeleccionarCurso = new JLabel("Seleccionar Curso");
		lblSeleccionarCurso.setBounds(226, 12, 146, 21);
		panel.add(lblSeleccionarCurso);
		
		JLabel lblNombre = new JLabel("[* nombre = nombre del Curso *]");
		lblNombre.setBounds(238, 27, 239, 21);
		panel.add(lblNombre);
		
		JLabel lblIngreseNombre = new JLabel("Ingrese nombre:");
		lblIngreseNombre.setBounds(238, 53, 117, 15);
		panel.add(lblIngreseNombre);
		
		textFieldNomCurso = new JTextField();
		textFieldNomCurso.setBounds(363, 51, 114, 19);
		panel.add(textFieldNomCurso);
		textFieldNomCurso.setColumns(10);
		
		JButton btnSeleccionarCurso = new JButton("Seleccionar");
		btnSeleccionarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSeleccionarCursoActionPerformed(e);
			}
		});
		btnSeleccionarCurso.setBounds(232, 80, 117, 25);
		panel.add(btnSeleccionarCurso);
		
		JButton btnCancelarCurso = new JButton("Cancelar");
		btnCancelarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarCursoActionPerformed(e);
			}
		});
		btnCancelarCurso.setBounds(363, 80, 117, 25);
		panel.add(btnCancelarCurso);
		
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
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnCancelarTodo.setBounds(257, 263, 117, 25);
		getContentPane().add(btnCancelarTodo);

	}
	
	private boolean checkFormulario() {
		String nomProgFormacion = textFieldProgFormacion.getText();
		String nomCurso = textFieldNomCurso.getText();
		
		 if (nomProgFormacion.isEmpty() || nomCurso.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Agregar Socio",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
		 return true;
	}
	
	protected void btnSeleccionarInstitutoActionPerformed(ActionEvent arg0) {
		String nomInst = textFieldProgFormacion.getText();
		if(checkFormulario()) {
			try {
				ArrayList<DtCursoBase> cursos = icon.seleccionarProgFormacion(nomInst);
				panel.setVisible(true);
				String datos= "CURSOS\n";
				for(DtCursoBase dt: cursos) {
					datos = datos +"\n"+ dt.toString();
				}
				textPaneCursos.setText(datos);
				
			}catch(ExisteProgramaException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error el nombre del instituto "+nomInst+" no es correcto", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	protected void btnCancelarProgramaActionPerformed(ActionEvent arg0) {
		textPaneProgFormacion.setText("");
		textFieldProgFormacion.setText("");
		setVisible(false); 
		//getContentPane().setVisible(false);
	}
	
	protected void btnSeleccionarCursoActionPerformed(ActionEvent arg0) {
		String nomCurso = textFieldNomCurso.getText();
		if(checkFormulario()) {
			try {
				btnCancelarTodo.setVisible(true);
				btnConfirmarAgregar.setVisible(true);
				icon.seleccionarCurso(nomCurso);
				
			}catch(ExisteCursoException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error el nombre del Curso "+nomCurso+" no es correcto", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

	protected void btnCancelarCursoActionPerformed(ActionEvent arg0) {
		textPaneProgFormacion.setText("");
		textFieldProgFormacion.setText("");
		textFieldNomCurso.setText("");
		textPaneCursos.setText("");
		setVisible(false); 
		//getContentPane().setVisible(false);
	}
	
	protected void btnConfirmarAgregarActionPerformed(ActionEvent arg0) {
		icon.confirmar();
		JOptionPane.showMessageDialog(this, "AGREGAR CURSO A PROGRAMA DE FORMACION", "OPERACION EXITOSA ", JOptionPane.INFORMATION_MESSAGE);
	}
		
	protected void btnCancelarTodoActionPerformed(ActionEvent arg0) {
			textPaneProgFormacion.setText("");
			textFieldProgFormacion.setText("");
			textFieldNomCurso.setText("");
			textPaneCursos.setText("");
			setVisible(false); 
			//getContentPane().setVisible(false);
		}
	
}
