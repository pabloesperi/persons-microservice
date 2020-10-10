package com.proyects.microservices.app.personsmicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyects.microservices.app.personsmicroservice.dao.IPersonDao2;
import com.proyects.microservices.app.personsmicroservice.dao.PersonDaoImp;
//import com.proyects.microservices.app.personsmicroservice.models.Person;
import com.proyects.microservices.app.commonsmicroservice.models.Person;

@Service
public class PersonServiceImp implements IPersonService {

	@Autowired
	private PersonDaoImp pd;
	
	@Autowired
	private IPersonDao2 ipd;
	
	@Override
	public Person getPersonById(Long id) {
		// TODO Auto-generated method stub
		return pd.getPersonById(id);
	}

	@Override
	public List<Person> getPersons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void savePerson(Person person) {
		pd.savePerson(person);
	}

	@Override
	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return pd.getAllPersons();
	}

	@Override
	public void deletePerson(Long id) {
		pd.deletePerson(id);
		
	}

	@Override
	public List <Person> getPersonBySurname(String name) {
		// TODO Auto-generated method stub
		System.out.println(name);
		return ipd.getPersonBySurname(name);
	}
	
	@Override
	public List <Person> getPersonBySurnameNamed(String name) {
		// TODO Auto-generated method stub
		System.out.println(name);
		return ipd.getPersonBySurname(name);
	}

	@Override
	public Person getPersonById2(Long id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		return ipd.getPersonById2(id);
	}

}

