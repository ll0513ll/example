package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.AnswerVo;
import com.javaex.vo.BoardVo;

@Controller
public class BoardController {
	
	@Autowired BoardService boardService;
	
	@RequestMapping(value = "/board", method= RequestMethod.GET)
	public String list(Model model) {
		
		List<BoardVo> getList = boardService.getList();
		model.addAttribute("getList", getList);
		System.out.println("게시글 완료");
		
		List<AnswerVo> getAlist = boardService.getAnswerList();
		model.addAttribute("getAlist",getAlist);
		System.out.println("댓글완료");
		
		return "/WEB-INF/views/test/bitBoard.jsp";
		
	}
	
	@RequestMapping(value = "/add")
	public String add() {
		
		return "/WEB-INF/views/board/write.jsp";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(@ModelAttribute BoardVo boardVo) {
		
		boardService.add(boardVo);
		
		return "redirect:/board";
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(@RequestParam("no")int no,Model model) {
		
		BoardVo boardVo = boardService.getContent(no);
		model.addAttribute("content", boardVo);
		return "/WEB-INF/views/board/view.jsp";
	}
	
	@RequestMapping(value = "/reply", method = RequestMethod.GET)
	public String reply(@RequestParam("no")int no,@RequestParam("depth")int depth,Model model) {
		model.addAttribute("no",no);
		model.addAttribute("depth",depth);
		return "/WEB-INF/views/board/replyform.jsp";
	}
	
	@RequestMapping(value = "/add_answer", method = RequestMethod.POST)
	public String add_answer(@RequestParam("no")int no,@RequestParam("Bdepth")int Bdepth,@ModelAttribute AnswerVo answerVo) {
		
		System.out.println(answerVo.toString());
		
		boardService.add_answer(no,Bdepth,answerVo);
		
		return "redirect:/board";
	}
	
	@RequestMapping(value = "/Aview", method = RequestMethod.GET)
	public String Aview(@RequestParam("a_no")int a_no,Model model) {
		
		AnswerVo answerVo = boardService.getAcontent(a_no);
		model.addAttribute("Acontent",answerVo);
		
		return "/WEB-INF/views/board/aview.jsp";
	}
	
	@RequestMapping(value = "/add_AAnswer", method = RequestMethod.GET)
	public String add_AAnswer(@ModelAttribute AnswerVo answerVo) {
		
		boardService.add_AAnswer(answerVo);
		
		return "redirect:/board";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@RequestParam("a_no")int a_no) {
		
		boardService.delete(a_no);
		
		return "redirect:/board";
	}
	
	
}
