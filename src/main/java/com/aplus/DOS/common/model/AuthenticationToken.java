package com.aplus.DOS.common.model;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthenticationToken {
	private Long memberId;
	private String email;
	private String nickname;
	private Collection authorities;
	private String token;
	private Long money;
	private Long level;
	private Long exp;
	private int chooseNote;
	private int chooseEffect;
}
