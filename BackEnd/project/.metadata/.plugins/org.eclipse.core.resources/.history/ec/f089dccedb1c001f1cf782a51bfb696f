package com.cg.onlinesweetmart.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.onlinesweetmart.entity.Cart;
import com.cg.onlinesweetmart.entity.Role;
import com.cg.onlinesweetmart.entity.User;
import com.cg.onlinesweetmart.exception.SweetMartAPIException;
import com.cg.onlinesweetmart.repository.CartRepository;
import com.cg.onlinesweetmart.repository.RoleRepository;
import com.cg.onlinesweetmart.repository.UserRepository;
import com.cg.onlinesweetmart.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	public List<User> showAllUsers() {
		return userRepository.findAll();
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public void cancelUser(long userId) {
		userRepository.deleteById(userId);;
	}
}
