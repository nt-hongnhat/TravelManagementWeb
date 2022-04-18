package com.lth.service.impl;

import com.lth.pojos.Category;
import com.lth.repository.CategoryRepository;
import com.lth.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public List<Category> getCategories() {
		return this.categoryRepository.getCategories();
	}
}
