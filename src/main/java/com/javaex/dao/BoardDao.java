package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.AnswerVo;
import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void insert(BoardVo boardVo) {
		
		sqlSession.insert("board.content_insert",boardVo);
		
	}
	
	public List<BoardVo> getList(){
		
		return sqlSession.selectList("board.getList");
		
	}
	
	public BoardVo getContent(int no) {
		
		return sqlSession.selectOne("board.getContent", no);
	}
	
	public void add_answer(AnswerVo answerVo) {
		
		sqlSession.insert("board.add_answer",answerVo);
	}
	
	public void add_AAnswer(AnswerVo answerVo) {
		
		sqlSession.insert("board.add_AAnswer",answerVo);
	}
	
	public List<AnswerVo> getAnswerList(){
		
		return sqlSession.selectList("board.getAlist");
	}
	
	public AnswerVo getAcontent(int a_no) {
		
		return sqlSession.selectOne("board.getAcontent",a_no);
	}
	
	public void delete(int a_no) {
		
		sqlSession.delete("board.delete",a_no);
	}

}
