package com.meltube.member.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.meltube.member.vo.MemberVO;

public class MemberDaoImplForOracle extends SqlSessionDaoSupport implements MemberDao{

	@Override
	public int selectCountMemberEmail(String email) {
		return getSqlSession().selectOne("MemberDao.selectCountMemberEmail", email);
	}

	@Override
	public int selectCountMemberNickname(String nickname) {
		return getSqlSession().selectOne("MemberDao.selectCountMemberNickname", nickname);
	}

	@Override
	public int insertMember(MemberVO memberVO) {
		return getSqlSession().insert("MemberDao.insertMember", memberVO);
	}

	@Override
	public String selectSalt(String email) {
		return null;
	}

	@Override
	public MemberVO selectMember(MemberVO memberVO) {
		return null;
	}

	@Override
	public int deleteMember(int id) {
		return 0;
	}

}
