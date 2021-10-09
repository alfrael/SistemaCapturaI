package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.ImageIcon;

import componentes.AltaReigreso;
import componentes.Baja;
import componentes.CargaLayout;
import componentes.CargaMasiva;
import componentes.Modificacion;
import utilerias.GeneraFormato;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTextPane;
import java.awt.Toolkit;

public class Aplicacion {

	private JFrame frameCaptura;
	private JPanel panelContenido;
	private JPanel panel;
	private JLabel lblMenuAlta;
	private JLabel lblMenuBaja;
	private JLabel lblMenuModificacion;
	private JLabel lblSalir;
	private int xMouse;
	private int yMouse;
	private JLabel lblMenu;
	private JLabel lblUser;
	private JLabel lblMinimizar;
	private JLabel lblMenuCargaMasiva;
	private JLabel lblCargaPorLayout;
//	private static Server serverbd;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					String fechaHoy = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
					
					if(GeneraFormato.validaRangoFechas(fechaHoy, "08-10-2021", "10-10-2021")) {
						Aplicacion window = new Aplicacion();
						window.frameCaptura.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Favor de contactar con el Administrador: ing.joseluis.escobedo@hotmail.com");
					}
//					serverbd = ConexionBd.iniciaConexionServidor();				    
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Aplicacion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameCaptura = new JFrame();
		frameCaptura.setTitle("Sistema de Captura");
		frameCaptura.setIconImage(Toolkit.getDefaultToolkit().getImage(Aplicacion.class.getResource("/img/outline_health_and_safety_white_24dp.png")));
		frameCaptura.setBounds(100, 100, 1080, 650);
		frameCaptura.setLocationRelativeTo(null);
		frameCaptura.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCaptura.getContentPane().setLayout(null);
		frameCaptura.setUndecorated(true);
		
		panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(0, 0, 1080, 650);
		frameCaptura.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(0, 34, 215, 616);
		panelMenu.setBackground(new Color(49, 58, 73));
		panel.add(panelMenu);
		panelMenu.setLayout(null);
		
		lblMenuAlta = new JLabel("  Nueva Alta");
		lblMenuAlta.setHorizontalAlignment(SwingConstants.LEFT);
		lblMenuAlta.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				lblMenuAlta.setBackground(new Color(39, 45, 57));
			}
		});
		lblMenuAlta.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel.remove(2);
				panel.add(new AltaReigreso());
				frameCaptura.repaint();
				frameCaptura.revalidate();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMenuAlta.setBackground(new Color(68, 79, 91));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMenuAlta.setBackground(new Color(39, 45, 57));
			}
		});
		lblMenuAlta.setIcon(new ImageIcon(Aplicacion.class.getResource("/img/outline_person_add_alt_white_24dp.png")));
		lblMenuAlta.setForeground(new Color(255, 255, 255));
		lblMenuAlta.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		lblMenuAlta.setBackground(new Color(39, 45, 57));
		lblMenuAlta.setOpaque(true);
		lblMenuAlta.setBounds(0, 157, 215, 32);
		lblMenuAlta.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblMenuAlta);
		
		lblMenuModificacion = new JLabel("  Modificaci\u00F3n");
		lblMenuModificacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel.remove(2);
				panel.add(new Modificacion());
				frameCaptura.repaint();
				frameCaptura.revalidate();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMenuModificacion.setBackground(new Color(68, 79, 91));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMenuModificacion.setBackground(new Color(39, 45, 57));
			}
		});
		lblMenuModificacion.setIcon(new ImageIcon(Aplicacion.class.getResource("/img/outline_badge_white_24dp.png")));
		lblMenuModificacion.setOpaque(true);
		lblMenuModificacion.setForeground(Color.WHITE);
		lblMenuModificacion.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		lblMenuModificacion.setBackground(new Color(39, 45, 57));
		lblMenuModificacion.setBounds(0, 186, 215, 32);
		lblMenuModificacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblMenuModificacion);
		
		lblMenuBaja = new JLabel("  Baja");
		lblMenuBaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel.remove(2);
				panel.add(new Baja());
				frameCaptura.repaint();
				frameCaptura.revalidate();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMenuBaja.setBackground(new Color(68, 79, 91));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMenuBaja.setBackground(new Color(39, 45, 57));
			}
		});
		lblMenuBaja.setIcon(new ImageIcon(Aplicacion.class.getResource("/img/outline_person_remove_white_24dp.png")));
		lblMenuBaja.setOpaque(true);
		lblMenuBaja.setForeground(Color.WHITE);
		lblMenuBaja.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		lblMenuBaja.setBackground(new Color(39, 45, 57));
		lblMenuBaja.setBounds(0, 218, 215, 32);
		lblMenuBaja.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblMenuBaja);
		
		lblMenu = new JLabel("  Menu");
		lblMenu.setIcon(new ImageIcon(Aplicacion.class.getResource("/img/outline_list_white_24dp.png")));
		lblMenu.setOpaque(true);
		lblMenu.setHorizontalAlignment(SwingConstants.LEFT);
		lblMenu.setForeground(Color.WHITE);
		lblMenu.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		lblMenu.setBackground(new Color(42, 45, 57));
		lblMenu.setBounds(0, 125, 215, 32);
		panelMenu.add(lblMenu);
		
		lblUser = new JLabel("");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setIcon(new ImageIcon(Aplicacion.class.getResource("/img/outline_account_circle_white_36dp.png")));
		lblUser.setBounds(0, 0, 215, 97);
		panelMenu.add(lblUser);
		
		JTextPane txtpnCreado = new JTextPane();
		txtpnCreado.setEditable(false);
		txtpnCreado.setForeground(Color.WHITE);
		txtpnCreado.setFont(new Font("Roboto Medium", Font.PLAIN, 12));
		txtpnCreado.setText("Todos los derechos reservados.\r\nIng. Jos\u00E9 Luis Escobedo Jim\u00E9nez\r\ning.joseluis.escobedo@hotmail.com");
		txtpnCreado.setBounds(0, 554, 215, 62);
		txtpnCreado.setBackground(null);
		panelMenu.add(txtpnCreado);
		
		lblMenuCargaMasiva = new JLabel("  Carga Masiva");
		lblMenuCargaMasiva.setIcon(new ImageIcon(Aplicacion.class.getResource("/img/baseline_recent_actors_white_24dp.png")));
		lblMenuCargaMasiva.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel.remove(2);
				panel.add(new CargaMasiva());
				frameCaptura.repaint();
				frameCaptura.revalidate();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMenuCargaMasiva.setBackground(new Color(68, 79, 91));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMenuCargaMasiva.setBackground(new Color(39, 45, 57));
			}
		});
		lblMenuCargaMasiva.setOpaque(true);
		lblMenuCargaMasiva.setForeground(Color.WHITE);
		lblMenuCargaMasiva.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		lblMenuCargaMasiva.setBackground(new Color(39, 45, 57));
		lblMenuCargaMasiva.setBounds(0, 249, 215, 32);
		lblMenuCargaMasiva.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblMenuCargaMasiva);
		
		lblCargaPorLayout = new JLabel("  Carga por Layout");
		lblCargaPorLayout.setIcon(new ImageIcon(Aplicacion.class.getResource("/img/baseline_upload_file_white_24dp.png")));
		lblCargaPorLayout.setOpaque(true);
		lblCargaPorLayout.setForeground(Color.WHITE);
		lblCargaPorLayout.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		lblCargaPorLayout.setBackground(new Color(39, 45, 57));
		lblCargaPorLayout.setBounds(0, 280, 215, 32);
		lblCargaPorLayout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblCargaPorLayout.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panel.remove(2);
				panel.add(new CargaLayout());
				frameCaptura.repaint();
				frameCaptura.revalidate();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCargaPorLayout.setBackground(new Color(68, 79, 91));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCargaPorLayout.setBackground(new Color(39, 45, 57));
			}
		});
		panelMenu.add(lblCargaPorLayout);
		
		JPanel panelBarra = new JPanel();
		panelBarra.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				frameCaptura.setLocation(x - xMouse, y - yMouse);
			}
		});
		panelBarra.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		panelBarra.setBackground(new Color(12, 104, 89));
		panelBarra.setBounds(0, 0, 1080, 35);
		panel.add(panelBarra);
		panelBarra.setLayout(null);
		
		JLabel lblLogo = new JLabel("Sistema de Captura");
		lblLogo.setIcon(new ImageIcon(Aplicacion.class.getResource("/img/outline_health_and_safety_white_24dp.png")));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setFont(new Font("Roboto Black", Font.BOLD, 16));
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setBounds(0, 0, 213, 35);
		panelBarra.add(lblLogo);
		
		lblSalir = new JLabel("  Salir");
		lblSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int cerrar = JOptionPane.showConfirmDialog(frameCaptura, "¿Desea salir?", "Salir del Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if(cerrar == 0) {
//					serverbd.stop();
//					System.out.println(serverbd.getStatus());
					System.exit(0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSalir.setBackground(new Color(21, 113, 105));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSalir.setBackground(new Color(14, 108, 92));
			}
		});
		lblSalir.setIcon(new ImageIcon(Aplicacion.class.getResource("/img/outline_logout_white_24dp.png")));
		lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalir.setOpaque(true);
		lblSalir.setForeground(Color.WHITE);
		lblSalir.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		lblSalir.setBackground(new Color(14, 108, 92));
		lblSalir.setBounds(1005, 0, 75, 35);
		lblSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelBarra.add(lblSalir);
		
		lblMinimizar = new JLabel();
		lblMinimizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblMinimizar.setBackground(new Color(14, 108, 92));
		lblMinimizar.setOpaque(true);
		lblMinimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameCaptura.setExtendedState(1);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMinimizar.setBackground(new Color(21, 113, 105));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMinimizar.setBackground(new Color(14, 108, 92));
			}
		});
		lblMinimizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimizar.setIcon(new ImageIcon(Aplicacion.class.getResource("/img/outline_remove_white_24dp.png")));
		lblMinimizar.setBounds(974, 0, 31, 35);
		panelBarra.add(lblMinimizar);
		
		panelContenido = new JPanel();
		panelContenido.setBounds(215, 34, 865, 616);
		panel.add(panelContenido);
		panelContenido.setLayout(null);
	}
}
