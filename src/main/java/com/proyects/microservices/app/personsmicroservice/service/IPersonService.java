package com.proyects.microservices.app.personsmicroservice.service;

import java.util.List;

import com.proyects.microservices.app.personsmicroservice.models.Person;

public interface IPersonService {
	
	public Person getPersonById(Long id);
	public List<Person> getPersons();
	public void savePerson(Person person);
	public void deletePerson(Long id);
	public List<Person> getAllPersons();
	public List <Person> getPersonBySurname(String name);
	public Person getPersonById2(Long id);
	public List <Person> getPersonBySurnameNamed(String name);

}

