package com.brokenbank.service;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import co.edu.usbcali.enums.TasasDeInteres;
import co.edu.usbcali.params.RespuestaBanco;
import co.edu.usbcali.proyectofinalsoa.utilities.Utilities;

@Path("/brokenBankService")
public class ConsultarTasaInteresBrokenBank implements Serializable{

	private static final long serialVersionUID = -3086677042036966122L;
	private static final Double valorPrestamoMinimo = 20000000d;

	@Path("/consultarTasaInteres/{numeroIdentificacion}/{tipoIdentificacion}/{valorPrestamo}/{creditHistoryLegth}/{creditScore}")
	@GET
	public RespuestaBanco consultarTasaInteres(@PathParam("numeroIdentificacion") String identificacion,
			@PathParam("tipoIdentificacion") String tipoIdentificacion,
			@PathParam("valorPrestamo") String valorPrestamo,
			@PathParam("creditHistoryLegth") String creditHistoryLegth,
			@PathParam("creditScore") String creditScore) {
	
		RespuestaBanco respuesta = new RespuestaBanco();
		if(identificacion == null || tipoIdentificacion  == null) {
			respuesta.setMensaje("Se debe ingresar la información del cliente");
		}else if(valorPrestamo == null || Double.parseDouble(valorPrestamo) < valorPrestamoMinimo) {
			respuesta.setMensaje("El valor de prestamo debe ser mayor a "+ Utilities.conversionDoubleExponencial(valorPrestamoMinimo));
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
