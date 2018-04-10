package com.meltube.community.web;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.meltube.melonChart.service.MelonChartService;
import com.meltube.melonChart.vo.MelonChartVO;
import com.meltube.util.DownloadUtil;

@Controller
public class CommunityController {
	private CommunityService communityService;
	private MelonChartService melonChartService;
	
	public void setCommunityService(CommunityService communityService) {
		this.communityService = communityService;
	}
	
	public void setMelonChartService(MelonChartService melonChartService) {
		this.melonChartService = melonChartService;
	}
	
	
	/////////////////////// 메인화면 보기 ///////////////////////////////////
	@RequestMapping("/")
	public ModelAndView viewListPage() {

		ModelAndView view = new ModelAndView();
		
		// /WEB-INF/view/community/main.jsp
		view.setViewName("community/main");

		List<CommunityVO> singList = communityService.getAll();
		List<CommunityVO> sortList = communityService.getLikeList();
		List<MelonChartVO> mChart = melonChartService.getMchart();

		
		
		
		
		view.addObject("communityList", singList);
		view.addObject("sortList", sortList);
		view.addObject("mChart", mChart);
		
		
		
		return view;
	}
	////////////////////////////////////////////////////////////////////////
	
	@RequestMapping("/sortList")
	public ModelAndView viewSortListPage() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("community/main");
		
		List<CommunityVO> sortList = communityService.getLikeList();
		
		mav.addObject("sortList", sortList);
		
		return mav;
	}
	
	
	
	
	//////////////////글쓰기//////////////////////////////////////////////
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String viewWritePage() {

		return "community/write";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public ModelAndView doWrite(@ModelAttribute("writeForm") @Valid CommunityVO communityVO, Errors errors,
			HttpSession session, HttpServletRequest request) {
		
		String requestIp = request.getRemoteAddr();
		communityVO.setRequestIp(requestIp);
		
		communityVO.save();
		
		boolean isSuccess = communityService.createCommunity(communityVO);
		
		// 만약에 글쓰기 등록이 완료 되었다면~ 리스트로 정보 보내고 다시 가겠다.
		if (isSuccess) {
			return new ModelAndView("redirect:/");

		}

		return new ModelAndView("redirect:/write");
	}
	/////////////////////////////////////////////////////////////////////////////
	
	
	
	

	
	////////////좋아요/////////////////////////
	@RequestMapping("/likeIt/{id}")
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

	@RequestMapping("/get/{id}")
	public void download(@PathVariable int id, 
			HttpServletRequest request, 
			HttpServletResponse response) {
		
		CommunityVO community = communityService.getOne(id);
		String filename = community.getDisplayFilename();
		System.out.println(filename);
		System.out.println(community.getAlbum());
		System.out.println(community.getDisplayFilename());
		System.out.println(community.getGenre());
		System.out.println(community.getTitle());
		DownloadUtil download = new DownloadUtil("D:/uploadFiles/" + filename);
		
		try {
			System.out.println("try");
			download.download(request, response, filename);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

	}
	
	
}
