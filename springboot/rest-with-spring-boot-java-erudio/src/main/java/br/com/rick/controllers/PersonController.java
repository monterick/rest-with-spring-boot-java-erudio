package br.com.rick.controllers;





import java.security.Provider.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(
            value = "/{id}", 
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable(value = "id") String id) throws Exception {
        return service.findById(id);
    }
	
	@RequestMapping(
            value = "/{id}", 
            method = RequestMethod.DELETE
            )
            
    public void delete(@PathVariable(value = "id") String id) throws Exception {
        service.delete(id);
    }
	
	@RequestMapping(	       
	        method = RequestMethod.POST,
	        produces = MediaType.APPLICATION_JSON_VALUE,
	        consumes = MediaType.APPLICATION_JSON_VALUE
	        )
	public Person create(@RequestBody Person person) throws Exception {
	   return service.create(person);
	}
	
	@RequestMapping(          
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
            )
    public Person update(@RequestBody Person person) throws Exception {
       return service.create(person);
    }
}
