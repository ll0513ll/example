package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public void add_answer(int no,int depth,AnswerVo answerVo) {
		
		Map<String,Object> bmap = new HashMap<String,Object>();
		bmap.put("no", no);
		bmap.put("depth", depth);
		sqlSession.insert("board.add_answer",bmap);
	}

}
