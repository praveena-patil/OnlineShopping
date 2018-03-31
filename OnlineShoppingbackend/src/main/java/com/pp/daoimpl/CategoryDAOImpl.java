package com.pp.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.pp.dao.CategoryDAO;
import com.pp.model.Category;

@Repository(value="categoryDAO")
@EnableTransactionManagement
public class CategoryDAOImpl implements CategoryDAO {
	// private static List<Category> categories = new ArrayList();

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategory() {
		return sessionFactory.getCurrentSession().createQuery("from Category")
				.list();
	}

	@Transactional
	@Override
	public Category getCategory(int id) {
		Category category = (Category) sessionFactory.getCurrentSession().get(
				Category.class, id);
		return category;
	}

	@Transactional
	@Override
	public boolean addCategory(Category category) {
		sessionFactory.getCurrentSession().save(category);
		return true;
	}

	@Transactional
	@Override
	public void removeCategory(int id) {
		Category category = getCategory(id);
		if (category != null)
			sessionFactory.getCurrentSession().delete(category);
	}

	@Transactional
	@Override
	public boolean modifyCategory(Category category) {
		Category categoryToUpdate = getCategory(1);
		categoryToUpdate.setCategory_name(category.getCategory_name());
		sessionFactory.getCurrentSession().update(categoryToUpdate);
		return true;
	}
}
