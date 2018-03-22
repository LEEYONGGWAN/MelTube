package com.meltube.community.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.meltube.community.vo.CommunityVO;

public class CommunityDaoImplForOracle extends SqlSessionDaoSupport implements CommunityDao{

	@Override
	public List<CommunityVO> selectAll() {
		return null;
	}

	@Override
	public CommunityVO selectSing(int id) {
		return null;
	}

	@Override
	public CommunityVO selectGenre(int id) {
		return null;
	}

	@Override
	public int insertCommunity(CommunityVO communityVO) {
		return getSqlSession().insert("CommunityDao.insertCommunity", communityVO);
	}


	@Override
	public int incrementRCount(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int incrementViewCount(int id) {
		// TODO Auto-generated method stub
		return 0;
	}



}
