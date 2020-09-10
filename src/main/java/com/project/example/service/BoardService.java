package com.project.example.service;

import java.util.List;

import com.project.example.domain.Board;
import com.project.example.domain.Comment;
import com.project.example.domain.Pagination;
import com.project.example.domain.PagingCriteria;

public interface BoardService {

	//public List<Board> getBoardList(Board board);
	
	// BoardServiceMpl 에서 return한 값

	public int selectBoardTotalCount();
	
	public void boardWrite(Board board);
	
	public Board getDetail(String b_id);
	
	public Board boardDetail(String b_id);
	
	public void boardDelete(String b_id);
	
	public void boardUpdate(Board board);

	public List<Board> getBoardList(Pagination page);
	
	public boolean updateHit(String b_id);
	
	//comment
	
	public int commentInsert(Comment comment);
	
	public List<Comment> commentList(Integer commentB_id);
	
	public int commentUpdate(Comment comment);
	
	public int commentDelete(int c_id);

}
