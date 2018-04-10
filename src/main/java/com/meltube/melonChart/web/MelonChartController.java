package com.meltube.melonChart.web;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.meltube.melonChart.service.MelonChartService;
import com.meltube.melonChart.vo.MelonChartVO;



@Controller
public class MelonChartController {
	
	////////////////////////////////////////////////////////////////////////
	private MelonChartService melonChartService;
	
	public void setMelonChartService(MelonChartService melonChartService) {
		this.melonChartService = melonChartService;
	}
	/////////////////////////////////////////////////////////////////////////
	
	
	@RequestMapping("/getFromMelon")
	public String getPharsing(MelonChartVO melonChartVO) {
		   
		String target = "http://www.melon.com/chart/";

	      try {
	    	  //doc 에 내가 원하는 페이지의 모든 내용이 담겨져있음
	    	 Document doc = Jsoup.connect(target).get();
	         Elements txt = doc.select("tr#lst50.lst50");
	         storeStockData(txt);
	         
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	         return "redirect:/";
	}
	         
	         
	
	private void storeStockData(Elements ele) {
		//받기전에 쌓이니깐 먼저 지워줌
		melonChartService.removeCommunityMelon();
		MelonChartVO melonChartVO;
		
		for (Element node : ele) {
			if (node.hasAttr("data-song-no")) {
				melonChartVO = new MelonChartVO();

				Elements td = node.select("td");
				
				melonChartVO.setmSinger(td.get(5).select("div.ellipsis.rank02 > a").text());
				melonChartVO.setmTitle(td.get(5).select("div.ellipsis.rank01").text());
				
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
	
	
	
}
