package com.meltube.melonChart.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.meltube.melonChart.vo.MelonChartVO;

public class MelonChartDaoImplForOracle extends SqlSessionDaoSupport implements MelonChartDao{

	@Override
	public List<MelonChartVO> selectMchart() {
		return null;
	}

	@Override
	public int insertCommunityMelon(MelonChartVO melonChartVO) {
		return getSqlSession().insert("MelonChartDao.insertCommunityMelon", melonChartVO);
	}

}
