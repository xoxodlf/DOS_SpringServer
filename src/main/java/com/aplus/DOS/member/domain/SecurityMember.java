package com.aplus.DOS.member.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class SecurityMember extends User{
	private static final String ROLE_PREFIX = "ROLE_";
	private static final long serialVersionUID = 1L;
	
	public SecurityMember(Member member) {
		super(member.getEmail(), member.getPassword(),makeGrantedAuthority());
	}
	
	private static List<GrantedAuthority> makeGrantedAuthority(){
		List<GrantedAuthority> list = new ArrayList<>();
		list.add(new SimpleGrantedAuthority(ROLE_PREFIX + "Basic"));
		return list;
	}
}
