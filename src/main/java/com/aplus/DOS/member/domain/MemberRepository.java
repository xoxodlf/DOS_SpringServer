package com.aplus.DOS.member.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>{
	public List<Member> findByEmail(String email);
	public List<Member> findByEmailAndAnswer(String email, String answer);
}
