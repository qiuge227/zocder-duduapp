package com.truck.logic;

import java.util.List;

import com.truck.domain.Member;
import com.truck.util.AboutPage;

 




public interface MemberDao {
	
	public boolean addMember(Member member);
	public Member getMemberById(int id);
	public List<Member> showMembers(int offset,
			AboutPage aboutPage, List<Member> members,int pageSize);
	public boolean updateMember(Member member);
	public boolean deleteMember(int id);
	public boolean checkUsername(String loginUsername);
	public boolean login(String name,String password);
}
