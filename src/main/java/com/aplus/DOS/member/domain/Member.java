package com.aplus.DOS.member.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.aplus.DOS.common.model.BaseTimeEntity;
import com.aplus.DOS.levels.domain.Levels;
import com.aplus.DOS.memberHasItem.domain.MemberHasItem;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class Member extends BaseTimeEntity{
	
	@Id
    @Column(name = "Member_ID", unique = true, nullable = false)
    @SequenceGenerator(schema = "hr", name = "Member_Sequence" , sequenceName = "Member_Sequence")
    @GeneratedValue(generator = "Member_Sequence", strategy = GenerationType.SEQUENCE)
    private Long memberId;
	
	@Column(name = "Email", nullable = false)
	private String email;
	@Column(name = "Nickname", nullable = false)
	private String nickname;
	@Column(name = "Password", nullable = false)
	private String password;
	@Column(name = "Exp", nullable = false)
	private Long exp;
	@Column(name = "Answer", nullable = false)
	private String answer;
	@Column(name = "Money", nullable = false)
	private Long money;
	@Column(name = "choose_note", nullable = false)
	private int  chooseNote;
	@Column(name = "choose_effect", nullable = false)
	private int  chooseEffect;
	@ManyToOne
	@JoinColumn(name = "Levels_ID")
	private Levels level;
	
	@Builder
	public Member(Long memberId, String email, String nickname, String password, Long exp, String answer, Long money,
			int chooseNote, int chooseEffect, Levels level) {
		this.memberId = memberId;
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.exp = exp;
		this.answer = answer;
		this.money = money;
		this.chooseNote = chooseNote;
		this.chooseEffect = chooseEffect;
		this.level = level;
	}
}
