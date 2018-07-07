package co.edu.usbcali.formulario;

public class Contacto {

	private String nombreCompleto;
	private Long identificacion;
	private Long telefonoContacto;
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public Long getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}
	public Long getTelefonoContacto() {
		return telefonoContacto;
	}
	public void setTelefonoContacto(Long telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}
	public Contacto(String nombreCompleto, Long identificacion, Long telefonoContacto) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.identificacion = identificacion;
		this.telefonoContacto = telefonoContacto;
	}
	public Contacto() {
		super();
	}
	
	
	
	
	
	

}
