package com.aplus.DOS.memberHasItem.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.aplus.DOS.common.model.BaseTimeEntity;
import com.aplus.DOS.item.domain.Item;
import com.aplus.DOS.levels.domain.Levels;
import com.aplus.DOS.member.domain.Member;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class MemberHasItem extends BaseTimeEntity{
	
	@Id
    @Column(name = "Member_has_Item_ID", unique = true, nullable = false)
    @SequenceGenerator(schema = "hr", name = "Member_has_Item_Sequence" , sequenceName = "Member_has_Item_Sequence")
    @GeneratedValue(generator = "Member_has_Item_Sequence", strategy = GenerationType.SEQUENCE)
    private Long memberHasItemId;
	@ManyToOne
	@JoinColumn(name = "Member_ID")
	private Member member;
	
	@Column(name = "Member_ID", insertable = false, updatable = false)
	private Long memberId;
	@ManyToOne
	@JoinColumn(name = "Item_ID")
	private Item item;
	
	@Builder
	public MemberHasItem(Long memberHasItemId, Member member, Item item) {
		this.memberHasItemId = memberHasItemId;
		this.member = member;
		this.item = item;
	}
	
}
