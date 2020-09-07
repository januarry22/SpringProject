package com.project.example.service;

import java.util.List;

import com.project.example.domain.Board;
import com.project.example.domain.PagingCriteria;

public interface BoardService {

	public List<Board> getBoardList(Board board);
	
	// BoardServiceMpl 에서 return한 값

	public int selectBoardTotalCount(Board board);
	
	public void boardWrite(Board board);
	
	public Board getDetail(String b_id);
	
	public Board boardDetail(String b_id);
	
	public void boardDelete(String b_id);
	
	public void boardUpdate(Board board);
}
