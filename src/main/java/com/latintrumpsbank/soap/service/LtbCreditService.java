package com.latintrumpsbank.soap.service;

import java.text.DecimalFormat;
import java.util.Random;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.edu.usbcali.enums.TasasDeInteres;
import co.edu.usbcali.params.RespuestaBanco;
import co.edu.usbcali.params.SolicitudBanco;

@WebService( endpointInterface = "com.latintrumpsbank.soap.service.ILtbCreditService" )
public class LtbCreditService implements ILtbCreditService {
	
	private Logger log = LoggerFactory.getLogger(LtbCreditService.class);
	
	@Override
	public RespuestaBanco prestamoService(SolicitudBanco solicitud) {

		RespuestaBanco respuesta = new RespuestaBanco();
		try {
			
			log.info("Calculando tipo y tasa de interes para la solicitud de prestamo...");
			log.info("Usuario >>> Tipo Identificacion :"+solicitud.getTipoIdentificacion()+" Numero identificacion: "+solicitud.getNumeroIdentificacion());
			log.info("Experiencia Crediticia :"+solicitud.getPerfilCrediticio().getCreditHistoryLegth()+" Score Crediticio: "+solicitud.getPerfilCrediticio().getCreditScore());
			
			double leftLimit = 1D;
		    double rightLimit = 10D;
		    double generatedDouble = leftLimit + new Random().nextDouble() * (rightLimit - leftLimit);
		    
		    Integer tipoTasaTmp = new Random().ints(1, (5 + 1)).findFirst().getAsInt();
		    
		    
			respuesta.setTasaInteres(new DecimalFormat("#.##").format(generatedDouble)+"%");
			respuesta.setTipoTasaInteres(TasasDeInteres.getValue(tipoTasaTmp).descripcion());
			
			    			
		} catch (Exception e) {
			respuesta = null;
		}
		return respuesta;
	}

}
