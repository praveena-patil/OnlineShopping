package com.pp.dao;

import java.util.List;

import com.pp.model.Category;

public interface CategoryDAO {
	public List<Category> getAllCategory();
	public Category getCategory(int id);
	void addCategory(Category category);
	void removeCategory(int id);
	void modifyCategory(Category category);
}
