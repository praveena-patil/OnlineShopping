package com.pp.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pp.dao.CategoryDAO;
import com.pp.model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	// private static List<Category> categories = new ArrayList();

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() 
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Category> getAllCategory() {
		return getCurrentSession().createQuery("from Category").list();
	}

	@Override
	public Category getCategory(int id) {
		Category category = (Category) getCurrentSession().get(Category.class,id);
		return category;
	}

	@Override
	public void addCategory(Category category) 
	{
		getCurrentSession().save(category);
	}

	@Override
	public void removeCategory(int id) 
	{
		Category category = getCategory(id);
		if (category != null)
			getCurrentSession().delete(category);
	}

	@Override
	public void modifyCategory(Category category) 
	{
		Category categoryToUpdate = getCategory(category.getCategory_id());
		categoryToUpdate.setCategory_name(category.getCategory_name());
		getCurrentSession().update(categoryToUpdate);
	}
}
