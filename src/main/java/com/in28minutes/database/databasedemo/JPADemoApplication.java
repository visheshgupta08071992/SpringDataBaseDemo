package com.in28minutes.database.databasedemo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.in28minutes.database.databasedemo.entity.Person.Person;
import com.in28minutes.database.databasedemo.jpa.PersonJPARepository;

//@SpringBootApplication
public class JPADemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JPADemoApplication.class, args);
	}


	@Autowired
	PersonJPARepository personDao;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("No of rows inserted  is " + personDao.insert(new Person(10001,"vishesh","India",
				new Date())));
		System.out.println("No of rows inserted  is " + personDao.insert(new Person("Sandesh","India",
				new Date())));
		System.out.println("Users are {}" + personDao.findById(1));
		personDao.deleteByID(2);


		/*System.out.println("User by id is {}" + personDao.findById(10001));
		System.out.println("No of rows deleted by id is " + personDao.DeleteById(10001));
		System.out.println("No of rows inserted  is " + personDao.Insert(new Person(10004,"vishesh","India",new Date())));*/
	}
}
