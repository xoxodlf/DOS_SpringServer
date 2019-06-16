package com.aplus.DOS.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MemberItemSelectDto {
	private String memberId;
	private String chooseNote;
	private String chooseEffect;
}
