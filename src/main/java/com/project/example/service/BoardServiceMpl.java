package com.project.example.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.example.domain.Board;
import com.project.example.domain.Comment;
import com.project.example.domain.Pagination;
import com.project.example.domain.PaginationInfo;
import com.project.example.domain.PagingCriteria;
import com.project.example.mapper.BoardMapper;

@Service("BoardServiceMpl")
public class BoardServiceMpl implements BoardService{

	@Autowired BoardMapper boardmapper;
	// mapper로 가져온 파일 boardmapper 주입
	@Override
	public List<Board> getBoardList(Pagination page) {
		// TODO Auto-generated method stub
//		List<Board> boardList=Collections.emptyList();
//		
//		int boardTotalCount=boardmapper.selectBoardTotalCount(board);
//
//		PaginationInfo paginationInfo= new PaginationInfo(board);
//		paginationInfo.setTotalRecordCount(boardTotalCount);
//		
//		board.setPaginationInfo(paginationInfo);
//		
//		if(boardTotalCount>0) {
//			boardList=boardmapper.selectBoardList(board);
//		}
//		return boardList;
		
//		int total=selectBoardTotalCount(board);
//		PagingCriteria criteria = new PagingCriteria();
//		criteria.setMaxPage(total);
		
		
		return boardmapper.selectBoardList(page);
		// BoardService.java로 return함
	}
	
	@Override
	public int selectBoardTotalCount() {
	
		return boardmapper.selectBoardTotalCount();
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

	@Override
	public boolean updateHit(String b_id) {
		// TODO Auto-generated method stub
		
		return boardmapper.updateHit(b_id);
	}

	@Override
	public int commentInsert(Comment comment) {
		// TODO Auto-generated method stub

		return boardmapper.commentInsert(comment);
	}

	@Override
	public List<Comment> commentList(Integer commentB_id) {
		// TODO Auto-generated method stub
		return boardmapper.commentList(commentB_id);
	}

	@Override
	public int commentUpdate(Comment comment) {
		// TODO Auto-generated method stub
		return boardmapper.commentUpdate(comment);
	}

	@Override
	public int commentDelete(int c_id) {
		// TODO Auto-generated method stub
		return boardmapper.commentDelete(c_id);
	}




	

}
