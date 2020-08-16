package com.in28minutes.database.databasedemo.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.database.databasedemo.entity.Person.Person;

@Repository
public class personJdbcDao {
	//select * from person

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Person> findAll() {
      return jdbcTemplate.query("select * from Person",new BeanPropertyRowMapper<>(Person.class));
	}

	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from Person where id="+id+"",
				new BeanPropertyRowMapper<>(Person.class));
	}

	public int DeleteById(int id) {
		return jdbcTemplate.update("DELETE from Person where id="+id+"");
	}

	public int Insert(Person person) {
		return jdbcTemplate.update("INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) \n" +
				"VALUES(?,  ?, ?,?)",new Object[]{person.getId(),person.getName(),person.getLocation(),person.getBirthDate()});
	}
}
