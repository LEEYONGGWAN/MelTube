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

	private MelonChartService melonChartService;
	
	public void setMelonChartService(MelonChartService melonChartService) {
		this.melonChartService = melonChartService;
	}
	
	
	
	@RequestMapping("/getFromMelon")
	public String getPharsing(MelonChartVO melonChartVO) {
		   
		System.out.println("들어옴");
		String target = "http://www.melon.com/chart/";
	         // 상승 http://finance.daum.net/quote/rise.daum?nil_profile=stockprice&nil_menu=siseleftmenu11&nil_stock=refresh
	         // 기본 국내 3/12 
	         //http://finance.daum.net/quote/index.daum?nil_profile=stockgnb&nil_menu=sise_top&nil_stock=refresh
	         
	    
	         String title = null;
	         String singer = null;
	         Document doc = null;
	         
	         
	      try {
	    	  System.out.println("TRY시도");
	         doc = Jsoup.connect(target).get();
	         	System.out.println("doc 내용" + doc);
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      
	      
	      
	      
	      System.out.println("들어옴2");
	      	//노래제목
	         Elements txt = doc.select("td.ellipsis.rank01 > span > a");
	         
	         System.out.println("엘리먼트에 무슨 내용있는지 볼까?" + txt  );
	         
	         
	         for(Element node:txt) {
	        	 System.out.println("들어옴3");
	            title = (node.text());
	            
	            melonChartVO.setmTitle(title);
	            
	            melonChartService.createCommunityMelon(melonChartVO);
	         }
	         
	         
	         
	         //가수
	         Elements qq = doc.select("td.checkEllipsis");
	         System.out.println("가수 긁어옴");
	         for(Element node:qq) {
	            singer = (node.text());
	            
	            	System.out.println("가수 돌리기 시작");
	            melonChartVO.setmSinger(singer);
	            
	            
	            melonChartService.createCommunityMelon(melonChartVO);
	         }
	         
	         return "redirect:/";
	         
	         
	}
	
	
	
	
	
}
