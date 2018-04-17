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

	// 오른쪽 좋아요순으로 데려오기
	@Override
	public List<CommunityVO> getLikeList() {
		return communityDao.sortAll();
	}

	//장르별 가져오기	
	@Override
	public List<CommunityVO> getGenre(String genre) {
		return communityDao.selectGenre(genre);
	}

	//검색해서 가져오기
	@Override
	public List<CommunityVO> getSearchKeyword(String keyword) {
		return communityDao.searchEvery(keyword);
	}
	
	@Override
	public CommunityVO getOne(int id) {
		return communityDao.selectSing(id);
	}

	@Override
	public boolean createCommunity(CommunityVO communityVO) {
		return communityDao.insertCommunity(communityVO) > 0;
	}

	@Override
	public boolean increaseR(int id) {
		if (communityDao.incrementRCount(id) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean increaseV(int id) {

		if (communityDao.incrementViewCount(id) > 0) {
			return true;
		}
		return false;

	}

	@Override
	public int readMyCommunitiesCount(int userId) {
		return communityDao.selectMyCommunitiesCount(userId);
	}





}
