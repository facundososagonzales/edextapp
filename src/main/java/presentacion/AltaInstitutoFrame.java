package presentacion;



import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IControladorAltaInstituto;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import excepciones.InstitutoCargadoException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AltaInstitutoFrame extends JInternalFrame {
	private static final long serialVersionUID = 1L;

	private IControladorAltaInstituto icai;
	private JTextField nomIns;
	
	public AltaInstitutoFrame(IControladorAltaInstituto icai) {
		this.icai= icai;
		
		setResizable(true);
	    setIconifiable(true);
	    setMaximizable(true);
	    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    setClosable(true);
        setTitle("Alta de un Instituto");
		setBounds(100, 100, 600, 450);
		getContentPane().setLayout(null);
		
		nomIns = new JTextField();
		nomIns.setBounds(239, 98, 116, 18);
		getContentPane().add(nomIns);
		nomIns.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre Instituto:");
		lblNewLabel.setBounds(136, 102, 107, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnAltaInsConf = new JButton("Confirmar");
		btnAltaInsConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				altaInstitutoActionPerformed(e);
			}
			
		});
		btnAltaInsConf.setBounds(358, 371, 102, 23);
		getContentPane().add(btnAltaInsConf);
		
		JButton btnAltaInsCancelar = new JButton("Cancelar");
		btnAltaInsCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
	            setVisible(false);
			}
		});
		btnAltaInsCancelar.setBounds(469, 371, 89, 23);
		getContentPane().add(btnAltaInsCancelar);
		

	}
	
	protected void altaInstitutoActionPerformed(ActionEvent e){
		String nomIns = this.nomIns.getText();
			if (checkFormulario())
			{
				try {
					this.icai.darDeAltaInstituto(nomIns);
					JOptionPane.showMessageDialog(this, "El Instituto se ha Registrado con Exito ", "Alta Instituto", JOptionPane.INFORMATION_MESSAGE);
		            limpiarFormulario();
		            setVisible(false);
					}
				catch(InstitutoCargadoException a) {
					JOptionPane.showMessageDialog(this, "El Instituto ya Existe, Vuelva a Ingresar un Nombre Valido", "Alta Instituto", JOptionPane.ERROR_MESSAGE);
					 limpiarFormulario();
					 setVisible(true);
				}
			}
			
	}
	
	
	
	private void limpiarFormulario() {
        nomIns.setText("");
        }
	
	
	protected boolean checkFormulario(){
	
		String nomIns = this.nomIns.getText();
		if(nomIns.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Agregar Instituto", JOptionPane.ERROR_MESSAGE);
			return false;
			}
		else {
			return true;
		}
		
		
	}
}
