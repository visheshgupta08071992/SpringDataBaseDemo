package com.in28minutes.database.databasedemo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.database.databasedemo.entity.Person.Person;

//Repository
@Repository
@Transactional
public class PersonJPARepository {

	//Connect to Database
	@PersistenceContext
	EntityManager entityManager;
	public Person findById(int id){
		return entityManager.find(Person.class,id);
	}

	public Person insert(Person person){
		return entityManager.merge(person);
	}

	public void deleteByID(int id){
		Person person=findById(id);
		entityManager.remove(person);
	}

}
