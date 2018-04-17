package com.meltube.melonChart.dao;

import java.util.List;

import com.meltube.melonChart.vo.MelonChartVO;


public interface MelonChartDao {

	//멜론에서 가져온거 jsp에 올리는 부분
	public List<MelonChartVO> selectMchart();
	
	//멜론에서 가져온거 db로 넣기
	public int insertCommunityMelon( MelonChartVO melonChartVO );
	
	//새로 갱신하기위해서 db로 넣기 전에 지운다.
	public int deleteCommunityMelon();
	
	
	
	
}
