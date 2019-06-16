package com.aplus.DOS.item.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.aplus.DOS.category.domain.Category;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Item {
	@Id
    @Column(name = "Item_ID", unique = true, nullable = false)
    @SequenceGenerator(schema = "hr", name = "Item_Sequence" , sequenceName = "Item_Sequence")
    @GeneratedValue(generator = "Item_Sequence", strategy = GenerationType.SEQUENCE)
    private Long itemId;
	
	@Column(name = "Name", nullable = false)
	private String name;
	@Column(name = "Image", nullable = false)
	private String image;
	@Column(name = "Price", nullable = false)
	private Long price;
	
	@ManyToOne
	@JoinColumn(name = "Category_ID")
	private Category category;
	
	@Builder
	public Item(Long itemId, String name, String image, Long price, Category category) {
		this.itemId = itemId;
		this.name = name;
		this.image = image;
		this.price = price;
		this.category = category;
	}
	
	
}
