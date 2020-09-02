package com.project.example.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.example.domain.Board;
import com.project.example.domain.PaginationInfo;
import com.project.example.domain.PagingCriteria;
import com.project.example.mapper.BoardMapper;

@Service("BoardServiceMpl")
public class BoardServiceMpl implements BoardService{

	@Autowired BoardMapper boardmapper;
	// mapper로 가져온 파일 boardmapper 주입
	@Override
	public List<Board> selectBoardList(Board board) {
		// TODO Auto-generated method stub
		List<Board> boardList=Collections.emptyList();
		
		int boardTotalCount=boardmapper.selectBoardTotalCount(board);

		PaginationInfo info= new PaginationInfo(board);
		info.setTotalRecordCount(boardTotalCount);
		
		board.setPaginationInfo(info);
		
		if(boardTotalCount>0) {
			boardList=boardmapper.selectBoardList(board);
		}
		return boardList;
		// BoardService.java로 return함
	}
	
	@Override
	public void boardWrite(Board board) {
		// TODO Auto-generated method stub
		boardmapper.boardWrite(board);
	}

	@Override
	public Board getDetail(String b_id) {
		// TODO Auto-generated method stub
		return boardmapper.getDetail(b_id);
	}
	
	public Board boardDetail(String b_id) {
		Board board= boardmapper.getDetail(b_id);
		return board;
	}

	@Override
	public void boardDelete(String b_id) {
		// TODO Auto-generated method stub
		boardmapper.boardDelete(b_id);
		
	}

	@Override
	public void boardUpdate(Board board) {
		// TODO Auto-generated method stub
		boardmapper.boardUpdate(board);
		
	}
	



	

}
