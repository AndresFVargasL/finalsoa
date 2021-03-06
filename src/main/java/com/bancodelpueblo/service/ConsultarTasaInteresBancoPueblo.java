package com.bancodelpueblo.service;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.springframework.web.bind.annotation.RequestBody;

import co.edu.usbcali.enums.TasasDeInteres;
import co.edu.usbcali.params.RespuestaBanco;
import co.edu.usbcali.params.SolicitudBanco;
import co.edu.usbcali.proyectofinalsoa.utilities.Utilities;

@Path("/bancoPuebloService")
public class ConsultarTasaInteresBancoPueblo implements Serializable{

	private static final long serialVersionUID = -1235695603189092850L;
	private static final Double valorPrestamoMaximo= 10000000d;

	
	@Path("/consultarTasaInteres")
	@GET
	public RespuestaBanco consultarTasaInteres(@QueryParam("numeroIdentificacion") String identificacion,
			@QueryParam("tipoIdentificacion") String tipoIdentificacion,
			@QueryParam("valorPrestamo") Double valorPrestamo,
			@QueryParam("creditHistoryLegth") String creditHistoryLegth,
			@QueryParam("creditScore") String creditScore) {
		
		RespuestaBanco respuesta = new RespuestaBanco();
		
		if(identificacion == null || tipoIdentificacion  == null) {
			respuesta.setMensaje("Se debe ingresar la información del cliente");
		}else if(valorPrestamo == null || valorPrestamo > valorPrestamoMaximo) {
			respuesta.setMensaje("El valor del prestamo NO puede ser mayor a "+ Utilities.conversionDoubleExponencial(valorPrestamoMaximo));
		}else if(creditHistoryLegth == null || creditScore == null) {
			respuesta.setMensaje("Se debe ingresar la información financiera del cliente");
		}else {
			Random r = new Random();
			double leftLimit = 1D;
		    double rightLimit = 10D;
		    double generatedDouble = leftLimit + new Random().nextDouble() * (rightLimit - leftLimit);
		    Integer tipoTasaTmp = new Random().ints(1, (5 + 1)).findFirst().getAsInt();
			respuesta.setTasaInteres(new DecimalFormat("#.##").format(generatedDouble));
			respuesta.setTipoTasaInteres(TasasDeInteres.getValue(tipoTasaTmp).descripcion());
			respuesta.setMensaje("Tasa de interes definida");
		}
		
		return respuesta;
	}
	
}
