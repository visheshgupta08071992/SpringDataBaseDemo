package com.in28minutes.database.databasedemo.SpringData;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.database.databasedemo.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	public List<User> findByRole(String Role);
}
