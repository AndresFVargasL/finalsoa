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

import co.edu.usbcali.enums.TasasDeInteres;
import co.edu.usbcali.params.RespuestaBanco;
import co.edu.usbcali.params.SolicitudBanco;
import co.edu.usbcali.params.XmlParameterReader;

public class FormularioProcessor implements Callable {
	
	private Logger log = LoggerFactory.getLogger(FormularioProcessor.class);

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {

		  MuleMessage message = eventContext.getMessage();
		  
		  FormularioPrincipal formulario = (FormularioPrincipal) message.getPayload();
		  
		  InputParameters parameters = new InputParameters();
		  Cliente cliente = new Cliente();
		  
			try {
				
				cliente.setTipoIdentificacion(formulario.getTipoIdentificacion());
				cliente.setNumeroDeIdentificacion(formulario.getNumeroIdentificacion().toString());
				cliente.setNombres(formulario.getNombres());
				cliente.setApellidos(formulario.getApellidos());
				
				parameters.setCliente(cliente);
				
				
				message.setOutboundProperty("identificacionCliente", formulario.getNumeroIdentificacion());
				message.setPayload(parameters);
				    			
			} catch (Exception e) {
				parameters = null;
			}
			
			return parameters;
		
	}

	
	
}
