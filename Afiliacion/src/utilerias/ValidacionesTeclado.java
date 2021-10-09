/**
 * 
 */
package utilerias;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

/**
 * @author JoseLuisE
 *
 */
public class ValidacionesTeclado implements KeyListener{

	private int limit = 0;
	private JTextField cadena;
	private int tiposValidacion;
	
	public ValidacionesTeclado(int longitud, JTextField dato, int tipoValidacion) {
		limit = longitud;
		cadena = dato;
		tiposValidacion = tipoValidacion;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		char caracter = e.getKeyChar();
		
		switch (tiposValidacion) {
			case 1:
				/**
				 * Permite solo numeros
				 */
				if((caracter < '0') || (caracter > '9') && (caracter != '\b')) {
					e.consume();
				}
				/**
				 * Valida Longitud en Campo
				 */
				if(cadena.getText().length() == limit) {
					e.consume();
				}
				break;
			default:
				/**
				 * Valida Longitud en Campo
				 */
				if(cadena.getText().length() == limit) {
					e.consume();
				}
				break;
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}