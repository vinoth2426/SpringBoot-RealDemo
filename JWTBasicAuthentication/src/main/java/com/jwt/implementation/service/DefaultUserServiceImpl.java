package com.jwt.implementation.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.implementation.model.User;
import com.jwt.implementation.model.UserDTO;
import com.jwt.implementation.repository.UserRepository;

@Service
public class DefaultUserServiceImpl implements DefaultUserService {

	@Autowired
	UserRepository userRepo;

	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUserName(username);
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				new ArrayList<>());
	}

	@Override
	public User save(UserDTO userRegisteredDTO) {

		User user = new User();
		user.setEmail(userRegisteredDTO.getEmail());
		user.setUserName(userRegisteredDTO.getUserName());
		user.setPassword(passwordEncoder.encode(userRegisteredDTO.getPassword()));
		return userRepo.save(user);
	}

}
