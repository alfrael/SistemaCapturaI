package componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import bean.AltaReingresoBean;
import bean.BajaBean;
import bean.ModificacionBean;
import service.CargaDatosLayout;
import utilerias.GeneraFormato;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CargaLayout extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3430000965508246704L;
	private JLabel lblAltaImg;
	private JLabel lblModificacionImg;
	private JLabel lblBajaImg;
	/**
	 * Create the panel.
	 */
	public CargaLayout() {
		setBackground(new Color(245, 245, 245));
		setBounds(215, 34, 865, 616);
		setLayout(null);
		
		lblAltaImg = new JLabel();
		lblAltaImg.setBackground(new Color(14, 108, 92));
		lblAltaImg.setOpaque(true);
		lblAltaImg.setIcon(new ImageIcon(CargaLayout.class.getResource("/img/baseline_person_add_white_48dp.png")));
		lblAltaImg.setBounds(75, 182, 128, 114);
		lblAltaImg.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblAltaImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				/**
				 * Abrir archivo xlsx
				 */
				JFileChooser ubicacionA = new JFileChooser();
				ubicacionA.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				ubicacionA.setDialogTitle("Selecciona un directorio");
				int respuestaA = ubicacionA.showDialog(lblAltaImg, "Abir Archivo");
				
				if(respuestaA == 0) {
					System.out.println(respuestaA+"|"+ubicacionA.getSelectedFile().getAbsolutePath());
					String rutaA = ubicacionA.getSelectedFile().getAbsolutePath();
					
					if(rutaA.substring(rutaA.length()-5, rutaA.length()).indexOf(".xlsx") != -1) {
						List<AltaReingresoBean> altaReingresoList = new ArrayList<AltaReingresoBean>();
						
						List<Map<Integer, String>> listaRegistroLayout = GeneraFormato.leerArchivo(ubicacionA.getSelectedFile().getAbsolutePath());
						ubicacionA.getSelectedFile().exists();
						
						for (Map<Integer, String> listaRegistroMap : listaRegistroLayout) {
							altaReingresoList.add(new CargaDatosLayout().alta(listaRegistroMap)); 
						}
						
						/**
						 * Generar Formato
						 */
						JFileChooser ubicacionG = new JFileChooser();
						ubicacionG.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
						ubicacionG.setDialogTitle("Selecciona un directorio");
						int respuestaG = ubicacionG.showDialog(lblAltaImg, "Guardar en...");	
						
						if(respuestaG == 0) {
							String rutaG = ubicacionG.getSelectedFile().getAbsolutePath();
							boolean isGeneraFormato = GeneraFormato.generaFormato(rutaG+File.separator+"ALTAS-REINGRESOS-", altaReingresoList);
							altaReingresoList.clear();
							
							if(isGeneraFormato) {
								JOptionPane.showMessageDialog(null, "Formato Generado");
								GeneraFormato.limpiarFormulario(getComponents());
							}else {
								JOptionPane.showMessageDialog(null, "Error al generar Formato", "Error", JOptionPane.ERROR_MESSAGE);
							}
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Error al generar Formato", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAltaImg.setBackground(new Color(21, 113, 105));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAltaImg.setBackground(new Color(14, 108, 92));
			}
		});
		add(lblAltaImg);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 553, 845, 2);
		separator.setForeground(new Color(128, 128, 128));
		separator.setBackground(new Color(255, 255, 255));
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 36, 845, 7);
		separator_1.setForeground(new Color(128, 128, 128));
		separator_1.setBackground(new Color(255, 255, 255));
		add(separator_1);
		
		JLabel lblTitulo = new JLabel("CARGA POR LAYOUT");
		lblTitulo.setBounds(10, 11, 206, 20);
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitulo.setForeground(new Color(105, 105, 105));
		lblTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		lblTitulo.setIcon(new ImageIcon(AltaReigreso.class.getResource("/img/outline_person_add_black_24dp.png")));
		add(lblTitulo);
		
		JLabel lblAlta = new JLabel("Alta o Reingreso");
		lblAlta.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		lblAlta.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlta.setBounds(75, 307, 141, 27);
		add(lblAlta);
		
		JLabel lblModificacion = new JLabel("Modificacion");
		lblModificacion.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		lblModificacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificacion.setBounds(343, 307, 128, 27);
		add(lblModificacion);
		
		JLabel lblBaja = new JLabel("Baja");
		lblBaja.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		lblBaja.setHorizontalAlignment(SwingConstants.CENTER);
		lblBaja.setBounds(616, 307, 128, 27);
		add(lblBaja);
		
		lblModificacionImg = new JLabel();
		lblModificacionImg.setBackground(new Color(14, 108, 92));
		lblModificacionImg.setOpaque(true);
		lblModificacionImg.setIcon(new ImageIcon(CargaLayout.class.getResource("/img/baseline_badge_white_48dp.png")));
		lblModificacionImg.setBounds(343, 182, 128, 114);
		lblModificacionImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificacionImg.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblModificacionImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				/**
				 * Abrir archivo xlsx
				 */
				JFileChooser ubicacionA = new JFileChooser();
				ubicacionA.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				ubicacionA.setDialogTitle("Selecciona un directorio");
				int respuestaA = ubicacionA.showDialog(lblModificacionImg, "Abir Archivo");
				
				if(respuestaA == 0) {
					System.out.println(respuestaA+"|"+ubicacionA.getSelectedFile().getAbsolutePath());
					String rutaA = ubicacionA.getSelectedFile().getAbsolutePath();
					
					if(rutaA.substring(rutaA.length()-5, rutaA.length()).indexOf(".xlsx") != -1) {
						List<ModificacionBean> modificacionList = new ArrayList<ModificacionBean>();
						
						List<Map<Integer, String>> listaRegistroLayout = GeneraFormato.leerArchivo(ubicacionA.getSelectedFile().getAbsolutePath());
						ubicacionA.getSelectedFile().exists();
						
						for (Map<Integer, String> listaRegistroMap : listaRegistroLayout) {
							modificacionList.add(new CargaDatosLayout().modificacion(listaRegistroMap)); 
						}
						
						/**
						 * Generar Formato
						 */
						JFileChooser ubicacionG = new JFileChooser();
						ubicacionG.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
						ubicacionG.setDialogTitle("Selecciona un directorio");
						int respuestaG = ubicacionG.showDialog(lblModificacionImg, "Guardar en...");
											
						
						if(respuestaG == 0) {
							String rutaG = ubicacionG.getSelectedFile().getAbsolutePath();
							
							boolean isGeneraFormato = GeneraFormato.generaFormato(rutaG+File.separator+"MODIFICACIONES-", modificacionList);
							modificacionList.clear();
							
							if(isGeneraFormato) {
								JOptionPane.showMessageDialog(null, "Formato Generado");
								GeneraFormato.limpiarFormulario(getComponents());
							}else {
								JOptionPane.showMessageDialog(null, "Error al generar Formato", "Error", JOptionPane.ERROR_MESSAGE);
							}
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Error al generar Formato", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblModificacionImg.setBackground(new Color(21, 113, 105));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblModificacionImg.setBackground(new Color(14, 108, 92));
			}
		});
		add(lblModificacionImg);
		
		lblBajaImg = new JLabel();
		lblBajaImg.setBackground(new Color(14, 108, 92));
		lblBajaImg.setOpaque(true);
		lblBajaImg.setIcon(new ImageIcon(CargaLayout.class.getResource("/img/baseline_person_remove_white_48dp.png")));
		lblBajaImg.setBounds(616, 182, 128, 114);
		lblBajaImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblBajaImg.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblBajaImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				/**
				 * Abrir archivo xlsx
				 */
				JFileChooser ubicacionA = new JFileChooser();
				ubicacionA.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				ubicacionA.setDialogTitle("Selecciona un directorio");
				int respuestaA = ubicacionA.showDialog(lblBajaImg, "Abir Archivo");
				
				if(respuestaA == 0) {
					System.out.println(respuestaA+"|"+ubicacionA.getSelectedFile().getAbsolutePath());
					String rutaA = ubicacionA.getSelectedFile().getAbsolutePath();
					
					if(rutaA.substring(rutaA.length()-5, rutaA.length()).indexOf(".xlsx") != -1) {
						List<BajaBean> bajaList = new ArrayList<BajaBean>();
						
						List<Map<Integer, String>> listaRegistroLayout = GeneraFormato.leerArchivo(ubicacionA.getSelectedFile().getAbsolutePath());
						ubicacionA.getSelectedFile().exists();
						
						for (Map<Integer, String> listaRegistroMap : listaRegistroLayout) {
							bajaList.add(new CargaDatosLayout().baja(listaRegistroMap)); 
						}
						
						/**
						 * Generar Formato
						 */
						JFileChooser ubicacionG = new JFileChooser();
						ubicacionG.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
						ubicacionG.setDialogTitle("Selecciona un directorio");
						int respuestaG = ubicacionG.showDialog(lblBajaImg, "Guardar en...");
											
						
						if(respuestaG == 0) {
							String rutaG = ubicacionG.getSelectedFile().getAbsolutePath();
							
							boolean isGeneraFormato = GeneraFormato.generaFormato(rutaG+File.separator+"BAJAS-", bajaList);
							bajaList.clear();
							
							if(isGeneraFormato) {
								JOptionPane.showMessageDialog(null, "Formato Generado");
								GeneraFormato.limpiarFormulario(getComponents());
							}else {
								JOptionPane.showMessageDialog(null, "Error al generar Formato", "Error", JOptionPane.ERROR_MESSAGE);
							}
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Error al generar Formato", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBajaImg.setBackground(new Color(21, 113, 105));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBajaImg.setBackground(new Color(14, 108, 92));
			}
		});
		add(lblBajaImg);

	}
}