package co.edu.usbcali.formulario;

import java.text.DecimalFormat;
import java.util.Random;

import org.apache.commons.lang.WordUtils;
import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transport.PropertyScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crc.modelo.Cliente;
import com.crc.modelo.InputParameters;
import com.crc.modelo.OutputParameters;

import co.edu.usbcali.enums.TasasDeInteres;
import co.edu.usbcali.params.RespuestaBanco;
import co.edu.usbcali.params.SolicitudBanco;
import co.edu.usbcali.params.XmlParameterReader;

public class MainEventBrainListener implements Callable {
	
	private Logger log = LoggerFactory.getLogger(MainEventBrainListener.class);

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {

		  MuleMessage message = eventContext.getMessage();
		  
		  String cuerpoCorreo = "";
		  String nombreBanco = "";
		  String tipoTasa = "";
		  String valorTasa = "";
		  
			try {
				FormularioPrincipal principal = (FormularioPrincipal) eventContext.getMessage().getProperty("payloadFormulario", PropertyScope.SESSION);
				
				RespuestaBanco respuestaBancoDeAmerica = (RespuestaBanco) eventContext.getMessage().getProperty("respuestaBancoDeAmerica", PropertyScope.SESSION);
				RespuestaBanco respuestaBrokenBank = (RespuestaBanco) eventContext.getMessage().getProperty("respuestaBrokenBank", PropertyScope.SESSION);
				RespuestaBanco respuestaLatinTrumpsBank = (RespuestaBanco) eventContext.getMessage().getProperty("respuestaLatinTrumpsBank", PropertyScope.SESSION);
				RespuestaBanco respuestaBancoChibcha = (RespuestaBanco) eventContext.getMessage().getProperty("respuestaBancoChibcha", PropertyScope.SESSION);
				RespuestaBanco respuestaBancoDelPueblo = (RespuestaBanco) eventContext.getMessage().getProperty("respuestaBancoDelPueblo", PropertyScope.SESSION);
				
				if(principal.getCantidadSolicitada() >= 20000000L){
					
					Double tasaBdA = Double.parseDouble(respuestaBancoDeAmerica.getTasaInteres());
					Double tasaBB = Double.parseDouble(respuestaBrokenBank.getTasaInteres());
					if(tasaBdA.compareTo(tasaBB) > 0){
						 nombreBanco = "Banco de América";
						 tipoTasa = respuestaBancoDeAmerica.getTipoTasaInteres();
						 valorTasa = respuestaBancoDeAmerica.getTasaInteres();
					}else{
						 nombreBanco = "Broken Bank";
						 tipoTasa = respuestaBrokenBank.getTipoTasaInteres();
						 valorTasa = respuestaBrokenBank.getTasaInteres();
					}
					
				}else if(principal.getCantidadSolicitada() >= 10000000 && principal.getCantidadSolicitada() < 20000000){
					
					Double tasaLtb = Double.parseDouble(respuestaLatinTrumpsBank.getTasaInteres());
					Double tasaChibcha = Double.parseDouble(respuestaBancoChibcha.getTasaInteres());
					if(tasaLtb.compareTo(tasaChibcha) > 0){
						 nombreBanco = "Latin Trumps Bank";
						 tipoTasa = respuestaLatinTrumpsBank.getTipoTasaInteres();
						 valorTasa = respuestaLatinTrumpsBank.getTasaInteres();
					}else{
						 nombreBanco = "Banco Chibcha";
						 tipoTasa = respuestaBancoChibcha.getTipoTasaInteres();
						 valorTasa = respuestaBancoChibcha.getTasaInteres();
					}
					
				}else{
					 nombreBanco = "Banco del Pueblo";
					 tipoTasa = respuestaBancoDelPueblo.getTipoTasaInteres();
					 valorTasa = respuestaBancoDelPueblo.getTasaInteres();
				}
				
				cuerpoCorreo = "<table style=\"width:600px;text-align:center\"><tbody><tr><td>"
								+"<table style=\"width:600px;font-family:Arial,Helvetica,sans-serif;background-color:#35352d;color:white;font-size:12px;padding:10px 25px\">"
								+"<tbody><tr><td style=\"width:80%;text-align:center\"><span>Grupo Bancario Vortexbird S.A.S</span><br>"
								+"<span>Prestamos de todo el mundo...</span><br><span>...Y para todo el mundo</span></td></tr></tbody></table>"
								+"<td style=\"font-family:Arial,Helvetica,sans-serif;padding:20px;text-align:justify;background-color:#f7f7f7\"></tr><tr>"
								+"<td style=\"font-family:Arial,Helvetica,sans-serif;padding:20px;text-align:justify;background-color:#f7f7f7\">"
								+"Fraternal Saludo "+WordUtils.capitalize(principal.getNombres().toLowerCase())+" "+WordUtils.capitalize(principal.getApellidos().toLowerCase())+",<br><br>"
								+"Es un agrado para nosotros comunicarle que finalmente hemos encontrado"
								+ " la mejor opción de préstamo de acuerdo a la solicitud recibida. "
								+ "Es por ello que el banco "+nombreBanco+" tiene un crédito pre-aprobado con una "+tipoTasa+" del "+valorTasa+" %. No olvide acercarse a nuestras oficinas para culminar el proceso.<br><br>"
								+"Cordialmente, <br><br>"
								+"Grupo Vortex <br></td>"
								+"</td></tr><tr><td><table style=\"width:600px;font-family:Arial,Helvetica,sans-serif;background-color:#35352d;color:white;font-size:12px;padding:10px 25px\">"
								+"<tbody><tr><td style=\"width:80%;text-align:center\"><span>Sociedad Bancaria Mundial Vortexbird S.A.S</span><br>"
								+"<span>Avenida Portuaria - Edificio Administración</span><br><span>P.B.X. 5555555 - 999</span></td></tr></tbody></table></td></tr></tbody></table>";

				 
				message.setPayload(cuerpoCorreo);   			
			} catch (Exception e) {
				cuerpoCorreo = null;
			}
			
			return cuerpoCorreo;
		
	}

	
	
}
