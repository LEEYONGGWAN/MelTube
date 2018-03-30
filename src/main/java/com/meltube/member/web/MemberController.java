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

import com.meltube.community.service.CommunityService;
import com.meltube.member.constants.Member;
import com.meltube.member.service.MemberService;
import com.meltube.member.vo.MemberVO;

@Controller
public class MemberController {

	private MemberService memberService;
	private CommunityService communityService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public void setCommunityService(CommunityService communityService) {
		this.communityService = communityService;
	}
	
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewLoginPage(HttpSession session) {

		if (session.getAttribute(Member.USER) != null) {
			return "redirect:/";
		}
		return "community/main";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLoginAction(MemberVO memberVO, Errors errors, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		// DB에 계정이 존재하지 않을 경우로 변경
		// db에 있는 정보에서 멤버를 찾아서 로그인멤버에 넣어줌 만약에 디비에 아무것도 없으면 null값임
		
		System.out.println("로그인액션 들어옴");
		System.out.println("ZZZZZZZZZZZZ" + memberVO.getEmail());
		System.out.println("ZZZZZZZZZZZZ" + memberVO.getId());
		
		MemberVO loginMember = memberService.readMember(memberVO);
	

	
		if (loginMember != null) {
			
			session.setAttribute(Member.USER, loginMember);
			System.out.println("로긴 성공");
			return "community/main";
		}

		return "redirect:/login";

	}

	
	
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String viewRegistPage() {

		return "member/regist";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public ModelAndView doRegistAction(@ModelAttribute("registForm") @Valid MemberVO memberVO, Errors errors) {

		
		if (errors.hasErrors()) {
			return new ModelAndView("member/join");
		}
		
		System.out.println(memberVO.getNickname());
		System.out.println(memberVO.getPassword());

		if (memberService.createMember(memberVO)) {
			return new ModelAndView("redirect:/login");
		}
		
		return new ModelAndView("member/join");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/logout")
	public String doLogoutAction(HttpSession session) {

		// 세션 소멸
		session.invalidate();

		return "redirect:/login";
	}
}
