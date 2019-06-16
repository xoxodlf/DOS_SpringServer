package com.aplus.DOS.item.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BuyItemDto {
	private String memberId;
	private String itemId;
	private String money;
}
