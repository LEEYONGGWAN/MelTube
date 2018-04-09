package com.meltube.community.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.meltube.community.vo.CommunityVO;

public class CommunityDaoImplForOracle extends SqlSessionDaoSupport implements CommunityDao{

	@Override
	public List<CommunityVO> selectAll() {
		return getSqlSession().selectList("CommunityDao.selectAll");
	}

	@Override
	public CommunityVO selectSing(int id) {
		return getSqlSession().selectOne("CommunityDao.selectSing", id);
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
		return getSqlSession().update("CommunityDao.incrementRCount", id);
	}


	@Override
	public List<CommunityVO> sortAll() {
		return getSqlSession().selectList("CommunityDao.sortAll");
	}
	
	//회원탈퇴 할때 본인이 썼던 글 지우는 부분
	@Override
	public int deleteCommunities(List<Integer> ids, int userId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ids", ids);
		params.put("userId", userId);
		return getSqlSession().delete("CommunityDao.deleteCommunities", params);
	}

	@Override
	public int deleteMyCommunities(int userId) {
		return 0;
	}

	@Override
	public int selectMyCommunitiesCount(int userId) {
		return getSqlSession().selectOne("CommunityDao.selectMyCommunitiesCount", userId);
	}

	
	@Override
	public int incrementViewCount(int id) {
		// TODO Auto-generated method stub
		return 0;
	}




	
	
	
	
	

}
