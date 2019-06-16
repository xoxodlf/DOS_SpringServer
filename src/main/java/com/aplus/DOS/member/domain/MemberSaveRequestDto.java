	package com.aplus.DOS.member.domain;

import com.aplus.DOS.levels.domain.Levels;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberSaveRequestDto {
	
	private String email;
	private String nickname;
	private String password;
	private String answer;
	
	public Member toEntity() {
		return Member.builder()
				.email(email)
				.nickname(nickname)
				.password(password)
				.exp(0L)
				.level(Levels.builder().levelsId(1L).build())
				.answer(answer)
				.money(0L)
				.chooseEffect(0)
				.chooseNote(0)
				.build();
	}
	
}
