package com.meltube.community.dao;

import java.util.List;

import com.meltube.community.vo.CommunityVO;

public interface CommunityDao {

	public List<CommunityVO> selectAll();
	
	
	//오른쪽 좋아요 순 노래
	public List<CommunityVO> sortAll();
	
	public CommunityVO selectSing(int id);

	public CommunityVO selectGenre(int id);	
	
	public int insertCommunity(CommunityVO communityVO);
	
	public int incrementRCount(int id);
	
	public int incrementViewCount(int id);

}
