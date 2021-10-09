/**
 * 
 */
package utilerias;

import java.awt.Component;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import bean.AltaReingresoBean;
import bean.BajaBean;
import bean.ModificacionBean;

/**
 * @author JoseLuisE
 *
 */
public class GeneraFormato {
	
	public static List<Map<Integer, String>> leerArchivo(String ruta) {
		List<Map<Integer, String>> listRegistrosArchivo = new ArrayList<>();
		Map<Integer, String> registroCeldas = new LinkedHashMap<Integer, String>();
		File archivo = new File(ruta);
		
		int numCeldas = -1;
		
		if(archivo.exists()) {
			
			try {
				Workbook libroExcel = WorkbookFactory.create(new FileInputStream(archivo));
				Sheet hojaActual = libroExcel.getSheetAt(0);
				Iterator<Row> filaIterator = hojaActual.rowIterator();
				
				while(filaIterator.hasNext()) {
					Row filaActual = (Row) filaIterator.next();
					registroCeldas.clear();
					
					Iterator<Cell> celdaIterator = filaActual.cellIterator();
					while(celdaIterator.hasNext()) {
					 	Cell celda = (Cell) celdaIterator.next();
					 	String valor = "";					 	
					 	numCeldas++;
					 	
					 	if(celda != null) {
					 		switch (celda.getCellType().getCode()) {
								case 0:
									valor = String.valueOf(celda.getNumericCellValue());
									break;
								case 1:
									valor = String.valueOf(celda.getStringCellValue());
									break;
									
							}
					 	}
					 	registroCeldas.put(numCeldas, valor);
					}
					listRegistrosArchivo.add(registroCeldas);
				}
				libroExcel.close();
			} catch (EncryptedDocumentException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return listRegistrosArchivo;
	}
	
	public static <T> boolean generaFormato(String ruta, List<T> listaDatos) {
		boolean isGeneraFormato = false;
		
		String anual = new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());
		String mes = new SimpleDateFormat("MM").format(Calendar.getInstance().getTime());
		String dia = new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
		mes = GeneraFormato.obtenerNombreMes(mes).toUpperCase();
		
		ruta += dia+mes+anual+".txt"; 
		File formato = new File(ruta);
		
		try {
			FileWriter escribirFormato = new FileWriter(formato);
			BufferedWriter escribeDatos = new BufferedWriter(escribirFormato);
			int numeroRegistro = 1;
			
			for (T datos : listaDatos) {
				if(datos instanceof AltaReingresoBean) {
					AltaReingresoBean alta = (AltaReingresoBean) datos;
					
					for(Field campo: alta.getClass().getDeclaredFields()) {
						Field elemento = alta.getClass().getField(campo.getName());
						escribeDatos.write(elemento.get(alta).toString());
					}
				}else if(datos instanceof ModificacionBean) {
					ModificacionBean modificacion = (ModificacionBean) datos;
					
					for(Field campo: modificacion.getClass().getDeclaredFields()) {
						Field elemento = modificacion.getClass().getField(campo.getName());
						escribeDatos.write(elemento.get(modificacion).toString());
					}
				}else if(datos instanceof BajaBean) {
					BajaBean baja = (BajaBean) datos;
					
					for(Field campo: baja.getClass().getDeclaredFields()) {
						Field elemento = baja.getClass().getField(campo.getName());
						escribeDatos.write(elemento.get(baja).toString());
					}
				}
				
				if(numeroRegistro < listaDatos.size()) {
					escribeDatos.newLine();
				}
				numeroRegistro++;
				
			}
			
			escribeDatos.close();
			isGeneraFormato = true;
						
		}catch (Exception e) {
			e.getMessage();
		}
		
		return isGeneraFormato;
	}
	
	public static String espacios(int numeroEspacios) {
		String espaciosBlancos = "";
		
		for(int numEspacio = 0; numEspacio < numeroEspacios; numEspacio++) {
			espaciosBlancos += " ";
		}
		
		return espaciosBlancos;
	}
	
	public static String agregaEspacios(String cadena, int limit) {
		String completaFormato = "";
		
		if(cadena.length() == limit) {
			completaFormato = cadena;
		}else {
			String espacioBlancos = "";
			for(int numEspacio = cadena.length(); numEspacio < limit; numEspacio++) {
				espacioBlancos += " ";
			}
			completaFormato = cadena.concat(espacioBlancos);
		}
		
		return completaFormato;
	}
	
	public static String agregaCeros(String cadena, int limit) {
		String completaFormato = "";
		
		if(cadena.length() == limit) {
			completaFormato = cadena.trim();
		}else {
			String ceros = "";
			for(int numEspacio = cadena.length(); numEspacio < limit; numEspacio++) {
				ceros += "0";
			}
			
			completaFormato = ceros.concat(cadena);
		}
		
		return completaFormato;
	}
	
	public static String validaNumeroExpresion(String valor) {
		if(valor.matches("[0-9]*")) {
			return valor; 
		}else {
			valor = "0";
			return valor;
		}
	}
	
	public static void limpiarFormulario(Component[] componente) {
		for(int i = 0; componente.length > i; i++) {
			if(componente[i] instanceof JTextField) {
				((JTextField) componente[i]).setText("");
			}else if(componente[i] instanceof JFormattedTextField) {
				((JFormattedTextField) componente[i]).setText("");
			}else if(componente[i] instanceof JComboBox) {
				((JComboBox) componente[i]).setSelectedIndex(0);;
			}
		}
	}
	
	public static String obtenerNombreMes(String numMes) {
		String nombreMes = "";
		switch (numMes) {
			case "1":
				nombreMes = "Enero";
			break;
			case "2":
				nombreMes = "Febrero";
			break;
			case "3":
				nombreMes = "Marzo";
			break;
			case "4":
				nombreMes = "Abril";
			break;
			case "5":
				nombreMes = "Mayo";
			break;
			case "6":
				nombreMes = "Junio";
			break;
			case "7":
				nombreMes = "Julio";
			break;
			case "8":
				nombreMes = "Agosto";
			break;
			case "9":
				nombreMes = "Septiembre";
			break;
			case "10":
				nombreMes = "Octubre";
			break;
			case "11":
				nombreMes = "Noviembre";
			break;
			case "12":
				nombreMes = "Diciembre";
			break;
		}
		
		return nombreMes;
	}
	
	public static String validaNull(String cadena) {
		if(cadena == null || "null".equalsIgnoreCase(cadena)) {
			return "";
		}
		return cadena.trim();
	}
	
	public static boolean validaRangoFechas(String dateToCheck, String startDate, String endDate) {
		boolean res = false;
		SimpleDateFormat fmt1 = new SimpleDateFormat("dd-MM-yyyy"); // 22-05-2013
		SimpleDateFormat fmt2 = new SimpleDateFormat("dd/MM/yyyy"); // 22-05-2013
		try {
			Date requestDate = fmt2.parse(dateToCheck);
			Date fromDate = fmt1.parse(startDate);
			Date toDate = fmt1.parse(endDate);
			res = requestDate.compareTo(fromDate) >= 0 && requestDate.compareTo(toDate) <= 0;
		} catch (ParseException pex) {
			pex.printStackTrace();
		}
		return res;
	}
}