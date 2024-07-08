package com.gyojincompany.profile.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gyojincompany.profile.dao.MemberDao;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@GetMapping(value = "/")
	public String home() {
		return "index";
	}
	
	@GetMapping(value = "/index")
	public String index() {
		return "index";
	}
	
	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@GetMapping(value = "/join")
	public String join() {
		return "join";
	}
	
	@GetMapping(value = "/profile")
	public String profile() {
		return "profile";
	}
	
	@GetMapping(value = "/contact")
	public String contact() {
		return "contact";
	}
	
	@GetMapping(value = "/write")
	public String write() {
		return "writeForm";
	}
	
	@GetMapping(value = "/list")
	public String list() {
		return "boardlist";
	}
	
	@PostMapping(value = "/joinOk")
	public String joinOk(HttpServletRequest request, Model model) {
		
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);		
		
		int idCheck = memberDao.idcheckDao(request.getParameter("mid"));
		// idCheck == 1이면 가입불가, 0이면 가입가능
		
		if (idCheck == 1) {//참이면 가입불가
			model.addAttribute("joinFail", 1);			
		} else {
			//가입성공
			memberDao.joinDao(request.getParameter("mid"), request.getParameter("mpw"), request.getParameter("mname"), request.getParameter("memail"));
			model.addAttribute("mid", request.getParameter("mid"));
			model.addAttribute("mname", request.getParameter("mname"));			
		}
		return "joinOk";
	}
	
}
