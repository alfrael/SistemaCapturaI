/**
 * 
 */
package utilerias;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author JoseLuisE
 *
 */
public class ValidacionesFocus implements FocusListener{
	private int limit = 0;
	private JTextField cadena;
	private int tiposValidacion;
	
	public ValidacionesFocus(int longitud, JTextField dato, int tipoValidacion) {
		limit = longitud;
		cadena = dato;
		tiposValidacion = tipoValidacion;
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		switch (tiposValidacion) {
			case 1:
				/**
				 * Valida Longitud en Campo
				 */
				if(cadena.getText().length() > limit) {
					cadena.setText(cadena.getText().substring(0, limit));
				}
				
				/**
				 * Valida numeros
				 */
				if(!cadena.getText().matches("[0-9]*")) {
					JOptionPane.showMessageDialog(null, "Formato no valido", "Error", JOptionPane.ERROR_MESSAGE);
					cadena.setText("");
				}			
				
				break;
			case 2:
				SimpleDateFormat formatoFecha = new SimpleDateFormat("ddMMyyyy");
				formatoFecha.setLenient(false);
				try {
					formatoFecha.parse(cadena.getText());
				} catch (ParseException e1) {
					JOptionPane.showInternalMessageDialog(null, "Fecha no valida\nFormato valido ddMMyyyy", "Formato de fecha no valido", JOptionPane.ERROR_MESSAGE);
				}
				
				break;
			default:
				/**
				 * Valida Longitud en Campo
				 */
				if(cadena.getText().length() > limit) {
					cadena.setText(cadena.getText().substring(0, limit));
				}
				break;
		}
	}
}