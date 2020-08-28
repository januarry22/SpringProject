package com.project.example.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.project.example.domain.User;


public interface UserService extends UserDetailsService {
	// 권한 생성
	public void createAuthorities(User user);

	// 유저 정보
	public User readUser(String username);

	// 유저 생성
	public void createUser(User user);

	// 권한 읽기
	Collection<GrantedAuthority> getAuthorities(String username);

}
