package com.brokenbank.service;

import java.io.Serializable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.web.bind.annotation.RequestBody;

import co.edu.usbcali.params.SolicitudBanco;

@Path("/brokenBankService")
public class ConsultarTasaInteresBrokenBank implements Serializable{

	private static final long serialVersionUID = -3086677042036966122L;

	@Path("/consultarTasaInteres/{identificacion}")
	@GET
	public String consultarTasaInteres(@RequestBody SolicitudBanco solicitud) {
		return "Cliente con id: "+ solicitud.getNumeroIdentificacion();
	}
	
}
