package com.meltube.melonChart.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.meltube.melonChart.vo.MelonChartVO;

public class MelonChartDaoImplForOracle extends SqlSessionDaoSupport implements MelonChartDao{

	@Override
	public List<MelonChartVO> selectMchart() {
		return getSqlSession().selectList("MelonChartDao.selectMchart");
	}

	@Override
	public int insertCommunityMelon(MelonChartVO melonChartVO) {
		return getSqlSession().insert("MelonChartDao.insertCommunityMelon", melonChartVO);
	}

	@Override
	public int deleteCommunityMelon() {
		return getSqlSession().delete("MelonChartDao.deleteCommunityMelon");
	}

	
	
}
