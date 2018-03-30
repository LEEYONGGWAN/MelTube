/*package com.meltube.community.dao;

import java.util.ArrayList;
import java.util.List;

import com.meltube.community.vo.CommunityVO;

public class CommunityDaoImpl implements CommunityDao {

	private List<CommunityVO> singList;
	
	public CommunityDaoImpl() {
		singList = new ArrayList<CommunityVO>();
	}
	
	@Override
	public List<CommunityVO> selectAll() {
		return singList;
	}

	@Override
	public int insertCommunity(CommunityVO communityVO) {
		communityVO.setId(singList.size() + 1);
		singList.add(communityVO);
		return 1;
	}

	@Override
	public int incrementRCount(int id) {
		for(CommunityVO community : singList) {
			if(community.getId() == id) {
				community.setLikeIt(community.getLikeIt() + 1);
				return 1;
			}
		}
		
		return 0;
	}
	
	@Override
	public int incrementViewCount(int id) {
		for(CommunityVO community : singList) {
			if(community.getId() == id) {
				community.setLikeIt( community.getLikeIt() + 1 );
				return 1;
			}
		}
		return 0;
	}
	
	

	@Override
	public CommunityVO selectSing(int id) {
		for(CommunityVO community : singList) {
			if(community.getId() == id) {

				return community;
			}
		}
		return null;
	}

	@Override
	public CommunityVO selectGenre(int id) {
		return null;
	}

}
*/