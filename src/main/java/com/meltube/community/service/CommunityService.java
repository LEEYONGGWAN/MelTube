package com.meltube.community.service;

import java.util.List;

import com.meltube.community.vo.CommunityVO;


public interface CommunityService {
	public List<CommunityVO> getAll();
	
	//오른쪽 좋아요 순으로 데려오기
	public List<CommunityVO> getLikeList();
	
	public CommunityVO getOne(int id);
	
	//장르별 가져오기
	public List<CommunityVO> getGenre(String genre);
	
	
	public boolean createCommunity(CommunityVO communityVO);
	
	public boolean increaseR(int id);
	
	public boolean increaseV(int id);
	
	public int readMyCommunitiesCount(int userId);
	
}
