package com.bancodeamercia.service;

import java.io.Serializable;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("/bancoAmericaService")
public class ConsultarTasaInteresBancoAmerica implements Serializable{

	private static final long serialVersionUID = -5327800381308717205L;

	@Path("/consultarTasaInteres")
	@POST
	public String consultarTasaInteres(@QueryParam("identificacion") String identificacion) {
		return "Cliente con id: "+ identificacion;
	}
	
}
