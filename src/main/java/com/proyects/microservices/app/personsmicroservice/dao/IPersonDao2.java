package com.proyects.microservices.app.personsmicroservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import com.proyects.microservices.app.personsmicroservice.models.Person;
import com.proyects.microservices.app.commonsmicroservice.models.Person;

@Repository
public interface IPersonDao2 extends CrudRepository<Person, Long>{
	
	//indexed
	@Query(nativeQuery = true, value = "SELECT * FROM PERSONS u WHERE u.name=?1")
	public List <Person> getPersonBySurname(String name);
	
	//named
	@Query(nativeQuery = true, value = "SELECT * FROM PERSONS u WHERE u.name=:surname")
	public List <Person> getPersonBySurnameNamed(@Param(value = "surname") String surname);
	
	@Query(nativeQuery = true, value = "SELECT * FROM persons WHERE id=?1")
	public Person getPersonById2(Long id);

}

