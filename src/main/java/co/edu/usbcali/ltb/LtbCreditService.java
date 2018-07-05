package co.edu.usbcali.ltb;

import javax.jws.WebService;

@WebService( endpointInterface = "co.edu.usbcali.ltb.ILtbCreditService" )
public class LtbCreditService implements ILtbCreditService {

	/* (non-Javadoc)
	 * @see co.edu.usbcali.ltb.ILtbCreditService#prestamoService(java.lang.String)
	 */
	@Override
	public String prestamoService(String id) {
		
		return "Test:"+id;
	}

}
