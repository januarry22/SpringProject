package com.project.example.service;

import java.util.List;

import com.project.example.domain.Board;

public interface BoardService {

	public List<Board> selectBoardList();
	
	// BoardServiceMpl 에서 return한 값
}
