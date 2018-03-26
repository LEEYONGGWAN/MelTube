package com.meltube.member.service;

import com.meltube.community.dao.CommunityDao;
import com.meltube.member.dao.MemberDao;
import com.meltube.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService{

	private MemberDao memberDao;
	private CommunityDao communityDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void setCommunityDao(CommunityDao communityDao) {
		this.communityDao = communityDao;
	}

	@Override
	public boolean readCountMemberEmail(String email) {
		return memberDao.selectCountMemberEmail(email) > 0;
	}

	@Override
	public boolean readCountMemberNickname(String nickname) {
		return memberDao.selectCountMemberNickname(nickname) > 0;
	}

	@Override
	public boolean createMember(MemberVO memberVO) {
		
		System.out.println("createMember 들어옴");
		return memberDao.insertMember(memberVO) > 0;
	}

	@Override
	public MemberVO readMember(MemberVO member) {
		return memberDao.selectMember(member);
	}

	@Override
	public boolean removeMember(int id, String deleteFlag) {
		return false;
	}

}
