package com.meltube.community.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.meltube.community.service.CommunityService;
import com.meltube.community.vo.CommunityVO;

@Controller
public class CommunityController {
	private CommunityService communityService;

	public void setCommunityService(CommunityService communityService) {
		this.communityService = communityService;
	}
//adsf
	/////////////////////// 메인화면 보기 ///////////////////////////////////
	@RequestMapping("/")
	public ModelAndView viewListPage() {

		ModelAndView view = new ModelAndView();

		// /WEB-INF/view/community/main.jsp
		view.setViewName("community/main");

		List<CommunityVO> singList = communityService.getAll();
		
		
		
		view.addObject("communityList", singList);
		
		return view;
	}
	////////////////////////////////////////////////////////////////////////
	
	//////////////////글쓰기//////////////////////////////////////////////
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String viewWritePage() {

		return "community/write";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public ModelAndView doWrite(@ModelAttribute("writeForm") @Valid CommunityVO communityVO, Errors errors,
			HttpSession session, HttpServletRequest request) {
		
		System.out.println("write 들어옴");
		

		String requestIp = request.getRemoteAddr();
		communityVO.setRequestIp(requestIp);
		
		System.out.println(communityVO);
		
		boolean isSuccess = communityService.createCommunity(communityVO);
		
		
		
		// 만약에 글쓰기 등록이 완료 되었다면~ 리스트로 정보 보내고 다시 가겠다.
		if (isSuccess) {
			//return new ModelAndView("redirect:/");
			return new ModelAndView("redirect:/");

		}

		return new ModelAndView("redirect:/write");
	}
	/////////////////////////////////////////////////////////////////////////////
	
	//////////////////////////글 눌렀을떄 보기///////////////////////////////////////
	@RequestMapping("/recommend/{id}")
	public String rCount(@PathVariable int id) {

		if (communityService.increaseR(id)) {
			return "redirect:/view/" + id;
		}
		return "redirect:/";
	}
	
	@RequestMapping("/read/{id}")
	public String viewCount(@PathVariable int id) {
		
		if(communityService.increaseV(id)) {
			return "redirect:/view/" + id;
		}
		return "redirect:/";
		
	}

	
	
	
	@RequestMapping("/view/{id}")
	public ModelAndView viewViewPage(@PathVariable int id) {

		ModelAndView view = new ModelAndView();
		view.setViewName("community/view");

		CommunityVO community = communityService.getOne(id);

		view.addObject("community", community);

		return view;
	}
	//////////////////////////////////////////////////////////////////////////

}
