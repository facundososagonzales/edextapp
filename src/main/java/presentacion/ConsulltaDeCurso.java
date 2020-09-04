package presentacion;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;

import datatypes.DtCursoBase;
import datatypes.DtCursoDetalle;
import datatypes.DtProgCurso;
import excepciones.ExisteCursoException;
import excepciones.ExisteInstitutoException;
import excepciones.ExisteProgramaException;
import interfaces.IControladorConsultaDeCurso;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ConsulltaDeCurso extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNomInstituto;
	private JTextField textFieldNomCurso;
	private JTextField textFieldConsultaExtr;
	private IControladorConsultaDeCurso icon;
	private JTextPane textPaneListadoCursos;
	private JButton btnConsultarCurso;
//	private JButton btnConsultarEdicion; 
	private JButton btnConsultarProgformacion;
	private JButton btnCancelarCurso;
	private JButton btnSalir;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsulltaDeCurso frame = new ConsulltaDeCurso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ConsulltaDeCurso(IControladorConsultaDeCurso icon) {
		this.icon = icon;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setTitle("CONSULTA DE CURSO");
		setBounds(100, 100, 511, 362);
		getContentPane().setLayout(null);
		
		JLabel lblNombreInstituto = new JLabel("Nombre Instituto:");
		lblNombreInstituto.setBounds(181, 12, 125, 15);
		getContentPane().add(lblNombreInstituto);
		
		textFieldNomInstituto = new JTextField();
		textFieldNomInstituto.setBounds(314, 10, 114, 19);
		getContentPane().add(textFieldNomInstituto);
		textFieldNomInstituto.setColumns(10);
		
		JButton btnConsultarInstituto = new JButton("Consultar");
		btnConsultarInstituto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaInstitutoActionPerformed(e);
			}
		});
		btnConsultarInstituto.setBounds(311, 43, 117, 25);
		getContentPane().add(btnConsultarInstituto);
		
		JTextPane textPaneListadoCursos = new JTextPane();
		textPaneListadoCursos.setBounds(37, 12, 137, 158);
		getContentPane().add(textPaneListadoCursos);
		
		JLabel lblNombreCurso = new JLabel("Nombre Curso:");
		lblNombreCurso.setBounds(192, 96, 114, 15);
		getContentPane().add(lblNombreCurso);
		
		textFieldNomCurso = new JTextField();
		textFieldNomCurso.setBounds(314, 94, 114, 19);
		getContentPane().add(textFieldNomCurso);
		textFieldNomCurso.setColumns(10);
		textFieldNomCurso.setVisible(false);
		
		JButton btnConsultarCurso = new JButton("Consultar");
		btnConsultarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaCursoActionPerformed(e);
			}
		});
		btnConsultarCurso.setBounds(311, 123, 117, 25);
		getContentPane().add(btnConsultarCurso);
		btnConsultarCurso.setVisible(false);
		
		textFieldConsultaExtr = new JTextField();
		textFieldConsultaExtr.setBounds(254, 233, 114, 19);
		getContentPane().add(textFieldConsultaExtr);
		textFieldConsultaExtr.setColumns(10);
		textFieldConsultaExtr.setVisible(false);
		
		JButton btnConsultarEdicion = new JButton("Consultar Edicion");
		btnConsultarEdicion.setBounds(37, 264, 165, 25);
		getContentPane().add(btnConsultarEdicion);
		btnConsultarEdicion.setVisible(false);
		
		JButton btnConsultarProgformacion = new JButton("Consultar ProgFormacion");
		btnConsultarProgformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
			}
		});
		
		btnConsultarProgformacion.setBounds(213, 264, 215, 25);
		getContentPane().add(btnConsultarProgformacion);
		btnConsultarProgformacion.setVisible(false);
		
		JLabel lblConsultarProgramaDe = new JLabel("Consultar Programa de Formacion o Edicion ");
		lblConsultarProgramaDe.setBounds(37, 192, 322, 15);
		getContentPane().add(lblConsultarProgramaDe);
		
		JLabel lblIngreseNombreA = new JLabel("Ingrese Nombre a Consultar:");
		lblIngreseNombreA.setBounds(37, 235, 217, 15);
		getContentPane().add(lblIngreseNombreA);
		
		JButton btnCancelarInstituto = new JButton("Cancelar");
		btnCancelarInstituto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarInstitutoActionPerformed(e);
			}
		});
		btnCancelarInstituto.setBounds(189, 43, 117, 25);
		getContentPane().add(btnCancelarInstituto);
		
		JButton btnCancelarCurso = new JButton("Cancelar");
		btnCancelarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarCursoActionPerformed(e);
			
			}
		});
		btnCancelarCurso.setBounds(182, 123, 117, 25);
		getContentPane().add(btnCancelarCurso);
		btnCancelarCurso.setVisible(false);
		
		JLabel lblIngreseNombre = new JLabel("[* Ingrese nombre del Progrma de Formacion o de Edicion *]");
		lblIngreseNombre.setBounds(37, 208, 436, 15);
		getContentPane().add(lblIngreseNombre);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSalirActionPerformed(e);
			}
		});
		btnSalir.setBounds(35, 293, 117, 25);
		getContentPane().add(btnSalir);
		btnSalir.setVisible(false);

	}
	
	protected void consultaInstitutoActionPerformed(ActionEvent arg0) {
		String nomInstituto = textFieldNomInstituto.getText();
		ArrayList<DtCursoBase> cursos = new ArrayList<>();
		
		if(checkFormulario()) {
			String info;
			
			try {
				
				cursos = icon.ingresarInstituto(nomInstituto);
				info = "LISTADO_DE_SOCIOS";
				textPaneListadoCursos.setText("");
				for(DtCursoBase dt: cursos) {
					info = info + "\n\n"+ dt.toString();
				}
				textPaneListadoCursos.setText(info);
				textFieldNomCurso.setVisible(true);
				btnConsultarCurso.setVisible(true);
				btnCancelarCurso.setVisible(true);
			}catch(ExisteInstitutoException e) {
				
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error el nombre del instituto "+nomInstituto+" no es correcto", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}
	
	protected void btnCancelarInstitutoActionPerformed(ActionEvent arg0) {
		textPaneListadoCursos.setText("");
		textFieldNomInstituto.setText("");
		setVisible(false); 
		//getContentPane().setVisible(false);
	}
	
	private boolean checkFormulario() {
		String nomInstituto = textFieldNomInstituto.getText();
		String nomCurso = textFieldNomCurso.getText();
		String nomExtra = textFieldConsultaExtr.getText();
		
		 if (nomInstituto.isEmpty() || nomCurso.isEmpty()|| nomExtra.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Agregar Socio",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
		 return true;
	}
	
	protected void consultaCursoActionPerformed(ActionEvent arg0) {
		String nomCurso = textFieldNomCurso.getText();
		if(checkFormulario()) {
			try {
				textPaneListadoCursos.setText("");
				DtCursoDetalle dt = icon.seleccionarCurso(nomCurso);
				String infoC = "DATOS DEL CURSO SELECCIONADO: \n\n" + dt.toString();
				textPaneListadoCursos.setText(infoC);
				textFieldConsultaExtr.setVisible(true);
				btnConsultarProgformacion.setVisible(true);
				btnSalir.setVisible(true);
				
			}catch(ExisteCursoException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error el nombre del Curso "+nomCurso+" no es correcto", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	protected void btnCancelarCursoActionPerformed(ActionEvent arg0) {
		textPaneListadoCursos.setText("");
		textFieldNomInstituto.setText("");
		textFieldNomCurso.setText("");
		setVisible(false); 
		//getContentPane().setVisible(false);
	}
	
	protected void consultarProgFormacionActionPerformed(ActionEvent arg0) {
		String nomPf = textFieldConsultaExtr.getText();
		if(checkFormulario()) {
			try {
				DtProgCurso dt = icon.seleccionarPrograma(nomPf);
				String infoProg = "PROGRAMA DE FORMACION: \n"+dt.toString();
				JOptionPane.showMessageDialog(this, "", "Informacion: "+infoProg, JOptionPane.INFORMATION_MESSAGE);
			}catch(ExisteProgramaException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error el nombre del Curso "+nomPf+" no es correcto", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	protected void btnSalirActionPerformed(ActionEvent arg0) {
		textPaneListadoCursos.setText("");
		textFieldNomInstituto.setText("");
		textFieldNomCurso.setText("");
		textFieldConsultaExtr.setText("");
		setVisible(false); 
		//getContentPane().setVisible(false);
	}
	
}
