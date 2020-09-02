package com.project.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.example.domain.Board;
import com.project.example.domain.PagingCriteria;

@Mapper
public interface BoardMapper {

	public List<Board> selectBoardList(Board board);
	// DB에서 가져옴
	
	public int selectBoardTotalCount(Board board);

	public void boardWrite(Board board);
	
	public Board getDetail(String b_id);
	
	public Board boardDetail();
	
	public void boardDelete(String b_id);
	
	public void boardUpdate(Board board);
	
}
