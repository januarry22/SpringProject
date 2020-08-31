package com.project.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.example.domain.Board;
import com.project.example.domain.User;
import com.project.example.service.BoardService;
import com.project.example.service.UserService;

@org.springframework.stereotype.Controller
public class Controller {
	
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired BoardService boardservice;
	@Autowired UserService userService;
	
	@RequestMapping("/")
	public String home(Model model) {
		List<Board> list = boardservice.selectBoardList();
		model.addAttribute("list",list);
		// view에서 사용 list에 메소드에서 가져온 list 삽입
		logger.debug("debug");
		logger.info("info");
		logger.error("error");
		
		return "/index";
		
	}
	
	@RequestMapping("/beforeSignUp")
	public String beforeSignUp() {
		return "/signup";
	}
	
	@RequestMapping("/signup")
	public String signUp(User user){
		//비밀번호 암호화
		String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
		
		//유저 데이터 세팅
		user.setPassword(encodedPassword);;
		user.setAccountNonExpired(true);
		user.setEnabled(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_USER"));
		
		//유저 생성
		userService.createUser(user);
		//유저 권한 생성
		userService.createAuthorities(user);
		
		return "/login";
	}
	
	
	@RequestMapping(value="/login")
	public String beforeLogin(Model model) {
		return "/login";
	}

	@Secured({"ROLE_ADMIN"})
	@RequestMapping(value="/admin")
	public String admin(Model model) {
		return "/admin";
	}
	
	@Secured({"ROLE_USER"})
	@RequestMapping(value="/user/info")
	public String userInfo(Model model) {
		return "/user_info";
	}
	
	@RequestMapping(value="/denied")
	public String denied(Model model) {
		return "/denied";
	}

	@Secured({"ROLE_USER"})
	@RequestMapping(value="/user/update")
	public String beforeUpdate( ) {
		return "/user_update";
	}
	
	@Secured({"ROLE_USER"})
	@RequestMapping("/user_update")
	public String userUpdate(User user) {
		
		//비밀번호 암호화
//		String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
//		
//		//유저 데이터 세팅
//		user.setPassword(encodedPassword);;
//		user.setAccountNonExpired(true);
//		user.setEnabled(true);
//		user.setAccountNonLocked(true);
//		user.setCredentialsNonExpired(true);
//		user.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_USER"));
//		
		userService.userUpdate(user);
	//	userService.createAuthorities(user);
		
		return "/user_info";
	}
	
	@Secured({"ROLE_USER"})
	@RequestMapping(value="/user/delete")
	public String beforeuserDelete(User user) {
		
		return "/user_delete";
	}

	@RequestMapping(value="/user_delete")
	public String userDelete(String username) {
		
		userService.userDelete(username);
		return "/login";
	}


}
