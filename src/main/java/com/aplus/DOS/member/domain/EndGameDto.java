package com.aplus.DOS.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EndGameDto {
	private String memberId;
	private String money;
	private String exp;
	private String level;
}
