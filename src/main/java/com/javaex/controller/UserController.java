package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="joinForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("/user/joinForm");
		
		return "user/joinForm";
	}
	
	@RequestMapping(value="join", method= {RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("/user/join");
		System.out.println(userVo.toString());
		
		userService.join(userVo);
		
		return "user/joinOk";
	}
	
	@RequestMapping(value="loginForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		System.out.println("/user/loginForm");
		
		return "user/loginForm";
	}
	
	@RequestMapping(value="login", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("/user/login");
		System.out.println(userVo.toString());
		
		UserVo authUser = userService.login(userVo);
		
		if(authUser == null) {
			System.out.println("로그인실패");
			return "redirect:/user/loginForm?result=fail";
		} else {
			session.setAttribute("authUser", authUser);
			return "redirect:/main";
		}

	}
	
	@RequestMapping(value="logout", method= {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/main";
	}
	
	@RequestMapping(value="modifyForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(Model model, HttpSession session) {
		System.out.println("/user/modifyForm");
		int no = ((UserVo)session.getAttribute("authUser")).getNo();
		
		UserVo vo = userService.selectId(no);
		
		model.addAttribute("vo", vo);
		
		
		
		return "user/modifyForm";
	}
	
	@RequestMapping(value="modify", method= {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("/user/modify");
		System.out.println(userVo.toString());
		
		userService.modify(userVo);
		
		UserVo vo = (UserVo)session.getAttribute("authUser");
		vo.setName(userVo.getName());
		
		
		return "redirect:/main";
	}

}
