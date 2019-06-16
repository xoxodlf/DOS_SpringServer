package com.aplus.DOS.music.domain;

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
public class Music {
	
	@Id
    @Column(name = "Music_ID", unique = true, nullable = false)
    @SequenceGenerator(schema = "hr", name = "Music_Sequence" , sequenceName = "Music_Sequence")
    @GeneratedValue(generator = "Music_Sequence", strategy = GenerationType.SEQUENCE)
    private Long musicId;
	
	@Column(name = "Title", nullable = false)
	private String title;
	
	@Builder
	public Music(Long musicId, String title) {
		this.musicId = musicId;
		this.title = title;
	}
	
}
