package com.meltube.community.service;

import java.util.List;

import com.meltube.community.vo.CommunityVO;


public interface CommunityService {
	public List<CommunityVO> getAll();
	
	public CommunityVO getOne(int id);
	
	public boolean createCommunity(CommunityVO communityVO);
	
	public boolean increaseR(int id);
	
	public boolean increaseV(int id);
}
