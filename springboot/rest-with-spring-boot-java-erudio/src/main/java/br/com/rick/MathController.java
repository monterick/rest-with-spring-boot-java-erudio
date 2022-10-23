package br.com.rick;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.rick.Exceptions.UnsuportedMathOperationException;

@RestController
public class MathController {

	@RequestMapping (value = "/sum/{numberOne}/{numberTwo}",
	method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne, 
			          @PathVariable(value = "numberTwo") String numberTwo
	 )throws Exception {
		

		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please se a numeric value");
		}
		
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
		
		//return 1D;
	}
	
	private Double convertToDouble(String numero) {		
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
