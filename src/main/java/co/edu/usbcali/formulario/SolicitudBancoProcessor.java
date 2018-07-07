package co.edu.usbcali.formulario;

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

import co.edu.usbcali.enums.TasasDeInteres;
import co.edu.usbcali.params.RespuestaBanco;
import co.edu.usbcali.params.SolicitudBanco;
import co.edu.usbcali.params.XmlParameterReader;

public class SolicitudBancoProcessor implements Callable {
	
	private Logger log = LoggerFactory.getLogger(SolicitudBancoProcessor.class);

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {

		  MuleMessage message = eventContext.getMessage();
		  
		  OutputParameters outputParameters = (OutputParameters) message.getPayload();
		  
		  SolicitudBanco solicitudBanco = new SolicitudBanco();
		  
			try {
				FormularioPrincipal principal = (FormularioPrincipal) eventContext.getMessage().getProperty("payloadFormulario", PropertyScope.SESSION);
				
				
				solicitudBanco.setNumeroIdentificacion(principal.getNumeroIdentificacion().toString());
				solicitudBanco.setTipoIdentificacion(principal.getTipoIdentificacion());
				solicitudBanco.setValorPrestamo(principal.getCantidadSolicitada().doubleValue());
				solicitudBanco.setPerfilCrediticio(outputParameters.getCreditProfile());
				
				
				
				message.setPayload(solicitudBanco);
				    			
			} catch (Exception e) {
				solicitudBanco = null;
			}
			
			return solicitudBanco;
		
	}

	
	
}
