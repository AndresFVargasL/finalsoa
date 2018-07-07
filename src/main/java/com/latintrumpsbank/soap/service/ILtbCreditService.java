package com.latintrumpsbank.soap.service;

import javax.jws.WebService;

import co.edu.usbcali.params.SolicitudBanco;

@WebService
public interface ILtbCreditService {

	public String prestamoService(SolicitudBanco solicitud);

}