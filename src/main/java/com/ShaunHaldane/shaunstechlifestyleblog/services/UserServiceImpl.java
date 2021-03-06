package com.ShaunHaldane.shaunstechlifestyleblog.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

import com.ShaunHaldane.shaunstechlifestyleblog.models.Role;
import com.ShaunHaldane.shaunstechlifestyleblog.models.User;
import com.ShaunHaldane.shaunstechlifestyleblog.repositories.RoleRepository;
import com.ShaunHaldane.shaunstechlifestyleblog.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public void createNewAccount(User user) {
		user.setEnabled(true);
		user.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(user.getPassword()));
		userRepository.save(user);
		
		Role role = new Role();
		role.setLogin(user.getLogin());
		role.setRole("ROLE_CLIENT");
		roleRepository.save(role);
	}

	@Override
	public boolean loginExists(String login) {
		return userRepository.existsByLogin(login);
	}

}
