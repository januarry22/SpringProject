package com.project.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.example.domain.Board;
import com.project.example.domain.Comment;
import com.project.example.domain.Pagination;
import com.project.example.domain.PagingCriteria;

@Mapper
public interface BoardMapper {

	public List<Board> selectBoardList(Pagination page);
	// DB에서 가져옴
	
	public int selectBoardTotalCount();
	

	public void boardWrite(Board board);
	
	public Board getDetail(String b_id);
	
	public Board boardDetail();
	
	public void boardDelete(String b_id);
	
	public void boardUpdate(Board board);
	
	public boolean updateHit(String b_id);
	
	// comment
	
	public Comment commentInsert(Comment comment);
	
	public List<Comment> commentList(String commentB_id);
}
