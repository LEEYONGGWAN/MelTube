package com.meltube.melonChart.service;

import com.meltube.melonChart.dao.MelonChartDao;
import com.meltube.melonChart.vo.MelonChartVO;

public class MelonChartServiceImpl implements MelonChartService{

	private MelonChartDao melonChartDao;
	
	public void setMelonChartDao(MelonChartDao melonChartDao) {
		this.melonChartDao = melonChartDao;
	}

	@Override
	public boolean createCommunityMelon(MelonChartVO melonChartVO) {
		return melonChartDao.insertCommunityMelon(melonChartVO) >0;
	}
	
}
