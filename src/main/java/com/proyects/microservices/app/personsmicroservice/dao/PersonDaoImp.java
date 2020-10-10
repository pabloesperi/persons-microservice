package com.proyects.microservices.app.personsmicroservice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//import com.proyects.microservices.app.personsmicroservice.models.Person;
import com.proyects.microservices.app.commonsmicroservice.models.Person;

@Repository
public class PersonDaoImp implements IPersonDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional(readOnly = true)
	public Person getPersonById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Person.class, id);
	}

	@Override
	@Transactional
	public void savePerson(Person person) {
		em.persist(person);	
	}

	@Override
	@Transactional
	public void deletePerson(Long id) {
		Person person = em.find(Person.class, id);
		em.remove(person);	
	}

	@Override
	@Transactional(readOnly = true)
	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return em.createQuery("select u from Person u").getResultList();
	}

//	@Override
//	@Transactional(readOnly = true)
//	public Person getPersonBySurname(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	@Transactional(readOnly = true)
//	public Person getPersonById2(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
