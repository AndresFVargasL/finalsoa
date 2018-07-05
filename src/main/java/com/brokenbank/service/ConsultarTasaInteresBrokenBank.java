package com.brokenbank.service;

import java.io.Serializable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/brokenBankService")
public class ConsultarTasaInteresBrokenBank implements Serializable{

	private static final long serialVersionUID = -3086677042036966122L;

	@Path("/consultarTasaInteres/{identificacion}")
	@GET
	public String consultarTasaInteres(@PathParam("identificacion") String identificacion) {
		return "Cliente con id: "+ identificacion;
	}
	
}
