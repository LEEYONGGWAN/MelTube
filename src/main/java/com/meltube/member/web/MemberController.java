package com.meltube.member.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

		// db에 있는 정보에서 멤버를 찾아서 로그인멤버에 넣어줌 만약에 디비에 아무것도 없으면 null값임
		MemberVO loginMember = memberService.readMember(memberVO);
	
		if (loginMember != null) {
			session.setAttribute(Member.USER, loginMember);
			return "redirect:/";
		}

		return "redirect:/";

	}
////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String viewRegistPage() {

		return "member/regist";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public ModelAndView doRegistAction(@ModelAttribute("registForm") @Valid MemberVO memberVO, Errors errors) {
			System.out.println("일단 포스트 조인 들어옴");
		
		if (errors.hasErrors()) {
			System.out.println("해즈 에러");
			return new ModelAndView("member/tt");
		}
		
		if (memberService.createMember(memberVO)) {
			System.out.println("크리에이트 멤바");
			return new ModelAndView("redirect:/");
		}
		System.out.println("마지막 모델엔뷰");
		return new ModelAndView("member/join");
	}

	@RequestMapping("/logout")
	public String doLogoutAction(HttpSession session) {

		// 세션 소멸
		session.invalidate();

		return "redirect:/";
	}
///////////////////////////////////////////////////////////////////////////	
	
	@RequestMapping("/api/exists/email")
	@ResponseBody
	public Map<String, Boolean> apiIsExistsEmail(@RequestParam String email){
		
		boolean isExists = memberService.readCountMemberEmail(email);
		System.out.println("이메일" + email +" 불린은 "+isExists);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("response", isExists);
		return response;
		
	}
	
	
	@RequestMapping("/api/exists/nickname")
	@ResponseBody
	public Map<String, Boolean> apiIsExistsNickname(@RequestParam String nickname){
		
		boolean isExists = memberService.readCountMemberNickname(nickname);
		System.out.println("닉네임"+ nickname + "불린은" +isExists);
		
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("response", isExists);
		return response;
	}
	
	
	
}
