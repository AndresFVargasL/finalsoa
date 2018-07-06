package co.edu.usbcali.proyectofinalsoa.utilities;

import java.text.DecimalFormat;

public class Utilities {

	 public static String conversionDoubleExponencial(Double valor){
	    	
	    	//Formato para número
	    	DecimalFormat num = new DecimalFormat("####");
	    	String result = "";
	    	//Se valida si viene nulo el valor, en caso de ser nulo se envia cero
	    	if(valor == null){
	    		result = "0";
	    	}else{
	    		result = num.format(valor);
	    	}
	    	return result;
	    }
	
	
}
