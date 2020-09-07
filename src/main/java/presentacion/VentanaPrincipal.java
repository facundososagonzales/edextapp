package presentacion;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import interfaces.Fabrica;
import interfaces.IControladorAltaInstituto;
import interfaces.IControladorAltaUsuario;
import interfaces.IControladorConsultaEdicionCurso;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal {

	private JFrame frame;
	private AltaUsuarioFrame altaUsuarioFrame;
	private AltaInstitutoFrame altaInstitutoFrame;
	private ConsultaEdicionCursoFrame consultaEdicionCursoFrame;

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
		IControladorAltaInstituto icai = fab.getIControladorAltaInstituto();
		IControladorConsultaEdicionCurso iccec = fab.getIControladorConsultaEdicionCurso();
		Dimension desktopSize = frame.getSize();
		Dimension jInternalFrameSize;
		
		altaUsuarioFrame = new AltaUsuarioFrame(icau); 	
		jInternalFrameSize = altaUsuarioFrame.getSize();
		altaUsuarioFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		altaUsuarioFrame.setVisible(false);
		frame.getContentPane().add(altaUsuarioFrame);
		
		
		altaInstitutoFrame = new AltaInstitutoFrame(icai); 
		jInternalFrameSize = altaInstitutoFrame.getSize();
		altaInstitutoFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		altaInstitutoFrame.setVisible(false);
		frame.getContentPane().add(altaInstitutoFrame);
		
		consultaEdicionCursoFrame = new ConsultaEdicionCursoFrame(iccec); 
		jInternalFrameSize = consultaEdicionCursoFrame.getSize();
		consultaEdicionCursoFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		consultaEdicionCursoFrame.setVisible(false);
		frame.getContentPane().add(consultaEdicionCursoFrame);
		
		
		
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
		
		JMenuItem mntmNewMenuItemAltaInstituto = new JMenuItem("Alta Instituto");
		mntmNewMenuItemAltaInstituto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaInstitutoFrame.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItemAltaInstituto);


		
		JMenu mnNewMenuConsultas = new JMenu("Consultas");
		mnNewMenuConsultas.setFont(new Font("Segoe UI", Font.BOLD, 18));
		menuBar.add(mnNewMenuConsultas);
		
		JMenuItem mntmNewMenuItemConsultaEdicionCurso = new JMenuItem("Consulta de Edicion de Curso");
		mntmNewMenuItemConsultaEdicionCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnNewMenuConsultas.add(mntmNewMenuItemConsultaEdicionCurso);

		
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
