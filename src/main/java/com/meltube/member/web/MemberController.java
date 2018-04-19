package com.meltube.member.web;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
			return "community/main";
		}
		
		return "member/login";
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

		return "member/login";

	}
////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String viewRegistPage() {

		return "member/regist";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public ModelAndView doRegistAction(@ModelAttribute("registForm") @Valid MemberVO memberVO, Errors errors) {
		
		if (errors.hasErrors()) {
			return new ModelAndView("member/tt");
		}
		
		if (memberService.createMember(memberVO)) {
			return new ModelAndView("redirect:/");
		}
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
	
	//////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping("/delete/process1")
	public String viewVerifyPage() {
		return "member/delete/process1";
	}
	
	@RequestMapping("/delete/process2")
	public ModelAndView viewDeleteMyCommunitiesPage(@RequestParam(required=false, defaultValue = "") String password
													, HttpSession session) {
		
		if( password.length() == 0 ) {
			return new ModelAndView("error/404");
		}
		
		System.out.println("여기들어옴");
		
		MemberVO member = (MemberVO) session.getAttribute(Member.USER);
		member.setPassword(password);

		MemberVO verifyMember = memberService.readMember(member);
		if(verifyMember == null) {
			return new ModelAndView("redirect:/delete/process1");
		}
		//TODO 내가 작성한 게시글의 개수 가져오기
		int myCommunitiesCount = communityService.readMyCommunitiesCount(verifyMember.getId());
		
		
		ModelAndView view = new ModelAndView();
		view.setViewName("member/delete/process2");
		view.addObject("myCommunitiesCount", myCommunitiesCount);
		
		
		//난수값을 만든다음 token 이라는 이름으로 집어넣어라(process3 으로 넘어갈때 중간들에 들어오는애들 못들어오)		
		String uuid = UUID.randomUUID().toString();
		session.setAttribute("__TOKEN__", uuid);
		
		view.addObject("token", uuid);
		
		return view;
	}
	
	@RequestMapping("/account/delete/{deleteFlag}")
	public String removeId(HttpSession session,
							@RequestParam(required=false, defaultValue="") String token,
							@PathVariable String deleteFlag)  {

		String sessionToken = (String) session.getAttribute("__TOKEN__");
		System.out.println(sessionToken);
		if( sessionToken == null || !sessionToken.equals(token)) {
			return "error/404";
		}
		
		
		MemberVO member = (MemberVO) session.getAttribute(Member.USER);

		if (member == null) {
			return "redirect:/login";
		}

		int id = member.getId();

		if (memberService.removeMember(id, deleteFlag)) {
			session.invalidate();
		}
		return "member/delete/delete";
	}
	
	
	
	
}
