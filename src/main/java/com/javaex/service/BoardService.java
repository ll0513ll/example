package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.AnswerVo;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired BoardDao boardDao;
	
	public void add(BoardVo boardVo) {
			
		boardDao.insert(boardVo);
	}
	
	public List<BoardVo> getList() {
		
		return boardDao.getList();
		
	}
	
	public BoardVo getContent(int no) {
		
		return boardDao.getContent(no);
	}
	
	public void add_answer(int no,int Bdepth,AnswerVo answerVo) {
		
		answerVo.setGroup_no(no);
		answerVo.setDepth(Bdepth);
		boardDao.add_answer(answerVo);
	}
	
	public List<AnswerVo> getAnswerList(){
		
		return boardDao.getAnswerList();
	}

}
