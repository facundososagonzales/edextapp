package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import excepcion.InstitutoCargadoException;
import excepcion.InstitutoNoCargadoException;
import interfaces.IControladorConsultaEdicionCurso;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaEdicionCursoFrame extends JInternalFrame {
	private JTextField textFieldIngreseInstituto;
	private IControladorConsultaEdicionCurso iccec;
	
	
	public ConsultaEdicionCursoFrame(IControladorConsultaEdicionCurso iccec) {
		this.iccec=iccec;
		setResizable(true);
	    setIconifiable(true);
	    setMaximizable(true);
	    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    setClosable(true);
        setTitle("Consulta de Edicion de Curso");
		setBounds(100, 100, 600, 450);
		getContentPane().setLayout(null);
		
		textFieldIngreseInstituto = new JTextField();
		textFieldIngreseInstituto.setBounds(146, 31, 86, 20);
		getContentPane().add(textFieldIngreseInstituto);
		textFieldIngreseInstituto.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ingrese Instituto:");
		lblNewLabel.setBounds(28, 31, 139, 20);
		getContentPane().add(lblNewLabel);
		
		JButton btnConfirmarIns = new JButton("Confirmar");
		btnConfirmarIns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnConfirmarIns.setBounds(361, 366, 89, 23);
		getContentPane().add(btnConfirmarIns);
		
		JButton btnConfirmarIns_1 = new JButton("Cancelar");
		btnConfirmarIns_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfirmarIns_1.setBounds(461, 366, 89, 23);
		getContentPane().add(btnConfirmarIns_1);

	}
	
	
	protected void ingresarInstitutoActionPerformed(ActionEvent e){
		String nomIns = textFieldIngreseInstituto.getText();
			if (checkFormulario())
			{
				try {
					this.iccec.ingresarInstituto(nomIns);
		            setVisible(false);
					}
				catch(InstitutoNoCargadoException a) {
					JOptionPane.showMessageDialog(this, "El Instituto ya Existe, Vuelva a Ingresar un Nombre Valido", "Alta Instituto", JOptionPane.ERROR_MESSAGE);
					 limpiarFormulario();
					 setVisible(true);
				}
			}
			
	}
	
	protected boolean checkFormulario(){
		
		String nomIns = this.textFieldIngreseInstituto.getText();
		if(nomIns.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Error al ingresar instituto", JOptionPane.ERROR_MESSAGE);
			return false;
			}
		else {
			return true;
		}
		
}
