package com.meltube.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.meltube.member.constants.Member;
import com.meltube.member.vo.MemberVO;

@Controller
public class MemberController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewLoginPage(HttpSession session) {

		if (session.getAttribute(Member.USER) != null) {
			return "redirect:/";
		}

		return "member/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView doLoginAction(@ModelAttribute("loginForm") @Valid MemberVO memberVO, Errors errors, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
/*		if (memberVO.getId() == null || memberVO.getId().length() == 0) {
			session.setAttribute("status", "emptyId");
			return new ModelAndView("redirect:/login");

		}
		
		if (memberVO.getPassword() == null || memberVO.getPassword().length() == 0) {
			session.setAttribute("status", "emptyPassword");
			return new ModelAndView("redirect:/login");
		}*/

		if(errors.hasErrors()) {
			ModelAndView view = new ModelAndView();
			view.setViewName("member/login");
			view.addObject("MemberVO", memberVO);
			return view;
		}
		
		
		if (memberVO.getId().equals("admin") && memberVO.getPassword().equals("1234")) {

			memberVO.setNickname("관리자");
			session.setAttribute(Member.USER, memberVO);

			session.removeAttribute("status");

			return new ModelAndView("redirect:/");
		}

		session.setAttribute("status", "fail");

		return new ModelAndView("redirect:/login");

	}

	@RequestMapping("/logout")
	public String doLogoutAction(HttpSession session) {

		// 세션 소멸
		session.invalidate();

		return "redirect:/login";
	}
}
