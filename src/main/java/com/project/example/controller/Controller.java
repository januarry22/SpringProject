package com.project.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.cj.xdevapi.JsonArray;
import com.project.example.domain.Board;
import com.project.example.domain.Comment;
import com.project.example.domain.Pagination;
import com.project.example.domain.PagingCriteria;
import com.project.example.domain.User;
import com.project.example.service.BoardService;
import com.project.example.service.UserService;

@org.springframework.stereotype.Controller
public class Controller {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BoardService boardservice;
	@Autowired
	UserService userService;

	@RequestMapping("/")
	public String home(Model model) {
//		List<Board> list = boardservice.selectBoardList();
//		model.addAttribute("list",list);
		// view에서 사용 list에 메소드에서 가져온 list 삽입
//		logger.debug("debug");
//		logger.info("info");
//		logger.error("error");

		return "/index";

	}

	@RequestMapping("/beforeSignUp")
	public String beforeSignUp() {
		return "/signup";
	}

	@RequestMapping("/signup")
	public String signUp(User user) {
		// 비밀번호 암호화
		String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());

		// 유저 데이터 세팅
		user.setPassword(encodedPassword);
		;
		user.setAccountNonExpired(true);
		user.setEnabled(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_USER"));

		// 유저 생성
		userService.createUser(user);
		// 유저 권한 생성
		userService.createAuthorities(user);

		return "/login";
	}

	@RequestMapping(value = "/login")
	public String beforeLogin(Model model) {
		return "/login";
	}

	@Secured({ "ROLE_ADMIN" })
	@RequestMapping(value = "/admin")
	public String admin(Model model) {
		return "/admin";
	}

	@Secured({ "ROLE_USER" })
	@RequestMapping(value = "/user/info")
	public String userInfo(Model model) {

		return "/user_info";
	}

	@RequestMapping(value = "/denied")
	public String denied(Model model) {
		return "/denied";
	}

	@Secured({ "ROLE_USER" })
	@RequestMapping(value = "/user/update")
	public String beforeUpdate() {
		return "/user_update";
	}

	@Secured({ "ROLE_USER" })
	@RequestMapping("/user_update")
	public String userUpdate(User user) {

		userService.userUpdate(user);

		return "/user_info";
	}

	@RequestMapping(value = "/user/delete")
	public String beforeuserDelete(User user) {

		return "/user_delete";
	}

	@RequestMapping(value = "/user_delete")
	public String userDelete(String username) {

		userService.userDelete(username);
		return "/login";
	}

	@RequestMapping(value = "/board_Write")
	public String beforeboardWrite(String username, HttpSession session) {
//		String user= (String) session.getAttribute("username");
//
//		model.addAttribute("user",user);
//		session.setAttribute("user", user);

		return "/boardWrite";
	}

	@RequestMapping(value = "/boardWrite")
	public String boardWrite(Board board) {
		boardservice.boardWrite(board);

		return "/boardList";
	}

	@GetMapping("boardList")
	//@ModelAttribute("board") Board board,
	public String boardList( Model model, Pagination page
			, @RequestParam(value="nowPage", required = false)String nowPage) {
		
		int total=boardservice.selectBoardTotalCount();
		
//		if(nowPage==null&& cntPerPage==null) {
//			nowPage="1";
//			cntPerPage="5";
//		}else 
		if(nowPage==null) {
			nowPage="1";
		}
//		else if(cntPerPage==null) {
//			cntPerPage="5";
//		}
		
		page=new Pagination(total, Integer.parseInt(nowPage));
		model.addAttribute("paging",page);
	

	//	List<Board> boardList = boardservice.getBoardList(board);
		model.addAttribute("board", boardservice.getBoardList(page));
		

		return "/boardList";
	}

//	@RequestMapping(value="/boardDetail")
//	public String getDetail(String b_id) {
//
//	
//		boardservice.getDetail(b_id);
//		
//		model.seta
//		
//		return "/boardDetail";
//		
//	}

	@GetMapping(value = "/boardDetail")
	public String boardDetail( Model model, @RequestParam(value = "b_id") String b_id) {

		model.addAttribute("board", boardservice.boardDetail(b_id));
		boardservice.updateHit(b_id);

		return "/boardDetail";
	}

	@RequestMapping(value = "/boardUpdate")
	public String boardUpdate(Board board) {
		boardservice.boardUpdate(board);
		return "/boardDetail";

	}

	@GetMapping(value = "/board/Update")
	public String beforeboardUpdate( Model model, @RequestParam(value = "b_id") String b_id) {

		Board board = boardservice.boardDetail(b_id);

		model.addAttribute("board", board);
		return "/boardUpdate";

	}

	@RequestMapping(value = "/boardDelete")
	public String boardDelete(String b_id) {

		boardservice.boardDelete(b_id);
		return "/boardList";

	}
	
	
	// Comment
	
	
	@RequestMapping(value="/commentInsert")
	@ResponseBody
	public String jspcommentInsert(Comment comment) {
		
	//	String writer=(String)session.getAttribute("b_writer");

		
		boardservice.commentInsert(comment);
		
		return "/commentList";

		
	}
	
	@RequestMapping(value="/commentList")
	@ResponseBody
	public List<Comment> jspcommentList(@ModelAttribute("board")Board board, Model model, 
			@RequestParam(value = "bno") Integer commentB_id) {
		

		return boardservice.commentList(commentB_id);
	}
	
	@RequestMapping(value="/commentUpdate")
	@ResponseBody
	public int jspcommentUpdate(Comment comment) {
		
		boardservice.commentUpdate(comment);
		
		return boardservice.commentUpdate(comment);
	}
	

	@RequestMapping(value="/commentDelete")
	@ResponseBody
	public int jspcommentDelete(Integer c_id) {
			

		boardservice.commentDelete(c_id);
			return boardservice.commentDelete(c_id);
	}
	}

