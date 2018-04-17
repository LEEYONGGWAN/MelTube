package com.meltube.community.dao;

import java.util.List;

import com.meltube.community.vo.CommunityVO;

public interface CommunityDao {

	public List<CommunityVO> selectAll();
	
	
	//오른쪽 좋아요 순 노래
	public List<CommunityVO> sortAll();
	
	public CommunityVO selectSing(int id);

	//노래 서치 하기
	public List<CommunityVO> searchEvery(String keyword);
	
	//장르별로 선택하기
	public List<CommunityVO> selectGenre(String genre);	
	
	public int insertCommunity(CommunityVO communityVO);
	
	public int incrementRCount(int id);
	
	public int incrementViewCount(int id);

	//회원탈퇴 할때 본인이 썼던 글 지우는 부분
	public int deleteCommunities(List<Integer> ids, int userId);
	
	public int selectMyCommunitiesCount(int userId);
	
	public int deleteMyCommunities(int userId);
	
	
	
	

	
	
}
