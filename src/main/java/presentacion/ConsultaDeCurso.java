package presentacion;


import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;

import datatypes.DtCursoBase;
import datatypes.DtEdicionDetalle;
import datatypes.DtInfoProgCurso;
import datatypes.DtProgCurso;
import excepciones.ExisteCursoException;
import excepciones.ExisteInstitutoException;
import excepciones.ExisteNomEdicionException;
import excepciones.ExisteProgramaException;
import excepciones.ListaDeCursosVaciaException;
import interfaces.IControladorConsultaDeCurso;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class ConsultaDeCurso extends JInternalFrame {
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
	private JButton btnConsultarEdicion; 
	private JButton btnConsultarProgformacion;
	private JButton btnCancelarCurso;
	private JButton btnSalir;
		public ConsultaDeCurso(IControladorConsultaDeCurso icon) {
		this.icon = icon;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setTitle("CONSULTA DE CURSO");
		setBounds(100, 100, 649, 435);
		getContentPane().setLayout(null);
		
		JLabel lblNombreInstituto = new JLabel("Nombre Instituto:");
		lblNombreInstituto.setBounds(322, 14, 125, 15);
		getContentPane().add(lblNombreInstituto);
		
		textFieldNomInstituto = new JTextField();
		textFieldNomInstituto.setBounds(465, 12, 114, 19);
		getContentPane().add(textFieldNomInstituto);
		textFieldNomInstituto.setColumns(10);
		
		JButton btnConsultarInstituto = new JButton("Consultar");
		btnConsultarInstituto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaInstitutoActionPerformed(e);
			}
		});
		btnConsultarInstituto.setBounds(475, 43, 117, 25);
		getContentPane().add(btnConsultarInstituto);
		
		JTextPane textPaneListadoCursos = new JTextPane();
		textPaneListadoCursos.setEditable(false);
		textPaneListadoCursos.setBounds(37, 12, 137, 158);
		getContentPane().add(textPaneListadoCursos);
		this.textPaneListadoCursos = textPaneListadoCursos;
		
		JLabel lblNombreCurso = new JLabel("Nombre Curso:");
		lblNombreCurso.setBounds(333, 127, 114, 15);
		getContentPane().add(lblNombreCurso);
		
		textFieldNomCurso = new JTextField();
		textFieldNomCurso.setBounds(465, 125, 114, 19);
		getContentPane().add(textFieldNomCurso);
		textFieldNomCurso.setColumns(10);
		textFieldNomCurso.setVisible(false);
		
		JButton btnConsultarCurso = new JButton("Consultar");
		btnConsultarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaCursoActionPerformed(e);
			}
		});
		btnConsultarCurso.setBounds(475, 161, 117, 25);
		getContentPane().add(btnConsultarCurso);
		btnConsultarCurso.setVisible(false);
		this.btnConsultarCurso =btnConsultarCurso; 
		
		textFieldConsultaExtr = new JTextField();
		textFieldConsultaExtr.setBounds(257, 274, 114, 19);
		getContentPane().add(textFieldConsultaExtr);
		textFieldConsultaExtr.setColumns(10);
		textFieldConsultaExtr.setVisible(false);
		
		JButton btnConsultarEdicion = new JButton("Consultar Edicion");
		btnConsultarEdicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultarEdicionActionPerformed(e);
			}
		});
		btnConsultarEdicion.setBounds(37, 305, 165, 25);
		this.btnConsultarEdicion = btnConsultarEdicion;
		getContentPane().add(btnConsultarEdicion);
		btnConsultarEdicion.setVisible(false);
		
		JButton btnConsultarProgformacion = new JButton("Consultar ProgFormacion");
		btnConsultarProgformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarProgFormacionActionPerformed(e);
			}
		});
		this.btnConsultarProgformacion = btnConsultarProgformacion;
			btnConsultarProgformacion.setBounds(232, 305, 215, 25);
		getContentPane().add(btnConsultarProgformacion);
		btnConsultarProgformacion.setVisible(false);
		
		JLabel lblConsultarProgramaDe = new JLabel("Consultar Programa de Formacion o Edicion ");
		lblConsultarProgramaDe.setBounds(37, 220, 322, 15);
		getContentPane().add(lblConsultarProgramaDe);
		
		JLabel lblIngreseNombreA = new JLabel("Ingrese Nombre a Consultar:");
		lblIngreseNombreA.setBounds(37, 278, 217, 15);
		getContentPane().add(lblIngreseNombreA);
		
		JButton btnCancelarInstituto = new JButton("Cancelar");
		btnCancelarInstituto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarInstitutoActionPerformed(e);
			}
		});
		btnCancelarInstituto.setBounds(332, 43, 117, 25);
		getContentPane().add(btnCancelarInstituto);
		
		JButton btnCancelarCurso = new JButton("Cancelar");
		btnCancelarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarCursoActionPerformed(e);
			
			}
		});
		btnCancelarCurso.setBounds(330, 161, 117, 25);
		getContentPane().add(btnCancelarCurso);
		btnCancelarCurso.setVisible(false);
		this.btnCancelarCurso=btnCancelarCurso; 
		JLabel lblIngreseNombre = new JLabel("[* Ingrese nombre del Progrma de Formacion o de Edicion *]");
		lblIngreseNombre.setBounds(37, 247, 436, 15);
		getContentPane().add(lblIngreseNombre);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSalirActionPerformed(e);
			}
		});
		btnSalir.setBounds(37, 342, 117, 25);
		getContentPane().add(btnSalir);
		btnSalir.setVisible(false);
		this.btnSalir=btnSalir;
		
		
		
		 JScrollPane sp = new JScrollPane(textPaneListadoCursos, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		 sp.setBounds(37, 12, 256, 196);
		 getContentPane().add(sp);
		
	}
	
	protected void consultaInstitutoActionPerformed(ActionEvent arg0) {
		String nomInstituto = textFieldNomInstituto.getText();
		ArrayList<DtCursoBase> cursos = new ArrayList<>();
		
		if(checkFormularioIns()) {
			String info;
		
			cursos = icon.ingresarInstituto(nomInstituto);
			if(!cursos.isEmpty()) {
					info = ".:LISTADO_DE_CURSOS:.";
					textPaneListadoCursos.setText("");
					for(DtCursoBase dt: cursos) {
						info = info + "\n\n"+ dt.toString();
					}
					textPaneListadoCursos.setText(info);
					textFieldNomCurso.setVisible(true);
					btnConsultarCurso.setVisible(true);
					btnCancelarCurso.setVisible(true);
					
			}else {
				JOptionPane.showMessageDialog(this, "El Instituto no Existe/ o / No hay cursos en el Sistema", "..: ERROR :..", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}
	
	protected void btnCancelarInstitutoActionPerformed(ActionEvent arg0) {
		textPaneListadoCursos.setText("");
		textFieldNomInstituto.setText("");
		setVisible(false); 
		//getContentPane().setVisible(false);
	}
	
	private boolean checkFormularioIns() {
		String nomInstituto = textFieldNomInstituto.getText();
		 if (nomInstituto.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "No puede haber campos vac�os", "Agregar Socio",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
		 return true;
	}
	
	private boolean checkFormularioCur() {
		String nomCurso = textFieldNomCurso.getText();
		
		 if (nomCurso.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "No puede haber campos vac�os", "Agregar Socio",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
		 return true;
	}
	
	private boolean checkFormularioExt() {
		String nomExtra = textFieldConsultaExtr.getText();
		
		 if (nomExtra.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "No puede haber campos vac�os", "Agregar Socio",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
		 return true;
	}
		
	protected void consultaCursoActionPerformed(ActionEvent arg0) {
		String nomCurso = textFieldNomCurso.getText();
		if(checkFormularioCur()) {
			
			
			textPaneListadoCursos.setText("");
			DtInfoProgCurso dt = icon.seleccionarCurso(nomCurso);
			if(dt.getTexto() != null) {
				String infoC = "DATOS DEL CURSO SELECCIONADO: \n\n" + dt.toString();
				textPaneListadoCursos.setText(infoC);
				textFieldConsultaExtr.setVisible(true);
				btnConsultarProgformacion.setVisible(true);
				btnConsultarEdicion.setVisible(true);
				btnSalir.setVisible(true);
				
			}else {
				JOptionPane.showMessageDialog(this, "No existe el Curso", "...: ERROR :...", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	protected void btnCancelarCursoActionPerformed(ActionEvent arg0) {
		textPaneListadoCursos.setText("");
		textFieldNomInstituto.setText("");
		textFieldNomCurso.setText("");
		textFieldConsultaExtr.setText("");
		setVisible(false); 
	}
	
	protected void consultarProgFormacionActionPerformed(ActionEvent arg0) {
		String nomPf = textFieldConsultaExtr.getText();
		if(checkFormularioExt()) {
		
			DtProgCurso dt = icon.seleccionarPrograma(nomPf);
			if(dt != null) {
				String infoProg = "PROGRAMA DE FORMACION: \n"+dt.toString();
				JOptionPane.showMessageDialog(this, infoProg, "Informacion de Programa de Formacion: "+"", JOptionPane.INFORMATION_MESSAGE);
				textPaneListadoCursos.setText("");
				textFieldNomInstituto.setText("");
				textFieldNomCurso.setText("");
				textFieldConsultaExtr.setText("");
				setVisible(false); 
			}else{
				JOptionPane.showMessageDialog(this, "No existe el programa ", "Error el nombre del Programa "+nomPf+" no es correcto", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	protected void btnConsultarEdicionActionPerformed(ActionEvent arg0) {
		String nomEd = textFieldConsultaExtr.getText();
		if(checkFormularioExt()) {
			
			DtEdicionDetalle dt = icon.seleccionarEdicion(nomEd);
			
			if(dt != null){
				String infoEd = "EDICION: \n"+dt.toString();
				JOptionPane.showMessageDialog(this, infoEd, "Informacion de Edicion: "+"", JOptionPane.INFORMATION_MESSAGE);
				textPaneListadoCursos.setText("");
				textFieldNomInstituto.setText("");
				textFieldNomCurso.setText("");
				textFieldConsultaExtr.setText("");
				setVisible(false); 
			}else {
				JOptionPane.showMessageDialog(this, "La edicion no existe", "Error el nombre de la Edicion "+nomEd+" no es correcto", JOptionPane.ERROR_MESSAGE);
			
			}
		}	
		
	}
	
	protected void btnSalirActionPerformed(ActionEvent arg0) {
		textPaneListadoCursos.setText("");
		textFieldNomInstituto.setText("");
		textFieldNomCurso.setText("");
		textFieldConsultaExtr.setText("");
		setVisible(false); 
	}
}

