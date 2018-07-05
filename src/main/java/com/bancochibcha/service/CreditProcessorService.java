package com.bancochibcha.service;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transport.PropertyScope;

public class CreditProcessorService implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {

		  MuleMessage message = eventContext.getMessage();
		  String firstName = message.getInvocationProperty("name");
		  String lastName = message.getProperty("lastName", PropertyScope.INVOCATION);
		  
		  System.out.println(message.getPayloadAsString());

		return "AHORA YO SOY EL PAYLOAD";
		
	}

	
	
}
