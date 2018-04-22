package com.meltube.community.web;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.meltube.community.service.CommunityService;
import com.meltube.community.vo.CommunityVO;
import com.meltube.melonChart.service.MelonChartService;
import com.meltube.melonChart.vo.MelonChartVO;
import com.meltube.member.constants.Member;
import com.meltube.member.vo.MemberVO;
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
	//////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	
	
	////////////////////////좋아요순으로 정렬하기////////////////////////////
	@RequestMapping("/sortList")
	public ModelAndView viewSortListPage() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("community/main");

		List<CommunityVO> sortList = communityService.getLikeList();

		mav.addObject("sortList", sortList);

		return mav;
	}
	//////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	
	
	////////////////// 글쓰기//////////////////////////////////////////////
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

	
	
	
	
	
	
	
	
	//////////// 좋아요/////////////////////////
	@RequestMapping("/likeIt/{id}")
	public String rCount(@PathVariable int id) {

		if (communityService.increaseR(id)) {

			System.out.println("asdf");
			return "redirect:/view/" + id;
		}
		return "redirect:/";
	}
	//////////////////////////////////////////

	
	
	
	
	
	
	
	
	
	/////////////////////////긁 읽기 기능/////////////////////////////
	@RequestMapping("/read/{id}")
	public String viewCount(@PathVariable int id) {

		if (communityService.increaseV(id)) {
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

	
	
	
	
	
	
	/////////////////////////이미지,동영상 보이기///////////////////////////////
	@RequestMapping("/get/{id}")
	public void download(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {

		CommunityVO community = communityService.getOne(id);
		String filename = community.getDisplayFilename();
		// String img = community.getSingImg();

		DownloadUtil download = new DownloadUtil("C:\\Users\\YongGwan\\Desktop\\uploadFiles\\" + filename);

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

		DownloadUtil download = new DownloadUtil("C:\\Users\\YongGwan\\Desktop\\uploadImg\\" + img);

		try {
			download.download(request, response, img);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

	}
	//////////////////////////////////////////

	
	
	
	
	
	
	
	
	
	/////////////////////장르별 나누기/////////////////////
	@RequestMapping("/distGenre")
	public ModelAndView viewGenrePage(
			@RequestParam(value = "id", required = false, defaultValue = "ballad") String id) {

		ModelAndView view = new ModelAndView();
		view.setViewName("community/divideGenre");

		if (id.equals("ballad")) {
			List<CommunityVO> genreList = communityService.getGenre(id);
			view.addObject("genreList", genreList);
		} else if (id.equals("rap")) {

			String kk = "rap&hiphop";
			List<CommunityVO> genreList = communityService.getGenre(kk);
			view.addObject("genreList", genreList);
		} else if (id.equals("RnB/Soul")) {

			List<CommunityVO> genreList = communityService.getGenre(id);
			view.addObject("genreList", genreList);
		} else if (id.equals("rock/metal")) {

			List<CommunityVO> genreList = communityService.getGenre(id);
			view.addObject("genreList", genreList);
		} else if (id.equals("dance")) {

			List<CommunityVO> genreList = communityService.getGenre(id);
			view.addObject("genreList", genreList);
		}

		return view;

	}
	////////////////////////////////////////////

	
	
	
	
	
	
	
	/////////////////// 멜론차트페이지//////////////////////////
	@RequestMapping("/melonChartViewAction")
	public ModelAndView viewMChart() {

		String target = "http://www.melon.com/chart/";

		ModelAndView view = new ModelAndView();
		view.setViewName("community/melonChartView");

		try {
			// doc 에 내가 원하는 페이지의 모든 내용이 담겨져있음
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
		// 받기전에 쌓이니깐 먼저 지워줌
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

				// 랭크 가 넘어올때 앞에 0이 안붙는 바람에 정렬할때 제대로 되지 않음 그래서 1 은 01로 2는 02로 바꿔주는 작업함
				if (Integer.parseInt(td.get(1).select("span.rank").text()) < 10) {
					String tt = "0" + td.get(1).select("span.rank").text();
					melonChartVO.setRank(tt);
				} else {
					melonChartVO.setRank(td.get(1).select("span.rank").text());
				}

				melonChartService.createCommunityMelon(melonChartVO);

			}
		}
	}
	/////////////////////////////////////////////////////////

	
	
	
	
	
	///////////////////////노래 찾기 기능//////////////////////////////////
	@RequestMapping(value = "/searchView/{keyword}")
	public ModelAndView doRegistAction(@PathVariable String keyword) {

		ModelAndView view = new ModelAndView();

		view.setViewName("community/search");

		List<CommunityVO> searchList = communityService.getSearchKeyword(keyword);


		List<CommunityVO> singerMatchList = new ArrayList<CommunityVO>();
		List<CommunityVO> titleMatchList = new ArrayList<CommunityVO>();
		List<CommunityVO> lyricsMatchList = new ArrayList<CommunityVO>();
		
		for (int i = 0; i < searchList.size(); i++) {
			if (searchList.get(i).getSinger().equals(keyword) ) {
				singerMatchList.add(searchList.get(i));
				
			}
			else if (searchList.get(i).getSinger().contains(keyword) ) {
				singerMatchList.add(searchList.get(i));
				
			}

			if (searchList.get(i).getTitle().equals(keyword) ) {
				titleMatchList.add(searchList.get(i));
			}
			
			else if(searchList.get(i).getTitle().contains(keyword)) {
				titleMatchList.add(searchList.get(i));
			}
			

			
			if(searchList.get(i).getLyrics().contains(keyword)) {
				lyricsMatchList.add(searchList.get(i));
			}
			
			
		}
		view.addObject("singerList", singerMatchList);
		view.addObject("titleList", titleMatchList);
		view.addObject("lyList", lyricsMatchList);

		return view;

	}
	/////////////////////////////////////////////////////////

	
	
	
	//////////////////////////////수정하기/////////////////////////////////////////
	@RequestMapping(value = "/modify/{id}", method=RequestMethod.GET)
	public ModelAndView viewModifyPage(@PathVariable int id, HttpSession session) {
		

		MemberVO member = (MemberVO) session.getAttribute(Member.USER);
		CommunityVO community = communityService.getOne(id);

		int userId = member.getId();

		if (userId != community.getUserId()) {
			return new ModelAndView("error/404");
		}
		
		ModelAndView view = new ModelAndView();
		view.setViewName("community/write");
		view.addObject("communityVO", community);
		view.addObject("mode", "modify");
		return view;
	}
	
	
	@RequestMapping(value = "/modify/{id}", method=RequestMethod.POST)
	public String doModifyAction(@PathVariable int id,
									HttpSession session,
									HttpServletRequest request,
									@ModelAttribute("writeForm") @Valid CommunityVO communityVO,
									Errors errors) {
		
		
		MemberVO member = (MemberVO)session.getAttribute(Member.USER);
		CommunityVO originalVO = communityService.getOne(id);
		
		System.out.println("멤바 아이디" + member.getId());
		System.out.println("오리지날 아이디" + originalVO.getUserId());
		if( member.getId() != originalVO.getUserId() ) {
			return "member/tt";
		}
		
		if( errors.hasErrors()) {
			return "redirect:/modify/" + id;
		}
		
		CommunityVO newCommunity = new CommunityVO();
		newCommunity.setId( originalVO.getId() );
		newCommunity.setUserId( member.getId() );
		
		boolean isModify =false;
		
		String asIs = "";
		String toBe = "";
		
		
		
		// 1.IP 변경확인
		String ip = request.getRemoteAddr();
		if( !ip.equals(originalVO.getRequestIp())) {
			//달라진 ip만 newCommunity 여기에 넣어준다
			newCommunity.setRequestIp(ip);
			isModify =true;
			asIs +="IP :" + originalVO.getRequestIp() + "<br/>";
			toBe +="IP :" + ip + "<br/>";
		}
		
		//2. 제목 변경확인
		if( !originalVO.getTitle().equals( communityVO.getTitle())) {
			newCommunity.setTitle(communityVO.getTitle());
			isModify =true;
			asIs +="Title :" + originalVO.getTitle() + "<br/>";
			toBe +="Title :" + communityVO.getTitle() + "<br/>";
			
		}
		
		//3. 가사 변경확인
		if( !originalVO.getLyrics().equals( communityVO.getLyrics())) {
			newCommunity.setLyrics(communityVO.getLyrics());
			isModify =true;
			asIs +="Lyrics :" + originalVO.getLyrics() + "<br/>";
			toBe +="Lyrics :" + communityVO.getLyrics() + "<br/>";
			
		}
		
		//4. 파일 변경확인
		//아래 이프문은 데이터가 있는지 없는지 알려줌 데이터의 이름의 길이로 해서 널이면 당연히 0임
		if( communityVO.getDisplayFilename().length() >0) {
			File file = new File("C:\\\\Users\\\\YongGwan\\\\Desktop\\\\uploadFiles\\\\" + communityVO.getDisplayFilename());
			file.delete();
			communityVO.setDisplayFilename("");
		}
		else {
			communityVO.setDisplayFilename(originalVO.getDisplayFilename());
		}
		
		communityVO.save();
		
		if(!originalVO.getDisplayFilename().equals(communityVO.getDisplayFilename() )) {
				newCommunity.setDisplayFilename( communityVO.getDisplayFilename() );
				isModify = true;
				
				asIs +="File :" + originalVO.getDisplayFilename() + "<br/>";
				toBe +="File :" + communityVO.getDisplayFilename() + "<br/>";
			
		}
		
		//5. 노래 이미지 변경확인
		if( communityVO.getSingImg().length() >0) {
			File file = new File("C:\\\\Users\\\\YongGwan\\\\Desktop\\\\uploadImg\\\\" + communityVO.getSingImg());
			file.delete();
			communityVO.setSingImg("");
		}
		else {
			communityVO.setSingImg(originalVO.getSingImg());
		}
		
		communityVO.imgSave();
		
		if(!originalVO.getSingImg().equals(communityVO.getSingImg() )) {
				newCommunity.setSingImg( communityVO.getSingImg() );
				isModify = true;
				
				asIs +="File :" + originalVO.getSingImg() + "<br/>";
				toBe +="File :" + communityVO.getSingImg() + "<br/>";
			
		}
		
		
		//6. 변경이 없는지 확인
		if( isModify) {
			//6. update 하는 service code 호출
			communityService.updateCommunity(newCommunity);
		}
		
		return "redirect:/view/" +id;
	}
	///////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
