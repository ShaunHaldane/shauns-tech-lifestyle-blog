package com.ShaunHaldane.shaunstechlifestyleblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ShaunHaldane.shaunstechlifestyleblog.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public boolean existsByLogin(String login);
	
	public User findByLogin(String login);
}
