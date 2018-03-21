package com.meltube.community.service;

import java.util.List;

import com.meltube.community.dao.CommunityDao;
import com.meltube.community.vo.CommunityVO;

public class CommunityServiceImpl implements CommunityService {

	private CommunityDao communityDao;

	public void setCommunityDao(CommunityDao communityDao) {
		this.communityDao = communityDao;
	}
	
	@Override
	public List<CommunityVO> getAll() {
		return communityDao.selectAll();
	}

	@Override
	public CommunityVO getOne(int id) {
		return communityDao.selectSing(id);
	}

	
	
	@Override
	public boolean createCommunity(CommunityVO communityVO) {

		int insertCount = communityDao.insertCommunity(communityVO);

		return insertCount > 0;
	}

	@Override
	public boolean increaseR(int id) {
		if(communityDao.incrementRCount(id) > 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean increaseV(int id) {
		
		if(communityDao.incrementViewCount(id) > 0) {
			return true;
		}
		return false;
		
	}

}
