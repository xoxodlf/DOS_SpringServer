package com.aplus.DOS.memberMusicRanking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.aplus.DOS.levels.domain.Levels;
import com.aplus.DOS.member.domain.Member;
import com.aplus.DOS.music.domain.Music;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class MemberMusicRanking {
	
	@Id
    @Column(name = "Member_Music_Ranking_ID", unique = true, nullable = false)
    @SequenceGenerator(schema = "hr", name = "Member_Music_Ranking_Sequence" , sequenceName = "Member_Music_Ranking_Sequence")
    @GeneratedValue(generator = "Member_Music_Ranking_Sequence", strategy = GenerationType.SEQUENCE)
    private Long memberMusicRankingId;
	
	@Column(name = "Score", nullable = false)
	private Long score;
	
	@ManyToOne
	@JoinColumn(name = "Member_ID")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name = "Music_ID")
	private Music music;
	
	@Builder
	public MemberMusicRanking(Long memberMusicRankingId, Long score, Member member, Music music) {
		this.memberMusicRankingId = memberMusicRankingId;
		this.score = score;
		this.member = member;
		this.music = music;
	}
	
	
}
