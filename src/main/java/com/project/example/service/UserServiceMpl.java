package com.project.example.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.example.domain.User;
import com.project.example.mapper.UserMapper;

@Service
public class UserServiceMpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String u_id) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userMapper.readUser(u_id);
		user.setAuthorities(getAuthorities(u_id));

		return user;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities(String u_id) {
		// TODO Auto-generated method stub
		List<GrantedAuthority> authorities = userMapper.readAuthorities(u_id);

		return authorities;
	}

	@Override
	public User readUser(String u_id) {
		// TODO Auto-generated method stub
		return userMapper.readUser(u_id);
	}

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		userMapper.createUser(user);

	}

	@Override
	public void createAuthorities(User user) {
		// TODO Auto-generated method stub
		userMapper.createUser(user);
	}

}
