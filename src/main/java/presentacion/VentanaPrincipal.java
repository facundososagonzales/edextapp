package presentacion;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import interfaces.Fabrica;
import interfaces.IControladorAgregarCursoAProgDeFormacion;
import interfaces.IControladorAltaUsuario;
import interfaces.IControladorConsultaDeCurso;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal {

	private JFrame frame;
	private AltaUsuarioFrame altaUsuarioFrame;
	private AgregarCursoaProgramaFormacion agregarCursoPf;
	private ConsultaDeCurso consultaCurso;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public VentanaPrincipal() {
		initialize();
		
		Fabrica fab = Fabrica.getInstancia();
		IControladorAltaUsuario icau = fab.getIControladorAltaUsuario();
		IControladorConsultaDeCurso icConsultaCurso = fab.getIControladorConsultaDeCurso();
		IControladorAgregarCursoAProgDeFormacion icAgregarCpf = fab.getIControladorAgregarCursoAProgDeFormacion();
		
		
		Dimension desktopSize = frame.getSize();
		Dimension jInternalFrameSize;
		
		altaUsuarioFrame = new AltaUsuarioFrame(icau); 
		jInternalFrameSize = altaUsuarioFrame.getSize();
		altaUsuarioFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		altaUsuarioFrame.setVisible(false);
		frame.getContentPane().add(altaUsuarioFrame);
		
	
		agregarCursoPf = new AgregarCursoaProgramaFormacion(icAgregarCpf); 
		jInternalFrameSize = agregarCursoPf.getSize();
		agregarCursoPf.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		agregarCursoPf.setVisible(false);
		frame.getContentPane().add(agregarCursoPf);
		
		consultaCurso = new ConsultaDeCurso(icConsultaCurso); 
		jInternalFrameSize = consultaCurso.getSize();
		consultaCurso.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		consultaCurso.setVisible(false);
		frame.getContentPane().add(consultaCurso);
		
		
		
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu(" Altas ");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 18));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Alta Usuario");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaUsuarioFrame.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmAgregarCursoA = new JMenuItem("Agregar Curso a ProgFormacion");
		mntmAgregarCursoA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarCursoPf.setVisible(true);
			}
		});
		mnNewMenu.add(mntmAgregarCursoA);
		
		JMenu mnNewMenuConsultas = new JMenu("Consultas");
		mnNewMenuConsultas.setFont(new Font("Segoe UI", Font.BOLD, 18));
		menuBar.add(mnNewMenuConsultas);
		
		JMenuItem mntmConsultaDeCurso = new JMenuItem("Consulta de Curso");
		mntmConsultaDeCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultaCurso.setVisible(true);
			}
		});
		mnNewMenuConsultas.add(mntmConsultaDeCurso);
		
		JMenu mnNewMenuSalir = new JMenu("Salir");
		mnNewMenuSalir.setFont(new Font("Segoe UI", Font.BOLD, 18));
		menuBar.add(mnNewMenuSalir);
		
		JMenuItem mntmNewMenuItemSalir = new JMenuItem("Salir");
		mntmNewMenuItemSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		mnNewMenuSalir.add(mntmNewMenuItemSalir);
	}
}
