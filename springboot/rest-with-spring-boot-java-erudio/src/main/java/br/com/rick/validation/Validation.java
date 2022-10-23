package br.com.rick.validation;

public class Validation {	
	

	public static Double convertToDouble(String numero) {		
		if(numero == null) return 0D;
		String number = numero.replaceAll(",", ".");
		if(isNumeric(number)) { return Double.parseDouble(number); }
		return 0D;
	}

	public static boolean isNumeric(String str) { 
		  if(str == null) return false; 
		  String number  = str.replaceAll(",", ".");
		  return number.matches("[-+]?[0-9]*\\.?[0-9]+");
		}
	
}
