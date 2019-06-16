package com.aplus.DOS.common.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aplus.DOS.member.domain.MemberRepository;
import com.aplus.DOS.member.domain.SecurityMember;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println(email);
		return new SecurityMember(memberRepository.findByEmail(email).get(0));
	}

}
