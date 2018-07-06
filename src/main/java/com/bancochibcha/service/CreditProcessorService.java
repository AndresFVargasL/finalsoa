package com.bancochibcha.service;

import java.text.DecimalFormat;
import java.util.Random;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transport.PropertyScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.edu.usbcali.enums.TasasDeInteres;
import co.edu.usbcali.params.RespuestaBanco;
import co.edu.usbcali.params.SolicitudBanco;
import co.edu.usbcali.params.XmlParameterReader;

public class CreditProcessorService implements Callable {
	
	private Logger log = LoggerFactory.getLogger(CreditProcessorService.class);

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {

		  MuleMessage message = eventContext.getMessage();
		  
		  XmlParameterReader parameterReader = (XmlParameterReader) message.getPayload();
		  
		  SolicitudBanco solicitud = parameterReader.getSolicitudBanco();
		  
		  RespuestaBanco respuesta = new RespuestaBanco();
		  
			try {
				
				log.info("BANCO <<<<<< LATIN TRUMPS BANK>>>>>>> Calculando tipo y tasa de interes para la solicitud de prestamo...");
				log.info("Usuario >>> Tipo Identificacion :"+solicitud.getTipoIdentificacion()+" Numero identificacion: "+solicitud.getNumeroIdentificacion());
				log.info("Experiencia Crediticia :"+solicitud.getPerfilCrediticio().getCreditHistoryLegth()+" Score Crediticio: "+solicitud.getPerfilCrediticio().getCreditScore());
				
				double leftLimit = 1D;
			    double rightLimit = 10D;
			    double generatedDouble = leftLimit + new Random().nextDouble() * (rightLimit - leftLimit);
			    
			    Integer tipoTasaTmp = new Random().ints(1, (5 + 1)).findFirst().getAsInt();
			    
			    
				respuesta.setTasaInteres(new DecimalFormat("#.##").format(generatedDouble));
				respuesta.setTipoTasaInteres(TasasDeInteres.getValue(tipoTasaTmp).descripcion());
				
				message.setOutboundProperty("identificacionCliente", solicitud.getNumeroIdentificacion());
				message.setPayload(respuesta);
				    			
			} catch (Exception e) {
				respuesta = null;
			}
			
			return respuesta;
		
	}

	
	
}
