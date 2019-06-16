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
import com.aplus.DOS.memberMusicRanking.domain.MemberMusicRanking;
import com.aplus.DOS.memberMusicRanking.domain.MemberMusicRankingRepository;
import com.aplus.DOS.music.domain.Music;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DosMemberMusicRankingTests {
	
	@Autowired
	MemberMusicRankingRepository memberMusicRankingRespository;
	
	@After
	public void cleanup() {
		memberMusicRankingRespository.deleteAll();
	}
	
	@Test
	public void contextLoads() {
//		memberMusicRankingRespository.save(MemberMusicRanking.builder()
//				.score(100L)
//				.member(new Member(1L, "1", "1", "1", 0L, "1", 1000L,new Levels(1L, 0L)))
//				.music(new Music(1L, "song1")).build());
//		
//		List<MemberMusicRanking> list = memberMusicRankingRespository.findAll();
//		
//		MemberMusicRanking me = list.get(0);
//		assertThat(me.getScore(), is(100L));
	}

}
