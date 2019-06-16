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

import com.aplus.DOS.levels.domain.Levels;
import com.aplus.DOS.levels.domain.LevelsRepository;
import com.aplus.DOS.member.domain.Member;
import com.aplus.DOS.member.domain.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DosMemberTests {
	
	@Autowired
	MemberRepository memberRespository;
	
	@After
	public void cleanup() {
		memberRespository.deleteAll();
	}
	
	@Test
	public void contextLoads() {
		memberRespository.save(Member.builder()
				.nickname("xoxodlf")
				.email("xoxodlf@naver.com")
				.exp(0L)
				.password("xoxodlf")
				.answer("1")
				.money(1000L)
				.level(new Levels(1L,0L)).build());
		
		List<Member> list = memberRespository.findAll();
		
		Member me = list.get(0);
		assertThat(me.getExp(), is(0L));
	}

}
