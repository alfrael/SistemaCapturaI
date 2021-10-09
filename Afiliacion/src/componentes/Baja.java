package componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.text.AbstractDocument;

import bean.BajaBean;
import bean.Campos;
import service.CargaDatosLayout;
import utilerias.GeneraFormato;
import utilerias.UpperCaseTextFiel;
import utilerias.ValidacionesFocus;
import utilerias.ValidacionesTeclado;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;

public class Baja extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8007455441868211269L;
	private JTextField textRegistroPatronal;
	private JTextField textDigitoVerificador;
	private JTextField textNumVerificadorNss;
	private JTextField textApellidoP;
	private JTextField textApellidoM;
	private JTextField textNombre;
	private JTextField textTipoMovimiento;
	private JTextField textGuia;
	private JTextField textClaveTrabajador;
	private JTextField textIdFormato;
	private JComboBox comboCausaBaja;
	private JTextField textNumSeguroSocial;
	private JFormattedTextField formatFechaMovimiento;
	private JLabel lblRegistroAgregado;
	private List<BajaBean> bajaList;
	private JButton btnArchivo;
	
	public Baja() {
		setBackground(new Color(245, 245, 245));
		setBounds(215, 34, 865, 616);
		setLayout(null);
		bajaList = new ArrayList<BajaBean>();
		
		/**
		 * Propiedades de diseño
		 */
		MatteBorder border = new MatteBorder(0, 0, 1, 0, Color.DARK_GRAY);
		Color backgroundInput = new Color(245, 245, 245);
		Color foregroundInput = new Color(105, 105, 105);
		Color foregroundLabel = new Color(105, 105, 105);
		Color exito   = new Color(0, 153, 102);
		Color foregroundBoton = new Color(254, 254, 254);
		
		Font  fuenteBoton  = new Font("Roboto", Font.BOLD, 14);
		Font  fuenteLabel  = new Font("Roboto", Font.BOLD, 12);
		
		JLabel lbRegistroPatronal = new JLabel(Campos.REGISTRO_PATRONAL);
		lbRegistroPatronal.setFont(fuenteLabel);
		lbRegistroPatronal.setForeground(foregroundLabel);
		lbRegistroPatronal.setBounds(20, 54, 149, 19);
		add(lbRegistroPatronal);
		
		textRegistroPatronal = new JTextField();
		textRegistroPatronal.setBackground(backgroundInput);
		textRegistroPatronal.setForeground(foregroundInput);
		textRegistroPatronal.setBounds(20, 84, 149, 20);
		textRegistroPatronal.setColumns(10);
		textRegistroPatronal.setToolTipText("Registro Asignado por el IMSS en 10 Posiciones num\u00E9rico o Alfanumerico");
		textRegistroPatronal.addKeyListener(new ValidacionesTeclado(10, textRegistroPatronal, 0));
		textRegistroPatronal.addFocusListener(new ValidacionesFocus(10, textRegistroPatronal, 0));
		textRegistroPatronal.setBorder(border);
		((AbstractDocument) textRegistroPatronal.getDocument()).setDocumentFilter(new UpperCaseTextFiel());
		add(textRegistroPatronal);				
		
		JLabel lblDigitoVerificador = new JLabel(Campos.DIGITO_RP);
		lblDigitoVerificador.setForeground(foregroundLabel);
		lblDigitoVerificador.setFont(fuenteLabel);
		lblDigitoVerificador.setBounds(235, 54, 149, 19);
		add(lblDigitoVerificador);
		
		textDigitoVerificador = new JTextField();
		textDigitoVerificador.setBackground(backgroundInput);
		textDigitoVerificador.setForeground(foregroundInput);
		textDigitoVerificador.setBounds(235, 84, 149, 20);
		textDigitoVerificador.setColumns(1);
		textDigitoVerificador.setToolTipText("11vO. D\u00EDgito del registro patronal");
		textDigitoVerificador.addKeyListener(new ValidacionesTeclado(1, textDigitoVerificador, 1));
		textDigitoVerificador.addFocusListener(new ValidacionesFocus(1, textDigitoVerificador, 1));
		textDigitoVerificador.setBorder(border);
		add(textDigitoVerificador);
		

		JLabel lblNumSeguroSocial = new JLabel(Campos.NUMERO_SURIDAD_SOCIAL);
		lblNumSeguroSocial.setForeground(foregroundLabel);
		lblNumSeguroSocial.setFont(fuenteLabel);
		lblNumSeguroSocial.setBounds(447, 54, 163, 19);
		add(lblNumSeguroSocial);
		
		textNumSeguroSocial = new JTextField();
		textNumSeguroSocial.setBackground(backgroundInput);
		textNumSeguroSocial.setForeground(foregroundInput);
		textNumSeguroSocial.setColumns(10);
		textNumSeguroSocial.setBounds(447, 84, 149, 20);
		textNumSeguroSocial.setToolTipText("N\u00FAmero de registro del trabajador asignado por el IMSS");
		textNumSeguroSocial.addKeyListener(new ValidacionesTeclado(10, textNumSeguroSocial, 1));
		textNumSeguroSocial.addFocusListener(new ValidacionesFocus(10, textNumSeguroSocial, 1));
		textNumSeguroSocial.setBorder(border);
		add(textNumSeguroSocial);
		
		JLabel lblDigitoVerificadorNss = new JLabel(Campos.DIGITO_NSS);
		lblDigitoVerificadorNss.setForeground(foregroundLabel);
		lblDigitoVerificadorNss.setFont(fuenteLabel);
		lblDigitoVerificadorNss.setBounds(653, 56, 149, 20);
		add(lblDigitoVerificadorNss);
		
		textNumVerificadorNss = new JTextField();
		textNumVerificadorNss.setBackground(backgroundInput);
		textNumVerificadorNss.setForeground(foregroundInput);
		textNumVerificadorNss.setBounds(653, 84, 149, 20);
		textNumVerificadorNss.setColumns(10);
		textNumVerificadorNss.setToolTipText("11vO. D\u00EDgito del n\u00FAmero de seguro social");
		textNumVerificadorNss.addKeyListener(new ValidacionesTeclado(1, textNumVerificadorNss, 1));
		textNumVerificadorNss.addFocusListener(new ValidacionesFocus(1, textNumVerificadorNss, 1));
		textNumVerificadorNss.setBorder(border);
		add(textNumVerificadorNss);
		
		JLabel lblApellidoP = new JLabel(Campos.APELLIDO_PATERNO);
		lblApellidoP.setForeground(foregroundLabel);
		lblApellidoP.setFont(fuenteLabel);
		lblApellidoP.setBounds(20, 121, 149, 19);
		add(lblApellidoP);
		
		textApellidoP = new JTextField();
		textApellidoP.setBackground(backgroundInput);
		textApellidoP.setForeground(foregroundInput);
		textApellidoP.setBounds(20, 151, 214, 20);
		textApellidoP.setColumns(10);
		textApellidoP.setToolTipText("Primer Apellido del Asegurado");
		textApellidoP.addKeyListener(new ValidacionesTeclado(27, textApellidoP, 0));
		textApellidoP.addFocusListener(new ValidacionesFocus(27, textApellidoP, 0));
		textApellidoP.setBorder(border);
		((AbstractDocument) textApellidoP.getDocument()).setDocumentFilter(new UpperCaseTextFiel());
		add(textApellidoP);
		
		JLabel lblApellidoM = new JLabel(Campos.APELLIDO_MATERNO);
		lblApellidoM.setForeground(foregroundLabel);
		lblApellidoM.setFont(fuenteLabel);
		lblApellidoM.setBounds(312, 121, 149, 19);
		add(lblApellidoM);
		
		textApellidoM = new JTextField();
		textApellidoM.setBackground(backgroundInput);
		textApellidoM.setForeground(foregroundInput);
		textApellidoM.setBounds(312, 151, 214, 20);
		textApellidoM.setColumns(10);
		textApellidoM.setToolTipText("Segundo Apellido del Asegurado");
		textApellidoM.addKeyListener(new ValidacionesTeclado(27, textApellidoM, 0));
		textApellidoM.addFocusListener(new ValidacionesFocus(27, textApellidoM, 0));
		textApellidoM.setBorder(border);
		((AbstractDocument) textApellidoM.getDocument()).setDocumentFilter(new UpperCaseTextFiel());
		add(textApellidoM);
		
		JLabel lblNombre = new JLabel(Campos.NOMBRE);
		lblNombre.setForeground(foregroundLabel);
		lblNombre.setFont(fuenteLabel);
		lblNombre.setBounds(588, 121, 149, 19);
		add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBackground(backgroundInput);
		textNombre.setForeground(foregroundInput);
		textNombre.setBounds(588, 151, 214, 20);
		textNombre.setColumns(10);
		textNombre.setToolTipText("Nombre (s) del Asegurado");
		textNombre.addKeyListener(new ValidacionesTeclado(27, textNombre, 0));
		textNombre.addFocusListener(new ValidacionesFocus(27, textNombre, 0));
		textNombre.setBorder(border);
		((AbstractDocument) textNombre.getDocument()).setDocumentFilter(new UpperCaseTextFiel());
		add(textNombre);
		
		JLabel lblFechaMovimiento = new JLabel(Campos.FECHA_MOVIENTO);
		lblFechaMovimiento.setForeground(foregroundLabel);
		lblFechaMovimiento.setFont(fuenteLabel);
		lblFechaMovimiento.setBounds(20, 195, 149, 19);
		add(lblFechaMovimiento);
		
		formatFechaMovimiento = new JFormattedTextField();
		formatFechaMovimiento.setBackground(backgroundInput);
		formatFechaMovimiento.setForeground(foregroundInput);
		formatFechaMovimiento.setBounds(20, 225, 149, 20);
		formatFechaMovimiento.setToolTipText("Fecha de Inicio de labores (DDMMAAAA)");
		formatFechaMovimiento.addKeyListener(new ValidacionesTeclado(8, formatFechaMovimiento, 1));
		formatFechaMovimiento.addFocusListener(new ValidacionesFocus(8, formatFechaMovimiento, 1));
		formatFechaMovimiento.addFocusListener(new ValidacionesFocus(8, formatFechaMovimiento, 2));
		formatFechaMovimiento.setBorder(border);
		add(formatFechaMovimiento);
		
		JLabel lblTipoMovimiento = new JLabel(Campos.TIPO_MOVIENTO);
		lblTipoMovimiento.setForeground(foregroundLabel);
		lblTipoMovimiento.setFont(fuenteLabel);
		lblTipoMovimiento.setBounds(235, 195, 149, 19);
		add(lblTipoMovimiento);
		
		textTipoMovimiento = new JTextField();
		textTipoMovimiento.setBackground(backgroundInput);
		textTipoMovimiento.setForeground(foregroundInput);
		textTipoMovimiento.setBounds(235, 225, 149, 20);
		textTipoMovimiento.setToolTipText("08 = Reingreso");
		textTipoMovimiento.addKeyListener(new ValidacionesTeclado(2, textTipoMovimiento, 1));
		textTipoMovimiento.addFocusListener(new ValidacionesFocus(2, textTipoMovimiento, 1));
		textTipoMovimiento.setBorder(border);
		textTipoMovimiento.setColumns(10);
		add(textTipoMovimiento);
		
		JLabel lblGuia = new JLabel(Campos.GUIA);
		lblGuia.setForeground(foregroundLabel);
		lblGuia.setFont(fuenteLabel);
		lblGuia.setBounds(447, 195, 149, 19);
		add(lblGuia);
		
		textGuia = new JTextField();
		textGuia.setBackground(backgroundInput);
		textGuia.setForeground(foregroundInput);
		textGuia.setBounds(447, 225, 149, 20);
		textGuia.setToolTipText("N\u00FAmero asignado por la subdelegaci\u00F3n");
		textGuia.addKeyListener(new ValidacionesTeclado(5, textGuia, 1));
		textGuia.addFocusListener(new ValidacionesFocus(5, textGuia, 1));
		textGuia.setBorder(border);
		textGuia.setColumns(10);
		add(textGuia);
		
		JLabel lblClaveTrabajador = new JLabel(Campos.CLAVE_TRABAJADOR);
		lblClaveTrabajador.setForeground(foregroundLabel);
		lblClaveTrabajador.setFont(fuenteLabel);
		lblClaveTrabajador.setBounds(653, 195, 149, 19);
		add(lblClaveTrabajador);
		
		textClaveTrabajador = new JTextField();
		textClaveTrabajador.setBackground(backgroundInput);
		textClaveTrabajador.setForeground(foregroundInput);
		textClaveTrabajador.setBounds(653, 225, 149, 20);
		textClaveTrabajador.setColumns(10);
		textClaveTrabajador.setToolTipText("Clave asignada por el patron");
		textClaveTrabajador.addKeyListener(new ValidacionesTeclado(10, textClaveTrabajador, 0));
		textClaveTrabajador.addFocusListener(new ValidacionesFocus(10, textClaveTrabajador, 0));
		((AbstractDocument) textClaveTrabajador.getDocument()).setDocumentFilter(new UpperCaseTextFiel());
		textClaveTrabajador.setBorder(border);
		add(textClaveTrabajador);
		
		JLabel lblCausaBaja = new JLabel(Campos.CAUSA_BAJA);
		lblCausaBaja.setBounds(20, 280, 149, 14);
		lblCausaBaja.setBackground(backgroundInput);
		lblCausaBaja.setForeground(foregroundInput);
		lblCausaBaja.setFont(fuenteLabel);
		add(lblCausaBaja);
		
		comboCausaBaja = new JComboBox();
		comboCausaBaja.setModel(new DefaultComboBoxModel(new String[] {"Seleccione Opci\u00F3n", "Termino de Contrato", "Separaci\u00F3n Voluntaria", "Abandono de Empleo", "Defunci\u00F3n", "Clausura", "Otras", "Ausentismo", "Recisi\u00F3n de Contrato", "Jubilaci\u00F3n", "Pensi\u00F3n"}));
		comboCausaBaja.setBounds(20, 305, 149, 22);
		comboCausaBaja.setBackground(backgroundInput);
		comboCausaBaja.setForeground(foregroundInput);
		add(comboCausaBaja);
		
		JLabel lblIdFormato = new JLabel(Campos.ID_FORMATO);
		lblIdFormato.setForeground(foregroundLabel);
		lblIdFormato.setFont(fuenteLabel);
		lblIdFormato.setBounds(237, 277, 147, 19);
		add(lblIdFormato);
		
		textIdFormato = new JTextField();
		textIdFormato.setBackground(backgroundInput);
		textIdFormato.setForeground(foregroundInput);
		textIdFormato.setBounds(237, 307, 147, 20);
		textIdFormato.setColumns(10);
		textIdFormato.setToolTipText("Digito nueve (9)");
		textIdFormato.addKeyListener(new ValidacionesTeclado(1, textIdFormato, 1));
		textIdFormato.addFocusListener(new ValidacionesFocus(1, textIdFormato, 1));
		textIdFormato.setBorder(border);
		add(textIdFormato);
		
		JButton btnBaja = new JButton("Baja");
		btnBaja.setFont(fuenteBoton);
		btnBaja.setForeground(foregroundBoton);
		btnBaja.setBackground(exito);
		btnBaja.setBorder(BorderFactory.createEmptyBorder());
		btnBaja.setIcon(new ImageIcon(Baja.class.getResource("/img/outline_group_off_white_24dp.png")));
		btnBaja.setBounds(588, 569, 110, 34);
		btnBaja.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				/**
				 * Validacion de campos
				 */
				boolean isAgregarRegistro = true;
				
				if(isAgregarRegistro) {
					String tipoBaja = "";
					if(comboCausaBaja.getSelectedIndex() == 10) {
						tipoBaja = "A";
					}
					
					Map<Integer, String> valorColumna = new LinkedHashMap<Integer, String>();
					
					valorColumna.put(0, textRegistroPatronal.getText());
					valorColumna.put(1, textDigitoVerificador.getText());
					valorColumna.put(2, textNumSeguroSocial.getText());
					valorColumna.put(3, textNumVerificadorNss.getText());
					valorColumna.put(4, textApellidoP.getText());
					valorColumna.put(5, textApellidoM.getText());
					valorColumna.put(6, textNombre.getText());
					valorColumna.put(7, formatFechaMovimiento.getText());
					valorColumna.put(8, textTipoMovimiento.getText());
					valorColumna.put(9, textGuia.getText());
					valorColumna.put(10, textClaveTrabajador.getText());
					valorColumna.put(11, String.valueOf(tipoBaja));
					valorColumna.put(12, textIdFormato.getText());
					
					lblRegistroAgregado.setVisible(true);
					GeneraFormato.limpiarFormulario(getComponents());
					lblRegistroAgregado.setText("Registros Agregados "+(bajaList.size()+1));
					
					bajaList.add(new CargaDatosLayout().baja(valorColumna));
				}
			}
		});
		add(btnBaja);
		
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
								lblRegistroAgregado.setVisible(false);
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
		});
		btnArchivo.setBounds(708, 569, 147, 34);
		add(btnArchivo);
		
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
		
		JLabel lblTitulo = new JLabel("BAJA");
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitulo.setForeground(new Color(105, 105, 105));
		lblTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 14));
		lblTitulo.setIcon(new ImageIcon(Baja.class.getResource("/img/outline_person_remove_black_24dp.png")));
		lblTitulo.setBounds(10, 11, 206, 20);
		add(lblTitulo);
		
		lblRegistroAgregado = new JLabel();
		lblRegistroAgregado.setForeground(new Color(21, 113, 105));
		lblRegistroAgregado.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroAgregado.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		lblRegistroAgregado.setBounds(696, 523, 159, 29);
		lblRegistroAgregado.setVisible(false);
		add(lblRegistroAgregado);
		
		
	}
}