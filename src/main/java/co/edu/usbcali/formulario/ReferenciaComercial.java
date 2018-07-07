package co.edu.usbcali.formulario;

import java.io.Serializable;

public class ReferenciaComercial implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long nitEmpresa;
	private String nombreEmpresa;
	private String direccionEmpresa;
	private Contacto contacto;
	
	public Long getNitEmpresa() {
		return nitEmpresa;
	}
	public void setNitEmpresa(Long nitEmpresa) {
		this.nitEmpresa = nitEmpresa;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public String getDireccionEmpresa() {
		return direccionEmpresa;
	}
	public void setDireccionEmpresa(String direccionEmpresa) {
		this.direccionEmpresa = direccionEmpresa;
	}
	public Contacto getContacto() {
		return contacto;
	}
	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}
	
	

}
