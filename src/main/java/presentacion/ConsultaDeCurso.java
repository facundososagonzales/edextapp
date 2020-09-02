package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JFormattedTextField;

public class ConsultaDeCurso extends JInternalFrame {
	private JTextField textFieldNomInstituto;
	private JTextField textFieldNomCurso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaDeCurso frame = new ConsultaDeCurso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultaDeCurso() {
		setTitle("CONSULTA DE CURSO");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JPanel panelNombreInstituto = new JPanel();
		panelNombreInstituto.setBounds(25, 12, 386, 114);
		getContentPane().add(panelNombreInstituto);
		panelNombreInstituto.setLayout(null);
		
		JLabel lblNombreInstituto = new JLabel("Nombre Instituto:");
		lblNombreInstituto.setBounds(23, 12, 136, 15);
		panelNombreInstituto.add(lblNombreInstituto);
		
		textFieldNomInstituto = new JTextField();
		textFieldNomInstituto.setBounds(166, 10, 114, 19);
		panelNombreInstituto.add(textFieldNomInstituto);
		textFieldNomInstituto.setColumns(10);
		
		JButton btnConsultarInsituto = new JButton("Consultar");
		btnConsultarInsituto.setBounds(165, 41, 103, 25);
		panelNombreInstituto.add(btnConsultarInsituto);
		
		JPanel panelListadoCursos = new JPanel();
		panelListadoCursos.setBounds(25, 138, 386, 103);
		getContentPane().add(panelListadoCursos);
		panelListadoCursos.setLayout(null);
		
		JLabel lblNombreCurso = new JLabel("Nombre Curso:");
		lblNombreCurso.setBounds(145, 12, 105, 15);
		panelListadoCursos.add(lblNombreCurso);
		
		textFieldNomCurso = new JTextField();
		textFieldNomCurso.setBounds(260, 10, 114, 19);
		panelListadoCursos.add(textFieldNomCurso);
		textFieldNomCurso.setColumns(10);
		
		JButton btnConsultarCurso = new JButton("Consultar");
		btnConsultarCurso.setBounds(260, 41, 103, 25);
		panelListadoCursos.add(btnConsultarCurso);

	}
}
