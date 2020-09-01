package com.project.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.example.domain.Board;
import com.project.example.mapper.BoardMapper;

@Service("BoardServiceMpl")
public class BoardServiceMpl implements BoardService{

	@Autowired BoardMapper boardmapper;
	// mapper로 가져온 파일 boardmapper 주입
	@Override
	public List<Board> selectBoardList() {
		// TODO Auto-generated method stub
		
		return boardmapper.selectBoardList();
		// BoardService.java로 return함
	}
	
	@Override
	public void boardWrite(Board board) {
		// TODO Auto-generated method stub
		boardmapper.boardWrite(board);
	}
	

	

}
