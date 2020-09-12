package presentacion;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IControladorConsultaEdicionCurso;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextPane;

import datatypes.DtEdicionDetalle;

public class ConsultaEdicionCursoFrame extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private IControladorConsultaEdicionCurso iccec;
	protected JComboBox<String> comboBoxSelInstituto;
	protected JComboBox<String> comboBoxSelCurso;
	protected JComboBox<String> comboBoxSelEdicion;
	protected JTextPane textPaneEdicionCurso;
	
	
	public ConsultaEdicionCursoFrame(IControladorConsultaEdicionCurso iccec) {
		this.iccec=iccec;
		setResizable(true);
	    setIconifiable(true);
	    setMaximizable(true);
	    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    setClosable(true);
        setTitle("Consulta de Edicion de Curso");
		setBounds(100, 100, 592, 318);
		getContentPane().setLayout(null);
		
		JLabel lblSelInstituto = new JLabel("Seleccione Instituto:");
		lblSelInstituto.setBounds(28, 31, 139, 20);
		getContentPane().add(lblSelInstituto);
		
		JButton btnConfirmarIns_1 = new JButton("Salir");
		btnConfirmarIns_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnConfirmarIns_1.setBounds(460, 243, 89, 23);
		getContentPane().add(btnConfirmarIns_1);
		
		JComboBox<String> comboBoxSelInstituto = new JComboBox<String>();
		comboBoxSelInstituto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verCursos();
				
			}
			
		});
		this.comboBoxSelInstituto = comboBoxSelInstituto;
		comboBoxSelInstituto.setBounds(162, 30, 111, 22);
		getContentPane().add(comboBoxSelInstituto);
		
		JLabel lblSelEdicion = new JLabel("Seleccionar Edicion:");
		lblSelEdicion.setBounds(28, 170, 105, 14);
		getContentPane().add(lblSelEdicion);
		
		JComboBox<String> comboBoxSelCurso = new JComboBox<String>();
		comboBoxSelCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verEdicion();
			}
		});
		comboBoxSelCurso.setBounds(162, 97, 111, 23);
		getContentPane().add(comboBoxSelCurso);
		this.comboBoxSelCurso = comboBoxSelCurso;
		
		JLabel lblSelCurso_1 = new JLabel("Seleccionar Curso:");
		lblSelCurso_1.setBounds(28, 101, 105, 14);
		getContentPane().add(lblSelCurso_1);
		
		JComboBox<String> comboBoxSelEdicion = new JComboBox<String>();
		comboBoxSelEdicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verEdicionDetalle();
			}
		});
		comboBoxSelEdicion.setBounds(162, 161, 111, 23);
		getContentPane().add(comboBoxSelEdicion);
		this.comboBoxSelEdicion = comboBoxSelEdicion;
		
		JTextPane textPaneEdicionCurso = new JTextPane();
		textPaneEdicionCurso.setBounds(291, 49, 259, 137);
		this.textPaneEdicionCurso = textPaneEdicionCurso;
		getContentPane().add(textPaneEdicionCurso);
		JScrollPane sp = new JScrollPane(textPaneEdicionCurso, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//getContentPane().add();

		 sp.setBounds(291, 49, 259, 137);
		getContentPane().add(sp);
		
		JLabel lblEdiciondeCurso = new JLabel("Informacion de Edicion de Curso:");
		lblEdiciondeCurso.setBounds(291, 34, 170, 14);
		getContentPane().add(lblEdiciondeCurso);

	}
	
	public void inicializarInstituto() {
		List <String> instituto =this.iccec.listarInstituto();
		String[] inst = new String[instituto.size()];
		   int i=0;
		   for(String s: instituto) {
		        	inst[i]=s;
		        	i++;
		        }
		        
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(inst);
		comboBoxSelInstituto.setModel(model);
		comboBoxSelInstituto.setSelectedIndex(0);


	}
	
	
	public void verCursos() {
		this.iccec.ingresarInstituto(comboBoxSelInstituto.getSelectedItem().toString());
		List<String> curso= this.iccec.listarCurso();
		if (!curso.isEmpty()) {
			String[] cur = new String[curso.size()];
			   int i=0;
			   for(String s: curso) {
			        	cur[i]=s;
			        	i++;
			        }
			        
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(cur);
			comboBoxSelCurso.setModel(model);
			comboBoxSelCurso.setEnabled(true);
			comboBoxSelCurso.setSelectedIndex(0);
				
		}
		else {
			comboBoxSelCurso.setEnabled(false);
			comboBoxSelCurso.setSelectedIndex(-1);
		}
	}
	
	public void verEdicion() {
		if (comboBoxSelCurso.getSelectedIndex()!=-1) {
			this.iccec.ingresarCurso(comboBoxSelCurso.getSelectedItem().toString());
			List<String> edicion= this.iccec.listarEdicion();
			if (!edicion.isEmpty()) {
				String[] edi = new String[edicion.size()];
				   int i=0;
				   for(String s: edicion) {
				        	edi[i]=s;
				        	i++;
				        }
				        
				DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(edi);
				comboBoxSelEdicion.setModel(model);
				comboBoxSelEdicion.setEnabled(true);
				comboBoxSelEdicion.setSelectedIndex(0);
					
			}
			else {
				comboBoxSelEdicion.setEnabled(false);
				comboBoxSelEdicion.setSelectedIndex(-1);
			}
		}else {
			comboBoxSelEdicion.setEnabled(false);
			comboBoxSelEdicion.setSelectedIndex(-1);
		}
	}
	
	
	
	public void verEdicionDetalle() {
		if (comboBoxSelEdicion.getSelectedIndex()!=-1) {
			this.iccec.ingresarEdicion(comboBoxSelEdicion.getSelectedItem().toString());
			DtEdicionDetalle dtEdicionFinal = this.iccec.SeleccionarEdicion();
			List<String> docentes = iccec.listarDocentes();
			String datosEdicion ="Datos de la Edicion:";
			DateFormat date = new SimpleDateFormat("dd MMMM yyyy");
			String strDate = date.format(dtEdicionFinal.getFechaI());
			String strDate1 = date.format(dtEdicionFinal.getFechaF());
			
			datosEdicion = datosEdicion + "\n" + "Nombre:"+dtEdicionFinal.getNombre()+"\n"+"Fecha Inicio:"+strDate+
					"\n"+"Fecha Final:"+strDate1+"\n"+"Cupos:"+dtEdicionFinal.getCupos()+"\n"+"Fecha Pub:"+dtEdicionFinal.getFechaPub()+"\n"+"Docentes: "+ "\n";
			for (String s: docentes){ 
				datosEdicion=datosEdicion+s+"\n";
			}
			textPaneEdicionCurso.setText(datosEdicion);
		}
	}
}
