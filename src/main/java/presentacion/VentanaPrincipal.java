package presentacion;

import java.awt.Dimension;

import java.awt.EventQueue;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import interfaces.Fabrica;
import interfaces.IControladorAgregarCursoAProgDeFormacion;
import interfaces.IControladorAltaUsuario;
import interfaces.IControladorConsultaDeCurso;
import interfaces.IControladorAltaEdicionCurso;
import interfaces.IControladorAltaInstituto;
import interfaces.IControladorConsultaEdicionCurso;
import interfaces.IControladorAltaCurso;
import interfaces.IControladorCrearProgFormacion;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaPrincipal {

	private JFrame frame;
	private AltaUsuarioFrame altaUsuarioFrame;
	private AgregarCursoaProgramaFormacion agregarCursoPf;
	//private ConsultaDeCurso consultaCurso;
	private AltaEdicionCursoFrame altaEdicionCursoFrame;
	private AltaInstitutoFrame altaInstitutoFrame;
	private ConsultaEdicionCursoFrame consultaEdicionCursoFrame;
	private AltaCursoFrame altaCursoFrame;
	private CrearProgFormacionFrame altaProgFormacionFrame;
	
	
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
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ejemplosHibernate");
		System.out.println("Conexion creada");
		Fabrica fab = Fabrica.getInstancia();
		IControladorAltaUsuario icau = fab.getIControladorAltaUsuario();
		//IControladorConsultaDeCurso icConsultaCurso = fab.getIControladorConsultaDeCurso();
		IControladorAgregarCursoAProgDeFormacion icAgregarCpf = fab.getIControladorAgregarCursoAProgDeFormacion();
		IControladorAltaEdicionCurso icaec = fab.getIControladorAltaEdicionCurso();
		IControladorAltaInstituto icai = fab.getIControladorAltaInstituto();
		IControladorConsultaEdicionCurso iccec = fab.getIControladorConsultaEdicionCurso();
		IControladorAltaCurso icac = fab.getIControladorAltaCurso();
		IControladorCrearProgFormacion icpf = fab.getIControladorCrearProgFormacion();
		
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
		
	
		agregarCursoPf = new AgregarCursoaProgramaFormacion(icAgregarCpf); 
		jInternalFrameSize = agregarCursoPf.getSize();
		agregarCursoPf.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		agregarCursoPf.setVisible(false);
		frame.getContentPane().add(agregarCursoPf);
		
		
		altaCursoFrame = new AltaCursoFrame(icac); 
		jInternalFrameSize = altaCursoFrame.getSize();
		altaCursoFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
				(desktopSize.height- jInternalFrameSize.height)/2);
		altaCursoFrame.setVisible(false);
		frame.getContentPane().add(altaCursoFrame);
		
		
		altaProgFormacionFrame = new CrearProgFormacionFrame(icpf); 
		jInternalFrameSize = altaProgFormacionFrame.getSize();
		altaProgFormacionFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
				(desktopSize.height- jInternalFrameSize.height)/2);
		altaProgFormacionFrame.setVisible(false);
		frame.getContentPane().add(altaProgFormacionFrame);
		
		
		/*consultaCurso = new ConsultaDeCurso(icConsultaCurso); 
		jInternalFrameSize = consultaCurso.getSize();
		consultaCurso.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		consultaCurso.setVisible(false);
		frame.getContentPane().add(consultaCurso);*/
		
		
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
		
		JMenuItem mntmNewMenuItem_AltaCurso = new JMenuItem("Alta Curso");
		mntmNewMenuItem_AltaCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaCursoFrame.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_AltaCurso);
		
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
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Alta prog formaci\u00F3n");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaProgFormacionFrame.setVisible(true);
			
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

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
				//consultaCurso.setVisible(true);
			}
		});
		mnNewMenuConsultas.add(mntmConsultaDeCurso);
		
		JMenuItem mntmNewMenuItemConsultaEdicionCurso = new JMenuItem("Consulta de Edicion de Curso");
		mntmNewMenuItemConsultaEdicionCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fabrica fab = Fabrica.getInstancia();
				IControladorConsultaEdicionCurso iccec = fab.getIControladorConsultaEdicionCurso();
				List <String> instituto = iccec.listarInstituto();
				if (instituto.isEmpty()) {
					consultaEdicionCursoFrame.comboBoxSelInstituto.setEnabled(false);
					consultaEdicionCursoFrame.comboBoxSelCurso.setEnabled(false);
					consultaEdicionCursoFrame.comboBoxSelEdicion.setEnabled(false);
					consultaEdicionCursoFrame.setVisible(false);
					JOptionPane.showMessageDialog(frame, "Deben existir institutos en el sistema para consultar ediciones de curso", "Consulta de Edicion de Curso", JOptionPane.ERROR_MESSAGE);

				}else{
					consultaEdicionCursoFrame.inicializarInstituto();
					consultaEdicionCursoFrame.setVisible(true);
					consultaEdicionCursoFrame.comboBoxSelInstituto.setEnabled(true);
					
				}
					
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
