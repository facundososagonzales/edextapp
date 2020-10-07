package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import excepciones.EstudianteInscriptoException;
import interfaces.IControladorInsEdicionCurso;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.awt.event.ActionEvent;

public class InscripcionEdicionCursoFrame extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNick;
	private JTextField textFieldDia;
	protected JComboBox<String> instituto;
	protected JComboBox<String> comboBoxCurso;
	protected JComboBox<String> comboBoxEdicion;
	private IControladorInsEdicionCurso iciec;
	private JTextField textFieldMes;
	private JTextField textFieldAnio;

	
	public InscripcionEdicionCursoFrame(IControladorInsEdicionCurso iciec) {
		this.iciec=iciec;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		
		JLabel lblNewLabelInstituto = new JLabel("Institutos");
		lblNewLabelInstituto.setBounds(10, 39, 62, 14);
		getContentPane().add(lblNewLabelInstituto);
		
		instituto = new JComboBox<String>();
		instituto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarCursos();
			}
		});
		instituto.setBounds(107, 36, 277, 20);
		getContentPane().add(instituto);
		
		JLabel lblNewLabelCursos = new JLabel("Cursos");
		lblNewLabelCursos.setBounds(10, 70, 46, 14);
		getContentPane().add(lblNewLabelCursos);
		
		comboBoxCurso = new JComboBox<String>();
		comboBoxCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarEdiciones();
			}
		});
		comboBoxCurso.setBounds(107, 67, 277, 20);
		getContentPane().add(comboBoxCurso);
		
		comboBoxEdicion = new JComboBox<String>();
		comboBoxEdicion.setBounds(107, 98, 277, 20);
		getContentPane().add(comboBoxEdicion);
		
		JLabel lblNewLabelEdicion = new JLabel("Edicion");
		lblNewLabelEdicion.setBounds(10, 101, 46, 14);
		getContentPane().add(lblNewLabelEdicion);
		
		JLabel lblNewLabel = new JLabel("Estudiante (nick)");
		lblNewLabel.setBounds(10, 143, 101, 14);
		getContentPane().add(lblNewLabel);
		
		textFieldNick = new JTextField();
		textFieldNick.setBounds(166, 140, 108, 20);
		getContentPane().add(textFieldNick);
		textFieldNick.setColumns(10);
		
		JLabel lblNewLabelFechaIns = new JLabel("Fecha Inscripcion");
		lblNewLabelFechaIns.setBounds(10, 176, 101, 14);
		getContentPane().add(lblNewLabelFechaIns);
		
		textFieldDia = new JTextField();
		textFieldDia.setBounds(166, 173, 39, 20);
		getContentPane().add(textFieldDia);
		textFieldDia.setColumns(10);
		
		JButton btnNewButtonAceptar = new JButton("Aceptar");
		btnNewButtonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inscribirEstudiante();
			}
		});
		btnNewButtonAceptar.setBounds(204, 236, 89, 23);
		getContentPane().add(btnNewButtonAceptar);
		
		JButton btnNewButtonCancelar = new JButton("Cancelar");
		btnNewButtonCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent c) {
			limpiarFormulario();
			setVisible(false);
			}
		});
		btnNewButtonCancelar.setBounds(315, 236, 89, 23);
		getContentPane().add(btnNewButtonCancelar);
		
		textFieldMes = new JTextField();
		textFieldMes.setBounds(215, 173, 39, 20);
		getContentPane().add(textFieldMes);
		textFieldMes.setColumns(10);
		
		textFieldAnio = new JTextField();
		textFieldAnio.setBounds(264, 173, 39, 20);
		getContentPane().add(textFieldAnio);
		textFieldAnio.setColumns(10);
			
	}
	
	public void listarInstitutos() {
		List<String> institutos = this.iciec.listarInstitutos();
		String[] inst = new String[institutos.size()];
        int i=0;
        for(String s: institutos) {
        	inst[i]=s;
        	i++;
        }
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(inst);
		instituto.setModel(model);
		instituto.setSelectedIndex(0);
	}
	
	protected void listarCursos() {
		this.iciec.ingresarInstituto(instituto.getSelectedItem().toString());
		List<String> cursos = this.iciec.listarCursos();
		if(!cursos.isEmpty()) {
			String[] listCursos = new String[cursos.size()];
	        int i=0;
	        for(String s: cursos) {
	        	listCursos[i]=s;
	        	i++;
	        }
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(listCursos);
			comboBoxCurso.setModel(model);
			comboBoxCurso.setEnabled(true);
			comboBoxCurso.setSelectedIndex(0);
		}else {
			comboBoxCurso.setEnabled(false);
			comboBoxCurso.setSelectedIndex(-1);
		}
	}
	
	protected void listarEdiciones() {
		if (comboBoxCurso.getSelectedIndex()!=-1) {
			this.iciec.ingresarCursoInstituto(comboBoxCurso.getSelectedItem().toString());
			List<String> edicion= this.iciec.listarEdicion();
			if (!edicion.isEmpty()) {
				String[] edi = new String[edicion.size()];
				   int i=0;
				   for(String s: edicion) {
				        	edi[i]=s;
				        	i++;
				        }
				        
				DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(edi);
				comboBoxEdicion.setModel(model);
				comboBoxEdicion.setEnabled(true);
				comboBoxEdicion.setSelectedIndex(0);
					
			}
			else {
				comboBoxEdicion.setEnabled(false);
				comboBoxEdicion.setSelectedIndex(-1);
			}
		}else {
			comboBoxEdicion.setEnabled(false);
			comboBoxEdicion.setSelectedIndex(-1);
		}
	}
	
	public void inscribirEstudiante() {
		String nombre = textFieldNick.getText();
		String dia = textFieldDia.getText();
		String mes = textFieldMes.getText();
		String anio = textFieldAnio.getText();
		if(this.comboBoxEdicion.getSelectedIndex()!=-1) {
			String edicion = this.comboBoxEdicion.getSelectedItem().toString();
			if(checkFormulario()) {
				try {
					Date fechaIns = new GregorianCalendar(Integer.parseInt(anio), (Integer.parseInt(mes)-1), Integer.parseInt(dia)).getTime();
					this.iciec.inscripcionEstudiante(nombre, fechaIns, edicion);
					JOptionPane.showMessageDialog(this, "El estudiante ha sido inscripto", "Inscribir Estudiante", JOptionPane.INFORMATION_MESSAGE);
				} catch (EstudianteInscriptoException ei) {
					JOptionPane.showMessageDialog(this, ei.getMessage(), "El estudiante ya esta inscripto", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
	
	private boolean checkFormulario() {
	    String nombreU = this.textFieldNick.getText();
	    String dia = this.textFieldDia.getText();
	    String mes = this.textFieldMes.getText();
	    String anio = this.textFieldAnio.getText();

	    if (nombreU.isEmpty() || dia.isEmpty() || mes.isEmpty() || anio.isEmpty() ) {
	        JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Modificar datos del Usuario",
	                JOptionPane.ERROR_MESSAGE);
	        return false;
	    }
	    try {
			int dia1 = Integer.parseInt(dia);
			int mes1 = Integer.parseInt(mes);
			int anio1 = Integer.parseInt(anio);
			if(dia1<=31 && dia1>=1) {
				if(mes1<=12 && mes1>=1) {
					if(anio1<=2020 && anio1>=1900) {
						return true;
					}else {
						JOptionPane.showMessageDialog(this, "El anio debe estar entre 1900 y 2020", "Agregar Fecha", JOptionPane.ERROR_MESSAGE);
						this.textFieldAnio.setText("");
						return false;
					}
				}else {
					JOptionPane.showMessageDialog(this, "El mes debe estar entre 1 y 12", "Agregar Fecha", JOptionPane.ERROR_MESSAGE);
					this.textFieldMes.setText("");
					return false;
				}
			}else {
				JOptionPane.showMessageDialog(this, "El dia debe estar entre 1 y 31", "Agregar Fecha", JOptionPane.ERROR_MESSAGE);
				this.textFieldDia.setText("");
				return false;
			}
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "La fecha debe ser numerica", "Agregar Fecha", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	private void limpiarFormulario() {
	    textFieldNick.setText("");
	    textFieldDia.setText("");
	}
}