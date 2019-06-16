package com.aplus.DOS.levels.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LevelsSaveRequestDto {
	private Long levelsId;
	private Long Exp;
	
	public Levels toEntity() {
		return Levels.builder()
				.levelsId(levelsId)
				.Exp(Exp)
				.build();
	}
}
