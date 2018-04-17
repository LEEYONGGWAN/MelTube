package com.meltube.community.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		communityVO.imgSave();
		
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
	//////////////////////////////////////////
	
	
	
	
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
	public void download(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
		
		CommunityVO community = communityService.getOne(id);
		String filename = community.getDisplayFilename();
		//String img = community.getSingImg();
		
		DownloadUtil download = new DownloadUtil("D:/uploadFiles/" + filename);
		
		try {
			download.download(request, response, filename);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

	}
	
	@RequestMapping("/getS/{id}")
	public void Imgdownload(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
		
		CommunityVO community = communityService.getOne(id);
		String img = community.getSingImg();
		
		DownloadUtil download = new DownloadUtil("D:/uploadImg/" + img);
		
		try {
			download.download(request, response, img);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

	}
	//////////////////////////////////////////
	
	//////////////////////////////////////////
	@RequestMapping("/distGenre")
	public ModelAndView viewGenrePage(@RequestParam(value="id", required=false, defaultValue="ballad") String id){

		ModelAndView view = new ModelAndView();
		view.setViewName("community/genre" );
		
		if( id.equals("ballad")   ) {
			List<CommunityVO> genreList = communityService.getGenre(id);
			view.addObject("genreList", genreList);
		}
		else if(id.equals("rap")) {
			
			String kk= "rap&hiphop";
			List<CommunityVO> genreList = communityService.getGenre(kk);
			view.addObject("genreList", genreList);
		}
		else if(id.equals("RnB/Soul")) {
			
			List<CommunityVO> genreList = communityService.getGenre(id);
			view.addObject("genreList", genreList);
		}
		else if(id.equals("rock/metal")) {
			
			List<CommunityVO> genreList = communityService.getGenre(id);
			view.addObject("genreList", genreList);
		}
		else if(id.equals("dance")){
			
			List<CommunityVO> genreList = communityService.getGenre(id);
			view.addObject("genreList", genreList);
		}
		
		return view;
		
	}
	////////////////////////////////////////////
	
	///////////////////멜론차트페이지//////////////////////////
	@RequestMapping("/melonChartViewAction")
	public ModelAndView viewMChart() {
		
		String target = "http://www.melon.com/chart/";
		
		ModelAndView view = new ModelAndView();
		view.setViewName("community/melonChartView");
		
		
	      try {
	    	  //doc 에 내가 원하는 페이지의 모든 내용이 담겨져있음
	    	 Document doc = Jsoup.connect(target).get();
	         Elements txt = doc.select("tr#lst50.lst50");
	         parsingData(txt);
	         List<MelonChartVO> mChart = melonChartService.getMchart();
	         view.addObject("mChart", mChart);
	         
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	         return view;
	}
	
	private void parsingData(Elements ele) {
		//받기전에 쌓이니깐 먼저 지워줌
		melonChartService.removeCommunityMelon();
		MelonChartVO melonChartVO;
		
		for (Element node : ele) {
				
			if (node.hasAttr("data-song-no")) {
				melonChartVO = new MelonChartVO();

				Elements td = node.select("td");
				
				String imgtt = "0" + td.get(3).select("div.wrap > a > img");
				String[] array = imgtt.split(" ");
				String chagejuso = array[4];
				chagejuso = chagejuso.substring(5);
				
				melonChartVO.setmImage(chagejuso);
				
				melonChartVO.setmSinger(td.get(5).select("div.ellipsis.rank02 > a").text());
				
				melonChartVO.setmTitle(td.get(5).select("div.ellipsis.rank01").text());
				
				
				
				//랭크 가 넘어올때  앞에 0이 안붙는 바람에 정렬할때 제대로 되지 않음 그래서 1 은 01로 2는 02로 바꿔주는 작업함
 				if( Integer.parseInt(td.get(1).select("span.rank").text()) < 10) {
					String tt = "0"+ td.get(1).select("span.rank").text();
					melonChartVO.setRank(tt);
				}
				else {
					melonChartVO.setRank(td.get(1).select("span.rank").text());
				}
				
				
				
				melonChartService.createCommunityMelon(melonChartVO);
				
			}
		}
	}
	/////////////////////////////////////////////////////////
	
	/////////////////////////////////////////////////////////
	@RequestMapping(value = "/searchView/{keyword}")
	public ModelAndView doRegistAction(@PathVariable String keyword) {

		ModelAndView view = new ModelAndView();
		
		view.setViewName("community/search");
		
		List<CommunityVO> searchList = communityService.getSearchKeyword(keyword);
		
		
		
	/*	
		List<CommunityVO> singerMatchList
		List<CommunityVO> titleMatchList
	*/
		
		view.addObject("SearchList", searchList);
		
		
		
		
		return view;
	
	
	}
	/////////////////////////////////////////////////////////
	
}
