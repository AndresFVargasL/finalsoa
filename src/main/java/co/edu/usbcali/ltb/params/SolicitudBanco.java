package co.edu.usbcali.ltb.params;

import com.crc.modelo.CreditProfile;

public class SolicitudBanco {

	private String tipoIdentificacion;
	private String numeroIdentificacion;
	private CreditProfile perfilCrediticio;
	
	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	public CreditProfile getPerfilCrediticio() {
		return perfilCrediticio;
	}
	public void setPerfilCrediticio(CreditProfile perfilCrediticio) {
		this.perfilCrediticio = perfilCrediticio;
	}
	
	

}
