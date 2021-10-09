/**
 * 
 */
package utilerias;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import bean.Campos;
import bean.CamposLogintud;

/**
 * @author JoseLuisE
 *
 */
public class ValidacionesCampos {
	
	public static String validaCampo(String columna, String campo) {
		String cadena = "";
		
		if(Campos.REGISTRO_PATRONAL.equalsIgnoreCase(columna)) {
			if(campo.length() > CamposLogintud.REGISTRO_PATRONAL_LIMIT) {
				cadena = campo.substring(0, CamposLogintud.REGISTRO_PATRONAL_LIMIT);
			}else {
				cadena = GeneraFormato.agregaEspacios(campo, CamposLogintud.REGISTRO_PATRONAL_LIMIT);
			}
		}else if(Campos.DIGITO_RP.equalsIgnoreCase(columna)) {
			if(campo.length() > CamposLogintud.DIGITO_RP_LIMIT) {
				cadena = campo.substring(0, CamposLogintud.DIGITO_RP_LIMIT);
				cadena = GeneraFormato.validaNumeroExpresion(cadena);
				if("0".equals(cadena)) {
					cadena = GeneraFormato.agregaCeros(cadena, CamposLogintud.DIGITO_RP_LIMIT);
				}
			}else {
				cadena = GeneraFormato.agregaCeros(GeneraFormato.validaNumeroExpresion(campo), CamposLogintud.DIGITO_RP_LIMIT);
			}			
			
		}else if(Campos.NUMERO_SURIDAD_SOCIAL.equalsIgnoreCase(columna)) {
			if(campo.length() > CamposLogintud.NUMERO_SURIDAD_SOCIAL_LIMIT) {
				cadena = campo.substring(0, CamposLogintud.NUMERO_SURIDAD_SOCIAL_LIMIT);
				cadena = GeneraFormato.validaNumeroExpresion(cadena);
				if("0".equals(cadena)) {
					cadena = GeneraFormato.agregaCeros(cadena, CamposLogintud.NUMERO_SURIDAD_SOCIAL_LIMIT);
				}
			}else {
				cadena = GeneraFormato.agregaCeros(GeneraFormato.validaNumeroExpresion(campo), CamposLogintud.NUMERO_SURIDAD_SOCIAL_LIMIT);
			}
		}else if(Campos.DIGITO_NSS.equalsIgnoreCase(columna)) {
			if(campo.length() > CamposLogintud.DIGITO_NSS_LIMIT) {
				cadena = campo.substring(0, CamposLogintud.DIGITO_NSS_LIMIT);
				cadena = GeneraFormato.validaNumeroExpresion(cadena);
				if("0".equals(cadena)) {
					cadena = GeneraFormato.agregaCeros(cadena, CamposLogintud.DIGITO_NSS_LIMIT);
				}
			}else {
				cadena = GeneraFormato.agregaCeros(GeneraFormato.validaNumeroExpresion(campo), CamposLogintud.DIGITO_NSS_LIMIT);
			}
		}else if(Campos.APELLIDO_PATERNO.equalsIgnoreCase(columna)) {
			if(campo.length() > CamposLogintud.APELLIDO_PATERNO_LIMIT) {
				cadena = campo.substring(0, CamposLogintud.APELLIDO_PATERNO_LIMIT);
			}else {
				cadena = GeneraFormato.agregaEspacios(campo, CamposLogintud.APELLIDO_PATERNO_LIMIT);
			}
		}else if(Campos.APELLIDO_MATERNO.equalsIgnoreCase(columna)) {
			if(campo.length() > CamposLogintud.APELLIDO_MATERNO_LIMIT) {
				cadena = campo.substring(0, CamposLogintud.APELLIDO_MATERNO_LIMIT);
			}else {
				cadena = GeneraFormato.agregaEspacios(campo, CamposLogintud.APELLIDO_MATERNO_LIMIT);
			}
		}else if(Campos.NOMBRE.equalsIgnoreCase(columna)) {
			if(campo.length() > CamposLogintud.NOMBRE_LIMIT) {
				cadena = campo.substring(0, CamposLogintud.NOMBRE_LIMIT);
			}else {
				cadena = GeneraFormato.agregaEspacios(campo, CamposLogintud.NOMBRE_LIMIT);
			}
		}else if(Campos.SALARIO_COTIZACION.equalsIgnoreCase(columna)) {
			if(campo.length() > CamposLogintud.SALARIO_COTIZACION_LIMIT) {
				cadena = campo.substring(0, CamposLogintud.SALARIO_COTIZACION_LIMIT);
				cadena = GeneraFormato.validaNumeroExpresion(cadena);
				if("0".equals(cadena)) {
					cadena = GeneraFormato.agregaCeros(cadena, CamposLogintud.SALARIO_COTIZACION_LIMIT);
				}
			}else {
				cadena = GeneraFormato.agregaCeros(GeneraFormato.validaNumeroExpresion(campo), CamposLogintud.SALARIO_COTIZACION_LIMIT); //Valores Decimales
			}
		}else if(Campos.TIPO_TRABAJADOR.equalsIgnoreCase(columna)) {
			if(campo.length() > CamposLogintud.TIPO_TRABAJADOR_LIMIT) {
				cadena = campo.substring(0, CamposLogintud.TIPO_TRABAJADOR_LIMIT);
				cadena = GeneraFormato.validaNumeroExpresion(cadena);
				if("0".equals(cadena)) {
					cadena = GeneraFormato.agregaCeros(cadena, CamposLogintud.TIPO_TRABAJADOR_LIMIT);
				}
			}else {
				cadena = GeneraFormato.agregaCeros(GeneraFormato.validaNumeroExpresion(campo), CamposLogintud.TIPO_TRABAJADOR_LIMIT);
			}
		}else if(Campos.TIPO_SALARIO.equalsIgnoreCase(columna)) {
			if(campo.length() > CamposLogintud.TIPO_SALARIO_LIMIT) {
				cadena = campo.substring(0, CamposLogintud.TIPO_SALARIO_LIMIT);
				cadena = GeneraFormato.validaNumeroExpresion(cadena);
				if("0".equals(cadena)) {
					cadena = GeneraFormato.agregaCeros(cadena, CamposLogintud.TIPO_SALARIO_LIMIT);
				}
			}else {
				cadena = GeneraFormato.agregaCeros(GeneraFormato.validaNumeroExpresion(campo), CamposLogintud.TIPO_SALARIO_LIMIT);
			}
		}else if(Campos.SEMAN_JORNADA.equalsIgnoreCase(columna)) {
			if(campo.length() > CamposLogintud.SEMAN_JORNADA_LIMIT) {
				cadena = campo.substring(0, CamposLogintud.SEMAN_JORNADA_LIMIT);
				cadena = GeneraFormato.validaNumeroExpresion(cadena);
				if("0".equals(cadena)) {
					cadena = GeneraFormato.agregaCeros(cadena, CamposLogintud.SEMAN_JORNADA_LIMIT);
				}
			}else {
				cadena = GeneraFormato.agregaCeros(GeneraFormato.validaNumeroExpresion(campo), CamposLogintud.SEMAN_JORNADA_LIMIT);
			}
		}else if(Campos.FECHA_MOVIENTO.equalsIgnoreCase(columna)) {
			if(campo.length() > CamposLogintud.FECHA_MOVIENTO_LIMIT) {
				cadena = campo.substring(0, CamposLogintud.FECHA_MOVIENTO_LIMIT);
				if(!cadena.matches("[0-9]*")) {
					cadena = GeneraFormato.agregaEspacios("", CamposLogintud.FECHA_MOVIENTO_LIMIT);
				}else {
					SimpleDateFormat formatoFecha = new SimpleDateFormat("ddMMyyyy");
					formatoFecha.setLenient(false);
					try {
						formatoFecha.parse(cadena);
					} catch (ParseException e1) {
						cadena = GeneraFormato.agregaEspacios("", CamposLogintud.FECHA_MOVIENTO_LIMIT);
					}
				}
			}else if(campo.length() == CamposLogintud.FECHA_MOVIENTO_LIMIT){
				SimpleDateFormat formatoFecha = new SimpleDateFormat("ddMMyyyy");
				formatoFecha.setLenient(false);
				try {
					formatoFecha.parse(campo);
					cadena = campo;
				} catch (ParseException e1) {
					cadena = GeneraFormato.agregaEspacios("", CamposLogintud.FECHA_MOVIENTO_LIMIT);
				}
			}else {
				cadena = GeneraFormato.agregaEspacios("", CamposLogintud.FECHA_MOVIENTO_LIMIT);
			}
		}else if(Campos.UNIDAD_FAMILIAR.equalsIgnoreCase(columna)) {
			if(campo.length() > CamposLogintud.UNIDAD_FAMILIAR_LIMIT) {
				cadena = campo.substring(0, CamposLogintud.UNIDAD_FAMILIAR_LIMIT);
				cadena = GeneraFormato.validaNumeroExpresion(cadena);
				if("0".equals(cadena)) {
					cadena = GeneraFormato.agregaCeros(cadena, CamposLogintud.UNIDAD_FAMILIAR_LIMIT);
				}
			}else {
				cadena = GeneraFormato.agregaCeros(GeneraFormato.validaNumeroExpresion(campo), CamposLogintud.UNIDAD_FAMILIAR_LIMIT);
			}
		}else if(Campos.TIPO_MOVIENTO.equalsIgnoreCase(columna)) {
			if(campo.length() > CamposLogintud.TIPO_MOVIENTO_LIMIT) {
				cadena = campo.substring(0, CamposLogintud.TIPO_MOVIENTO_LIMIT);
				cadena = GeneraFormato.validaNumeroExpresion(cadena);
				if("0".equals(cadena)) {
					cadena = GeneraFormato.agregaCeros(cadena, CamposLogintud.TIPO_MOVIENTO_LIMIT);
				}
			}else {
				cadena = GeneraFormato.agregaCeros(GeneraFormato.validaNumeroExpresion(campo), CamposLogintud.TIPO_MOVIENTO_LIMIT);
			}
		}else if(Campos.GUIA.equalsIgnoreCase(columna)) {
			if(campo.length() > CamposLogintud.GUIA_LIMIT) {
				cadena = campo.substring(0, CamposLogintud.GUIA_LIMIT);
				cadena = GeneraFormato.validaNumeroExpresion(cadena);
				if("0".equals(cadena)) {
					cadena = GeneraFormato.agregaCeros(cadena, CamposLogintud.GUIA_LIMIT);
				}
			}else {
				cadena = GeneraFormato.agregaCeros(GeneraFormato.validaNumeroExpresion(campo), CamposLogintud.GUIA_LIMIT);
			}
		}else if(Campos.CLAVE_TRABAJADOR.equalsIgnoreCase(columna)) {
			if(campo.length() > CamposLogintud.CLAVE_TRABAJADOR_LIMIT) {
				cadena = campo.substring(0, CamposLogintud.CLAVE_TRABAJADOR_LIMIT);
			}else {
				cadena = GeneraFormato.agregaEspacios(campo, CamposLogintud.CLAVE_TRABAJADOR_LIMIT);
			}
		}else if(Campos.CLAVE_UNICA.equalsIgnoreCase(columna)) {
			if(campo.length() > CamposLogintud.CLAVE_UNICA_LIMIT) {
				cadena = campo.substring(0, CamposLogintud.CLAVE_UNICA_LIMIT);
			}else {
				cadena = GeneraFormato.agregaEspacios(campo, CamposLogintud.CLAVE_UNICA_LIMIT);
			}
		}else if(Campos.ID_FORMATO.equalsIgnoreCase(columna)) {
			if(campo.length() > CamposLogintud.ID_FORMATO_LIMIT) {
				cadena = campo.substring(0, CamposLogintud.ID_FORMATO_LIMIT);
				cadena = GeneraFormato.validaNumeroExpresion(cadena);
				if("0".equals(cadena)) {
					cadena = GeneraFormato.agregaCeros(cadena, CamposLogintud.ID_FORMATO_LIMIT);
				}
			}else {
				cadena = GeneraFormato.agregaCeros(GeneraFormato.validaNumeroExpresion(campo), CamposLogintud.ID_FORMATO_LIMIT);
			}
		}else if(Campos.CAUSA_BAJA.equalsIgnoreCase(columna)) {
			if(campo.length() > CamposLogintud.CAUSA_BAJA_LIMIT) {
				cadena = campo.substring(0, CamposLogintud.CAUSA_BAJA_LIMIT);
				cadena = GeneraFormato.validaNumeroExpresion(cadena);
				if("0".equals(cadena)) {
					cadena = GeneraFormato.agregaCeros(cadena, CamposLogintud.CAUSA_BAJA_LIMIT);
				}
			}else {
				cadena = GeneraFormato.agregaCeros(GeneraFormato.validaNumeroExpresion(campo), CamposLogintud.CAUSA_BAJA_LIMIT);
			}
		}
			
		return cadena;
	}
}