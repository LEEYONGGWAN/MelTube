package com.meltube.melonChart.service;

import java.util.List;

import com.meltube.melonChart.dao.MelonChartDao;
import com.meltube.melonChart.vo.MelonChartVO;

public class MelonChartServiceImpl implements MelonChartService {

	private MelonChartDao melonChartDao;

	public void setMelonChartDao(MelonChartDao melonChartDao) {
		this.melonChartDao = melonChartDao;
	}

	@Override
	public List<MelonChartVO> getMchart() {
		return melonChartDao.selectMchart();
	}

	@Override
	public boolean createCommunityMelon(MelonChartVO melonChartVO) {
		return melonChartDao.insertCommunityMelon(melonChartVO) > 0;
	}

	@Override
	public boolean removeCommunityMelon() {
		return melonChartDao.deleteCommunityMelon() > 0 ;
	}
	
	

}
