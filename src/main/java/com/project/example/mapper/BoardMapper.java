package com.project.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.example.domain.Board;

@Mapper
public interface BoardMapper {

	public List<Board> selectBoardList();
	// DB에서 가져옴

	public void boardWrite(Board board);
}
