package com.aplus.DOS.memberHasItem.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MemberHasItemJoinDto {
	private Long memberId;
	private LocalDateTime modifiedDate;
	private LocalDateTime createdDate;
	private Long itemId;
	private String name;
	private String Image;
	private Long categoryId;
}
