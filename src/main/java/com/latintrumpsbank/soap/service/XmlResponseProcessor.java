package com.latintrumpsbank.soap.service;

import java.text.DecimalFormat;
import java.util.Random;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transport.PropertyScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crc.modelo.Cliente;
import com.crc.modelo.InputParameters;
import com.crc.modelo.OutputParameters;
import com.google.gson.Gson;

import co.edu.usbcali.enums.TasasDeInteres;
import co.edu.usbcali.params.RespuestaBanco;
import co.edu.usbcali.params.SolicitudBanco;
import co.edu.usbcali.params.XmlParameterReader;

public class XmlResponseProcessor implements Callable {
	
	private Logger log = LoggerFactory.getLogger(XmlResponseProcessor.class);

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {

		  MuleMessage message = eventContext.getMessage();
		  RespuestaBanco respuesta = new RespuestaBanco();
		  
		  
			try {
				PrestamoServiceResponse response = (PrestamoServiceResponse) message.getPayload();
				
				
				Gson gson = new Gson();
				
				log.info("RESPUESTA ::: LATIN TRUMPS BANK >> "+response.getNs1PrestamoServiceResponse().getNs1Return());
				
				respuesta = gson.fromJson(response.getNs1PrestamoServiceResponse().getNs1Return(), RespuestaBanco.class);
				
				
				
				message.setPayload(respuesta);
				    			
			} catch (Exception e) {
				respuesta = null;
			}
			
			return respuesta;
		
	}

	
	
}
