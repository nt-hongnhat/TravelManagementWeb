package com.lth.service;

import com.lth.pojos.Category;

import java.util.List;

public interface CategoryService {
	List<Category> getCategories();
	Category getCategoryByID(int id);
}
