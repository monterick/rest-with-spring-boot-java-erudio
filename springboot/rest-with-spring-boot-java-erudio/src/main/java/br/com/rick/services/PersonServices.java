package br.com.rick.services;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import model.Person;





@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());
    
    public List<Person> findAll() {        
        List<Person> persons = new ArrayList<>();
        for(int i = 0;i< 8;i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons ;
    }
    
   

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
    
    private Person mockPerson(int i) {
        logger.info("finding All people!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name "+i);
        person.setLastName("Last name "+i);
        person.setAddress("Rua A "+i);
        person.setGender("M");
        return person;
    }
	
}
