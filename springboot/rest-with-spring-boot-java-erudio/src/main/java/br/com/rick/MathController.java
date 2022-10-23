package br.com.rick;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.rick.Exceptions.UnsuportedMathOperationException;

@RestController
public class MathController {
	
	Operacoes operacoes = new Operacoes();

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
		method = RequestMethod.GET
			)
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
			) {
		if(!Validation.isNumeric(numberOne)||!Validation.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a number value");
		}
		return operacoes.sum(Validation.convertToDouble(numberOne), Validation.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}",
			method = RequestMethod.GET
				)
		public Double subtraction(
				@PathVariable(value = "numberOne") String numberOne,
	            @PathVariable(value = "numberTwo") String numberTwo
				) {
			if(!Validation.isNumeric(numberOne)||!Validation.isNumeric(numberTwo)) {
				throw new UnsuportedMathOperationException("Please set a number value");
			}
			return operacoes.subtraction(Validation.convertToDouble(numberOne), Validation.convertToDouble(numberTwo));
		}
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}",
			method = RequestMethod.GET
				)
		public Double multiplication(
				@PathVariable(value = "numberOne") String numberOne,
	            @PathVariable(value = "numberTwo") String numberTwo
				) {
			if(!Validation.isNumeric(numberOne)||!Validation.isNumeric(numberTwo)) {
				throw new UnsuportedMathOperationException("Please set a number value");
			}
			return operacoes.multiplication(Validation.convertToDouble(numberOne), Validation.convertToDouble(numberTwo));
		}
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}",
			method = RequestMethod.GET
				)
		public Double devision(
				@PathVariable(value = "numberOne") String numberOne,
	            @PathVariable(value = "numberTwo") String numberTwo
				) {
			if(!Validation.isNumeric(numberOne)||!Validation.isNumeric(numberTwo)) {
				throw new UnsuportedMathOperationException("Please set a number value");
			}
			return operacoes.divisao(Validation.convertToDouble(numberOne), Validation.convertToDouble(numberTwo));
		}
	@RequestMapping(value = "/media/{numberOne}/{numberTwo}",
			method = RequestMethod.GET
				)
		public Double media(
				@PathVariable(value = "numberOne") String numberOne,
	            @PathVariable(value = "numberTwo") String numberTwo
				) {
			if(!Validation.isNumeric(numberOne)||!Validation.isNumeric(numberTwo)) {
				throw new UnsuportedMathOperationException("Please set a number value");
			}
			return operacoes.media(Validation.convertToDouble(numberOne), Validation.convertToDouble(numberTwo));
		}
	
	@RequestMapping(value = "/square/{number}",
			method = RequestMethod.GET
				)
		public Double media(
				@PathVariable(value = "number") String number
	            
				) {
			if(!Validation.isNumeric(number)) {
				throw new UnsuportedMathOperationException("Please set a number value");
			}
			return operacoes.square(Validation.convertToDouble(number));
		}
}
