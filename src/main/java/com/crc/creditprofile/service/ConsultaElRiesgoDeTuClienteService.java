package com.crc.creditprofile.service;

import java.util.Random;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestBody;

import com.crc.modelo.Cliente;
import com.crc.modelo.CreditProfile;
import com.crc.modelo.InputParameters;
import com.crc.modelo.OutputParameters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/creditAgencyService")
public class ConsultaElRiesgoDeTuClienteService {
	
	private Logger log = LoggerFactory.getLogger(ConsultaElRiesgoDeTuClienteService.class);

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/creditProfile")
	public OutputParameters evaluateCreditProfile(@RequestBody InputParameters parameters) {
		OutputParameters response = new OutputParameters();
		CreditProfile profile = new CreditProfile();
		
		try {
			Cliente cliente = parameters.getCliente();
			
			log.info("El cliente es: "+cliente.getNombres());
			
			Random r = new Random();
			
			profile.setCreditHistoryLegth(String.valueOf(r.ints(0, (20 + 1)).findFirst().getAsInt()));
			profile.setCreditScore(String.valueOf(r.ints(0, (600 + 1)).findFirst().getAsInt()));
			
		} catch (Exception e) {
			profile.setCreditHistoryLegth("0");
			profile.setCreditScore("0");
		}
		
		response.setCreditProfile(profile);
		return response;
	}

}
