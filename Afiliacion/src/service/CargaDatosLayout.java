/**
 * 
 */
package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JTable;

import bean.AltaReingresoBean;
import bean.BajaBean;
import bean.Campos;
import bean.ModificacionBean;
import utilerias.GeneraFormato;
import utilerias.ValidacionesCampos;

/**
 * @author JoseLuisE
 *
 */
public class CargaDatosLayout {
	public AltaReingresoBean alta(Map<Integer, String> valorColumnas) {
		AltaReingresoBean alta = new AltaReingresoBean();
		
		List<String>camposList = new ArrayList<String>();
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
		camposList.add(Campos.ID_FORMATO);
				
		Iterator<Entry<Integer, String>> camposIte = valorColumnas.entrySet().iterator();
		while(camposIte.hasNext()) {
			Integer numColumna = camposIte.next().getKey(); 
			
			String valorColumna =  GeneraFormato.validaNull(valorColumnas.get(numColumna)); 
		
			if(numColumna == 0) {
				alta.setRegistroPatronal(ValidacionesCampos.validaCampo(camposList.get(numColumna) , valorColumna));
			}else if(numColumna == 1) {
				alta.setDigitoVerificadorRp(ValidacionesCampos.validaCampo(camposList.get(numColumna) , valorColumna));
			}else if(numColumna == 2) {
				alta.setNumeroSeguro(ValidacionesCampos.validaCampo(camposList.get(numColumna) , valorColumna));
			}else if(numColumna == 3) {
				alta.setDigitoVerificadorNss(ValidacionesCampos.validaCampo(camposList.get(numColumna) , valorColumna));
			}else if(numColumna == 4) {
				alta.setApellidoP(ValidacionesCampos.validaCampo(camposList.get(numColumna) , valorColumna));
			}else if(numColumna == 5) {
				alta.setApellidoM(ValidacionesCampos.validaCampo(camposList.get(numColumna) , valorColumna));
			}else if(numColumna == 6) {
				alta.setNombre(ValidacionesCampos.validaCampo(camposList.get(numColumna) , valorColumna));
			}else if(numColumna == 7) {
				alta.setSalarioBaseCotizacion(ValidacionesCampos.validaCampo(camposList.get(numColumna) , valorColumna));
				alta.setFillerUno(GeneraFormato.espacios(6));
			}else if(numColumna == 8) {
				alta.setTipoTrabajador(ValidacionesCampos.validaCampo(camposList.get(numColumna) , valorColumna));
			}else if(numColumna == 9) {
				alta.setTipoSalario(ValidacionesCampos.validaCampo(camposList.get(numColumna) , valorColumna));
			}else if(numColumna == 10) {
				alta.setSemanaJornada(ValidacionesCampos.validaCampo(camposList.get(numColumna) , valorColumna));
			}else if(numColumna == 11) {
				alta.setFechaMovimiento(ValidacionesCampos.validaCampo(camposList.get(numColumna) , valorColumna));
			}else if(numColumna == 12) {
				alta.setUnidadMedicinaFamiliar(ValidacionesCampos.validaCampo(camposList.get(numColumna) , valorColumna));
				alta.setFillerDos(GeneraFormato.espacios(2));
			}else if(numColumna == 13) {
				alta.setTipoMovimiento(ValidacionesCampos.validaCampo(camposList.get(numColumna) , valorColumna));
			}else if(numColumna == 14) {
				alta.setGuia(ValidacionesCampos.validaCampo(camposList.get(numColumna) , valorColumna));
			}else if(numColumna == 15) {
				alta.setClaveTrabajador(ValidacionesCampos.validaCampo(camposList.get(numColumna) , valorColumna));
				alta.setFillerTres(GeneraFormato.espacios(1));
			}else if(numColumna == 16) {
				alta.setClaveUnicaRegistro(ValidacionesCampos.validaCampo(camposList.get(numColumna) , valorColumna));
			}else if(numColumna == 17) {
				alta.setIdentificadorFormato(ValidacionesCampos.validaCampo(camposList.get(numColumna) , valorColumna));
			}
		
		}
		return alta;
	}
	
	public AltaReingresoBean alta(int columnas, int numFilas, JTable jtable) {
		AltaReingresoBean alta = new AltaReingresoBean();
		
		for (int numColumnas = 0; numColumnas < columnas; numColumnas++) {
			
			String valorColumna =  GeneraFormato.validaNull(String.valueOf(jtable.getValueAt(numFilas, numColumnas)));
			
			if(numColumnas == 0) {
				alta.setRegistroPatronal(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 1) {
				alta.setDigitoVerificadorRp(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 2) {
				alta.setNumeroSeguro(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 3) {
				alta.setDigitoVerificadorNss(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 4) {
				alta.setApellidoP(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 5) {
				alta.setApellidoM(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 6) {
				alta.setNombre(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 7) {
				alta.setSalarioBaseCotizacion(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
				alta.setFillerUno(GeneraFormato.espacios(6));
			}else if(numColumnas == 8) {
				alta.setTipoTrabajador(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 9) {
				alta.setTipoSalario(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 10) {
				alta.setSemanaJornada(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 11) {
				alta.setFechaMovimiento(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 12) {
				alta.setUnidadMedicinaFamiliar(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
				alta.setFillerDos(GeneraFormato.espacios(2));
			}else if(numColumnas == 13) {
				alta.setTipoMovimiento(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 14) {
				alta.setGuia(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 15) {
				alta.setClaveTrabajador(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
				alta.setFillerTres(GeneraFormato.espacios(1));
			}else if(numColumnas == 16) {
				alta.setClaveUnicaRegistro(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 17) {
				alta.setIdentificadorFormato(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}
		}
		return alta;
	}
	
	public ModificacionBean modificacion(Map<Integer, String> valorColumnas) {
		ModificacionBean modificacion = new ModificacionBean();
		
		List<String>camposList = new ArrayList<String>();
		camposList.add(Campos.REGISTRO_PATRONAL);
		camposList.add(Campos.DIGITO_RP);
		camposList.add(Campos.NUMERO_SURIDAD_SOCIAL);
		camposList.add(Campos.DIGITO_NSS);
		camposList.add(Campos.APELLIDO_PATERNO);
		camposList.add(Campos.APELLIDO_MATERNO);
		camposList.add(Campos.NOMBRE);
		camposList.add(Campos.SALARIO_COTIZACION);
		camposList.add(Campos.TIPO_SALARIO);
		camposList.add(Campos.SEMAN_JORNADA);
		camposList.add(Campos.FECHA_MOVIENTO);
		camposList.add(Campos.TIPO_MOVIENTO);
		camposList.add(Campos.GUIA);
		camposList.add(Campos.CLAVE_TRABAJADOR);
		camposList.add(Campos.CLAVE_UNICA);
		camposList.add(Campos.ID_FORMATO);
				
		Iterator<Entry<Integer, String>> camposIte = valorColumnas.entrySet().iterator();
		while(camposIte.hasNext()) {
			Integer numColumna = camposIte.next().getKey(); 
			
			String valorColumna =  GeneraFormato.validaNull(valorColumnas.get(numColumna)); 
		
			if(numColumna == 0) {
				modificacion.setRegistroPatronal(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
			}else if(numColumna == 1) {
				modificacion.setDigitoVerificadorRp(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
			}else if(numColumna == 2) {
				modificacion.setNumeroSeguro(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
			}else if(numColumna == 3) {
				modificacion.setDigitoVerificadorNss(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
			}else if(numColumna == 4) {
				modificacion.setApellidoP(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
			}else if(numColumna == 5) {
				modificacion.setApellidoM(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
			}else if(numColumna == 6) {
				modificacion.setNombre(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
			}else if(numColumna == 7) {
				modificacion.setSalarioBaseCotizacion(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
				modificacion.setFillerUno(GeneraFormato.espacios(6));
				modificacion.setFillerDos(GeneraFormato.espacios(1));
			}else if(numColumna == 8) {
				modificacion.setTipoSalario(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
			}else if(numColumna == 9) {
				modificacion.setSemanaJornada(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
			}else if(numColumna == 10) {
				modificacion.setFechaMovimiento(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
				modificacion.setFillerTres(GeneraFormato.espacios(5));
			}else if(numColumna == 11) {
				modificacion.setTipoMovimiento(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
			}else if(numColumna == 12) {
				modificacion.setGuia(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
			}else if(numColumna == 13) {
				modificacion.setClaveTrabajador(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
				modificacion.setFillerCuatro(GeneraFormato.espacios(1));
			}else if(numColumna == 14) {
				modificacion.setClaveUnicaRegistro(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
			}else if(numColumna == 15) {
				modificacion.setIdentificadorFormato(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
			}
		}
		return modificacion;
	}
	
	public ModificacionBean modificacion(int columnas, int numFilas, JTable jtable) {
		ModificacionBean modificacion = new ModificacionBean();
		for (int numColumnas = 0; numColumnas < columnas; numColumnas++) {
			
			String valorColumna =  GeneraFormato.validaNull(String.valueOf(jtable.getValueAt(numFilas, numColumnas)));
		
			if(numColumnas == 0) {
				modificacion.setRegistroPatronal(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 1) {
				modificacion.setDigitoVerificadorRp(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 2) {
				modificacion.setNumeroSeguro(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 3) {
				modificacion.setDigitoVerificadorNss(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 4) {
				modificacion.setApellidoP(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 5) {
				modificacion.setApellidoM(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 6) {
				modificacion.setNombre(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 7) {
				modificacion.setSalarioBaseCotizacion(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
				modificacion.setFillerUno(GeneraFormato.espacios(6));
				modificacion.setFillerDos(GeneraFormato.espacios(1));
			}else if(numColumnas == 8) {
				modificacion.setTipoSalario(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 9) {
				modificacion.setSemanaJornada(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 10) {
				modificacion.setFechaMovimiento(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
				modificacion.setFillerTres(GeneraFormato.espacios(5));
			}else if(numColumnas == 11) {
				modificacion.setTipoMovimiento(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 12) {
				modificacion.setGuia(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 13) {
				modificacion.setClaveTrabajador(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
				modificacion.setFillerCuatro(GeneraFormato.espacios(1));
			}else if(numColumnas == 14) {
				modificacion.setClaveUnicaRegistro(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 15) {
				modificacion.setIdentificadorFormato(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}
		}
		return modificacion;
	}
	
	public BajaBean baja(Map<Integer, String> valorColumnas) {
		BajaBean baja = new BajaBean();
		
		List<String>camposList = new ArrayList<String>();
		camposList.add(Campos.REGISTRO_PATRONAL);
		camposList.add(Campos.DIGITO_RP);
		camposList.add(Campos.NUMERO_SURIDAD_SOCIAL);
		camposList.add(Campos.DIGITO_NSS);
		camposList.add(Campos.APELLIDO_PATERNO);
		camposList.add(Campos.APELLIDO_MATERNO);
		camposList.add(Campos.NOMBRE);
		camposList.add(Campos.FECHA_MOVIENTO);
		camposList.add(Campos.TIPO_MOVIENTO);
		camposList.add(Campos.GUIA);
		camposList.add(Campos.CLAVE_TRABAJADOR);
		camposList.add(Campos.CAUSA_BAJA);
		camposList.add(Campos.ID_FORMATO);
				
		Iterator<Entry<Integer, String>> camposIte = valorColumnas.entrySet().iterator();
		while(camposIte.hasNext()) {
			Integer numColumna = camposIte.next().getKey(); 
			
			String valorColumna =  GeneraFormato.validaNull(valorColumnas.get(numColumna)); 
		
			if(numColumna == 0) {
				baja.setRegistroPatronal(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
			}else if(numColumna == 1) {
				baja.setDigitoVerificadorRp(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
			}else if(numColumna == 2) {
				baja.setNumeroSeguro(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
			}else if(numColumna == 3) {
				baja.setDigitoVerificadorNss(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
			}else if(numColumna == 4) {
				baja.setApellidoP(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
			}else if(numColumna == 5) {
				baja.setApellidoM(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
			}else if(numColumna == 6) {
				baja.setNombre(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
				baja.setFillerUno(GeneraFormato.espacios(15));
			}else if(numColumna == 7) {
				baja.setFechaMovimiento(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
				baja.setFillerDos(GeneraFormato.espacios(5));
			}else if(numColumna == 8) {
				baja.setTipoMovimiento(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
			}else if(numColumna == 9) {
				baja.setGuia(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
			}else if(numColumna == 10) {
				baja.setClaveTrabajador(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
			}else if(numColumna == 11) {
				baja.setCausaBaja(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
				baja.setFillerTres(GeneraFormato.espacios(18));
			}else if(numColumna == 12) {
				baja.setIdentificadorFormato(ValidacionesCampos.validaCampo(camposList.get(numColumna), valorColumna));
			}
		}
		return baja;
	}
	
	public BajaBean baja(int columnas, int numFilas, JTable jtable) {
		BajaBean baja = new BajaBean();
		
		for (int numColumnas = 0; numColumnas < columnas; numColumnas++) {
			
			String valorColumna =  GeneraFormato.validaNull(String.valueOf(jtable.getValueAt(numFilas, numColumnas)));
		
			if(numColumnas == 0) {
				baja.setRegistroPatronal(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 1) {
				baja.setDigitoVerificadorRp(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 2) {
				baja.setNumeroSeguro(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 3) {
				baja.setDigitoVerificadorNss(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 4) {
				baja.setApellidoP(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 5) {
				baja.setApellidoM(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 6) {
				baja.setNombre(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
				baja.setFillerUno(GeneraFormato.espacios(15));
			}else if(numColumnas == 7) {
				baja.setFechaMovimiento(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
				baja.setFillerDos(GeneraFormato.espacios(5));
			}else if(numColumnas == 8) {
				baja.setTipoMovimiento(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 9) {
				baja.setGuia(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 10) {
				baja.setClaveTrabajador(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}else if(numColumnas == 11) {
				baja.setCausaBaja(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
				baja.setFillerTres(GeneraFormato.espacios(18));
			}else if(numColumnas == 12) {
				baja.setIdentificadorFormato(ValidacionesCampos.validaCampo(jtable.getColumnName(numColumnas), valorColumna));
			}
		}
		return baja;
	}
}