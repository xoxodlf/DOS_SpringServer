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
import com.aplus.DOS.item.domain.Item;
import com.aplus.DOS.item.domain.ItemRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DosItemTests {
	
	@Autowired
	ItemRepository itemRespository;
	
	@After
	public void cleanup() {
		itemRespository.deleteAll();
	}
	
	@Test
	public void contextLoads() {
		itemRespository.save(Item.builder()
				.price(1000L)
				.name("양태일짱짱스킨")
				.image("xoxodlf")
				.category(new Category(50L,"스킨")).build());
		
		List<Item> list = itemRespository.findAll();
		
		Item item = list.get(0);
		assertThat(item.getName(), is("양태일짱짱스킨"));
	}

}
