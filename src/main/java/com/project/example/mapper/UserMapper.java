package com.project.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;

import com.project.example.domain.User;

@Mapper
public interface UserMapper {

	// 권한 일기
	public List<GrantedAuthority> readAuthorities(String username);

	// 유저 정보
	public User readUser(String username);

	// 유저 생성
	public void createUser(User user);

	// 권한 생성
	public void createAuthority(User user);
}
