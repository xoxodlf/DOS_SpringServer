package com.aplus.DOS;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aplus.DOS.item.domain.Item;
import com.aplus.DOS.member.domain.Member;
import com.aplus.DOS.memberHasItem.domain.MemberHasItem;
import com.aplus.DOS.memberHasItem.domain.MemberHasItemRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DosMemberHasItemTests {
	
	@Autowired
	MemberHasItemRepository memberHasItemRespository;
	
	@After
	public void cleanup() {
		memberHasItemRespository.deleteAll();
	}
	
	@Test
	public void contextLoads() {
//		memberHasItemRespository.save(MemberHasItem.builder()
//				.member(Member.builder().memberId(3200L).build())
//				.item(Item.builder().itemId(1100L).build()).build());
//		
//		List<MemberHasItem> list = memberHasItemRespository.findAll();
//		
//		MemberHasItem me = list.get(0);
//		assertThat(me.getItem().getPrice(), is(1000L));
	}

}
