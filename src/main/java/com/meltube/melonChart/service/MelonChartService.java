package com.meltube.melonChart.service;

import java.util.List;

import com.meltube.melonChart.vo.MelonChartVO;

public interface MelonChartService {

	//멜론에서 가져온거 jsp에 올리는 부분
	public List<MelonChartVO> getMchart();
	
	// 멜론에서 차트 가져와서 디비로 넣기
	public boolean createCommunityMelon(MelonChartVO melonChartVO);

	//새로 갱신하기위해서 db로 넣기 전에 지운다.
	public boolean removeCommunityMelon();

}
