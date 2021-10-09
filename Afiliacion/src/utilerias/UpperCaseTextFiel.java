/**
 * 
 */
package utilerias;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 * @author JoseLuisE
 *
 */
public class UpperCaseTextFiel extends DocumentFilter{

	@Override
	public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
			throws BadLocationException {
		
		fb.insertString(offset, string.toUpperCase(), attr);
	}

	@Override
	public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
			throws BadLocationException {
		// 
		fb.replace(offset, length, text.toUpperCase(), attrs);
	}
	
}