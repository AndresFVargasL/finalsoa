package co.edu.usbcali.formulario;

import java.io.Serializable;

public class ReferenciaFamiliar implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long identificacion;
	private String nombre;
	private String parentesco;
	
	public Long getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getParentesco() {
		return parentesco;
	}
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	
	
	

}
