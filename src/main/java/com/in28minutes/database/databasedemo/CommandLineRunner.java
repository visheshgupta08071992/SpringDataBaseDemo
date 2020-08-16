package com.in28minutes.database.databasedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.database.databasedemo.SpringData.UserRepository;
import com.in28minutes.database.databasedemo.entity.User;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

	@Autowired
	UserRepository user;

	@Override
	public void run(String... args) throws Exception {
		user.save(new User("Vishesh","Owner"));
		user.save(new User("Sandesh","Owner"));
		user.save(new User("Harshi","Princess"));
		user.save(new User("Mamta","Queen"));

		for (User user:user.findAll()) {
			System.out.println("Users are : " + user.getName());
		}

		for (User user1:user.findByRole("Owner")) {
			System.out.println("Owners are" + user1.getName());
		}


	}
}
