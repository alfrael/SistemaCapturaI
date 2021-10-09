/**
 * 
 */
package dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author JoseLuisE
 *
 */
@Entity
@Table(name = "afiliados")
public class AfiliadosDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 401796753398721369L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_afiliado")
    private int idAfiliado;
	@Column(name = "registro_patronal")
	private String registroPatronal;
	@Column(name = "digito_verificador_rp")
	private String digitoVerificadorRp;
	@Column(name = "numero_seguro")
	private String numeroSeguro;
	@Column(name = "digito_verificador_nss")
	private String digitoVerificadorNss;
	@Column(name = "apellido_parterno")
	private String apellidoP;
	@Column(name = "apellido_materno")
	private String apellidoM;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "salario_base_cotizacion")
	private String salarioBaseCotizacion;
	@Column(name = "tipo_trabajador")
	private String tipoTrabajador;
	@Column(name = "tipo_salario")
	private String tipoSalario;
	@Column(name = "semana_jornada")
	private String semanaJornada;
	@Column(name = "fecha_movimiento")
	private String fechaMovimiento;
	@Column(name = "unidad_medicina_familiar")
	private String unidadMedicinaFamiliar;
	@Column(name = "tipo_movimiento")
	private String tipoMovimiento;
	@Column(name = "guia")
	private String guia;
	@Column(name = "clave_trabajador")
	private String claveTrabajador;
	@Column(name = "clave_unica_registro")
	private String claveUnicaRegistro;
	@Column(name = "identificador_formato")
	private String identificadorFormato;
	@Column(name = "causa_baja")
	private String causaBaja;
	
	/**
	 * @return the idAfiliado
	 */
	public int getIdAfiliado() {
		return idAfiliado;
	}
	/**
	 * @param idAfiliado the idAfiliado to set
	 */
	public void setIdAfiliado(int idAfiliado) {
		this.idAfiliado = idAfiliado;
	}
	/**
	 * @return the registroPatronal
	 */
	public String getRegistroPatronal() {
		return registroPatronal;
	}
	/**
	 * @param registroPatronal the registroPatronal to set
	 */
	public void setRegistroPatronal(String registroPatronal) {
		this.registroPatronal = registroPatronal;
	}
	/**
	 * @return the digitoVerificadorRp
	 */
	public String getDigitoVerificadorRp() {
		return digitoVerificadorRp;
	}
	/**
	 * @param digitoVerificadorRp the digitoVerificadorRp to set
	 */
	public void setDigitoVerificadorRp(String digitoVerificadorRp) {
		this.digitoVerificadorRp = digitoVerificadorRp;
	}
	/**
	 * @return the numeroSeguro
	 */
	public String getNumeroSeguro() {
		return numeroSeguro;
	}
	/**
	 * @param numeroSeguro the numeroSeguro to set
	 */
	public void setNumeroSeguro(String numeroSeguro) {
		this.numeroSeguro = numeroSeguro;
	}
	/**
	 * @return the digitoVerificadorNss
	 */
	public String getDigitoVerificadorNss() {
		return digitoVerificadorNss;
	}
	/**
	 * @param digitoVerificadorNss the digitoVerificadorNss to set
	 */
	public void setDigitoVerificadorNss(String digitoVerificadorNss) {
		this.digitoVerificadorNss = digitoVerificadorNss;
	}
	/**
	 * @return the apellidoP
	 */
	public String getApellidoP() {
		return apellidoP;
	}
	/**
	 * @param apellidoP the apellidoP to set
	 */
	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}
	/**
	 * @return the apellidoM
	 */
	public String getApellidoM() {
		return apellidoM;
	}
	/**
	 * @param apellidoM the apellidoM to set
	 */
	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the salarioBaseCotizacion
	 */
	public String getSalarioBaseCotizacion() {
		return salarioBaseCotizacion;
	}
	/**
	 * @param salarioBaseCotizacion the salarioBaseCotizacion to set
	 */
	public void setSalarioBaseCotizacion(String salarioBaseCotizacion) {
		this.salarioBaseCotizacion = salarioBaseCotizacion;
	}
	/**
	 * @return the tipoTrabajador
	 */
	public String getTipoTrabajador() {
		return tipoTrabajador;
	}
	/**
	 * @param tipoTrabajador the tipoTrabajador to set
	 */
	public void setTipoTrabajador(String tipoTrabajador) {
		this.tipoTrabajador = tipoTrabajador;
	}
	/**
	 * @return the tipoSalario
	 */
	public String getTipoSalario() {
		return tipoSalario;
	}
	/**
	 * @param tipoSalario the tipoSalario to set
	 */
	public void setTipoSalario(String tipoSalario) {
		this.tipoSalario = tipoSalario;
	}
	/**
	 * @return the semanaJornada
	 */
	public String getSemanaJornada() {
		return semanaJornada;
	}
	/**
	 * @param semanaJornada the semanaJornada to set
	 */
	public void setSemanaJornada(String semanaJornada) {
		this.semanaJornada = semanaJornada;
	}
	/**
	 * @return the fechaMovimiento
	 */
	public String getFechaMovimiento() {
		return fechaMovimiento;
	}
	/**
	 * @param fechaMovimiento the fechaMovimiento to set
	 */
	public void setFechaMovimiento(String fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}
	/**
	 * @return the unidadMedicinaFamiliar
	 */
	public String getUnidadMedicinaFamiliar() {
		return unidadMedicinaFamiliar;
	}
	/**
	 * @param unidadMedicinaFamiliar the unidadMedicinaFamiliar to set
	 */
	public void setUnidadMedicinaFamiliar(String unidadMedicinaFamiliar) {
		this.unidadMedicinaFamiliar = unidadMedicinaFamiliar;
	}
	/**
	 * @return the tipoMovimiento
	 */
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	/**
	 * @param tipoMovimiento the tipoMovimiento to set
	 */
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	/**
	 * @return the guia
	 */
	public String getGuia() {
		return guia;
	}
	/**
	 * @param guia the guia to set
	 */
	public void setGuia(String guia) {
		this.guia = guia;
	}
	/**
	 * @return the claveTrabajador
	 */
	public String getClaveTrabajador() {
		return claveTrabajador;
	}
	/**
	 * @param claveTrabajador the claveTrabajador to set
	 */
	public void setClaveTrabajador(String claveTrabajador) {
		this.claveTrabajador = claveTrabajador;
	}
	/**
	 * @return the claveUnicaRegistro
	 */
	public String getClaveUnicaRegistro() {
		return claveUnicaRegistro;
	}
	/**
	 * @param claveUnicaRegistro the claveUnicaRegistro to set
	 */
	public void setClaveUnicaRegistro(String claveUnicaRegistro) {
		this.claveUnicaRegistro = claveUnicaRegistro;
	}
	/**
	 * @return the identificadorFormato
	 */
	public String getIdentificadorFormato() {
		return identificadorFormato;
	}
	/**
	 * @param identificadorFormato the identificadorFormato to set
	 */
	public void setIdentificadorFormato(String identificadorFormato) {
		this.identificadorFormato = identificadorFormato;
	}
	/**
	 * @return the causaBaja
	 */
	public String getCausaBaja() {
		return causaBaja;
	}
	/**
	 * @param causaBaja the causaBaja to set
	 */
	public void setCausaBaja(String causaBaja) {
		this.causaBaja = causaBaja;
	}
	
}