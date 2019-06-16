package com.aplus.DOS.member.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SettingNewPasswordDto {
	private String email;
	private String answer;

	public Member toEntity() {
		return Member.builder()
				.email(email)
				.answer(answer)
				.build();
	}
	
}
