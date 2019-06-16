package com.aplus.DOS.category.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Category {
	@Id
    @Column(name = "Category_ID", unique = true, nullable = false)
    @SequenceGenerator(schema = "hr", name = "Category_Sequence" , sequenceName = "Category_Sequence")
    @GeneratedValue(generator = "Category_Sequence", strategy = GenerationType.SEQUENCE)
    private Long categoryId;
	
	@Column(name = "Name", nullable = false)
	private String name;
	
	@Builder
	public Category(Long categoryId, String name) {
		this.categoryId = categoryId;
		this.name = name;
	}
}
