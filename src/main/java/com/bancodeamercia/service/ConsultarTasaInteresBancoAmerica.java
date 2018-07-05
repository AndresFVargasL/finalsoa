package com.bancodeamercia.service;

import java.io.Serializable;
import java.util.Random;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.web.bind.annotation.RequestBody;

import co.edu.usbcali.params.RespuestaBanco;
import co.edu.usbcali.params.SolicitudBanco;
import co.edu.usbcali.proyectofinalsoa.utilities.Utilities;

@Path("/bancoAmericaService")
public class ConsultarTasaInteresBancoAmerica implements Serializable{

	private static final long serialVersionUID = -5327800381308717205L;
	private static final Double valorPrestamoMinimo = 20000000d;
	
	@Path("/consultarTasaInteres")
	@POST
	public RespuestaBanco consultarTasaInteres(@RequestBody SolicitudBanco solicitud) {
		
		RespuestaBanco respuesta = new RespuestaBanco();
		
		if(solicitud == null) {
			respuesta.setMensaje("Se debe ingresar una petición");
		}else if(solicitud.getPerfilCrediticio() == null) {
			respuesta.setMensaje("Se debe ingresar el perfil crediticio del cliente");
		}else if(solicitud.getNumeroIdentificacion() == null || solicitud.getTipoIdentificacion() == null) {
			respuesta.setMensaje("Se debe ingresar la informacion básica del cliente");
		}else if(solicitud.getValorPrestamo() == null || solicitud.getValorPrestamo()< valorPrestamoMinimo) {
			respuesta.setMensaje("El valor del prestamo debe ser mayor o igual a "+ Utilities.conversionDoubleExponencial(valorPrestamoMinimo));
		}else {
			Random r = new Random();
			respuesta.setTasaInteres((String.valueOf(r.ints(0, (5 + 1)).findFirst().getAsInt()))+"%");
			respuesta.setTipoTasaInteres("Preferencial");
			respuesta.setMensaje("Tasa de interes definida");
		}
		
		return respuesta;
	}
	
}
