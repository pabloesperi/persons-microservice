package com.proyects.microservices.app.personsmicroservice.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import com.proyects.microservices.app.personsmicroservice.models.Person;
import com.proyects.microservices.app.commonsmicroservice.models.Person;

import com.proyects.microservices.app.personsmicroservice.service.IPersonService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
//@RequestMapping(value = "/api")
public class PersonsController {
	
	private static Logger logger = LoggerFactory.getLogger(PersonsController.class);
	
	@Autowired
	private IPersonService ps;
	
//	Lenguaje de expresión ${}
	@Value(value = "${configuration.text}")
	private String texto;

	@GetMapping(value = "/getAllPersons")
	public @ResponseBody List <Person> getAllPersons(){
		List <Person> persons = ps.getAllPersons();
		return persons;
	}
	
	@GetMapping(value = "/getPersonById/{id}")
	public @ResponseBody Person getPersonById(@PathVariable(value = "id") Long id){
		Person person = ps.getPersonById(id);
		return person;
	}
	
	@DeleteMapping(value = "/deletePersonById/{id}")
	public void deletePersonById(@PathVariable(value = "id") Long id){
		System.out.println(id);
		ps.deletePerson(id);
	}
	
	@PostMapping(value = "/savePerson")
	public void savePerson(@RequestBody Person person){
		ps.savePerson(person);
		System.out.println(person.getMobileNumber());
	}
	
	//indexed3
	@GetMapping(value = "/getPersonBySurname/{name}")
	public @ResponseBody List <Person> getPersonBySurname(@PathVariable(value = "name") String name) {
		List <Person> person = ps.getPersonBySurname(name);
		System.out.println(person);
		return person;
	}	
	
	//named
	@GetMapping(value = "/getPersonBySurnameNamed/{surname}")
	public @ResponseBody List <Person> getPersonBySurnameNamed(@PathVariable(value = "surname") String surname) {
		List <Person> person = ps.getPersonBySurname(surname);
		return person;
	}	
	
	@GetMapping(value = "/getPersonById2/{id}")
	public @ResponseBody Person getPersonById2(@PathVariable(value = "id") Long id){
		System.out.println(id);
		Person person = ps.getPersonById2(id);
		System.out.println(person);
		return person;
	}
	
	@GetMapping(value = "/obtener-config")
	public ResponseEntity<?> obtenerConfig(@Value("${server.port}") String port){	
		logger.info(texto);
		logger.info(port);
		Map<String, String> json = new HashMap<String, String>();
		json.put("texto", texto);
		json.put("port", port);
		return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
	}
	
}
