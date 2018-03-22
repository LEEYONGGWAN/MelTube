package com.meltube.member.service;

import com.meltube.member.vo.MemberVO;

public interface MemberService {
	public boolean readCountMemberEmail(String email);
	
	public boolean readCountMemberNickname(String nickname);
	
	public boolean createMember(MemberVO member);
	
	public MemberVO readMember(MemberVO member);
	
	public boolean removeMember(int id, String deleteFlag);
}
