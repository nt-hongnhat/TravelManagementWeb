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

	@Override
	public Category getCategoryByID(int id) {
		return this.categoryRepository.findById(id);
	}

	@Override
	public boolean addCategory(Category category) {
		return this.categoryRepository.addCategory(category);
	}

	@Override
	public boolean updateCategory(Category category) {
		return this.categoryRepository.updateCategory(category);
	}

	@Override
	public boolean deleteCategory(Category category) {
		return this.categoryRepository.deleteCategory(category);
	}
}
