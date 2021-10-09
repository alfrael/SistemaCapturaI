package componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import bean.AltaReingresoBean;
import bean.BajaBean;
import bean.Campos;
import bean.ModificacionBean;
import service.CargaDatosLayout;
import utilerias.ExcelAdapter;
import utilerias.GeneraFormato;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class CargaMasiva extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 535128238914392339L;
	private List<String> camposList;
	private JTable jtAlta;
	private JTable jtModificacion;
	private JTable jtBaja;
	private JPanel panelAltas;
	private JPanel panelModificacion;
	private JPanel panelBajas;
	private JButton btnNumFilas;
	private JButton btnArchivo;
	private List<AltaReingresoBean> altaReingresoList;
	private List<ModificacionBean> modificacionList;
	private List<BajaBean> bajaList;
	private JTabbedPane tabbeCargaMasiva;
	private JTextField celda;
	private boolean isRegistroAltaVisible = true;
	private boolean isRegistroModificacionVisible = true;
	private boolean isRegistroBajaVisible = true;
	/**
	 * Create the panel.
	 */
	public CargaMasiva() {
		setBackground(new Color(245, 245, 245));
		setBounds(215, 34, 865, 616);
		setLayout(null);
		altaReingresoList = new ArrayList<AltaReingresoBean>();
		modificacionList = new ArrayList<ModificacionBean>();
		bajaList = new ArrayList<BajaBean>();
		
		/**
		 * Propiedades de diseño
		 */
		Color exito   = new Color(0, 153, 102);
		Font  fuenteBoton  = new Font("Roboto", Font.BOLD, 14);
		Color foregroundBoton = new Color(254, 254, 254);
		
		Color backgroundInput = new Color(245, 245, 245);
		Color foregroundInput = new Color(105, 105, 105);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(128, 128, 128));
		separator.setBackground(new Color(255, 255, 255));
		separator.setBounds(10, 553, 845, 2);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(128, 128, 128));
		separator_1.setBackground(new Color(255, 255, 255));
		separator_1.setBounds(10, 36, 845, 7);
		add(separator_1);
		
		JLabel lblTitulo = new JLabel("CARGA MASIVA");
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitulo.setForeground(new Color(105, 105, 105));
		lblTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		lblTitulo.setIcon(new ImageIcon(AltaReigreso.class.getResource("/img/outline_person_add_black_24dp.png")));
		lblTitulo.setBounds(10, 11, 206, 20);
		add(lblTitulo);
		
		camposList = new ArrayList<String>();
		camposList.add(Campos.REGISTRO_PATRONAL);
		camposList.add(Campos.DIGITO_RP);
		camposList.add(Campos.NUMERO_SURIDAD_SOCIAL);
		camposList.add(Campos.DIGITO_NSS);
		camposList.add(Campos.APELLIDO_PATERNO);
		camposList.add(Campos.APELLIDO_MATERNO);
		camposList.add(Campos.NOMBRE);
		camposList.add(Campos.SALARIO_COTIZACION);
		camposList.add(Campos.TIPO_TRABAJADOR);
		camposList.add(Campos.TIPO_SALARIO);
		camposList.add(Campos.SEMAN_JORNADA);
		camposList.add(Campos.FECHA_MOVIENTO);
		camposList.add(Campos.UNIDAD_FAMILIAR);
		camposList.add(Campos.TIPO_MOVIENTO);
		camposList.add(Campos.GUIA);
		camposList.add(Campos.CLAVE_TRABAJADOR);
		camposList.add(Campos.CLAVE_UNICA);
		camposList.add(Campos.CAUSA_BAJA);
		camposList.add(Campos.ID_FORMATO);
				
		tabbeCargaMasiva = new JTabbedPane(JTabbedPane.TOP);
		tabbeCargaMasiva.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(tabbeCargaMasiva.getSelectedIndex() == 0 && isRegistroAltaVisible) {
					btnNumFilas.setVisible(true);
				}else if(tabbeCargaMasiva.getSelectedIndex() == 0 && !isRegistroAltaVisible) {
					btnNumFilas.setVisible(false);
				}
				
				if(tabbeCargaMasiva.getSelectedIndex() == 1 && isRegistroModificacionVisible) {
					btnNumFilas.setVisible(true);
				}else if(tabbeCargaMasiva.getSelectedIndex() == 1 && !isRegistroModificacionVisible) {
					btnNumFilas.setVisible(false);
				} 
					
				if(tabbeCargaMasiva.getSelectedIndex() == 2 && isRegistroBajaVisible) {
					btnNumFilas.setVisible(true);
				}else if(tabbeCargaMasiva.getSelectedIndex() == 2 && !isRegistroBajaVisible) {
					btnNumFilas.setVisible(false);
				}
			}
		});
		tabbeCargaMasiva.setBounds(10, 36, 845, 506);
		add(tabbeCargaMasiva);
		
		panelAltas = new JPanel();
		tabbeCargaMasiva.addTab("Alta o Reingreso", null, panelAltas, null);
		panelAltas.setLayout(null);
		
		panelModificacion = new JPanel();
		tabbeCargaMasiva.addTab("Modificacion", null, panelModificacion, null);
		panelModificacion.setLayout(null);
		
		panelBajas = new JPanel();
		tabbeCargaMasiva.addTab("Baja", null, panelBajas, null);
		panelBajas.setLayout(null);
		
		celda = new JTextField();
		celda.setBackground(exito);
		celda.setBackground(backgroundInput);
		celda.setForeground(foregroundInput);
		
		btnNumFilas = new JButton("Numero de Registros");
		btnNumFilas.setIcon(new ImageIcon(CargaMasiva.class.getResource("/img/baseline_post_add_white_24dp.png")));
		btnNumFilas.setFont(fuenteBoton);
		btnNumFilas.setBackground(exito);
		btnNumFilas.setForeground(foregroundBoton);
		btnNumFilas.setBorder(BorderFactory.createEmptyBorder());
		btnNumFilas.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNumFilas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String numFilas = JOptionPane.showInputDialog(null, "Ingrese numero de registro", "Numero de Filas", JOptionPane.OK_CANCEL_OPTION);
				List<String> columnas = new ArrayList<String>(); 
				if(tabbeCargaMasiva.getSelectedIndex() == 1) {
					columnas.addAll(camposList);
					columnas.remove(Campos.TIPO_TRABAJADOR);
					columnas.remove(Campos.UNIDAD_FAMILIAR);
					columnas.remove(Campos.CAUSA_BAJA);
				}else if(tabbeCargaMasiva.getSelectedIndex() == 2) {
					columnas.addAll(camposList);
					columnas.remove(Campos.SALARIO_COTIZACION);
					columnas.remove(Campos.TIPO_TRABAJADOR);
					columnas.remove(Campos.TIPO_SALARIO);
					columnas.remove(Campos.SEMAN_JORNADA);
					columnas.remove(Campos.UNIDAD_FAMILIAR);
					columnas.remove(Campos.CLAVE_UNICA);
				}else {
					columnas.addAll(camposList);
					columnas.remove(Campos.CAUSA_BAJA);
				}
				
				String[] columns = new String[columnas.size()];
				columns = columnas.toArray(columns);
				
				if(tabbeCargaMasiva.getSelectedIndex() == 1) {
					jtModificacion = new JTable();
					jtModificacion.setFont(new Font("Roboto", Font.PLAIN, 11));
					jtModificacion.setBounds(10,50,200,300);
					jtModificacion.setModel(new DefaultTableModel(columns, Integer.parseInt(numFilas)));
					ExcelAdapter excel = new ExcelAdapter(jtModificacion);
					
					JScrollPane sp = new JScrollPane(jtModificacion);
					sp.setBounds(0, 0, 840, 478);
					sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
					
					panelModificacion.add(sp);
					btnNumFilas.setVisible(false);
					isRegistroModificacionVisible = false;
				}else if(tabbeCargaMasiva.getSelectedIndex() == 2) {
					jtBaja = new JTable();
					jtBaja.setFont(new Font("Roboto", Font.PLAIN, 11));
					jtBaja.setBounds(10,50,200,300);
					jtBaja.setModel(new DefaultTableModel(columns, Integer.parseInt(numFilas)));
					ExcelAdapter excel = new ExcelAdapter(jtBaja);
					
					JScrollPane sp = new JScrollPane(jtBaja);
					sp.setBounds(0, 0, 840, 478);
					sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
					
					panelBajas.add(sp);
					btnNumFilas.setVisible(false);
					isRegistroBajaVisible = false;
				}else {
					jtAlta = new JTable();
					jtAlta.setFont(new Font("Roboto", Font.PLAIN, 11));
					jtAlta.setBounds(10,50,200,300);
					jtAlta.setModel(new DefaultTableModel(columns, Integer.parseInt(numFilas)));
					ExcelAdapter excel = new ExcelAdapter(jtAlta);
					
					JScrollPane sp = new JScrollPane(jtAlta);
					sp.setBounds(0, 0, 840, 478);
					sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
					
					panelAltas.add(sp);
					btnNumFilas.setVisible(false);
					isRegistroAltaVisible = false;
				}
			}
		});
		
		btnNumFilas.setBounds(10, 565, 195, 38);
		add(btnNumFilas);
		
		btnArchivo = new JButton("Generar Formato");
		btnArchivo.setIcon(new ImageIcon(AltaReigreso.class.getResource("/img/outline_text_snippet_white_24dp.png")));
		btnArchivo.setFont(fuenteBoton);
		btnArchivo.setForeground(foregroundBoton);
		btnArchivo.setBackground(exito);
		btnArchivo.setBorder(BorderFactory.createEmptyBorder());
		btnArchivo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnArchivo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modelo;
				if(tabbeCargaMasiva.getSelectedIndex() == 1) {
					modelo = (DefaultTableModel) jtModificacion.getModel();
				}else if(tabbeCargaMasiva.getSelectedIndex() == 2) {
					modelo = (DefaultTableModel) jtBaja.getModel();
				}else {
					modelo = (DefaultTableModel) jtAlta.getModel();
				}
				
				int filas = modelo.getRowCount();
				int columnas = modelo.getColumnCount();
				
				/**
				 * Agregar Registro
				 */
				for (int numFilas = 0; numFilas < filas; numFilas++) {
					
					if(tabbeCargaMasiva.getSelectedIndex() == 1) {
						modificacionList.add(new CargaDatosLayout().modificacion(columnas, numFilas, jtModificacion));
					}else if(tabbeCargaMasiva.getSelectedIndex() == 2) {
						bajaList.add(new CargaDatosLayout().baja(columnas, numFilas, jtBaja));
					}else {
						altaReingresoList.add(new CargaDatosLayout().alta(columnas, numFilas, jtAlta));
					}
				 	
				}
				
				/**
				 * Generar Formato
				 */
				
				if(tabbeCargaMasiva.getSelectedIndex() == 1) {
					if(modificacionList.size() > 0) {
						int confirFormato = JOptionPane.showConfirmDialog(null, "¿Desea generar el Formato?", "Generaci\u00F3n de Formato", JOptionPane.YES_NO_OPTION);
						
						if(confirFormato == 0) {
							JFileChooser ubicacion = new JFileChooser();
							ubicacion.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
							ubicacion.setDialogTitle("Selecciona un directorio");
							int respuesta = ubicacion.showDialog(btnArchivo, "Guardar en...");
												
							
							if(respuesta == 0) {
								String ruta = ubicacion.getSelectedFile().getAbsolutePath();
								
								boolean isGeneraFormato = GeneraFormato.generaFormato(ruta+File.separator+"MODIFICACIONES-", modificacionList);
								modificacionList.clear();
								
								if(isGeneraFormato) {
									JOptionPane.showMessageDialog(null, "Formato Generado");
									GeneraFormato.limpiarFormulario(getComponents());
								}else {
									JOptionPane.showMessageDialog(null, "Error al generar Formato", "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
						}
					}else {
						JOptionPane.showMessageDialog(null, "No hay registro para generar Formato", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
				}else if(tabbeCargaMasiva.getSelectedIndex() == 2) {
					if(bajaList.size() > 0) {
						int confirFormato = JOptionPane.showConfirmDialog(null, "¿Desea generar el Formato?", "Generaci\u00F3n de Formato", JOptionPane.YES_NO_OPTION);
						
						if(confirFormato == 0) {
							JFileChooser ubicacion = new JFileChooser();
							ubicacion.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
							ubicacion.setDialogTitle("Selecciona un directorio");
							int respuesta = ubicacion.showDialog(btnArchivo, "Guardar en...");
												
							
							if(respuesta == 0) {
								String ruta = ubicacion.getSelectedFile().getAbsolutePath();
								
								boolean isGeneraFormato = GeneraFormato.generaFormato(ruta+File.separator+"BAJAS-", bajaList);
								bajaList.clear();
								
								if(isGeneraFormato) {
									JOptionPane.showMessageDialog(null, "Formato Generado");
									GeneraFormato.limpiarFormulario(getComponents());
								}else {
									JOptionPane.showMessageDialog(null, "Error al generar Formato", "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
						}
					}else {
						JOptionPane.showMessageDialog(null, "No hay registro para generar Formato", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
				}else {
					if(altaReingresoList.size() > 0) {
						int confirFormato = JOptionPane.showConfirmDialog(null, "¿Desea generar el Formato?", "Generaci\u00F3n de Formato", JOptionPane.YES_NO_OPTION);
						
						if(confirFormato == 0) {
							JFileChooser ubicacion = new JFileChooser();
							ubicacion.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
							ubicacion.setDialogTitle("Selecciona un directorio");
							int respuesta = ubicacion.showDialog(btnArchivo, "Guardar en...");
												
							
							if(respuesta == 0) {
								String ruta = ubicacion.getSelectedFile().getAbsolutePath();
								
								boolean isGeneraFormato = GeneraFormato.generaFormato(ruta+File.separator+"ALTAS-REINGRESOS-", altaReingresoList);
								altaReingresoList.clear();
								
								if(isGeneraFormato) {
									JOptionPane.showMessageDialog(null, "Formato Generado");
									GeneraFormato.limpiarFormulario(getComponents());
								}else {
									JOptionPane.showMessageDialog(null, "Error al generar Formato", "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
						}
					}else {
						JOptionPane.showMessageDialog(null, "No hay registro para generar Formato", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		
		btnArchivo.setBounds(708, 569, 147, 34);
		add(btnArchivo);
	}
}