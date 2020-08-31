package com.project.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;

import com.project.example.domain.User;

@Mapper
public interface UserMapper {

	// 권한 읽기
	public List<GrantedAuthority> readAuthorities(String username);

	// 유저 정보
	public User readUser(String username);

	// 유저 생성
	public void createUser(User user);

	// 권한 생성
	public void createAuthority(User user);
	
	// 정보 수정
	public void userUpdate(User user);
	
	// 회원 삭제
	public void userDelete(String username);
}
