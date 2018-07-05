package com.bancodelpueblo.service;

import java.io.Serializable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/bancoPuebloService")
public class ConsultarTasaInteresBancoPueblo implements Serializable{

	private static final long serialVersionUID = -1235695603189092850L;

	@Path("/consultarTasaInteres/{identificacion}")
	@GET
	public String consultarTasaInteres(@PathParam("identificacion") String identificacion) {
		return "Cliente con id: "+ identificacion;
	}
	
}
