package com.aplus.DOS.item.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aplus.DOS.common.model.ApiResponseMessage;
import com.aplus.DOS.item.domain.BuyItemDto;
import com.aplus.DOS.item.domain.Item;
import com.aplus.DOS.member.domain.Member;
import com.aplus.DOS.member.domain.MemberRepository;
import com.aplus.DOS.memberHasItem.domain.MemberHasItem;
import com.aplus.DOS.memberHasItem.domain.MemberHasItemJoinDto;
import com.aplus.DOS.memberHasItem.domain.MemberHasItemRepository;
import com.aplus.DOS.memberHasItem.domain.MemberIdDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ItemRestController {
	private MemberHasItemRepository memberHasItemRepository;
	private MemberRepository memberRespository;
	
	@PostMapping("/buyItem")
	public ResponseEntity<ApiResponseMessage> buyItem(@RequestBody BuyItemDto dto){
		try {
			Member member = memberRespository.getOne(Long.parseLong(dto.getMemberId())); 
			MemberHasItem memberHasItem = MemberHasItem.builder()
					 .member(Member.builder()
							 .memberId(Long.parseLong(dto.getMemberId()))
							 .build())
					 .item(Item.builder()
							 .itemId(Long.parseLong(dto.getItemId()))
							 .build())
					 .build();
			 memberHasItemRepository.save(memberHasItem);
			 System.out.println(member.getMoney()+"-"+Long.parseLong(dto.getMoney())+"="+(member.getMoney()-Long.parseLong(dto.getMoney())));
			 member.setMoney(member.getMoney()-Long.parseLong(dto.getMoney()));
			 memberRespository.save(member);
		}catch (Exception e) {
			ApiResponseMessage message = new ApiResponseMessage("Fail", "Error", "", "");
			return new ResponseEntity<ApiResponseMessage>(message,HttpStatus.OK);
		}
		ApiResponseMessage message = new ApiResponseMessage("Success", "Buy Success", "", "");
		return new ResponseEntity<ApiResponseMessage>(message,HttpStatus.OK);
	}
	
	@PostMapping("/loadItems")
	public List<Item> loadItems(@RequestBody MemberIdDto dto) {
		List<Item> items = new ArrayList<Item>();
		List<MemberHasItem> memberHasItems = memberHasItemRepository.findAllByMemberId(Long.parseLong(dto.getMemberId()));
		for(MemberHasItem mbhi : memberHasItems) {
			items.add(mbhi.getItem());
		}
		return items;
	}
}
