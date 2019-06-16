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

import com.aplus.DOS.category.domain.Category;
import com.aplus.DOS.category.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DosCategoryTests {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@After
	public void cleanup() {
		//categoryRepository.deleteAll();
	}
	
	@Test
	public void contextLoads() {
		categoryRepository.save(Category.builder().name("Thema").build());
		
		List<Category> list = categoryRepository.findAll();
		
		Category ca = list.get(0);
		assertThat(ca.getName(), is("Thema"));
	}

}
