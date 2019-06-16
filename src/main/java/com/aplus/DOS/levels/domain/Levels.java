package com.aplus.DOS.levels.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Levels {
	
	@Id
    @Column(name = "Levels_ID", unique = true, nullable = false)
    @SequenceGenerator(schema = "hr", name = "Levels_Sequence" , sequenceName = "Levels_Sequence")
    @GeneratedValue(generator = "Levels_Sequence", strategy = GenerationType.SEQUENCE)
    private Long levelsId;
	
	@Column(name = "Exp", nullable = false)
	private Long Exp;
	
	@Builder
	public Levels(Long levelsId, Long Exp) {
		this.levelsId = levelsId;
		this.Exp = Exp;
	}
	
}
