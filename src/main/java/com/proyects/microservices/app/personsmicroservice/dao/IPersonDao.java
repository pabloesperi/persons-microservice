package com.proyects.microservices.app.personsmicroservice.dao;

import java.util.List;

//import com.proyects.microservices.app.personsmicroservice.models.Person;
import com.proyects.microservices.app.commonsmicroservice.models.Person;

public interface IPersonDao {
	
	public Person getPersonById(Long id);
	public void savePerson(Person person);
	public void deletePerson(Long id);
	public List<Person> getAllPersons();

}

