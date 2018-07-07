package co.edu.usbcali.formulario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class FormularioPrincipal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipoIdentificacion;
	private Long numeroIdentificacion;
	private String nombres;
	private String apellidos;
	private Long cantidadSolicitada;
	private String tipoMoneda;
	private Long plazoEnMeses;
	private String correo;
	private List<ReferenciaComercial> referenciasComerciales;
	private List<ReferenciaFamiliar> referenciasFamiliares;
	
	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	public Long getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	public void setNumeroIdentificacion(Long numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Long getCantidadSolicitada() {
		return cantidadSolicitada;
	}
	public void setCantidadSolicitada(Long cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}
	public String getTipoMoneda() {
		return tipoMoneda;
	}
	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}
	public Long getPlazoEnMeses() {
		return plazoEnMeses;
	}
	public void setPlazoEnMeses(Long plazoEnMeses) {
		this.plazoEnMeses = plazoEnMeses;
	}
	public List<ReferenciaComercial> getReferenciasComerciales() {
		return referenciasComerciales;
	}
	public void setReferenciasComerciales(List<ReferenciaComercial> referenciasComerciales) {
		this.referenciasComerciales = referenciasComerciales;
	}
	public List<ReferenciaFamiliar> getReferenciasFamiliares() {
		return referenciasFamiliares;
	}
	public void setReferenciasFamiliares(List<ReferenciaFamiliar> referenciasFamiliares) {
		this.referenciasFamiliares = referenciasFamiliares;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	/*public static void main(String[] args) {
		FormularioPrincipal formularioPrincipal = new FormularioPrincipal();
		List<ReferenciaComercial> referenciasComerciales = new ArrayList<>();
		
		ReferenciaComercial referenciaComercial1 = new ReferenciaComercial();
		referenciaComercial1.setNitEmpresa(988766475L);
		referenciaComercial1.setNombreEmpresa("Tu Pizza SAS");
		referenciaComercial1.setDireccionEmpresa("Calle 1 # 2 -3");
		referenciaComercial1.setContacto(new Contacto("Marina Granziera", 1144387622L, 3215676892L));
		
		referenciasComerciales.add(referenciaComercial1);
		
		ReferenciaComercial referenciaComercial2 = new ReferenciaComercial();
		referenciaComercial2.setNitEmpresa(999876546L);
		referenciaComercial2.setNombreEmpresa("Tu Venta SAS");
		referenciaComercial2.setDireccionEmpresa("Calle 2 # 3 -4");
		referenciaComercial2.setContacto(new Contacto("Zulma Gomez", 1123387622L, 3219876892L));
		
		referenciasComerciales.add(referenciaComercial2);
		
		List<ReferenciaFamiliar> referenciasFamiliares = new ArrayList<>();
		
		ReferenciaFamiliar referenciaFamiliar1 = new ReferenciaFamiliar();
		referenciaFamiliar1.setIdentificacion(1133872198L);
		referenciaFamiliar1.setNombre("Pepito Perez");
		referenciaFamiliar1.setParentesco("Tio");
		referenciasFamiliares.add(referenciaFamiliar1);
		
		ReferenciaFamiliar referenciaFamiliar2 = new ReferenciaFamiliar();
		referenciaFamiliar2.setIdentificacion(1133902134L);
		referenciaFamiliar2.setNombre("Juanito Sanchez");
		referenciaFamiliar2.setParentesco("Abuelo");
		referenciasFamiliares.add(referenciaFamiliar2);
		
		
		formularioPrincipal.setTipoIdentificacion("CC");
		formularioPrincipal.setNumeroIdentificacion(1144068377L);
		formularioPrincipal.setNombres("Andres Felipe");
		formularioPrincipal.setApellidos("Vargas Lopez");
		formularioPrincipal.setCantidadSolicitada(1500000L);
		formularioPrincipal.setTipoMoneda("COP");
		formularioPrincipal.setPlazoEnMeses(48L);
		formularioPrincipal.setReferenciasComerciales(referenciasComerciales);
		formularioPrincipal.setReferenciasFamiliares(referenciasFamiliares);
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(formularioPrincipal));
	}*/

}
