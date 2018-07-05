package co.edu.usbcali.ltb.enums;

public enum TasasDeInteres {
	
	TIF(1, "Tasa de Interés Fija"),
    TIV(2, "Tasa de Interés Flotante"),
    TEA(3, "Tasa de Interés Efectiva Anual"),
    TEM(4, "Tasa de Interés Efectiva Mensual"),
    TIN(5, "Tasa de Interés Nominal");

	private Integer codigo;
    private String descripcion;

    TasasDeInteres(Integer codigo, String descripcion) {
    	this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String descripcion() {
        return descripcion;
    }
    
    public Integer codigo(){
    	return codigo;
    }

}
