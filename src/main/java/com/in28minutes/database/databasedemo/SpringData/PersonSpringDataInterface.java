package com.in28minutes.database.databasedemo.SpringData;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.database.databasedemo.entity.Person.Person;

public interface PersonSpringDataInterface extends JpaRepository<Person,Integer> {
}
