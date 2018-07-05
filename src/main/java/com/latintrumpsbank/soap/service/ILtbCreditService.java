package com.latintrumpsbank.soap.service;

import javax.jws.WebService;

import co.edu.usbcali.params.RespuestaBanco;
import co.edu.usbcali.params.SolicitudBanco;

@WebService
public interface ILtbCreditService {

	public RespuestaBanco prestamoService(SolicitudBanco solicitud);

}