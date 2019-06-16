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

import com.aplus.DOS.music.domain.Music;
import com.aplus.DOS.music.domain.MusicRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DosLevelsTests {
	
	@Autowired
	MusicRepository musicRespository;
	
	@After
	public void cleanup() {
		musicRespository.deleteAll();
	}
	
	@Test
	public void contextLoads() {
		musicRespository.save(Music.builder().title("Music").build());
		
		List<Music> list = musicRespository.findAll();
		
		Music mu = list.get(0);
		assertThat(mu.getTitle(), is("Music"));
	}

}
