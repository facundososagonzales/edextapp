package presentacion;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import interfaces.Fabrica;
import interfaces.IControladorAltaEdicionCurso;
import interfaces.IControladorAltaInstituto;
import interfaces.IControladorAltaUsuario;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class VentanaPrincipal {

	private JFrame frame;
	private AltaUsuarioFrame altaUsuarioFrame;
	private AltaEdicionCursoFrame altaEdicionCursoFrame;
	private AltaInstitutoFrame altaInstitutoFrame;

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
		IControladorAltaEdicionCurso icaec = fab.getIControladorAltaEdicionCurso();
		IControladorAltaInstituto icai = fab.getIControladorAltaInstituto();
		
		Dimension desktopSize = frame.getSize();
		Dimension jInternalFrameSize;
		
		altaUsuarioFrame = new AltaUsuarioFrame(icau); 
		jInternalFrameSize = altaUsuarioFrame.getSize();
		altaUsuarioFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
				(desktopSize.height- jInternalFrameSize.height)/2);
		altaUsuarioFrame.setVisible(false);
		frame.getContentPane().add(altaUsuarioFrame);
		
		altaEdicionCursoFrame = new AltaEdicionCursoFrame(icaec); 
		jInternalFrameSize = altaEdicionCursoFrame.getSize();
		altaEdicionCursoFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		altaEdicionCursoFrame.setVisible(false);
		frame.getContentPane().add(altaEdicionCursoFrame);
		
		altaInstitutoFrame = new AltaInstitutoFrame(icai); 
		jInternalFrameSize = altaInstitutoFrame.getSize();
		altaInstitutoFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		altaInstitutoFrame.setVisible(false);
		frame.getContentPane().add(altaInstitutoFrame);
		
		
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
		
		JMenuItem mntmNewMenuItemAltaEdiciones = new JMenuItem("Alta Edicion de Curso");
		mntmNewMenuItemAltaEdiciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fabrica fab = Fabrica.getInstancia();
				IControladorAltaEdicionCurso icaec = fab.getIControladorAltaEdicionCurso();
				List<String> institutos =icaec.listarInstitutos();
				if(institutos.isEmpty()) {
					altaEdicionCursoFrame.comboBoxInstituto.setEnabled(false);
					altaEdicionCursoFrame.comboBoxInstitutoCurso.setEnabled(false);
					altaEdicionCursoFrame.setVisible(false);
					JOptionPane.showMessageDialog(frame, "Deben haber institutos cargados para crear una edicion de curso", "Agregar Instituto", JOptionPane.ERROR_MESSAGE);
				}else {
					altaEdicionCursoFrame.inicializarInstitutos();
					altaEdicionCursoFrame.comboBoxInstituto.setEnabled(true);
					altaEdicionCursoFrame.setVisible(true);
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItemAltaEdiciones);
		
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
