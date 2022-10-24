package br.com.rick.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import model.Person;





@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());
    
    public Person findById(String id) {
		
    	logger.info("finding one person!");
    	Person person = new Person();
    	person.setId(counter.incrementAndGet());
    	person.setFirstName("Ricardo");
    	person.setLastName("Monte");
    	person.setAddress("Rua A");
    	person.setGender("M");
    	return person;

	}
	
}
