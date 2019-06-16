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

@RunWith(SpringRunner.class)
@SpringBootTest
public class DosMusicTests {
	
	@Autowired
	LevelsRepository levelsRespository;
	
	@After
	public void cleanup() {
		//levelsRespository.deleteAll();
	}
	
	@Test
	public void contextLoads() {
		for(int i=1;i<301;i++) {
			levelsRespository.save(Levels.builder().levelsId((long)i).Exp((long)0).build());
		}
		
//		List<Levels> list = levelsRespository.findAll();
//		
//		Levels le = list.get(0);
//		assertThat(le.getExp(), is(0L));
	}

}
