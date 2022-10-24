package br.com.rick.controllers;




import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rick.services.PersonServices;
import model.Person;



@RestController
@RequestMapping(value = "/person")
public class PersonController {

	@Autowired
	private PersonServices service;
	//PersonServices personServices = new PersonServices();
	@RequestMapping(
			value = "/{id}", 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value = "id") String id) throws Exception {
		return service.findById(id);
	}
	
}
