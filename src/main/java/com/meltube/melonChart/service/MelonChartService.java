package com.meltube.melonChart.service;

import com.meltube.melonChart.vo.MelonChartVO;

public interface MelonChartService {
	//멜론에서 차트 가져와서 디비로 넣기
			public boolean createCommunityMelon(MelonChartVO melonChartVO);
}
